/**
 * 본사추천 배경이미지 관련 자바스크립트
 */
function initialize() {
    // 이미지 선택
    $(".bg_preview").on("click", function() {
        $(".bg_preview").removeClass("selected");
        $(this).addClass("selected");
    });
}

/**
 * 변경된 배경이미지 저장
 */
function saveImage() {
    if ($(".bg_preview.selected").length <= 0) {
        alert("적용할 배경이미지를 선택하세요.");
        return;
    }

    with (frmRecomImage) {
        var imgInfo = $(".bg_preview.selected").attr("data").split("|");

        if (parent.$("#" + parent.$("#selTdId").val()).text() == imgInfo[0]) {
            alert("이미 적용된 배경이미지입니다.");
            return;
        }

        if (!confirm("선택한 배경이미지를 적용하시겠습니까?")) {
            return;
        }

        var params = "";
        params += "regDt=" + parent.$("#regDt").val();
        params += "&seq=" + parent.$("#seq").val();
        params += "&imgOrigFileNm=" + imgInfo[0];
        params += "&imgSaveFileNm=" + imgInfo[1];
        params += "&imgSavePath=" + imgInfo[2];

        requestAjax("/recomHofficeUpdate.do", params, callbackUpdate);
    }
}

/**
 * 배경이미지 저장 후 콜백
 */
function callbackUpdate(data) {
    if (data.result.code == "000") {
        var imgInfo = $(".bg_preview.selected").attr("data").split("|");

        $(parent.co.popup._document).find("#" + parent.$("#selTdId").val()).text(imgInfo[0]);

        alert(data.result.message);

        parent.co.popup.close();
    }
    else {
        alert("[" + data.result.code + "] " + data.result.message);
    }
}