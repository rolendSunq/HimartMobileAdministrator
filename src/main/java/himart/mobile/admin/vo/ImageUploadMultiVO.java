package himart.mobile.admin.vo;


import org.springframework.web.multipart.MultipartFile;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 이미지 등록정보가 보관될 객체
 * @author SeoJohoon
 */
public class ImageUploadMultiVO {
	
	// 업로드 구분
	private String[] imgUploadType;
	
	// 구분코드
	private String[] imgCfCd;

	// 닉네임/품목코드
	private String[] prdNicNm;

	// 액세서리상품ID
	private String[] accPrdId;

	// 액세서리상품코드
	private String[] accPrdCd;

	// 이미지구분코드
	private String[] imgPstCfCd;

	// 이미지원파일
	private MultipartFile[] imgOrigFile;

	
	public String[] getImgUploadType() {
		return imgUploadType;
	}

	public void setImgUploadType(String[] imgUploadType) {
		this.imgUploadType = imgUploadType;
	}
	
	/**
	 * @return the imgCfCd
	 */
	public String[] getImgCfCd() {
		return imgCfCd;
	}

	/**
	 * @param imgCfCd the imgCfCd to set
	 */
	public void setImgCfCd(String[] imgCfCd) {
		this.imgCfCd = imgCfCd;
	}

	/**
	 * @return the prdNicNm
	 */
	public String[] getPrdNicNm() {
		return prdNicNm;
	}

	/**
	 * @param prdNicNm the prdNicNm to set
	 */
	public void setPrdNicNm(String[] prdNicNm) {
		this.prdNicNm = prdNicNm;
	}

	/**
	 * @return the accPrdId
	 */
	public String[] getAccPrdId() {
		return accPrdId;
	}

	/**
	 * @param accPrdId the accPrdId to set
	 */
	public void setAccPrdId(String[] accPrdId) {
		this.accPrdId = accPrdId;
	}

	/**
	 * @return the accPrdCd
	 */
	public String[] getAccPrdCd() {
		return accPrdCd;
	}

	/**
	 * @param accPrdCd the accPrdCd to set
	 */
	public void setAccPrdCd(String[] accPrdCd) {
		this.accPrdCd = accPrdCd;
	}

	/**
	 * @return the imgPstCfCd
	 */
	public String[] getImgPstCfCd() {
		return imgPstCfCd;
	}

	/**
	 * @param imgPstCfCd the imgPstCfCd to set
	 */
	public void setImgPstCfCd(String[] imgPstCfCd) {
		this.imgPstCfCd = imgPstCfCd;
	}

	/**
	 * @return the imgOrigFile
	 */
	public MultipartFile[] getImgOrigFile() {
		return imgOrigFile;
	}

	/**
	 * @param imgOrigFile the imgOrigFile to set
	 */
	public void setImgOrigFile(MultipartFile[] imgOrigFile) {
		this.imgOrigFile = imgOrigFile;
	}
}
