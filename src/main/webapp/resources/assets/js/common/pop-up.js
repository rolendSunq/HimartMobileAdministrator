/**
 * 공통팝업 관련 자바스크립트
 */

function initialize() {
	if ($("#cardGb").val() == "Y" || $("#cardGb").val() == "B") {
		$("#schCond").hide();
	}
 
    // 기본값 세팅
    $("#schStrCond").val($("#schStr").val());

    $("input[type='radio'][name='schGbCond'][value='" + $("#schGb").val() + "'").prop("checked", true);

    // 조회
    $("#btnLookup").on("click", function() {
        top.co.loading.start();

        with (frmCommon) {
            schGb.value = $("input[type='radio'][name='schGbCond']:checked").val();
            schStr.value = $("#schStrCond").val();

            submit();
        }
    });
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
    top.co.loading.start();

    with (frmCommon) {
        pageNo.value = no;

        submit();
    }
}

/**
 * 코드 선택
 */
function choiceCode(obj) {
    if ( typeof parent.co.popup.callback == "function") {
        var codeInfo = $(obj).attr("data").split("|");

        parent.co.popup.callback(codeInfo[0], codeInfo[1]);
    }

    parent.co.popup.close();
}
