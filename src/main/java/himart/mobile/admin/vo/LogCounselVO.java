package himart.mobile.admin.vo;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 상담로그 정보가 보관될 객체
 * @author SeoJohoon
 */
public class LogCounselVO {
	// 상담일자 (시작일자)
	private String cnslDtFrom = null;
	// 상담일자 (종료일자)
	private String cnslDtTo = null;

	// 순번
	private int seq = 0;
	// 지점코드
	private String brchId = null;
	// 지점명
	private String brchIdNm = null;
	// 상담일자
	private String cnslDt = null;
	// 발생순번
	private String occrSeq = null;
	// 상세순번
	private String dtlSeq = null;
	// 메뉴CH
	private String mnCfCd = null;
	// 상담시작시각
	private String cnslStrtTm = null;
	// 권유자사번
	private String ivtmnId = null;
	// 권유자성명
	private String ivtmnIdNm = null;
	// 연령코드
	private String ags = null;
	// 연령명
	private String agsNm = null;
	// 성별코드
	private String sexCd = null;
	// 성별명
	private String sexNm = null;
	// 상담모델코드
	private String cnslPrdCd = null;
	// 상담모델명
	private String cnslPrdCdNm = null;
	// 제조사코드
	private String mkrId = null;
	// 제조사명
	private String mkrNm = null;
	// 희망통신사코드
	private String mbcomCd = null;
	// 희망통신사명
	private String mbcomCdNm = null;
	// 상담_가입구분코드
	private String cnslJnCfCd = null;
	// 상담_가입구분명
	private String cnslJnCfCdNm = null;
	// 상담_판매가
	private int cnslSlprc = 0;
	// 희망_가입구분코드
	private String hopeJnCfCd = null;
	// 희망_가입구분명
	private String hopeJnCfCdNm = null;
	// 희망_판매가
	private int hopeSlprc = 0;
	// 요금제코드
	private String clpnCd = null;
	// 요금제명
	private String clpnCdNm = null;
	// SKN중고보상금액
	private int cpnAmt = 0;
	// 결합할인코드
	private String dcSvCd = null;
	// 결합할인명
	private String dcSvCdNm = null;
	// 카드할인코드
	private String vndrId = null;
	// 카드할인명
	private String vndrIdNm = null;
	// 통신사중고보상금액
	private int mbcomUcAmt = 0;
	// 지점할인금액
	private int brchDcAmt = 0;
	// 복지할인코드
	private String wlfrDcCd = null;
	// 복지할인명
	private String wlfrDcCdNm = null;
	// 부가서비스총액
	private int opsvcTsumAmt = 0;
	// 부가서비스
	private String mobOpsvcCdNm = null;
	// 고객명
	private String custNm = null;
	// 휴대폰번호
	private String mpno = null;
	// 구매확정일
	private String buyCfmDt = null;
	// 상담상태코드
	private String cnslStsCd = null;
	// 상담상태명
	private String cnslStsCdNm = null;
	// 상담페이지
	private String cnslPageUrl = null;
	// 비고
	private String rmk = null;
	// 이전통신사코드
	private String mnoBfMbcomCd;
	// 이전통신사
	private String mnoBfMbcomCdNm;
	// 월납입금액내역
	private String mmPaidAmtBkdn;
	// 상담상품코드2
	private String cnslPrdCd2;
	// 상담상품2
	private String cnslPrdCdNm2;
	// 요금제연령대코드
	private String clpnAgs;
	// 요금제연령대
	private String clpnAgsNm;
	//페이지번호
	private int pageNo;
	//페이지당조회수
	private int pageSize;

	/**
	 * @return the cnslDtFrom
	 */
	public String getCnslDtFrom() {
		return cnslDtFrom;
	}

	/**
	 * @param cnslDtFrom the cnslDtFrom to set
	 */
	public void setCnslDtFrom(String cnslDtFrom) {
		this.cnslDtFrom = cnslDtFrom;
	}

	/**
	 * @return the cnslDtTo
	 */
	public String getCnslDtTo() {
		return cnslDtTo;
	}

	/**
	 * @param cnslDtTo the cnslDtTo to set
	 */
	public void setCnslDtTo(String cnslDtTo) {
		this.cnslDtTo = cnslDtTo;
	}

	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 * @return the brchId
	 */
	public String getBrchId() {
		return brchId;
	}

	/**
	 * @param brchId the brchId to set
	 */
	public void setBrchId(String brchId) {
		this.brchId = brchId;
	}

	/**
	 * @return the brchIdNm
	 */
	public String getBrchIdNm() {
		return brchIdNm;
	}

	/**
	 * @param brchIdNm the brchIdNm to set
	 */
	public void setBrchIdNm(String brchIdNm) {
		this.brchIdNm = brchIdNm;
	}

	/**
	 * @return the cnslDt
	 */
	public String getCnslDt() {
		return cnslDt;
	}

	/**
	 * @param cnslDt the cnslDt to set
	 */
	public void setCnslDt(String cnslDt) {
		this.cnslDt = cnslDt;
	}

	/**
	 * @return the occrSeq
	 */
	public String getOccrSeq() {
		return occrSeq;
	}

	/**
	 * @param occrSeq the occrSeq to set
	 */
	public void setOccrSeq(String occrSeq) {
		this.occrSeq = occrSeq;
	}

	/**
	 * @return the dtlSeq
	 */
	public String getDtlSeq() {
		return dtlSeq;
	}

	/**
	 * @param dtlSeq the dtlSeq to set
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}

	/**
	 * @return the mnCfCd
	 */
	public String getMnCfCd() {
		return mnCfCd;
	}

	/**
	 * @param mnCfCd the mnCfCd to set
	 */
	public void setMnCfCd(String mnCfCd) {
		this.mnCfCd = mnCfCd;
	}

	/**
	 * @return the cnslStrtTm
	 */
	public String getCnslStrtTm() {
		return cnslStrtTm;
	}

	/**
	 * @param cnslStrtTm the cnslStrtTm to set
	 */
	public void setCnslStrtTm(String cnslStrtTm) {
		this.cnslStrtTm = cnslStrtTm;
	}

	/**
	 * @return the ivtmnId
	 */
	public String getIvtmnId() {
		return ivtmnId;
	}

	/**
	 * @param ivtmnId the ivtmnId to set
	 */
	public void setIvtmnId(String ivtmnId) {
		this.ivtmnId = ivtmnId;
	}

	/**
	 * @return the ivtmnIdNm
	 */
	public String getIvtmnIdNm() {
		return ivtmnIdNm;
	}

	/**
	 * @param ivtmnIdNm the ivtmnIdNm to set
	 */
	public void setIvtmnIdNm(String ivtmnIdNm) {
		this.ivtmnIdNm = ivtmnIdNm;
	}

	/**
	 * @return the ags
	 */
	public String getAgs() {
		return ags;
	}

	/**
	 * @param ags the ags to set
	 */
	public void setAgs(String ags) {
		this.ags = ags;
	}

	/**
	 * @return the agsNm
	 */
	public String getAgsNm() {
		return agsNm;
	}

	/**
	 * @param agsNm the agsNm to set
	 */
	public void setAgsNm(String agsNm) {
		this.agsNm = agsNm;
	}

	/**
	 * @return the sexCd
	 */
	public String getSexCd() {
		return sexCd;
	}

	/**
	 * @param sexCd the sexCd to set
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	/**
	 * @return the sexNm
	 */
	public String getSexNm() {
		return sexNm;
	}

	/**
	 * @param sexNm the sexNm to set
	 */
	public void setSexNm(String sexNm) {
		this.sexNm = sexNm;
	}

	/**
	 * @return the cnslPrdCd
	 */
	public String getCnslPrdCd() {
		return cnslPrdCd;
	}

	/**
	 * @param cnslPrdCd the cnslPrdCd to set
	 */
	public void setCnslPrdCd(String cnslPrdCd) {
		this.cnslPrdCd = cnslPrdCd;
	}

	/**
	 * @return the cnslPrdCdNm
	 */
	public String getCnslPrdCdNm() {
		return cnslPrdCdNm;
	}

	/**
	 * @param cnslPrdCdNm the cnslPrdCdNm to set
	 */
	public void setCnslPrdCdNm(String cnslPrdCdNm) {
		this.cnslPrdCdNm = cnslPrdCdNm;
	}

	/**
	 * @return the mkrId
	 */
	public String getMkrId() {
		return mkrId;
	}

	/**
	 * @param mkrId the mkrId to set
	 */
	public void setMkrId(String mkrId) {
		this.mkrId = mkrId;
	}

	/**
	 * @return the mkrNm
	 */
	public String getMkrNm() {
		return mkrNm;
	}

	/**
	 * @param mkrNm the mkrNm to set
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
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
	 * @return the cnslJnCfCd
	 */
	public String getCnslJnCfCd() {
		return cnslJnCfCd;
	}

	/**
	 * @param cnslJnCfCd the cnslJnCfCd to set
	 */
	public void setCnslJnCfCd(String cnslJnCfCd) {
		this.cnslJnCfCd = cnslJnCfCd;
	}

	/**
	 * @return the cnslJnCfCdNm
	 */
	public String getCnslJnCfCdNm() {
		return cnslJnCfCdNm;
	}

	/**
	 * @param cnslJnCfCdNm the cnslJnCfCdNm to set
	 */
	public void setCnslJnCfCdNm(String cnslJnCfCdNm) {
		this.cnslJnCfCdNm = cnslJnCfCdNm;
	}

	/**
	 * @return the cnslSlprc
	 */
	public int getCnslSlprc() {
		return cnslSlprc;
	}

	/**
	 * @param cnslSlprc the cnslSlprc to set
	 */
	public void setCnslSlprc(int cnslSlprc) {
		this.cnslSlprc = cnslSlprc;
	}

	/**
	 * @return the hopeJnCfCd
	 */
	public String getHopeJnCfCd() {
		return hopeJnCfCd;
	}

	/**
	 * @param hopeJnCfCd the hopeJnCfCd to set
	 */
	public void setHopeJnCfCd(String hopeJnCfCd) {
		this.hopeJnCfCd = hopeJnCfCd;
	}

	/**
	 * @return the hopeJnCfCdNm
	 */
	public String getHopeJnCfCdNm() {
		return hopeJnCfCdNm;
	}

	/**
	 * @param hopeJnCfCdNm the hopeJnCfCdNm to set
	 */
	public void setHopeJnCfCdNm(String hopeJnCfCdNm) {
		this.hopeJnCfCdNm = hopeJnCfCdNm;
	}

	/**
	 * @return the hopeSlprc
	 */
	public int getHopeSlprc() {
		return hopeSlprc;
	}

	/**
	 * @param hopeSlprc the hopeSlprc to set
	 */
	public void setHopeSlprc(int hopeSlprc) {
		this.hopeSlprc = hopeSlprc;
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
	 * @return the cpnAmt
	 */
	public int getCpnAmt() {
		return cpnAmt;
	}

	/**
	 * @param cpnAmt the cpnAmt to set
	 */
	public void setCpnAmt(int cpnAmt) {
		this.cpnAmt = cpnAmt;
	}

	/**
	 * @return the dcSvCd
	 */
	public String getDcSvCd() {
		return dcSvCd;
	}

	/**
	 * @param dcSvCd the dcSvCd to set
	 */
	public void setDcSvCd(String dcSvCd) {
		this.dcSvCd = dcSvCd;
	}

	/**
	 * @return the dcSvCdNm
	 */
	public String getDcSvCdNm() {
		return dcSvCdNm;
	}

	/**
	 * @param dcSvCdNm the dcSvCdNm to set
	 */
	public void setDcSvCdNm(String dcSvCdNm) {
		this.dcSvCdNm = dcSvCdNm;
	}

	/**
	 * @return the vndrId
	 */
	public String getVndrId() {
		return vndrId;
	}

	/**
	 * @param vndrId the vndrId to set
	 */
	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}

	/**
	 * @return the vndrIdNm
	 */
	public String getVndrIdNm() {
		return vndrIdNm;
	}

	/**
	 * @param vndrIdNm the vndrIdNm to set
	 */
	public void setVndrIdNm(String vndrIdNm) {
		this.vndrIdNm = vndrIdNm;
	}

	/**
	 * @return the mbcomUcAmt
	 */
	public int getMbcomUcAmt() {
		return mbcomUcAmt;
	}

	/**
	 * @param mbcomUcAmt the mbcomUcAmt to set
	 */
	public void setMbcomUcAmt(int mbcomUcAmt) {
		this.mbcomUcAmt = mbcomUcAmt;
	}

	/**
	 * @return the brchDcAmt
	 */
	public int getBrchDcAmt() {
		return brchDcAmt;
	}

	/**
	 * @param brchDcAmt the brchDcAmt to set
	 */
	public void setBrchDcAmt(int brchDcAmt) {
		this.brchDcAmt = brchDcAmt;
	}

	/**
	 * @return the wlfrDcCd
	 */
	public String getWlfrDcCd() {
		return wlfrDcCd;
	}

	/**
	 * @param wlfrDcCd the wlfrDcCd to set
	 */
	public void setWlfrDcCd(String wlfrDcCd) {
		this.wlfrDcCd = wlfrDcCd;
	}

	/**
	 * @return the wlfrDcCdNm
	 */
	public String getWlfrDcCdNm() {
		return wlfrDcCdNm;
	}

	/**
	 * @param wlfrDcCdNm the wlfrDcCdNm to set
	 */
	public void setWlfrDcCdNm(String wlfrDcCdNm) {
		this.wlfrDcCdNm = wlfrDcCdNm;
	}

	/**
	 * @return the opsvcTsumAmt
	 */
	public int getOpsvcTsumAmt() {
		return opsvcTsumAmt;
	}

	/**
	 * @param opsvcTsumAmt the opsvcTsumAmt to set
	 */
	public void setOpsvcTsumAmt(int opsvcTsumAmt) {
		this.opsvcTsumAmt = opsvcTsumAmt;
	}

	/**
	 * @return the mobOpsvcCdNm
	 */
	public String getMobOpsvcCdNm() {
		return mobOpsvcCdNm;
	}

	/**
	 * @param mobOpsvcCdNm the mobOpsvcCdNm to set
	 */
	public void setMobOpsvcCdNm(String mobOpsvcCdNm) {
		this.mobOpsvcCdNm = mobOpsvcCdNm;
	}

	/**
	 * @return the custNm
	 */
	public String getCustNm() {
		return custNm;
	}

	/**
	 * @param custNm the custNm to set
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * @return the mpno
	 */
	public String getMpno() {
		return mpno;
	}

	/**
	 * @param mpno the mpno to set
	 */
	public void setMpno(String mpno) {
		this.mpno = mpno;
	}

	/**
	 * @return the buyCfmDt
	 */
	public String getBuyCfmDt() {
		return buyCfmDt;
	}

	/**
	 * @param buyCfmDt the buyCfmDt to set
	 */
	public void setBuyCfmDt(String buyCfmDt) {
		this.buyCfmDt = buyCfmDt;
	}

	/**
	 * @return the cnslStsCd
	 */
	public String getCnslStsCd() {
		return cnslStsCd;
	}

	/**
	 * @param cnslStsCd the cnslStsCd to set
	 */
	public void setCnslStsCd(String cnslStsCd) {
		this.cnslStsCd = cnslStsCd;
	}

	/**
	 * @return the cnslStsCdNm
	 */
	public String getCnslStsCdNm() {
		return cnslStsCdNm;
	}

	/**
	 * @param cnslStsCdNm the cnslStsCdNm to set
	 */
	public void setCnslStsCdNm(String cnslStsCdNm) {
		this.cnslStsCdNm = cnslStsCdNm;
	}

	/**
	 * @return the cnslPageUrl
	 */
	public String getCnslPageUrl() {
		return cnslPageUrl;
	}

	/**
	 * @param cnslPageUrl the cnslPageUrl to set
	 */
	public void setCnslPageUrl(String cnslPageUrl) {
		this.cnslPageUrl = cnslPageUrl;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the mnoBfMbcomCd
	 */
	public String getMnoBfMbcomCd() {
		return mnoBfMbcomCd;
	}

	/**
	 * @param mnoBfMbcomCd the mnoBfMbcomCd to set
	 */
	public void setMnoBfMbcomCd(String mnoBfMbcomCd) {
		this.mnoBfMbcomCd = mnoBfMbcomCd;
	}

	/**
	 * @return the mnoBfMbcomCdNm
	 */
	public String getMnoBfMbcomCdNm() {
		return mnoBfMbcomCdNm;
	}

	/**
	 * @param mnoBfMbcomCdNm the mnoBfMbcomCdNm to set
	 */
	public void setMnoBfMbcomCdNm(String mnoBfMbcomCdNm) {
		this.mnoBfMbcomCdNm = mnoBfMbcomCdNm;
	}

	/**
	 * @return the mmPaidAmtBkdn
	 */
	public String getMmPaidAmtBkdn() {
		return mmPaidAmtBkdn;
	}

	/**
	 * @param mmPaidAmtBkdn the mmPaidAmtBkdn to set
	 */
	public void setMmPaidAmtBkdn(String mmPaidAmtBkdn) {
		this.mmPaidAmtBkdn = mmPaidAmtBkdn;
	}

	/**
	 * @return the cnslPrdCd2
	 */
	public String getCnslPrdCd2() {
		return cnslPrdCd2;
	}

	/**
	 * @param cnslPrdCd2 the cnslPrdCd2 to set
	 */
	public void setCnslPrdCd2(String cnslPrdCd2) {
		this.cnslPrdCd2 = cnslPrdCd2;
	}

	/**
	 * @return the cnslPrdCdNm2
	 */
	public String getCnslPrdCdNm2() {
		return cnslPrdCdNm2;
	}

	/**
	 * @param cnslPrdCdNm2 the cnslPrdCdNm2 to set
	 */
	public void setCnslPrdCdNm2(String cnslPrdCdNm2) {
		this.cnslPrdCdNm2 = cnslPrdCdNm2;
	}

	/**
	 * @return the clpnAgs
	 */
	public String getClpnAgs() {
		return clpnAgs;
	}

	/**
	 * @param clpnAgs the clpnAgs to set
	 */
	public void setClpnAgs(String clpnAgs) {
		this.clpnAgs = clpnAgs;
	}

	/**
	 * @return the clpnAgsNm
	 */
	public String getClpnAgsNm() {
		return clpnAgsNm;
	}

	/**
	 * @param clpnAgsNm the clpnAgsNm to set
	 */
	public void setClpnAgsNm(String clpnAgsNm) {
		this.clpnAgsNm = clpnAgsNm;
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
