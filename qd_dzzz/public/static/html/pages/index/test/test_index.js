// 公示平台mock

Mock.setup({
	timeout: 0 - 400,
	status: 200,
	headers: {
		'Content-Type': 'application/json'
	}
});

// 药品、医疗器械、化妆品三种子类数据
// 传参data{type} 0:药品  1：医疗器械  2：化妆品
Mock.mock('/typeList', {
	custom: {
		'list|1-28': [
			{
				name: '@cword(10,12)',
				id: '@guid()'
			}
		]
	}
});

// 获取行政区域数据
Mock.mock('/cityName', {
    custom: {
        'list|10': [{
            value: '@guid()', //code
            label: '@city()',
            'children|5-10': [{
                value: '@guid()',
                label: '@city()'
            }]
        }]
    }
})

// 列表数据
// 传参data{pageindex,pagesixe,typeId,keyWord,value1,value2,value3,value4,value5,value6,value7}
// pageidnex:页码从0开始 pagesize每页个数  typeId子类id  keyWrod:顶部搜索 value1:企业名称  value2:社会信用代码
// value3:许可编号 value4:行政区划  value5：发证机关  value6:发证日期  value7:产品名称
// rankState: 排序 numberdown、numberup  证书编号升降   timeup、timedown : 发证日期 升降 
Mock.mock('/ListDetail', {
	custom: {
        total: 1000, //总条数
		'list|10': [
			{
				certificat_name: '@cword(10,12)', //证书类型
                certificat_number: '@guid()', //证书编号
                firm_name: '@cword(10,20)', //企业名称
                dep_name: '@cword(10, 20)', //发证机关
                time: '@time(yyyy-MM-dd)', //发证日期
                state: '@cword(3,4)', //状态
                'handle|1-4': [{ //跳转内容
                    'name|+1': ['正文', '副本', '变更记录','变更2'],
                    url: 'http://www.baidu.com'
                }]
			}
		]
	}
});
