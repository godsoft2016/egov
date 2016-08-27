package egovframework.com.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:egovframework/spring/com/context-*.xml",
		"classpath:egovframework/spring/com/idgn/context-*.xml" })
// @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class CmmUseDAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Resource(name = "cmmUseDAO")
	private CmmUseDAO cmmUseDAO;

	@Test
	public void test() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> items = cmmUseDAO.selectCmmCodeDetail(vo);

		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("items=" + items);

			for (CmmnDetailCode item : items) {
				egovLogger.debug("getCodeNm=" + item.getCodeNm());
			}
		}
	}

}