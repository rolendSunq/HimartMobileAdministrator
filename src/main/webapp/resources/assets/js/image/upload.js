/**
 * 이미지 관련 자바스크립트
 */
function initialize() {
    // 구분 변경시
    $("input[type='radio'][name='imgCf']").on("click", function() {
        $("#itemGrp").find("input").val("");
        $("#nicGrp").find("input").val("");

        if ($(this).val() == "2" || $(this).val() == "9" ) {
        	$("#itemGrp").hide();
        	if ($(this).val() == "9" ){
        		$("#selTitleNic").text("보험상품");
        	}else {
        		$("#selTitleNic").text("카드할인");
        	}
        } 
        else {
            if ($(this).val() == "4") {
              $("#selTitleNic").text("대표코드");
            }  
            else {
              $("#selTitleNic").text("닉네임");
            }
            $("#itemGrp").show();
        } 
    });

    // 조회
    $("#btnLookup").on("click", function() {
        if ($("input[type='radio'][name='imgCf']:checked").val() != "2" &&
        	$("input[type='radio'][name='imgCf']:checked").val() != "9"
          ) {
            if ($("#itemCd").val() == "") {
                alert("품목을 선택하세요.");
                return false;
            }
        }

        top.co.loading.start();

        with (frmImage) {
            imgCfCd.value = $("input[type='radio'][name='imgCf']:checked").val();
            imgCfCdNm.value = $('label[for=' + $("input[type='radio'][name='imgCf']:checked").prop("id") + ']').text();
            prdItemNm.value = $("#itemCd").val();
            prdItemNmNm.value = $("#itemNm").val();
            prdNicNm.value = $("#nicCd").val();
            prdNicNmNm.value = $("#nicNm").val();
            pageNo.value = "1";

            submit();
        }
    });

    // 등록
    $("#btnEnrolment").on("click", function() {
        parent.co.popup.open($(document), "이미지 등록", "/imageUploadReg.do", 1000, 600);
    });

    // 수정
    $("a img[name='btnModify']").on("click", function() {
        var selectedTr = $(this).parents("tr");
        var selectedData = $(selectedTr).attr("data").split("^");

        var params = "";
        params += "?imgCfCd=" + selectedData[0];
        params += "&prdNicNm=" + selectedData[1];
        params += "&accPrdId=" + selectedData[2];
        params += "&imgPstCfCd=" + selectedData[3];
        params += "&imgCfCdNm=" + encodeURI($(selectedTr).find("[name='imgCfCdNm']").text());
        params += "&prdNicNmNm=" + encodeURI($(selectedTr).find("[name='prdNicNmNm']").text());
        params += "&accPrdCd=" + encodeURI($(selectedTr).find("[name='accPrdCd']").text());
        params += "&imgPstCfCdNm=" + encodeURI($(selectedTr).find("[name='imgPstCfCdNm']").text());

        parent.co.popup.open($(document), "이미지 수정", "/imageUploadMod.do" + params, 800, 150);
    });

    // 삭제
    $("#btnDelete").on("click", function() {
        with (frmImage) {
            if (parseInt(totalCnt.value) <= 0) {
                alert("삭제할 자료를 조회하세요.");
                return;
            }

            var chkList = "";

            $("input[type='checkbox'][name='checkItem']").each(function() {
                if ($(this).prop("checked") == true) {
                    if (chkList != "") {
                        chkList += "|";
                    }

                    chkList += $(this).parents("tr").attr("data");
                }
            });

            if (chkList == "") {
                alert("삭제할 자료를 선택하세요.");
                return;
            }

            if (confirm("선택한 자료를 삭제하시겠습니까?")) {
                var params = "data=" + chkList;

                requestAjax("/imageUploadDelete.do", params, callbackDelete);
            }
        }
    });

    $("input[type='radio'][name='imgCf'][value='" + ($("#imgCfCd").val() == "" ? "1" : $("#imgCfCd").val()) + "']").click();
    $("#itemCd").val($("#prdItemNm").val());
    $("#itemNm").val($("#prdItemNmNm").val());
    $("#nicCd").val($("#prdNicNm").val());
    $("#nicNm").val($("#prdNicNmNm").val());

    setupCheckbox("checkAll", "checkItem");
}

/**
 * 품목 검색
 */
function popupItem() {
    parent.co.popup.callback = setSelectItem;

    parent.co.popup.open($(document), "품목 검색", "/commonItemList.do?allowAll=N", 500, 530);
}

function setSelectItem(cd, nm) {
    if ($("#itemCd").val() == cd) {
        return;
    }

    $("#itemCd").val(cd);
    $("#itemNm").val(nm);

    $("#nicCd").val("");
    $("#nicNm").val("");
}

/**
 * 닉네임 검색
 */
function popupNic() {
    if ($("input[type='radio'][name='imgCf']:checked").val() == "2" || $("input[type='radio'][name='imgCf']:checked").val() == "9") {
        // 카드할인 검색
        parent.co.popup.callback = setSelectNic;
        if($("input[type='radio'][name='imgCf']:checked").val() == "9"){
            parent.co.popup.open($(document), "보험상품 검색", "/commonCardList.do?allowAll=Y&cardGb=B", 500, 530);
        }else {
            parent.co.popup.open($(document), "카드할인 검색", "/commonCardList.do?allowAll=Y&cardGb=Y", 500, 530);
        }
    }
    else {
        // 닉네임 검색
        if ($("#itemCd").val() == "") {
            alert("품목을 선택하세요.");
            return;
        }

        var param = "&schUpCd=" + $("#itemCd").val();

        parent.co.popup.callback = setSelectNic;

        if ($("input[type='radio'][name='imgCf']:checked").val() == "4") {
            parent.co.popup.open($(document), "대표코드 검색", "/commonMstList.do?allowAll=Y" + param, 500, 530);
        } else {
            parent.co.popup.open($(document), "닉네임 검색", "/commonNicList.do?allowAll=Y" + param, 500, 530);
        }
    }
}

function setSelectNic(cd, nm) {
    if ($("#nicCd").val() == cd) {
        return;
    }

    $("#nicCd").val(cd);
    $("#nicNm").val(nm);
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
    top.co.loading.start();

    with (frmImage) {
        pageNo.value = no;

        submit();
    }
}

/**
 * 삭제 처리 결과
 */
function callbackDelete(data) {
    if (data.result.code == "000") {
        alert(data.result.message);

        // 재조회
        $("#btnLookup").click();
    }
    else {
        alert("[" + data.result.code + "] " + data.result.message);
    }
}

/**
 * 이미지 미리보기
 */
function previewImage(path, name) {
    var param = "?imgSavePath=" + path;
    param += "&imgSaveFileNm=" + name;

    parent.co.popup.open($(document), "이미지 미리보기", "/imageUploadPreview.do" + param, 0, 0);
}
