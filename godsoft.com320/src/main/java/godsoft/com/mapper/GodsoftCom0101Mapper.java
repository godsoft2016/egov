package godsoft.com.mapper;

import java.util.List;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface GodsoftCom0101Mapper {

	List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo)
			throws Exception;

	List<CmmnDetailCode> selectCmmCodeDetail2(ComDefaultCodeVO vo)
			throws Exception;

	List<EgovMap> selectCmmCodeDetail3(ComDefaultCodeVO vo) throws Exception;

	List<EgovMap> selectCmmCodeDetail4(ComDefaultCodeVO vo) throws Exception;

}