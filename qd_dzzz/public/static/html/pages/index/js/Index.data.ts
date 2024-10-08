import { FormSchema } from '/@/components/Table';


//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '选择企业信息',
    field: 'qyid',
    show: false,
    component: 'JPopup',
    colProps: { span: 24 },
    componentProps: ({ formActionType }) => {
      const { setFieldsValue } = formActionType;
      return {
        setFieldsValue: setFieldsValue,
        code: 'company',
        fieldConfig: [
          { source: 'uscc', target: 'shxydm' },
          { source: 'company_name', target: 'qymc' },
        ],
        multi: false,
      };
    },
  },
];
[
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
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '有效期起',
    field: 'fzrqStart',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '有效期止',
    field: 'fzrqEnd',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
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
    field: 'CS',
    component: 'Input',
  },
  {
    label: '产品',
    field: 'CP',
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
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '数据同步公示平台时间',
    field: 'sjtbGsptTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '数据同步档案系统时间',
    field: 'sjtbDaTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '数据同步行政审批',
    field: 'sjtbXzspTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
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
    show: false,
  },
];
