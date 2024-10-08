import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业id',
    align:"center",
    dataIndex: 'qyid'
   },
   {
    title: '证书类型',
    align:"center",
    dataIndex: 'zslx'
   },
   {
    title: '证书编号',
    align:"center",
    dataIndex: 'zsbh'
   },
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'qymc'
   },
   {
    title: '社会信用代码',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: '注册地址',
    align:"center",
    dataIndex: 'zcdz'
   },
   {
    title: '法定代表人',
    align:"center",
    dataIndex: 'fddbr'
   },
   {
    title: '企业负责人',
    align:"center",
    dataIndex: 'qyfzr'
   },
   {
    title: '质量负责人',
    align:"center",
    dataIndex: 'zlfzr'
   },
   {
    title: '分类码',
    align:"center",
    dataIndex: 'flm'
   },
   {
    title: '日常监督管理机构',
    align:"center",
    dataIndex: 'rcjdgljg'
   },
   {
    title: '日常监督管理人员',
    align:"center",
    dataIndex: 'rcjdglry'
   },
   {
    title: '生产地址范围',
    align:"center",
    dataIndex: 'scdzhfw'
   },
   {
    title: '发证机关',
    align:"center",
    dataIndex: 'fzjg'
   },
   {
    title: '签发人',
    align:"center",
    dataIndex: 'qfr'
   },
   {
    title: '发证日期',
    align:"center",
    dataIndex: 'fzrq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '有效期起',
    align:"center",
    dataIndex: 'yxqq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '有效期至',
    align:"center",
    dataIndex: 'yxqz',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '生产地址',
    align:"center",
    dataIndex: 'scdz'
   },
   {
    title: '受理号',
    align:"center",
    dataIndex: 'slh'
   },
   {
    title: '仓库地址',
    align:"center",
    dataIndex: 'ckdz'
   },
   {
    title: 'your_comment_here',
    align:"center",
    dataIndex: 'jgjzc'
   },
   {
    title: '范围',
    align:"center",
    dataIndex: 'fw'
   },
   {
    title: '范围副本',
    align:"center",
    dataIndex: 'fwyw'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: '主送',
    align:"center",
    dataIndex: 'zs'
   },
   {
    title: '抄送',
    align:"center",
    dataIndex: 'chaosong'
   },
   {
    title: '产品',
    align:"center",
    dataIndex: 'chanping'
   },
   {
    title: '产品类别',
    align:"center",
    dataIndex: 'cplb'
   },
   {
    title: '产品明细',
    align:"center",
    dataIndex: 'cpmx'
   },
   {
    title: '电话',
    align:"center",
    dataIndex: 'dh'
   },
   {
    title: '传真',
    align:"center",
    dataIndex: 'cz'
   },
   {
    title: '规格',
    align:"center",
    dataIndex: 'guige'
   },
   {
    title: '剂型',
    align:"center",
    dataIndex: 'jx'
   },
   {
    title: '附件',
    align:"center",
    dataIndex: 'fj'
   },
   {
    title: '网站域名',
    align:"center",
    dataIndex: 'wzym'
   },
   {
    title: '接受来源',
    align:"center",
    dataIndex: 'jsly'
   },
   {
    title: '盖章生成状态 0同步 2未生成3生成未盖章 4盖章',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: '业务类别',
    align:"center",
    dataIndex: 'ywlb'
   },
   {
    title: '版本id',
    align:"center",
    dataIndex: 'bbid'
   },
   {
    title: 'FZJGID',
    align:"center",
    dataIndex: 'mbid'
   },
   {
    title: 'ylzd1',
    align:"center",
    dataIndex: 'ylzd1'
   },
   {
    title: 'ylzd2',
    align:"center",
    dataIndex: 'ylzd2'
   },
   {
    title: 'ylzd3',
    align:"center",
    dataIndex: 'ylzd3'
   },
   {
    title: 'ylzd4',
    align:"center",
    dataIndex: 'ylzd4'
   },
   {
    title: 'ylzd5',
    align:"center",
    dataIndex: 'ylzd5'
   },
   {
    title: '发证机关id',
    align:"center",
    dataIndex: 'fzjgid'
   },
   {
    title: '公示平台',
    align:"center",
    dataIndex: 'sjtbGspt'
   },
   {
    title: '档案系统',
    align:"center",
    dataIndex: 'sjtbDa'
   },
   {
    title: '1表示是行政审批推送来的数据',
    align:"center",
    dataIndex: 'sjtbXzsp'
   },
   {
    title: '国家局数据同步',
    align:"center",
    dataIndex: 'sjtbGj'
   },
   {
    title: 'sjtbCwxx',
    align:"center",
    dataIndex: 'sjtbCwxx'
   },
   {
    title: 'sjtbGjsj',
    align:"center",
    dataIndex: 'sjtbGjsj'
   },
   {
    title: 'ylzd6',
    align:"center",
    dataIndex: 'ylzd6'
   },
   {
    title: 'ylzd7',
    align:"center",
    dataIndex: 'ylzd7'
   },
   {
    title: 'ylzd8',
    align:"center",
    dataIndex: 'ylzd8'
   },
   {
    title: 'ylzd9',
    align:"center",
    dataIndex: 'ylzd9'
   },
   {
    title: 'ylzd10',
    align:"center",
    dataIndex: 'ylzd10'
   },
   {
    title: 'ylzd11',
    align:"center",
    dataIndex: 'ylzd11'
   },
   {
    title: 'ylzd12',
    align:"center",
    dataIndex: 'ylzd12'
   },
   {
    title: 'ylzd13',
    align:"center",
    dataIndex: 'ylzd13'
   },
   {
    title: 'ylzd14',
    align:"center",
    dataIndex: 'ylzd14'
   },
   {
    title: 'ylzd15',
    align:"center",
    dataIndex: 'ylzd15'
   },
   {
    title: 'ylzd16',
    align:"center",
    dataIndex: 'ylzd16'
   },
   {
    title: 'ylzd17',
    align:"center",
    dataIndex: 'ylzd17'
   },
   {
    title: 'ylzd18',
    align:"center",
    dataIndex: 'ylzd18'
   },
   {
    title: 'ylzd19',
    align:"center",
    dataIndex: 'ylzd19'
   },
   {
    title: 'ylzd20',
    align:"center",
    dataIndex: 'ylzd20'
   },
   {
    title: 'ylzd21',
    align:"center",
    dataIndex: 'ylzd21'
   },
   {
    title: 'ylzd22',
    align:"center",
    dataIndex: 'ylzd22'
   },
   {
    title: 'ylzd23',
    align:"center",
    dataIndex: 'ylzd23'
   },
   {
    title: 'ylzd24',
    align:"center",
    dataIndex: 'ylzd24'
   },
   {
    title: 'ylzd25',
    align:"center",
    dataIndex: 'ylzd25'
   },
   {
    title: 'ylzd26',
    align:"center",
    dataIndex: 'ylzd26'
   },
   {
    title: 'ylzd27',
    align:"center",
    dataIndex: 'ylzd27'
   },
   {
    title: 'ylzd28',
    align:"center",
    dataIndex: 'ylzd28'
   },
   {
    title: 'ylzd29',
    align:"center",
    dataIndex: 'ylzd29'
   },
   {
    title: 'ylzd30',
    align:"center",
    dataIndex: 'ylzd30'
   },
   {
    title: 'ylzd31',
    align:"center",
    dataIndex: 'ylzd31'
   },
   {
    title: 'ylzd32',
    align:"center",
    dataIndex: 'ylzd32'
   },
   {
    title: 'ylzd33',
    align:"center",
    dataIndex: 'ylzd33'
   },
   {
    title: 'ylzd34',
    align:"center",
    dataIndex: 'ylzd34'
   },
   {
    title: 'ylzd35',
    align:"center",
    dataIndex: 'ylzd35'
   },
   {
    title: 'ylzd36',
    align:"center",
    dataIndex: 'ylzd36'
   },
   {
    title: 'ylzd37',
    align:"center",
    dataIndex: 'ylzd37'
   },
   {
    title: 'ylzd38',
    align:"center",
    dataIndex: 'ylzd38'
   },
   {
    title: 'ylzd39',
    align:"center",
    dataIndex: 'ylzd39'
   },
   {
    title: 'ylzd40',
    align:"center",
    dataIndex: 'ylzd40'
   },
   {
    title: '二维码路径',
    align:"center",
    dataIndex: 'ewmlj'
   },
   {
    title: '同步',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: '模板id',
    align:"center",
    dataIndex: 'glzdb'
   },
   {
    title: '企业类型',
    align:"center",
    dataIndex: 'qylx'
   },
   {
    title: '联系人邮箱',
    align:"center",
    dataIndex: 'lxryx'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'lxdh'
   },
   {
    title: '类型级别',
    align:"center",
    dataIndex: 'typelevel'
   },
   {
    title: '移动电话',
    align:"center",
    dataIndex: 'mobile'
   },
   {
    title: '证照类型Id',
    align:"center",
    dataIndex: 'certtypeid'
   },
   {
    title: '有效状态10核发20变更30换证60证书纠错70数据维护',
    align:"center",
    dataIndex: 'zszt'
   },
   {
    title: '证书状态10有效50注销60过期70吊销80撤销99作废',
    align:"center",
    dataIndex: 'yxzt'
   },
   {
    title: '二维码',
    align:"center",
    dataIndex: 'ewm'
   },
   {
    title: 'synctime',
    align:"center",
    dataIndex: 'synctime',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'zsdl',
    align:"center",
    dataIndex: 'zsdl'
   },
   {
    title: 'oldId',
    align:"center",
    dataIndex: 'oldId'
   },
   {
    title: 'isxt',
    align:"center",
    dataIndex: 'isxt'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业id',
    field: 'qyid',
    component: 'Input',
  },
  {
    label: '证书类型',
    field: 'zslx',
    component: 'Input',
  },
  {
    label: '证书编号',
    field: 'zsbh',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'qymc',
    component: 'Input',
  },
  {
    label: '社会信用代码',
    field: 'shxydm',
    component: 'Input',
  },
  {
    label: '注册地址',
    field: 'zcdz',
    component: 'Input',
  },
  {
    label: '法定代表人',
    field: 'fddbr',
    component: 'Input',
  },
  {
    label: '企业负责人',
    field: 'qyfzr',
    component: 'Input',
  },
  {
    label: '质量负责人',
    field: 'zlfzr',
    component: 'Input',
  },
  {
    label: '分类码',
    field: 'flm',
    component: 'Input',
  },
  {
    label: '日常监督管理机构',
    field: 'rcjdgljg',
    component: 'Input',
  },
  {
    label: '日常监督管理人员',
    field: 'rcjdglry',
    component: 'Input',
  },
  {
    label: '生产地址范围',
    field: 'scdzhfw',
    component: 'Input',
  },
  {
    label: '发证机关',
    field: 'fzjg',
    component: 'Input',
  },
  {
    label: '签发人',
    field: 'qfr',
    component: 'Input',
  },
  {
    label: '发证日期',
    field: 'fzrq',
    component: 'DatePicker',
  },
  {
    label: '有效期起',
    field: 'yxqq',
    component: 'DatePicker',
  },
  {
    label: '有效期至',
    field: 'yxqz',
    component: 'DatePicker',
  },
  {
    label: '生产地址',
    field: 'scdz',
    component: 'InputTextArea',
  },
  {
    label: '受理号',
    field: 'slh',
    component: 'Input',
  },
  {
    label: '仓库地址',
    field: 'ckdz',
    component: 'InputTextArea',
  },
  {
    label: 'your_comment_here',
    field: 'jgjzc',
    component: 'InputTextArea',
  },
  {
    label: '范围',
    field: 'fw',
    component: 'InputTextArea',
  },
  {
    label: '范围副本',
    field: 'fwyw',
    component: 'InputTextArea',
  },
  {
    label: '备注',
    field: 'bz',
    component: 'InputTextArea',
  },
  {
    label: '主送',
    field: 'zs',
    component: 'Input',
  },
  {
    label: '抄送',
    field: 'chaosong',
    component: 'Input',
  },
  {
    label: '产品',
    field: 'chanping',
    component: 'Input',
  },
  {
    label: '产品类别',
    field: 'cplb',
    component: 'InputTextArea',
  },
  {
    label: '产品明细',
    field: 'cpmx',
    component: 'Input',
  },
  {
    label: '电话',
    field: 'dh',
    component: 'Input',
  },
  {
    label: '传真',
    field: 'cz',
    component: 'Input',
  },
  {
    label: '规格',
    field: 'guige',
    component: 'InputTextArea',
  },
  {
    label: '剂型',
    field: 'jx',
    component: 'Input',
  },
  {
    label: '附件',
    field: 'fj',
    component: 'InputTextArea',
  },
  {
    label: '网站域名',
    field: 'wzym',
    component: 'Input',
  },
  {
    label: '接受来源',
    field: 'jsly',
    component: 'Input',
  },
  {
    label: '盖章生成状态 0同步 2未生成3生成未盖章 4盖章',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '业务类别',
    field: 'ywlb',
    component: 'Input',
  },
  {
    label: '版本id',
    field: 'bbid',
    component: 'Input',
  },
  {
    label: 'FZJGID',
    field: 'mbid',
    component: 'Input',
  },
  {
    label: 'ylzd1',
    field: 'ylzd1',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd2',
    field: 'ylzd2',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd3',
    field: 'ylzd3',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd4',
    field: 'ylzd4',
    component: 'Input',
  },
  {
    label: 'ylzd5',
    field: 'ylzd5',
    component: 'Input',
  },
  {
    label: '发证机关id',
    field: 'fzjgid',
    component: 'Input',
  },
  {
    label: '公示平台',
    field: 'sjtbGspt',
    component: 'Input',
  },
  {
    label: '档案系统',
    field: 'sjtbDa',
    component: 'Input',
  },
  {
    label: '1表示是行政审批推送来的数据',
    field: 'sjtbXzsp',
    component: 'Input',
  },
  {
    label: '国家局数据同步',
    field: 'sjtbGj',
    component: 'Input',
  },
  {
    label: 'sjtbCwxx',
    field: 'sjtbCwxx',
    component: 'Input',
  },
  {
    label: 'sjtbGjsj',
    field: 'sjtbGjsj',
    component: 'Input',
  },
  {
    label: 'ylzd6',
    field: 'ylzd6',
    component: 'Input',
  },
  {
    label: 'ylzd7',
    field: 'ylzd7',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd8',
    field: 'ylzd8',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd9',
    field: 'ylzd9',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd10',
    field: 'ylzd10',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd11',
    field: 'ylzd11',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd12',
    field: 'ylzd12',
    component: 'Input',
  },
  {
    label: 'ylzd13',
    field: 'ylzd13',
    component: 'Input',
  },
  {
    label: 'ylzd14',
    field: 'ylzd14',
    component: 'Input',
  },
  {
    label: 'ylzd15',
    field: 'ylzd15',
    component: 'Input',
  },
  {
    label: 'ylzd16',
    field: 'ylzd16',
    component: 'Input',
  },
  {
    label: 'ylzd17',
    field: 'ylzd17',
    component: 'Input',
  },
  {
    label: 'ylzd18',
    field: 'ylzd18',
    component: 'Input',
  },
  {
    label: 'ylzd19',
    field: 'ylzd19',
    component: 'Input',
  },
  {
    label: 'ylzd20',
    field: 'ylzd20',
    component: 'Input',
  },
  {
    label: 'ylzd21',
    field: 'ylzd21',
    component: 'Input',
  },
  {
    label: 'ylzd22',
    field: 'ylzd22',
    component: 'Input',
  },
  {
    label: 'ylzd23',
    field: 'ylzd23',
    component: 'Input',
  },
  {
    label: 'ylzd24',
    field: 'ylzd24',
    component: 'Input',
  },
  {
    label: 'ylzd25',
    field: 'ylzd25',
    component: 'Input',
  },
  {
    label: 'ylzd26',
    field: 'ylzd26',
    component: 'Input',
  },
  {
    label: 'ylzd27',
    field: 'ylzd27',
    component: 'Input',
  },
  {
    label: 'ylzd28',
    field: 'ylzd28',
    component: 'Input',
  },
  {
    label: 'ylzd29',
    field: 'ylzd29',
    component: 'Input',
  },
  {
    label: 'ylzd30',
    field: 'ylzd30',
    component: 'Input',
  },
  {
    label: 'ylzd31',
    field: 'ylzd31',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd32',
    field: 'ylzd32',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd33',
    field: 'ylzd33',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd34',
    field: 'ylzd34',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd35',
    field: 'ylzd35',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd36',
    field: 'ylzd36',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd37',
    field: 'ylzd37',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd38',
    field: 'ylzd38',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd39',
    field: 'ylzd39',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd40',
    field: 'ylzd40',
    component: 'InputTextArea',
  },
  {
    label: '二维码路径',
    field: 'ewmlj',
    component: 'Input',
  },
  {
    label: '同步',
    field: 'sync',
    component: 'Input',
  },
  {
    label: '模板id',
    field: 'glzdb',
    component: 'Input',
  },
  {
    label: '企业类型',
    field: 'qylx',
    component: 'Input',
  },
  {
    label: '联系人邮箱',
    field: 'lxryx',
    component: 'Input',
  },
  {
    label: '联系电话',
    field: 'lxdh',
    component: 'Input',
  },
  {
    label: '类型级别',
    field: 'typelevel',
    component: 'Input',
  },
  {
    label: '移动电话',
    field: 'mobile',
    component: 'Input',
  },
  {
    label: '证照类型Id',
    field: 'certtypeid',
    component: 'Input',
  },
  {
    label: '有效状态10核发20变更30换证60证书纠错70数据维护',
    field: 'zszt',
    component: 'Input',
  },
  {
    label: '证书状态10有效50注销60过期70吊销80撤销99作废',
    field: 'yxzt',
    component: 'Input',
  },
  {
    label: '二维码',
    field: 'ewm',
    component: 'Input',
  },
  {
    label: 'synctime',
    field: 'synctime',
    component: 'DatePicker',
  },
  {
    label: 'zsdl',
    field: 'zsdl',
    component: 'Input',
  },
  {
    label: 'oldId',
    field: 'oldId',
    component: 'Input',
  },
  {
    label: 'isxt',
    field: 'isxt',
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
  qyid: {title: '企业id',order: 0,view: 'text', type: 'string',},
  zslx: {title: '证书类型',order: 1,view: 'text', type: 'string',},
  zsbh: {title: '证书编号',order: 2,view: 'text', type: 'string',},
  qymc: {title: '企业名称',order: 3,view: 'text', type: 'string',},
  shxydm: {title: '社会信用代码',order: 4,view: 'text', type: 'string',},
  zcdz: {title: '注册地址',order: 5,view: 'text', type: 'string',},
  fddbr: {title: '法定代表人',order: 6,view: 'text', type: 'string',},
  qyfzr: {title: '企业负责人',order: 7,view: 'text', type: 'string',},
  zlfzr: {title: '质量负责人',order: 8,view: 'text', type: 'string',},
  flm: {title: '分类码',order: 9,view: 'text', type: 'string',},
  rcjdgljg: {title: '日常监督管理机构',order: 10,view: 'text', type: 'string',},
  rcjdglry: {title: '日常监督管理人员',order: 11,view: 'text', type: 'string',},
  scdzhfw: {title: '生产地址范围',order: 12,view: 'text', type: 'string',},
  fzjg: {title: '发证机关',order: 13,view: 'text', type: 'string',},
  qfr: {title: '签发人',order: 14,view: 'text', type: 'string',},
  fzrq: {title: '发证日期',order: 15,view: 'date', type: 'string',},
  yxqq: {title: '有效期起',order: 16,view: 'date', type: 'string',},
  yxqz: {title: '有效期至',order: 17,view: 'date', type: 'string',},
  scdz: {title: '生产地址',order: 18,view: 'textarea', type: 'string',},
  slh: {title: '受理号',order: 19,view: 'text', type: 'string',},
  ckdz: {title: '仓库地址',order: 20,view: 'textarea', type: 'string',},
  jgjzc: {title: 'your_comment_here',order: 21,view: 'textarea', type: 'string',},
  fw: {title: '范围',order: 22,view: 'textarea', type: 'string',},
  fwyw: {title: '范围副本',order: 23,view: 'textarea', type: 'string',},
  bz: {title: '备注',order: 24,view: 'textarea', type: 'string',},
  zs: {title: '主送',order: 25,view: 'text', type: 'string',},
  chaosong: {title: '抄送',order: 26,view: 'text', type: 'string',},
  chanping: {title: '产品',order: 27,view: 'text', type: 'string',},
  cplb: {title: '产品类别',order: 28,view: 'textarea', type: 'string',},
  cpmx: {title: '产品明细',order: 29,view: 'text', type: 'string',},
  dh: {title: '电话',order: 30,view: 'text', type: 'string',},
  cz: {title: '传真',order: 31,view: 'text', type: 'string',},
  guige: {title: '规格',order: 32,view: 'textarea', type: 'string',},
  jx: {title: '剂型',order: 33,view: 'text', type: 'string',},
  fj: {title: '附件',order: 34,view: 'textarea', type: 'string',},
  wzym: {title: '网站域名',order: 35,view: 'text', type: 'string',},
  jsly: {title: '接受来源',order: 36,view: 'text', type: 'string',},
  zt: {title: '盖章生成状态 0同步 2未生成3生成未盖章 4盖章',order: 37,view: 'text', type: 'string',},
  ywlb: {title: '业务类别',order: 38,view: 'text', type: 'string',},
  bbid: {title: '版本id',order: 39,view: 'text', type: 'string',},
  mbid: {title: 'FZJGID',order: 40,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 41,view: 'textarea', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 42,view: 'textarea', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 43,view: 'textarea', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 44,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 45,view: 'text', type: 'string',},
  fzjgid: {title: '发证机关id',order: 46,view: 'text', type: 'string',},
  sjtbGspt: {title: '公示平台',order: 47,view: 'text', type: 'string',},
  sjtbDa: {title: '档案系统',order: 48,view: 'text', type: 'string',},
  sjtbXzsp: {title: '1表示是行政审批推送来的数据',order: 49,view: 'text', type: 'string',},
  sjtbGj: {title: '国家局数据同步',order: 50,view: 'text', type: 'string',},
  sjtbCwxx: {title: 'sjtbCwxx',order: 51,view: 'text', type: 'string',},
  sjtbGjsj: {title: 'sjtbGjsj',order: 52,view: 'text', type: 'string',},
  ylzd6: {title: 'ylzd6',order: 53,view: 'text', type: 'string',},
  ylzd7: {title: 'ylzd7',order: 54,view: 'textarea', type: 'string',},
  ylzd8: {title: 'ylzd8',order: 55,view: 'textarea', type: 'string',},
  ylzd9: {title: 'ylzd9',order: 56,view: 'textarea', type: 'string',},
  ylzd10: {title: 'ylzd10',order: 57,view: 'textarea', type: 'string',},
  ylzd11: {title: 'ylzd11',order: 58,view: 'textarea', type: 'string',},
  ylzd12: {title: 'ylzd12',order: 59,view: 'text', type: 'string',},
  ylzd13: {title: 'ylzd13',order: 60,view: 'text', type: 'string',},
  ylzd14: {title: 'ylzd14',order: 61,view: 'text', type: 'string',},
  ylzd15: {title: 'ylzd15',order: 62,view: 'text', type: 'string',},
  ylzd16: {title: 'ylzd16',order: 63,view: 'text', type: 'string',},
  ylzd17: {title: 'ylzd17',order: 64,view: 'text', type: 'string',},
  ylzd18: {title: 'ylzd18',order: 65,view: 'text', type: 'string',},
  ylzd19: {title: 'ylzd19',order: 66,view: 'text', type: 'string',},
  ylzd20: {title: 'ylzd20',order: 67,view: 'text', type: 'string',},
  ylzd21: {title: 'ylzd21',order: 68,view: 'text', type: 'string',},
  ylzd22: {title: 'ylzd22',order: 69,view: 'text', type: 'string',},
  ylzd23: {title: 'ylzd23',order: 70,view: 'text', type: 'string',},
  ylzd24: {title: 'ylzd24',order: 71,view: 'text', type: 'string',},
  ylzd25: {title: 'ylzd25',order: 72,view: 'text', type: 'string',},
  ylzd26: {title: 'ylzd26',order: 73,view: 'text', type: 'string',},
  ylzd27: {title: 'ylzd27',order: 74,view: 'text', type: 'string',},
  ylzd28: {title: 'ylzd28',order: 75,view: 'text', type: 'string',},
  ylzd29: {title: 'ylzd29',order: 76,view: 'text', type: 'string',},
  ylzd30: {title: 'ylzd30',order: 77,view: 'text', type: 'string',},
  ylzd31: {title: 'ylzd31',order: 78,view: 'textarea', type: 'string',},
  ylzd32: {title: 'ylzd32',order: 79,view: 'textarea', type: 'string',},
  ylzd33: {title: 'ylzd33',order: 80,view: 'textarea', type: 'string',},
  ylzd34: {title: 'ylzd34',order: 81,view: 'textarea', type: 'string',},
  ylzd35: {title: 'ylzd35',order: 82,view: 'textarea', type: 'string',},
  ylzd36: {title: 'ylzd36',order: 83,view: 'textarea', type: 'string',},
  ylzd37: {title: 'ylzd37',order: 84,view: 'textarea', type: 'string',},
  ylzd38: {title: 'ylzd38',order: 85,view: 'textarea', type: 'string',},
  ylzd39: {title: 'ylzd39',order: 86,view: 'textarea', type: 'string',},
  ylzd40: {title: 'ylzd40',order: 87,view: 'textarea', type: 'string',},
  ewmlj: {title: '二维码路径',order: 88,view: 'text', type: 'string',},
  sync: {title: '同步',order: 89,view: 'text', type: 'string',},
  glzdb: {title: '模板id',order: 90,view: 'text', type: 'string',},
  qylx: {title: '企业类型',order: 91,view: 'text', type: 'string',},
  lxryx: {title: '联系人邮箱',order: 92,view: 'text', type: 'string',},
  lxdh: {title: '联系电话',order: 93,view: 'text', type: 'string',},
  typelevel: {title: '类型级别',order: 94,view: 'text', type: 'string',},
  mobile: {title: '移动电话',order: 95,view: 'text', type: 'string',},
  certtypeid: {title: '证照类型Id',order: 96,view: 'text', type: 'string',},
  zszt: {title: '有效状态10核发20变更30换证60证书纠错70数据维护',order: 97,view: 'text', type: 'string',},
  yxzt: {title: '证书状态10有效50注销60过期70吊销80撤销99作废',order: 98,view: 'text', type: 'string',},
  ewm: {title: '二维码',order: 99,view: 'text', type: 'string',},
  synctime: {title: 'synctime',order: 100,view: 'date', type: 'string',},
  zsdl: {title: 'zsdl',order: 101,view: 'text', type: 'string',},
  oldId: {title: 'oldId',order: 102,view: 'text', type: 'string',},
  isxt: {title: 'isxt',order: 103,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}