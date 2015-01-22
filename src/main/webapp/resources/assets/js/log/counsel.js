/**
 * 상담로그 관련 자바스크립트
 */
function initialize() {
    // 달력
    $("input[name='cnslDtFrom']").datepicker({
        dateFormat : "yy-mm-dd"
    });

    $("#btnCnslDtFrom").on("click", function() {
        $("input[name='cnslDtFrom']").focus();
        return false;
    });

    $("input[name='cnslDtTo']").datepicker({
        dateFormat : "yy-mm-dd"
    });

    $("#btnCnslDtTo").on("click", function() {
        $("input[name='cnslDtTo']").focus();
        return false;
    });

    // 조회
    $("#btnLookup").on("click", function() {
        if ($("input[name='cnslDtFrom']").val() == "") {
            alert("상담시작일자를 입력하세요.");
            return false;
        }

        if ($("input[name='cnslDtTo']").val() == "") {
            alert("상담종료일자를 입력하세요.");
            return false;
        }

        if (co.utility.compareDate($("input[name='cnslDtFrom']").val(), $("input[name='cnslDtTo']").val(), "-") > 0) {
            alert("상담시작일자는 상담종료일자보다 이전이어야 합니다.");
            return false;
        }

        if (co.utility.compareDate($("input[name='cnslDtFrom']").val(), $("input[name='cnslDtTo']").val(), "-") < -31) {
            alert("최대 31일간의 상담내역만 조회가 가능합니다.");
            return false;
        }

        top.co.loading.start();

        with (frmLog) {
            pageNo.value = "1";

            action = "/logCounsel.do";

            submit();
        }
    });

    // 엑셀다운로드
    $("#btnExcel").on("click", function() {
        if ($("input[name='cnslDtFrom']").val() == "") {
            alert("상담시작일자를 입력하세요.");
            return false;
        }

        if ($("input[name='cnslDtTo']").val() == "") {
            alert("상담종료일자를 입력하세요.");
            return false;
        }

        if (co.utility.compareDate($("input[name='cnslDtFrom']").val(), $("input[name='cnslDtTo']").val(), "-") > 0) {
            alert("상담시작일자는 상담종료일자보다 이전이어야 합니다.");
            return false;
        }

        if (co.utility.compareDate($("input[name='cnslDtFrom']").val(), $("input[name='cnslDtTo']").val(), "-") < -31) {
            alert("최대 31일간의 상담내역만 엑셀다운로드가 가능합니다.");
            return false;
        }

        $.fileDownload("/logCounselExcel.do?" + $("#frmLog").serialize(), {
            httpMethod: "POST",
            prepareCallback: function () { console.log("prepareCallback"); top.co.loading.start(); },
            successCallback: function () { console.log("successCallback"); top.co.loading.stop(); },
            failCallback: function () { console.log("failCallback"); top.co.loading.stop(); }
        });
    });
}

/**
 * 통신사 검색
 */
function popupMbcom() {
    parent.co.popup.callback = setSelectMbcom;

    parent.co.popup.open($(document), "통신사 검색", "/commonMbcomList.do?allowAll=Y", 500, 530);
}

function setSelectMbcom(cd, nm) {
    if ($("input[name='mbcomCd']").val() == cd) {
        return false;
    }

    $("input[name='mbcomCd']").val(cd);
    $("#mbcomCdNm").val(nm);
}

/**
 * 제조사 검색
 */
function popupMkr() {
    parent.co.popup.callback = setSelectMkr;

    parent.co.popup.open($(document), "제조사 검색", "/commonMkrList.do?allowAll=Y", 500, 530);
}

function setSelectMkr(cd, nm) {
    if ($("input[name='mkrId']").val() == cd) {
        return false;
    }

    $("input[name='mkrId']").val(cd);
    $("#mkrNm").val(nm);

    if ($("input[name='mkrId']").val() == "") {
        $("input[name='cnslPrdCd']").val("");
        $("input[name='cnslPrdCdNm']").val("");
    }
}

/**
 * 모델코드 검색
 */
function popupCnslPrd() {
    if ($("input[name='mkrId']").val() == "") {
        alert("제조사를 선택하세요.");
        return false;
    }

    parent.co.popup.callback = setSelectCnslPrd;

    var params = "&schUpCd=" + $("input[name='mkrId']").val();

    parent.co.popup.open($(document), "모델코드 검색", "/commonPrdCdList.do?allowAll=Y" + params, 500, 530);
}

function setSelectCnslPrd(cd, nm) {
    if ($("input[name='cnslPrdCd").val() == cd) {
        return false;
    }

    $("input[name='cnslPrdCd']").val(cd);
    $("input[name='cnslPrdCdNm']").val(nm);
}

/**
 * 지점 검색
 */
function popupBrch() {
    parent.co.popup.callback = setSelectBrch;

    parent.co.popup.open($(document), "지점 검색", "/commonBrchList.do?allowAll=Y", 500, 530);
}

function setSelectBrch(cd, nm) {
    if ($("input[name='brchId']").val() == cd) {
        return false;
    }

    $("input[name='brchId']").val(cd);
    $("#brchIdNm").val(nm);

    if ($("input[name='brchId']").val() == "") {
        $("input[name='ivtmnId']").val("");
        $("#ivtmnIdNm").val("");
    }
}

/**
 * 권유자 검색
 */
function popupIvtmn() {
    if ($("input[name='brchId']").val() == "") {
        alert("지점을 선택하세요.");
        return false;
    }

    parent.co.popup.callback = setSelectIvtmn;

    var params = "&schUpCd=" + $("input[name='brchId']").val();

    parent.co.popup.open($(document), "권유자 검색", "/commonIvtmnList.do?allowAll=Y" + params, 500, 530);
}

function setSelectIvtmn(cd, nm) {
    if ($("input[name='ivtmnId']").val() == cd) {
        return false;
    }

    $("input[name='ivtmnId']").val(cd);
    $("#ivtmnIdNm").val(nm);
}

/**
 * 조회한 목록의 페이지별 조회
 */
function goPage(no) {
    top.co.loading.start();
    
    with (frmLog) {
        pageNo.value = no;

        submit();
    }
}