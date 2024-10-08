import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业编码',
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
    title: '社会统一信用代码',
    align:"center",
    dataIndex: 'uscc'
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
    title: '日常监管机构',
    align:"center",
    dataIndex: 'rcjgjg'
   },
   {
    title: '日常监管人员',
    align:"center",
    dataIndex: 'rcjgry'
   },
   {
    title: '生产地址和生产范围',
    align:"center",
    dataIndex: 'scdzhszfw'
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
    dataIndex: 'fzrq'
   },
   {
    title: '有效期起',
    align:"center",
    dataIndex: 'fzrqStart'
   },
   {
    title: '有效期止',
    align:"center",
    dataIndex: 'fzrqEnd'
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
    title: '结构以及组成',
    align:"center",
    dataIndex: 'jgyjzc'
   },
   {
    title: '范围',
    align:"center",
    dataIndex: 'fw'
   },
   {
    title: '范围英文',
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
    dataIndex: 'cc'
   },
   {
    title: '产品',
    align:"center",
    dataIndex: 'product'
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
    title: '传真',
    align:"center",
    dataIndex: 'cz'
   },
   {
    title: '电话',
    align:"center",
    dataIndex: 'dh'
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
    dataIndex: 'wzyy'
   },
   {
    title: '接受来源',
    align:"center",
    dataIndex: 'jsly'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: '业务类型',
    align:"center",
    dataIndex: 'ywlx'
   },
   {
    title: '版本id',
    align:"center",
    dataIndex: 'bbid'
   },
   {
    title: '模块id',
    align:"center",
    dataIndex: 'mkid'
   },
   {
    title: '数据同步公示平台',
    align:"center",
    dataIndex: 'sjtbGspt'
   },
   {
    title: '数据同步档案系统',
    align:"center",
    dataIndex: 'sjtbDa'
   },
   {
    title: '数据同步行政审批',
    align:"center",
    dataIndex: 'sjtbXzsp'
   },
   {
    title: '数据同步国家局',
    align:"center",
    dataIndex: 'sjtbGjj'
   },
   {
    title: '数据同步错误信息',
    align:"center",
    dataIndex: 'sjtbError'
   },
   {
    title: '数据同步国家局时间',
    align:"center",
    dataIndex: 'sjtbGjjTime'
   },
   {
    title: '数据同步公示平台时间',
    align:"center",
    dataIndex: 'sjtbGsptTime'
   },
   {
    title: '数据同步档案系统时间',
    align:"center",
    dataIndex: 'sjtbDaTime'
   },
   {
    title: '数据同步行政审批',
    align:"center",
    dataIndex: 'sjtbXzspTime'
   },
   {
    title: '二维码',
    align:"center",
    dataIndex: 'ewm'
   },
   {
    title: '二维码路径',
    align:"center",
    dataIndex: 'ewmLj'
   },
   {
    title: '管理者代表',
    align:"center",
    dataIndex: 'glzdb'
   },
   {
    title: '联系人邮箱',
    align:"center",
    dataIndex: 'lxryx'
   },
   {
    title: '联系人电话',
    align:"center",
    dataIndex: 'lxdh'
   },
   {
    title: '企业类型',
    align:"center",
    dataIndex: 'qylx'
   },
   {
    title: '预留字段1',
    align:"center",
    dataIndex: 'ylzd1'
   },
   {
    title: '预留字段5',
    align:"center",
    dataIndex: 'ylzd5'
   },
   {
    title: '预留字段2',
    align:"center",
    dataIndex: 'ylzd2'
   },
   {
    title: '预留字段3',
    align:"center",
    dataIndex: 'ylzd3'
   },
   {
    title: '预留字段4',
    align:"center",
    dataIndex: 'ylzd4'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业编码',
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
    label: '社会统一信用代码',
    field: 'uscc',
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
    label: '日常监管机构',
    field: 'rcjgjg',
    component: 'Input',
  },
  {
    label: '日常监管人员',
    field: 'rcjgry',
    component: 'Input',
  },
  {
    label: '生产地址和生产范围',
    field: 'scdzhszfw',
    component: 'InputTextArea',
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
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '有效期起',
    field: 'fzrqStart',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '有效期止',
    field: 'fzrqEnd',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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
    label: '结构以及组成',
    field: 'jgyjzc',
    component: 'InputTextArea',
  },
  {
    label: '范围',
    field: 'fw',
    component: 'Input',
  },
  {
    label: '范围英文',
    field: 'fwyw',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'bz',
    component: 'Input',
  },
  {
    label: '主送',
    field: 'zs',
    component: 'Input',
  },
  {
    label: '抄送',
    field: 'cc',
    component: 'Input',
  },
  {
    label: '产品',
    field: 'product',
    component: 'Input',
  },
  {
    label: '产品类别',
    field: 'cplb',
    component: 'Input',
  },
  {
    label: '产品明细',
    field: 'cpmx',
    component: 'InputTextArea',
  },
  {
    label: '传真',
    field: 'cz',
    component: 'Input',
  },
  {
    label: '电话',
    field: 'dh',
    component: 'Input',
  },
  {
    label: '剂型',
    field: 'jx',
    component: 'Input',
  },
  {
    label: '附件',
    field: 'fj',
    component: 'Input',
  },
  {
    label: '网站域名',
    field: 'wzyy',
    component: 'Input',
  },
  {
    label: '接受来源',
    field: 'jsly',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '业务类型',
    field: 'ywlx',
    component: 'Input',
  },
  {
    label: '版本id',
    field: 'bbid',
    component: 'Input',
  },
  {
    label: '模块id',
    field: 'mkid',
    component: 'Input',
  },
  {
    label: '数据同步公示平台',
    field: 'sjtbGspt',
    component: 'Input',
  },
  {
    label: '数据同步档案系统',
    field: 'sjtbDa',
    component: 'Input',
  },
  {
    label: '数据同步行政审批',
    field: 'sjtbXzsp',
    component: 'Input',
  },
  {
    label: '数据同步国家局',
    field: 'sjtbGjj',
    component: 'Input',
  },
  {
    label: '数据同步错误信息',
    field: 'sjtbError',
    component: 'Input',
  },
  {
    label: '数据同步国家局时间',
    field: 'sjtbGjjTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '数据同步公示平台时间',
    field: 'sjtbGsptTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '数据同步档案系统时间',
    field: 'sjtbDaTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '数据同步行政审批',
    field: 'sjtbXzspTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '二维码',
    field: 'ewm',
    component: 'Input',
  },
  {
    label: '二维码路径',
    field: 'ewmLj',
    component: 'Input',
  },
  {
    label: '管理者代表',
    field: 'glzdb',
    component: 'Input',
  },
  {
    label: '联系人邮箱',
    field: 'lxryx',
    component: 'Input',
  },
  {
    label: '联系人电话',
    field: 'lxdh',
    component: 'Input',
  },
  {
    label: '企业类型',
    field: 'qylx',
    component: 'Input',
  },
  {
    label: '预留字段1',
    field: 'ylzd1',
    component: 'Input',
  },
  {
    label: '预留字段5',
    field: 'ylzd5',
    component: 'Input',
  },
  {
    label: '预留字段2',
    field: 'ylzd2',
    component: 'Input',
  },
  {
    label: '预留字段3',
    field: 'ylzd3',
    component: 'Input',
  },
  {
    label: '预留字段4',
    field: 'ylzd4',
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
//子表单数据
//子表表格配置
export const certchildYlqxwlxsbaColumns: JVxeColumn[] = [
    {
      title: 'zsid',
      key: 'zsid',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'shxydm',
      key: 'shxydm',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'dsfptbafptmc',
      key: 'dsfptbafptmc',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'pzbh',
      key: 'pzbh',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'bz',
      key: 'bz',
      type: JVxeTypes.textarea,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'sync',
      key: 'sync',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'xzspid',
      key: 'xzspid',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'num',
      key: 'num',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]
export const certchildDylylqxscbapzColumns: JVxeColumn[] = [
    {
      title: 'zsid',
      key: 'zsid',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'zczh',
      key: 'zczh',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'cplbDm',
      key: 'cplbDm',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'sfwtsc',
      key: 'sfwtsc',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'zcbarmc',
      key: 'zcbarmc',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'zcbardz',
      key: 'zcbardz',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'shxydm',
      key: 'shxydm',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'wtqx',
      key: 'wtqx',
      type: JVxeTypes.date,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'bz',
      key: 'bz',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'cpmc',
      key: 'cpmc',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'sync',
      key: 'sync',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'xzspid',
      key: 'xzspid',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'num',
      key: 'num',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: 'zt',
      key: 'zt',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]


// 高级查询数据
export const superQuerySchema = {
  qyid: {title: '企业编码',order: 0,view: 'text', type: 'string',},
  zslx: {title: '证书类型',order: 1,view: 'text', type: 'string',},
  zsbh: {title: '证书编号',order: 2,view: 'text', type: 'string',},
  uscc: {title: '社会统一信用代码',order: 3,view: 'text', type: 'string',},
  zcdz: {title: '注册地址',order: 4,view: 'text', type: 'string',},
  fddbr: {title: '法定代表人',order: 5,view: 'text', type: 'string',},
  qyfzr: {title: '企业负责人',order: 6,view: 'text', type: 'string',},
  zlfzr: {title: '质量负责人',order: 7,view: 'text', type: 'string',},
  flm: {title: '分类码',order: 8,view: 'text', type: 'string',},
  rcjgjg: {title: '日常监管机构',order: 9,view: 'text', type: 'string',},
  rcjgry: {title: '日常监管人员',order: 10,view: 'text', type: 'string',},
  scdzhszfw: {title: '生产地址和生产范围',order: 11,view: 'textarea', type: 'string',},
  fzjg: {title: '发证机关',order: 12,view: 'text', type: 'string',},
  qfr: {title: '签发人',order: 13,view: 'text', type: 'string',},
  fzrq: {title: '发证日期',order: 14,view: 'datetime', type: 'string',},
  fzrqStart: {title: '有效期起',order: 15,view: 'datetime', type: 'string',},
  fzrqEnd: {title: '有效期止',order: 16,view: 'datetime', type: 'string',},
  scdz: {title: '生产地址',order: 17,view: 'textarea', type: 'string',},
  slh: {title: '受理号',order: 18,view: 'text', type: 'string',},
  ckdz: {title: '仓库地址',order: 19,view: 'textarea', type: 'string',},
  jgyjzc: {title: '结构以及组成',order: 20,view: 'textarea', type: 'string',},
  fw: {title: '范围',order: 21,view: 'text', type: 'string',},
  fwyw: {title: '范围英文',order: 22,view: 'text', type: 'string',},
  bz: {title: '备注',order: 23,view: 'text', type: 'string',},
  zs: {title: '主送',order: 24,view: 'text', type: 'string',},
  cc: {title: '抄送',order: 25,view: 'text', type: 'string',},
  product: {title: '产品',order: 26,view: 'text', type: 'string',},
  cplb: {title: '产品类别',order: 27,view: 'text', type: 'string',},
  cpmx: {title: '产品明细',order: 28,view: 'textarea', type: 'string',},
  cz: {title: '传真',order: 29,view: 'text', type: 'string',},
  dh: {title: '电话',order: 30,view: 'text', type: 'string',},
  jx: {title: '剂型',order: 31,view: 'text', type: 'string',},
  fj: {title: '附件',order: 32,view: 'text', type: 'string',},
  wzyy: {title: '网站域名',order: 33,view: 'text', type: 'string',},
  jsly: {title: '接受来源',order: 34,view: 'text', type: 'string',},
  zt: {title: '状态',order: 35,view: 'text', type: 'string',},
  ywlx: {title: '业务类型',order: 36,view: 'text', type: 'string',},
  bbid: {title: '版本id',order: 37,view: 'text', type: 'string',},
  mkid: {title: '模块id',order: 38,view: 'text', type: 'string',},
  sjtbGspt: {title: '数据同步公示平台',order: 39,view: 'text', type: 'string',},
  sjtbDa: {title: '数据同步档案系统',order: 40,view: 'text', type: 'string',},
  sjtbXzsp: {title: '数据同步行政审批',order: 41,view: 'text', type: 'string',},
  sjtbGjj: {title: '数据同步国家局',order: 42,view: 'text', type: 'string',},
  sjtbError: {title: '数据同步错误信息',order: 43,view: 'text', type: 'string',},
  sjtbGjjTime: {title: '数据同步国家局时间',order: 44,view: 'datetime', type: 'string',},
  sjtbGsptTime: {title: '数据同步公示平台时间',order: 45,view: 'datetime', type: 'string',},
  sjtbDaTime: {title: '数据同步档案系统时间',order: 46,view: 'datetime', type: 'string',},
  sjtbXzspTime: {title: '数据同步行政审批',order: 47,view: 'datetime', type: 'string',},
  ewm: {title: '二维码',order: 48,view: 'text', type: 'string',},
  ewmLj: {title: '二维码路径',order: 49,view: 'text', type: 'string',},
  glzdb: {title: '管理者代表',order: 50,view: 'text', type: 'string',},
  lxryx: {title: '联系人邮箱',order: 51,view: 'text', type: 'string',},
  lxdh: {title: '联系人电话',order: 52,view: 'text', type: 'string',},
  qylx: {title: '企业类型',order: 53,view: 'text', type: 'string',},
  ylzd1: {title: '预留字段1',order: 54,view: 'text', type: 'string',},
  ylzd5: {title: '预留字段5',order: 55,view: 'text', type: 'string',},
  ylzd2: {title: '预留字段2',order: 56,view: 'text', type: 'string',},
  ylzd3: {title: '预留字段3',order: 57,view: 'text', type: 'string',},
  ylzd4: {title: '预留字段4',order: 58,view: 'text', type: 'string',},
  //子表高级查询
  certchildYlqxwlxsba: {
    title: 'certchild_ylqxwlxsba',
    view: 'table',
    fields: {
FreeMarker template error (DEBUG mode; use RETHROW in production!):
The following has evaluated to null or missing:
==> po  [in template "jvxe\\onetomany\\java\\${bussiPackage}\\${entityPackage}\\vue3\\${entityName}__data.tsi" at line 786, column 68]

----
Tip: If the failing expression is known to legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: #if subCol.isShowList == "Y" && subCo...  [in template "jvxe\\onetomany\\java\\${bussiPackage}\\${entityPackage}\\vue3\\${entityName}__data.tsi" at line 786, column 9]
----

Java stack trace (for programmers):
----
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:134)
	at freemarker.core.UnexpectedTypeException.newDescriptionBuilder(UnexpectedTypeException.java:85)
	at freemarker.core.UnexpectedTypeException.<init>(UnexpectedTypeException.java:48)
	at freemarker.core.NonHashException.<init>(NonHashException.java:49)
	at freemarker.core.Dot._eval(Dot.java:48)
	at freemarker.core.Expression.eval(Expression.java:101)
	at freemarker.core.EvalUtil.compare(EvalUtil.java:113)
	at freemarker.core.ComparisonExpression.evalToBoolean(ComparisonExpression.java:78)
	at freemarker.core.AndExpression.evalToBoolean(AndExpression.java:36)
	at freemarker.core.ConditionalBlock.accept(ConditionalBlock.java:48)
	at freemarker.core.Environment.visit(Environment.java:371)
	at freemarker.core.IteratorBlock$IterationContext.executedNestedContentForCollOrSeqListing(IteratorBlock.java:321)
	at freemarker.core.IteratorBlock$IterationContext.executeNestedContent(IteratorBlock.java:271)
	at freemarker.core.IteratorBlock$IterationContext.accept(IteratorBlock.java:244)
	at freemarker.core.Environment.visitIteratorBlock(Environment.java:645)
	at freemarker.core.IteratorBlock.acceptWithResult(IteratorBlock.java:108)
	at freemarker.core.IteratorBlock.accept(IteratorBlock.java:94)
	at freemarker.core.Environment.visit(Environment.java:371)
	at freemarker.core.IteratorBlock$IterationContext.executedNestedContentForCollOrSeqListing(IteratorBlock.java:321)
	at freemarker.core.IteratorBlock$IterationContext.executeNestedContent(IteratorBlock.java:271)
	at freemarker.core.IteratorBlock$IterationContext.accept(IteratorBlock.java:244)
	at freemarker.core.Environment.visitIteratorBlock(Environment.java:645)
	at freemarker.core.IteratorBlock.acceptWithResult(IteratorBlock.java:108)
	at freemarker.core.IteratorBlock.accept(IteratorBlock.java:94)
	at freemarker.core.Environment.visit(Environment.java:335)
	at freemarker.core.Environment.visit(Environment.java:341)
	at freemarker.core.Environment.process(Environment.java:314)
	at freemarker.template.Template.process(Template.java:383)
	at org.jeecgframework.codegenerate.generate.util.b.a(FreemarkerHelper.java:101)
	at org.jeecgframework.codegenerate.generate.impl.a.a.a(BaseCodeGenerate.java:130)
	at org.jeecgframework.codegenerate.generate.impl.a.a.a(BaseCodeGenerate.java:87)
	at org.jeecgframework.codegenerate.generate.impl.a.a.a(BaseCodeGenerate.java:62)
	at org.jeecgframework.codegenerate.generate.impl.a.a.a(BaseCodeGenerate.java:48)
	at org.jeecgframework.codegenerate.generate.impl.CodeGenerateOneToMany.generateCodeFile(CodeGenerateOneToMany.java:190)
	at org.jeecgframework.codegenerate.generate.impl.CodeGenerateOneToMany.generateCodeFile(CodeGenerateOneToMany.java:205)
	at org.jeecg.modules.online.cgform.service.a.d.generateOneToMany(OnlCgformHeadServiceImpl.java:1746)
	at org.jeecg.modules.online.cgform.service.a.d$$FastClassBySpringCGLIB$$1.invoke(<generated>)
	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
	at org.springframework.aop.framework.CglibAopProxy.invokeMethod(CglibAopProxy.java:386)
	at org.springframework.aop.framework.CglibAopProxy.access$000(CglibAopProxy.java:85)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:703)
	at org.jeecg.modules.online.cgform.service.a.d$$EnhancerBySpringCGLIB$$1.generateOneToMany(<generated>)
	at org.jeecg.modules.online.cgform.c.a.b(OnlCgformApiController.java:1182)
	at org.jeecg.modules.online.cgform.c.a$$FastClassBySpringCGLIB$$1.invoke(<generated>)
	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:792)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:762)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:762)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:707)
	at org.jeecg.modules.online.cgform.c.a$$EnhancerBySpringCGLIB$$1.b(<generated>)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:458)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:373)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:370)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:354)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:267)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter.doFilterInternal(HttpTraceFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:458)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:373)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:370)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:154)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:96)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:168)
	at org.apache.catalina.core.StandardContextValve.__invoke(StandardContextValve.java:90)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:41002)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:928)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1794)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:748)
