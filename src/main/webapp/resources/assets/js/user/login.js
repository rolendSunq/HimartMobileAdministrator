/**
 * 로그인/로그아웃 관련 자바스크립트
 */
var cookieKey = "mobileAdminEmpNo";

function initialize() {
    if (top == window) {
        // 화면 가운데 정렬
        redrawLoginBox();
        
        $(window).on("resize", function() {
            redrawLoginBox();
        });
        
        $("#btnLogin").on("click", function() {
            var params = "";
            params += "empNo=" + $("#empNo").val();
            params += "&pwd=" + $("#pwd").val();

            requestAjax("/userLoginProc.do", params, callbackLoginProc);
        });
    }
    else {
        top.co.loading.start();

        top.location.href = location.href;
    }
}

function redrawLoginBox() {
    if ($(window).height() > $("#login-page").height()) {
        $("#login-page").css("top", Math.round(($(window).height() - $("#login-page").height()) / 2));
    } else {
        $("#login-page").css("top", 0);
    }
}

/**
 * 로그인 처리 결과
 *
 * @param data
 */
function callbackLoginProc(data) {
    if (data.result.code == "000") {
        top.co.loading.start();
        
        top.location.href = "/main.do";
    }
    else {
        alert("[" + data.result.code + "] " + data.result.message);
    }
}
