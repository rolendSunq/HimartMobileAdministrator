package himart.mobile.admin.util;


import java.util.Enumeration;
import java.util.Vector;


/**
 * 확장 StringTokenizer.
 * 기존의 StringTokenizer와 비교한 개선사항
 * 1. 단일문자가 아닌, 다중문자를 Delimeter로 지정할 수 있음.<br>
 * 2. prevToken()을 통해 이전 Token을 가져올 수 있음.<br>
 * 3. prevElment()을 통해 이전 Element를 가져올 수 있음.<br>
 * 4. setIndex()를 통해 직접 Token을 가져올 Index를 지정할 수 있음.<br>
 * 5. getIndex()를 통해, 현재 참조중인 Index를 가져올 수 있음.<br>
 * 6. getToken()을 통해, 현재 Index에 해당하는 Token을 가져올 수 있음. (Index는 변화되지 않음)<br>
 * 7. getElement()를 통해, 현재 Index에 해당하는 Element를 가져올 수 있음. (Index는 변화되지 않음)<br>
 * 8. 구분자내 여백 또는 널문자를 제외시키지 않고, Token으로 분석.<br>
 * </pre>
 * 
 * @Description : StringTokenizer 확장 (공백문자를 Skip하지 않음)
 * @author SeoJoHoon
 */
public class ExtendStringTokenizer implements Enumeration<Object> {
	private String m_strValue = null;

	private String m_strDelimiter = "|";

	private boolean m_bReturnDelimiter = false;

	private Vector<String> m_vtTokenList = new Vector<String>();

	private int m_iTokenIndex = -1;

	/**
	 * 지정된 문자열에 대한 ExtendStringTokenizer를 생성
	 * 
	 * @param p_strValue 지정된 문자열
	 */
	public ExtendStringTokenizer(String p_strValue) {
		this.m_strValue = p_strValue;
		parseString();
	}

	/**
	 * 지정된 문자열, 구분자에 대한 ExtendStringTokenizer를 생성
	 * 
	 * @param p_strValue 지정된 문자열
	 * @param p_strDelimiter 구분자
	 */
	public ExtendStringTokenizer(String p_strValue, String p_strDelimiter) {
		this.m_strValue = p_strValue;
		if (p_strDelimiter.length() > 0) {
			this.m_strDelimiter = p_strDelimiter;
		}
		parseString();
	}

	/**
	 * 지정된 문자열, 구분자, 구분자 리턴여부에 대한 ExtendStringTokenizer를 생성
	 * 
	 * @param p_strValue 지정된 문자열
	 * @param p_strDelimiter 구분자
	 * @param p_bReturnDelimiter 구분자 리턴여부
	 */
	public ExtendStringTokenizer(String p_strValue, String p_strDelimiter, boolean p_bReturnDelimiter) {
		this.m_strValue = p_strValue;
		this.m_strDelimiter = p_strDelimiter;
		this.m_bReturnDelimiter = p_bReturnDelimiter;
		parseString();
	}

	/**
	 * 가져올 수 있는 Token이 남아있는지 확인
	 * 
	 * @return 남아있는 Token 존재여부
	 */
	public boolean hasMoreTokens() {
		return this.m_vtTokenList.size() > (this.m_iTokenIndex + 1) ? true : false;
	}

	/**
	 * 가져올 수 있는 Element가 남아있는지 확인
	 * 
	 * @return 남아있는 Token 존재여부
	 */
	@Override
	public boolean hasMoreElements() {
		return this.m_vtTokenList.size() > (this.m_iTokenIndex + 1) ? true : false;
	}

	/**
	 * Token의 전체수
	 * 
	 * @return 전체 Token 수
	 */
	public int countTokens() {
		return this.m_vtTokenList.size();
	}

	/**
	 * 현재 Index를 한단계 낮추고, 이전 Token을 가져옴
	 * 
	 * @return 이전 Token
	 */
	public String prevToken() {
		setIndex(this.m_iTokenIndex - 1);
		return getToken();
	}

	/**
	 * 현재 Index를 한단계 높이고, 다음 Token을 가져옴
	 * 
	 * @return 다음 Token
	 */
	public String nextToken() {
		setIndex(this.m_iTokenIndex + 1);
		return getToken();
	}

	/**
	 * 현재 Index를 한단계 낮추고, 이전 Element를 가져옴
	 * 
	 * @return 이전 Element
	 */
	public Object prevElement() {
		setIndex(this.m_iTokenIndex - 1);

		return getElement();
	}

	/**
	 * 현재 Index를 한단계 높이고, 다음 Element를 가져옴
	 * 
	 * @return 다음 Element
	 */
	@Override
	public Object nextElement() {
		setIndex(this.m_iTokenIndex + 1);

		return getElement();
	}

	/**
	 * 현재 Index에 해당하는 Token을 가져옴 (Index 변화없음)
	 * 
	 * @return 현재 Token
	 */
	public String getToken() {
		return this.m_vtTokenList.get(this.m_iTokenIndex);
	}

	/**
	 * 현재 Index에 해당하는 Element를 가져옴 (Index 변화없음)
	 * 
	 * @return 현재 Element
	 */
	public Object getElement() {
		return this.m_vtTokenList.get(this.m_iTokenIndex);
	}

	/**
	 * 현재 Index를 지정한 Index로 변경
	 * 
	 * @param p_iTokenIndex 지정 Index
	 */
	public void setIndex(int p_iTokenIndex) {
		if (p_iTokenIndex >= 0 && (p_iTokenIndex + 1) <= this.m_vtTokenList.size()) {
			this.m_iTokenIndex = p_iTokenIndex;
		}
	}

	/**
	 * String 분석 후, 분해된 Token List를 나열
	 */
	private void parseString() {
		if (this.m_strValue.length() == 0) {
			this.m_vtTokenList.add(this.m_strValue);
		}
		else {
			int l_iCharIndex = 0;
			int l_iDelimiterIndex = 0;

			while (l_iCharIndex <= this.m_strValue.length()) {
				l_iDelimiterIndex = this.m_strValue.indexOf(this.m_strDelimiter, l_iCharIndex);

				if (l_iDelimiterIndex == -1) {
					this.m_vtTokenList.add(this.m_strValue.substring(l_iCharIndex, (this.m_strValue.length())));
					break;
				}
				else {
					this.m_vtTokenList.add(this.m_strValue.substring(l_iCharIndex, l_iDelimiterIndex));
					if (this.m_bReturnDelimiter) {
						this.m_vtTokenList.add(this.m_strDelimiter);
					}

					l_iCharIndex = l_iDelimiterIndex + this.m_strDelimiter.length();
				}
			}
		}
	}

}
