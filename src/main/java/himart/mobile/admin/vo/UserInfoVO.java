package himart.mobile.admin.vo;


import java.io.Serializable;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 로그인 사용자의 정보로 세션에 보관될 객체
 * @author SeoJohoon
 */
@SuppressWarnings("serial")
public class UserInfoVO implements Serializable {
	// 사원번호
	String empNo = null;

	// 비밀번호
	String pwd = null;

	// 사원명
	String empKname = null;

	// 소속코드
	String blongOrgNo = null;

	// 소속명
	String orgNm = null;

	// 소속유형
	String orgType = null;

	// 비밀번호 일치여부
	String validPwd = null;

	/**
	 * @return 사원번호
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo 사원번호
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return 비밀번호
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd 비밀번호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return 사원명
	 */
	public String getEmpKname() {
		return empKname;
	}

	/**
	 * @param empKname 사원명
	 */
	public void setEmpKname(String empKname) {
		this.empKname = empKname;
	}

	/**
	 * @return 소속코드
	 */
	public String getBlongOrgNo() {
		return blongOrgNo;
	}

	/**
	 * @param blongOrgNo 소속코드
	 */
	public void setBlongOrgNo(String blongOrgNo) {
		this.blongOrgNo = blongOrgNo;
	}

	/**
	 * @return 소속명
	 */
	public String getOrgNm() {
		return orgNm;
	}

	/**
	 * @param orgNm 소속명
	 */
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	/**
	 * @return 소속유형
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * @param orgType 소속유형
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	/**
	 * @return 비밀번호 일치여부
	 */
	public String getValidPwd() {
		return validPwd;
	}

	/**
	 * @param validPwd 비밀번호 일치여부
	 */
	public void setValidPwd(String validPwd) {
		this.validPwd = validPwd;
	}
}
