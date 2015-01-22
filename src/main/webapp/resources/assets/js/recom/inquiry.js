/**
 * 본사추천 등록 관련 자바스크립트
 */
function initialize() {
    // 조회
    $("#btnLookup").on("click", function() {
        // 통신사
        if ($("input[name=mbcomCd]").val() == "") {
            alert("통신사를 선택하세요.");
            return false;
        }

        // 차수
        if ($("input[name=mobDgr]").val() == "") {
            alert("차수를 확인하세요.");
            return false;
        }
        
        top.co.loading.start();
        
        with (frmSearch) {
            pageNo.value = "1";

            submit();
        }
    });
    
    // 판매가 클릭 시
    $("td.curPointer").on("click", function() {
        if ($(this).find("input[type=hidden]").val() == "" && $(this).find("input[type=hidden]").attr("title") != "0") {
            $(this).find("input[type=hidden]").val($(this).find("input[type=hidden]").attr("title"));
            $(this).css("background-color", "#0061a1").css("color", "#ffffff");
        } else {
            $(this).find("input[type=hidden]").val("");
            $(this).css("background-color", "").css("color", "#585858");
        }
    });
    
    // 저장 시
    $("#btnSave").on("click", function() {
        if ($("#frmSave input[name=regDt]").length <= 0) {
            alert("조회된 자료가 존재하지 않습니다.");
        } else {
            if ($("#frmSave input[type=hidden][title]").filter(function() { return ($(this).val() != ""); }).length <= 0) {
                alert("저장할 자료가 존재하지 않습니다.");
            } else {
                top.co.loading.start();
                
                frmSave.submit();        
            }
        }
    });
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
    top.co.loading.start();
    
    with (frmSearch) {
        pageNo.value = no;

        submit();
    }
}

/**
 * 통신사 검색
 */
function popupMbcom() {
    co.popup.callback = setSelectMbcom;

    co.popup.open($(document), "통신사 검색", "/commonMbcomList.do?allowAll=N", 500, 530);
}

function setSelectMbcom(cd, nm) {
    if ($("input[name=mbcomCd]").val() == cd) {
        return false;
    }

    $("input[name=mbcomCd]").val(cd);
    $("#mbcomCdNm").val(nm);

    $("#mobDgr").val("");

    // 최종차수 조회
    var params = "mbcomCd=" + cd;

    requestAjax("/recomHofficeRegMobDgr.do", params, callbackMobDgr);
}

/**
 * 최종차수 조회 결과 세팅
 */
function callbackMobDgr(data) {
    if (data.mobDgr == "-1") {
        return false;
    }

    $("#mobDgr").val(data.mobDgr);
}

/**
 * 저장 성공시
 */
function callbackSaveSuccess(msg) {
    top.co.loading.stop();
    
    alert(msg);

    // 목록화면 조회
    $(parent.co.popup._document).find("#regDtCond").val($("#regDt").val());
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
