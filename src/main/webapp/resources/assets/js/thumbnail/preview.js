/**
 * 이미지 미리보기 관련 자바스크립트
 */

function initialize() {
    // 이미지 클릭시 팝업 닫기
    $("#preview_image").on("click", function() {
        parent.co.popup.close();
    });


    $("#preview_image").one("load", function() {
        // 이미지의 크기에 맞게 팝업 크기 조정
        var imgWidth = $("#preview_image").width();
        var imgHeight= $("#preview_image").height();
    
        parent.co.popup.resize(imgWidth + 20, imgHeight + 20);
    });

    $("#preview_image").attr("src", "/thumbnailUploadView.do?imgSavePath=" + $("#imgSavePath").val() + "&imgSaveFileNm=" + $("#imgSaveFileNm").val());
}
