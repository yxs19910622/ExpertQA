if (typeof (QZFL) == "undefined" || !QZFL) {
	var QZFL;
	var $e;
	if (typeof (QZONE) == "object") {
		QZFL = QZONE
	} else {
		window.QZONE = QZFL = {}
	}
	QZFL.version = "2.0.5.4";
	QZFL._qzfl = true
}
QZFL.emptyFn = function() {
};
QZFL.userAgent = (function() {
	var n, x, w, g, f, m, u, c, q, p, k, y = false, d = false, h = navigator.userAgent, e = /(?:MSIE.(\d+\.\d+))|(?:(?:Firefox|GranParadiso|Iceweasel|Minefield).(\d+\.\d+))|(?:Opera.(\d+\.\d+))|(?:AppleWebKit.(\d+(?:\.\d+)?))/, r = /(Windows.*?;)|(Mac OS X.*?;)/, j = /Windows.+?(\d+\.\d+)/, z = /AdobeAIR/, v = /Chrome.(\d+\.\d+)/, a = /Version\/(\d+(?:\.\d+)?)/, b = e
			.exec(h), i = r.exec(h);
	if (b) {
		x = b[1] ? parseFloat(b[1], 10) : NaN;
		w = b[2] ? parseFloat(b[2], 10) : NaN;
		g = b[3] ? parseFloat(b[3], 10) : NaN;
		m = b[4] ? parseFloat(b[4], 10) : NaN;
		p = f = k = NaN;
		if (m) {
			if (n = z.exec(h)) {
				p = 1
			} else {
				if (n = a.exec(h)) {
					if (n.length > 1) {
						f = parseFloat(n[1], 10)
					} else {
						f = 1
					}
				} else {
					if (n = v.exec(h)) {
						if (n.length > 1) {
							k = parseFloat(n[1], 10)
						} else {
							k = 1
						}
					}
				}
			}
		}
	} else {
		x = w = g = f = m = p = k = NaN;
		if (typeof ActiveXObject == "function") {
			x = (/Trident\/4\.0/i.test(navigator.appVersion)) ? 8 : 8
					- (typeof XDomainRequest == "object" ? 0 : 1)
					- (typeof XMLHttpRequest == "object" ? 0 : 1)
		} else {
			if (/AppleWebKit\/\d+\.\d+/i.test(navigator.appVersion)) {
				m = parseFloat(navigator.appVersion.replace(
						/^[\s\S]*?AppleWebKit.(\d+\.\d+)[\s\S]*$/i, "$1"));
				if (typeof openDatabase == "function") {
					f = parseFloat(navigator.appVersion.replace(
							/^[\s\S]*?Version.(\d+\.\d+)[\s\S]*$/i, "$1"))
				}
				if (typeof MessageEvent == "function") {
					k = parseFloat(navigator.appVersion.replace(
							/^[\s\S]*?chrome.(\d+\.\d+)[\s\S]*$/i, "$1"))
				}
				if (/AdobeAIR/i.test(navigator.appVersion)) {
					p = 1
				}
			} else {
				if (typeof document.getBoxObjectFor == "function") {
					w = parseFloat(navigator.userAgent.replace(
							/^[\s\S]*?Firefox\/(\d+\.\d+)[\s\S]*$/i, "$1"))
				} else {
					if (typeof opera == "object") {
						g = parseFloat(navigator.appVersion.replace(
								/^(\d+\.\d+)[\s\S]*$/i, "$1"))
					} else {
						x = 6
					}
				}
			}
		}
	}
	if (x) {
		if (x > 7
				&& window.navigator
				&& window.navigator.appMinorVersion
				&& window.navigator.appMinorVersion.toLowerCase().indexOf(
						"beta") > -1) {
			y = true
		}
	}
	if (i) {
		u = !!i[1];
		q = !!i[2];
		if (u) {
			if (n = j.exec(h)) {
				if (n.length > 0) {
					c = parseFloat(n[1], 10)
				}
			}
		}
	} else {
		u = q = false;
		c = NaN
	}
	function s() {
		if (!s.adjusted && x && x < 7) {
			try {
				document.execCommand("BackgroundImageCache", false, true)
			} catch (t) {
			}
			s.adjusted = true
		}
	}
	return {
		beta : y,
		firefox : w,
		ie : x,
		opera : g,
		air : p,
		safari : f,
		safariV : f,
		webkit : m,
		windows : c ? c : u,
		macs : q,
		chrome : k,
		adjustBehaviors : s
	}
})();
QZFL.object = {
	map : function(a, b, c) {
		b = b || window;
		QZFL.object.each(a, function(e, d) {
			if (typeof (c) == "string") {
				if (typeof (e == c)) {
					b[d] = e
				}
			} else {
				b[d] = e
			}
		})
	},
	extend : function(a, b) {
		var c = QZFL.object.getType(a);
		if (c != "object" && c != "function") {
			return
		}
		QZFL.object.each(b, function(e, d) {
			a[d] = e
		})
	},
	each : function(c, e) {
		if (typeof c != "object" || typeof e != "function") {
			return false
		}
		var d = 0, b, f = e;
		if (Object.prototype.toString.call(c) === "[object Array]") {
			if (!!c.forEach) {
				c.forEach(e)
			} else {
				var a = c.length;
				while (d < a) {
					f(c[d], d, c);
					++d
				}
			}
		} else {
			for (b in c) {
				f(c[b], b, c)
			}
		}
		return true
	},
	getType : function(a) {
		var b;
		return ((b = typeof (a)) == "object" ? a == null && "null"
				|| Object.prototype.toString.call(a).slice(8, -1) : b)
				.toLowerCase()
	}
};
QZFL.console = {
	print : function(b, a) {
		if (window.console) {
			console.log((a == 4 ? (new Date() + ":") : "") + b)
		}
	}
};
QZFL.report = {
	receive : QZFL.emptyFn,
	addRule : QZFL.emptyFn
};
QZFL.runTime = {
	isDebugMode : false,
	error : function() {
	},
	warn : function() {
	}
};
QZFL.object.each([ "widget", "string", "util" ], function(a) {
	QZFL[a] = {}
});
QZFL.namespace = QZFL.object;
var ua = window.ua || QZFL.userAgent;
QZFL.config = {
	debugLevel : 0,
	defaultDataCharacterSet : "utf-8",
	DCCookieDomain : "shop.qq.com",
	domainPrefix : "qq.com",
	gbEncoderPath : "http://imgcache.qq.com/ac/qqshop/toolpages/",
	FSHelperPage : "http://imgcache.qq.com/ac/qqshop/toolpages/fp_gbk.html",
	defaultShareObject : "http://imgcache.qq.com/ac/qqshop/toolpages/getset.swf"
};
QZFL.css = {
	getClassRegEx : function(b) {
		var a = QZFL.css.classNameCache[b];
		if (!a) {
			a = new RegExp("(?:^|\\s+)" + b + "(?:\\s+|$)");
			QZFL.css.classNameCache[b] = a
		}
		return a
	},
	convertHexColor : function(d) {
		d = /^#/.test(d) ? d.substr(1) : d;
		var c = new RegExp("\\w{2}", "ig");
		d = d.match(c);
		if (!d || d.length < 3) {
			return [ 0, 0, 0 ]
		}
		var f = parseInt(d[0], 16);
		var e = parseInt(d[1], 16);
		var a = parseInt(d[2], 16);
		return [ f, e, a ]
	},
	styleSheets : {},
	getStyleSheetById : function(b) {
		try {
			return QZFL.dom.get(b).sheet || document.styleSheets[b]
		} catch (a) {
			return null
		}
	},
	getRulesBySheet : function(b) {
		var a = QZFL.css.getStyleSheetById(b);
		if (a) {
			try {
				return a.cssRules || a.rules
			} catch (c) {
				return null
			}
		} else {
			return null
		}
	},
	getRuleBySelector : function(e, a) {
		var f = this.getStyleSheetById(e);
		if (!f.cacheSelector) {
			f.cacheSelector = {}
		}
		if (f) {
			var d = f.cssRules || f.rules;
			var c = new RegExp("^" + a + "$", "i");
			var g = f.cacheSelector[a];
			if (g && c.test(d[g].selectorText)) {
				return d[g]
			} else {
				for ( var b = 0; b < d.length; b++) {
					if (c.test(d[b].selectorText)) {
						f.cacheSelector[a] = b;
						return d[b]
					}
				}
				return null
			}
		} else {
			return null
		}
	},
	insertCSSLink : function(b, d) {
		var c = document, a = c.createElement("link");
		if (d) {
			a.id = d
		}
		a.rel = "stylesheet";
		a.rev = "stylesheet";
		a.type = "text/css";
		a.media = "screen";
		a.href = b;
		c.getElementsByTagName("head")[0].appendChild(a);
		return a.sheet || a
	},
	insertStyleSheet : function(b) {
		var a = document.createElement("style");
		a.id = b;
		document.getElementsByTagName("head")[0].appendChild(a);
		return a.sheet || a
	},
	removeStyleSheet : function(c) {
		var b = this.getStyleSheetById(c);
		if (b) {
			var a = b.owningElement || b.ownerNode;
			QZFL.dom.removeElement(a)
		}
	},
	hasClassName : function(b, a) {
		return (b && a) ? new RegExp("\\b" + a + "\\b").test(b.className)
				: false
	},
	swapClassName : function(f, c, b) {
		function e(i, h, g) {
			if (QZFL.css.hasClassName(i, h)) {
				i.className = i.className.replace(h, g)
			} else {
				if (QZFL.css.hasClassName(i, g)) {
					i.className = i.className.replace(g, h)
				}
			}
		}
		if (f.constructor != Array) {
			f = [ f ]
		}
		for ( var d = 0, a = f.length; d < a; d++) {
			e(f[d], c, b)
		}
	},
	replaceClassName : function(f, d, e) {
		function b(i, h, g) {
			if (QZFL.css.hasClassName(i, h)) {
				i.className = i.className.replace(h, g)
			}
		}
		if (f.constructor != Array) {
			f = [ f ]
		}
		for ( var c = 0, a = f.length; c < a; c++) {
			b(f[c], d, e)
		}
	},
	addClassName : function(b, a) {
		if (b && a) {
			if (b.className) {
				if (QZFL.css.hasClassName(b, a)) {
					return false
				} else {
					b.className += " " + a;
					return true
				}
			} else {
				b.className = a;
				return true
			}
		} else {
			return false
		}
	},
	removeClassName : function(c, b) {
		if (c && b && c.className) {
			var a = c.className;
			c.className = (c.className.replace(new RegExp("\\b" + b + "\\b"),
					""));
			return c.className != a
		} else {
			return false
		}
	},
	toggleClassName : function(c, a) {
		var b = QZFL.css;
		if (b.hasClassName(c, a)) {
			b.removeClassName(c, a)
		} else {
			b.addClassName(c, a)
		}
	}
};
QZFL.css.classNameCache = {};
QZFL.dom = {
	getById : function(a) {
		return document.getElementById(a)
	},
	getByName : function(b, d) {
		if (!d) {
			return document.getElementsByName(b)
		}
		var a = [];
		var f = document.getElementsByTagName(d);
		for ( var c = 0; c < f.length; ++c) {
			if (!!f[c].getAttribute("name")
					&& (f[c].getAttribute("name").toLowerCase() == b
							.toLowerCase())) {
				a.push(f[c])
			}
		}
		return a
	},
	get : function(a) {
		if (a && ((a.tagName || a.item) || a.nodeType == 9)) {
			return a
		}
		return this.getById(a)
	},
	getNode : function(a) {
		if (a && (a.nodeType || a.item)) {
			return a
		}
		if (typeof a === "string") {
			return this.getById(a)
		}
		return null
	},
	removeElement : function(b) {
		if (typeof (b) == "string") {
			b = QZFL.dom.getById(b)
		}
		if (!b) {
			return
		}
		if (b.removeNode) {
			b.removeNode(true)
		} else {
			if (b.childNodes.length > 0) {
				for ( var a = b.childNodes.length - 1; a >= 0; a--) {
					QZFL.dom.removeElement(b.childNodes[a])
				}
			}
			if (b.parentNode) {
				b.parentNode.removeChild(b)
			}
		}
		b = null;
		return null
	},
	searchElementByClassName : function(c, b) {
		c = this.get(c);
		if (!c) {
			return null
		}
		var a = QZFL.css.getClassRegEx(b);
		while (c) {
			if (a.test(c.className)) {
				return c
			}
			c = c.parentNode
		}
		return null
	},
	getElementsByClassName : function(g, b, c) {
		var b = b || "*";
		c = (c) ? this.get(c) : null || document;
		if (!c) {
			return []
		}
		var d = [], h = c.getElementsByTagName(b), f = QZFL.css
				.getClassRegEx(g);
		for ( var e = 0, a = h.length; e < a; ++e) {
			if (f.test(h[e].className)) {
				d[d.length] = h[e]
			}
		}
		return d
	},
	isAncestor : function(b, a) {
		if (!b || !a) {
			return false
		}
		if (b.contains && a.nodeType && !QZFL.userAgent.webkit) {
			return b.contains(a) && b != a
		}
		if (b.compareDocumentPosition && a.nodeType) {
			return !!(b.compareDocumentPosition(a) & 16)
		} else {
			if (a.nodeType) {
				return !!this.getAncestorBy(a, function(c) {
					return c == b
				})
			}
		}
		return false
	},
	getAncestorBy : function(a, b) {
		while (a = a.parentNode) {
			if (a && a.nodeType == 1 && (!b || b(a))) {
				return a
			}
		}
		return null
	},
	getFirstChild : function(a) {
		a = this.getNode(a);
		if (!a) {
			return null
		}
		var b = !!a.firstChild && a.firstChild.nodeType == 1 ? a.firstChild
				: null;
		return b || this.getNextSibling(a.firstChild)
	},
	getNextSibling : function(a) {
		a = this.getNode(a);
		if (!a) {
			return null
		}
		while (a) {
			a = a.nextSibling;
			if (!!a && a.nodeType == 1) {
				return a
			}
		}
		return null
	},
	getPreviousSibling : function(a) {
		a = this.getNode(a);
		if (!a) {
			return null
		}
		while (a) {
			a = a.previousSibling;
			if (!!a && a.nodeType == 1) {
				return a
			}
		}
		return null
	},
	swapNode : function(b, a) {
		if (b.swapNode) {
			b.swapNode(a)
		} else {
			var d = a.parentNode;
			var c = a.nextSibling;
			if (c == b) {
				d.insertBefore(b, a)
			} else {
				if (a == b.nextSibling) {
					d.insertBefore(a, b)
				} else {
					b.parentNode.replaceChild(a, b);
					d.insertBefore(b, c)
				}
			}
		}
	},
	createElementIn : function(d, e, f, c) {
		var d = d || "div";
		var e = this.get(e) || document.body;
		var g = e.ownerDocument;
		var a = g.createElement(d);
		if (c) {
			for ( var b in c) {
				if (/class/.test(b)) {
					a.className = c[b]
				} else {
					if (/style/.test(b)) {
						a.style.cssText = c[b]
					} else {
						a[b] = c[b]
					}
				}
			}
		}
		if (f) {
			e.insertBefore(a, e.firstChild)
		} else {
			e.appendChild(a)
		}
		return a
	},
	getStyle : function(b, f) {
		b = this.get(b);
		var a = document.defaultView && document.defaultView.getComputedStyle;
		var c = !a ? null : document.defaultView.getComputedStyle(b, "");
		var d = "";
		switch (f) {
		case "float":
			f = a ? "cssFloat" : "styleFloat";
			break;
		case "opacity":
			if (!a) {
				var h = 100;
				try {
					h = b.filters["DXImageTransform.Microsoft.Alpha"].opacity
				} catch (g) {
					try {
						h = b.filters("alpha").opacity
					} catch (g) {
					}
				}
				return h / 100
			}
			break;
		case "backgroundPositionX":
			if (a) {
				f = "backgroundPosition";
				return ((c || b.style)[f]).split(" ")[0]
			}
			break;
		case "backgroundPositionY":
			if (a) {
				f = "backgroundPosition";
				return ((c || b.style)[f]).split(" ")[1]
			}
			break
		}
		if (a) {
			return (c || b.style)[f]
		} else {
			return (b.currentStyle[f] || b.style[f])
		}
	},
	setStyle : function(d, f, e) {
		d = this.get(d);
		if (!d || d.nodeType == 9) {
			return false
		}
		var c = document.defaultView && document.defaultView.getComputedStyle;
		switch (f) {
		case "float":
			f = c ? "cssFloat" : "styleFloat";
		case "opacity":
			if (!c) {
				if (e >= 1) {
					d.style.filter = "";
					return
				}
				d.style.filter = "alpha(opacity=" + (e * 100) + ")";
				return true
			} else {
				d.style[f] = e;
				return true
			}
			break;
		case "backgroundPositionX":
			if (c) {
				var a = QZFL.dom.getStyle(d, "backgroundPositionY");
				d.style.backgroundPosition = e + " " + (a || "top")
			} else {
				d.style[f] = e
			}
			break;
		case "backgroundPositionY":
			if (c) {
				var b = QZFL.dom.getStyle(d, "backgroundPositionX");
				d.style.backgroundPosition = (b || "left") + " " + e
			} else {
				d.style[f] = e
			}
			break;
		default:
			if (typeof d.style[f] == "undefined") {
				return false
			}
			d.style[f] = e;
			return true
		}
	},
	createNamedElement : function(c, a, d) {
		var e = d || document, b;
		try {
			b = e.createElement("<" + c + ' name="' + a + '">')
		} catch (f) {
		}
		if (!b || !b.name) {
			b = e.createElement(c);
			b.name = a
		}
		return b
	},
	getPosition : function(b) {
		var c = QZFL.dom.getXY(b), a = QZFL.dom.getSize(b);
		return {
			top : c[1],
			left : c[0],
			width : a[0],
			height : a[1]
		}
	},
	setPosition : function(a, b) {
		QZFL.dom.setXY(a, b.left, b.top);
		QZFL.dom.setSize(a, b.width, b.height)
	},
	getXY : function(d, g) {
		var f = 0, c = 0, h = g || document;
		if (d) {
			if (h.documentElement.getBoundingClientRect
					&& d.getBoundingClientRect) {
				var e = d.getBoundingClientRect(), b = d.ownerDocument, a = QZFL.userAgent.ie ? 2
						: 0;
				f = e.top - a + QZFL.dom.getScrollTop(b);
				c = e.left - a + QZFL.dom.getScrollLeft(b)
			} else {
				while (d.offsetParent) {
					f += d.offsetTop;
					c += d.offsetLeft;
					d = d.offsetParent
				}
			}
		}
		return [ c, f ]
	},
	getSize : function(c) {
		var a = [ 0, 0 ];
		QZFL.object.each([ "Left", "Right", "Top", "Bottom" ], function(e) {
			a[e == "Left" || e == "Right" ? 0 : 1] += (parseInt(QZFL.dom
					.getStyle(c, "border" + e + "Width"), 10) || 0)
					+ (parseInt(QZFL.dom.getStyle(c, "padding" + e), 10) || 0)
		});
		var b = c.offsetWidth - a[0];
		var d = c.offsetHeight - a[1];
		return [ b, d ]
	},
	setXY : function(c, a, e) {
		c = this.get(c);
		var b = parseInt(this.getStyle(c, "marginLeft")) || 0;
		var d = parseInt(this.getStyle(c, "marginTop")) || 0;
		this.setStyle(c, "left", parseInt(a) - b + "px");
		this.setStyle(c, "top", parseInt(e) - d + "px")
	},
	getScrollLeft : function(a) {
		var b = a || document;
		return Math.max(b.documentElement.scrollLeft, b.body.scrollLeft)
	},
	getScrollTop : function(a) {
		var b = a || document;
		return Math.max(b.documentElement.scrollTop, b.body.scrollTop)
	},
	getScrollHeight : function(a) {
		var b = a || document;
		return Math.max(b.documentElement.scrollHeight, b.body.scrollHeight)
	},
	getScrollWidth : function(a) {
		var b = a || document;
		return Math.max(b.documentElement.scrollWidth, b.body.scrollWidth)
	},
	setScrollLeft : function(a, b) {
		var c = b || document;
		c[c.compatMode == "CSS1Compat" && !QZFL.userAgent.webkit ? "documentElement"
				: "body"].scrollLeft = a
	},
	setScrollTop : function(a, b) {
		var c = b || document;
		c[c.compatMode == "CSS1Compat" && !QZFL.userAgent.webkit ? "documentElement"
				: "body"].scrollTop = a
	},
	getClientHeight : function(a) {
		var b = a || document;
		return b.compatMode == "CSS1Compat" ? b.documentElement.clientHeight
				: b.body.clientHeight
	},
	getClientWidth : function(a) {
		var b = a || document;
		return b.compatMode == "CSS1Compat" ? b.documentElement.clientWidth
				: b.body.clientWidth
	},
	setSize : function(e, d, b) {
		e = this.get(e);
		var a = /\d+([a-z%]+)/i.exec(d);
		a = a ? a[1] : "";
		var c = /\d+([a-z%]+)/i.exec(b);
		c = c ? c[1] : "";
		this.setStyle(e, "width", (typeof d != "number" || d < 0 || /auto/i
				.test(d)) ? "auto" : (parseInt(d) + (a || "px")));
		this.setStyle(e, "height", (typeof b != "number" || b < 0 || /auto/i
				.test(b)) ? "auto" : (parseInt(b) + (c || "px")))
	},
	getDocumentWindow : function(a) {
		var b = a || document;
		return b.parentWindow || b.defaultView
	},
	getElementsByTagNameNS : function(g, f, e) {
		var d = [];
		if (g) {
			if (g.getElementsByTagNameNS) {
				return g.getElementsByTagName(f + ":" + e)
			} else {
				if (g.getElementsByTagName) {
					var h = document.namespaces;
					if (h.length > 0) {
						var b = g.getElementsByTagName(e);
						for ( var c = 0, a = b.length; c < a; ++c) {
							if (b[c].scopeName == f) {
								d.push(b[c])
							}
						}
					}
				}
			}
		}
		return d
	},
	collection2Array : function(c) {
		if (isArray(c)) {
			return c
		} else {
			var d = [];
			for ( var b = 0, a = c.length; b < a; ++b) {
				d.push(c[b])
			}
		}
		return d
	},
	getElementByTagNameBubble : function(c, b) {
		if (!isNode(c)) {
			return null
		}
		b += "";
		var d = 31;
		while (c && c.tagName && (c.tagName.toLowerCase() != b.toLowerCase())) {
			if (c == document.body || (--d) < 0) {
				return null
			}
			c = c.parentNode
		}
		return c
	}
};
var _CN = QZFL.dom.createNamedElement, $ = QZFL.dom.getById, removeNode = QZFL.dom.removeElement;
QZFL.event = {
	KEYS : {
		BACKSPACE : 8,
		TAB : 9,
		RETURN : 13,
		ESC : 27,
		SPACE : 32,
		LEFT : 37,
		UP : 38,
		RIGHT : 39,
		DOWN : 40,
		DELETE : 46
	},
	extendType : /(click|mousedown|mouseover|mouseout|mouseup|mousemove|scroll|contextmenu|resize)/i,
	_eventListDictionary : {},
	_fnSeqUID : 0,
	_objSeqUID : 0,
	addEvent : function(g, d, f, b) {
		var e = f, c = false, a;
		if (!g) {
			return c
		}
		if (!g.eventsListUID) {
			g.eventsListUID = "e" + (++QZFL.event._objSeqUID);
			QZFL.event._eventListDictionary[g.eventsListUID] = {}
		}
		a = QZFL.event._eventListDictionary[g.eventsListUID];
		if (!f.__elUID) {
			f.__elUID = "e" + (++QZFL.event._fnSeqUID) + g.eventsListUID
		}
		if (!a[d]) {
			a[d] = {}
		}
		if (typeof (a[d][f.__elUID]) == "function") {
			return false
		}
		if (QZFL.event.extendType.test(d)) {
			var b = b || [];
			e = function(h) {
				return f.apply(null, ([ QZFL.event.getEvent(h) ]).concat(b))
			}
		}
		if (g.addEventListener) {
			g.addEventListener(d, e, false);
			c = true
		} else {
			if (g.attachEvent) {
				c = g.attachEvent("on" + d, e)
			} else {
				c = false
			}
		}
		if (c) {
			a[d][f.__elUID] = e
		}
		return c
	},
	removeEvent : function(f, c, e) {
		var d = e, b = false, a;
		if (!f) {
			return b
		}
		if (!d) {
			return QZFL.event.purgeEvent(f, c)
		}
		if (!f.eventsListUID) {
			f.eventsListUID = "e" + (++QZFL.event._objSeqUID);
			QZFL.event._eventListDictionary[f.eventsListUID] = {}
		}
		a = QZFL.event._eventListDictionary[f.eventsListUID];
		if (!e.__elUID) {
			e.__elUID = "e" + (++QZFL.event._fnSeqUID) + f.eventsListUID
		}
		if (!a[c]) {
			a[c] = {}
		}
		if (QZFL.event.extendType.test(c) && a[c] && a[c][e.__elUID]) {
			d = a[c][e.__elUID]
		}
		if (f.removeEventListener) {
			f.removeEventListener(c, d, false);
			b = true
		} else {
			if (f.detachEvent) {
				f.detachEvent("on" + c, d);
				b = true
			} else {
				return false
			}
		}
		if (b && a[c]) {
			delete a[c][e.__elUID]
		}
		return b
	},
	purgeEvent : function(d, c) {
		var a;
		if (d.eventsListUID
				&& (a = QZFL.event._eventListDictionary[d.eventsListUID])
				&& a[c]) {
			for ( var b in a[c]) {
				if (d.removeEventListener) {
					d.removeEventListener(c, a[c][b], false)
				} else {
					if (d.detachEvent) {
						d.detachEvent("on" + c, a[c][b])
					}
				}
			}
		}
		if (d["on" + c]) {
			d["on" + c] = null
		}
		if (a) {
			a[c] = null;
			delete a[c]
		}
		return true
	},
	getEvent : function(a) {
		var a = a || window.event;
		if (!a && !QZFL.userAgent.ie) {
			var d = this.getEvent.caller, b = 1;
			while (d) {
				a = d.arguments[0];
				if (a && Event == a.constructor) {
					break
				} else {
					if (b > 32) {
						break
					}
				}
				d = d.caller;
				b++
			}
		}
		return a
	},
	getButton : function(a) {
		var b = QZFL.event.getEvent(a);
		if (!b) {
			return -1
		}
		if (QZFL.userAgent.ie) {
			return b.button - Math.ceil(b.button / 2)
		} else {
			return b.button
		}
	},
	getTarget : function(a) {
		var b = QZFL.event.getEvent(a);
		if (b) {
			return b.target || b.srcElement
		} else {
			return null
		}
	},
	getCurrentTarget : function(a) {
		var b = QZFL.event.getEvent(a);
		if (b) {
			return b.currentTarget || document.activeElement
		} else {
			return null
		}
	},
	cancelBubble : function(a) {
		a = QZFL.event.getEvent(a);
		if (!a) {
			return false
		}
		if (a.stopPropagation) {
			a.stopPropagation()
		} else {
			if (!a.cancelBubble) {
				a.cancelBubble = true
			}
		}
	},
	preventDefault : function(a) {
		a = QZFL.event.getEvent(a);
		if (!a) {
			return false
		}
		if (a.preventDefault) {
			a.preventDefault()
		} else {
			a.returnValue = false
		}
	},
	mouseX : function(a) {
		a = QZFL.event.getEvent(a);
		return a.pageX
				|| (a.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft))
	},
	mouseY : function(a) {
		a = QZFL.event.getEvent(a);
		return a.pageY
				|| (a.clientY + (document.documentElement.scrollTop || document.body.scrollTop))
	},
	getRelatedTarget : function(b) {
		b = QZFL.event.getEvent(b);
		var a = b.relatedTarget;
		if (!a) {
			if (b.type == "mouseout") {
				a = b.toElement
			} else {
				if (b.type == "mouseover") {
					a = b.fromElement
				} else {
				}
			}
		}
		return a
	},
	bind : function(b, c) {
		var a = Array.prototype.slice.call(arguments, 2);
		return function() {
			var e = b || this;
			var d = a.concat(Array.prototype.slice.call(arguments, 0));
			if (typeof (c) == "string") {
				if (e[c]) {
					return e[c].apply(e, d)
				}
			} else {
				return c.apply(e, d)
			}
		}
	}
};
QZFL.event.on = QZFL.event.addEvent;
window.addEvent = QZFL.event.addEvent;
window.removeEvent = QZFL.event.removeEvent;
window.getEvent = QZFL.event.getEvent;
QZFL.selector = {
	query : function(a, b) {
		b = b || document;
		var c = QZFL.selector.engine(a, b);
		return c
	}
};
(function() {
	var r = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^[\]]*\]|['"][^'"]*['"]|[^[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?/g, i = 0, d = Object.prototype.toString, p = false;
	var b = function(F, v, C, x) {
		C = C || [];
		var e = v = v || document;
		if (v.nodeType !== 1 && v.nodeType !== 9) {
			return []
		}
		if (!F || typeof F !== "string") {
			return C
		}
		var D = [], E, A, I, H, B, u, t = true, y = q(v);
		r.lastIndex = 0;
		while ((E = r.exec(F)) !== null) {
			D.push(E[1]);
			if (E[2]) {
				u = RegExp.rightContext;
				break
			}
		}
		if (D.length > 1 && j.exec(F)) {
			if (D.length === 2 && f.relative[D[0]]) {
				A = g(D[0] + D[1], v)
			} else {
				A = f.relative[D[0]] ? [ v ] : b(D.shift(), v);
				while (D.length) {
					F = D.shift();
					if (f.relative[F]) {
						F += D.shift()
					}
					A = g(F, A)
				}
			}
		} else {
			if (!x && D.length > 1 && v.nodeType === 9 && !y
					&& f.match.ID.test(D[0])
					&& !f.match.ID.test(D[D.length - 1])) {
				var J = b.find(D.shift(), v, y);
				v = J.expr ? b.filter(J.expr, J.set)[0] : J.set[0]
			}
			if (v) {
				var J = x ? {
					expr : D.pop(),
					set : a(x)
				} : b.find(D.pop(),
						D.length === 1 && (D[0] === "~" || D[0] === "+")
								&& v.parentNode ? v.parentNode : v, y);
				A = J.expr ? b.filter(J.expr, J.set) : J.set;
				if (D.length > 0) {
					I = a(A)
				} else {
					t = false
				}
				while (D.length) {
					var w = D.pop(), z = w;
					if (!f.relative[w]) {
						w = ""
					} else {
						z = D.pop()
					}
					if (z == null) {
						z = v
					}
					f.relative[w](I, z, y)
				}
			} else {
				I = D = []
			}
		}
		if (!I) {
			I = A
		}
		if (!I) {
			throw "Syntax error, unrecognized expression: " + (w || F)
		}
		if (d.call(I) === "[object Array]") {
			if (!t) {
				C.push.apply(C, I)
			} else {
				if (v && v.nodeType === 1) {
					for ( var G = 0; I[G] != null; G++) {
						if (I[G]
								&& (I[G] === true || I[G].nodeType === 1
										&& h(v, I[G]))) {
							C.push(A[G])
						}
					}
				} else {
					for ( var G = 0; I[G] != null; G++) {
						if (I[G] && I[G].nodeType === 1) {
							C.push(A[G])
						}
					}
				}
			}
		} else {
			a(I, C)
		}
		if (u) {
			b(u, e, C, x);
			b.uniqueSort(C)
		}
		return C
	};
	b.uniqueSort = function(t) {
		if (c) {
			p = false;
			t.sort(c);
			if (p) {
				for ( var e = 1; e < t.length; e++) {
					if (t[e] === t[e - 1]) {
						t.splice(e--, 1)
					}
				}
			}
		}
	};
	b.matches = function(e, t) {
		return b(e, null, null, t)
	};
	b.find = function(z, e, A) {
		var y, w;
		if (!z) {
			return []
		}
		for ( var v = 0, u = f.order.length; v < u; v++) {
			var x = f.order[v], w;
			if ((w = f.match[x].exec(z))) {
				var t = RegExp.leftContext;
				if (t.substr(t.length - 1) !== "\\") {
					w[1] = (w[1] || "").replace(/\\/g, "");
					y = f.find[x](w, e, A);
					if (y != null) {
						z = z.replace(f.match[x], "");
						break
					}
				}
			}
		}
		if (!y) {
			y = e.getElementsByTagName("*")
		}
		return {
			set : y,
			expr : z
		}
	};
	b.filter = function(C, B, F, v) {
		var u = C, H = [], z = B, x, e, y = B && B[0] && q(B[0]);
		while (C && B.length) {
			for ( var A in f.filter) {
				if ((x = f.match[A].exec(C)) != null) {
					var t = f.filter[A], G, E;
					e = false;
					if (z == H) {
						H = []
					}
					if (f.preFilter[A]) {
						x = f.preFilter[A](x, z, F, H, v, y);
						if (!x) {
							e = G = true
						} else {
							if (x === true) {
								continue
							}
						}
					}
					if (x) {
						for ( var w = 0; (E = z[w]) != null; w++) {
							if (E) {
								G = t(E, x, w, z);
								var D = v ^ !!G;
								if (F && G != null) {
									if (D) {
										e = true
									} else {
										z[w] = false
									}
								} else {
									if (D) {
										H.push(E);
										e = true
									}
								}
							}
						}
					}
					if (G !== undefined) {
						if (!F) {
							z = H
						}
						C = C.replace(f.match[A], "");
						if (!e) {
							return []
						}
						break
					}
				}
			}
			if (C == u) {
				if (e == null) {
					throw "Syntax error, unrecognized expression: " + C
				} else {
					break
				}
			}
			u = C
		}
		return z
	};
	var f = b.selectors = {
		order : [ "ID", "NAME", "TAG" ],
		match : {
			ID : /#((?:[\w\u00c0-\uFFFF_-]|\\.)+)/,
			CLASS : /\.((?:[\w\u00c0-\uFFFF_-]|\\.)+)/,
			NAME : /\[name=['"]*((?:[\w\u00c0-\uFFFF_-]|\\.)+)['"]*\]/,
			ATTR : /\[\s*((?:[\w\u00c0-\uFFFF_-]|\\.)+)\s*(?:(\S?=)\s*(['"]*)(.*?)\3|)\s*\]/,
			TAG : /^((?:[\w\u00c0-\uFFFF\*_-]|\\.)+)/,
			CHILD : /:(only|nth|last|first)-child(?:\((even|odd|[\dn+-]*)\))?/,
			POS : /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^-]|$)/,
			PSEUDO : /:((?:[\w\u00c0-\uFFFF_-]|\\.)+)(?:\((['"]*)((?:\([^\)]+\)|[^\2\(\)]*)+)\2\))?/
		},
		attrMap : {
			"class" : "className",
			"for" : "htmlFor"
		},
		attrHandle : {
			href : function(e) {
				return e.getAttribute("href")
			}
		},
		relative : {
			"+" : function(z, e, y) {
				var w = typeof e === "string", A = w && !/\W/.test(e), x = w
						&& !A;
				if (A && !y) {
					e = e.toUpperCase()
				}
				for ( var v = 0, u = z.length, t; v < u; v++) {
					if ((t = z[v])) {
						while ((t = t.previousSibling) && t.nodeType !== 1) {
						}
						z[v] = x || t && t.nodeName === e ? t || false
								: t === e
					}
				}
				if (x) {
					b.filter(e, z, true)
				}
			},
			">" : function(y, t, z) {
				var w = typeof t === "string";
				if (w && !/\W/.test(t)) {
					t = z ? t : t.toUpperCase();
					for ( var u = 0, e = y.length; u < e; u++) {
						var x = y[u];
						if (x) {
							var v = x.parentNode;
							y[u] = v.nodeName === t ? v : false
						}
					}
				} else {
					for ( var u = 0, e = y.length; u < e; u++) {
						var x = y[u];
						if (x) {
							y[u] = w ? x.parentNode : x.parentNode === t
						}
					}
					if (w) {
						b.filter(t, y, true)
					}
				}
			},
			"" : function(v, t, x) {
				var u = i++, e = s;
				if (!/\W/.test(t)) {
					var w = t = x ? t : t.toUpperCase();
					e = n
				}
				e("parentNode", t, u, v, w, x)
			},
			"~" : function(v, t, x) {
				var u = i++, e = s;
				if (typeof t === "string" && !/\W/.test(t)) {
					var w = t = x ? t : t.toUpperCase();
					e = n
				}
				e("previousSibling", t, u, v, w, x)
			}
		},
		find : {
			ID : function(t, u, v) {
				if (typeof u.getElementById !== "undefined" && !v) {
					var e = u.getElementById(t[1]);
					return e ? [ e ] : []
				}
			},
			NAME : function(u, x, y) {
				if (typeof x.getElementsByName !== "undefined") {
					var t = [], w = x.getElementsByName(u[1]);
					for ( var v = 0, e = w.length; v < e; v++) {
						if (w[v].getAttribute("name") === u[1]) {
							t.push(w[v])
						}
					}
					return t.length === 0 ? null : t
				}
			},
			TAG : function(e, t) {
				return t.getElementsByTagName(e[1])
			}
		},
		preFilter : {
			CLASS : function(v, t, u, e, y, z) {
				v = " " + v[1].replace(/\\/g, "") + " ";
				if (z) {
					return v
				}
				for ( var w = 0, x; (x = t[w]) != null; w++) {
					if (x) {
						if (y
								^ (x.className && (" " + x.className + " ")
										.indexOf(v) >= 0)) {
							if (!u) {
								e.push(x)
							}
						} else {
							if (u) {
								t[w] = false
							}
						}
					}
				}
				return false
			},
			ID : function(e) {
				return e[1].replace(/\\/g, "")
			},
			TAG : function(t, e) {
				for ( var u = 0; e[u] === false; u++) {
				}
				return e[u] && q(e[u]) ? t[1] : t[1].toUpperCase()
			},
			CHILD : function(e) {
				if (e[1] == "nth") {
					var t = /(-?)(\d*)n((?:\+|-)?\d*)/.exec(e[2] == "even"
							&& "2n" || e[2] == "odd" && "2n+1"
							|| !/\D/.test(e[2]) && "0n+" + e[2] || e[2]);
					e[2] = (t[1] + (t[2] || 1)) - 0;
					e[3] = t[3] - 0
				}
				e[0] = i++;
				return e
			},
			ATTR : function(w, t, u, e, x, y) {
				var v = w[1].replace(/\\/g, "");
				if (!y && f.attrMap[v]) {
					w[1] = f.attrMap[v]
				}
				if (w[2] === "~=") {
					w[4] = " " + w[4] + " "
				}
				return w
			},
			PSEUDO : function(w, t, u, e, x) {
				if (w[1] === "not") {
					if (r.exec(w[3]).length > 1 || /^\w/.test(w[3])) {
						w[3] = b(w[3], null, null, t)
					} else {
						var v = b.filter(w[3], t, u, true ^ x);
						if (!u) {
							e.push.apply(e, v)
						}
						return false
					}
				} else {
					if (f.match.POS.test(w[0]) || f.match.CHILD.test(w[0])) {
						return true
					}
				}
				return w
			},
			POS : function(e) {
				e.unshift(true);
				return e
			}
		},
		filters : {
			enabled : function(e) {
				return e.disabled === false && e.type !== "hidden"
			},
			disabled : function(e) {
				return e.disabled === true
			},
			checked : function(e) {
				return e.checked === true
			},
			selected : function(e) {
				e.parentNode.selectedIndex;
				return e.selected === true
			},
			parent : function(e) {
				return !!e.firstChild
			},
			empty : function(e) {
				return !e.firstChild
			},
			has : function(u, t, e) {
				return !!b(e[3], u).length
			},
			header : function(e) {
				return /h\d/i.test(e.nodeName)
			},
			text : function(e) {
				return "text" === e.type
			},
			radio : function(e) {
				return "radio" === e.type
			},
			checkbox : function(e) {
				return "checkbox" === e.type
			},
			file : function(e) {
				return "file" === e.type
			},
			password : function(e) {
				return "password" === e.type
			},
			submit : function(e) {
				return "submit" === e.type
			},
			image : function(e) {
				return "image" === e.type
			},
			reset : function(e) {
				return "reset" === e.type
			},
			button : function(e) {
				return "button" === e.type
						|| e.nodeName.toUpperCase() === "BUTTON"
			},
			input : function(e) {
				return /input|select|textarea|button/i.test(e.nodeName)
			}
		},
		setFilters : {
			first : function(t, e) {
				return e === 0
			},
			last : function(u, t, e, v) {
				return t === v.length - 1
			},
			even : function(t, e) {
				return e % 2 === 0
			},
			odd : function(t, e) {
				return e % 2 === 1
			},
			lt : function(u, t, e) {
				return t < e[3] - 0
			},
			gt : function(u, t, e) {
				return t > e[3] - 0
			},
			nth : function(u, t, e) {
				return e[3] - 0 == t
			},
			eq : function(u, t, e) {
				return e[3] - 0 == t
			}
		},
		filter : {
			PSEUDO : function(x, t, u, y) {
				var e = t[1], v = f.filters[e];
				if (v) {
					return v(x, u, t, y)
				} else {
					if (e === "contains") {
						return (x.textContent || x.innerText || "")
								.indexOf(t[3]) >= 0
					} else {
						if (e === "not") {
							var w = t[3];
							for (u = 0, l = w.length; u < l; u++) {
								if (w[u] === x) {
									return false
								}
							}
							return true
						}
					}
				}
			},
			CHILD : function(e, v) {
				var y = v[1], t = e;
				switch (y) {
				case "only":
				case "first":
					while ((t = t.previousSibling)) {
						if (t.nodeType === 1) {
							return false
						}
					}
					if (y == "first") {
						return true
					}
					t = e;
				case "last":
					while ((t = t.nextSibling)) {
						if (t.nodeType === 1) {
							return false
						}
					}
					return true;
				case "nth":
					var u = v[2], B = v[3];
					if (u == 1 && B == 0) {
						return true
					}
					var x = v[0], A = e.parentNode;
					if (A && (A.sizcache !== x || !e.nodeIndex)) {
						var w = 0;
						for (t = A.firstChild; t; t = t.nextSibling) {
							if (t.nodeType === 1) {
								t.nodeIndex = ++w
							}
						}
						A.sizcache = x
					}
					var z = e.nodeIndex - B;
					if (u == 0) {
						return z == 0
					} else {
						return (z % u == 0 && z / u >= 0)
					}
				}
			},
			ID : function(t, e) {
				return t.nodeType === 1 && t.getAttribute("id") === e
			},
			TAG : function(t, e) {
				return (e === "*" && t.nodeType === 1) || t.nodeName === e
			},
			CLASS : function(t, e) {
				return (" " + (t.className || t.getAttribute("class")) + " ")
						.indexOf(e) > -1
			},
			ATTR : function(x, v) {
				var u = v[1], e = f.attrHandle[u] ? f.attrHandle[u](x)
						: x[u] != null ? x[u] : x.getAttribute(u), y = e + "", w = v[2], t = v[4];
				return e == null ? w === "!="
						: w === "=" ? y === t
								: w === "*=" ? y.indexOf(t) >= 0
										: w === "~=" ? (" " + y + " ")
												.indexOf(t) >= 0
												: !t ? y && e !== false
														: w === "!=" ? y != t
																: w === "^=" ? y
																		.indexOf(t) === 0
																		: w === "$=" ? y
																				.substr(y.length
																						- t.length) === t
																				: w === "|=" ? y === t
																						|| y
																								.substr(
																										0,
																										t.length + 1) === t
																								+ "-"
																						: false
			},
			POS : function(w, t, u, x) {
				var e = t[2], v = f.setFilters[e];
				if (v) {
					return v(w, u, t, x)
				}
			}
		}
	};
	var j = f.match.POS;
	for ( var m in f.match) {
		f.match[m] = new RegExp(f.match[m].source
				+ /(?![^\[]*\])(?![^\(]*\))/.source)
	}
	var a = function(t, e) {
		t = Array.prototype.slice.call(t);
		if (e) {
			e.push.apply(e, t);
			return e
		}
		return t
	};
	try {
		Array.prototype.slice.call(document.documentElement.childNodes)
	} catch (k) {
		a = function(w, v) {
			var t = v || [];
			if (d.call(w) === "[object Array]") {
				Array.prototype.push.apply(t, w)
			} else {
				if (typeof w.length === "number") {
					for ( var u = 0, e = w.length; u < e; u++) {
						t.push(w[u])
					}
				} else {
					for ( var u = 0; w[u]; u++) {
						t.push(w[u])
					}
				}
			}
			return t
		}
	}
	var c;
	if (document.documentElement.compareDocumentPosition) {
		c = function(t, e) {
			var u = t.compareDocumentPosition(e) & 4 ? -1 : t === e ? 0 : 1;
			if (u === 0) {
				p = true
			}
			return u
		}
	} else {
		if ("sourceIndex" in document.documentElement) {
			c = function(t, e) {
				var u = t.sourceIndex - e.sourceIndex;
				if (u === 0) {
					p = true
				}
				return u
			}
		} else {
			if (document.createRange) {
				c = function(v, t) {
					var u = v.ownerDocument.createRange(), e = t.ownerDocument
							.createRange();
					u.selectNode(v);
					u.collapse(true);
					e.selectNode(t);
					e.collapse(true);
					var w = u.compareBoundaryPoints(Range.START_TO_END, e);
					if (w === 0) {
						p = true
					}
					return w
				}
			}
		}
	}
	(function() {
		var t = document.createElement("div"), u = "script"
				+ (new Date).getTime();
		t.innerHTML = "<a name='" + u + "'/>";
		var e = document.documentElement;
		e.insertBefore(t, e.firstChild);
		if (!!document.getElementById(u)) {
			f.find.ID = function(w, x, y) {
				if (typeof x.getElementById !== "undefined" && !y) {
					var v = x.getElementById(w[1]);
					return v ? v.id === w[1]
							|| typeof v.getAttributeNode !== "undefined"
							&& v.getAttributeNode("id").nodeValue === w[1] ? [ v ]
							: undefined
							: []
				}
			};
			f.filter.ID = function(x, v) {
				var w = typeof x.getAttributeNode !== "undefined"
						&& x.getAttributeNode("id");
				return x.nodeType === 1 && w && w.nodeValue === v
			}
		}
		e.removeChild(t);
		e = t = null
	})();
	(function() {
		var e = document.createElement("div");
		e.appendChild(document.createComment(""));
		if (e.getElementsByTagName("*").length > 0) {
			f.find.TAG = function(t, x) {
				var w = x.getElementsByTagName(t[1]);
				if (t[1] === "*") {
					var v = [];
					for ( var u = 0; w[u]; u++) {
						if (w[u].nodeType === 1) {
							v.push(w[u])
						}
					}
					w = v
				}
				return w
			}
		}
		e.innerHTML = "<a href='#'></a>";
		if (e.firstChild && typeof e.firstChild.getAttribute !== "undefined"
				&& e.firstChild.getAttribute("href") !== "#") {
			f.attrHandle.href = function(t) {
				return t.getAttribute("href", 2)
			}
		}
		e = null
	})();
	if (document.querySelectorAll) {
		(function() {
			var e = b, u = document.createElement("div");
			u.innerHTML = "<p class='TEST'></p>";
			if (u.querySelectorAll && u.querySelectorAll(".TEST").length === 0) {
				return
			}
			b = function(y, x, v, w) {
				x = x || document;
				if (!w && x.nodeType === 9 && !q(x)) {
					try {
						return a(x.querySelectorAll(y), v)
					} catch (z) {
					}
				}
				return e(y, x, v, w)
			};
			for ( var t in e) {
				b[t] = e[t]
			}
			u = null
		})()
	}
	if (document.getElementsByClassName
			&& document.documentElement.getElementsByClassName) {
		(function() {
			var e = document.createElement("div");
			e.innerHTML = "<div class='test e'></div><div class='test'></div>";
			if (e.getElementsByClassName("e").length === 0) {
				return
			}
			e.lastChild.className = "e";
			if (e.getElementsByClassName("e").length === 1) {
				return
			}
			f.order.splice(1, 0, "CLASS");
			f.find.CLASS = function(t, u, v) {
				if (typeof u.getElementsByClassName !== "undefined" && !v) {
					return u.getElementsByClassName(t[1])
				}
			};
			e = null
		})()
	}
	function n(t, y, x, C, z, B) {
		var A = t == "previousSibling" && !B;
		for ( var v = 0, u = C.length; v < u; v++) {
			var e = C[v];
			if (e) {
				if (A && e.nodeType === 1) {
					e.sizcache = x;
					e.sizset = v
				}
				e = e[t];
				var w = false;
				while (e) {
					if (e.sizcache === x) {
						w = C[e.sizset];
						break
					}
					if (e.nodeType === 1 && !B) {
						e.sizcache = x;
						e.sizset = v
					}
					if (e.nodeName === y) {
						w = e;
						break
					}
					e = e[t]
				}
				C[v] = w
			}
		}
	}
	function s(t, y, x, C, z, B) {
		var A = t == "previousSibling" && !B;
		for ( var v = 0, u = C.length; v < u; v++) {
			var e = C[v];
			if (e) {
				if (A && e.nodeType === 1) {
					e.sizcache = x;
					e.sizset = v
				}
				e = e[t];
				var w = false;
				while (e) {
					if (e.sizcache === x) {
						w = C[e.sizset];
						break
					}
					if (e.nodeType === 1) {
						if (!B) {
							e.sizcache = x;
							e.sizset = v
						}
						if (typeof y !== "string") {
							if (e === y) {
								w = true;
								break
							}
						} else {
							if (b.filter(y, [ e ]).length > 0) {
								w = e;
								break
							}
						}
					}
					e = e[t]
				}
				C[v] = w
			}
		}
	}
	var h = document.compareDocumentPosition ? function(t, e) {
		return t.compareDocumentPosition(e) & 16
	} : function(t, e) {
		return t !== e && (t.contains ? t.contains(e) : true)
	};
	var q = function(e) {
		return e.nodeType === 9 && e.documentElement.nodeName !== "HTML"
				|| !!e.ownerDocument
				&& e.ownerDocument.documentElement.nodeName !== "HTML"
	};
	var g = function(e, z) {
		var v = [], w = "", x, u = z.nodeType ? [ z ] : z;
		while ((x = f.match.PSEUDO.exec(e))) {
			w += x[0];
			e = e.replace(f.match.PSEUDO, "")
		}
		e = f.relative[e] ? e + "*" : e;
		for ( var y = 0, t = u.length; y < t; y++) {
			b(e, u[y], v)
		}
		return b.filter(w, v)
	};
	QZFL.selector.engine = b
})();
(function() {
	var a = null;
	QZFL.element = {
		get : function(b, c) {
			if (b.nodeType) {
				b = [ b ]
			}
			return new a(b, c)
		},
		extend : function(b) {
			QZFL.namespace.extend(a, b)
		},
		extendFn : function(b) {
			QZFL.namespace.extend(a.prototype, b)
		},
		getVersion : function() {
			return a.version
		}
	};
	QZFL.ElementHandler = function(b, c) {
		this.elements = null;
		this._isElementHandler = true;
		this._init(b, c)
	};
	a = QZFL.ElementHandler;
	a.prototype = {
		_init : function(b, c) {
			if (typeof (b) == "string") {
				this.elements = QZFL.selector.query(b, c)
			} else {
				this.elements = b
			}
		},
		findElements : function(b) {
			var c = [];
			this.each(function(d) {
				var e = QZFL.selector.query(b, d);
				if (e.length > 0) {
					c = c.concat(e)
				}
			});
			return c
		},
		find : function(b) {
			return QZFL.element.get(this.findElements(b))
		},
		each : function(b) {
			QZFL.object.each(this.elements, b)
		},
		concat : function(b) {
			return QZFL.element.get(this.elements
					.concat(!!b._isElementHandler ? b.elements : b))
		},
		get : function(b) {
			return QZFL.element.get(this.elements[b])
		}
	};
	window.$e = QZFL.element.get
})();
QZFL.element.extend({
	version : "1.0"
});
QZFL.element.extendFn({
	bind : function(b, a) {
		this.each(function(c) {
			QZFL.event.addEvent(c, b, a)
		})
	},
	unBind : function(b, a) {
		this.each(function(c) {
			QZFL.event.removeEvent(c, b, a)
		})
	},
	onClick : function(a) {
		this.bind("click", a)
	},
	onHover : function(a) {
	}
});
QZFL.element.extendFn({
	setHtml : function(a) {
		this.setAttr("innerHTML", a)
	},
	getHtml : function(b) {
		var a = this.elements[b || 0];
		return !!a ? a.innerHTML : null
	},
	setVal : function(b) {
		if (QZFL.object.getType(b) == "array") {
			var a = "\x00" + b.join("\x00") + "\x00";
			this
					.each(function(c) {
						if (/radio|checkbox/.test(c.type)) {
							c.checked = c.nodeType
									&& ("\x00"
											+ a.indexOf(c.value.toString()
													+ "\x00") > -1 || a
											.indexOf("\x00" + c.name.toString()
													+ "\x00") > -1)
						} else {
							if (c.tagName == "SELECT") {
								QZFL.object.each(c.options, function(d) {
									d.selected = d.nodeType == 1
											&& ("\x00"
													+ a.indexOf(d.value
															.toString()
															+ "\x00") > -1 || a
													.indexOf("\x00"
															+ d.text.toString()
															+ "\x00") > -1)
								})
							} else {
								c.value = b
							}
						}
					})
		} else {
			this.setAttr("value", b)
		}
	},
	getVal : function(b) {
		var a = this.elements[b || 0], c;
		if (a) {
			if (a.tagName == "SELECT") {
				c = [];
				if (a.selectedIndex < 0) {
					return null
				}
				if (a.type == "select-one") {
					c.push(a.value)
				} else {
					QZFL.object.each(a.options, function(d) {
						if (d.nodeType == 1 && d.selected) {
							c.push(d.value)
						}
					})
				}
			} else {
				c = a.value
			}
		} else {
			return null
		}
		return c
	},
	addClass : function(a) {
		this.each(function(b) {
			QZFL.css.addClassName(b, a)
		})
	},
	removeClass : function(a) {
		this.each(function(b) {
			QZFL.css.removeClassName(b, a)
		})
	},
	toggleClass : function(a) {
		this.each(function(b) {
			QZFL.css.toggleClassName(b, a)
		})
	},
	getSize : function(b) {
		var a = this.elements[b || 0];
		return !!a ? QZFL.dom.getSize(a) : null
	},
	getXY : function(b) {
		var a = this.elements[b || 0];
		return !!a ? QZFL.dom.getXY(a) : null
	},
	setSize : function(b, a) {
		this.each(function(c) {
			QZFL.dom.setSize(c, b, a)
		})
	},
	setXY : function(b, a) {
		this.each(function(c) {
			QZFL.dom.setXY(c, b, a)
		})
	},
	hide : function() {
		this.each(function(a) {
			QZFL.dom.setStyle(a, "display", "none")
		})
	},
	show : function() {
		this.each(function(a) {
			QZFL.dom.setStyle(a, "display", "")
		})
	},
	getStyle : function(c, b) {
		var a = this.elements[b || 0];
		return !!a ? QZFL.dom.getStyle(a, c) : null
	},
	setStyle : function(a, b) {
		this.each(function(c) {
			QZFL.dom.setStyle(c, a, b)
		})
	},
	setAttr : function(a, b) {
		a = (a == "class" ? "className" : a);
		this.each(function(c) {
			c[a] = b
		})
	},
	getAttr : function(c, b) {
		c = (c == "class" ? "className" : c);
		var a = this.elements[b || 0];
		return !!a ? (a[c] || a.getAttribute(c)) : null
	}
});
QZFL.element.extendFn({
	getPrev : function() {
		var a = [];
		this.each(function(c) {
			var b = QZFL.dom.getPreviousSibling(c);
			a.push(b)
		});
		return QZFL.element.get(a)
	},
	getNext : function() {
		var a = [];
		this.each(function(c) {
			var b = QZFL.dom.getNextSibling(c);
			a.push(b)
		});
		return QZFL.element.get(a)
	},
	getChildren : function() {
		var a = [];
		this.each(function(b) {
			var c = QZFL.dom.getFirstChild(b);
			while (c) {
				if (!!c && c.nodeType == 1) {
					a.push(c)
				}
				c = c.nextSibling
			}
		});
		return QZFL.element.get(a)
	},
	getParent : function() {
		var a = [];
		this.each(function(c) {
			var b = c.parentNode;
			a.push(b)
		});
		return QZFL.element.get(a)
	}
});
QZFL.element
		.extendFn({
			create : function(c, b) {
				var a = [];
				this.each(function(d) {
					a.push(QZFL.dom.createElementIn(c, d, false, b))
				});
				return QZFL.element.get(a)
			},
			appendTo : function(a) {
				var a = (a.elements && a.elements[0]) || QZFL.dom.get(a);
				this.each(function(b) {
					a.appendChild(b)
				})
			},
			insertAfter : function(b) {
				var b = (b.elements && b.elements[0]) || QZFL.dom.get(b), c = b.nextSibling, a = b.parentNode;
				this.each(function(d) {
					a[!c ? "appendChild" : "insertBefore"](d, c)
				})
			},
			insertBefore : function(b) {
				var b = (b.elements && b.elements[0]) || QZFL.dom.get(b), a = b.parentNode;
				this.each(function(c) {
					a.insertBefore(c, b)
				})
			},
			remove : function() {
				this.each(function(a) {
					QZFL.dom.removeElement(a)
				})
			}
		});
QZFL.queue = (function() {
	var b = QZFL.object;
	var d = {};
	var a = function(f, e) {
		if (this instanceof arguments.callee) {
			this._qz_queuekey = f;
			return this
		}
		if (b.getType(e = e || []) == "array") {
			d[f] = e
		}
		return new a(f)
	};
	var c = {
		push : function(e, f) {
			f = this._qz_queuekey ? e : f;
			d[this._qz_queuekey || e].push(f)
		},
		shift : function(e) {
			var f = d[this._qz_queuekey || e];
			if (f) {
				return QZFL.queue._exec(f.shift())
			}
		},
		getLen : function(e) {
			return d[this._qz_queuekey || e].length
		},
		run : function(e) {
			var f = d[this._qz_queuekey || e];
			if (f) {
				b.each(d[this._qz_queuekey || e], QZFL.queue._exec)
			}
		},
		_exec : function(h, f, g) {
			if (!h || b.getType(h) != "function") {
				if (b.getType(f) == "number") {
					g[f] = null
				}
				return false
			}
			try {
				return h()
			} catch (i) {
				QZFL.console.print("QZFL Queue Got An Error: [" + i.name
						+ "]  " + i.message, 1)
			}
		}
	};
	b.extend(a.prototype, c);
	b.extend(a, c);
	return a
})();
QZFL.string = {};
QZFL.util = {
	buildUri : function(a) {
		return QZFL.util.URI(a)
	},
	URI : function(d) {
		if (!QZFL.object.getType(d) == "string") {
			return null
		}
		if (d.indexOf("://") < 1) {
			d = location.protocol
					+ "//"
					+ location.host
					+ (d.indexOf("/") == 0 ? "" : location.pathname.substr(0,
							location.pathname.lastIndexOf("/") + 1)) + d
		}
		var c = d.split("://");
		if (QZFL.object.getType(c) == "array" && c.length > 1
				&& (/^[a-zA-Z]+$/).test(c[0])) {
			this.protocol = c[0].toLowerCase();
			var b = c[1].split("/");
			if (QZFL.object.getType(b) == "array") {
				this.host = b[0];
				this.pathname = "/"
						+ b.slice(1).join("/").replace(/(\?|\#).+/i, "");
				this.href = d;
				var e = c[1].lastIndexOf("?"), a = c[1].lastIndexOf("#");
				this.search = (e >= 0) ? c[1].substring(e) : "";
				this.hash = (a >= 0) ? c[1].substring(a) : "";
				if (this.search.length > 0 && this.hash.length > 0) {
					if (a < e) {
						this.search = ""
					} else {
						this.search = c[1].substring(e, a)
					}
				}
				return this
			} else {
				return null
			}
		} else {
			return null
		}
	}
};
QZFL.FormSender = function(b, d, a, c) {
	this.name = "_fpInstence_" + QZFL.FormSender.counter;
	QZFL.FormSender.instance[this.name] = this;
	QZFL.FormSender.counter++;
	this.method = d || "POST";
	this.uri = b;
	this.data = (typeof (a) == "object" || typeof (a) == "string") ? a : null;
	this.proxyURL = (typeof (c) == "string" && c.toUpperCase() == "UTF-8") ? QZFL.config.FSHelperPage
			.replace(/_gbk/, "_utf8")
			: QZFL.config.FSHelperPage;
	this._sender = null;
	this.onSuccess = QZFL.emptyFn;
	this.onError = QZFL.emptyFn
};
QZFL.FormSender.instance = {};
QZFL.FormSender.counter = 0;
QZFL.FormSender._errCodeMap = {
	999 : {
		msg : "Connection or Server error"
	}
};
QZFL.FormSender.prototype.send = function() {
	if (this.method == "POST" && this.data == null) {
		return false
	}
	function a(d) {
		d._sender = d._sender.callback = d._sender.errorCallback = d._sender.onreadystatechange = null;
		if (ua.safari || ua.opera) {
			setTimeout('removeNode($("_fp_frm_' + d.name + '"))', 50)
		} else {
			removeNode($("_fp_frm_" + d.name))
		}
	}
	if (this._sender === null || this._sender === void (0)) {
		var c = document.createElement("iframe");
		c.id = "_fp_frm_" + this.name;
		c.style.width = c.style.height = c.style.borderWidth = "0";
		c.style.display = "none";
		document.body.appendChild(c);
		c.callback = QZFL.event.bind(this, function(d) {
			clearInterval(b);
			a(this);
			this.onSuccess(d)
		});
		c.errorCallback = QZFL.event.bind(this, function(d) {
			clearInterval(b);
			a(this);
			this.onError(d)
		});
		if (typeof c.onreadystatechange != "undefined") {
			c.onreadystatechange = QZFL.event.bind(this, function() {
				if (this._sender.readyState == "complete"
						&& this._sender.submited) {
					a(this);
					this.onError(QZFL.FormSender._errCodeMap[999])
				}
			})
		} else {
			var b = setInterval(QZFL.event.bind(this, function() {
				try {
					var e = this._sender.contentWindow.location.href;
					if (e.indexOf(this.uri) == 0) {
						a(this);
						this.onError(QZFL.FormSender._errCodeMap[999]);
						clearInterval(b)
					}
				} catch (d) {
					a(this);
					this.onError(QZFL.FormSender._errCodeMap[999]);
					clearInterval(b)
				}
			}), 100)
		}
		this._sender = c
	}
	this._sender.src = this.proxyURL;
	return true
};
QZFL.FormSender.prototype.destroy = function() {
	var a = this.name;
	delete QZFL.FormSender.instance[a]._sender;
	QZFL.FormSender.instance[a]._sender = null;
	delete QZFL.FormSender.instance[a];
	QZFL.FormSender.counter--;
	return null
};
QZFL.JsLoader = function(a) {
	this.loaded = false;
	this.debug = a || (QZFL.config.debugLevel > 1);
	this.onload = QZFL.emptyFn;
	this.onerror = QZFL.emptyFn
};
QZFL.JsLoader.scriptId = 1;
QZFL.JsLoader.prototype.load = function(d, b, e) {
	var a = QZFL.JsLoader.scriptId;
	QZFL.JsLoader.scriptId++;
	var c = this;
	setTimeout(function() {
		c._load2.apply(c, [ a, d, b, e ]);
		c = null
	}, 0)
};
QZFL.JsLoader.prototype._load2 = function(c, e, d, f) {
	_doc = d || document;
	f = f || "gb2312";
	var b = QZFL.userAgent.ie, a = _doc.createElement("script");
	QZFL.event
			.addEvent(
					a,
					(b ? "readystatechange" : "load"),
					(function(g) {
						return (function() {
							if (b) {
								if (a
										&& !(a.readyState == "complete" || a.readyState == "loaded")) {
									return
								}
							}
							g.onload();
							if (!g.debug) {
								QZFL.dom.removeElement(a)
							}
							a = null
						})
					})(this));
	if (!b) {
		QZFL.event.addEvent(a, "error", (function(g) {
			return (function() {
				g.onerror();
				if (!g.debug) {
					QZFL.dom.removeElement(a)
				}
				a = null
			})
		})(this))
	}
	a.id = "js_" + c;
	a.defer = true;
	a.charset = f;
	a.src = e;
	_doc.getElementsByTagName("head")[0].appendChild(a)
};
QZFL.jsLoader = QZFL.JsLoader;
QZFL.enviroment = (function() {
	var a = {}, c = {};
	function e(f) {
		return a[f]
	}
	function d(f) {
		delete a[f];
		return true
	}
	function b(g, f) {
		if (typeof f == "undefined") {
			if (typeof g == "undefined") {
				return false
			} else {
				if (!(a[g] === undefined)) {
					return false
				}
			}
		} else {
			a[g] = f;
			return true
		}
	}
	return {
		get : e,
		set : b,
		del : d,
		hookPool : c
	}
})();
var ENV = QZFL.enviroment;
QZFL.pageEvents = (function() {
	function _ihp() {
		var qs = location.search.substring(1), qh = location.hash.substring(1), s, h, n;
		ENV.set("_queryString", qs);
		ENV.set("_queryHash", qh);
		ENV.set("queryString", s = QZFL.util.splitHttpParamString(qs));
		ENV.set("queryHash", h = QZFL.util.splitHttpParamString(qh));
		if (s && s.DEBUG) {
			n = parseInt(s.DEBUG, 10);
			if (!isNaN(n)) {
				QZFL.config.debugLevel = n
			}
		}
	}
	function _bootStrap() {
		if (document.addEventListener) {
			if (ua.safari) {
				var interval = setInterval(function() {
					if ((/loaded|complete/).test(document.readyState)) {
						_onloadHook();
						clearInterval(interval)
					}
				}, 50)
			} else {
				document
						.addEventListener("DOMContentLoaded", _onloadHook, true)
			}
		} else {
			var src = "javascript:void(0)";
			if (window.location.protocol == "https:") {
				src = "//:"
			}
			document
					.write('<script onreadystatechange="if(this.readyState==\'complete\'){this.parentNode.removeChild(this);QZFL.pageEvents._onloadHook();}" defer="defer" src="'
							+ src + '"><\/script>')
		}
		window.onload = QZFL.lang.chain(window.onload, function() {
			_onloadHook();
			_runHooks("onafterloadhooks")
		});
		window.onbeforeunload = function() {
			return _runHooks("onbeforeunloadhooks")
		};
		window.onunload = QZFL.lang.chain(window.onunload, function() {
			_runHooks("onunloadhooks")
		})
	}
	function _onloadHook() {
		_runHooks("onloadhooks");
		QZFL.enviroment.loaded = true
	}
	function _runHook(handler) {
		try {
			handler()
		} catch (ex) {
		}
	}
	function _runHooks(hooks) {
		var isbeforeunload = (hooks == "onbeforeunloadhooks"), warn = null, hc = window.ENV.hookPool;
		do {
			var h = hc[hooks];
			if (!isbeforeunload) {
				hc[hooks] = null
			}
			if (!h) {
				break
			}
			for ( var ii = 0; ii < h.length; ii++) {
				if (isbeforeunload) {
					warn = warn || h[ii]()
				} else {
					h[ii]()
				}
			}
			if (isbeforeunload) {
				break
			}
		} while (hc[hooks]);
		if (isbeforeunload) {
			if (warn) {
				return warn
			} else {
				QZFL.enviroment.loaded = false
			}
		}
	}
	function _addHook(hooks, handler) {
		var c = window.ENV.hookPool;
		(c[hooks] ? c[hooks] : (c[hooks] = [])).push(handler)
	}
	function _insertHook(hooks, handler, position) {
		var c = window.ENV.hookPool;
		if (typeof (position) == "number" && position >= 0 && c[hooks]) {
			c[hooks].splice(position, 0, handler)
		} else {
			return false
		}
	}
	function _lr(handler) {
		QZFL.enviroment.loaded ? _runHook(handler) : _addHook("onloadhooks",
				handler)
	}
	function _bulr(handler) {
		_addHook("onbeforeunloadhooks", handler)
	}
	function _ulr(handler) {
		_addHook("onunloadhooks", handler)
	}
	function pinit() {
		_bootStrap();
		_ihp();
		ua.adjustBehaviors();
		var _dt = $("__DEBUG_out");
		if (_dt) {
			ENV.set("dout", _dt)
		}
		var __dalert;
		if (!ENV.get("alertConverted")) {
			__dalert = alert;
			eval("var alert=function(msg){if(msg!=undefined){__dalert(msg);return msg;}}");
			ENV.set("alertConverted", true)
		}
		var t = ENV.get("queryHash");
		if (t && t.DEBUG) {
			QZFL.config.debugLevel = 2
		}
	}
	return {
		onloadRegister : _lr,
		onbeforeunloadRegister : _bulr,
		onunloadRegister : _ulr,
		initHttpParams : _ihp,
		bootstrapEventHandlers : _bootStrap,
		_onloadHook : _onloadHook,
		insertHooktoHooksQueue : _insertHook,
		pageBaseInit : pinit
	}
})();
QZFL.lang = {
	isString : function(a) {
		return QZFL.object.getType(a) == "string"
	},
	isArray : function(a) {
		return QZFL.object.getType(a) == "array"
	},
	isHashMap : function(a) {
		return QZFL.object.getType(a) == "object"
	},
	isNode : function(b) {
		if (typeof (Node) == "undefined") {
			Node = null
		}
		try {
			if (!b || !((Node != undefined && b instanceof Node) || b.nodeName)) {
				return false
			}
		} catch (a) {
			return false
		}
		return true
	},
	isElement : function(a) {
		return a && a.nodeType == 1
	},
	isValidXMLdom : function(a) {
		if (!a) {
			return false
		}
		if (!a.xml) {
			return false
		}
		if (a.xml == "") {
			return false
		}
		if (!(/^<\?xml/.test(a.xml))) {
			return false
		}
		return true
	},
	arg2arr : function(b, a) {
		if (typeof a == "undefined") {
			a = 0
		}
		return Array.prototype.slice.apply(b, [ a, b.length ])
	},
	getObjByNameSpace : function(e, b) {
		if (typeof (e) != "string") {
			return e
		}
		var c = e.split("."), f = window;
		try {
			for ( var d = 0, a = c.length; d < a; ++d) {
				if (typeof (f[c[d]]) == "undefined") {
					if (b) {
						f[c[d]] = {}
					} else {
						return void (0)
					}
				}
				f = f[c[d]]
			}
			return f
		} catch (g) {
			return void (0)
		}
	},
	objectClone : function(d, c) {
		if ((typeof d) == "object") {
			var b = (QZFL.lang.isArray(d)) ? [] : {};
			for ( var a in d) {
				if (a != c) {
					b[a] = objectClone(d[a], c)
				}
			}
			return b
		} else {
			if ((typeof d) == "function") {
				return (new d()).constructor
			}
		}
		return d
	},
	obj2str : function(d) {
		var c, a;
		if ((typeof d) == "object") {
			if (d === null) {
				return "null"
			}
			a = QZFL.lang.isArray(d);
			c = [];
			for ( var b in d) {
				c.push((a ? "" : ('"' + QZFL.string.escString(b) + '":'))
						+ obj2str(d[b]))
			}
			c = c.join();
			return a ? ("[" + c + "]") : ("{" + c + "}")
		} else {
			if ((typeof d) == "function") {
				return ""
			} else {
				if ((typeof d) == "undefined") {
					return "undefined"
				} else {
					if ((typeof d) == "number") {
						return d.toString()
					}
				}
			}
		}
		return !d ? '""' : ('"' + QZFL.string.escString(d) + '"')
	},
	propertieCopy : function(e, a, f, d) {
		var c = (!f || typeof (f) != "object") ? a : f;
		e = e || {};
		for ( var g in c) {
			if (!d || !(g in e)) {
				e[g] = c[g]
			}
		}
		return e
	},
	tryThese : function() {
		var b;
		for ( var c = 0, a = arguments.length; c < a; c++) {
			try {
				b = arguments[c]();
				return b
			} catch (d) {
			}
		}
		return b
	},
	chain : function(c, b) {
		var d = [];
		for ( var e = 0, a = arguments.length; e < a; e++) {
			d.push(arguments[e])
		}
		return (function() {
			for ( var g = 0, f = d.length; g < f; g++) {
				if (d[g] && d[g].apply(null, arguments) === false) {
					return false
				}
			}
			return true
		})
	},
	uniqueArray : function(a) {
		var b = {};
		var c = 0;
		while (c < a.length) {
			if (b[a[c]] == typeof (a[c])) {
				a.splice(c, 1);
				continue
			}
			b[a[c].toString()] = typeof (a[c]);
			++c
		}
		return a
	}
};
QZFL.namespace.map(QZFL.lang);
(function() {
	QZFL.object
			.extend(
					QZFL.string,
					{
						RegExps : {
							trim : /^\s*|\s*$/g,
							ltrim : /^\s*/g,
							rtrim : /\s*$/g,
							nl2br : /\n/g,
							s2nb : /[\x20]{2}/g,
							URIencode : /[\x09\x0A\x0D\x20\x21-\x29\x2B\x2C\x2F\x3A-\x3F\x5B-\x5E\x60\x7B-\x7E]/g,
							escHTML : {
								re_amp : /&/g,
								re_lt : /</g,
								re_gt : />/g,
								re_apos : /\x27/g,
								re_quot : /\x22/g
							},
							escString : {
								bsls : /\\/g,
								nl : /\n/g,
								rt : /\r/g,
								tab : /\t/g
							},
							restXHTML : {
								re_amp : /&amp;/g,
								re_lt : /&lt;/g,
								re_gt : /&gt;/g,
								re_apos : /&(?:apos|#0?39);/g,
								re_quot : /&quot;/g
							},
							write : /\{(\d{1,2})(?:\:([xodQqb]))?\}/g,
							isURL : /^(?:ht|f)tp(?:s)?\:\/\/(?:[\w\-\.]+)\.\w+/i,
							cut : /[\x00-\xFF]/,
							getRealLen : {
								r0 : /[^\x00-\xFF]/g,
								r1 : /[\x00-\xFF]/g
							}
						},
						commonReplace : function(a, c, b) {
							return a.replace(c, b)
						},
						listReplace : function(c, a) {
							if (isHashMap(a)) {
								for ( var b in a) {
									c = (QZFL.string.commonReplace(c, a[b], b) || c)
								}
								return c
							} else {
								return c
							}
						},
						trim : function(a) {
							return QZFL.string.commonReplace(a + "",
									QZFL.string.RegExps.trim, "")
						},
						ltrim : function(a) {
							return QZFL.string.commonReplace(a + "",
									QZFL.string.RegExps.ltrim, "")
						},
						rtrim : function(a) {
							return QZFL.string.commonReplace(a + "",
									QZFL.string.RegExps.rtrim, "")
						},
						nl2br : function(a) {
							return QZFL.string.commonReplace(a + "",
									QZFL.string.RegExps.nl2br, "<br />")
						},
						s2nb : function(a) {
							return QZFL.string.commonReplace(a + "",
									QZFL.string.RegExps.s2nb, "&nbsp;&nbsp;")
						},
						URIencode : function(a) {
							var c, b;
							return (a + "").replace(
									QZFL.string.RegExps.URIencode, function(d) {
										if (d == "\x20") {
											return "+"
										} else {
											if (d == "\x0D") {
												return ""
											}
										}
										c = d.charCodeAt(0);
										b = c.toString(16);
										return "%" + ((c < 16) ? ("0" + b) : b)
									})
						},
						escHTML : function(b) {
							var a = QZFL.string.RegExps.escHTML;
							return QZFL.string.listReplace((b + ""), {
								"&amp;" : a.re_amp,
								"&lt;" : a.re_lt,
								"&gt;" : a.re_gt,
								"&#039;" : a.re_apos,
								"&quot;" : a.re_quot
							})
						},
						escString : function(b) {
							var a = QZFL.string.RegExps.escString;
							return QZFL.string.listReplace((b + ""), {
								"\\\\" : a.bsls,
								"\\n" : a.nl,
								"" : a.rt,
								"\\t" : a.tab,
								"\\'" : a.re_apos,
								'\\"' : a.re_quot
							})
						},
						restHTML : function(b) {
							if (!QZFL.string.restHTML.__utilDiv) {
								QZFL.string.restHTML.__utilDiv = document
										.createElement("div")
							}
							var a = QZFL.string.restHTML.__utilDiv;
							a.innerHTML = (b + "");
							if (typeof (a.innerText) != "undefined") {
								return a.innerText
							} else {
								if (typeof (a.textContent) != "undefined") {
									return a.textContent
								} else {
									if (typeof (a.text) != "undefined") {
										return a.text
									} else {
										return ""
									}
								}
							}
						},
						restXHTML : function(b) {
							var a = QZFL.string.RegExps.restXHTML;
							return QZFL.string.listReplace((b + ""), {
								"<" : a.re_lt,
								">" : a.re_gt,
								"\x27" : a.re_apos,
								"\x22" : a.re_quot,
								"&" : a.re_amp
							})
						},
						write : function(d, e) {
							if (arguments.length < 1 || !isString(d)) {
								return ""
							}
							var c = arg2arr(arguments), a = c.shift(), b;
							return a
									.replace(
											QZFL.string.RegExps.write,
											function(g, f, h) {
												f = parseInt(f, 10);
												if (f < 0
														|| (typeof c[f] == "undefined")) {
													return "(n/a)"
												} else {
													if (!h) {
														return c[f]
													} else {
														switch (h) {
														case "x":
															return "0x"
																	+ c[f]
																			.toString(16);
														case "o":
															return "o"
																	+ c[f]
																			.toString(8);
														case "d":
															return c[f]
																	.toString(10);
														case "Q":
															return "\x22"
																	+ c[f]
																			.toString(16)
																	+ "\x22";
														case "q":
															return "`"
																	+ c[f]
																			.toString(16)
																	+ "\x27";
														case "b":
															return "<" + !!c[f]
																	+ ">"
														}
													}
												}
											})
						},
						isURL : function(a) {
							return QZFL.string.RegExps.isURL.test(a)
						},
						customEncode : function(b, a) {
							var c;
							if (typeof a == "undefined") {
								a = ""
							}
							switch (a.toUpperCase()) {
							case "URICPT":
								c = encodeURIComponent(b);
								break;
							default:
								c = encodeURIComponent(b)
							}
							return c
						},
						escapeURI : function(a) {
							if (!isString(a)) {
								return ""
							}
							if (window.encodeURIComponent) {
								return encodeURIComponent(a)
							}
							if (window.escape) {
								return escape(a)
							}
						},
						parseXML : function(c) {
							if (window.ActiveXObject) {
								var b = QZFL.lang.tryThese(function() {
									return new ActiveXObject(
											"MSXML2.DOMDocument.6.0")
								}, function() {
									return new ActiveXObject(
											"MSXML2.DOMDocument.5.0")
								}, function() {
									return new ActiveXObject(
											"MSXML2.DOMDocument.4.0")
								}, function() {
									return new ActiveXObject(
											"MSXML2.DOMDocument.3.0")
								}, function() {
									return new ActiveXObject(
											"MSXML2.DOMDocument")
								},
										function() {
											return new ActiveXObject(
													"Microsoft.XMLDOM")
										});
								b.async = "false";
								b.loadXML(c);
								if (b.parseError.reason) {
									return null
								}
							} else {
								var d = new DOMParser();
								var b = d.parseFromString(c, "text/xml");
								if (b.documentElement.nodeName == "parsererror") {
									return null
								}
							}
							var a = b.documentElement;
							return a
						},
						fillLength : function(e, a, d, b) {
							if (typeof (e) != "string") {
								e = e.toString()
							}
							if (e.length < a) {
								var c = (1 << (a - e.length)).toString(2)
										.substring(1);
								if (typeof (d) != "undefined" && !!d) {
									c = c.replace("0", d.toString()).substring(
											1)
								}
								return b ? (e + c) : (c + e)
							} else {
								return e
							}
						},
						cut : function(f, h, g) {
							if (typeof (f) != "string") {
								return ""
							}
							if (typeof (g) == "undefined") {
								g = ""
							}
							if (getRealLen(f) <= h) {
								return f
							}
							var e = [], d;
							for ( var c = 0, b = 0, a = f.length; c < a
									&& b < h; ++c) {
								e.push(d = f.charAt(c));
								if (QZFL.string.RegExps.cut.test(d)) {
									b++
								} else {
									b += 2
								}
							}
							return e.join("") + g
						},
						getRealLen : function(b, a) {
							if (typeof (b) != "string") {
								return 0
							}
							if (!a) {
								return b
										.replace(
												QZFL.string.RegExps.getRealLen.r0,
												"**").length
							} else {
								var c = b.replace(
										QZFL.string.RegExps.getRealLen.r1, "");
								return (b.length - c.length)
										+ (encodeURI(c).length / 3)
							}
						}
					})
})();
QZFL.string.timeFormatString = function(a, e, c) {
	var f, d = QZFL.string.timeFormatString;
	if (!d._init) {
		d._dL = [ "_ds", "_dm", "_dh", "_dd", "_dM", "_dy" ];
		d.re = /\{([_yYMdhms]{1,2})(\:[\d\w\s]|)\}/g;
		QZFL.object.each([ 1000, 60, 60, 24, 30, 12 ], function(h, g) {
			d[d._dL[g]] = !d._dL[g - 1] ? h : d[d._dL[g - 1]] * h
		});
		d._init = true
	}
	if (typeof (a) == "number") {
		f = new Date();
		f.setTime(a);
		a = f
	}
	if (typeof (a) == "object") {
		try {
			a.getTime()
		} catch (b) {
			return ""
		}
		if (typeof (e) != "string") {
			return a.toString()
		} else {
			return e.replace(d.re, function(h, g, j) {
				var i = d._fnSplit[g];
				return (typeof (i) == "function") ? i(a, j, d, c) : h
			})
		}
	}
};
QZFL.string.timeFormatString._fnSplit = {
	y : function(b, d) {
		var a = b.getYear().toString();
		return QZFL.string.fillLength(a.substring(a.length - 2), 2)
	},
	_y : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._dy;
		return Math.floor(a)
	},
	Y : function(a, b) {
		return QZFL.string.fillLength(a.getFullYear(), 2)
	},
	M : function(a, b) {
		return QZFL.string.fillLength(a.getMonth() + 1, 2, b)
	},
	_M : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._dM;
		return Math.floor(a)
	},
	d : function(a, b) {
		return QZFL.string.fillLength(a.getDate(), 2, b)
	},
	_d : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._dd;
		return Math.floor(a)
	},
	h : function(a, b) {
		return QZFL.string.fillLength(a.getHours(), 2, b)
	},
	_h : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._dh;
		return Math.floor(a)
	},
	m : function(a, b) {
		return QZFL.string.fillLength(a.getMinutes(), 2)
	},
	_m : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._dm;
		return Math.floor(a)
	},
	s : function(a, b) {
		return QZFL.string.fillLength(a.getSeconds(), 2)
	},
	_s : function(b, f, e, d) {
		var a = Math.abs(b - d) / e._ds;
		return Math.floor(a)
	}
};
QZFL.string.StringBuilder = function() {
	this._strList = arg2arr(arguments)
};
QZFL.string.StringBuilder.prototype = {
	append : function(a) {
		if (isString(a)) {
			this._strList.push(a.toString())
		}
	},
	insertFirst : function(a) {
		if (isString(a)) {
			this._strList.unshift(a.toString())
		}
	},
	appendArray : function(a) {
		if (isArray(a)) {
			this._strList = this._strList.concat(a)
		}
	},
	toString : function(a) {
		return this._strList.join(!a ? "" : a)
	},
	clear : function() {
		this._strList.splice(0, this._strList.length)
	}
};
(function() {
	QZFL.object.extend(QZFL.util, {
		copyToClip : function(b) {
			if (ua.ie) {
				return clipboardData.setData("Text", b)
			} else {
				var a = QZFL.shareObject.getValidSO();
				return a ? a.setClipboard(b) : false
			}
		},
		evalGlobal : function(c) {
			var b = document.createElement("script");
			b.type = "text/javascript";
			b.id = "__evalGlobal_" + QZFL.util.evalGlobal._counter;
			try {
				b.innerHTML = c
			} catch (a) {
				b.text = c
			}
			document.body.appendChild(b);
			QZFL.util.evalGlobal._counter++;
			setTimeout('removeNode($("' + b.id + '"));', 50)
		},
		runStyleGlobal : function(a) {
			if (ua.safari) {
				var d = document.createElement("style");
				d.type = "text/css";
				d.id = "__runStyle_" + QZFL.util.runStyleGlobal._counter;
				try {
					d.textContent = a
				} catch (c) {
					alert(c.message)
				}
				var b = document.getElementsByTagName("head")[0];
				if (b) {
					b.appendChild(d);
					QZFL.util.runStyleGlobal._counter++
				}
			} else {
				rt.warn("plz use runStyleGlobal() in Safari!")
			}
		},
		genHttpParamString : function(c) {
			if (QZFL.lang.isHashMap(c)) {
				var b = new QZFL.string.StringBuilder();
				try {
					for ( var a in c) {
						b.append(a + "="
								+ QZFL.string.customEncode(c[a], "URICPT"))
					}
				} catch (d) {
					return ""
				}
				return b.toString("&")
			} else {
				if (typeof (c) == "string") {
					return c
				} else {
					return ""
				}
			}
		},
		splitHttpParamString : function(a) {
			return QZFL.util.commonDictionarySplit(a, "&")
		},
		commonDictionarySplit : function(j, b, a) {
			if (typeof (b) == "undefined") {
				b = "&"
			}
			if (typeof (a) == "undefined") {
				a = ""
			}
			var f = new RegExp("^" + a + "|" + a + "$", "g");
			if (isString(j)) {
				var c = j.split(a + b), d, h = {};
				for ( var e = 0, g = c.length; e < g; e++) {
					d = c[e].split("=");
					if (d.length > 1) {
						h[d[0]] = (d.slice(1).join("=")).replace(f, "")
					} else {
						h[c[e]] = true
					}
				}
				return h
			} else {
				return {}
			}
		}
	});
	QZFL.util.evalGlobal._counter = 0;
	QZFL.util.runStyleGlobal._counter = 0
})();
QZFL.media = {
	_tempImageList : [],
	_flashVersion : null,
	adjustImageSize : function(a, d, c, g) {
		var e = QZFL.event.getTarget();
		if (ua.firefox < 3 && e === document) {
			e = QZFL.event.getEvent().currentTarget
		}
		e.onload = null;
		var f, b = QZFL.media._tempImageList;
		b[f = b.length] = new Image();
		b[f].onload = (function(i, j, h, k) {
			return function() {
				j.onload = null;
				var m = j.width, n = j.height;
				if (m / n > h / k) {
					if (m > h) {
						i.width = h
					}
				} else {
					if (n > k) {
						i.height = k
					}
				}
				i.src = j.src;
				b[f] = null;
				delete b[f];
				if (typeof (g) == "function") {
					g(i, a, d, j, m, n)
				}
			}
		})(e, b[f], a, d);
		b[f].onerror = function() {
			b[f] = null;
			delete b[f]
		};
		b[f].src = c
	},
	getFlashHtml : function(b, g, f) {
		var h = new QZFL.string.StringBuilder(), d = new QZFL.string.StringBuilder();
		if (typeof (f) == "undefined") {
			f = "D27CDB6E-AE6D-11cf-96B8-444553540000"
		}
		for ( var c in b) {
			switch (c) {
			case "movie":
				continue;
				break;
			case "id":
			case "name":
			case "width":
			case "height":
			case "style":
				h.append(c + "='" + b[c] + "' ");
				break;
			default:
				d.append("<param name='" + ((c == "src") ? "movie" : c)
						+ "' value='" + (b[c]) + "' />");
				h.append(c + "='" + b[c] + "' ")
			}
		}
		if (g && (g instanceof QZFL.media.SWFVersion)) {
			var a = QZFL.media.getFlashVersion().major;
			var e = g.major;
			h
					.append("codeBase='http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab#version="
							+ g + "' ")
		}
		if (ua.ie) {
			return "<object classid='clsid:" + f + "' " + h + ">" + d
					+ "</object>"
		} else {
			return "<embed "
					+ h
					+ " pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash'></embed>"
		}
	},
	getWMMHtml : function(c, e) {
		var d = new QZFL.string.StringBuilder();
		var b = new QZFL.string.StringBuilder();
		if (typeof (e) == "undefined") {
			e = "clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6"
		}
		for ( var a in c) {
			switch (a) {
			case "id":
			case "width":
			case "height":
			case "style":
				b.append(a + '="' + c[a] + '" ');
				break;
			case "src":
				b.append(a + '="' + c[a] + '" ');
				break;
			default:
				b.append(a + '="' + c[a] + '" ');
				d.append('<param name="' + a + '" value="' + c[a] + '" />')
			}
		}
		if (c.src) {
			d.append('<param name="URL" value="' + c.src + '" />')
		}
		if (ua.ie) {
			return '<object classid="' + e + '" ' + b + ">" + d + "</object>"
		} else {
			return "<embed " + b + "></embed>"
		}
	}
};
QZFL.media.SWFVersion = function() {
	var b;
	if (arguments.length > 1) {
		b = arg2arr(arguments)
	} else {
		if (arguments.length == 1) {
			if (typeof (arguments[0]) == "object") {
				b = arguments[0]
			} else {
				if (typeof arguments[0] == "number") {
					b = [ arguments[0] ]
				} else {
					b = []
				}
			}
		} else {
			b = []
		}
	}
	this.major = parseInt(b[0], 10) || 0;
	this.minor = parseInt(b[1], 10) || 0;
	this.rev = parseInt(b[2], 10) || 0;
	this.add = parseInt(b[3], 10) || 0
};
QZFL.media.SWFVersion.prototype.toString = function(a) {
	return ([ this.major, this.minor, this.rev, this.add ])
			.join((typeof a == "undefined") ? "," : a)
};
QZFL.media.SWFVersion.prototype.toNumber = function() {
	var a = 0.001;
	return this.major + this.minor * a + this.rev * a * a + this.add * a * a
			* a
};
QZFL.media.getFlashVersion = function() {
	if (!QZFL.media._flashVersion) {
		var b = 0;
		if (navigator.plugins && navigator.mimeTypes.length) {
			var a = navigator.plugins["Shockwave Flash"];
			if (a && a.description) {
				b = a.description.replace(/(?:[a-z]|[A-Z]|\s)+/, "").replace(
						/(?:\s+r|\s+b[0-9]+)/, ".").split(".")
			}
		} else {
			try {
				for ( var d = (b = 6), c = new Object(); c != null; ++d) {
					c = new ActiveXObject("ShockwaveFlash.ShockwaveFlash." + d);
					b = d
				}
			} catch (f) {
				if (b == 6) {
					b = 0
				}
				b = Math.max(b - 1, 0)
			}
			try {
				b = new QZFL.media.SWFVersion(c.GetVariable("$version").split(
						" ")[1].split(","))
			} catch (g) {
			}
		}
		if (!(b instanceof QZFL.media.SWFVersion)) {
			b = new QZFL.media.SWFVersion(b)
		}
		if (b.major < 3) {
			b.major = 0
		}
		QZFL.media._flashVersion = b
	}
	return QZFL.media._flashVersion
};
QZFL.media._changeFlashSrc = function(c, a, b) {
	if (a >= 6 && b > a) {
		c = "http://imgcache.qq.com/qzone/flashinstall.swf"
	}
	return c
};
var insertFlash = QZFL.media.getFlashHtml;
QZFL.dataCenter = (function() {
	var g = {}, c = [];
	function d(j, i) {
		c[j] = i;
		return true
	}
	function f(j, i) {
		var m = QZFL.shareObject.getValidSO();
		if (m) {
			return m.set("_dc_so_" + j, i)
		} else {
			return false
		}
	}
	function h(j, i) {
		var m = QZFL.config.DCCookieDomain;
		if (m) {
			return o.set("_dc_co_" + j, i, m, "/", 120)
		} else {
			return false
		}
	}
	function b(m) {
		var k = g[m];
		var j, i;
		if (typeof (k) == "undefined") {
			return k
		} else {
			k = k[k.length - 1];
			switch (k[1]) {
			case "memory":
				j = c[k[0]];
				break;
			case "soflash":
				i = QZFL.shareObject.getValidSO();
				if (i) {
					j = i.get("_dc_so_" + k[0])
				} else {
					i = null
				}
				break;
			case "cookie":
				i = QZFL.cookie;
				if (i) {
					j = i.get("_dc_co_" + k[0])
				} else {
					i = null
				}
				break;
			default:
				j = c[k[0]]
			}
		}
		return j
	}
	function e(m) {
		var k = g[m];
		var j, i;
		if (typeof (k) == "undefined") {
			return false
		} else {
			k = k[k.length - 1];
			switch (k[1]) {
			case "memory":
				delete c[k[0]];
				break;
			case "soflash":
				i = QZFL.shareObject.getValidSO();
				if (i) {
					j = i.del("_dc_so_" + m)
				}
				break;
			case "cookie":
				i = QZFL.cookie;
				if (i) {
					j = i.del("_dc_co_" + QZFL.config.DCCookieDomain, "/")
				}
				break;
			default:
				delete c[k[0]]
			}
		}
		delete g[m];
		return true
	}
	function a(i, j, m) {
		if (arguments.length < 2 || typeof (arguments[0]) != "string") {
			throw (new Error("必须提供键值对:\nkeyName{String}:value{String/Object}"));
			return false
		}
		var k = c.length;
		if (typeof (g[i]) == "undefined") {
			g[i] = []
		}
		g[i].push([ k, m ]);
		switch (m) {
		case "memory":
			return d(k, j);
		case "soflash":
			return f(k, j);
		case "cookie":
			return h(k, j);
		default:
			return d(k, j)
		}
		return false
	}
	return {
		save : a,
		get : b,
		load : b,
		del : e
	}
})();
QZFL.cookie = {
	set : function(d, f, e, g, a) {
		if (a) {
			var c = new Date();
			var b = new Date();
			b.setTime(c.getTime() + 3600000 * a)
		}
		document.cookie = d
				+ "="
				+ f
				+ "; "
				+ (a ? ("expires=" + b.toGMTString() + "; ") : "")
				+ (g ? ("path=" + g + "; ") : "path=/; ")
				+ (e ? ("domain=" + e + ";") : ("domain="
						+ QZFL.config.domainPrefix + ";"));
		return true
	},
	get : function(b) {
		var c = new RegExp("(?:^|;+|\\s+)" + b + "=([^;]*)");
		var a = document.cookie.match(c);
		return (!a ? "" : a[1])
	},
	del : function(a, b, c) {
		document.cookie = a
				+ "=; expires=Mon, 26 Jul 1997 05:00:00 GMT; "
				+ (c ? ("path=" + c + "; ") : "path=/; ")
				+ (b ? ("domain=" + b + ";") : ("domain="
						+ QZFL.config.domainPrefix + ";"))
	}
};
QZFL.shareObject = {};
QZFL.shareObject.create = function(b) {
	if (typeof (b) == "undefined") {
		b = QZFL.config.defaultShareObject
	}
	var a = new QZFL.shareObject.DataBase(b)
};
QZFL.shareObject.instance = {};
QZFL.shareObject.refCount = 0;
QZFL.shareObject.getValidSO = function() {
	var b = QZFL.shareObject.refCount + 1;
	for ( var a = 1; a < b; ++a) {
		if (QZFL.shareObject.instance["so_" + a]
				&& QZFL.shareObject.instance["so_" + a]._ready) {
			return QZFL.shareObject.instance["so_" + a]
		}
	}
	return null
};
QZFL.shareObject.get = function(a) {
	var b = QZFL.shareObject.getValidSO();
	if (b) {
		return b.get(a)
	} else {
		return void (0)
	}
};
QZFL.shareObject.set = function(b, a) {
	var c = QZFL.shareObject.getValidSO();
	if (c) {
		return c.set(b, a)
	} else {
		return false
	}
};
QZFL.shareObject.DataBase = function(a) {
	if (QZFL.shareObject.refCount > 0) {
		return QZFL.shareObject.instance.so_1
	}
	this._ready = false;
	QZFL.shareObject.refCount++;
	var b = document.createElement("div");
	b.style.marginTop = "-1px";
	document.body.appendChild(b);
	b.innerHTML = QZFL.media.getFlashHtml({
		src : a,
		id : "__so" + QZFL.shareObject.refCount,
		width : 0,
		height : 0,
		allowscriptaccess : "always"
	});
	this.ele = $("__so" + QZFL.shareObject.refCount);
	QZFL.shareObject.instance["so_" + QZFL.shareObject.refCount] = this
};
QZFL.shareObject.DataBase.prototype.set = function(a, b) {
	if (this._ready) {
		this.ele.set("seed", Math.random());
		this.ele.set(a, b);
		this.ele.flush();
		return true
	} else {
		return false
	}
};
QZFL.shareObject.DataBase.prototype.del = function(a) {
	if (this._ready) {
		this.ele.set("seed", Math.random());
		this.ele.set(a, void (0));
		this.ele.flush();
		return true
	} else {
		return false
	}
};
QZFL.shareObject.DataBase.prototype.get = function(a) {
	return (this._ready) ? (this.ele.get(a)) : null
};
QZFL.shareObject.DataBase.prototype.clear = function() {
	if (this._ready) {
		this.ele.clear();
		return true
	} else {
		return false
	}
};
QZFL.shareObject.DataBase.prototype.getDataSize = function() {
	if (this._ready) {
		return this.ele.getSize()
	} else {
		return -1
	}
};
QZFL.shareObject.DataBase.prototype.load = function(b, a, d, c) {
	if (this._ready) {
		this.ele.load(b, a, d, c);
		return true
	} else {
		return false
	}
};
QZFL.shareObject.DataBase.prototype.setReady = function() {
	this._ready = true
};
function getShareObjectPrefix() {
	QZFL.shareObject.instance["so_" + QZFL.shareObject.refCount].setReady();
	return location.host.split(".")[0]
}
QZFL.shareObject.DataBase.prototype.setClipboard = function(a) {
	if (this._ready && isString(a)) {
		this.ele.setClipboard(a);
		return true
	} else {
		return false
	}
};
QZFL.Tween = function(b, f, c, a, e, g) {
	this._func = c || QZFL.transitions.simple;
	this._obj = QZFL.dom.get(b);
	this.isColor = /^#/.test(a);
	this._prop = f;
	var d = /\d+([a-z%]+)/i.exec(a);
	this._suffix = d ? d[1] : "";
	this._startValue = this.isColor ? 0 : parseFloat(a);
	this._finishValue = this.isColor ? 100 : parseFloat(e);
	if (this.isColor) {
		this._startColor = QZFL.css.convertHexColor(a);
		this._finishColor = QZFL.css.convertHexColor(e)
	}
	this._duration = g || 10;
	this._timeCount = 0;
	this._startTime = 0;
	this._changeValue = this._finishValue - this._startValue;
	this.currentValue = 0;
	this.isPlayed = false;
	this.isLoop = false;
	this.onMotionStart = QZFL.emptyFn;
	this.onMotionChange = QZFL.emptyFn;
	this.onMotionStop = QZFL.emptyFn
};
QZFL.Tween.prototype.start = function(a) {
	this._reloadTimer();
	this.isPlayed = true;
	this._runTime();
	this.isLoop = a ? true : false;
	this.onMotionStart.apply(this);
	return "d"
};
QZFL.Tween.prototype.pause = function() {
	this.isPlayed = false
};
QZFL.Tween.prototype.stop = function() {
	this.isPlayed = false;
	this._playTime(this._duration + 0.1)
};
QZFL.Tween.prototype._reloadTimer = function() {
	this._startTime = new Date().getTime() - this._timeCount * 1000
};
QZFL.Tween.prototype._playTime = function(d) {
	var b = false;
	if (d > this._duration) {
		d = this._duration;
		b = true
	}
	var a = this._func(d, this._startValue, this._changeValue, this._duration);
	this.currentValue = /(opacity)/i.test(this._prop) ? a : Math.round(a);
	if (this.isColor) {
		this.currentValue = this.getColor(this._startColor, this._finishColor,
				a)
	}
	var c = QZFL.dom.setStyle(this._obj, this._prop, this.currentValue
			+ this._suffix);
	if (!c) {
		this._obj[this._prop] = this.currentValue + this._suffix
	}
	this.onMotionChange.apply(this,
			[ this._obj, this._prop, this.currentValue ]);
	if (b) {
		this.isPlayed = false;
		if (this.isLoop) {
			this.isPlayed = true;
			this._reloadTimer()
		}
		this.onMotionStop.apply(this);
		if (window.CollectGarbage) {
			CollectGarbage()
		}
	}
};
QZFL.Tween.prototype._runTime = function() {
	var a = this;
	if (a.isPlayed) {
		a._playTime((new Date().getTime() - this._startTime) / 1000);
		setTimeout(function() {
			a._runTime.apply(a, [])
		}, 0)
	}
};
QZFL.Tween.prototype.getPercent = function() {
	return (this.currentValue - this._startValue) / this._changeValue * 100
};
QZFL.Tween.prototype.swapValue = function() {
	if (this.isColor) {
		var a = this._startColor.join(",");
		this._startColor = this._finishColor;
		this._finishColor = a.split(",")
	} else {
		var a = this._startValue;
		this._startValue = this._finishValue;
		this._finishValue = a;
		this._changeValue = this._finishValue - this._startValue
	}
};
QZFL.Tween.prototype.getColor = function(f, a, d) {
	var b = f;
	var g = a;
	var e = [];
	if (d > 100) {
		d = 100
	}
	if (d < 0) {
		d = 0
	}
	for ( var c = 0; c < 3; c++) {
		e[c] = Math.floor(b[c] * 1 + (d / 100) * (g[c] - b[c])).toString(16);
		if (e[c].length < 2) {
			e[c] = "0" + e[c]
		}
	}
	return "#" + e.join("")
};
QZFL.transitions = {
	simple : function(d, a, b, c) {
		return b * d / c + a
	},
	regularEaseIn : function(e, a, g, f) {
		return g * (e /= f) * e + a
	},
	regularEaseOut : function(e, a, g, f) {
		return -g * (e /= f) * (e - 2) + a
	},
	regularEaseInOut : function(e, a, g, f) {
		if ((e /= f / 2) < 1) {
			return g / 2 * e * e + a
		}
		return -g / 2 * ((--e) * (e - 2) - 1) + a
	}
};
QZFL.object.extend(QZFL.transitions, {
	backEaseIn : function(e, a, h, g) {
		var f = 1.70158;
		return h * (e /= g) * e * ((f + 1) * e - f) + a
	},
	backEaseOut : function(g, e, k, j, f, i) {
		var h = 1.70158;
		return k * ((g = g / j - 1) * g * ((h + 1) * g + h) + 1) + e
	},
	backEaseInOut : function(g, e, k, j, f, i) {
		var h = 1.70158;
		if ((g /= j / 2) < 1) {
			return k / 2 * (g * g * (((h *= (1.525)) + 1) * g - h)) + e
		}
		return k / 2 * ((g -= 2) * g * (((h *= (1.525)) + 1) * g + h) + 2) + e
	},
	bounceEaseOut : function(e, a, g, f) {
		if ((e /= f) < (1 / 2.75)) {
			return g * (7.5625 * e * e) + a
		} else {
			if (e < (2 / 2.75)) {
				return g * (7.5625 * (e -= (1.5 / 2.75)) * e + 0.75) + a
			} else {
				if (e < (2.5 / 2.75)) {
					return g * (7.5625 * (e -= (2.25 / 2.75)) * e + 0.9375) + a
				} else {
					return g * (7.5625 * (e -= (2.625 / 2.75)) * e + 0.984375)
							+ a
				}
			}
		}
	},
	bounceEaseIn : function(e, a, g, f) {
		return g - QZFL.transitions.bounceEaseOut(f - e, 0, g, f) + a
	},
	bounceEaseInOut : function(e, a, g, f) {
		if (e < f / 2) {
			return QZFL.transitions.bounceEaseIn(e * 2, 0, g, f) * 0.5 + a
		} else {
			return QZFL.transitions.bounceEaseOut(e * 2 - f, 0, g, f) * 0.5 + g
					* 0.5 + a
		}
	},
	strongEaseIn : function(e, a, g, f) {
		return g * (e /= f) * e * e * e * e + a
	},
	strongEaseOut : function(e, a, g, f) {
		return g * ((e = e / f - 1) * e * e * e * e + 1) + a
	},
	strongEaseInOut : function(e, a, g, f) {
		if ((e /= f / 2) < 1) {
			return g / 2 * e * e * e * e * e + a
		}
		return g / 2 * ((e -= 2) * e * e * e * e + 2) + a
	},
	elasticEaseIn : function(g, e, k, j, f, i) {
		if (g == 0) {
			return e
		}
		if ((g /= j) == 1) {
			return e + k
		}
		if (!i) {
			i = j * 0.3
		}
		if (!f || f < Math.abs(k)) {
			f = k;
			var h = i / 4
		} else {
			var h = i / (2 * Math.PI) * Math.asin(k / f)
		}
		return -(f * Math.pow(2, 10 * (g -= 1)) * Math.sin((g * j - h)
				* (2 * Math.PI) / i))
				+ e
	},
	elasticEaseOut : function(g, e, k, j, f, i) {
		if (g == 0) {
			return e
		}
		if ((g /= j) == 1) {
			return e + k
		}
		if (!i) {
			i = j * 0.3
		}
		if (!f || f < Math.abs(k)) {
			f = k;
			var h = i / 4
		} else {
			var h = i / (2 * Math.PI) * Math.asin(k / f)
		}
		return (f * Math.pow(2, -10 * g)
				* Math.sin((g * j - h) * (2 * Math.PI) / i) + k + e)
	},
	elasticEaseInOut : function(g, e, k, j, f, i) {
		if (g == 0) {
			return e
		}
		if ((g /= j / 2) == 2) {
			return e + k
		}
		if (!i) {
			var i = j * (0.3 * 1.5)
		}
		if (!f || f < Math.abs(k)) {
			var f = k;
			var h = i / 4
		} else {
			var h = i / (2 * Math.PI) * Math.asin(k / f)
		}
		if (g < 1) {
			return -0.5
					* (f * Math.pow(2, 10 * (g -= 1)) * Math.sin((g * j - h)
							* (2 * Math.PI) / i)) + e
		}
		return f * Math.pow(2, -10 * (g -= 1))
				* Math.sin((g * j - h) * (2 * Math.PI) / i) * 0.5 + k + e
	}
});
QZFL.dragdrop = {
	dragdropPool : {},
	dragTempId : 0,
	_scrollRange : 0,
	dragGhostStyle : "cursor:move;position:absolute;border:1px solid #06c;background:#6cf;z-index:1000;color:#003;overflow:hidden",
	registerDragdropHandler : function(d, f, c) {
		var a = QZFL.event;
		var g = QZFL.dom.get(d);
		var e = QZFL.dom.get(f);
		c = c || {
			range : [ null, null, null, null ],
			ghost : 0
		};
		if (!g) {
			return null
		}
		var b = e || g;
		if (!g.id) {
			g.id = "dragdrop_" + this.dragTempId;
			QZFL.dragdrop.dragTempId++
		}
		g.style.cursor = c.cursor || "move";
		this.dragdropPool[g.id] = new this.eventController();
		a.on(g, "mousedown", a.bind(this, this.startDrag), [ g.id, b, c ]);
		return this.dragdropPool[g.id]
	},
	unRegisterDragdropHandler : function(b) {
		var c = QZFL.dom.get(b);
		var a = QZFL.event;
		if (!c) {
			return null
		}
		c.style.cursor = "default";
		delete this.dragdropPool[c.id];
		a.removeEvent(c, "mousedown")
	},
	startDrag : function(r, a, u, d) {
		var h = QZFL.dom;
		var f = QZFL.event;
		if (f.getButton() != 0 || f.getTarget().noDrag) {
			return
		}
		if (d.ignoreTagName == f.getTarget().tagName
				|| f.getTarget().noDragdrop) {
			return
		}
		var m = h.getSize(u);
		var c = h.getStyle(u, "position");
		var p = c == "absolute" || c == "fixed";
		var b = null, q = false;
		var j = null;
		if (d.rangeElement) {
			var i = d.rangeElement;
			var n = QZFL.dom.get(i[0]);
			var g = QZFL.dom.getSize(n);
			var s = i[1];
			if (!i[2]) {
				d.range = [ s[0] ? 0 : null, s[1] ? 0 : null,
						s[2] ? g[1] : null, s[3] ? g[0] : null ]
			} else {
				var k = QZFL.dom.getXY(n);
				d.range = [ s[0] ? k[1] : null, s[1] ? k[0] : null,
						s[2] ? k[1] + g[1] : null, s[3] ? k[0] + g[0] : null ]
			}
		}
		if (!p || d.ghost) {
			j = p ? [ parseInt(u.style.left), parseInt(u.style.top) ] : h
					.getXY(u);
			b = h.createElementIn("div", p ? u.parentNode : document.body,
					false, {
						style : d.ghostStyle || this.dragGhostStyle
					});
			b.id = "dragGhost";
			h.setStyle(b, "opacity", "0.8");
			setTimeout(function() {
				h.setStyle(u, "opacity", "0.5")
			}, 0);
			if (d.ghostSize) {
				h.setSize(b, d.ghostSize[0], d.ghostSize[1]);
				j = [ r.clientX + QZFL.dom.getScrollLeft() - 30,
						r.clientY + QZFL.dom.getScrollTop() - 20 ]
			} else {
				h.setSize(b, m[0] - 2, m[1] - 2)
			}
			h.setXY(b, j[0], j[1]);
			q = true
		} else {
			j = [ parseInt(h.getStyle(u, "left")),
					parseInt(h.getStyle(u, "top")) ]
		}
		var t = b || u;
		this.currentDragCache = {
			size : m,
			xy : j,
			mXY : j,
			dragTarget : t,
			target : u,
			x : r.clientX - parseInt(j[0]),
			y : r.clientY - parseInt(j[1]),
			ghost : b,
			hasGhost : q,
			isAbsolute : p,
			options : d,
			scrollRangeTop : QZFL.dragdrop._scrollRange,
			scrollRangeBottom : QZFL.dom.getClientHeight()
					- QZFL.dragdrop._scrollRange,
			maxScrollRange : Math.max(QZFL.dom.getScrollHeight()
					- QZFL.dom.getClientHeight(), 0)
		};
		f.on(document, "mousemove", f.bind(this, this.doDrag), [ a,
				this.currentDragCache, d ]);
		f.on(document, "mouseup", f.bind(this, this.endDrag), [ a,
				this.currentDragCache, d ]);
		this.dragdropPool[a].onStartDrag.apply(null, [ r, a,
				this.currentDragCache, d ]);
		f.preventDefault()
	},
	doDrag : function(h, d, b, a) {
		var i = {};
		if (a.autoScroll) {
			if (h.clientY < b.scrollRangeTop) {
				if (!QZFL.dragdrop._scrollTop) {
					QZFL.dragdrop._stopScroll();
					QZFL.dragdrop._scrollTimer = setTimeout(function() {
						QZFL.dragdrop._doScroll(true, b)
					}, 200)
				}
			} else {
				if (h.clientY > b.scrollRangeBottom) {
					if (!QZFL.dragdrop._scrollBottom) {
						QZFL.dragdrop._stopScroll();
						QZFL.dragdrop._scrollTimer = setTimeout(function() {
							QZFL.dragdrop._doScroll(false, b)
						}, 200)
					}
				} else {
					QZFL.dragdrop._stopScroll()
				}
			}
		}
		var g = h.clientX - b.x;
		var c = h.clientY - b.y;
		var f = this._countXY(g, c, b.size, a);
		g = f.x;
		c = f.y;
		QZFL.dom.setXY(b.dragTarget, g, c);
		b.mXY = [ g, c ];
		this.dragdropPool[d].onDoDrag.apply(null, [ h, d, b, a ]);
		if (QZFL.userAgent.ie) {
			document.body.setCapture()
		} else {
			if (window.captureEvents) {
				window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
		QZFL.event.preventDefault()
	},
	endDrag : function(b, a, f, j) {
		var c = QZFL.dom;
		if (f.hasGhost) {
			QZFL.dom.removeElement(f.dragTarget);
			var h = f.target;
			setTimeout(function() {
				QZFL.dom.setStyle(h, "opacity", "1");
				h = null
			}, 0);
			if (f.isAbsolute) {
				var g = parseInt(c.getStyle(f.target, "left"))
						+ (f.mXY[0] - f.xy[0]);
				var d = parseInt(c.getStyle(f.target, "top"))
						+ (f.mXY[1] - f.xy[1]);
				var i = this._countXY(g, d, f.size, j);
				QZFL.dom.setXY(f.target, i.x, i.y)
			}
		}
		QZFL.event.removeEvent(document, "mousemove");
		QZFL.event.removeEvent(document, "mouseup");
		this.dragdropPool[a].onEndDrag.apply(null, [ b, a, f, j ]);
		f = null;
		QZFL.dragdrop._stopScroll();
		if (QZFL.userAgent.ie) {
			document.body.releaseCapture()
		} else {
			if (window.releaseEvents) {
				window.releaseEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
	},
	_doScroll : function(c, a) {
		step = c ? -15 : 15;
		var b = QZFL.dom.getScrollTop();
		if (c && b + step < 0) {
			step = 0
		}
		if (!c && b + step > a.maxScrollRange) {
			step = 0
		}
		QZFL.dom.setScrollTop(b + step);
		a.y = a.y - step;
		QZFL.dragdrop._scrollTop = c;
		QZFL.dragdrop._scrollBottom = !c;
		QZFL.dragdrop._scrollTimer = setTimeout(function() {
			QZFL.dragdrop._doScroll(c, a)
		}, 16)
	},
	_stopScroll : function() {
		QZFL.dragdrop._scrollTop = QZFL.dragdrop._scrollBottom = false;
		clearTimeout(QZFL.dragdrop._scrollTimer)
	},
	_countXY : function(f, d, m, n) {
		var e = {
			x : f,
			y : d
		};
		if (n.x) {
			e.x = parseInt(e.x / n.x, 10) * n.x
					+ (e.x % n.x < n.x / 2 ? 0 : n.x)
		}
		if (n.y) {
			e.y = parseInt(e.y / n.y, 10) * n.y
					+ (e.y % n.y < n.y / 2 ? 0 : n.y)
		}
		if (n.range) {
			var h = n.range;
			var c = 0, b = 0;
			while (c < h.length && b < 2) {
				if (typeof h[c] != "number") {
					c++;
					continue
				}
				var a = c % 2 ? "x" : "y";
				var g = e[a];
				e[a] = c < 2 ? Math.max(e[a], h[c]) : Math.min(e[a], h[c]
						- m[(c + 1) % 2]);
				if (e[a] != g) {
					b++
				}
				c++
			}
		}
		return e
	}
};
QZFL.dragdrop.eventController = function() {
	this.onStartDrag = QZFL.emptyFn;
	this.onDoDrag = QZFL.emptyFn;
	this.onEndDrag = QZFL.emptyFn
};
QZFL.element.extendFn({
	dragdrop : function(c, b) {
		var a = [];
		this.each(function() {
			a.push(QZFL.dragdrop.registerDragdropHandler(this, c, b))
		});
		return a
	},
	unDragdrop : function(b, a) {
		this.each(function() {
			_arr.push(QZFL.dragdrop.unRegisterDragdropHandler(this))
		})
	}
});
QZFL.dialog = {
	items : [],
	lastFocus : null,
	tween : true,
	create : function(g, e, d, a, c, h) {
		var f = this.items;
		f.push(new QZFL.DialogHandler(f.length, h, c));
		var b = f[f.length - 1];
		b.init(d || 300, a || 200);
		b.fillTitle(g || "无标题");
		b.fillContent(e || "");
		return b
	},
	createBorderNone : function(d, c, a) {
		var e = this.items;
		var b;
		e.push(b = (new QZFL.DialogHandler(e.length, true)));
		b.init(c || 300, a || 200, true);
		b.fillContent(d || "");
		return b
	}
};
QZFL.DialogHandler = function(d, b, a) {
	this._id = d;
	this._isIE6 = (QZFL.userAgent.ie && QZFL.userAgent.ie < 7);
	this.id = "dialog_" + d;
	this.mainId = "dialog_main_" + d;
	this.headId = "dialog_head_" + d;
	this.titleId = "dialog_title_" + d;
	this.closeId = "dialog_button_" + d;
	this.contentId = "dialog_content_" + d;
	this.frameId = "dialog_frame_" + d;
	this.useTween = (typeof (a) != "boolean") ? QZFL.dialog.tween : a;
	this.zIndex = 6000 + this._id;
	this.iconClass = "none";
	this.onBeforeUnload = function() {
		return true
	};
	this.onUnload = QZFL.emptyFn;
	this.isFocus = false;
	var c = [ '<div id="', this.mainId, '" class="',
			(b ? "" : "layer_global_main"), '">', "<div id=", this.headId,
			' class="', (b ? "none" : "layer_global_title"), '">',
			'<h3><span class="jian">&gt;</span><span id=', this.titleId,
			" ></span></h3>", '<button id="', this.closeId,
			'" title="关闭"><span class="none">&#9587;</span></button>',
			"</div>", '<div id="', this.contentId, '" class="',
			(b ? "" : "layer_global_cont"), '"></div>', "</div>" ];
	if (this._isIE6 && !b) {
		c
				.push('<iframe id="'
						+ this.frameId
						+ '" style="position:absolute;width:100%;top:0px;z-index:-1;"></iframe>')
	}
	this.temlate = c.join("")
};
QZFL.DialogHandler.prototype.init = function(width, height, isNoneBerder) {
	this.dialog = document.createElement("div");
	this.dialog.id = this.id;
	var _l = (QZFL.dom.getClientWidth() - width) / 2 + QZFL.dom.getScrollLeft();
	var _t = Math.max((QZFL.dom.getClientHeight() - height) / 2
			+ QZFL.dom.getScrollTop(), 0);
	with (this.dialog) {
		if (!isNoneBerder) {
			className = "layer_global"
		}
		style.position = "absolute";
		style.left = _l + "px";
		style.top = _t + "px";
		style.zIndex = this.zIndex;
		innerHTML = this.temlate
	}
	document.body.appendChild(this.dialog);
	this.dialogClose = QZFL.dom.get(this.closeId);
	var o = this;
	QZFL.event.addEvent(this.dialog, "mousedown", QZFL.event.bind(o, o.focus));
	QZFL.event.addEvent(this.dialogClose, "click", function() {
		var t = QZFL.dialog.items[o._id];
		if (t) {
			t.unload()
		}
	});
	if (QZFL.dragdrop) {
		QZFL.dragdrop.registerDragdropHandler(QZFL.dom.get(this.headId),
				QZFL.dom.get(this.id), {
					range : [ 0, null, null, null ],
					ghost : 0
				})
	}
	this.setSize(width, height);
	if (this.useTween && QZFL.Tween) {
		QZFL.dom.setStyle(this.dialog, "opacity", 0);
		var tween1 = new QZFL.Tween(this.dialog, "top",
				QZFL.transitions.regularEaseIn, _t - 30 + "px", _t + "px", 0.3);
		tween1.onMotionChange = function() {
			QZFL.dom.setStyle(o.dialog, "opacity", this.getPercent() / 100)
		};
		tween1.onMotionStop = function() {
			QZFL.dom.setStyle(o.dialog, "opacity", 1);
			tween1 = null
		};
		tween1.start()
	} else {
	}
};
QZFL.DialogHandler.prototype.focus = function() {
	if (this.isFocus) {
		return
	}
	this.dialog.style.zIndex = this.zIndex + 3000;
	if (QZFL.dialog.lastFocus) {
		QZFL.dialog.lastFocus.blur()
	}
	this.isFocus = true;
	QZFL.dialog.lastFocus = this
};
QZFL.DialogHandler.prototype.blur = function() {
	this.isFocus = false;
	this.dialog.style.zIndex = this.zIndex
};
QZFL.DialogHandler.prototype.getZIndex = function() {
	return this.dialog.style.zIndex
};
QZFL.DialogHandler.prototype.fillTitle = function(b) {
	var a = QZFL.dom.get(this.titleId);
	a.innerHTML = b
};
QZFL.DialogHandler.prototype.fillContent = function(b) {
	var a = QZFL.dom.get(this.contentId);
	a.innerHTML = b
};
QZFL.DialogHandler.prototype.setSize = function(d, a) {
	var c = QZFL.dom.get(this.id);
	c.style.width = d + "px";
	var b = QZFL.dom.get(this.contentId);
	a = a - 28 < 0 ? 50 : a - 28;
	b.style[QZFL.userAgent.ie < 7 ? "height" : "minHeight"] = a + "px";
	if (this._isIE6) {
		var e = QZFL.dom.getSize(QZFL.dom.get(this.id)), f = QZFL.dom
				.get(this.frameId);
		QZFL.dom.setSize(f, e[0], e[1])
	}
};
QZFL.DialogHandler.prototype.unload = function() {
	if (!this.onBeforeUnload()) {
		return
	}
	var b = this;
	if (this.useTween && QZFL.Tween) {
		var a = new QZFL.Tween(this.dialog, "opacity",
				QZFL.transitions.regularEaseIn, 1, 0, 0.2);
		a.onMotionStop = function() {
			b._unload();
			a = null
		};
		a.start()
	} else {
		this._unload()
	}
};
QZFL.DialogHandler.prototype._unload = function() {
	this.onUnload();
	if (QZFL.dragdrop) {
		QZFL.dragdrop.unRegisterDragdropHandler(QZFL.dom.get(this.headId))
	}
	this.dialog.innerHTML = "";
	QZFL.dom.removeElement(this.dialog);
	delete QZFL.dialog.items[this._id]
};
(function() {
	function a(f, d) {
		var b = {
			title : "提 示",
			subTitle : "",
			content : "",
			tips : "",
			tips2 : "",
			yes : "确 定",
			no : "",
			width : 410,
			height : 200,
			useTween : false,
			onYes : false,
			onNo : false,
			className : "tips"
		};
		QZFL.object.extend(b, f);
		QZFL.object.extend(b, d);
		QZFL.object.each(QZFL.dialog.items, function(g) {
			try {
				g.unload()
			} catch (h) {
			}
		});
		var c = '<div class="mod '
				+ b.className
				+ '"><h4 class="layer_global_tit"'
				+ (b.subTitle ? "" : ' style="display:none"')
				+ ">"
				+ b.subTitle
				+ "</h4><p>"
				+ b.content
				+ '</p></div><p class="tips_over strong"'
				+ (b.tips2 ? "" : ' style="display:none"')
				+ ">"
				+ b.tips2
				+ '</p><div class="wrap_tips"><p class="tips_text">'
				+ b.tips
				+ '</p><div class="bt_wrap">'
				+ (b.yes ? '<a href="javascript:;" id="dialog_button_yes" class="bt_small"><strong>'
						+ b.yes + "</strong></a>"
						: "")
				+ (b.no ? '<a href="javascript:;" id="dialog_button_no" class="bt_small"><strong>'
						+ b.no + "</strong></a>"
						: "") + "</div></div>";
		var e = QZFL.dialog.create(b.title, c, b.width, b.height);
		e.onYes = b.onYes || function() {
			e.unload()
		};
		e.onNo = b.onNo || function() {
			e.unload()
		};
		$e("#dialog_button_yes").bind("click", function() {
			e.onYes()
		});
		$e("#dialog_button_no").bind("click", function() {
			e.onNo()
		});
		$e("#" + e.id).addClass("dialog");
		return e
	}
	QZFL.object.extend(QZFL.dialog, {
		tips : function(b) {
			return a({
				className : "tips"
			}, b)
		},
		error : function(b) {
			return a({
				className : "error"
			}, b)
		},
		success : function(b) {
			return a({
				className : "success"
			}, b)
		},
		confirm : function(b) {
			return a({
				className : "confirm",
				no : "取 消"
			}, b)
		}
	})
})();
QZFL.maskLayout = {
	count : 0,
	items : {},
	create : function(b, d) {
		this.count++;
		b = b || 5000;
		d = d || document;
		var a = QZFL.dom.createElementIn("div", d.body, false, {
			className : "qz_mask_layout"
		});
		var c = (QZFL.userAgent.ie && QZFL.userAgent.ie < 7) ? Math.max(
				d.documentElement.scrollHeight, d.body.scrollHeight) : QZFL.dom
				.getClientHeight(d);
		a.style.zIndex = b;
		a.style.height = c + "px";
		a.unselectable = "on";
		this.items[this.count] = a;
		return this.count
	},
	remove : function(a) {
		QZFL.dom.removeElement(this.items[a]);
		delete this.items[a]
	}
};
var QZFL = QZFL || {};
QZFL.lazyLoad = (function() {
	var c = 0, a = [], d = [], i = 0, n = "http://imgcache.qq.com/club/vipshop/img/loading/default.gif", e = QZFL, j = e.css, g = e.event;
	function k() {
		if (c != 0) {
			return
		}
		c = setTimeout(m, 30)
	}
	function f(t) {
		var r = true;
		try {
			var s = document.documentElement.scrollTop
					|| document.body.scrollTop;
			var q = s + document.documentElement.clientHeight;
			var u = t.offsetTop;
			while (t = t.offsetParent) {
				u += t.offsetTop
			}
			r = u <= q
		} catch (t) {
			r = true
		}
		return r
	}
	function m() {
		if (i < 1) {
			g.removeEvent(window, "scroll", k);
			g.removeEvent(window, "resize", k);
			return
		}
		for ( var r = 0, q = a.length; r < q; r++) {
			if (!a[r]) {
				continue
			}
			if (f(a[r])) {
				a[r].src = a[r].getAttribute("init_src");
				delete a[r];
				i--
			}
		}
		c = 0
	}
	function p(r) {
		h();
		if (!r) {
			r = [ "img", "iframe" ]
		}
		for ( var v = 0, t = r.length; v < t; v++) {
			var w = document.getElementsByTagName(r[v]);
			for ( var x = 0, q = w.length; x < q; x++) {
				if (typeof w[x] == "object" && w[x].getAttribute("init_src")) {
					a.push(w[x]);
					i++
				} else {
					if (typeof w[x] == "object"
							&& w[x].getAttribute("hide_init_src")) {
						d.push(w[x])
					}
				}
				g.on(w[x], "load", (function(y) {
					return function() {
						if (y.src && y.src != e.lazyLoad.defaultImg) {
							j.removeClassName(y, "loading_82_21");
							j.removeClassName(y, "loading_36_35");
							j.removeClassName(y, "loading_58_58");
							j.removeClassName(y, "loading_16_16")
						}
					}
				})(w[x]))
			}
		}
		var s = new Image();
		var u = a.concat(d);
		g.on(s, "load", (function(y) {
			return function() {
				for ( var A = 0, z = y.length; A < z; A++) {
					if (!y[A].src) {
						y[A].src = e.lazyLoad.defaultImg
					}
				}
			}
		})(u));
		s.src = e.lazyLoad.defaultImg;
		g.on(window, "scroll", k);
		g.on(window, "resize", k);
		m()
	}
	function b(q) {
		var r = ((typeof q == "string") && e.element.get("#" + q + " img").elements)
				|| (q.length && q) || e.dom.get(q).getElementsByTagName("img");
		e.object.each(r, function(s) {
			if (s.getAttribute && s.getAttribute("hide_init_src")) {
				s.src = s.getAttribute("hide_init_src");
				s.setAttribute("hide_init_src", "")
			}
		})
	}
	function h() {
		c = 0;
		a = [];
		d = [];
		i = 0
	}
	return {
		init : p,
		loadHideImg : b,
		defaultImg : n,
		isVisible : f
	}
})();
QZFL.User = {
	info : {},
	f_info : {},
	callback : null,
	load : function(a) {
		if (!a.data) {
			return
		}
		if (a.callback) {
			QZFL.User.callback = a.callback
		}
		if (!QZFL.cookie.get("uin") || !QZFL.cookie.get("skey")) {
			QZFL.User.callback && QZFL.User.callback();
			return
		}
		new QZFL.JsLoader().load(
				"http://d1.shop.qq.com/json.php?mod=userInfo&act=login&data="
						+ a.data + "&callback=QZFL.User.init", document,
				"utf-8")
	},
	init : function(d) {
		var e = d;
		if (e.nick_name) {
			e.nick_name = e.nick_name.replace(/ $/, "")
		}
		for ( var b in e) {
			QZFL.User.info[b] = e[b]
		}
		if (QZFL.User.callback) {
			QZFL.User.callback(QZFL.User.info, QZFL.User.f_info)
		}
		if (QZFL.User.info.is_login && !QZFL.cookie.get("is_login_paipai")) {
			var c = "http://ptlogin2.paipai.com/jump?uin="
					+ QZFL.User.info.uin
					+ "&skey="
					+ QZFL.cookie.get("skey")
					+ "&u1=http%3A%2F%2Fmember.paipai.com%2Fcgi-bin%2Fptlogin%3Freturnurl%3Dhttp%3A%2F%2Fauction.paipai.com%2Fnull.shtml%26loginfrom%3D4";
			var a = document.createElement("iframe");
			a.style.display = "none";
			a.style.width = a.style.height = a.style.borderWidth = "0";
			a.src = c;
			document.body.appendChild(a);
			if (typeof a.onreadystatechange != "undefined") {
				a.onreadystatechange = function() {
					QZFL.cookie.set("is_login_paipai", "1")
				}
			} else {
				QZFL.cookie.set("is_login_paipai", "1")
			}
		}
	},
	logout : function(b) {
		var a = new QZFL.FormSender("http://d1.shop.qq.com/json.php", "POST", {
			mod : "userInfo",
			act : "logout"
		}, "utf-8");
		a.onSuccess = a.onError = function() {
			QZFL.cookie.del("is_login_paipai");
			if (b) {
				b()
			} else {
				window.location.reload()
			}
		};
		document.domain = "qq.com";
		a.send()
	},
	login : function() {
		QZFL.cookie.del("is_login_paipai");
		QZFL.quickLogin.open(2)
	},
	stuff : function(e, d, b) {
		var b = b || [ "a", "p", "span", "strong" ];
		for ( var c = 0, a = b.length; c < a; c++) {
			QZFL.User._stuff(b[c], false, d);
			e && QZFL.User._stuff(b[c], true, d)
		}
	},
	_stuff : function(c, n, a) {
		var h = function(q, r) {
			if (q.outerHTML) {
				q.outerHTML = r;
				return
			}
			var i = q.ownerDocument.createRange();
			i.setStartBefore(q);
			var k = i.createContextualFragment(r);
			q.parentNode.replaceChild(k, q)
		};
		var b = !!n ? this.f_info : this.info;
		var p = document.getElementsByTagName(c);
		var d = function(k, q, i) {
			i == "inner" ? (k.innerHTML = q) : h(k, q)
		};
		for ( var f = 0, g = p.length; f < g; f++) {
			var m = p[f].getAttribute(!!n ? "f_user" : "user");
			var j = p[f].getAttribute("stuff_method") || "inner";
			switch (m) {
			default:
				for ( var e in b) {
					if (m == e) {
						d(p[f], b[e], j);
						break
					}
				}
				break
			}
		}
	},
	parse : function(b, a) {
		return b.replace(/{(\w+)}/gi, function(d, c) {
			return c.toLowerCase() in QZFL.User.info ? (a ? QZFL.User.f_info[c
					.toLowerCase()] : QZFL.User.info[c.toLowerCase()]) : d
		})
	}
};
var QZFL = QZFL || {};
QZFL.Template = {
	parse : function(c, a, b) {
		var d = [];
		QZFL.object.each(c, function(e) {
			d.push(a.replace(/{(\w+)}/g, function(g, f) {
				return e[f] !== undefined ? e[f] : g
			}))
		});
		return d.join(b || "")
	},
	stuff : function(e, f, c, d) {
		c = $(c || f + "_tpl").value;
		f = $(f);
		var a = c.match(/<#([\s\S]+)#>/);
		var b = a[1];
		f.innerHTML = c.replace(a[0], this.parse(e, b, d));
		f.style.visibility = "visible"
	}
};
(function() {
	jWidget = {
		version : "1.0.0",
		each : function(d, c) {
			if (typeof d.length == "undefined" || typeof d == "string") {
				d = [ d ]
			}
			for ( var b = 0, a = d.length; b < a; b++) {
				if (c.call(d[b], d[b], b, d) === false) {
					return b
				}
			}
		},
		extend : QZFL.object.extend
	};
	jWidget.dom = QZFL.dom;
	jWidget.extend(QZFL.dom, {
		hasClass : QZFL.css.hasClassName,
		addClass : QZFL.css.addClassName,
		removeClass : QZFL.css.removeClassName
	});
	jWidget.dom.getChildren = function(b) {
		var a = [];
		var b = jWidget.dom.getFirstChild(b);
		while (b) {
			if (!!b && b.nodeType == 1) {
				a.push(b)
			}
			b = b.nextSibling
		}
		return a
	};
	jWidget.Tween = QZFL.Tween;
	jWidget.ui = jWidget.ui || {}
})();
(function() {
	var b = jWidget, a = b.dom;
	_Slide = function(c) {
		c = c || {};
		this.eventType = c.eventType || "mouseover",
				this.autoPlayInterval = c.autoPlayInterval || 3 * 1000;
		this._play = true;
		this._timer = null;
		this._fadeTimer = null;
		this._container = a.get(c.container);
		this._panelWrapper = a.get(c.panelWrapper)
				|| a.getFirstChild(this._container);
		this._sliders = a.getChildren(this._panelWrapper);
		this._navWrapper = a.get(c.navWrapper)
				|| a.getNextSibling(this._panelWrapper) || null;
		this._navs = (this._navWrapper && a.getChildren(this._navWrapper))
				|| null;
		this._effect = c.effect || "scrollx";
		this._panelSize = (this._effect.indexOf("scrolly") == -1 ? c.width
				: c.height)
				|| a.getSize(a.getFirstChild(this._panelWrapper))[this._effect
						.indexOf("scrolly") == -1 ? 0 : 1];
		this._count = c.count || a.getChildren(this._panelWrapper).length;
		this._navClassOn = c.navClassOn || "on";
		this._target = 0;
		this._changeProperty = this._effect.indexOf("scrolly") == -1 ? "left"
				: "top";
		this.curIndex = 0;
		this.step = this._effect.indexOf("scroll") == -1 ? 1 : (c.Step || 5);
		this.slideTime = c.slideTime || 10;
		if (c.nextButton) {
			var d = this;
			a.get(c.nextButton).onclick = (function(e) {
				return function() {
					e.next()
				}
			})(d)
		}
		if (c.prevButton) {
			a.get(c.prevButton).onclick = (function(e) {
				return function() {
					e.prev()
				}
			})(d)
		}
		this.init();
		this.run(true)
	};
	_Slide.prototype = {
		init : function() {
			if (this._container) {
				a.setStyle(this._container, "overflow", "hidden");
				a.setStyle(this._container, "position", "relative")
			}
			a.setStyle(this._panelWrapper, "position", "relative");
			if (this._effect.indexOf("scrolly") == -1) {
				a.setStyle(this._panelWrapper, "width", this._count
						* (this._panelSize + 200) + "px");
				b.each(this._sliders, function(d) {
					d.style.styleFloat = d.style.cssFloat = "left"
				})
			}
			var c = this;
			if (this._navs) {
				if (c.eventType == "click") {
					b.each(this._navs, function(e, d) {
						e.onclick = (function(f) {
							return function() {
								a.addClass(e, f._navClassOn);
								f._play = false;
								f.curIndex = d;
								f._play = true;
								f.run()
							}
						})(c)
					})
				} else {
					b.each(this._navs, function(e, d) {
						e.onmouseover = (function(f) {
							return function() {
								a.addClass(e, f._navClassOn);
								f._play = false;
								f.curIndex = d;
								f.run()
							}
						})(c);
						e.onmouseout = (function(f) {
							return function() {
								a.removeClass(e, f._navClassOn);
								f._play = true;
								f.run(false, true)
							}
						})(c)
					})
				}
			}
			b.each(this._sliders, function(e, d) {
				e.onmouseover = (function(f) {
					return function() {
						f._play = false;
						f.run(false, true)
					}
				})(c);
				e.onmouseout = (function(f) {
					return function() {
						f._play = true;
						f.run(false, true)
					}
				})(c)
			})
		},
		run : function(e, c) {
			if (this.curIndex < 0) {
				this.curIndex = this._count - 1
			} else {
				if (this.curIndex >= this._count) {
					this.curIndex = 0
				}
			}
			this._target = -1 * this._panelSize * this.curIndex;
			var d = this;
			if (this._navs) {
				b.each(this._navs, function(g, f) {
					d.curIndex == (f) ? a.addClass(g, d._navClassOn) : a
							.removeClass(g, d._navClassOn)
				})
			}
			this.scroll();
			if (this._effect.indexOf("fade") >= 0 && !c) {
				a.setStyle(this._panelWrapper, "opacity", e ? 0.5 : 0.1);
				this.fade()
			}
		},
		scroll : function() {
			clearTimeout(this._timer);
			try {
				if (QZFL.lazyLoad.isVisible(this._sliders[this.curIndex])) {
					QZFL.lazyLoad.loadHideImg(this._sliders[this.curIndex])
				}
			} catch (d) {
			}
			var g = this, f = parseInt(this._panelWrapper.style[this._changeProperty]) || 0, c = (this._target - f)
					/ this.step;
			if (Math.abs(c) < 1 && c != 0) {
				c = c > 0 ? 1 : -1
			}
			if (c != 0) {
				this._panelWrapper.style[this._changeProperty] = (f + c) + "px";
				this._timer = setTimeout(function() {
					g.scroll()
				}, this.slideTime)
			} else {
				this._panelWrapper.style[this._changeProperty] = this._target
						+ "px";
				if (this._play) {
					this._timer = setTimeout(function() {
						g.curIndex++;
						g.run()
					}, this.autoPlayInterval)
				}
			}
		},
		fade : function() {
			var c = a.getStyle(this._panelWrapper, "opacity");
			var d = this;
			if (c < 1) {
				a.setStyle(this._panelWrapper, "opacity", parseFloat(c) + 0.02);
				setTimeout(function() {
					d.fade()
				}, 1)
			}
		},
		next : function() {
			this._play = false;
			this.curIndex++;
			this._play = true;
			this.run()
		},
		prev : function() {
			this._play = false;
			this.curIndex--;
			this._play = true;
			this.run()
		}
	};
	jWidget.ui.SlideView = function(d, c) {
		if (!d.panelWrapper) {
			c = c || {};
			c.container = d
		} else {
			c = d
		}
		return new _Slide(c)
	}
})();
(function() {
	var b = jWidget, a = b.dom;
	_Tab = function(d) {
		this.eventType = d.eventType || "mouseover",
				this._container = d.container;
		this._type = d.type || "normal";
		this._navClassOn = d.navClassOn || "on";
		var e = this;
		if (this._type == "list") {
			var c = a.getChildren(this._container);
			this._panels = [];
			this._navs = [];
			b.each(c, function(g, f) {
				if (f % 2) {
					e._panels.push(g)
				} else {
					e._navs.push(g)
				}
			})
		} else {
			this._navWrapper = a.get(d.navWrapper)
					|| a.getFirstChild(this._container);
			this._navs = a.getChildren(this._navWrapper);
			this._panelWrapper = a.get(d.panelWrapper)
					|| a.getNextSibling(this._navWrapper);
			this._panels = a.getChildren(this._panelWrapper)
		}
		this.curIndex = 0;
		b.each(this._panels, function(g, f) {
			if (g.style.display != "none") {
				e.curIndex = f
			}
		});
		this._panels[this.curIndex].style.display = "";
		this._panels[this.curIndex].style.display = "";
		a.removeClass(this._navs[this.curIndex], this._navClassOn);
		a.addClass(this._navs[this.curIndex], this._navClassOn);
		b.each(this._navs, function(g, f) {
			g["on" + e.eventType] = (function(h) {
				return function() {
					a.removeClass(h._navs[h.curIndex], h._navClassOn);
					h._panels[h.curIndex].style.display = "none";
					h.curIndex = f;
					a.addClass(g, h._navClassOn);
					h._panels[h.curIndex].style.display = "";
					try {
						QZFL.lazyLoad.loadHideImg(h._panels[h.curIndex])
					} catch (i) {
					}
				}
			})(e)
		})
	};
	jWidget.ui.TabView = function(d, c) {
		c = c || {};
		c.container = a.get(d);
		return new _Tab(c)
	}
})();
jWidget.ui.Pager = function(b, a) {
	if (!b) {
		return
	}
	this.container = document.getElementById(b);
	this.offset = a.offset || 2;
	this.step = this.offset + 2;
	this.pageNum = a.pageNum;
	this.callback = a.callback || function() {
	};
	this.currentTpl = a.currentTpl
			|| '<a class="num on"><span>{num}</span></a>';
	this.anchor = a.anchor;
	this.normalTpl = a.normalTpl
			|| '<a class="num" onclick="pager.go({num})"><span>{num}</span></a>';
	this.omitTpl = a.omitTpl || '<span class="omit">...</span>';
	this.firstTpl = a.firstTpl || "";
	this.lastTpl = a.lastTpl || "";
	this.preTpl = a.preTpl
			|| '<a href="'
			+ (this.anchor ? "#" + this.anchor : "javascript:;")
			+ '" onclick="pager.go({num})"><span class="before_page">上一页</span></a>';
	this.nextTpl = a.nextTpl
			|| '<a href="'
			+ (this.anchor ? "#" + this.anchor : "javascript:;")
			+ '" onclick="pager.go({num})"><span class="next_page">下一页</span></a>';
	this.preDisableTpl = a.preDisableTpl || '<a href="'
			+ (this.anchor ? "#" + this.anchor : "javascript:;")
			+ '"><span class="before_page">上一页</span></a>';
	this.nextDisableTpl = a.nextDisableTpl || '<a href="'
			+ (this.anchor ? "#" + this.anchor : "javascript:;")
			+ '"><span class="next_page">下一页</span></a>';
	this.show(1)
};
jWidget.ui.Pager.prototype.go = function(b) {
	try {
		this.callback(b)
	} catch (a) {
	}
	if (this.anchor) {
		window.location.hash = "#" + this.anchor
	}
	this.show(b)
};
jWidget.ui.Pager.prototype.show = function(h) {
	if (h < 1 || h > this.pageNum) {
		return false
	}
	var f = 0, b = 0;
	if (h - 2 < this.step) {
		f = this.step - (h - 1)
	}
	if (this.pageNum - h - 1 < this.step) {
		b = this.step - (this.pageNum - h)
	}
	var a = h - this.offset - b;
	var g = h + this.offset + f;
	var e = [];
	e.push(this.firstTpl);
	if (h > 1) {
		var k = this.preTpl.replace("{num}", h - 1);
		e.push(k)
	} else {
		e.push(this.preDisableTpl)
	}
	if (a > 1) {
		e.push(this.normalTpl.replace(/{num}/g, 1))
	}
	if (a == 3) {
		e.push(this.normalTpl.replace(/{num}/g, 2))
	} else {
		if (a > 3) {
			e.push(this.omitTpl)
		}
	}
	for ( var c = h, d = a; d < c; d++) {
		if (d < 1) {
			continue
		}
		e.push(this.normalTpl.replace(/{num}/g, d))
	}
	e.push(this.currentTpl.replace(/{num}/g, h));
	for ( var d = h + 1, c = g + 1; d < c; d++) {
		if (d > this.pageNum) {
			break
		}
		e.push(this.normalTpl.replace(/{num}/g, d))
	}
	if (g == this.pageNum - 2) {
		e.push(this.normalTpl.replace(/{num}/g, this.pageNum - 1))
	} else {
		if (g < this.pageNum - 2) {
			e.push(this.omitTpl)
		}
	}
	if (g < this.pageNum) {
		e.push(this.normalTpl.replace(/{num}/g, this.pageNum))
	}
	if (h < this.pageNum) {
		var k = this.nextTpl.replace("{num}", h + 1);
		e.push(k)
	} else {
		e.push(this.nextDisableTpl)
	}
	e.push(this.lastTpl.replace(/{num}/g, this.pageNum));
	this.container.innerHTML = e.join("");
	return true
};
(function() {
	_SlideBanner = function(f) {
		var d = jWidget, b = f.upTime || 2, h = f.downTime || 1.2, g = f.delayTime || 4, c = d.dom
				.get(f.bigBanner || "silde_banner_big"), i = d.dom
				.get(f.smallBanner || "silde_banner_small"), e = f.bigHeight
				|| "420px", a = f.smallHeight || "45px";
		i.style.height = "0px";
		i.style.overflow = c.style.overflow = "hidden";
		setTimeout(function() {
			new d.Tween(c, "height", null, e, "0px", b).start();
			setTimeout(function() {
				i.style.display = "";
				new d.Tween(i, "height", null, "0px", a, h).start()
			}, b * 1000)
		}, g * 1000)
	};
	jWidget.ui.SlideBanner = function(a) {
		a = a || {};
		return new _SlideBanner(a)
	}
})();
jWidget.extend(QZFL.ui = QZFL.ui || {}, jWidget.ui);
QZFL.speedReport = (function() {
	var c = "http://isdspeed.qq.com/cgi-bin/r.cgi";
	var b = 1;
	var a = 2000;
	var e = 169;
	function d(f, k, j, h, i, g) {
		h = h || b;
		i = i || a;
		if (Math.random() >= h) {
			return
		}
		var m = (function(n, r, q, p) {
			return function() {
				var v = [];
				v.push("flag1=" + e);
				v.push("flag2=" + r);
				v.push("flag3=" + q);
				for ( var u = 1, s = n.length; u <= s; u++) {
					if (n[u]) {
						v.push(u + "=" + n[u])
					}
				}
				extParm = p || {};
				for (key in extParm) {
					v.push(key + "=" + extParm[key])
				}
				var t = new Image();
				t.src = c + "?" + v.join("&")
			}
		})(f, k, j, g);
		setTimeout(m, i)
	}
	return {
		WEB_MY : 100,
		WEB_FACE : 101,
		WEB_MAGIC : 102,
		WEB_ECARD : 103,
		WEB_RING : 104,
		WEB_VIP : 105,
		WEB_HAOMA : 106,
		WEB_FAV : 107,
		WEB_FANLI : 108,
		WEB_SHANGHAI : 109,
		WEB_SHOP : 110,
		send : d
	}
})();
var QZFL = QZFL || {};
QZFL.quickLogin = (function() {
	var g = null;
	var h = null;
	var c = null;
	var a = null;
	var d = null;
	var e = null;
	function b() {
		if (!a) {
			return
		}
		try {
			g.style.top = (window.innerHeight / 2 + pageYOffset) - e / 2 + "px";
			g.style.left = (window.innerWidth / 2 + pageXOffset) - d / 2 + "px"
		} catch (j) {
			var i = document.documentElement;
			if (!document.body.scrollTop) {
				g.style.top = (i.offsetHeight / 2 + i.scrollTop) - e / 2 + "px";
				g.style.left = (i.offsetWidth / 2 + i.scrollLeft) - d / 2
						+ "px"
			} else {
				g.style.top = (i.offsetHeight / 2 + document.body.scrollTop)
						- e / 2 + "px";
				g.style.left = (i.offsetWidth / 2 + document.body.scrollLeft)
						- d / 2 + "px"
			}
		}
		setTimeout(b, 500)
	}
	function f(i) {
		if (window.location.href.indexOf(i) > -1) {
			return true
		}
		return false
	}
	return {
		close : function() {
			if (g) {
				a = false;
				g.style.display = "none";
				c && (c.style.display = "none")
			}
		},
		resize : function(i, j) {
			if (g) {
				a = true;
				d = i;
				e = j;
				g.style.width = i + "px";
				g.style.height = j + "px";
				g.getElementsByTagName("iframe")[0].style.height = j + "px";
				if (h) {
					if (!c) {
						var k = document.createElement("div");
						k.id = "_ptlogin2_mask_body";
						k.style.position = "absolute";
						k.style.background = "#333333";
						k.style.opacity = "0.3";
						k.style.filter = "alpha(opacity=30)";
						k.style.zIndex = "999";
						k.style.width = document.body.scrollWidth + "px";
						k.style.height = document.body.scrollHeight + "px";
						k.style.top = "0px";
						k.style.left = "0px";
						document.getElementsByTagName("body")[0].appendChild(k);
						c = k
					} else {
						c.style.display = "block"
					}
				}
				b(i, j)
			}
		},
		open : function(k, j, i) {
			document.domain = "qq.com";
			if (!j) {
				j = window.location.href
			}
			if (!g) {
				var q = document.createElement("div");
				q.id = "_ptlogin2_div_container";
				q.style.position = "absolute";
				q.style.zIndex = "1000";
				q.style.width = "1px";
				q.style.height = "1px";
				q.style.top = "1px";
				q.style.left = "1px";
				q.innerHTML = '<iframe frameborder="no" scrolling="no" width="100%" height="100%" src="about:blank"></iframe>';
				document.getElementsByTagName("body")[0].appendChild(q);
				g = q
			}
			g.style.display = "block";
			var p = "";
			var m = "";
			if (f("act.vip.qq.com")) {
				p = "vipact";
				m = "8000205"
			} else {
				if (f("my.qq.com")) {
					p = "vipmyqq";
					m = "8000203"
				} else {
					if (f("fanli.qq.com") || f("jump.fanli.qq.com")) {
						p = "vipcomm";
						m = "8000207"
					} else {
						p = "vipcomm";
						m = "8000201"
					}
				}
			}
			switch (k) {
			case 2:
				url = "http://ui.ptlogin2.qq.com/cgi-bin/login?link_target=blank&target=blank&appid="
						+ m
						+ "&qlogin_jumpname="
						+ p
						+ "&f_url=loginerroralert&qlogin_auto_login=0&s_url="
						+ escape("http://imgcache.qq.com/club/portal_new/redirect.html?jump_url="
								+ escape(j))
						+ "&qlogin_param="
						+ escape("jump_url=" + escape(j));
				break;
			default:
				url = "http://ui.ptlogin2.qq.com/cgi-bin/login?link_target=blank&target=blank&appid="
						+ m
						+ "&f_url=loginerroralert&s_url="
						+ escape("http://imgcache.qq.com/club/portal_new/redirect.html?jump_url="
								+ escape(j));
				break
			}
			g.getElementsByTagName("iframe")[0].src = url;
			if (!!i) {
				h = true
			} else {
				h = false
			}
		}
	}
})();
window.openLogin = QZFL.quickLogin.open;
window.ptlogin2_onClose = QZFL.quickLogin.close;
window.ptlogin2_onResize = QZFL.quickLogin.resize;
if ($ !== undefined) {
	window._$ = $
}
var $ = (function() {
	var a = function(b) {
		return QZFL.dom.get(b)
	};
	QZFL.object.extend(a, QZFL);
	QZFL.userAgent.adjustBehaviors();
	return a
})();/* |xGv00|8ec4d903115ccacdc7a46fd316a56bf9 */