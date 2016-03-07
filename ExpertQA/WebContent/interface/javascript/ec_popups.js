/* power by jackNEss
* date: 2011-12-1
* ver 1.0
*/


function ec_popups() {

    //�������� start
    var option = {

        //�Ƿ��(����������)
        withBg: false,

        //������ɫ
        bgColor: "#000",

        //����͸����
        bgOpacity: 0.5,

        //����id
        bg_id: "jackness_bg" + Math.random(0, 999),

        //�������
        zIndex: 10000,

        //�����ƶ����ܶ���
        moveArea: null,

        //��������
        transition: 200,

        //�Ƿ���ҳ�����
        isFixed: true,

        //�رհ�ť����
        closeBtn: null,

        //ÿ֡����ʱ����
        interval: 40,

        screenLeft: 0,

        screenTop: 0,

        //�����㻺������
        dastance: 20
    }
    //��������  end

    var _outset, _targetElement;
    var _bg;
    var _op;
    var _screenLeft, _screenTop;
    var _resizeKey, scrollkey;
    var dc = document;

    arguments[0] ? _targetElement = easy_switch(arguments[0]) : "";
    arguments[1] ? _op = arguments[1] : "";

    function getCssValue(elm, attribute) {
        try {
            return elm.currentStyle ? elm.currentStyle[attribute] : document.defaultView.getComputedStyle(elm, false)[attribute];
        }
        catch (e) {
            return false;
        }
    }

    function addEvent(elm, type, func) {
        if (elm.attachEvent) {
            elm.attachEvent("on" + type, _addEvent);
        }
        else if (elm.addEventListener) {
            elm.addEventListener(type, _addEvent, false);
        }

        function _addEvent(e) {
            func.call(elm, e);
        }

        return _addEvent;
    }

    function removeEvent(elm, type, func) {
        if (elm.detachEvent) {
            elm.detachEvent("on" + type, func);
        }
        else if (elm.removeEventListener) {
            elm.removeEventListener(type, func, false);
        }
    }


    function isIE6() {
        if (window.XMLHttpRequest) {
            return false;
        }
        else {
            return true;
        }
    }

    function easy_switch(elm) {
        if (typeof elm == "string") {
            var strs = elm.split(" ");
            var targetElements = [document.body];
            for (var i = 0; i < strs.length; i++) {
                if (!targetElements) { return false; }
                var flagGroups = new Array();

                for (var j = 0; j < targetElements.length; j++) {

                    var datasource = typeSwitcher(targetElements[j], strs[i]);
                    if (!datasource) { return false; }
                    if (!datasource.length) {
                        if (datasource) {
                            flagGroups.push(datasource);
                        }
                    }
                    else {

                        for (var k = 0; k < datasource.length; k++) {
                            if (datasource[k]) {
                                flagGroups.push(datasource[k])
                            }
                        }
                    }

                }
                targetElements = flagGroups;
            }
            if (targetElements.length == 1) { return targetElements[0] }
            else { return targetElements; }
        }
        else {
            return elm;
        }
        function typeSwitcher(elm, str) {

            if (str.substring(0, 1) == "#") {
                return document.getElementById(str.substring(1, str.length))
            }
            else if (str.substring(0, 1) == ".") {
                var flag = elm.getElementsByTagName("*");
                var results = [];
                var classStr = str.substring(1, str.length);
                var classNames;
                for (var i = 0; i < flag.length; i++) {
                    classNames = flag[i].className.split(" ");

                    for (var j = 0; j < classNames.length; j++) {
                        if (classStr == classNames[j]) {
                            results.push(flag[i]);
                        }
                    }
                }
                return results;
            }
            else {
                var result = elm.getElementsByTagName(str)
                if (result.length > 0) {
                    return result;
                }
                else {
                    return false;
                }
            }
        }
    }

    //��ȡ����λ��,����x,yֵ ��2�������Ҫ�����document �п����� iframe �ĸ���ҳ��
    function getElmPosition(elm) {
        var contentDocument = document;
        arguments[1] ? contentDocument = arguments[1] : "";
        var _x = elm.offsetLeft;
        var _y = elm.offsetTop;

        if (getCssValue(elm, "position") == "fixed") {

            _x += contentDocument.documentElement.scrollLeft || contentDocument.body.scrollLeft;
            _y += contentDocument.documentElement.scrollTop || contentDocument.body.scrollTop;

        }

        while (elm = elm.offsetParent) {
            _x += elm.offsetLeft || 0;
            _y += elm.offsetTop || 0;
        }
        return {
            x: _x,
            y: _y
        }
    }

    //�����˶�
    function inertia_Motion(So, St, T) {
        var S = Math.abs(St - So);
        var a = S / Math.pow(T / 2, 2);
        var Vt = a * T / 4;


        return {
            Sn: function (Tn) {
                var _Sn;
                Tn < T / 2 ? (
					_Sn = So + a * Math.pow(Tn, 2) / 2 * (parseInt((St - So) / Math.abs(St - So)) || 0)
				) : (
					Tn < T ? (
						_Sn = So + (a * Math.pow(T / 2, 2) - a * Math.pow(T - Tn, 2) / 2) * (parseInt((St - So) / Math.abs(St - So)) || 0)
					) : (
						_Sn = St
					)
				);

                return _Sn;
            },
            Vn: function (Tn) {
                var _Vn;
                Tn < T / 2 ? (
					_Vn = a * Tn / 2
				) : (
					Tn < T ? (
						_Vn = Vt - a * (Tn - T / 2) / 2
					) : (
						_Vn = 0
					)
				);
                return _Vn;
            }
        }
    }

    function areaReset() {
        // _targetElement reset
        _targetElement.style.cssText += ";position:relative; top:0; left:0; display:block; margin:0;";

        // _outset reset
        _outset = dc.createElement("outset");
        _outset.style.cssText = "position:" + (option.isFixed && !isIE6() ? "fixed" : "absolute") + "; left:0; top:0; z-index:" + (option.zIndex + 1) + "; display:none;";

        dc.body.appendChild(_outset);
        _outset.appendChild(_targetElement);

    }

    //����
    function slideFadeIn(elm, op, callback) {

        !op.interval ? op.interval = 20 : "";
        !op.transition ? op.transition = 300 : "";
        !op.distance ? op.distance = 20 : "";
        !op.screenTop ? op.screenTop = 0 : "";
        !op.screenLeft ? op.screenLeft = 0 : "";


        elm.style.display = "block";

        var elm_offsetWidth = elm.offsetWidth;
        var elm_offsetHeight = elm.offsetHeight;

        op.screenLeft = (dc.documentElement.clientWidth - elm_offsetWidth) / 2;
        op.screenTop = (dc.documentElement.clientHeight - elm_offsetHeight) / 2;

        if (!op.isFixed) {
            op.screenLeft += (dc.documentElement.scrollLeft || dc.body.scrollLeft);
            op.screenTop += (dc.documentElement.scrollTop || dc.body.scrollTop);
        }


        var elm_style = elm.style;
        elm_style.filter = "alpha(opacity=0)";
        elm_style.opacity = 0;

        var T = op.transition / op.interval;
        var Tn = 0;
        var opacity_So = 0;
        var opacity_St = 100;
        var opacity_Sn = 0;
        var screenTop_So = op.screenTop + op.distance;
        var screenTop_St = op.screenTop;
        var screenTop_Sn = op.screenTop + op.distance;

        (function slideFadeInEvent() {
           if( Tn < T ) {
				opacity_Sn = parseInt(inertia_Motion(opacity_So, opacity_St, T).Sn(Tn)),
				screenTop_Sn = inertia_Motion(screenTop_So, screenTop_St, T).Sn(Tn),
				op.screenTop = screenTop_Sn,

				elm_style.filter = "alpha(opacity=" + opacity_Sn + ")",
				elm_style.opacity = opacity_Sn / 100,
				positionFix(elm, screenTop_Sn, op.screenLeft, op.isFixed),

				Tn++,
				setTimeout(slideFadeInEvent, op.interval)
            } else{
				elm_style.filter = "",
				elm_style.opacity = opacity_St / 100,
				op.screenTop = screenTop_St,
				positionFix(elm, screenTop_St, op.screenLeft, op.isFixed),

				typeof callback == "Function" ? callback() : ""
            }
        })();

    }

    //����
    function slideFadeOut(elm, op, callback) {

        !op.interval ? op.interval = 20 : "";
        !op.transition ? op.transition = 300 : "";
        !op.distance ? op.distance = 20 : "";
        !op.screenTop ? op.screenTop = 0 : "";
        !op.screenLeft ? op.screenLeft = 0 : "";

        elm.style.display = "block";

        var elm_offsetWidth = elm.offsetWidth;
        var elm_offsetHeight = elm.offsetHeight;

        var elm_style = elm.style;
        elm_style.filter = "alpha(opacity=100)";
        elm_style.opacity = 1;

        var T = op.transition / op.interval;
        var Tn = 0;
        var opacity_So = 100;
        var opacity_St = 0;
        var opacity_Sn = 100;
        var screenTop_So = op.screenTop;
        var screenTop_St = op.screenTop + op.distance;
        var screenTop_Sn = op.screenTop;

        (function slideFadeOutEvent() {
           if( Tn < T ){
				opacity_Sn = parseInt(inertia_Motion(opacity_So, opacity_St, T).Sn(Tn)),
				screenTop_Sn = inertia_Motion(screenTop_So, screenTop_St, T).Sn(Tn),
				op.screenTop = screenTop_Sn,

				elm_style.filter = "alpha(opacity=" + opacity_Sn + ")",
				elm_style.opacity = opacity_Sn / 100,
				positionFix(elm, screenTop_Sn, op.screenLeft, op.isFixed),

				Tn++,
				setTimeout(slideFadeOutEvent, op.interval)
           }else{
				elm_style.display = "none",
				elm_style.filter = "",
				elm_style.opacity = opacity_St / 100,
				op.screenTop = screenTop_St,
				positionFix(elm, screenTop_St, op.screenLeft, op.isFixed),
				typeof callback == "Function" ? callback() : ""
           }
        })();

    }

    //λ�õ���
    function positionFix(elm, screenTop, screenLeft, isFixed) {

        var elm_offsetWidth = elm.offsetWidth;
        var elm_offsetHeight = elm.offsetHeight;

        var elm_allowWidth, elm_allowHeight;

        if (isFixed) {

            elm_allowWidth = dc.documentElement.clientWidth;
            elm_allowHeight = dc.documentElement.clientHeight;

        }
        else {

            elm_allowWidth = dc.documentElement.scrollWidth;
            elm_allowHeight = dc.documentElement.scrollHeight;

        }

        screenTop > elm_allowHeight - elm_offsetHeight ? (
			screenTop = elm_allowHeight - elm_offsetHeight
		) : "";
        screenTop < 0 ? screenTop = 0 : "";


        screenLeft > elm_allowWidth - elm_offsetWidth ? (
			screenLeft = elm_allowWidth - elm_offsetWidth
		) : "";
        screenLeft < 0 ? screenLeft = 0 : "";

        /*-- ~>_<~ ��Ⱦ�Ұ� --*/
        option.screenLeft = screenLeft;
        option.screenTop = screenTop;
        /*--//~>_<~ ��Ⱦ�Ұ�--*/

        var elm_style = elm.style;
    
       if (isIE6() && isFixed) {
        		
			elm_style.top = (dc.body.scrollTop || dc.documentElement.scrollTop) + screenTop +"px",
			elm_style.left = (dc.body.scrollLeft || dc.documentElement.scrollLeft) + screenLeft + "px"
       } else{
			elm_style.top = screenTop + "px",
			elm_style.left = screenLeft + "px"
       }
    }

    //������ʾ
    function bgShow() {
        if (!_bg) {
            _bg = dc.createElement("div");
            _bg.id = option.bg_id;
            _bg.style.cssText = "position:absolute; left:0; top:0; z-index:" + option.zIndex + "; width:100%; height:" + dc.body.scrollHeight + "px; background:" + option.bgColor + "; opacity:" + option.bgOpacity + ";filter:alpha(opacity=" + (option.bgOpacity * 100) + ");";

        }
        dc.body.appendChild(_bg);
    }

    //��������
    function bgRemove() {
        if (!_bg) { return; }
        dc.body.removeChild(_bg);
    }

    //�����¼�
    function elmDragEvent() {
        var moveArea = option.moveArea;
        var target = _outset;
        var mousedownKey, mousemoveKey, mouseupKey;

        //mouseDownEvent
        mousedownKey = addEvent(moveArea, "mousedown", function (e) {
            e = e || window.event;

            var posX = e.clientX - option.screenLeft;
            var posY = e.clientY - option.screenTop;

            //mouseMoveEvent
            mousemoveKey = addEvent(dc, "mousemove", function (e) {

                option.screenLeft = e.clientX - posX;
                option.screenTop = e.clientY - posY;

                positionFix(target, option.screenTop, option.screenLeft, option.isFixed);

                //��ֹѡ��
                window.getSelection ? (
					window.getSelection().removeAllRanges()
				) : (
					document.selection.empty()
				);
            })




            //mouseUpEvent
            mouseupKey = addEvent(dc, "mouseup", function () {
                removeEvent(dc, "mousemove", mousemoveKey);
                removeEvent(dc, "mouseup", mouseupKey);
            })
        })


    }

    //��Ӹı��������Сʱ�������¼�
    function addResizeEvent() {
        var elm = _outset;
        var win = window;

        var elm_offsetWidth, elm_offsetHeight, elm_position;

        _resizeKey = addEvent(win, "resize", function () {
            if (!option.moveArea && option.isFixed) {
                elm_offsetWidth = elm.offsetWidth;
                elm_offsetHeight = elm.offsetHeight;

                option.screenLeft = (dc.documentElement.clientWidth - elm_offsetWidth) / 2;
                option.screenTop = (dc.documentElement.clientHeight - elm_offsetHeight) / 2;
            }
            positionFix(elm, option.screenTop, option.screenLeft, option.isFixed);


        })

        if (!isIE6()) { return; }
        _scrollKey = addEvent(win, "scroll", function () {
            positionFix(elm, option.screenTop, option.screenLeft, option.isFixed);

        })
    }

    //�Ƴ�ı��������Сʱ�������¼�
    function removeResizeEvent() {
        var elm = _outset;
        var win = window;
        removeEvent(win, "resize", _resizeKey);
        if (!isIE6()) { return; }
        removeEvent(win, "scroll", _scrollKey);
    }

    return {
        setOption: function (op) {
            typeof op.withBg == "boolean" ? option.withBg = op.withBg : "";
            typeof op.isIframe == "boolean" ? option.isIframe = op.isIframe : "";
            typeof op.isFixed == "boolean" ? option.isFixed = op.isFixed : "";

            op.bgColor ? option.bgColor = op.bgColor : "";
            op.bgOpacity ? option.bgOpacity = op.bgOpacity : "";
            op.zIndex ? option.zIndex = op.zIndex : "";
            op.bg_id ? option.bg_id = op.bg_id : "";

            op.moveArea ? option.moveArea = easy_switch(op.moveArea) : "";
            op.closeBtn ? option.closeBtn = easy_switch(op.closeBtn) : "";

            op.transition ? option.transition = parseInt(op.transition) : "";
            op.interval ? option.interval = parseInt(op.interval) : "";
            op.distance ? option.distance = parseInt(op.distance) : "";

            return this;
        },

        popupShow: function (callback) {
            if (option.withBg) {
                bgShow();
            }
            slideFadeIn(_outset, option, callback);
            addResizeEvent();
            return this;
        },

        popupHide: function (callback) {
            if (option.withBg) {
                bgRemove();
            }
            slideFadeOut(_outset, option, callback);
            removeResizeEvent();
            return this;
        },

        init: function () {
            if (!_targetElement) { return; }
            if (_op) { this.setOption(_op); }

            areaReset();
            if (option.closeBtn) {
                addEvent(option.closeBtn, "click", this.popupHide);
            }
            if (option.moveArea) {
                elmDragEvent();
            }

        }
    }
}