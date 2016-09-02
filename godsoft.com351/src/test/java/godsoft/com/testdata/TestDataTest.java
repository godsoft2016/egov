package godsoft.com.testdata;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.string.EgovDateUtil;

public class TestDataTest {

	@Test
	public void test() throws Exception {
		comTnEmplyrInfo();
	}

	/**
	 * 업무사용자정보
	 * 
	 * @throws Exception
	 */
	public void comTnEmplyrInfo() throws Exception {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		sb.append("set define off;\n\n");
		sb2.append("set define off;\n\n");

		for (int i = 100; i < 200; i++) {
			String iString = String.format("%03d", i);

			String emplyrId = "test" + iString;

			String userNm = "사용자명" + iString;

			String password = EgovFileScrty.encryptPassword("rhdxhd12",
					emplyrId);

			String groupId = "GROUP_TEST_000000001";

			String esntlId = "USRCNFRM_TEST_000" + iString;

			sb.append("insert into COMTNEMPLYRINFO /* 업무사용자정보 */ (\n");
			sb.append("    EMPLYR_ID /* EMPLYR_ID, 업무사용자정보.업무사용자ID */\n");
			sb.append("--    , ORGNZT_ID /* ORGNZT_ID, 업무사용자정보.조직ID */\n");
			sb.append("    , USER_NM /* USER_NM, 업무사용자정보.사용자명 */\n");
			sb.append("    , PASSWORD /* PASSWORD, 업무사용자정보.비밀번호 */\n");
			sb.append("--    , EMPL_NO /* EMPL_NO, 업무사용자정보.사원번호 */\n");
			sb.append("--    , IHIDNUM /* IHIDNUM, 업무사용자정보.주민등록번호 */\n");
			sb.append("--    , SEXDSTN_CODE /* SEXDSTN_CODE, 업무사용자정보.성별코드 */\n");
			sb.append("--    , BRTHDY /* BRTHDY, 업무사용자정보.생일 */\n");
			sb.append("--    , FXNUM /* FXNUM, 업무사용자정보.팩스번호 */\n");
			sb.append("    , HOUSE_ADRES /* HOUSE_ADRES, 업무사용자정보.주택주소 */\n");
			sb.append("    , PASSWORD_HINT /* PASSWORD_HINT, 업무사용자정보.비밀번호힌트 */\n");
			sb.append("    , PASSWORD_CNSR /* PASSWORD_CNSR, 업무사용자정보.비밀번호정답 */\n");
			sb.append("    , HOUSE_END_TELNO /* HOUSE_END_TELNO, 업무사용자정보.주택끝전화번호 */\n");
			sb.append("    , AREA_NO /* AREA_NO, 업무사용자정보.지역번호 */\n");
			sb.append("--    , DETAIL_ADRES /* DETAIL_ADRES, 업무사용자정보.상세주소 */\n");
			sb.append("    , ZIP /* ZIP, 업무사용자정보.우편번호 */\n");
			sb.append("--    , OFFM_TELNO /* OFFM_TELNO, 업무사용자정보.사무실전화번호 */\n");
			sb.append("--    , MBTLNUM /* MBTLNUM, 업무사용자정보.이동전화번호 */\n");
			sb.append("--    , EMAIL_ADRES /* EMAIL_ADRES, 업무사용자정보.이메일주소 */\n");
			sb.append("--    , OFCPS_NM /* OFCPS_NM, 업무사용자정보.직위명 */\n");
			sb.append("    , HOUSE_MIDDLE_TELNO /* HOUSE_MIDDLE_TELNO, 업무사용자정보.주택중간전화번호 */\n");
			sb.append("    , GROUP_ID /* GROUP_ID, 업무사용자정보.그룹ID */\n");
			sb.append("--    , PSTINST_CODE /* PSTINST_CODE, 업무사용자정보.소속기관코드 */\n");
			sb.append("    , EMPLYR_STTUS_CODE /* EMPLYR_STTUS_CODE, 업무사용자정보.사용자상태코드 */\n");
			sb.append("    , ESNTL_ID /* ESNTL_ID, 업무사용자정보.고유ID */\n");
			sb.append("--    , CRTFC_DN_VALUE /* CRTFC_DN_VALUE, 업무사용자정보.인증DN값 */\n");
			sb.append("--    , SBSCRB_DE /* SBSCRB_DE, 업무사용자정보.가입일자 */\n");
			sb.append(") values (\n");
			sb.append("     '" + emplyrId
					+ "' /* EMPLYR_ID, 업무사용자정보.업무사용자ID */\n");
			sb.append("--    ,  '조직ID' /* ORGNZT_ID, 업무사용자정보.조직ID */\n");
			sb.append("    ,  '" + userNm + "' /* USER_NM, 업무사용자정보.사용자명 */\n");
			sb.append("    ,  '" + password
					+ "' /* PASSWORD, 업무사용자정보.비밀번호 */\n");
			sb.append("--    ,  '사원번호' /* EMPL_NO, 업무사용자정보.사원번호 */\n");
			sb.append("--    ,  '주민등록번호' /* IHIDNUM, 업무사용자정보.주민등록번호 */\n");
			sb.append("--    ,  '성별코드' /* SEXDSTN_CODE, 업무사용자정보.성별코드 */\n");
			sb.append("--    ,  '생일' /* BRTHDY, 업무사용자정보.생일 */\n");
			sb.append("--    ,  '팩스번호' /* FXNUM, 업무사용자정보.팩스번호 */\n");
			sb.append("    ,  '주택주소' /* HOUSE_ADRES, 업무사용자정보.주택주소 */\n");
			sb.append("    ,  '비밀번호힌트' /* PASSWORD_HINT, 업무사용자정보.비밀번호힌트 */\n");
			sb.append("    ,  'rhdxhd12, 공통12' /* PASSWORD_CNSR, 업무사용자정보.비밀번호정답 */\n");
			sb.append("    ,  '1234' /* HOUSE_END_TELNO, 업무사용자정보.주택끝전화번호 */\n");
			sb.append("    ,  '1234' /* AREA_NO, 업무사용자정보.지역번호 */\n");
			sb.append("--    ,  '상세주소' /* DETAIL_ADRES, 업무사용자정보.상세주소 */\n");
			sb.append("    ,  '123456' /* ZIP, 업무사용자정보.우편번호 */\n");
			sb.append("--    ,  '사무실전화번호' /* OFFM_TELNO, 업무사용자정보.사무실전화번호 */\n");
			sb.append("--    ,  '이동전화번호' /* MBTLNUM, 업무사용자정보.이동전화번호 */\n");
			sb.append("--    ,  '이메일주소' /* EMAIL_ADRES, 업무사용자정보.이메일주소 */\n");
			sb.append("--    ,  '직위명' /* OFCPS_NM, 업무사용자정보.직위명 */\n");
			sb.append("    ,  '1234' /* HOUSE_MIDDLE_TELNO, 업무사용자정보.주택중간전화번호 */\n");
			sb.append("    ,  '" + groupId + "' /* GROUP_ID, 업무사용자정보.그룹ID */\n");
			sb.append("--    ,  '소속기관코드' /* PSTINST_CODE, 업무사용자정보.소속기관코드 */\n");
			sb.append("    ,  'P' /* EMPLYR_STTUS_CODE, 업무사용자정보.사용자상태코드 */\n");
			sb.append("    ,  '" + esntlId + "' /* ESNTL_ID, 업무사용자정보.고유ID */\n");
			sb.append("--    ,  '인증DN값' /* CRTFC_DN_VALUE, 업무사용자정보.인증DN값 */\n");
			sb.append("--    ,  '가입일자' /* SBSCRB_DE, 업무사용자정보.가입일자 */\n");
			sb.append(")\n");
			sb.append(";\n");

			sb2.append("insert into COMTNEMPLYRSCRTYESTBS /* 사용자보안설정 */ (\n");
			sb2.append("    SCRTY_DTRMN_TRGET_ID /* SCRTY_DTRMN_TRGET_ID, 사용자보안설정.보안설정대상ID */\n");
			sb2.append("    , MBER_TY_CODE /* MBER_TY_CODE, 사용자보안설정.회원유형코드 */\n");
			sb2.append("    , AUTHOR_CODE /* AUTHOR_CODE, 사용자보안설정.권한코드 */\n");
			sb2.append(") values (\n");
			sb2.append("    '" + esntlId
					+ "' /* SCRTY_DTRMN_TRGET_ID, 사용자보안설정.보안설정대상ID */\n");
			sb2.append("    ,  'USR03' /* MBER_TY_CODE, 사용자보안설정.회원유형코드 */\n");
			sb2.append("    ,  'ROLE_USER' /* AUTHOR_CODE, 사용자보안설정.권한코드 */\n");
			sb2.append(")\n");
			sb2.append(";\n");
		}

		sb.append("\ncommit;\n");
		sb2.append("\ncommit;\n");

		// file
		File file = new File(
				SystemUtils.USER_HOME
						+ "/Desktop/COMTNEMPLYRINFO 업무사용자정보 "
						+ EgovDateUtil.toString(new Date(),
								"yyyy-MM-dd HH-mm-ss", null) + ".sql");
		String data = sb.toString();

		System.out.println(data);
		System.out.println(file);

		FileUtils.writeStringToFile(file, data);

		// file2
		File file2 = new File(
				SystemUtils.USER_HOME
						+ "/Desktop/COMTNEMPLYRSCRTYESTBS 사용자보안설정 "
						+ EgovDateUtil.toString(new Date(),
								"yyyy-MM-dd HH-mm-ss", null) + ".sql");
		String data2 = sb2.toString();

		System.out.println(data2);
		System.out.println(file2);

		FileUtils.writeStringToFile(file2, data2);
	}

}
