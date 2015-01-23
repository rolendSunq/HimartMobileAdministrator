/**
 * 공통 Script
 *
 * @author	SeoJoHoon
 */

$(document).ready(function() {
    if ( typeof initialize == "function") {
        initialize();
    }
});

$(window).load(function() {
    top.co.loading.stop();
});

var co = {};

co.data = {
    formToObj : function(formId) {
        var obj = {};
        var sArr = $("#" + formId).serializeArray();

        $.each(sArr, function() {
            obj[this.name] = this.value;
        });

        return obj;
    },

    /**
     * NULL 인경우 빈 값 리턴
     */
    null2Blank : function(data) {
        if (data == null || data == undefined) {
            return '';
        }
        else {
            return data;
        }
    },

    /**
     * 데이터 포맷팅
     * @use	co.data.format.DATE("값");
     */
    format : {
        // 날짜	2013-10-01
        DATE : function(data) {
            if (data == null || data == '') {
                return "";
            }
            var fData = data.replace('/[^0-9]/g', "");

            if (fData.length == 8) {
                return fData.substr(0, 4) + "-" + fData.substr(4, 2) + "-" + fData.substr(6, 2);
            }
            else if (fData.length == 6) {
                return fData.substr(0, 4) + "-" + fData.substr(4, 2);
            }
            else {
                return fData;
            }
        },

        // 시간	12:30:30
        TIME : function(data) {
            if (data == null || data == '') {
                return "";
            }
            var fData = data.replace('/[^0-9]/g', "");

            if (fData.length == 6) {
                return fData.substr(0, 2) + ":" + fData.substr(2, 2) + ":" + fData.substr(4, 2);
            }
            else if (fData.length == 4) {
                return fData.substr(0, 2) + ":" + fData.substr(2, 2);
            }
            else {
                return fData;
            }
        },

        // 원화	5,000,000
        WON : function(data) {
            if (data == null || data == '') {
                return 0;
            }
            return co.utility.dispWON(data);
        },

        // 주민등록번호	123456-1******
        JUMIN_NO : function(data) {
            if (data.length < 13) {
                return data;
            }

            var rData = "";

            rData += data.substring(0, 6);
            rData += "-";
            rData += data.substring(6, 7);
            for (var i = 7; i < data.length; i++) {
                rData += "*";
            }

            return rData;
        },

        // 사업자번호 12345*****
        COMPANY_NO : function(data) {
            if (data.length < 10) {
                return data;
            }

            var rData = "";

            rData += data.substring(0, 5);
            for (var i = 5; i < data.length; i++) {
                rData += "*";
            }

            return rData;
        },

        // 주민/사업자번호
        REALNO : function(data) {
            if (data == null || data == '') {
                return "";
            }

            if (data.length == "13") {
                return co.data.format.JUMIN_NO(data);
            }

            if (data.length == "10") {
                return co.data.format.COMPANY_NO(data);
            }

            return data;
        },

        // 전체 마스킹 (예: 123 -> ***)
        MASKING : function(data) {
            if (data == null || data == '') {
                return "";
            }
            var rData = "";

            for (var i = 0; i < data.length; i++) {
                rData += "*";
            }
            return rData;
        },

        // 일부 마스킹 (예: 123 -> ***)
        MASKING_NUM : function(data, num) {
            if (data == null || data == '') {
                return "";
            }
            var rData = "";

            for (var i = 0; i < data.length; i++) {
                if (i >= num - 1) {
                    rData += "*";
                }
                else {
                    rData += data[i];
                }
            }
            return rData;
        },

        // 계좌번호 (예: 첫3자리와 끝1자리를 제외한 계좌번호012********3)
        ACCOUNT : function(data) {
            if (data == null || data == '') {
                return "";
            }

            if (data.length < 3) {
                return data;
            }

            var rData = "";
            var fData = data.replace('/[^0-9]*/g', "").trim();

            rData += fData.substring(0, 3);
            for (var i = 3; i < fData.length - 1; i++) {
                rData += "*";
            }
            rData += fData.substring(fData.length - 1);
            return rData;
        },

        // 소수점 표시
        POINT : function(data, digits) {
            if (data == null || data == '') {
                return "";
            }
            var rData = 0;
            var n = parseFloat(data);

            if (digits >= 0) {
                rData = parseFloat(n.toFixed(digits));
                // 소수부 반올림
            }
            else {
                digits = Math.pow(10, digits);
                // 정수부 반올림
                var t = Math.round(n * digits) / digits;

                rData = parseFloat(t.toFixed(0));
            }

            if (rData.toString().match(/^[0-9]+$/)) {
                rData = rData + ".0";

                for (var i = 1; i < digits; i++) {
                    rData = rData + "0";
                }
            }

            return rData;

        },

        POST : function(data) {
            if (data == null || data == '') {
                return "";
            }

            if (data.length < 6) {
                return data;
            }

            var rData = "";

            rData += data.substring(0, 3);
            rData += "-";
            rData += data.substring(3);

            return rData;
        },

        TEL : function(data) {
            if (data == null || data == '') {
                return "";
            }

            var rData = data.replace(/[^0-9]/g, '');

            if (rData.length < 9) {
                return data;
            }

            return rData.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/, "$1-$2-$3");
        }
    },

    validate : {
        // 최대바이트 체크
        maxByte : function(data, maxLen) {
            return (maxLen < co.utility.getBytes(data));
        }
    },

    /**
     * 문자열 치환
     */
    replaceAll : function(str, searchStr, replaceStr) {
        try {
            while (str.indexOf(searchStr) != -1) {
                str = str.replace(searchStr, replaceStr);
            }
            return str;
        }
        catch(e) {
        }
    }
};

/**********************************************************************
 * 팝업 관련
 **********************************************************************/
co.popup = {
    _document : null,
    callback : null,
    titleHeight : 30,
    layerLeft : 0,
    layerTop : 0,
    open : function(_document, title, url, layerWidth, layerHeight) {
        this._document = _document;

        // iframe이 존재하지 않으면 생성
        if ($("#popupDiv").length <= 0) {
            $("body").append("<div id='popupDiv'><div id='title'><div id='titleText'></div><img id='closeIcon' src='/resources/assets/image/icon_close_popup.png'/></div><iframe id='popupFrame' src='about:blank' frameborder='0'></iframe></div>");

            $("#closeIcon").on("click", function() {
                co.popup.close();
            });
        }

        this.resize(layerWidth, layerHeight);

        top.co.loading.start();

        $("#titleText").html(title);

        $("#popupFrame").attr("src", url);

        // 기본 스타일 변경
        $.blockUI.defaults.css = {
            padding : 0,
            margin : 0,
            left : this.layerLeft,
            top : this.layerTop,
            cursor : 'wait'
        };

        $.blockUI.defaults.overlayCSS = {
            backgroundColor : '#000',
            opacity : 0.5,
            cursor : 'wait'
        };
        
        $.blockUI.defaults.baseZ = 1000;
        
        // 실제 팝업
        $.blockUI({
            message : document.getElementById("popupDiv"),
            fadeIn : 0,
            bindEvents : false,
            centerX : false,
            centerY : false
        });

        $("#popupDiv").show();
    },

    resize : function(layerWidth, layerHeight) {
        // 최대 팝업 크기에 따른 크기 조정
        if ($(window).width() < layerWidth) {
            layerWidth = $(window).width();
        }

        if ($(window).height() < layerHeight + this.titleHeight) {
            layerHeight = $(window).height() - this.titleHeight;
        }

        // 최소 팝업 크기에 따른 크기 조정
        if (layerWidth < 250) {
            layerWidth = 250;
        }

        if (layerHeight < 130) {
            layerHeight = 130;
        }

        this.layerLeft = Math.round(($(window).width() - layerWidth) / 2);
        this.layerTop = Math.round(($(window).height() - layerHeight - this.titleHeight) / 2);

        if (this.layerLeft < 0) {
            this.layerLeft = 0;
        }

        if (this.layerTop < 0) {
            this.layerTop = 0;
        }

        if ($("#popupDiv").parent()) {
            $("#popupDiv").parent().css("left", this.layerLeft);
            $("#popupDiv").parent().css("top", this.layerTop);
        }

        $("#popupDiv").width(layerWidth);
        $("#popupDiv").height(layerHeight);
    },

    close : function() {
        if ($("#popupDiv").length > 0) {
            $("#popupFrame").attr("src", "");
            $("#popupDiv").hide();
        }

        $.unblockUI({
            message : document.getElementById("popupDiv"),
            fadeOut : 0
        });
    }
};

/**********************************************************************
 * 로딩바 관련
 **********************************************************************/
co.loading = {
    init : function() {
        if ($("#loadingDiv").length <= 0) {
            $("body").append("<div id='loadingDiv'><img src='/resources/assets/image/loading.gif'/></div>");
        }
    },
    
    start : function() {
        this.init();
       
        var layerWidth = 66;
        var layerHeight = 66;

        var layerLeft = Math.round(($(window).width() - layerWidth) / 2);
        var layerTop = Math.round(($(window).height() - layerHeight) / 2);
        
        // 기본 스타일 변경
        $.blockUI.defaults.css = {
            padding : 0,
            margin : 0,
            left : layerLeft,
            top : layerTop,
            cursor : 'wait'
        };

        $.blockUI.defaults.overlayCSS = {
            backgroundColor : '#000',
            opacity : 0.0,
            cursor : 'wait'
        };
        
        $.blockUI.defaults.baseZ = 2000;
            
        $("#loadingDiv").css("left", layerLeft);
        $("#loadingDiv").css("top", layerTop);

        $("#loadingDiv").width(layerWidth);
        $("#loadingDiv").height(layerHeight);

        $("#container").block({
            message: $("#loadingDiv")
        });

        $("#loadingDiv").show();
    },

    stop : function() {
        this.init();

        $("#loadingDiv").hide();

        $("#container").unblock({
            message : $("#loadingDiv"),
            fadeOut : 0
        });
    }
};

function requestAjax(url, params, successCallback) {
    top.co.loading.start();

    $.ajax({
        url : url,
        data : params,
        type : "POST",
        success : function(msg) {
            top.co.loading.stop();

            if ( typeof successCallback == "function") {
                successCallback(msg);
            }
        },
        failure : function(jqXHR, textStatus) {
            top.co.loading.stop();

            alert("알 수 없는 오류가 발생하였습니다.");
        }
    });
}

/**********************************************************************
 * 공통 유틸리티
 **********************************************************************/
co.utility = {
    /**
     * 오늘 날짜
     */
    today : function(formatChar) {
        var date = new Date();

        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();

        if (("" + month).length == 1) {
            month = "0" + month;
        }
        if (("" + day).length == 1) {
            day = "0" + day;
        }

        if (formatChar == "han") {
            return year.toString() + "년 " + month.toString() + "월 " + day.toString() + "일";
        }
        else {
            return year.toString() + formatChar + month.toString() + formatChar + day.toString();
        }
    },

    /**
     * 오늘 요일
     */
    getTodayWeek : function() {
        return new Date().getDay();
    },

    /**
     * 요일 한글명으로 반환
     */
    getKorWeek : function(day) {
        var k = "";
        if (day == "0") {
            k = "일";
        }
        else if (day == "1") {
            k = "월";
        }
        else if (day == "2") {
            k = "화";
        }
        else if (day == "3") {
            k = "수";
        }
        else if (day == "4") {
            k = "목";
        }
        else if (day == "5") {
            k = "금";
        }
        else if (day == "6") {
            k = "토";
        }

        return k;
    },

    /**
     * 특정 월의 마지막 날짜
     *
     * @return day
     */
    getLastDay : function(year, month) {
        return new Date(year, month, 0).getDate();
    },

    /**
     * 특정 일의 요일
     *
     * @return 0:일요일 ~ 6:토요일
     */
    getWeek : function(year, month, day) {
        return new Date(year + "/" + month + "/" + day).getDay();
    },

    /**
     * 특정 월이 몇 주인지 조회
     */
    getWeekCount : function(year, month) {
        var wCount = 0;
        var lastDate = this.getLastDay(year, month);

        for (var day = 1; day <= lastDate; day++) {
            // 매월 1일은 요일과 무관하게 1주차
            if (day == 1) {
                wCount++;
                continue;
            }

            // 매월 1일 이후에는 일요일마다 1주씩 증가
            if (this.getWeek(year, month, day) == 0) {
                wCount++;
            }
        }
        return wCount;
    },

    /**
     * 특정 일이 몇 주차인지 조회
     */
    getWeekDay : function(year, month, xday) {
        var wCount = 0;
        var lastDate = this.getLastDay(year, month);

        for (var day = 1; day <= lastDate; day++) {
            // 매월 1일은 요일과 무관하게 1주차
            if (day == 1) {
                wCount++;

                if (xday == day) {
                    break;
                }
                else {
                    continue;
                }
            }

            // 매월 1일 이후에는 일요일마다 1주씩 증가
            if (this.getWeek(year, month, day) == 0) {
                wCount++;
            }

            if (xday == day) {
                break;
            }
        }
        return wCount;
    },

    /**
     * 특정일의 이전 날짜 조회
     */
    getPrevDate : function(date, formatChar) {
        return this.getDate("prev", date, formatChar);
    },

    /**
     * 특정일의 다음 날짜 조회
     */
    getNextDate : function(date, formatChar) {
        return this.getDate("next", date, formatChar);
    },

    /**
     * 특정일의 이전달 조회
     */
    getPrevMonth : function(date, formatChar) {
        return this.getDate("prevMonth", date, formatChar);
    },

    /**
     * 특정일의 다음달 조회
     */
    getNextMonth : function(date, formatChar) {
        return this.getDate("nextMonth", date, formatChar);
    },

    /**
     * 특정일의 이전년도 조회
     */
    getPrevYear : function(date, formatChar) {
        return this.getDate("prevYear", date, formatChar);
    },

    /**
     * 특정일의 다음년도 조회
     */
    getNextYear : function(date, formatChar) {
        return this.getDate("nextYear", date, formatChar);
    },

    /**
     * 특정일의 날짜 조회
     */
    getDate : function(type, date, formatChar) {

        var tyear = date.substring(0, 4);
        var tmonth = date.substring(4, 6);
        var tday = date.substring(6);

        var date = new Date(tyear + "/" + tmonth + "/" + tday);

        if (type == "prev") {
            date.setDate(date.getDate() - 1);
        }
        else if (type == "next") {
            date.setDate(date.getDate() + 1);
        }
        else if (type == "nextMonth") {
            date.setMonth(date.getMonth() + 1);
        }
        else if (type == "prevMonth") {
            date.setMonth(date.getMonth() - 1);
        }
        else if (type == "nextYear") {
            date.setYear(date.getFullYear() + 1);
        }
        else if (type == "prevYear") {
            date.setYear(date.getFullYear() - 1);
        }

        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();

        if (("" + month).length == 1) {
            month = "0" + month;
        }
        if (("" + day).length == 1) {
            day = "0" + day;
        }

        return year.toString() + formatChar + month.toString() + formatChar + day.toString();
    },

    /**
     * 날짜 비교	date1 - date2
     */
    compareDate : function(date1, date2, formatChar) {
        var aDate1 = {};
        var aDate2 = {};

        if (formatChar == '') {
            aDate1[0] = date1.substring(0, 4);
            aDate1[1] = date1.substring(4, 6);
            aDate1[2] = date1.substring(6, 8);
            aDate2[0] = date2.substring(0, 4);
            aDate2[1] = date2.substring(4, 6);
            aDate2[2] = date2.substring(6, 8);
        }
        else {
            aDate1 = date1.split(formatChar);
            aDate2 = date2.split(formatChar);
        }
        var date1 = new Date(aDate1[0], aDate1[1], aDate1[2]);
        var date2 = new Date(aDate2[0], aDate2[1], aDate2[2]);
        var days = Math.ceil((date1 - date2) / 24 / 60 / 60 / 1000);

        return days;
    },

    /**
     * 원 단위 표시
     *
     * @사용 : co.utility.dispWON("값")
     */
    dispWON : function(str) {
        var won = "";
        var pattern = new RegExp("(-?[0-9]+)([0-9]{3})");

        if ( typeof str == "number") {
            won = str.toString();
        }
        else {
            won = str;
        }
        won = this.removeComma(won.trim());

        while (pattern.test(won)) {
            won = won.replace(pattern, "$1,$2");
        }

        return won;
    },

    /**
     * ,(콤마) 삭제
     */
    removeComma : function(str) {
        var str_l = "";

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(str.length - i - 1) != ",") {
                str_l = str.charAt(str.length - i - 1) + str_l;
            }
        }

        return str_l;
    },

    /**
     * 비숫자형 문자 제거
     */
    removeText : function(str) {
        return str.replace(/[^0-9]/g, '');
    },

    /**
     * 비숫자형 문자 제거
     */
    removeText4Number : function(str) {
        return str.replace(/[^0-9]/g, '').replace(/^0+([0-9]*)$/, "$1");
    },

    /**
     * 바이트 길이
     */
    getBytes : function(data) {
        var p, len = 0;

        for ( p = 0; p < data.length; p++) {
            (data.charCodeAt(p) > 255) ? len += 2 : len++;
        }
        console.log("[getBytes]	" + len);
        return len;
    }
};

/**********************************************************************
 * input text에서 특정문자만 입력받기
 **********************************************************************/
(function($) {
    /*
     * removeText와 dispWON를 동시에
     */
    $.fn.formatedNumber = function() {
        $(this).each(function() {
            $(this).css("text-align", "right");

            $(this).val(co.utility.dispWON(co.utility.removeText4Number($(this).val())));

            $(this).keypress(function(e) {
                if (e.keyCode != 8 && !(e.keyCode >= 48 && e.keyCode <= 57)) {
                    e.preventDefault();
                }
                else if ($(this).val().length >= parseInt($(this).attr("data-max"), 10)) {
                    e.preventDefault();
                }
            });

            $(this).keyup(function(e) {
                $(this).val(co.utility.dispWON(co.utility.removeText4Number($(this).val())));
            });
        });
    };

    /*
     * removeText만
     */
    $.fn.onlyNumber = function() {
        $(this).each(function() {
            $(this).val(co.utility.removeText($(this).val()));

            $(this).keypress(function(e) {
                if (e.keyCode != 8 && !(e.keyCode >= 48 && e.keyCode <= 57)) {
                    e.preventDefault();
                }
                else if ($(this).val().length >= parseInt($(this).attr("data-max"), 10)) {
                    e.preventDefault();
                }
            });

            $(this).keyup(function(e) {
                $(this).val(co.utility.removeText($(this).val()));
            });
        });
    };
})(jQuery);

/**********************************************************************
 * 체크박스의 전체선택/해제
 **********************************************************************/
function setupCheckbox(allObjId, chkObjName) {
    $("#" + allObjId).on("click", function() {
        if ($(this).prop("checked") == true) {
            $("input[type='checkbox'][name='" + chkObjName + "']").prop("checked", true);
        }
        else {
            $("input[type='checkbox'][name='" + chkObjName + "']").prop("checked", false);
        }
    });

    $("input[type='checkbox'][name='" + chkObjName + "']").on("click", function() {
        if ($(this).prop("checked") == true) {
            $("#" + allObjId).prop("checked", true);

            $("input[type='checkbox'][name='" + chkObjName + "']").each(function() {
                if ($(this).prop("checked") == false) {
                    $("#" + allObjId).prop("checked", false);
                }
            });
        }
        else {
            $("#" + allObjId).prop("checked", false);
        }
    });
}