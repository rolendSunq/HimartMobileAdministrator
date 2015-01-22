/**
 * 헤더 관련 자바스크립트
 */
var keepSessionInterval = null;

function initialize() {
    startKeepSession();
    
    $("iframe#contentArea").load(function() {
      if ($(this).attr("src").indexOf("/recomHoffice.do") >= 0) {
        $("#btnRecomHoffice").prop("src", "assets/image/btn_hq_on.png");
        $("#btnImageUpload").prop("src", "assets/image/btn_img.png");
        $("#btnLogCounsel").prop("src", "assets/image/btn_counsel.png");
        $("#btnThumbnailUpload").prop("src", "assets/image/btn_thumbnail.png");
        
        $("#btnRecomHoffice").removeClass("curPointer");
        $("#btnImageUpload").addClass("curPointer");
        $("#btnLogCounsel").addClass("curPointer");
        $("#btnThumbnailUpload").addClass("curPointer");
      } else if ($(this).attr("src").indexOf("/imageUpload.do") >= 0) {
        $("#btnRecomHoffice").prop("src", "assets/image/btn_hq.png");
        $("#btnImageUpload").prop("src", "assets/image/btn_img_on.png");
        $("#btnLogCounsel").prop("src", "assets/image/btn_counsel.png");
        $("#btnThumbnailUpload").prop("src", "assets/image/btn_thumbnail.png");
        
        $("#btnRecomHoffice").addClass("curPointer");
        $("#btnImageUpload").removeClass("curPointer");
        $("#btnLogCounsel").addClass("curPointer");
        $("#btnThumbnailUpload").addClass("curPointer");
      } else if ($(this).attr("src").indexOf("/logCounsel.do") >= 0) {
        $("#btnRecomHoffice").prop("src", "assets/image/btn_hq.png");
        $("#btnImageUpload").prop("src", "assets/image/btn_img.png");
        $("#btnLogCounsel").prop("src", "assets/image/btn_counsel_on.png");
        $("#btnThumbnailUpload").prop("src", "assets/image/btn_thumbnail.png");

        $("#btnRecomHoffice").addClass("curPointer");
        $("#btnImageUpload").addClass("curPointer");
        $("#btnLogCounsel").removeClass("curPointer");
        $("#btnThumbnailUpload").addClass("curPointer");
      } else if ($(this).attr("src").indexOf("/moveThumbnailUpload.do") >= 0) { //2014.01.22
          $("#btnRecomHoffice").prop("src", "assets/image/btn_hq.png");
          $("#btnImageUpload").prop("src", "assets/image/btn_img.png");
          $("#btnLogCounsel").prop("src", "assets/image/btn_counsel.png");
          $("#btnThumbnailUpload").prop("src", "assets/image/btn_thumbnail_on.png");

          $("#btnRecomHoffice").addClass("curPointer");
          $("#btnImageUpload").addClass("curPointer");
          $("#btnLogCounsel").addClass("curPointer");
          $("#btnThumbnailUpload").removeClass("curPointer");
        }
    });
}

function startKeepSession() {
    stopKeepSession();
    
    keepSessionInterval = setInterval(function() {
        requestAjax("/mainKeepSessionProc.do");
    }, 10 * 60 * 1000);
    // 10분
}

function stopKeepSession() {
    if (keepSessionInterval != null) {
        clearInterval(keepSessionInterval);
    }
}

function logout() {
    stopKeepSession();
    
    top.co.loading.start();

    top.location.href = "/userLogoutProc.do";
}

// 본사추천
function moveRecomHoffice() {
    startKeepSession();
    
    top.co.loading.start();

    $("iframe#contentArea").attr("src", "/recomHoffice.do");
}

// 이미지
function moveImageUpload() {
    startKeepSession();
    
    top.co.loading.start();

    $("iframe#contentArea").attr("src", "/imageUpload.do");
}

// 상담로그
function moveLogCounsel() {
    startKeepSession();
    
    top.co.loading.start();

    $("iframe#contentArea").attr("src", "/logCounsel.do");
}

//본사, 지점  이미지 등록
function moveThumbnailUpload() {
    startKeepSession();
    
    top.co.loading.start();

    $("iframe#contentArea").attr("src", "/moveThumbnailUpload.do");
}

