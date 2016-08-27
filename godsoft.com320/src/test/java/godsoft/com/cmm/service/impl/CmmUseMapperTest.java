package godsoft.com.cmm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:egovframework/spring/com/context-*.xml",
		"classpath:egovframework/spring/com/idgn/context-*.xml",
		"classpath:godsoft/spring/com/context-*.xml" })
public class CmmUseMapperTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CmmUseMapper cmmUseMapper;

	@Test
	public void test() throws Exception {
		selectCmmCodeDetail();
		// selectCmmCodeDetail2();
		// selectCmmCodeDetail3();
		// selectCmmCodeDetail4();

	}

	public void selectCmmCodeDetail() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> items = cmmUseMapper.selectCmmCodeDetail(vo);

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("items=" + items);

			for (CmmnDetailCode item : items) {
				egovLogger.debug("getCodeNm=" + item.getCodeNm());
			}
		}
	}

	public void selectCmmCodeDetail2() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> items = cmmUseMapper.selectCmmCodeDetail2(vo);

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("items=" + items);

			for (CmmnDetailCode item : items) {
				egovLogger.debug("getCodeNm=" + item.getCodeNm());
			}
		}
	}

	public void selectCmmCodeDetail3() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<EgovMap> items = cmmUseMapper.selectCmmCodeDetail3(vo);

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("items=" + items);

			for (EgovMap item : items) {
				egovLogger.debug("getCodeNm=" + item.get("codeNm"));
			}
		}
	}

	public void selectCmmCodeDetail4() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<EgovMap> items = cmmUseMapper.selectCmmCodeDetail4(vo);

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("items=" + items);

			for (EgovMap item : items) {
				egovLogger.debug("getCodeNm=" + item.get("codeNm"));
			}
		}
	}

}