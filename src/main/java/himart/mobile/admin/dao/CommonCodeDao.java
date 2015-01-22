package himart.mobile.admin.dao;


import himart.mobile.admin.vo.CommonCodeVO;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 공통정보
 * @author SeoJohoon
 */

@Repository
public class CommonCodeDao extends SqlSessionDaoSupport {
	/**
	 * 품목 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getItemTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectItemTotCount", vo);
	}

	/**
	 * 품목 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getItemList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectItemList", vo);
	}

	/**
	 * 닉네임 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getNicTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectNicTotCount", vo);
	}

	/**
	 * 닉네임 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getNicList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectNicList", vo);
	}

	/**
	 * 대표코드 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getMstTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectMstTotCount", vo);
	}

	/**
	 * 대표코드 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getMstList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectMstList", vo);
	}

	/**
	 * 액세서리 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getAccTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectAccTotCount", vo);
	}

	/**
	 * 액세서리 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getAccList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectAccList", vo);
	}

	/**
	 * 카드할인 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getCardTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectCardTotCount", vo);
	}

	/**
	 * 카드할인 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getCardList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectCardList", vo);
	}

	/**
	 * 이미지구분 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getImgGbTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectImgGbTotCount", vo);
	}

	/**
	 * 이미지구분 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getImgGbList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectImgGbList", vo);
	}

	/**
	 * 통신사 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getMbcomTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectMbcomTotCount", vo);
	}

	/**
	 * 통신사 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getMbcomList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectMbcomList", vo);
	}

	/**
	 * 제조사 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getMkrTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectMkrTotCount", vo);
	}

	/**
	 * 제조사 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getMkrList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectMkrList", vo);
	}

	/**
	 * 모델코드 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getPrdCdTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectPrdCdTotCount", vo);
	}

	/**
	 * 모델코드 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getPrdCdList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectPrdCdList", vo);
	}

	/**
	 * 지점 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getBrchTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectBrchTotCount", vo);
	}

	/**
	 * 지점 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getBrchList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectBrchList", vo);
	}

	/**
	 * 사원 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getEmpTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectEmpTotCount", vo);
	}

	/**
	 * 사원 조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getEmpList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectEmpList", vo);
	}
	
	/**
	 * 코드, 코드명 총건수 조회
	 * @param vo
	 * @return
	 */
	public int getCodeTotCount(CommonCodeVO vo) {
		return getSqlSession().selectOne("common.selectCodeTotCount", vo);
	}
	
	/**
	 *코드, 코드명  조회
	 * @param vo
	 * @return
	 */
	public List<CommonCodeVO> getCodeList(CommonCodeVO vo) {
		return getSqlSession().selectList("common.selectCodeList", vo);
	}
	
}
