package himart.mobile.admin.dao;


import himart.mobile.admin.vo.ImageUploadVO;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 이미지
 * @author SeoJohoon
 */

@Repository
public class ImageUploadDao extends SqlSessionDaoSupport {
	/**
	 * 이미지 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getImageUploadTotCount(ImageUploadVO vo) {
		return getSqlSession().selectOne("image.selectImageUploadTotCount", vo);
	}

	/**
	 * 이미지 목록 조회
	 * @param vo
	 * @return
	 */
	public List<ImageUploadVO> getImageUploadTotList(ImageUploadVO vo) {
		return getSqlSession().selectList("image.selectImageUploadList", vo);
	}

	/**
	 * 이미지 등록/수정
	 * @param vo
	 * @return
	 */
	public int updateImageUpload(ImageUploadVO vo) {
		return getSqlSession().update("image.updateImageUpload", vo);
	}

	/**
	 * 이미지 삭제
	 * @param vo
	 * @return
	 */
	public int deleteImageUpload(ImageUploadVO vo) {
		return getSqlSession().delete("image.deleteImageUpload", vo);
	}
}
