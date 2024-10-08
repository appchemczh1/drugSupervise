import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '经营方式/服务性质
',
    align:"center",
    dataIndex: 'jyfs'
   },
   {
    title: '注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址
',
    align:"center",
    dataIndex: 'zcdz'
   },
   {
    title: '日常监督管理机构
',
    align:"center",
    dataIndex: 'rcjdgljg'
   },
   {
    title: '法定代表人/关键人员类型/委托方法定代表人
',
    align:"center",
    dataIndex: 'fddbr'
   },
   {
    title: '投诉举报电话
',
    align:"center",
    dataIndex: 'tsjbdh'
   },
   {
    title: '企业负责人/原负责人/委托方企业负责人
',
    align:"center",
    dataIndex: 'qyfzr'
   },
   {
    title: '质量负责人/变更后负责人/医疗器械质量安全管理人
',
    align:"center",
    dataIndex: 'zlfzr'
   },
   {
    title: '发证机关/备案部门/审批部门
',
    align:"center",
    dataIndex: 'fzjg'
   },
   {
    title: '生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址
',
    align:"center",
    dataIndex: 'scdzscfw'
   },
   {
    title: '签发人/签字
',
    align:"center",
    dataIndex: 'qfr'
   },
   {
    title: '发证日期/签章与日期/备案日期/批准日期/生效日期
',
    align:"center",
    dataIndex: 'fzrq'
   },
   {
    title: '有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文
',
    align:"center",
    dataIndex: 'yxqz'
   },
   {
    title: '质量授权人
',
    align:"center",
    dataIndex: 'zlsqr'
   },
   {
    title: '生产负责人
',
    align:"center",
    dataIndex: 'scfzr'
   },
   {
    title: '主要负责人/制剂室负责人/网站负责人
',
    align:"center",
    dataIndex: 'zyfzr'
   },
   {
    title: '经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途
',
    align:"center",
    dataIndex: 'jyfw'
   },
   {
    title: '仓库地址/网站ip地址/检查场地地址/库房地址
',
    align:"center",
    dataIndex: 'ckdz'
   },
   {
    title: '科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所
',
    align:"center",
    dataIndex: 'ksdz'
   },
   {
    title: '许可证类别
',
    align:"center",
    dataIndex: 'xkzlb'
   },
   {
    title: '科室名称
',
    align:"center",
    dataIndex: 'ksmc'
   },
   {
    title: '医疗机构类别
',
    align:"center",
    dataIndex: 'yljglb'
   },
   {
    title: '科室负责人
',
    align:"center",
    dataIndex: 'ksfzr'
   },
   {
    title: '进口单位
',
    align:"center",
    dataIndex: 'jkdw'
   },
   {
    title: '进口单位英文名称
',
    align:"center",
    dataIndex: 'jkdwyw'
   },
   {
    title: '进口单位地址
',
    align:"center",
    dataIndex: 'jkdwdz'
   },
   {
    title: '进口单位英文地址
',
    align:"center",
    dataIndex: 'jkdwdzyw'
   },
   {
    title: '出口单位
',
    align:"center",
    dataIndex: 'ckdw'
   },
   {
    title: '出口单位英文名称
',
    align:"center",
    dataIndex: 'ckdwyw'
   },
   {
    title: '出口单位地址
',
    align:"center",
    dataIndex: 'ckdwdz'
   },
   {
    title: '出口单位英文地址
',
    align:"center",
    dataIndex: 'ckdwdzyw'
   },
   {
    title: '进口药物名称
',
    align:"center",
    dataIndex: 'jkywmc'
   },
   {
    title: '进口药物英文名称
',
    align:"center",
    dataIndex: 'jkywmcyw'
   },
   {
    title: '商品编码
',
    align:"center",
    dataIndex: 'spbm'
   },
   {
    title: '剂型中文/剂型
',
    align:"center",
    dataIndex: 'jxzw'
   },
   {
    title: '剂型英文
',
    align:"center",
    dataIndex: 'jxyw'
   },
   {
    title: '包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格
',
    align:"center",
    dataIndex: 'bzgg'
   },
   {
    title: '包装与规格英文/规格英文
',
    align:"center",
    dataIndex: 'bzggyw'
   },
   {
    title: '进口药物数量
',
    align:"center",
    dataIndex: 'jkywsl'
   },
   {
    title: '进口药物数量英文
',
    align:"center",
    dataIndex: 'jkywslyw'
   },
   {
    title: '管制药物含量
',
    align:"center",
    dataIndex: 'gzywhl'
   },
   {
    title: '生产企业/药品实际生产者中文
',
    align:"center",
    dataIndex: 'scqy'
   },
   {
    title: '生产企业英文/药品实际生产者英文
',
    align:"center",
    dataIndex: 'scqyyw'
   },
   {
    title: '进口口岸
',
    align:"center",
    dataIndex: 'jkka'
   },
   {
    title: '进口口岸英文
',
    align:"center",
    dataIndex: 'jkkayw'
   },
   {
    title: '出口口岸
',
    align:"center",
    dataIndex: 'ckka'
   },
   {
    title: '出口口岸英文
',
    align:"center",
    dataIndex: 'ckkayw'
   },
   {
    title: '于下列日期前进口/于下列日期前出口/有效期起
',
    align:"center",
    dataIndex: 'yxqq'
   },
   {
    title: '发证机关英文/证明当局英文
',
    align:"center",
    dataIndex: 'fzjgyw'
   },
   {
    title: '出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名
',
    align:"center",
    dataIndex: 'ckywmc'
   },
   {
    title: '出口药物数量
',
    align:"center",
    dataIndex: 'ckywsl'
   },
   {
    title: '出口药物数量英文
',
    align:"center",
    dataIndex: 'ckywslyw'
   },
   {
    title: '发货单位联系电话/联系电话/委托方联系电话/委托方住所电话
	',
    align:"center",
    dataIndex: 'fhdwlxdh'
   },
   {
    title: '运输证明有效期开始日期/有效证明有效期限自
',
    align:"center",
    dataIndex: 'yszmyxqq'
   },
   {
    title: '运输证明有效期截止日期/邮寄证明有效期限至
',
    align:"center",
    dataIndex: 'yszmyxqz'
   },
   {
    title: '发证机关联系电话/电话
',
    align:"center",
    dataIndex: 'fzjgdh'
   },
   {
    title: '邮编/地址和邮编/委托方住所邮编
',
    align:"center",
    dataIndex: 'yb'
   },
   {
    title: '管制类别/类别/制剂类别/药品分类
',
    align:"center",
    dataIndex: 'gzlb'
   },
   {
    title: '专业、学历/技术职称/是否执业药师/从业年限
',
    align:"center",
    dataIndex: 'zyxl'
   },
   {
    title: '审批结论/备案结论/备案意见/检查结论
',
    align:"center",
    dataIndex: 'spjl'
   },
   {
    title: '主送单位/主送
',
    align:"center",
    dataIndex: 'zsdw'
   },
   {
    title: '抄送单位/抄送
',
    align:"center",
    dataIndex: 'csdw'
   },
   {
    title: '说明
',
    align:"center",
    dataIndex: 'sm'
   },
   {
    title: '备注
',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: '受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号
',
    align:"center",
    dataIndex: 'slh'
   },
   {
    title: '产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称
',
    align:"center",
    dataIndex: 'cpmc'
   },
   {
    title: '产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号
',
    align:"center",
    dataIndex: 'cpzcbapzbh'
   },
   {
    title: '上一级行政机关
',
    align:"center",
    dataIndex: 'syjxzzjg'
   },
   {
    title: '人民政府
',
    align:"center",
    dataIndex: 'rmzf'
   },
   {
    title: '上传附件/附件
',
    align:"center",
    dataIndex: 'scfj'
   },
   {
    title: '有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期
',
    align:"center",
    dataIndex: 'yxq'
   },
   {
    title: '质量标准/药品标准
',
    align:"center",
    dataIndex: 'zlbz'
   },
   {
    title: '产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号
',
    align:"center",
    dataIndex: 'cpph'
   },
   {
    title: '调剂数量
',
    align:"center",
    dataIndex: 'tjsl'
   },
   {
    title: '制剂名称汉语拼音/汉语拼音
',
    align:"center",
    dataIndex: 'zjmchypy'
   },
   {
    title: '抄报单位
',
    align:"center",
    dataIndex: 'cbdw'
   },
   {
    title: '变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容
',
    align:"center",
    dataIndex: 'bgnr'
   },
   {
    title: '企业名称英文/药品生产企业或者药品上市许可持有人英文
',
    align:"center",
    dataIndex: 'qymcyw'
   },
   {
    title: '企业地址英文/药品生产企业或者药品上市许可持有人地址英文
',
    align:"center",
    dataIndex: 'qydzyw'
   },
   {
    title: '对该生产工厂检查的日期中文
',
    align:"center",
    dataIndex: 'jcrqzw'
   },
   {
    title: '对该生产工厂检查的日期英文
',
    align:"center",
    dataIndex: 'jcrqyw'
   },
   {
    title: '本证明文件的有效期英文/批准时间英文/证明的有效期至英文
',
    align:"center",
    dataIndex: 'zmwjyxqyw'
   },
   {
    title: '签发部门地址中文/证明当局地址中文
',
    align:"center",
    dataIndex: 'fzjgdzzw'
   },
   {
    title: '签发部门地址英文/证明当局地址英文
',
    align:"center",
    dataIndex: 'fzjgdzyw'
   },
   {
    title: '负责人姓名及职务中文
',
    align:"center",
    dataIndex: 'fzrxmzwzw'
   },
   {
    title: '负责人姓名及职务英文
',
    align:"center",
    dataIndex: 'fzrxmzwyw'
   },
   {
    title: '电子邮箱/联系人电子邮箱
',
    align:"center",
    dataIndex: 'dzyx'
   },
   {
    title: '传真/联系人传真
',
    align:"center",
    dataIndex: 'lxrcz'
   },
   {
    title: '证书编号英文/产品批准文号英文
',
    align:"center",
    dataIndex: 'zsbhyw'
   },
   {
    title: '产品名称英文
',
    align:"center",
    dataIndex: 'cpmcyw'
   },
   {
    title: '商品名中文
',
    align:"center",
    dataIndex: 'spmzw'
   },
   {
    title: '商品名英文
',
    align:"center",
    dataIndex: 'spmyw'
   },
   {
    title: '活性成分中文
',
    align:"center",
    dataIndex: 'hxcfzw'
   },
   {
    title: '活性成分英文
',
    align:"center",
    dataIndex: 'hxcfyw'
   },
   {
    title: '包括辅料在内的完整处方组成中文
',
    align:"center",
    dataIndex: 'cfzczw'
   },
   {
    title: '包括辅料在内的完整处方组成英文
',
    align:"center",
    dataIndex: 'cfzcyw'
   },
   {
    title: '该药品规格是否获得许可在中国市场上使用
',
    align:"center",
    dataIndex: 'sfhdxkzzgscssy'
   },
   {
    title: '该药品规格是否已经在中国市场上使用
',
    align:"center",
    dataIndex: 'sfyjzzgscssy'
   },
   {
    title: '药品实际生产者地址中文
',
    align:"center",
    dataIndex: 'ypsjsczdzzw'
   },
   {
    title: '药品实际生产者地址英文
',
    align:"center",
    dataIndex: 'ypsjsczdzyw'
   },
   {
    title: '证明当局是否对该药品的实际生产企业进行定期检查
',
    align:"center",
    dataIndex: 'jxdqjc'
   },
   {
    title: '定期检查的周期
',
    align:"center",
    dataIndex: 'dqjczq'
   },
   {
    title: '此类剂型的生产是否检查过
',
    align:"center",
    dataIndex: 'jxscsfjc'
   },
   {
    title: '生产设备和操作是否符合WHO推荐的药品生产质量管理规范
',
    align:"center",
    dataIndex: 'sffhwhogf'
   },
   {
    title: '申请人所提供的信息是否满足证明当局的要求
',
    align:"center",
    dataIndex: 'zmdjyq'
   },
   {
    title: '该规格未注册的理由中文
',
    align:"center",
    dataIndex: 'wzclyzw'
   },
   {
    title: '该规格未注册的理由英文
',
    align:"center",
    dataIndex: 'wzclyyw'
   },
   {
    title: '检查生产车间/线
',
    align:"center",
    dataIndex: 'jcsccj'
   },
   {
    title: '企业排查和整改情况表
',
    align:"center",
    dataIndex: 'qyjczgqk'
   },
   {
    title: '企业开展风险排查情况
',
    align:"center",
    dataIndex: 'qykzfxpcqk'
   },
   {
    title: '提示风险和问题是否存在
',
    align:"center",
    dataIndex: 'fxwtsfcz'
   },
   {
    title: '企业整改情况
',
    align:"center",
    dataIndex: 'qyzgqk'
   },
   {
    title: '其他建议或意见
',
    align:"center",
    dataIndex: 'qtjyyj'
   },
   {
    title: '认证范围中文
',
    align:"center",
    dataIndex: 'rzfwzw'
   },
   {
    title: '认证范围英文
',
    align:"center",
    dataIndex: 'rzfwyw'
   },
   {
    title: '受托方企业名称
',
    align:"center",
    dataIndex: 'stfqymc'
   },
   {
    title: '受托方生产备案编号
',
    align:"center",
    dataIndex: 'stfscbabh'
   },
   {
    title: '受托方住所
',
    align:"center",
    dataIndex: 'stfzs'
   },
   {
    title: '受托方生产地址
',
    align:"center",
    dataIndex: 'stfscdz'
   },
   {
    title: '受托方生产企业所在辖区
',
    align:"center",
    dataIndex: 'stfscqyszxq'
   },
   {
    title: '受托方组织机构代码
',
    align:"center",
    dataIndex: 'stfzzjgdm'
   },
   {
    title: '受托方联系电话
',
    align:"center",
    dataIndex: 'stflxdh'
   },
   {
    title: '受托方法定代表人
',
    align:"center",
    dataIndex: 'stffddbr'
   },
   {
    title: '受托方企业负责人
',
    align:"center",
    dataIndex: 'stfqyfzr'
   },
   {
    title: '代理人名称
',
    align:"center",
    dataIndex: 'dlrmc'
   },
   {
    title: '代理人住所/代理人地址
',
    align:"center",
    dataIndex: 'dlrzs'
   },
   {
    title: '结构组成/主要组成成分/性能结构及组成
',
    align:"center",
    dataIndex: 'jgzc'
   },
   {
    title: '预期用途/主要工作原理或者作用机理
',
    align:"center",
    dataIndex: 'yqyt'
   },
   {
    title: '委托方生产地址邮编
',
    align:"center",
    dataIndex: 'stfscdzyb'
   },
   {
    title: '委托方生产地址电话
',
    align:"center",
    dataIndex: 'stfscdzdh'
   },
   {
    title: '受托方联系人
',
    align:"center",
    dataIndex: 'stflxr'
   },
   {
    title: '受托方住所邮编
',
    align:"center",
    dataIndex: 'wtfzsyb'
   },
   {
    title: '受托方住所电话
',
    align:"center",
    dataIndex: 'wtfzsdh'
   },
   {
    title: '受托方生产地址邮编
',
    align:"center",
    dataIndex: 'wtfscdzyb'
   },
   {
    title: '受托方生产地址电话
',
    align:"center",
    dataIndex: 'wtfscdzdh'
   },
   {
    title: '医疗器械网络销售备案类型
',
    align:"center",
    dataIndex: 'ylqxwlxsbalx'
   },
   {
    title: '联系人姓名
',
    align:"center",
    dataIndex: 'lxrxm'
   },
   {
    title: '联系人身份证类型
',
    align:"center",
    dataIndex: 'lxrsfzlb'
   },
   {
    title: '联系人证件号
',
    align:"center",
    dataIndex: 'lxrzjh'
   },
   {
    title: '联系人电话
',
    align:"center",
    dataIndex: 'lxrdh'
   },
   {
    title: '主体业态
',
    align:"center",
    dataIndex: 'ztyt'
   },
   {
    title: '服务器存放地址
',
    align:"center",
    dataIndex: 'fwqcfdz'
   },
   {
    title: '联系地址
',
    align:"center",
    dataIndex: 'lxdz'
   },
   {
    title: '联系手机
',
    align:"center",
    dataIndex: 'lxsj'
   },
   {
    title: '申请资料
',
    align:"center",
    dataIndex: 'syzl'
   },
   {
    title: '试验名称
',
    align:"center",
    dataIndex: 'symc'
   },
   {
    title: '试验目标
',
    align:"center",
    dataIndex: 'symb'
   },
   {
    title: '试验用医疗器械分类
',
    align:"center",
    dataIndex: 'syyylqxfl'
   },
   {
    title: '需进行临床试验审批的第三类医疗器械
',
    align:"center",
    dataIndex: 'xjjlcsyspdsfylqx'
   },
   {
    title: '中国境内同类产品
',
    align:"center",
    dataIndex: 'zgjltlcp'
   },
   {
    title: '多中心临床试验
',
    align:"center",
    dataIndex: 'dzxlcsy'
   },
   {
    title: '代理人联系人
',
    align:"center",
    dataIndex: 'dlrlxr'
   },
   {
    title: '代理人电话
',
    align:"center",
    dataIndex: 'dlrdh'
   },
   {
    title: '代理人邮编
',
    align:"center",
    dataIndex: 'dlryb'
   },
   {
    title: '监查员姓名
',
    align:"center",
    dataIndex: 'jcyxm'
   },
   {
    title: '监查员电话
',
    align:"center",
    dataIndex: 'jcydh'
   },
   {
    title: '企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者',
    align:"center",
    dataIndex: 'qymc'
   },
   {
    title: '许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号',
    align:"center",
    dataIndex: 'zsbh'
   },
   {
    title: '社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码

',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: '分类码
',
    align:"center",
    dataIndex: 'flm'
   },
   {
    title: '生产地址和范围副本/范围英文',
    align:"center",
    dataIndex: 'scdzscfwyw'
   },
   {
    title: 'areaname',
    align:"center",
    dataIndex: 'areaname'
   },
   {
    title: 'areacode',
    align:"center",
    dataIndex: 'areacode'
   },
   {
    title: 'dzzzid',
    align:"center",
    dataIndex: 'dzzzid'
   },
   {
    title: 'ewm',
    align:"center",
    dataIndex: 'ewm'
   },
   {
    title: 'transid',
    align:"center",
    dataIndex: 'transid'
   },
   {
    title: 'zjdwmc',
    align:"center",
    dataIndex: 'zjdwmc'
   },
   {
    title: 'zjpzdz',
    align:"center",
    dataIndex: 'zjpzdz'
   },
   {
    title: 'fj',
    align:"center",
    dataIndex: 'fj'
   },
   {
    title: 'dwdz',
    align:"center",
    dataIndex: 'dwdz'
   },
   {
    title: 'dwmc',
    align:"center",
    dataIndex: 'dwmc'
   },
   {
    title: 'pzwh',
    align:"center",
    dataIndex: 'pzwh'
   },
   {
    title: 'syqx',
    align:"center",
    dataIndex: 'syqx'
   },
   {
    title: 'guige',
    align:"center",
    dataIndex: 'guige'
   },
   {
    title: 'yzjwh',
    align:"center",
    dataIndex: 'yzjwh'
   },
   {
    title: 'rzbh',
    align:"center",
    dataIndex: 'rzbh'
   },
   {
    title: 'stfpjpzdz',
    align:"center",
    dataIndex: 'stfpjpzdz'
   },
   {
    title: 'pzwhyxq',
    align:"center",
    dataIndex: 'pzwhyxq'
   },
   {
    title: 'zjyxq',
    align:"center",
    dataIndex: 'zjyxq'
   },
   {
    title: 'wzmc',
    align:"center",
    dataIndex: 'wzmc'
   },
   {
    title: 'sqly',
    align:"center",
    dataIndex: 'sqly'
   },
   {
    title: 'ysbh',
    align:"center",
    dataIndex: 'ysbh'
   },
   {
    title: 'ckywmcyw',
    align:"center",
    dataIndex: 'ckywmcyw'
   },
   {
    title: 'jszc',
    align:"center",
    dataIndex: 'jszc'
   },
   {
    title: 'iszy',
    align:"center",
    dataIndex: 'iszy'
   },
   {
    title: 'cynx',
    align:"center",
    dataIndex: 'cynx'
   },
   {
    title: 'bgqqk',
    align:"center",
    dataIndex: 'bgqqk'
   },
   {
    title: 'bghqk',
    align:"center",
    dataIndex: 'bghqk'
   },
   {
    title: 'basx',
    align:"center",
    dataIndex: 'basx'
   },
   {
    title: 'sqrsfzh',
    align:"center",
    dataIndex: 'sqrsfzh'
   },
   {
    title: 'jl',
    align:"center",
    dataIndex: 'jl'
   },
   {
    title: 'pzwhyw',
    align:"center",
    dataIndex: 'pzwhyw'
   },
   {
    title: 'dqjczqyw',
    align:"center",
    dataIndex: 'dqjczqyw'
   },
   {
    title: 'wzcxm',
    align:"center",
    dataIndex: 'wzcxm'
   },
   {
    title: 'ipdz',
    align:"center",
    dataIndex: 'ipdz'
   },
   {
    title: 'hlwbah',
    align:"center",
    dataIndex: 'hlwbah'
   },
   {
    title: 'slsjn',
    align:"center",
    dataIndex: 'slsjn'
   },
   {
    title: 'slsjy',
    align:"center",
    dataIndex: 'slsjy'
   },
   {
    title: 'slsjr',
    align:"center",
    dataIndex: 'slsjr'
   },
   {
    title: 'cpphyw',
    align:"center",
    dataIndex: 'cpphyw'
   },
   {
    title: 'cpmc2',
    align:"center",
    dataIndex: 'cpmc2'
   },
   {
    title: 'cpmc3',
    align:"center",
    dataIndex: 'cpmc3'
   },
   {
    title: 'cpmc4',
    align:"center",
    dataIndex: 'cpmc4'
   },
   {
    title: 'guige2',
    align:"center",
    dataIndex: 'guige2'
   },
   {
    title: 'bzgg2',
    align:"center",
    dataIndex: 'bzgg2'
   },
   {
    title: 'bzgg3',
    align:"center",
    dataIndex: 'bzgg3'
   },
   {
    title: 'bzgg4',
    align:"center",
    dataIndex: 'bzgg4'
   },
   {
    title: 'xh1',
    align:"center",
    dataIndex: 'xh1'
   },
   {
    title: 'xh2',
    align:"center",
    dataIndex: 'xh2'
   },
   {
    title: 'xh3',
    align:"center",
    dataIndex: 'xh3'
   },
   {
    title: 'xh4',
    align:"center",
    dataIndex: 'xh4'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '经营方式/服务性质
',
    field: 'jyfs',
    component: 'InputTextArea',
  },
  {
    label: '注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址
',
    field: 'zcdz',
    component: 'InputTextArea',
  },
  {
    label: '日常监督管理机构
',
    field: 'rcjdgljg',
    component: 'Input',
  },
  {
    label: '法定代表人/关键人员类型/委托方法定代表人
',
    field: 'fddbr',
    component: 'Input',
  },
  {
    label: '投诉举报电话
',
    field: 'tsjbdh',
    component: 'Input',
  },
  {
    label: '企业负责人/原负责人/委托方企业负责人
',
    field: 'qyfzr',
    component: 'Input',
  },
  {
    label: '质量负责人/变更后负责人/医疗器械质量安全管理人
',
    field: 'zlfzr',
    component: 'Input',
  },
  {
    label: '发证机关/备案部门/审批部门
',
    field: 'fzjg',
    component: 'Input',
  },
  {
    label: '生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址
',
    field: 'scdzscfw',
    component: 'InputTextArea',
  },
  {
    label: '签发人/签字
',
    field: 'qfr',
    component: 'Input',
  },
  {
    label: '发证日期/签章与日期/备案日期/批准日期/生效日期
',
    field: 'fzrq',
    component: 'Input',
  },
  {
    label: '有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文
',
    field: 'yxqz',
    component: 'Input',
  },
  {
    label: '质量授权人
',
    field: 'zlsqr',
    component: 'Input',
  },
  {
    label: '生产负责人
',
    field: 'scfzr',
    component: 'Input',
  },
  {
    label: '主要负责人/制剂室负责人/网站负责人
',
    field: 'zyfzr',
    component: 'Input',
  },
  {
    label: '经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途
',
    field: 'jyfw',
    component: 'InputTextArea',
  },
  {
    label: '仓库地址/网站ip地址/检查场地地址/库房地址
',
    field: 'ckdz',
    component: 'InputTextArea',
  },
  {
    label: '科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所
',
    field: 'ksdz',
    component: 'InputTextArea',
  },
  {
    label: '许可证类别
',
    field: 'xkzlb',
    component: 'Input',
  },
  {
    label: '科室名称
',
    field: 'ksmc',
    component: 'Input',
  },
  {
    label: '医疗机构类别
',
    field: 'yljglb',
    component: 'Input',
  },
  {
    label: '科室负责人
',
    field: 'ksfzr',
    component: 'Input',
  },
  {
    label: '进口单位
',
    field: 'jkdw',
    component: 'Input',
  },
  {
    label: '进口单位英文名称
',
    field: 'jkdwyw',
    component: 'InputTextArea',
  },
  {
    label: '进口单位地址
',
    field: 'jkdwdz',
    component: 'InputTextArea',
  },
  {
    label: '进口单位英文地址
',
    field: 'jkdwdzyw',
    component: 'InputTextArea',
  },
  {
    label: '出口单位
',
    field: 'ckdw',
    component: 'Input',
  },
  {
    label: '出口单位英文名称
',
    field: 'ckdwyw',
    component: 'InputTextArea',
  },
  {
    label: '出口单位地址
',
    field: 'ckdwdz',
    component: 'InputTextArea',
  },
  {
    label: '出口单位英文地址
',
    field: 'ckdwdzyw',
    component: 'InputTextArea',
  },
  {
    label: '进口药物名称
',
    field: 'jkywmc',
    component: 'Input',
  },
  {
    label: '进口药物英文名称
',
    field: 'jkywmcyw',
    component: 'InputTextArea',
  },
  {
    label: '商品编码
',
    field: 'spbm',
    component: 'Input',
  },
  {
    label: '剂型中文/剂型
',
    field: 'jxzw',
    component: 'Input',
  },
  {
    label: '剂型英文
',
    field: 'jxyw',
    component: 'InputTextArea',
  },
  {
    label: '包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格
',
    field: 'bzgg',
    component: 'InputTextArea',
  },
  {
    label: '包装与规格英文/规格英文
',
    field: 'bzggyw',
    component: 'InputTextArea',
  },
  {
    label: '进口药物数量
',
    field: 'jkywsl',
    component: 'Input',
  },
  {
    label: '进口药物数量英文
',
    field: 'jkywslyw',
    component: 'Input',
  },
  {
    label: '管制药物含量
',
    field: 'gzywhl',
    component: 'Input',
  },
  {
    label: '生产企业/药品实际生产者中文
',
    field: 'scqy',
    component: 'Input',
  },
  {
    label: '生产企业英文/药品实际生产者英文
',
    field: 'scqyyw',
    component: 'Input',
  },
  {
    label: '进口口岸
',
    field: 'jkka',
    component: 'Input',
  },
  {
    label: '进口口岸英文
',
    field: 'jkkayw',
    component: 'Input',
  },
  {
    label: '出口口岸
',
    field: 'ckka',
    component: 'Input',
  },
  {
    label: '出口口岸英文
',
    field: 'ckkayw',
    component: 'Input',
  },
  {
    label: '于下列日期前进口/于下列日期前出口/有效期起
',
    field: 'yxqq',
    component: 'Input',
  },
  {
    label: '发证机关英文/证明当局英文
',
    field: 'fzjgyw',
    component: 'InputTextArea',
  },
  {
    label: '出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名
',
    field: 'ckywmc',
    component: 'InputTextArea',
  },
  {
    label: '出口药物数量
',
    field: 'ckywsl',
    component: 'Input',
  },
  {
    label: '出口药物数量英文
',
    field: 'ckywslyw',
    component: 'InputTextArea',
  },
  {
    label: '发货单位联系电话/联系电话/委托方联系电话/委托方住所电话
	',
    field: 'fhdwlxdh',
    component: 'Input',
  },
  {
    label: '运输证明有效期开始日期/有效证明有效期限自
',
    field: 'yszmyxqq',
    component: 'Input',
  },
  {
    label: '运输证明有效期截止日期/邮寄证明有效期限至
',
    field: 'yszmyxqz',
    component: 'Input',
  },
  {
    label: '发证机关联系电话/电话
',
    field: 'fzjgdh',
    component: 'Input',
  },
  {
    label: '邮编/地址和邮编/委托方住所邮编
',
    field: 'yb',
    component: 'Input',
  },
  {
    label: '管制类别/类别/制剂类别/药品分类
',
    field: 'gzlb',
    component: 'InputTextArea',
  },
  {
    label: '专业、学历/技术职称/是否执业药师/从业年限
',
    field: 'zyxl',
    component: 'Input',
  },
  {
    label: '审批结论/备案结论/备案意见/检查结论
',
    field: 'spjl',
    component: 'InputTextArea',
  },
  {
    label: '主送单位/主送
',
    field: 'zsdw',
    component: 'Input',
  },
  {
    label: '抄送单位/抄送
',
    field: 'csdw',
    component: 'Input',
  },
  {
    label: '说明
',
    field: 'sm',
    component: 'Input',
  },
  {
    label: '备注
',
    field: 'bz',
    component: 'Input',
  },
  {
    label: '受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号
',
    field: 'slh',
    component: 'Input',
  },
  {
    label: '产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称
',
    field: 'cpmc',
    component: 'Input',
  },
  {
    label: '产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号
',
    field: 'cpzcbapzbh',
    component: 'Input',
  },
  {
    label: '上一级行政机关
',
    field: 'syjxzzjg',
    component: 'Input',
  },
  {
    label: '人民政府
',
    field: 'rmzf',
    component: 'Input',
  },
  {
    label: '上传附件/附件
',
    field: 'scfj',
    component: 'InputTextArea',
  },
  {
    label: '有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期
',
    field: 'yxq',
    component: 'Input',
  },
  {
    label: '质量标准/药品标准
',
    field: 'zlbz',
    component: 'Input',
  },
  {
    label: '产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号
',
    field: 'cpph',
    component: 'Input',
  },
  {
    label: '调剂数量
',
    field: 'tjsl',
    component: 'Input',
  },
  {
    label: '制剂名称汉语拼音/汉语拼音
',
    field: 'zjmchypy',
    component: 'Input',
  },
  {
    label: '抄报单位
',
    field: 'cbdw',
    component: 'Input',
  },
  {
    label: '变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容
',
    field: 'bgnr',
    component: 'InputTextArea',
  },
  {
    label: '企业名称英文/药品生产企业或者药品上市许可持有人英文
',
    field: 'qymcyw',
    component: 'Input',
  },
  {
    label: '企业地址英文/药品生产企业或者药品上市许可持有人地址英文
',
    field: 'qydzyw',
    component: 'InputTextArea',
  },
  {
    label: '对该生产工厂检查的日期中文
',
    field: 'jcrqzw',
    component: 'Input',
  },
  {
    label: '对该生产工厂检查的日期英文
',
    field: 'jcrqyw',
    component: 'Input',
  },
  {
    label: '本证明文件的有效期英文/批准时间英文/证明的有效期至英文
',
    field: 'zmwjyxqyw',
    component: 'Input',
  },
  {
    label: '签发部门地址中文/证明当局地址中文
',
    field: 'fzjgdzzw',
    component: 'InputTextArea',
  },
  {
    label: '签发部门地址英文/证明当局地址英文
',
    field: 'fzjgdzyw',
    component: 'InputTextArea',
  },
  {
    label: '负责人姓名及职务中文
',
    field: 'fzrxmzwzw',
    component: 'Input',
  },
  {
    label: '负责人姓名及职务英文
',
    field: 'fzrxmzwyw',
    component: 'InputTextArea',
  },
  {
    label: '电子邮箱/联系人电子邮箱
',
    field: 'dzyx',
    component: 'InputTextArea',
  },
  {
    label: '传真/联系人传真
',
    field: 'lxrcz',
    component: 'Input',
  },
  {
    label: '证书编号英文/产品批准文号英文
',
    field: 'zsbhyw',
    component: 'InputTextArea',
  },
  {
    label: '产品名称英文
',
    field: 'cpmcyw',
    component: 'InputTextArea',
  },
  {
    label: '商品名中文
',
    field: 'spmzw',
    component: 'Input',
  },
  {
    label: '商品名英文
',
    field: 'spmyw',
    component: 'InputTextArea',
  },
  {
    label: '活性成分中文
',
    field: 'hxcfzw',
    component: 'Input',
  },
  {
    label: '活性成分英文
',
    field: 'hxcfyw',
    component: 'InputTextArea',
  },
  {
    label: '包括辅料在内的完整处方组成中文
',
    field: 'cfzczw',
    component: 'InputTextArea',
  },
  {
    label: '包括辅料在内的完整处方组成英文
',
    field: 'cfzcyw',
    component: 'InputTextArea',
  },
  {
    label: '该药品规格是否获得许可在中国市场上使用
',
    field: 'sfhdxkzzgscssy',
    component: 'Input',
  },
  {
    label: '该药品规格是否已经在中国市场上使用
',
    field: 'sfyjzzgscssy',
    component: 'Input',
  },
  {
    label: '药品实际生产者地址中文
',
    field: 'ypsjsczdzzw',
    component: 'InputTextArea',
  },
  {
    label: '药品实际生产者地址英文
',
    field: 'ypsjsczdzyw',
    component: 'InputTextArea',
  },
  {
    label: '证明当局是否对该药品的实际生产企业进行定期检查
',
    field: 'jxdqjc',
    component: 'Input',
  },
  {
    label: '定期检查的周期
',
    field: 'dqjczq',
    component: 'Input',
  },
  {
    label: '此类剂型的生产是否检查过
',
    field: 'jxscsfjc',
    component: 'Input',
  },
  {
    label: '生产设备和操作是否符合WHO推荐的药品生产质量管理规范
',
    field: 'sffhwhogf',
    component: 'Input',
  },
  {
    label: '申请人所提供的信息是否满足证明当局的要求
',
    field: 'zmdjyq',
    component: 'Input',
  },
  {
    label: '该规格未注册的理由中文
',
    field: 'wzclyzw',
    component: 'Input',
  },
  {
    label: '该规格未注册的理由英文
',
    field: 'wzclyyw',
    component: 'InputTextArea',
  },
  {
    label: '检查生产车间/线
',
    field: 'jcsccj',
    component: 'Input',
  },
  {
    label: '企业排查和整改情况表
',
    field: 'qyjczgqk',
    component: 'Input',
  },
  {
    label: '企业开展风险排查情况
',
    field: 'qykzfxpcqk',
    component: 'Input',
  },
  {
    label: '提示风险和问题是否存在
',
    field: 'fxwtsfcz',
    component: 'Input',
  },
  {
    label: '企业整改情况
',
    field: 'qyzgqk',
    component: 'Input',
  },
  {
    label: '其他建议或意见
',
    field: 'qtjyyj',
    component: 'Input',
  },
  {
    label: '认证范围中文
',
    field: 'rzfwzw',
    component: 'Input',
  },
  {
    label: '认证范围英文
',
    field: 'rzfwyw',
    component: 'InputTextArea',
  },
  {
    label: '受托方企业名称
',
    field: 'stfqymc',
    component: 'Input',
  },
  {
    label: '受托方生产备案编号
',
    field: 'stfscbabh',
    component: 'Input',
  },
  {
    label: '受托方住所
',
    field: 'stfzs',
    component: 'Input',
  },
  {
    label: '受托方生产地址
',
    field: 'stfscdz',
    component: 'InputTextArea',
  },
  {
    label: '受托方生产企业所在辖区
',
    field: 'stfscqyszxq',
    component: 'Input',
  },
  {
    label: '受托方组织机构代码
',
    field: 'stfzzjgdm',
    component: 'Input',
  },
  {
    label: '受托方联系电话
',
    field: 'stflxdh',
    component: 'Input',
  },
  {
    label: '受托方法定代表人
',
    field: 'stffddbr',
    component: 'Input',
  },
  {
    label: '受托方企业负责人
',
    field: 'stfqyfzr',
    component: 'Input',
  },
  {
    label: '代理人名称
',
    field: 'dlrmc',
    component: 'Input',
  },
  {
    label: '代理人住所/代理人地址
',
    field: 'dlrzs',
    component: 'Input',
  },
  {
    label: '结构组成/主要组成成分/性能结构及组成
',
    field: 'jgzc',
    component: 'InputTextArea',
  },
  {
    label: '预期用途/主要工作原理或者作用机理
',
    field: 'yqyt',
    component: 'InputTextArea',
  },
  {
    label: '委托方生产地址邮编
',
    field: 'stfscdzyb',
    component: 'InputTextArea',
  },
  {
    label: '委托方生产地址电话
',
    field: 'stfscdzdh',
    component: 'Input',
  },
  {
    label: '受托方联系人
',
    field: 'stflxr',
    component: 'Input',
  },
  {
    label: '受托方住所邮编
',
    field: 'wtfzsyb',
    component: 'Input',
  },
  {
    label: '受托方住所电话
',
    field: 'wtfzsdh',
    component: 'Input',
  },
  {
    label: '受托方生产地址邮编
',
    field: 'wtfscdzyb',
    component: 'Input',
  },
  {
    label: '受托方生产地址电话
',
    field: 'wtfscdzdh',
    component: 'Input',
  },
  {
    label: '医疗器械网络销售备案类型
',
    field: 'ylqxwlxsbalx',
    component: 'Input',
  },
  {
    label: '联系人姓名
',
    field: 'lxrxm',
    component: 'Input',
  },
  {
    label: '联系人身份证类型
',
    field: 'lxrsfzlb',
    component: 'Input',
  },
  {
    label: '联系人证件号
',
    field: 'lxrzjh',
    component: 'Input',
  },
  {
    label: '联系人电话
',
    field: 'lxrdh',
    component: 'Input',
  },
  {
    label: '主体业态
',
    field: 'ztyt',
    component: 'Input',
  },
  {
    label: '服务器存放地址
',
    field: 'fwqcfdz',
    component: 'InputTextArea',
  },
  {
    label: '联系地址
',
    field: 'lxdz',
    component: 'InputTextArea',
  },
  {
    label: '联系手机
',
    field: 'lxsj',
    component: 'Input',
  },
  {
    label: '申请资料
',
    field: 'syzl',
    component: 'InputTextArea',
  },
  {
    label: '试验名称
',
    field: 'symc',
    component: 'Input',
  },
  {
    label: '试验目标
',
    field: 'symb',
    component: 'InputTextArea',
  },
  {
    label: '试验用医疗器械分类
',
    field: 'syyylqxfl',
    component: 'Input',
  },
  {
    label: '需进行临床试验审批的第三类医疗器械
',
    field: 'xjjlcsyspdsfylqx',
    component: 'Input',
  },
  {
    label: '中国境内同类产品
',
    field: 'zgjltlcp',
    component: 'Input',
  },
  {
    label: '多中心临床试验
',
    field: 'dzxlcsy',
    component: 'Input',
  },
  {
    label: '代理人联系人
',
    field: 'dlrlxr',
    component: 'Input',
  },
  {
    label: '代理人电话
',
    field: 'dlrdh',
    component: 'Input',
  },
  {
    label: '代理人邮编
',
    field: 'dlryb',
    component: 'Input',
  },
  {
    label: '监查员姓名
',
    field: 'jcyxm',
    component: 'Input',
  },
  {
    label: '监查员电话
',
    field: 'jcydh',
    component: 'Input',
  },
  {
    label: '企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者',
    field: 'qymc',
    component: 'Input',
  },
  {
    label: '许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号',
    field: 'zsbh',
    component: 'Input',
  },
  {
    label: '社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码

',
    field: 'shxydm',
    component: 'Input',
  },
  {
    label: '分类码
',
    field: 'flm',
    component: 'Input',
  },
  {
    label: '生产地址和范围副本/范围英文',
    field: 'scdzscfwyw',
    component: 'Input',
  },
  {
    label: 'areaname',
    field: 'areaname',
    component: 'Input',
  },
  {
    label: 'areacode',
    field: 'areacode',
    component: 'Input',
  },
  {
    label: 'dzzzid',
    field: 'dzzzid',
    component: 'Input',
  },
  {
    label: 'ewm',
    field: 'ewm',
    component: 'Input',
  },
  {
    label: 'transid',
    field: 'transid',
    component: 'Input',
  },
  {
    label: 'zjdwmc',
    field: 'zjdwmc',
    component: 'Input',
  },
  {
    label: 'zjpzdz',
    field: 'zjpzdz',
    component: 'Input',
  },
  {
    label: 'fj',
    field: 'fj',
    component: 'InputTextArea',
  },
  {
    label: 'dwdz',
    field: 'dwdz',
    component: 'Input',
  },
  {
    label: 'dwmc',
    field: 'dwmc',
    component: 'Input',
  },
  {
    label: 'pzwh',
    field: 'pzwh',
    component: 'Input',
  },
  {
    label: 'syqx',
    field: 'syqx',
    component: 'Input',
  },
  {
    label: 'guige',
    field: 'guige',
    component: 'InputTextArea',
  },
  {
    label: 'yzjwh',
    field: 'yzjwh',
    component: 'Input',
  },
  {
    label: 'rzbh',
    field: 'rzbh',
    component: 'Input',
  },
  {
    label: 'stfpjpzdz',
    field: 'stfpjpzdz',
    component: 'Input',
  },
  {
    label: 'pzwhyxq',
    field: 'pzwhyxq',
    component: 'Input',
  },
  {
    label: 'zjyxq',
    field: 'zjyxq',
    component: 'Input',
  },
  {
    label: 'wzmc',
    field: 'wzmc',
    component: 'Input',
  },
  {
    label: 'sqly',
    field: 'sqly',
    component: 'Input',
  },
  {
    label: 'ysbh',
    field: 'ysbh',
    component: 'Input',
  },
  {
    label: 'ckywmcyw',
    field: 'ckywmcyw',
    component: 'InputTextArea',
  },
  {
    label: 'jszc',
    field: 'jszc',
    component: 'InputTextArea',
  },
  {
    label: 'iszy',
    field: 'iszy',
    component: 'Input',
  },
  {
    label: 'cynx',
    field: 'cynx',
    component: 'Input',
  },
  {
    label: 'bgqqk',
    field: 'bgqqk',
    component: 'Input',
  },
  {
    label: 'bghqk',
    field: 'bghqk',
    component: 'Input',
  },
  {
    label: 'basx',
    field: 'basx',
    component: 'Input',
  },
  {
    label: 'sqrsfzh',
    field: 'sqrsfzh',
    component: 'Input',
  },
  {
    label: 'jl',
    field: 'jl',
    component: 'InputTextArea',
  },
  {
    label: 'pzwhyw',
    field: 'pzwhyw',
    component: 'InputTextArea',
  },
  {
    label: 'dqjczqyw',
    field: 'dqjczqyw',
    component: 'InputTextArea',
  },
  {
    label: 'wzcxm',
    field: 'wzcxm',
    component: 'Input',
  },
  {
    label: 'ipdz',
    field: 'ipdz',
    component: 'Input',
  },
  {
    label: 'hlwbah',
    field: 'hlwbah',
    component: 'Input',
  },
  {
    label: 'slsjn',
    field: 'slsjn',
    component: 'Input',
  },
  {
    label: 'slsjy',
    field: 'slsjy',
    component: 'Input',
  },
  {
    label: 'slsjr',
    field: 'slsjr',
    component: 'Input',
  },
  {
    label: 'cpphyw',
    field: 'cpphyw',
    component: 'InputTextArea',
  },
  {
    label: 'cpmc2',
    field: 'cpmc2',
    component: 'Input',
  },
  {
    label: 'cpmc3',
    field: 'cpmc3',
    component: 'Input',
  },
  {
    label: 'cpmc4',
    field: 'cpmc4',
    component: 'Input',
  },
  {
    label: 'guige2',
    field: 'guige2',
    component: 'Input',
  },
  {
    label: 'bzgg2',
    field: 'bzgg2',
    component: 'InputTextArea',
  },
  {
    label: 'bzgg3',
    field: 'bzgg3',
    component: 'InputTextArea',
  },
  {
    label: 'bzgg4',
    field: 'bzgg4',
    component: 'InputTextArea',
  },
  {
    label: 'xh1',
    field: 'xh1',
    component: 'Input',
  },
  {
    label: 'xh2',
    field: 'xh2',
    component: 'Input',
  },
  {
    label: 'xh3',
    field: 'xh3',
    component: 'Input',
  },
  {
    label: 'xh4',
    field: 'xh4',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  jyfs: {title: '经营方式/服务性质
',order: 0,view: 'textarea', type: 'string',},
  zcdz: {title: '注册地址/申请地址/调出方地址/制剂配制地址/调入方地址/申请人注册地址/申请人制剂配制地址/委托配制制剂配制地址/受托方制剂配制地址/委托方单位地址/工厂地址中文/药品生产企业或者药品上市许可持有人地址中文/住所/委托方住所/备案人住所/注册人住所/生产企业住所/申办者地址
',order: 1,view: 'textarea', type: 'string',},
  rcjdgljg: {title: '日常监督管理机构
',order: 2,view: 'text', type: 'string',},
  fddbr: {title: '法定代表人/关键人员类型/委托方法定代表人
',order: 3,view: 'text', type: 'string',},
  tsjbdh: {title: '投诉举报电话
',order: 4,view: 'text', type: 'string',},
  qyfzr: {title: '企业负责人/原负责人/委托方企业负责人
',order: 5,view: 'text', type: 'string',},
  zlfzr: {title: '质量负责人/变更后负责人/医疗器械质量安全管理人
',order: 6,view: 'text', type: 'string',},
  fzjg: {title: '发证机关/备案部门/审批部门
',order: 7,view: 'text', type: 'string',},
  scdzscfw: {title: '生产地址和生产范围/配置地址和配置范围/生产地址/生产范围/委托方生产地址
',order: 8,view: 'textarea', type: 'string',},
  qfr: {title: '签发人/签字
',order: 9,view: 'text', type: 'string',},
  fzrq: {title: '发证日期/签章与日期/备案日期/批准日期/生效日期
',order: 10,view: 'text', type: 'string',},
  yxqz: {title: '有效期至/失效日期/有效期限/批准文号有效期/批准文号有效期至/本证明文件的有效期/批准时间中文/证明的有效期至中文
',order: 11,view: 'text', type: 'string',},
  zlsqr: {title: '质量授权人
',order: 12,view: 'text', type: 'string',},
  scfzr: {title: '生产负责人
',order: 13,view: 'text', type: 'string',},
  zyfzr: {title: '主要负责人/制剂室负责人/网站负责人
',order: 14,view: 'text', type: 'string',},
  jyfw: {title: '经营范围/使用范围/网站域名/范围/检查范围/品种/适用范围/生产范围/适用范围或者预期用途
',order: 15,view: 'textarea', type: 'string',},
  ckdz: {title: '仓库地址/网站ip地址/检查场地地址/库房地址
',order: 16,view: 'textarea', type: 'string',},
  ksdz: {title: '科室地址/生产企业所在辖区/经营场所/经营场所或生产场所/办公场所
',order: 17,view: 'textarea', type: 'string',},
  xkzlb: {title: '许可证类别
',order: 18,view: 'text', type: 'string',},
  ksmc: {title: '科室名称
',order: 19,view: 'text', type: 'string',},
  yljglb: {title: '医疗机构类别
',order: 20,view: 'text', type: 'string',},
  ksfzr: {title: '科室负责人
',order: 21,view: 'text', type: 'string',},
  jkdw: {title: '进口单位
',order: 22,view: 'text', type: 'string',},
  jkdwyw: {title: '进口单位英文名称
',order: 23,view: 'textarea', type: 'string',},
  jkdwdz: {title: '进口单位地址
',order: 24,view: 'textarea', type: 'string',},
  jkdwdzyw: {title: '进口单位英文地址
',order: 25,view: 'textarea', type: 'string',},
  ckdw: {title: '出口单位
',order: 26,view: 'text', type: 'string',},
  ckdwyw: {title: '出口单位英文名称
',order: 27,view: 'textarea', type: 'string',},
  ckdwdz: {title: '出口单位地址
',order: 28,view: 'textarea', type: 'string',},
  ckdwdzyw: {title: '出口单位英文地址
',order: 29,view: 'textarea', type: 'string',},
  jkywmc: {title: '进口药物名称
',order: 30,view: 'text', type: 'string',},
  jkywmcyw: {title: '进口药物英文名称
',order: 31,view: 'textarea', type: 'string',},
  spbm: {title: '商品编码
',order: 32,view: 'text', type: 'string',},
  jxzw: {title: '剂型中文/剂型
',order: 33,view: 'text', type: 'string',},
  jxyw: {title: '剂型英文
',order: 34,view: 'textarea', type: 'string',},
  bzgg: {title: '包装与规格中文/规格/包装规格/型号、规格/规格型号/试验用医疗器械型号规格
',order: 35,view: 'textarea', type: 'string',},
  bzggyw: {title: '包装与规格英文/规格英文
',order: 36,view: 'textarea', type: 'string',},
  jkywsl: {title: '进口药物数量
',order: 37,view: 'text', type: 'string',},
  jkywslyw: {title: '进口药物数量英文
',order: 38,view: 'text', type: 'string',},
  gzywhl: {title: '管制药物含量
',order: 39,view: 'text', type: 'string',},
  scqy: {title: '生产企业/药品实际生产者中文
',order: 40,view: 'text', type: 'string',},
  scqyyw: {title: '生产企业英文/药品实际生产者英文
',order: 41,view: 'text', type: 'string',},
  jkka: {title: '进口口岸
',order: 42,view: 'text', type: 'string',},
  jkkayw: {title: '进口口岸英文
',order: 43,view: 'text', type: 'string',},
  ckka: {title: '出口口岸
',order: 44,view: 'text', type: 'string',},
  ckkayw: {title: '出口口岸英文
',order: 45,view: 'text', type: 'string',},
  yxqq: {title: '于下列日期前进口/于下列日期前出口/有效期起
',order: 46,view: 'text', type: 'string',},
  fzjgyw: {title: '发证机关英文/证明当局英文
',order: 47,view: 'textarea', type: 'string',},
  ckywmc: {title: '出口药物名称/准予运输药品名称/药品名称/申请定点生产药品名称/药品通用名称/药品名称英文名拉丁名
',order: 48,view: 'textarea', type: 'string',},
  ckywsl: {title: '出口药物数量
',order: 49,view: 'text', type: 'string',},
  ckywslyw: {title: '出口药物数量英文
',order: 50,view: 'textarea', type: 'string',},
  fhdwlxdh: {title: '发货单位联系电话/联系电话/委托方联系电话/委托方住所电话
	',order: 51,view: 'text', type: 'string',},
  yszmyxqq: {title: '运输证明有效期开始日期/有效证明有效期限自
',order: 52,view: 'text', type: 'string',},
  yszmyxqz: {title: '运输证明有效期截止日期/邮寄证明有效期限至
',order: 53,view: 'text', type: 'string',},
  fzjgdh: {title: '发证机关联系电话/电话
',order: 54,view: 'text', type: 'string',},
  yb: {title: '邮编/地址和邮编/委托方住所邮编
',order: 55,view: 'text', type: 'string',},
  gzlb: {title: '管制类别/类别/制剂类别/药品分类
',order: 56,view: 'textarea', type: 'string',},
  zyxl: {title: '专业、学历/技术职称/是否执业药师/从业年限
',order: 57,view: 'text', type: 'string',},
  spjl: {title: '审批结论/备案结论/备案意见/检查结论
',order: 58,view: 'textarea', type: 'string',},
  zsdw: {title: '主送单位/主送
',order: 59,view: 'text', type: 'string',},
  csdw: {title: '抄送单位/抄送
',order: 60,view: 'text', type: 'string',},
  sm: {title: '说明
',order: 61,view: 'text', type: 'string',},
  bz: {title: '备注
',order: 62,view: 'text', type: 'string',},
  slh: {title: '受理号/互联网药品信息服务资格证书编号/非经营性互联网信息服务备案编号
',order: 63,view: 'text', type: 'string',},
  cpmc: {title: '产品名称/制剂名称/制剂名称通用名称/网络客户端应用程序名/网站域名/产品名称中文/试验用医疗器械产品/准予运输药品名称
',order: 64,view: 'text', type: 'string',},
  cpzcbapzbh: {title: '产品注册证明文件或备案凭证编号/《医疗机构制剂许可证》编号/《医疗机构制剂许可证》编号或《药品生产许可证》编号/《医疗机构制剂许可证》（或《药品生产质量管理规范》认证证书）编号/医疗器械生产(经营)许可证或备案凭证编号/生产许可或备案凭证号
',order: 65,view: 'text', type: 'string',},
  syjxzzjg: {title: '上一级行政机关
',order: 66,view: 'text', type: 'string',},
  rmzf: {title: '人民政府
',order: 67,view: 'text', type: 'string',},
  scfj: {title: '上传附件/附件
',order: 68,view: 'textarea', type: 'string',},
  yxq: {title: '有效期/使用期限/检查时间/产品储存条件及有效期/试验方案版本号及日期
',order: 69,view: 'text', type: 'string',},
  zlbz: {title: '质量标准/药品标准
',order: 70,view: 'text', type: 'string',},
  cpph: {title: '产品批号/电信业务经营许可证编号/非经营性互联网信息服务备案编号/产品注册或备案凭证号
',order: 71,view: 'text', type: 'string',},
  tjsl: {title: '调剂数量
',order: 72,view: 'text', type: 'string',},
  zjmchypy: {title: '制剂名称汉语拼音/汉语拼音
',order: 73,view: 'text', type: 'string',},
  cbdw: {title: '抄报单位
',order: 74,view: 'text', type: 'string',},
  bgnr: {title: '变更内容/申请内容/申请理由/备案事项/变更前情况/变更原因/变更后情况/其他内容
',order: 75,view: 'textarea', type: 'string',},
  qymcyw: {title: '企业名称英文/药品生产企业或者药品上市许可持有人英文
',order: 76,view: 'text', type: 'string',},
  qydzyw: {title: '企业地址英文/药品生产企业或者药品上市许可持有人地址英文
',order: 77,view: 'textarea', type: 'string',},
  jcrqzw: {title: '对该生产工厂检查的日期中文
',order: 78,view: 'text', type: 'string',},
  jcrqyw: {title: '对该生产工厂检查的日期英文
',order: 79,view: 'text', type: 'string',},
  zmwjyxqyw: {title: '本证明文件的有效期英文/批准时间英文/证明的有效期至英文
',order: 80,view: 'text', type: 'string',},
  fzjgdzzw: {title: '签发部门地址中文/证明当局地址中文
',order: 81,view: 'textarea', type: 'string',},
  fzjgdzyw: {title: '签发部门地址英文/证明当局地址英文
',order: 82,view: 'textarea', type: 'string',},
  fzrxmzwzw: {title: '负责人姓名及职务中文
',order: 83,view: 'text', type: 'string',},
  fzrxmzwyw: {title: '负责人姓名及职务英文
',order: 84,view: 'textarea', type: 'string',},
  dzyx: {title: '电子邮箱/联系人电子邮箱
',order: 85,view: 'textarea', type: 'string',},
  lxrcz: {title: '传真/联系人传真
',order: 86,view: 'text', type: 'string',},
  zsbhyw: {title: '证书编号英文/产品批准文号英文
',order: 87,view: 'textarea', type: 'string',},
  cpmcyw: {title: '产品名称英文
',order: 88,view: 'textarea', type: 'string',},
  spmzw: {title: '商品名中文
',order: 89,view: 'text', type: 'string',},
  spmyw: {title: '商品名英文
',order: 90,view: 'textarea', type: 'string',},
  hxcfzw: {title: '活性成分中文
',order: 91,view: 'text', type: 'string',},
  hxcfyw: {title: '活性成分英文
',order: 92,view: 'textarea', type: 'string',},
  cfzczw: {title: '包括辅料在内的完整处方组成中文
',order: 93,view: 'textarea', type: 'string',},
  cfzcyw: {title: '包括辅料在内的完整处方组成英文
',order: 94,view: 'textarea', type: 'string',},
  sfhdxkzzgscssy: {title: '该药品规格是否获得许可在中国市场上使用
',order: 95,view: 'text', type: 'string',},
  sfyjzzgscssy: {title: '该药品规格是否已经在中国市场上使用
',order: 96,view: 'text', type: 'string',},
  ypsjsczdzzw: {title: '药品实际生产者地址中文
',order: 97,view: 'textarea', type: 'string',},
  ypsjsczdzyw: {title: '药品实际生产者地址英文
',order: 98,view: 'textarea', type: 'string',},
  jxdqjc: {title: '证明当局是否对该药品的实际生产企业进行定期检查
',order: 99,view: 'text', type: 'string',},
  dqjczq: {title: '定期检查的周期
',order: 100,view: 'text', type: 'string',},
  jxscsfjc: {title: '此类剂型的生产是否检查过
',order: 101,view: 'text', type: 'string',},
  sffhwhogf: {title: '生产设备和操作是否符合WHO推荐的药品生产质量管理规范
',order: 102,view: 'text', type: 'string',},
  zmdjyq: {title: '申请人所提供的信息是否满足证明当局的要求
',order: 103,view: 'text', type: 'string',},
  wzclyzw: {title: '该规格未注册的理由中文
',order: 104,view: 'text', type: 'string',},
  wzclyyw: {title: '该规格未注册的理由英文
',order: 105,view: 'textarea', type: 'string',},
  jcsccj: {title: '检查生产车间/线
',order: 106,view: 'text', type: 'string',},
  qyjczgqk: {title: '企业排查和整改情况表
',order: 107,view: 'text', type: 'string',},
  qykzfxpcqk: {title: '企业开展风险排查情况
',order: 108,view: 'text', type: 'string',},
  fxwtsfcz: {title: '提示风险和问题是否存在
',order: 109,view: 'text', type: 'string',},
  qyzgqk: {title: '企业整改情况
',order: 110,view: 'text', type: 'string',},
  qtjyyj: {title: '其他建议或意见
',order: 111,view: 'text', type: 'string',},
  rzfwzw: {title: '认证范围中文
',order: 112,view: 'text', type: 'string',},
  rzfwyw: {title: '认证范围英文
',order: 113,view: 'textarea', type: 'string',},
  stfqymc: {title: '受托方企业名称
',order: 114,view: 'text', type: 'string',},
  stfscbabh: {title: '受托方生产备案编号
',order: 115,view: 'text', type: 'string',},
  stfzs: {title: '受托方住所
',order: 116,view: 'text', type: 'string',},
  stfscdz: {title: '受托方生产地址
',order: 117,view: 'textarea', type: 'string',},
  stfscqyszxq: {title: '受托方生产企业所在辖区
',order: 118,view: 'text', type: 'string',},
  stfzzjgdm: {title: '受托方组织机构代码
',order: 119,view: 'text', type: 'string',},
  stflxdh: {title: '受托方联系电话
',order: 120,view: 'text', type: 'string',},
  stffddbr: {title: '受托方法定代表人
',order: 121,view: 'text', type: 'string',},
  stfqyfzr: {title: '受托方企业负责人
',order: 122,view: 'text', type: 'string',},
  dlrmc: {title: '代理人名称
',order: 123,view: 'text', type: 'string',},
  dlrzs: {title: '代理人住所/代理人地址
',order: 124,view: 'text', type: 'string',},
  jgzc: {title: '结构组成/主要组成成分/性能结构及组成
',order: 125,view: 'textarea', type: 'string',},
  yqyt: {title: '预期用途/主要工作原理或者作用机理
',order: 126,view: 'textarea', type: 'string',},
  stfscdzyb: {title: '委托方生产地址邮编
',order: 127,view: 'textarea', type: 'string',},
  stfscdzdh: {title: '委托方生产地址电话
',order: 128,view: 'text', type: 'string',},
  stflxr: {title: '受托方联系人
',order: 129,view: 'text', type: 'string',},
  wtfzsyb: {title: '受托方住所邮编
',order: 130,view: 'text', type: 'string',},
  wtfzsdh: {title: '受托方住所电话
',order: 131,view: 'text', type: 'string',},
  wtfscdzyb: {title: '受托方生产地址邮编
',order: 132,view: 'text', type: 'string',},
  wtfscdzdh: {title: '受托方生产地址电话
',order: 133,view: 'text', type: 'string',},
  ylqxwlxsbalx: {title: '医疗器械网络销售备案类型
',order: 134,view: 'text', type: 'string',},
  lxrxm: {title: '联系人姓名
',order: 135,view: 'text', type: 'string',},
  lxrsfzlb: {title: '联系人身份证类型
',order: 136,view: 'text', type: 'string',},
  lxrzjh: {title: '联系人证件号
',order: 137,view: 'text', type: 'string',},
  lxrdh: {title: '联系人电话
',order: 138,view: 'text', type: 'string',},
  ztyt: {title: '主体业态
',order: 139,view: 'text', type: 'string',},
  fwqcfdz: {title: '服务器存放地址
',order: 140,view: 'textarea', type: 'string',},
  lxdz: {title: '联系地址
',order: 141,view: 'textarea', type: 'string',},
  lxsj: {title: '联系手机
',order: 142,view: 'text', type: 'string',},
  syzl: {title: '申请资料
',order: 143,view: 'textarea', type: 'string',},
  symc: {title: '试验名称
',order: 144,view: 'text', type: 'string',},
  symb: {title: '试验目标
',order: 145,view: 'textarea', type: 'string',},
  syyylqxfl: {title: '试验用医疗器械分类
',order: 146,view: 'text', type: 'string',},
  xjjlcsyspdsfylqx: {title: '需进行临床试验审批的第三类医疗器械
',order: 147,view: 'text', type: 'string',},
  zgjltlcp: {title: '中国境内同类产品
',order: 148,view: 'text', type: 'string',},
  dzxlcsy: {title: '多中心临床试验
',order: 149,view: 'text', type: 'string',},
  dlrlxr: {title: '代理人联系人
',order: 150,view: 'text', type: 'string',},
  dlrdh: {title: '代理人电话
',order: 151,view: 'text', type: 'string',},
  dlryb: {title: '代理人邮编
',order: 152,view: 'text', type: 'string',},
  jcyxm: {title: '监查员姓名
',order: 153,view: 'text', type: 'string',},
  jcydh: {title: '监查员电话
',order: 154,view: 'text', type: 'string',},
  qymc: {title: '企业名称/发货单位名称/药品生产企业名称/申请单位/产品持有人/医疗机构名称/调出方医疗机构单位名称/制剂配制单位名称/调入方医疗机构单位名称/申请人单位名称/委托配制单位名称/委托方单位名称/受托方单位名称/机构名称/网站名称/原药品生产企业名称/工厂名称中文/药品生产许可证编号/药品生产企业或者药品上市许可持有人中文/药品生产企业或者药品上市许可持有人/委托方企业名称/注册人名称/申请人名称/申办者',order: 155,view: 'text', type: 'string',},
  zsbh: {title: '许可证编号/进口准许证号/编号/批件号/广告批准文号/批准文号/原制剂文号/制剂批准文号/备案号/原始编号/药品批准文号/批准文号/备案编号/委托方生产备案编号/注册证编号',order: 156,view: 'text', type: 'string',},
  shxydm: {title: '社会信用代码/统一社会信用代码/委托配制单位社会信用代码/委托方组织机构代码

',order: 157,view: 'text', type: 'string',},
  flm: {title: '分类码
',order: 158,view: 'text', type: 'string',},
  scdzscfwyw: {title: '生产地址和范围副本/范围英文',order: 159,view: 'text', type: 'string',},
  areaname: {title: 'areaname',order: 160,view: 'text', type: 'string',},
  areacode: {title: 'areacode',order: 161,view: 'text', type: 'string',},
  dzzzid: {title: 'dzzzid',order: 162,view: 'text', type: 'string',},
  ewm: {title: 'ewm',order: 163,view: 'text', type: 'string',},
  transid: {title: 'transid',order: 164,view: 'text', type: 'string',},
  zjdwmc: {title: 'zjdwmc',order: 165,view: 'text', type: 'string',},
  zjpzdz: {title: 'zjpzdz',order: 166,view: 'text', type: 'string',},
  fj: {title: 'fj',order: 167,view: 'textarea', type: 'string',},
  dwdz: {title: 'dwdz',order: 168,view: 'text', type: 'string',},
  dwmc: {title: 'dwmc',order: 169,view: 'text', type: 'string',},
  pzwh: {title: 'pzwh',order: 170,view: 'text', type: 'string',},
  syqx: {title: 'syqx',order: 171,view: 'text', type: 'string',},
  guige: {title: 'guige',order: 172,view: 'textarea', type: 'string',},
  yzjwh: {title: 'yzjwh',order: 173,view: 'text', type: 'string',},
  rzbh: {title: 'rzbh',order: 174,view: 'text', type: 'string',},
  stfpjpzdz: {title: 'stfpjpzdz',order: 175,view: 'text', type: 'string',},
  pzwhyxq: {title: 'pzwhyxq',order: 176,view: 'text', type: 'string',},
  zjyxq: {title: 'zjyxq',order: 177,view: 'text', type: 'string',},
  wzmc: {title: 'wzmc',order: 178,view: 'text', type: 'string',},
  sqly: {title: 'sqly',order: 179,view: 'text', type: 'string',},
  ysbh: {title: 'ysbh',order: 180,view: 'text', type: 'string',},
  ckywmcyw: {title: 'ckywmcyw',order: 181,view: 'textarea', type: 'string',},
  jszc: {title: 'jszc',order: 182,view: 'textarea', type: 'string',},
  iszy: {title: 'iszy',order: 183,view: 'text', type: 'string',},
  cynx: {title: 'cynx',order: 184,view: 'text', type: 'string',},
  bgqqk: {title: 'bgqqk',order: 185,view: 'text', type: 'string',},
  bghqk: {title: 'bghqk',order: 186,view: 'text', type: 'string',},
  basx: {title: 'basx',order: 187,view: 'text', type: 'string',},
  sqrsfzh: {title: 'sqrsfzh',order: 188,view: 'text', type: 'string',},
  jl: {title: 'jl',order: 189,view: 'textarea', type: 'string',},
  pzwhyw: {title: 'pzwhyw',order: 190,view: 'textarea', type: 'string',},
  dqjczqyw: {title: 'dqjczqyw',order: 191,view: 'textarea', type: 'string',},
  wzcxm: {title: 'wzcxm',order: 192,view: 'text', type: 'string',},
  ipdz: {title: 'ipdz',order: 193,view: 'text', type: 'string',},
  hlwbah: {title: 'hlwbah',order: 194,view: 'text', type: 'string',},
  slsjn: {title: 'slsjn',order: 195,view: 'text', type: 'string',},
  slsjy: {title: 'slsjy',order: 196,view: 'text', type: 'string',},
  slsjr: {title: 'slsjr',order: 197,view: 'text', type: 'string',},
  cpphyw: {title: 'cpphyw',order: 198,view: 'textarea', type: 'string',},
  cpmc2: {title: 'cpmc2',order: 199,view: 'text', type: 'string',},
  cpmc3: {title: 'cpmc3',order: 200,view: 'text', type: 'string',},
  cpmc4: {title: 'cpmc4',order: 201,view: 'text', type: 'string',},
  guige2: {title: 'guige2',order: 202,view: 'text', type: 'string',},
  bzgg2: {title: 'bzgg2',order: 203,view: 'textarea', type: 'string',},
  bzgg3: {title: 'bzgg3',order: 204,view: 'textarea', type: 'string',},
  bzgg4: {title: 'bzgg4',order: 205,view: 'textarea', type: 'string',},
  xh1: {title: 'xh1',order: 206,view: 'text', type: 'string',},
  xh2: {title: 'xh2',order: 207,view: 'text', type: 'string',},
  xh3: {title: 'xh3',order: 208,view: 'text', type: 'string',},
  xh4: {title: 'xh4',order: 209,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}