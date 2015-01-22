package himart.mobile.admin.vo;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 본사추천을 등록하기 위한 판매가격표
 * @author SeoJohoon
 */
public class SalePriceBoardVO {
	// 기준일자 (등록일자)
	private String regDt;
	// 통신사코드
	private String mbcomCd;
	// 통신사
	private String mbcomCdNm;
	// 최종차수
	private int mobDgr;
	// 닉네임코드
	private String nicCd;
	// 닉네임
	private String nicCdNm;
	// 모델명(타사상품코드)
	private String mkrPrdCd;
	// 출고가
	private int shoPrc;
	// 요금제코드
	private String clpnCd;
	// 요금제
	private String clpnCdNm;
	// 판매가
	private int salePrc;
	// 010신규 판매가
	private int salePrc11;
	// 보상기변 판매가
	private int salePrc16;
	// 일반기변 판매가
	private int salePrc17;
	// 우수기변1 판매가
	private int salePrc19;
	// 우수기변2 판매가
	private int salePrc22;
	// AMNP신규 판매가
	private int salePrc24;
	// BMNP신규 판매가
	private int salePrc25;
	// 사원번호
	private String empNo;
	// 페이지번호
	private int pageNo;
	// 페이지당 조회수
	private int pageSize;

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
	 * @return the mbcomCd
	 */
	public String getMbcomCd() {
		return mbcomCd;
	}

	/**
	 * @param mbcomCd the mbcomCd to set
	 */
	public void setMbcomCd(String mbcomCd) {
		this.mbcomCd = mbcomCd;
	}

	/**
	 * @return the mbcomCdNm
	 */
	public String getMbcomCdNm() {
		return mbcomCdNm;
	}

	/**
	 * @param mbcomCdNm the mbcomCdNm to set
	 */
	public void setMbcomCdNm(String mbcomCdNm) {
		this.mbcomCdNm = mbcomCdNm;
	}

	/**
	 * @return the mobDgr
	 */
	public int getMobDgr() {
		return mobDgr;
	}

	/**
	 * @param mobDgr the mobDgr to set
	 */
	public void setMobDgr(int mobDgr) {
		this.mobDgr = mobDgr;
	}

	/**
	 * @return the nicCd
	 */
	public String getNicCd() {
		return nicCd;
	}

	/**
	 * @param nicCd the nicCd to set
	 */
	public void setNicCd(String nicCd) {
		this.nicCd = nicCd;
	}

	/**
	 * @return the nicCdNm
	 */
	public String getNicCdNm() {
		return nicCdNm;
	}

	/**
	 * @param nicCdNm the nicCdNm to set
	 */
	public void setNicCdNm(String nicCdNm) {
		this.nicCdNm = nicCdNm;
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
	 * @return the shoPrc
	 */
	public int getShoPrc() {
		return shoPrc;
	}

	/**
	 * @param shoPrc the shoPrc to set
	 */
	public void setShoPrc(int shoPrc) {
		this.shoPrc = shoPrc;
	}

	/**
	 * @return the clpnCd
	 */
	public String getClpnCd() {
		return clpnCd;
	}

	/**
	 * @param clpnCd the clpnCd to set
	 */
	public void setClpnCd(String clpnCd) {
		this.clpnCd = clpnCd;
	}

	/**
	 * @return the clpnCdNm
	 */
	public String getClpnCdNm() {
		return clpnCdNm;
	}

	/**
	 * @param clpnCdNm the clpnCdNm to set
	 */
	public void setClpnCdNm(String clpnCdNm) {
		this.clpnCdNm = clpnCdNm;
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
	 * @return the salePrc11
	 */
	public int getSalePrc11() {
		return salePrc11;
	}

	/**
	 * @param salePrc11 the salePrc11 to set
	 */
	public void setSalePrc11(int salePrc11) {
		this.salePrc11 = salePrc11;
	}

	/**
	 * @return the salePrc16
	 */
	public int getSalePrc16() {
		return salePrc16;
	}

	/**
	 * @param salePrc16 the salePrc16 to set
	 */
	public void setSalePrc16(int salePrc16) {
		this.salePrc16 = salePrc16;
	}

	/**
	 * @return the salePrc17
	 */
	public int getSalePrc17() {
		return salePrc17;
	}

	/**
	 * @param salePrc17 the salePrc17 to set
	 */
	public void setSalePrc17(int salePrc17) {
		this.salePrc17 = salePrc17;
	}

	/**
	 * @return the salePrc19
	 */
	public int getSalePrc19() {
		return salePrc19;
	}

	/**
	 * @param salePrc19 the salePrc19 to set
	 */
	public void setSalePrc19(int salePrc19) {
		this.salePrc19 = salePrc19;
	}

	/**
	 * @return the salePrc22
	 */
	public int getSalePrc22() {
		return salePrc22;
	}

	/**
	 * @param salePrc22 the salePrc22 to set
	 */
	public void setSalePrc22(int salePrc22) {
		this.salePrc22 = salePrc22;
	}

	/**
	 * @return the salePrc24
	 */
	public int getSalePrc24() {
		return salePrc24;
	}

	/**
	 * @param salePrc24 the salePrc24 to set
	 */
	public void setSalePrc24(int salePrc24) {
		this.salePrc24 = salePrc24;
	}

	/**
	 * @return the salePrc25
	 */
	public int getSalePrc25() {
		return salePrc25;
	}

	/**
	 * @param salePrc25 the salePrc25 to set
	 */
	public void setSalePrc25(int salePrc25) {
		this.salePrc25 = salePrc25;
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
}
