/**
 * 이미지 관련 자바스크립트
 */
function initialize() {
    // 저장
    $("#btnSave").on("click", function() {
        if ($("input#imgCfCd").val() == "" || $("input#prdNicNm").val() == "" || $("input#accPrdCdNm").val() == "" || $("input#imgPstCfCd").val() == "" || $("input#imgOrigFileNm").val() == "") {
            alert("저장할 이미지를 선택하세요.");
            return false;
        }

        top.co.loading.start();

        // 이미지 저장
        $("input[type='submit'][name='submitMod']").click();
    });
}

function selectFile(obj) {
    $("#imgOrigFile").click();
}

function changeFile(obj) {
    var filepath = $(obj).val();

    if (filepath.match(/.*[.](jpeg|jpg|png)$/gi) == null) {
        $("#imgOrigFile").after($("#imgOrigFile").clone(true)).remove();
        alert("PNG. JPG 이미지만 등록할 수 있습니다.");
        return false;
    }

    $("#imgOrigFileNm").val(filepath.replace(/^.*(\\|\/)/g, ""));
}

/**
 * 저장 성공시
 */
function callbackSaveSuccess(msg) {
    top.co.loading.stop();
    
    alert(msg);

    $(parent.co.popup._document).find("#frmImage").submit();

    parent.co.popup.close();
}

/**
 * 저장 실패시
 */
function callbackSaveFailure(msg) {
    top.co.loading.stop();
    
    alert(msg);
}
