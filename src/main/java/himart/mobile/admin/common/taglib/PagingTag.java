package himart.mobile.admin.common.taglib;


import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


@SuppressWarnings("serial")
public class PagingTag extends TagSupport {
	private int pageNo;
	private int totalCnt;
	private int pageSize;
	private int pageCnt;
	private String urlImg;

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() {
		if (totalCnt <= pageSize) {
			return SKIP_BODY;
		}

		String blnkImg = urlImg + "pg_blank.png";
		String prevImg = urlImg + "pg_prev.gif";
		String nextImg = urlImg + "pg_next.gif";

		int totalPage = (totalCnt - 1) / pageSize + 1;
		int prev10 = (int) Math.floor((pageNo - 1) / pageCnt) * pageCnt;
		int next10 = prev10 + pageCnt + 1;

		StringBuffer sbuf = new StringBuffer();

		sbuf.append("<div class='paging'>");

		if (prev10 > 0) {
			sbuf.append("<a href='#' onClick='goPage(" + prev10 + "); return false;'>");

			if (prevImg != null && !"".equals(prevImg)) {
				sbuf.append("<img src='" + prevImg + "' name='ImgPrv' border='0' align='absmiddle' alt='이전'>");
			}
			else {
				sbuf.append(" &lt; ");
			}

			sbuf.append("</a> ");
		}
		else {
			if (prevImg != null && !"".equals(prevImg)) {
				sbuf.append("<img src='" + blnkImg + "' align='absmiddle' alt='이전'> ");
			}
			else {
				sbuf.append(" ");
			}
		}

		for (int i = 1 + prev10; i < next10 && i <= totalPage; i++) {
			if (i == pageNo) {
				sbuf.append("<strong>").append(i).append("</strong>");
			}
			else {
				sbuf.append("<a href='#' onClick='goPage(" + i + "); return false;'>").append(i).append("</a>");
			}

			if (i < totalPage && (i - prev10) < pageCnt) {
				sbuf.append("·");
			}
		}

		if (totalPage >= next10) {
			sbuf.append(" <a href='#' onClick='goPage(" + next10 + "); return false;'>");

			if (nextImg != null && !"".equals(nextImg)) {
				sbuf.append("<img src='" + nextImg + "' name='ImgNxt' border='0' align='absmiddle' alt='다음'>");
			}
			else {
				sbuf.append(" &gt; ");
			}

			sbuf.append("</a>");
		}
		else {
			if (nextImg != null && !"".equals(nextImg)) {
				sbuf.append(" <img src='" + blnkImg + "' align='absmiddle' alt='다음'>");
			}
			else {
				sbuf.append(" ");
			}
		}

		sbuf.append("</div>");

		JspWriter out = pageContext.getOut();

		try {
			out.print(sbuf.toString());
		} catch (IOException ignore) {
		}

		return EVAL_PAGE;
	}
}