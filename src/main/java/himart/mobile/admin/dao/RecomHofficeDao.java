package himart.mobile.admin.dao;


import himart.mobile.admin.vo.RecomHofficeVO;
import himart.mobile.admin.vo.SalePriceBoardVO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 본사추천
 * @author SeoJohoon
 */

@Repository
public class RecomHofficeDao extends SqlSessionDaoSupport {
	/**
	 * 본사추천 최종등록일자 조회
	 * @param vo
	 * @return
	 */
	public String getLastRegDate() {
		return getSqlSession().selectOne("recom.selectLastRegDate");
	}

	/**
	 * 본사추천 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getRecomHofficeTotCount(RecomHofficeVO vo) {
		return getSqlSession().selectOne("recom.selectRecomHofficeTotCount", vo);
	}

	/**
	 * 본사추천 목록 조회
	 * @param vo
	 * @return
	 */
	public List<RecomHofficeVO> getRecomHofficeTotList(RecomHofficeVO vo) {
		return getSqlSession().selectList("recom.selectRecomHofficeList", vo);
	}

	/**
	 * 본사추천 목록 삭제
	 * @param vo
	 * @return
	 */
	public int deleteRecomHoffice(RecomHofficeVO vo) {
		return getSqlSession().delete("recom.deleteRecomHoffice", vo);
	}

	/**
	 * 본사추천 배경이미지 목록 조회
	 * @param vo
	 * @return
	 */
	public List<RecomHofficeVO> getRecomHofficeBGList() {
		RecomHofficeVO vo;

		List<RecomHofficeVO> listBG = new ArrayList<RecomHofficeVO>();
		
		vo = new RecomHofficeVO();

		vo.setImgOrigFileNm("배경이미지1");
		vo.setImgSaveFileNm("bg_image_001.png");
		vo.setImgSavePath("/bg/");

		listBG.add(vo);

		vo = new RecomHofficeVO();

		vo.setImgOrigFileNm("배경이미지2");
		vo.setImgSaveFileNm("bg_image_002.png");
		vo.setImgSavePath("/bg/");

		listBG.add(vo);

		vo = new RecomHofficeVO();

		vo.setImgOrigFileNm("배경이미지3");
		vo.setImgSaveFileNm("bg_image_003.png");
		vo.setImgSavePath("/bg/");

		listBG.add(vo);

		vo = new RecomHofficeVO();

		vo.setImgOrigFileNm("배경이미지4");
		vo.setImgSaveFileNm("bg_image_004.png");
		vo.setImgSavePath("/bg/");

		listBG.add(vo);

		vo = new RecomHofficeVO();

		vo.setImgOrigFileNm("배경이미지5");
		vo.setImgSaveFileNm("bg_image_005.png");
		vo.setImgSavePath("/bg/");

		listBG.add(vo);

		return listBG;
	}

	/**
	 * 본사추천 목록 수정 (배경이미지)
	 * @param vo
	 * @return
	 */
	public int updateRecomHoffice(RecomHofficeVO vo) {
		return getSqlSession().update("recom.updateRecomHoffice", vo);
	}

	/**
	 * 통신사별 판매가격표 최종차수
	 * @param vo
	 * @return
	 */
	public int getLastMobDgr(SalePriceBoardVO vo) {
		return getSqlSession().selectOne("recom.selectLastMobDgr", vo);
	}

	/**
	 * 통신사별 판매가격표 목록 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getSalePriceBoardTotCount(SalePriceBoardVO vo) {
		return getSqlSession().selectOne("recom.selectSalePriceBoardTotCount", vo);
	}

	/**
	 * 통신사별 판매가격표 목록
	 * @param vo
	 * @return
	 */
	public List<SalePriceBoardVO> getSalePriceBoardList(SalePriceBoardVO vo) {
		return getSqlSession().selectList("recom.selectSalePriceBoardList", vo);
	}

	/**
	 * 본사추천 등록
	 * @param vo
	 * @return
	 */
	public int updateRecomHofficeSalePrc(RecomHofficeVO vo) {
		return getSqlSession().update("recom.updateRecomHofficeSalePrc", vo);
	}
}
