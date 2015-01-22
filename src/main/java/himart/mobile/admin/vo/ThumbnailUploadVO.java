package himart.mobile.admin.vo;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description   Thumbnail 이미지 정보가 보관될 객체
 * @author cKim
 */
public class ThumbnailUploadVO {
	// 구분코드
	private String imgCfCd;

	// 구분명
	private String imgCfCdNm;

	// 품목코드
	private String prdItemNm;

	// 품목명
	private String prdItemNmNm;

	// 닉네임코드
	private String prdNicNm;

	// 닉네임명
	private String prdNicNmNm;

	// 액세서리상품ID
	private String accPrdId;

	// 액세서리상품코드
	private String accPrdCd;

	// 액세서리상품명
	private String accPrdCdNm;

	// 이미지구분코드
	private String imgPstCfCd;

	// 이미지구분명
	private String imgPstCfCdNm;

	// 등록일자
	private String updDt;

	// 이미지원파일명
	private String imgOrigFileNm;

	// 이미지파일명
	private String imgSaveFileNm;

	// 이미지파일경로
	private String imgSavePath;

	//페이지번호
	private int pageNo;

	//페이지당조회수
	private int pageSize;

	//사원번호
	private String empNo;

	/**
	 * @return the imgCfCd
	 */
	public String getImgCfCd() {
		return imgCfCd;
	}

	/**
	 * @param imgCfCd the imgCfCd to set
	 */
	public void setImgCfCd(String imgCfCd) {
		this.imgCfCd = imgCfCd;
	}

	/**
	 * @return the imgCfCdNm
	 */
	public String getImgCfCdNm() {
		return imgCfCdNm;
	}

	/**
	 * @param imgCfCdNm the imgCfCdNm to set
	 */
	public void setImgCfCdNm(String imgCfCdNm) {
		this.imgCfCdNm = imgCfCdNm;
	}

	/**
	 * @return the prdItemNm
	 */
	public String getPrdItemNm() {
		return prdItemNm;
	}

	/**
	 * @param prdItemNm the prdItemNm to set
	 */
	public void setPrdItemNm(String prdItemNm) {
		this.prdItemNm = prdItemNm;
	}

	/**
	 * @return the prdItemNmNm
	 */
	public String getPrdItemNmNm() {
		return prdItemNmNm;
	}

	/**
	 * @param prdItemNmNm the prdItemNmNm to set
	 */
	public void setPrdItemNmNm(String prdItemNmNm) {
		this.prdItemNmNm = prdItemNmNm;
	}

	/**
	 * @return the prdNicNm
	 */
	public String getPrdNicNm() {
		return prdNicNm;
	}

	/**
	 * @param prdNicNm the prdNicNm to set
	 */
	public void setPrdNicNm(String prdNicNm) {
		this.prdNicNm = prdNicNm;
	}

	/**
	 * @return the prdNicNmNm
	 */
	public String getPrdNicNmNm() {
		return prdNicNmNm;
	}

	/**
	 * @param prdNicNmNm the prdNicNmNm to set
	 */
	public void setPrdNicNmNm(String prdNicNmNm) {
		this.prdNicNmNm = prdNicNmNm;
	}

	/**
	 * @return the accPrdId
	 */
	public String getAccPrdId() {
		return accPrdId;
	}

	/**
	 * @param accPrdId the accPrdId to set
	 */
	public void setAccPrdId(String accPrdId) {
		this.accPrdId = accPrdId;
	}

	/**
	 * @return the accPrdCd
	 */
	public String getAccPrdCd() {
		return accPrdCd;
	}

	/**
	 * @param accPrdCd the accPrdCd to set
	 */
	public void setAccPrdCd(String accPrdCd) {
		this.accPrdCd = accPrdCd;
	}

	/**
	 * @return the accPrdCdNm
	 */
	public String getAccPrdCdNm() {
		return accPrdCdNm;
	}

	/**
	 * @param accPrdCdNm the accPrdCdNm to set
	 */
	public void setAccPrdCdNm(String accPrdCdNm) {
		this.accPrdCdNm = accPrdCdNm;
	}

	/**
	 * @return the imgPstCfCd
	 */
	public String getImgPstCfCd() {
		return imgPstCfCd;
	}

	/**
	 * @param imgPstCfCd the imgPstCfCd to set
	 */
	public void setImgPstCfCd(String imgPstCfCd) {
		this.imgPstCfCd = imgPstCfCd;
	}

	/**
	 * @return the imgPstCfCdNm
	 */
	public String getImgPstCfCdNm() {
		return imgPstCfCdNm;
	}

	/**
	 * @param imgPstCfCdNm the imgPstCfCdNm to set
	 */
	public void setImgPstCfCdNm(String imgPstCfCdNm) {
		this.imgPstCfCdNm = imgPstCfCdNm;
	}

	/**
	 * @return the updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt the updDt to set
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * @return the imgOrigFileNm
	 */
	public String getImgOrigFileNm() {
		return imgOrigFileNm;
	}

	/**
	 * @param imgOrigFileNm the imgOrigFileNm to set
	 */
	public void setImgOrigFileNm(String imgOrigFileNm) {
		this.imgOrigFileNm = imgOrigFileNm;
	}

	/**
	 * @return the imgSaveFileNm
	 */
	public String getImgSaveFileNm() {
		return imgSaveFileNm;
	}

	/**
	 * @param imgSaveFileNm the imgSaveFileNm to set
	 */
	public void setImgSaveFileNm(String imgSaveFileNm) {
		this.imgSaveFileNm = imgSaveFileNm;
	}

	/**
	 * @return the imgSavePath
	 */
	public String getImgSavePath() {
		return imgSavePath;
	}

	/**
	 * @param imgSavePath the imgSavePath to set
	 */
	public void setImgSavePath(String imgSavePath) {
		this.imgSavePath = imgSavePath;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
}
