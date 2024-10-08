if (!window.Util) {
	window.Util = {};
}
$.extend(window.Util, {
	/**
	 * 快速渲染数字
	 * @param {String} space 命名空间
	 * @param {Object} data 数据
	 * @param {Boolean} animate 是否动态加载效果
	 * @param {Function} filterFn 过滤函数，处理渲染结果，比如加单位
	 */
	renderNum: function (space, data, filterFn) {
		for (var i in data) {
			if (Object.prototype.hasOwnProperty.call(data, i)) {
				var $dom = $('#' + space + '-' + i);
				if ($dom.length > 0) {
					$dom.text(filterFn ? filterFn(data[i]) : data[i]);
				}
			}
		}
	},
	/**
	 * 数字千分位转换
	 * @param {Number} n 转换数字
	 */
	addCommas: function (n) {
		if (isNaN(n)) {
			return '-';
		}
		n = (n + '').split('.');
		return (
			n[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,') +
			(n.length > 1 ? '.' + n[1] : '')
		);
	},
	/**
	 * 请求数据
	 * @param {Object} options 对象，包含url、请求类型、请求参数
	 * @param {Function} successFn 成功回调
	 * @param {Object} extraParams 额外请求参数
	 */
	getAjax: function (options, successFn, extraParams) {
		options = $.extend(
			{},
			{
				type: 'post',
				dataType: 'json'
			},
			options
		);
		var ajaxOptions = JSON.parse(JSON.stringify(options));
		if (options.data) {
			ajaxOptions.data = { params: JSON.stringify(options.data) };
		}
		ajaxOptions.url = (window.Config.isMock ? '' : window.Config.baseUrl) + options.url;
		$.ajax(ajaxOptions)
			.done(function (data) {
				successFn && successFn(data.custom, extraParams);
			})
			.fail(function (err) {
				/* eslint-disable */
				console.log('接口请求失败 ', err);
				/* eslint-enable */
			});
	},

	/**
	 * 获取数组中指定属性的最大值
	 * @param {Array} arr 数组
	 * @param {String} key 指定属性
	 * @returns {Number} 最大数值
	 * @example [{key:166},{key:200},{key:33}]=>getMax(arr,'key);=>200
	 */
	getMax: function (arr, key) {
		var max = 0,
			len = arr.length;
		for (var i = 0; i < len; i++) {
			var item = Number(arr[i][key]);
			if (max < item) max = item;
		}
		return max;
	},
	/**
	 * 获取数组中指定属性的最小值
	 * @param {Array} arr 数组
	 * @param {String} key 指定属性
	 * @returns {Number} 最小值
	 * @example [{key:166},{key:200},{key:33}]=>getMax(arr,'key);=>33
	 */
	getMin: function (arr, key) {
		if (arr.length === 0) return;
		var min = Number(arr[0][key]),
			len = arr.length;
		for (var i = 1; i < len; i++) {
			var item = Number(arr[i][key]);
			if (min > item) min = item;
		}
		return min;
	},
	/**
	 * 定时切换地图高亮
	 * @param {Object}chartInstance 图表实例
	 * @param {Number} length 数据长度
	 */
	areaHight: function (chartInstance, length) {
		chartInstance.dataLen = length;
		chartInstance.curData = 0;
		clearInterval(chartInstance.hightTimer);
		chartInstance.hightTimer = setInterval(function () {
			if (chartInstance.curData === chartInstance.dataLen) {
				chartInstance.curData = 0;
			}
			// 取消高亮
			chartInstance.dispatchAction({
				type: 'downplay',
				seriesIndex: 0
			});
			// 高亮地图区域
			chartInstance.dispatchAction({
				type: 'highlight',
				seriesIndex: 0,
				dataIndex: chartInstance.curData
			});
			// 显示悬浮窗
			chartInstance.dispatchAction({
				type: 'showTip',
				seriesIndex: 0,
				dataIndex: chartInstance.curData
			});
			chartInstance.curData++;
		}, 3000);
	}
});
