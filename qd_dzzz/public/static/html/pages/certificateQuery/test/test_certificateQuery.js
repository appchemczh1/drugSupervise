//首页证书查询Mock

Mock.setup({
	timeout: 0 - 400,
	status: 200,
	headers: {
		'Content-Type': 'application/json'
	}
});

// 药品、医疗器械、化妆品三种子类数据
// 传参data{type} 0:药品  1：医疗器械  2：化妆品
Mock.mock('/stampCase', {
	custom: {
		 await_stamp: '@integer(1, 9999)', //等待盖章总量
         warn_stamp: '@integer(1, 9999)', //盖章超时预警量
         'list|3': [{
            'name|+1': ['第二类体外诊断试剂注册证', '第二、三类医疗器械生产许可证', '医疗器械注册变更文件'], //名称
            value: '@integer(1, 999)', //数量
            url: 'http:///www.baidu.com', //跳转地址
         }]
	}
});

// 证书有效期预警数据
Mock.mock('/stampWarnList', {
    custom: {
        'list|20': [{
            type: '@cword(10,20)', //许可证书类型
            firm_name: '@cword(10,20)', //企业名称
            stamp_number: '@guid()', //证书编号
            'warn_state|1': ['已处理', '未处理'], //预警状态
        }]
    }
})

// 证书分布
Mock.mock('/stampDistribution',{
    custom: {
        'list|17': [{
            'name|+1': ['宜昌市', '荆州市', '咸宁市', '黄石市', '黄冈市', '鄂州市', '武汉市', '仙桃市', '天门市', '潜江市', '荆门市', '随州市', '孝感市', '襄阳市', '十堰市', '神农架林区', '恩施土家族苗族自治州'], //名称
            value: '@integer(1, 9999)', //数量
        }],
        total: '@integer(1, 999999)', //湖北省
        pro_total: '@integer(1, 99999)', //省本级
        drug_total: '@integer(1, 9999)', //药品证书数量
        app_total: '@integer(1, 9999)', //医疗器械证书数量
        cosmetics_total: '@integer(1, 9999)', //化妆品证书数量
    }
});

// 证书数量排名
Mock.mock('/stampRank', {
    custom: {
        'list|20': [{
            name: '@cword(10,15)', //名称
            value: '@integer(1, 99999)', //数量
            ratio: '@float(1, 99, 2, 2)', //占比
        }]
    }
})

// 证书总览
Mock.mock('/stampInfo',{
    custom: {
        'list|3': [{
            'name|+1': ['全省累计发证量', '省本级累计发证量', '市州累计发证量'], //名称
            total: '@integer(1, 999999)', //总量
            month_total: '@integer(1, 9999)', //本月发证量
            day_total: '@integer(1, 999)', //今日发证量
        }]
    }
})

// 企业总览
Mock.mock('/firmInfo',{
    custom: {
        dury_pd: '@integer(1, 999)', //药品生产
        dury_wholesale: '@integer(1, 999)', //药品批发
        retail: '@integer(1, 999)', //零售连锁总部
        medical: '@integer(1, 999)', //医疗机构剂
        instrument: '@integer(1, 999)', //器械生产
        cosmetics: '@integer(1, 999)', //化妆品生
        internet_total: '@integer(1, 9999)', //互联网信
        radioactivity: '@integer(1, 99)', //放射性生产
    }
})