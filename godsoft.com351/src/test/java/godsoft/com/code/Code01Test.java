package godsoft.com.code;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.rte.fdl.excel.EgovExcelService;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:egovframework/spring/com/**/context-*.xml",
		"classpath:godsoft/spring/com/**/context-*.xml" })
public class Code01Test {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EgovExcelService egovExcelService;

	@Test
	public void test() throws Exception {
		test2();
	}

	public void test2() throws Exception {
		if (egovLogger.isDebugEnabled()) {
			egovLogger.debug("test2");

			String filepath = "C:/Users/LeeBaekHaeng/git/egov/godsoft.com351/src/test/resources/godsoft/com/GOD_D08_코드정의서_V1.0_20160830.xlsx";
			XSSFWorkbook type = null;

			XSSFWorkbook loadWorkbook = egovExcelService.loadWorkbook(filepath,
					type);

			Sheet sheet3 = loadWorkbook.getSheet("3.코드정의서");
			Sheet sheet4 = loadWorkbook.getSheet("4.코드값현황표");

			// sheet3(sheet3);
			sheet4(sheet4);
		}
	}

	public void sheet3(Sheet sheet) throws Exception {
		StringBuffer sb = new StringBuffer();

		for (Row row : sheet) {
			int rowNum = row.getRowNum();

			String a = EgovExcelUtil.getValue(row.getCell(0)); // 코드명
			String b = EgovExcelUtil.getValue(row.getCell(1)); // 코드값

			// egovLogger.debug("row=" + row);
			// egovLogger.debug("row=" + row.getCell(0));
			egovLogger.debug("A=" + a);
			egovLogger.debug("B=" + b);

			if (rowNum <= 2) {
				continue;
			} else if (StringUtils.isEmpty(a)) {
				continue;
			}

			sb.append("INSERT INTO COMTCCMMNCODE (");
			sb.append("CL_CODE");
			sb.append(", CODE_ID");
			sb.append(", CODE_ID_NM");
			sb.append(", CODE_ID_DC");
			sb.append(", USE_AT");
			sb.append(", FRST_REGIST_PNTTM");
			sb.append(", FRST_REGISTER_ID");
			sb.append(",LAST_UPDT_PNTTM");
			sb.append(", LAST_UPDUSR_ID");
			sb.append(") VALUES (");
			sb.append("'EFC'");
			sb.append(", '" + b + "'");
			sb.append(", '" + a + "'");
			sb.append(", null");
			sb.append(", 'Y'");
			sb.append(", SYSDATE");
			sb.append(", 'SYSTEM2'");
			sb.append(", null");
			sb.append(", null");
			sb.append(");");
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public void sheet4(Sheet sheet) throws Exception {
		StringBuffer sb = new StringBuffer();

		for (Row row : sheet) {
			int rowNum = row.getRowNum();

			String a = EgovExcelUtil.getValue(row.getCell(0)); // 코드 명
			String b = EgovExcelUtil.getValue(row.getCell(1)); // 코드 값
			String c = EgovExcelUtil.getValue(row.getCell(2)); // 코드 값 의미
			String d = EgovExcelUtil.getValue(row.getCell(3)); // 상위 코드 값

			// egovLogger.debug("row=" + row);
			// egovLogger.debug("row=" + row.getCell(0));
			egovLogger.debug("A=" + a);
			egovLogger.debug("B=" + b);
			egovLogger.debug("C=" + c);
			egovLogger.debug("D=" + d);

			if (rowNum <= 2) {
				continue;
			} else if (StringUtils.isEmpty(a)) {
				continue;
			}

			sb.append("INSERT INTO COMTCCMMNDETAILCODE (");
			sb.append("CODE_ID");
			sb.append(", CODE");
			sb.append(", CODE_NM");
			sb.append(", CODE_DC");
			sb.append(", USE_AT");
			sb.append(", FRST_REGIST_PNTTM");
			sb.append(", FRST_REGISTER_ID");
			sb.append(", LAST_UPDT_PNTTM");
			sb.append(", LAST_UPDUSR_ID");
			sb.append(") VALUES (");
			sb.append("'" + d + "'");
			sb.append(", '" + b + "'");
			sb.append(", '" + c + "'");
			sb.append(", null");
			sb.append(", 'Y'");
			sb.append(", SYSDATE");
			sb.append(", 'SYSTEM'");
			sb.append(", null");
			sb.append(", null");
			sb.append(");");
			sb.append("\n");
		}

		System.out.println(sb);
	}
}