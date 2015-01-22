package himart.mobile.admin.vo;


import java.util.List;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 본사추천 정보가 보관될 객체
 * @author SeoJohoon
 */
public class RecomHofficeVO {
	// 순번
	private String seq;

	// 순번 (삭제를 위함)
	private List<String> seqList;

	// 등록일
	private String regDt;

	// 타사상품코드 (상품ID)
	private String mkrPrdCd;

	// 타사상품코드
	private String mkrPrdCdNm;

	// 통신사코드
	private String mbComCd;

	// 통신사명
	private String mbComCdNm;

	// 가입유형코드
	private String mobJnCfCd;

	// 가입유형명
	private String mobJnCfCdNm;

	// 요금제코드
	private String stpnCd;

	// 요금제명
	private String stpnCdNm;

	// 판매가
	private int salePrc;

	// 원본이미지명
	private String imgOrigFileNm;

	// 저장이미지명
	private String imgSaveFileNm;

	// 저장이미지경로
	private String imgSavePath;

	// 썸네일이미지
	private String imgSaveThumb;

	// 페이지번호
	private int pageNo;

	// 페이지당 조회수
	private int pageSize;

	// 사원번호
	private String empNo;

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the seqList
	 */
	public List<String> getSeqList() {
		return seqList;
	}

	/**
	 * @param seqList the seqList to set
	 */
	public void setSeqList(List<String> seqList) {
		this.seqList = seqList;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the mkrPrdCd
	 */
	public String getMkrPrdCd() {
		return mkrPrdCd;
	}

	/**
	 * @param mkrPrdCd the mkrPrdCd to set
	 */
	public void setMkrPrdCd(String mkrPrdCd) {
		this.mkrPrdCd = mkrPrdCd;
	}

	/**
	 * @return the mkrPrdCdNm
	 */
	public String getMkrPrdCdNm() {
		return mkrPrdCdNm;
	}

	/**
	 * @param mkrPrdCdNm the mkrPrdCdNm to set
	 */
	public void setMkrPrdCdNm(String mkrPrdCdNm) {
		this.mkrPrdCdNm = mkrPrdCdNm;
	}

	/**
	 * @return the mbComCd
	 */
	public String getMbComCd() {
		return mbComCd;
	}

	/**
	 * @param mbComCd the mbComCd to set
	 */
	public void setMbComCd(String mbComCd) {
		this.mbComCd = mbComCd;
	}

	/**
	 * @return the mbComCdNm
	 */
	public String getMbComCdNm() {
		return mbComCdNm;
	}

	/**
	 * @param mbComCdNm the mbComCdNm to set
	 */
	public void setMbComCdNm(String mbComCdNm) {
		this.mbComCdNm = mbComCdNm;
	}

	/**
	 * @return the mobJnCfCd
	 */
	public String getMobJnCfCd() {
		return mobJnCfCd;
	}

	/**
	 * @param mobJnCfCd the mobJnCfCd to set
	 */
	public void setMobJnCfCd(String mobJnCfCd) {
		this.mobJnCfCd = mobJnCfCd;
	}

	/**
	 * @return the mobJnCfCdNm
	 */
	public String getMobJnCfCdNm() {
		return mobJnCfCdNm;
	}

	/**
	 * @param mobJnCfCdNm the mobJnCfCdNm to set
	 */
	public void setMobJnCfCdNm(String mobJnCfCdNm) {
		this.mobJnCfCdNm = mobJnCfCdNm;
	}

	/**
	 * @return the stpnCd
	 */
	public String getStpnCd() {
		return stpnCd;
	}

	/**
	 * @param stpnCd the stpnCd to set
	 */
	public void setStpnCd(String stpnCd) {
		this.stpnCd = stpnCd;
	}

	/**
	 * @return the stpnCdNm
	 */
	public String getStpnCdNm() {
		return stpnCdNm;
	}

	/**
	 * @param stpnCdNm the stpnCdNm to set
	 */
	public void setStpnCdNm(String stpnCdNm) {
		this.stpnCdNm = stpnCdNm;
	}

	/**
	 * @return the salePrc
	 */
	public int getSalePrc() {
		return salePrc;
	}

	/**
	 * @param salePrc the salePrc to set
	 */
	public void setSalePrc(int salePrc) {
		this.salePrc = salePrc;
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
	 * @return the imgSaveThumb
	 */
	public String getImgSaveThumb() {
		return imgSaveThumb;
	}

	/**
	 * @param imgSaveThumb the imgSaveThumb to set
	 */
	public void setImgSaveThumb(String imgSaveThumb) {
		this.imgSaveThumb = imgSaveThumb;
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
