/**
 * 본사추천 관련 자바스크립트
 */
function initialize() {
    $("#regDtCond").datepicker({
        dateFormat : "yy-mm-dd"
    });

    $("#btnRegDtCond").on("click", function() {
        $("#regDtCond").focus();
    });

    // 조회
    $("#btnLookup").on("click", function() {
        top.co.loading.start();

        with (frmRecom) {
            regDt.value = $("#regDtCond").val();
            pageNo.value = "1";

            submit();
        }
    });

    // 등록
    $("#btnEnrolment").on("click", function() {
        var url = "/recomHofficeReg.do";

        parent.co.popup.open($(document), "본사추천 등록", url, 1000, 600);
    });

    // 삭제
    $("#btnDelete").on("click", function() {
        with (frmRecom) {
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
                var params = "";
                params += "regDt=" + $("#regDt").val();
                params += "&seq=" + chkList;

                requestAjax("/recomHofficeDelete.do", params, callbackDelete);
            }
        }
    });

    setupCheckbox("checkAll", "checkItem");
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
    top.co.loading.start();
    
    with (frmRecom) {
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
 * 배경이미지 변경 팝업
 */
function chgImage(obj, seq) {
    $("#selTdId").val($(obj).attr("id"));
    $("#seq").val(seq);

    var url = "/recomHofficeBGList.do";

    if ($(obj).text() != "") {
        url += "?imgOrigFileNm=" + encodeURI($(obj).text());
    }

    parent.co.popup.open($(document), "배경이미지", url, 900, 200);
}
