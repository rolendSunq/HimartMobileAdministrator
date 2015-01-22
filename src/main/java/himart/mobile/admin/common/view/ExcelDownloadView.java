package himart.mobile.admin.common.view;


import himart.mobile.admin.util.StringUtil;
import himart.mobile.admin.vo.LogCounselVO;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;


public class ExcelDownloadView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map<String, Object> ModelMap, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String excelName = ModelMap.get("target").toString();
		String fileName = ModelMap.get("fileName").toString();

		HSSFSheet worksheet = null;

		HSSFRow row = null;

		int sheetNo = 1;

		// 상담로그 다운로드일 경우
		if ("counsel".equals(excelName)) {
			fileName = URLEncoder.encode(fileName, "UTF-8");

			@SuppressWarnings("unchecked")
			List<LogCounselVO> list = (List<LogCounselVO>) ModelMap.get("list");

			int idx = 0;

			for (int i = 0; list != null && i < list.size(); i++) {
				// 오피스 2003 이전 버전일 경우 하나의 시트에 최대 65536행만 가능
				if (i % 65535 == 0) {
					worksheet = workbook.createSheet("상담로그+" + StringUtil.lPadding(String.valueOf(sheetNo++), 3, '0'));

					row = worksheet.createRow(0);

					idx = 0;

					row.createCell(idx++).setCellValue("지점코드");
					row.createCell(idx++).setCellValue("지점명");
					row.createCell(idx++).setCellValue("상담일자");
					row.createCell(idx++).setCellValue("발생순번");
					row.createCell(idx++).setCellValue("상세순번");
					row.createCell(idx++).setCellValue("메뉴CH");
					row.createCell(idx++).setCellValue("상담시작시각");
					row.createCell(idx++).setCellValue("권유자사번");
					row.createCell(idx++).setCellValue("권유자성명");
					row.createCell(idx++).setCellValue("연령대");
//					row.createCell(idx++).setCellValue("연령");
					row.createCell(idx++).setCellValue("성별코드");
					row.createCell(idx++).setCellValue("성별");
					row.createCell(idx++).setCellValue("상담모델코드");
					row.createCell(idx++).setCellValue("상담모델");
					row.createCell(idx++).setCellValue("제조사코드");
					row.createCell(idx++).setCellValue("제조사");
					row.createCell(idx++).setCellValue("희망통신사코드");
					row.createCell(idx++).setCellValue("희망통신사");
					row.createCell(idx++).setCellValue("상담_가입구분코드");
					row.createCell(idx++).setCellValue("상담_가입구분");
					row.createCell(idx++).setCellValue("상담_판매가");
					row.createCell(idx++).setCellValue("희망_가입구분코드");
					row.createCell(idx++).setCellValue("희망_가입구분");
					row.createCell(idx++).setCellValue("희망_판매가");
					row.createCell(idx++).setCellValue("요금제코드");
					row.createCell(idx++).setCellValue("요금제명");
					row.createCell(idx++).setCellValue("SKN중고보상금액");
					row.createCell(idx++).setCellValue("결합할인코드");
					row.createCell(idx++).setCellValue("결합할인");
					row.createCell(idx++).setCellValue("카드할인코드");
					row.createCell(idx++).setCellValue("카드할인");
					row.createCell(idx++).setCellValue("통신사중고보상금액");
					row.createCell(idx++).setCellValue("지점할인금액");
					row.createCell(idx++).setCellValue("복지할인코드");
					row.createCell(idx++).setCellValue("복지할인");
					row.createCell(idx++).setCellValue("부가서비스총액");
					row.createCell(idx++).setCellValue("부가서비스");
					row.createCell(idx++).setCellValue("고객명");
					row.createCell(idx++).setCellValue("휴대폰번호");
					row.createCell(idx++).setCellValue("구매확정일");
					row.createCell(idx++).setCellValue("상담상태코드");
					row.createCell(idx++).setCellValue("상담상태");
					row.createCell(idx++).setCellValue("상담페이지");
					row.createCell(idx++).setCellValue("이전통신사코드");
					row.createCell(idx++).setCellValue("이전통신사");
					row.createCell(idx++).setCellValue("월납입금액내역");
					row.createCell(idx++).setCellValue("상담상품코드2");
					row.createCell(idx++).setCellValue("상담상품2");
					row.createCell(idx++).setCellValue("요금제연령대코드");
					row.createCell(idx++).setCellValue("요금제연령대");
					row.createCell(idx++).setCellValue("비고");
				}

				row = worksheet.createRow(i + 1);

				idx = 0;

				row.createCell(idx++).setCellValue(list.get(i).getBrchId());
				row.createCell(idx++).setCellValue(list.get(i).getBrchIdNm());
				row.createCell(idx++).setCellValue(formatDate(list.get(i).getCnslDt()));
				row.createCell(idx++).setCellValue(list.get(i).getOccrSeq());
				row.createCell(idx++).setCellValue(list.get(i).getDtlSeq());
				row.createCell(idx++).setCellValue(list.get(i).getMnCfCd());
				row.createCell(idx++).setCellValue(formatTime(list.get(i).getCnslStrtTm()));
				row.createCell(idx++).setCellValue(list.get(i).getIvtmnId());
				row.createCell(idx++).setCellValue(list.get(i).getIvtmnIdNm());
				row.createCell(idx++).setCellValue(list.get(i).getAgs());
//				row.createCell(idx++).setCellValue(list.get(i).getAgs());
				row.createCell(idx++).setCellValue(list.get(i).getSexCd());
				row.createCell(idx++).setCellValue(list.get(i).getSexNm());
				row.createCell(idx++).setCellValue(list.get(i).getCnslPrdCd());
				row.createCell(idx++).setCellValue(list.get(i).getCnslPrdCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getMkrId());
				row.createCell(idx++).setCellValue(list.get(i).getMkrNm());
				row.createCell(idx++).setCellValue(list.get(i).getMbcomCd());
				row.createCell(idx++).setCellValue(list.get(i).getMbcomCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getCnslJnCfCd());
				row.createCell(idx++).setCellValue(list.get(i).getCnslJnCfCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getCnslSlprc());
				row.createCell(idx++).setCellValue(list.get(i).getHopeJnCfCd());
				row.createCell(idx++).setCellValue(list.get(i).getHopeJnCfCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getHopeSlprc());
				row.createCell(idx++).setCellValue(list.get(i).getClpnCd());
				row.createCell(idx++).setCellValue(list.get(i).getClpnCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getCpnAmt());
				row.createCell(idx++).setCellValue(list.get(i).getDcSvCd());
				row.createCell(idx++).setCellValue(list.get(i).getDcSvCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getVndrId());
				row.createCell(idx++).setCellValue(list.get(i).getVndrIdNm());
				row.createCell(idx++).setCellValue(list.get(i).getMbcomUcAmt());
				row.createCell(idx++).setCellValue(list.get(i).getBrchDcAmt());
				row.createCell(idx++).setCellValue(list.get(i).getWlfrDcCd());
				row.createCell(idx++).setCellValue(list.get(i).getWlfrDcCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getOpsvcTsumAmt());
				row.createCell(idx++).setCellValue(list.get(i).getMobOpsvcCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getCustNm());
				row.createCell(idx++).setCellValue(list.get(i).getMpno());
				row.createCell(idx++).setCellValue(formatDate(list.get(i).getBuyCfmDt()));
				row.createCell(idx++).setCellValue(list.get(i).getCnslStsCd());
				row.createCell(idx++).setCellValue(list.get(i).getCnslStsCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getCnslPageUrl());
				row.createCell(idx++).setCellValue(list.get(i).getMnoBfMbcomCd());
				row.createCell(idx++).setCellValue(list.get(i).getMnoBfMbcomCdNm());
				row.createCell(idx++).setCellValue(list.get(i).getMmPaidAmtBkdn());
				row.createCell(idx++).setCellValue(list.get(i).getCnslPrdCd2());
				row.createCell(idx++).setCellValue(list.get(i).getCnslPrdCdNm2());
				row.createCell(idx++).setCellValue(list.get(i).getClpnAgs());
				row.createCell(idx++).setCellValue(list.get(i).getClpnAgsNm());
				row.createCell(idx++).setCellValue(list.get(i).getRmk());
			}
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
		response.addCookie(new Cookie("fileDownload", "true"));
	}

	private String formatDate(String date) {
		if (date == null || "".equals(date)) {
			return "";
		}

		if (date.replaceAll("[^0-9]", "").trim().length() < 8) {
			return date.replaceAll("[^0-9]", "");
		}

		return date.replaceAll("[^0-9]", "").trim().replaceAll("([0-9]{4})([0-9]{2})([0-9]{2})", "$1-$2-$3");
	}

	private String formatTime(String time) {
		if (time == null || "".equals(time)) {
			return "";
		}

		if (time.replaceAll("[^0-9]", "").trim().length() < 6) {
			return time.replaceAll("[^0-9]", "");
		}

		return time.replaceAll("[^0-9]", "").trim().replaceAll("([0-9]{2})([0-9]{2})([0-9]{2})", "$1:$2:$3");
	}
}
