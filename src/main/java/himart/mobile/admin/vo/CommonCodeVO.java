package himart.mobile.admin.vo;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 품목/사원 등의 각종 공통코드성 정보가 보관될 객체
 * @author SeoJohoon
 */
public class CommonCodeVO {
	// 카드구분
	private String cardGb;

	// 검색구분
	private String schGb;

	// 검색어
	private String schStr;

	// 검색상위코드
	private String schUpCd;

	// 순번
	private int seq;

	// 항목코드1
	private String itemCd1;

	// 항목코드2
	private String itemCd2;

	// 항목명1
	private String itemNm1;

	// 항목명2
	private String itemNm2;

	// 페이지번호
	private int pageNo;

	// 페이지당 조회수
	private int pageSize;

	// 전체포함여부
	private String allowAll;

	// 이미지구분코드
	private String imgCfCd;
	
	public String getCardGb() {
		return cardGb;
	}

	public void setCardGb(String cardGb) {
		this.cardGb = cardGb;
	}

	/**
	 * @return the schGb
	 */
	public String getSchGb() {
		return schGb;
	}

	/**
	 * @param schGb the schGb to set
	 */
	public void setSchGb(String schGb) {
		this.schGb = schGb;
	}

	/**
	 * @return the schStr
	 */
	public String getSchStr() {
		return schStr;
	}

	/**
	 * @param schStr the schStr to set
	 */
	public void setSchStr(String schStr) {
		this.schStr = schStr;
	}

	/**
	 * @return the schUpCd
	 */
	public String getSchUpCd() {
		return schUpCd;
	}

	/**
	 * @param schUpCd the schUpCd to set
	 */
	public void setSchUpCd(String schUpCd) {
		this.schUpCd = schUpCd;
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
	 * @return the itemCd1
	 */
	public String getItemCd1() {
		return itemCd1;
	}

	/**
	 * @param itemCd1 the itemCd1 to set
	 */
	public void setItemCd1(String itemCd1) {
		this.itemCd1 = itemCd1;
	}

	/**
	 * @return the itemCd2
	 */
	public String getItemCd2() {
		return itemCd2;
	}

	/**
	 * @param itemCd2 the itemCd2 to set
	 */
	public void setItemCd2(String itemCd2) {
		this.itemCd2 = itemCd2;
	}

	/**
	 * @return the itemNm1
	 */
	public String getItemNm1() {
		return itemNm1;
	}

	/**
	 * @param itemNm1 the itemNm1 to set
	 */
	public void setItemNm1(String itemNm1) {
		this.itemNm1 = itemNm1;
	}

	/**
	 * @return the itemNm2
	 */
	public String getItemNm2() {
		return itemNm2;
	}

	/**
	 * @param itemNm2 the itemNm2 to set
	 */
	public void setItemNm2(String itemNm2) {
		this.itemNm2 = itemNm2;
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
	 * @return the allowAll
	 */
	public String getAllowAll() {
		return allowAll;
	}

	/**
	 * @param allowAll the allowAll to set
	 */
	public void setAllowAll(String allowAll) {
		this.allowAll = allowAll;
	}

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
}
