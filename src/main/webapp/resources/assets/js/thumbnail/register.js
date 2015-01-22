/**
 * 이미지 관련 자바스크립트
 */
var currRowObj;
//배경이미지
var intPstCfcd = 0;
//본사
var intCntB = 0;
//지점
var intCntS = 0;

function initialize() {
	// 구분 변경시
	$("input[type='radio'][name='imgCf']").on("click", function() {
		$("#itemGrp").find("input").val("");
		
		if ($(this).val() == "2") {
			$("#tdTitleGb").text("구분");
			$("#selTitleNic").text("카드할인");
			$("#itemGrp").hide();
		} else {
			$("#tdTitleGb").text("구분");
            if ($(this).val() == "4") {
	   		  $("#selTitleNic").text("대표코드");
			} else {
    		  $("#selTitleNic").text("닉네임");
			}
			$("#itemGrp").show();
		}
	});
	
	// 이미지 추가 버튼 
	$("#btnAdd").on("click", function() {
		if ($("#frmImage #imgFileNm").length >= 8) {
			alert("동시에 저장가능한 이미지는 최대 8개입니다.");
			return false;
		}

		var imgCf = $("input[type='radio'][name='imgCf']:checked").val();
		var imgCfNm = $('label[for='+$("input[type='radio'][name='imgCf']:checked").prop("id")+']').text();
		var itemCd = "";
		var itemNicNm = "";
		var itemPstCfCd = "01";  //순번

		//본사 이미지 갯수 1개 이상 불가
		if ($("input[type='radio'][name='imgCf']:checked").val() == "5") {
			intCntB++;
			if (intCntB > 1) {
				intCntB--;
				alert("본사이미지 항목을 1개이상 추가 할수 없습니다.");
				return false;
			}
		}
		//지점 이미지 갯수 1개 이상 불가
		if ($("input[type='radio'][name='imgCf']:checked").val() == "6") {
			intCntS++;
			if (intCntS > 1) {
				intCntS--;
				alert("지점 이미지 항목을 1개이상 추가 할수 없습니다.");
				return false;
			}
		}
		
		if ($("input[type='radio'][name='imgCf']:checked").val() == "7") {
			intPstCfcd++;
			if (intPstCfcd > 5) {
				intPstCfcd--;
				alert("배경이미지 항목을 5개이상 추가 할수 없습니다.");
				return false;
			}
			itemPstCfCd = toSpeclen(intPstCfcd, 2); 
		}
 
		//코드, 코드명
		if(imgCf == "8"){
			itemCd = "AP"; 
		}else{
			itemCd = "%"; 
		}
		//디폴트 코드
		itemNicNm = "0000000";
		itemCodeNm = "";
		imgUploadType = "reg";
		
		var newTr = "";

		newTr += "<tr>";
		newTr += "	<td class='txt_ac'><a href='#'><img src='/assets/image/btn_delrow.png' alt='삭제' title='삭제' onclick='javascript:deleteFile(this); return false;'/></a></td>";
		newTr += "	<td class='txt_ac'><input type='hidden' name='imgCfCd' value='" + imgCf + "' title='구분'/>" + imgCfNm + "</td>";
        if (imgCf == "8") {
        	 newTr += "  <td class='txt_ac'><input type='hidden' id='itemCdReg' value='" + itemCd + "' title='코드' /><input type='hidden' id='prdNicNm' name='prdNicNm' title='코드' /><input type='text' class='wd201' id='prdNicNmNm' title='코드명' readonly='readonly' /><input type='image' class='icld' src='/assets/image/btn_search.gif' alt='찾기' title='찾기' onclick='javascript:popupNic(this); return false;' /></td>";
        } else {
            newTr += "  <td class='txt_ac'><input type='hidden' id='itemCdReg' value='"+itemNicNm+"' title='코드' /><input type='hidden' id='prdNicNm' name='prdNicNm' title='코드' value='"+itemNicNm+"'  readonly='readonly' />"+itemNicNm+"</td>";
        }
//        if (imgCf == "8") {
        	newTr += "	<td class='txt_ac'><input type='text' class='wd201' id='itemNicNmNm' name='itemNicNmNm' title='코드명'  value='" + itemCodeNm + "'  readonly='readonly' />" + itemCodeNm + "</td>";
//        }
		newTr += "	<td class='txt_ac'><input type='hidden' id='imgPstCfCd' name='imgPstCfCd' title='순번'  value='" + itemPstCfCd + "'  />" + itemPstCfCd + "</td>";
		newTr += "	<td class='txt_ac'><input type='hidden' id='imgOrigFileNm' title='파일명' /><input type='file' class='wdfull' id='imgOrigFile' name='imgOrigFile' accept='image/*' onchange='javascript:changeFile(this);' /></td>";
        newTr += "  <td class='txt_ac'><input type='hidden' id='accPrdId' name='accPrdId' title='상품ID' value='0000000000' /></td>";
		newTr += "	<td class='txt_ac'><input type='hidden' id='imgUploadType' name='imgUploadType'  title='업로드유형'  value='" + imgUploadType + "'  /></td>";
		newTr += "</tr>";

		$(newTr).appendTo(".board-img tbody");
	});
	
	// 저장
	$("#btnSave").on("click", function() {
		
		// 추가한 이미지에 정보가 모두 입력되었는지 확인
		var cnt = $("#frmImage tbody tr").filter(function() {
// 		alert($(this).find("[name='imgUploadType']").val()); 
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

    if ($(currRowObj).find("input[name='imgCfCd']").val() == "2") {
        // 카드할인 검색
        co.popup.callback = setSelectNic;
        
        co.popup.open($(document), "카드할인 검색", "/commonCardList.do?allowAll=N", 500, 530);
    } else {
        // 닉네임 검색
        var param = "&schUpCd=" + $(currRowObj).find("#itemCdReg").val();

        co.popup.callback = setSelectNic;
    
        if ($(currRowObj).find("input[name='imgCfCd']").val() != "8") { //사용
            co.popup.open($(document), "대표코드 검색", "/commonMstList.do?allowAll=N" + param, 500, 530);
        } else {
            co.popup.open($(document), "타이틀 검색", "/commonCodeList.do?allowAll=N" + param, 500, 530);
        }
    }
}

function setSelectNic(cd, nm) {
    if ($(currRowObj).find("#prdNicNm").val() == cd) {
        return;
    }

    $(currRowObj).find("#prdNicNm").val(cd);
    $(currRowObj).find("#prdNicNmNm").val(cd);
    $(currRowObj).find("#itemNicNmNm").val(nm);
   
    itemCodeNm = nm;
    
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
	
	co.popup.open($(document), "이미지구분 검색", "/commonTitleGbList.do?allowAll=N", 500, 530);
}

function setSelectImgGb(cd, nm) {
	if ($(currRowObj).find("#imgPstCfCd").val() == cd) {
		return;
	}

	$(currRowObj).find("#imgPstCfCd").val(cd);
	$(currRowObj).find("#imgPstCfCdNm").val(cd);
//	$(currRowObj).find("#imgPstCfCdNm").val(nm);
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
    currRowObj = $(obj).parents("tr");

    if ($(currRowObj).find("input[name='imgCfCd']").val() == "5") {
    	intCntB--;
    }else  if ($(currRowObj).find("input[name='imgCfCd']").val() == "6") {
    	intCntS--;
    }else  if ($(currRowObj).find("input[name='imgCfCd']").val() == "7") {
    	intPstCfcd--;
    }
	
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

 
 function toSpeclen(num,len){ 
     if(typeof num !== "number"){return;}
     while(num.toString().length < len){
        num = "0" + num;
    }
    return num;
  }
 