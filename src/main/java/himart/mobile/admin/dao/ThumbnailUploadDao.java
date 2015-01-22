package himart.mobile.admin.dao;


//import himart.mobile.admin.vo.ThumbnailUploadVO;
import himart.mobile.admin.vo.ImageUploadVO;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description thumbnail 이미지
 * @author cKim
 */

@Repository
public class ThumbnailUploadDao extends SqlSessionDaoSupport {
	/**
	 * thumbnail 이미지 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getImageUploadTotCount(ImageUploadVO vo) {
		return getSqlSession().selectOne("thumbnail.selectImageUploadTotCount", vo);
	}

	/**
	 * thumbnail 이미지 목록 조회
	 * @param vo
	 * @return
	 */
	public List<ImageUploadVO> getImageUploadTotList(ImageUploadVO vo) {
		System.out.println ( "vo=== "+ vo);
		return getSqlSession().selectList("thumbnail.selectImageUploadList", vo);
	}

	/**
	 * thumbnail 이미지 등록/수정
	 * @param vo
	 * @return
	 */
	public int updateImageUpload(ImageUploadVO vo) {
		return getSqlSession().update("thumbnail.updateImageUpload", vo);
	}

	/**
	 * thumbnail 이미지 삭제
	 * @param vo
	 * @return
	 */
	public int deleteImageUpload(ImageUploadVO vo) {
		return getSqlSession().delete("thumbnail.deleteImageUpload", vo);
	}
	
	/**
	 * thumbnail 배경이미지 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getBackImgTotCount(ImageUploadVO vo) {
		return getSqlSession().selectOne("thumbnail.selectBackImgTotCount", vo);
	}

}
