/**
 * 이미지 관련 자바스크립트
 */
var currRowObj;

function initialize() {
	// 구분 변경시
	$("input[type='radio'][name='imgCf']").on("click", function() {
		$("#itemGrp").find("input").val("");
		
	    if ($(this).val() == "2" || $(this).val() == "9" ) {
			$("#tdTitleGb").text("구분");
			$("#itemGrp").hide();
        	if ($(this).val() == "9" ){
        		$("#selTitleNic").text("보험상품");
        	}else {
        		$("#selTitleNic").text("카드할인");
        	}

		} else {
			$("#tdTitleGb").text("구분(품목)");
            if ($(this).val() == "4") {
	   		  $("#selTitleNic").text("대표코드");
			} else {
    		  $("#selTitleNic").text("닉네임");
			}
			$("#itemGrp").show();
		}
	});
	
	// 추가
	$("#btnAdd").on("click", function() {
		if ($("#frmImage #imgFileNm").length >= 8) {
			alert("동시에 저장가능한 이미지는 최대 8개입니다.");
			return false;
		}

		var imgCf = $("input[type='radio'][name='imgCf']:checked").val();
		var imgCfNm = $('label[for='+$("input[type='radio'][name='imgCf']:checked").prop("id")+']').text();
		var itemCd = "";

		if ($("input[type='radio'][name='imgCf']:checked").val() != "2" && $("input[type='radio'][name='imgCf']:checked").val() != "9") {
			if ($("#itemCd").val() == "") {
				alert("품목을 선택하세요.");
				return false;
			}
			
			itemCd = $("#itemCd").val();
			imgCfNm += "<br/>(" + $("#itemNm").val() + ")";
		}
		
		var newTr = "";

		newTr += "<tr>";
		newTr += "	<td class='txt_ac'><a href='#'><img src='/resources/assets/image/btn_delrow.png' alt='삭제' title='삭제' onclick='javascript:deleteFile(this); return false;'/></a></td>";
		newTr += "	<td class='txt_ac'><input type='hidden' name='imgCfCd' value='" + imgCf + "' title='구분'/>" + imgCfNm + "</td>";
        newTr += "  <td class='txt_ac'><input type='hidden' id='itemCdReg' value='" + itemCd + "' title='품목코드' /><input type='hidden' id='prdNicNm' name='prdNicNm' title='닉네임코드/대표코드' /><input type='text' class='wd201' id='prdNicNmNm' title='닉네임명' readonly='readonly' /><input type='image' class='icld' src='/resources/assets/image/btn_search.gif' alt='찾기' title='찾기' onclick='javascript:popupNic(this); return false;' /></td>";
        if (imgCf == "4") {
        newTr += "  <td class='txt_ac'><input type='hidden' id='accPrdId' name='accPrdId' title='상품ID' /><input type='text' class='wd201' id='accPrdCdNm' title='닉네임명/대표코드' readonly='readonly' /><input type='image' class='icld' src='/resources/assets/image/btn_search.gif' alt='찾기' title='찾기' onclick='javascript:popupAcc(this); return false;' /></td>";
        } else {
        newTr += "  <td class='txt_ac'><input type='hidden' id='accPrdId' name='accPrdId' title='상품ID' value='0000000000' /></td>";
        }
		newTr += "	<td class='txt_ac'><input type='hidden' id='imgPstCfCd' name='imgPstCfCd' title='이미지구분코드' /><input type='text' class='wd101' id='imgPstCfCdNm' title='이미지구분명' readonly='readonly' /><input type='image' class='icld' src='/resources/assets/image/btn_search.gif' alt='찾기' title='찾기' onclick='javascript:popupImgGb(this); return false;' /></td>";
		newTr += "	<td class='txt_ac'><input type='hidden' id='imgOrigFileNm' title='파일명' /><input type='file' class='wdfull' id='imgOrigFile' name='imgOrigFile' accept='image/*' onchange='javascript:changeFile(this);' /></td>";
		newTr += "</tr>";

		$(newTr).appendTo(".board-img tbody");
	});
	
	// 저장
	$("#btnSave").on("click", function() {
		// 추가한 이미지에 정보가 모두 입력되었는지 확인
		var cnt = $("#frmImage tbody tr").filter(function() {
		                                                      return ($(this).find("[name='imgCfCd']").val() == "" ||
                                                                      $(this).find("[name='prdNicNm']").val() == "" ||
                                                                      $(this).find("[name='accPrdId']").val() == "" ||
                                                                      $(this).find("[name='imgPstCfCd']").val() == "" ||
                                                                      $(this).find("[name='imgOrigFile']").val() == "");
		                                                    }).length;
		
        if (cnt > 0) {
            alert("저장할 이미지의 모든 항목을 입력하세요.");
        } else {
            top.co.loading.start();
            
            // 이미지 저장
            $("input[type='submit'][name='submitReg']").click();
        }
	});
}

/**
 * 품목 검색
 */
function popupItem() {
	co.popup.callback = setSelectItem;

	co.popup.open($(document), "품목 검색", "/commonItemList.do?allowAll=N", 500, 530);
}

function setSelectItem(cd, nm) {
	if ($("#itemCd").val() == cd) {
		return;
	}

	$("#itemCd").val(cd);
	$("#itemNm").val(nm);
}

/**
 * 닉네임 검색
 */
function popupNic(obj) {
    currRowObj = $(obj).parents("tr");
    if ($(currRowObj).find("input[name='imgCfCd']").val() == "2" || $(currRowObj).find("input[name='imgCfCd']").val() == "9") {
        // 카드할인 검색
        co.popup.callback = setSelectNic;
        if($(currRowObj).find("input[name='imgCfCd']").val() == "9"){
        	co.popup.open($(document), "보험상품 검색", "/commonCardList.do?allowAll=N&cardGb=B", 500, 530);
        }else{
        	co.popup.open($(document), "카드할인 검색", "/commonCardList.do?allowAll=N&cardGb=Y", 500, 530);
        }
    } else {
        // 닉네임 검색
        var param = "&schUpCd=" + $(currRowObj).find("#itemCdReg").val();

        co.popup.callback = setSelectNic;
    
        if ($(currRowObj).find("input[name='imgCfCd']").val() == "4") {
            co.popup.open($(document), "대표코드 검색", "/commonMstList.do?allowAll=N" + param, 500, 530);
        } else {
            co.popup.open($(document), "닉네임 검색", "/commonNicList.do?allowAll=N" + param, 500, 530);
        }
    }
}

function setSelectNic(cd, nm) {
    if ($(currRowObj).find("#prdNicNm").val() == cd) {
        return;
    }

    $(currRowObj).find("#prdNicNm").val(cd);
    $(currRowObj).find("#prdNicNmNm").val(nm);

    if ($(currRowObj).find("#accPrdCdNm").length > 0) {
        $(currRowObj).find("#accPrdId").val("");
        $(currRowObj).find("#accPrdCdNm").val("");
    }
}

/**
 * 액세서리 검색
 */
function popupAcc(obj) {
    currRowObj = $(obj).parents("tr");

    if ($(currRowObj).find("input[name='imgCfCd']").val() == "4") {
        if ($(currRowObj).find("#prdNicNm").val() == "") {
            alert("대표코드를 먼저 선택하세요.");
            return false;
        }

        var param = "&schUpCd=" + $(currRowObj).find("#prdNicNm").val();

        co.popup.callback = setSelectAcc;
    
        co.popup.open($(document), "액세서리 검색", "/commonAccList.do?allowAll=N" + param, 500, 530);
    }
}

function setSelectAcc(cd, nm) {
    if ($(currRowObj).find("#accPrdId").val() == cd) {
        return;
    }

    $(currRowObj).find("#accPrdId").val(cd);
    $(currRowObj).find("#accPrdCdNm").val(nm);
}

/**
 * 이미지구분 검색
 */
function popupImgGb(obj) {
	currRowObj = $(obj).parents("tr");

	co.popup.callback = setSelectImgGb;
	
	co.popup.open($(document), "이미지구분 검색", "/commonImgGbList.do?allowAll=N", 500, 530);
}

function setSelectImgGb(cd, nm) {
	if ($(currRowObj).find("#imgPstCfCd").val() == cd) {
		return;
	}

	$(currRowObj).find("#imgPstCfCd").val(cd);
	$(currRowObj).find("#imgPstCfCdNm").val(nm);
}

function selectFile(obj) {
	$(obj).parents("tr").find("#imgOrigFile").click();
}

function changeFile(obj) {
	var filepath = $(obj).val();

	if (filepath.match(/.*[.](jpeg|jpg|png)$/gi) == null) {
		$("#imgOrigFile").after($("#imgOrigFile").clone(true)).remove();
		alert("PNG. JPG 이미지만 등록할 수 있습니다.");
		return false;
	}

	$("#imgOrigFileNm").val(filepath.replace(/^.*(\\|\/)/g, ""));
}

function deleteFile(obj) {
	$(obj).parents("tr").remove();
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
	with(frmRecom) {
		pageNo.value = no;

		submit();
	}
}

/**
 * 저장 성공시
 */
function callbackSaveSuccess(msg) {
    top.co.loading.stop();

	alert(msg);
	
	// 저장시 구분과 품목코드로 목록화면 조회
	$(parent.co.popup._document).find("input[type='radio'][id='" + $("input[type='radio'][name='imgCf']:checked").prop("id") + "']").click();
	$(parent.co.popup._document).find("#itemCd").val($("#itemCd").val());
	$(parent.co.popup._document).find("#itemNm").val($("#itemNm").val());
	
	$(parent.co.popup._document).find("#btnLookup").click();
	
	parent.co.popup.close();
}

/**
 * 저장 실패시
 */
function callbackSaveFailure(msg) {
    top.co.loading.stop();
    
	alert(msg);
}
