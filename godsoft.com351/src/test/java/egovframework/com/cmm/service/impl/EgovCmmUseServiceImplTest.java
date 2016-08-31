package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:egovframework/spring/com/**/context-*.xml" })
public class EgovCmmUseServiceImplTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EgovCmmUseService egovCmmUseService;

	@Test
	public void test() throws Exception {
		selectCmmCodeDetails();
	}

	public void selectCmmCodeDetails() throws Exception {
		List<ComDefaultCodeVO> voList = new ArrayList<ComDefaultCodeVO>();

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");
		voList.add(vo);

		vo = new ComDefaultCodeVO();
		vo.setCodeId("COM002");
		voList.add(vo);

		Map<String, List<CmmnDetailCode>> selectCmmCodeDetails = egovCmmUseService
				.selectCmmCodeDetails(voList);

		List<CmmnDetailCode> COM001 = selectCmmCodeDetails.get("COM001");
		List<CmmnDetailCode> COM002 = selectCmmCodeDetails.get("COM002");

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("selectCmmCodeDetails=" + selectCmmCodeDetails);
			egovLogger.debug("COM001=" + COM001);
			egovLogger.debug("COM002=" + COM002);
		}

		debug(COM001);
		debug(COM002);
	}

	public void debug(List<CmmnDetailCode> items) throws Exception {
		for (CmmnDetailCode item : items) {
			if (egovLogger.isDebugEnabled()) {
				egovLogger.debug("item=" + item);
				egovLogger.debug("getCodeId" + item.getCodeId());
				egovLogger.debug("getCode=" + item.getCode());
				egovLogger.debug("getCodeNm=" + item.getCodeNm());
			}
		}
	}

}