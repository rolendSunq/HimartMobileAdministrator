/**
 * 에러 관련 자바스크립트
 */
function initialize() {
    $(window).on("resize", function() {
        redrawErrorBox();
    });

    redrawErrorBox();
}

function redrawErrorBox() {
    if ($(window).height() >= $("#error-page").height()) {
        $("#error-page").css("top", Math.round(($(window).height() - $("#error-page").height()) / 2));
    } else {
        $("#error-page").css("top", 0);
    }
}
