import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { JVxeTypes, JVxeColumn } from '/@/components/jeecg/JVxeTable/types';
import { getcertmetelist, getCerttypeNameAndValuef } from '@/views/dzzz/certinfo/CertInfo.api';
import { optionsListApi } from '@/api/demo/select';

const listdata: any[] = async function getcertmeta() {
  const certmetalist = await getcertmetelist({ id: '78d8f71b-b72d-43eb-b11d-af27eedcfc78' });
  console.log(certmetalist);
  const certdata: any[] = [];
  for (let i = 0; i < certmetalist.length; i++) {
    certdata[i] = {
      label: certmetalist[i].lm,
      field: certmetalist[i].yssx,
      component: certmetalist[i].zdlx,
    };
  }
  console.log(certdata);
  return certdata;
};
/*console.log(await listdata);*/
export const columnszswh: BasicColumn[] = [
  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'qymc',
  },
  /*{
    title: '证书类型',
    align: "center",
    dataIndex: 'zslx'
  },*/
  {
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '社会统一信用代码',
    align: 'center',
    dataIndex: 'shxydm',
  },
  /* {
    title: '盖章状态',
    align: "center",
    dataIndex: 'zt'
  },*/
];
//执业药师-列表数据
export const columnsZyys: BasicColumn[] = [
  {
    title: '注册证编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '姓名',
    align: 'center',
    dataIndex: 'ylzd1',
  },
  {
    title: '身份证号',
    align: 'center',
    dataIndex: 'shxydm',
  },
  {
    title: '执业地区',
    align: 'center',
    dataIndex: 'ylzd12',
  },
];
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'qymc',
  },
  /*{
    title: '证书类型',
    align: "center",
    dataIndex: 'zslx'
  },*/
  {
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '社会统一信用代码',
    align: 'center',
    dataIndex: 'shxydm',
  },
  {
    title: '注册地址',
    align: 'center',
    dataIndex: 'zcdz',
  },
  /* {
    title: '法定代表人',
    align: "center",
    dataIndex: 'fddbr'
  },
  {
    title: '企业负责人',
    align: "center",
    dataIndex: 'qyfzr'
  },
  {
    title: '质量负责人',
    align: "center",
    dataIndex: 'zlfzr'
  },*/
  // {
  //   title: '分类码',
  //   align: "center",
  //   dataIndex: 'flm'
  // },
  {
    title: '发证日期',
    align: 'center',
    dataIndex: 'fzrq',
    width: '105px',
  },

  /*{
    title: '日常监管机构',
    align: "center",
    dataIndex: 'rcjdgljg'
  },
  {
    title: '日常监管人员',
    align: "center",
    dataIndex: 'rcjdglry'
  },
  {
    title: '生产地址和生产范围',
    align: "center",
    dataIndex: 'scdzhfw'
  },
  {
    title: '发证机关',
    align: "center",
    dataIndex: 'fzjg'
  },
  {
    title: '签发人',
    align: "center",
    dataIndex: 'qfr'
  },

  {
    title: '有效期起',
    align: "center",
    dataIndex: 'yxqq'
  },
  {
    title: '有效期止',
    align: "center",
    dataIndex: 'yxqz'
  },
  {
    title: '生产地址',
    align: "center",
    dataIndex: 'scdz'
  },
  {
    title: '受理号',
    align: "center",
    dataIndex: 'slh'
  },
  {
    title: '仓库地址',
    align: "center",
    dataIndex: 'ckdz'
  },
  {
    title: '结构以及组成',
    align: "center",
    dataIndex: 'jgyjzc'
  },
  {
    title: '范围',
    align: "center",
    dataIndex: 'fw'
  },
  {
    title: '范围英文',
    align: "center",
    dataIndex: 'fwyw'
  },
  {
    title: '备注',
    align: "center",
    dataIndex: 'bz'
  },
  {
    title: '主送',
    align: "center",
    dataIndex: 'zs'
  },
  {
    title: '抄送',
    align: "center",
    dataIndex: 'chaosong'
  },
  {
    title: '产品',
    align: "center",
    dataIndex: 'chanpin'
  },
  {
    title: '产品类别',
    align: "center",
    dataIndex: 'cplb'
  },
  {
    title: '产品明细',
    align: "center",
    dataIndex: 'cpmx'
  },
  {
    title: '传真',
    align: "center",
    dataIndex: 'cz'
  },
  {
    title: '电话',
    align: "center",
    dataIndex: 'dh'
  },
  {
    title: '剂型',
    align: "center",
    dataIndex: 'jx'
  },
  {
    title: '附件',
    align: "center",
    dataIndex: 'fj'
  },
  {
    title: '网站域名',
    align: "center",
    dataIndex: 'wzym'
  },
  {
    title: '接受来源',
    align: "center",
    dataIndex: 'jsly'
  },
  {
    title: '状态',
    align: "center",
    dataIndex: 'zt'
  },
  {
    title: '业务类型',
    align: "center",
    dataIndex: 'ywlx'
  },
  {
    title: '版本id',
    align: "center",
    dataIndex: 'bbid'
  },
  {
    title: '模块id',
    align: "center",
    dataIndex: 'mbid'
  },
  {
    title: '数据同步公示平台',
    align: "center",
    dataIndex: 'sjtbGspt'
  },
  {
    title: '数据同步档案系统',
    align: "center",
    dataIndex: 'sjtbDa'
  },
  {
    title: '数据同步行政审批',
    align: "center",
    dataIndex: 'sjtbXzsp'
  },
  {
    title: '数据同步国家局',
    align: "center",
    dataIndex: 'sjtbGjj'
  },
  {
    title: '数据同步错误信息',
    align: "center",
    dataIndex: 'sjtbError'
  },
  {
    title: '数据同步国家局时间',
    align: "center",
    dataIndex: 'sjtbGjjTime'
  },
  {
    title: '数据同步公示平台时间',
    align: "center",
    dataIndex: 'sjtbGsptTime'
  },
  {
    title: '数据同步档案系统时间',
    align: "center",
    dataIndex: 'sjtbDaTime'
  },
  {
    title: '数据同步行政审批',
    align: "center",
    dataIndex: 'sjtbXzspTime'
  },
  {
    title: '二维码',
    align: "center",
    dataIndex: 'ewm'
  },
  {
    title: '二维码路径',
    align: "center",
    dataIndex: 'ewmLj'
  },
  {
    title: '管理者代表',
    align: "center",
    dataIndex: 'glzdb'
  },
  {
    title: '联系人邮箱',
    align: "center",
    dataIndex: 'lxryx'
  },
  {
    title: '联系人电话',
    align: "center",
    dataIndex: 'lxdh'
  },
  {
    title: '企业类型',
    align: "center",
    dataIndex: 'qylx'
  },
  {
    title: '预留字段1',
    align: "center",
    dataIndex: 'ylzd1'
  },
  {
    title: '预留字段5',
    align: "center",
    dataIndex: 'ylzd5'
  },
  {
    title: '预留字段2',
    align: "center",
    dataIndex: 'ylzd2'
  },
  {
    title: '预留字段3',
    align: "center",
    dataIndex: 'ylzd3'
  },
  {
    title: '预留字段4',
    align: "center",
    dataIndex: 'ylzd4'
  },*/
];

// 证书查询-列表数据
export const columnsZscx: BasicColumn[] = [
  {
    title: '证书类型',
    align: 'center',
    dataIndex: 'zslxName',
  },
  {
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'qymc',
  },
  {
    title: '社会统一信用代码',
    align: 'center',
    dataIndex: 'shxydm',
  },
  {
    title: '注册地址',
    align: 'center',
    dataIndex: 'zcdz',
  },
  {
    title: '发证日期',
    align: 'center',
    dataIndex: 'fzrq',
    width: '102px',
  },
  {
    title: '有效期止',
    align: 'center',
    dataIndex: 'yxqz',
    width: '102px',
  },
  {
    title: '状态',
    align: 'center',
    dataIndex: 'yxztName',
    width: '60px',
  },
];

// 执行药师-查询数据
export const searchFormSchemaZyys: FormSchema[] = [
  {
    label: '注册证编号',
    component: 'JInput',
    field: 'zsbh',
  },
  {
    label: '姓名',
    component: 'JInput',
    field: 'ylzd1',
  },
  {
    label: '身份证号',
    component: 'JInput',
    field: 'shxydm',
    labelWidth: 100,
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
  {

  label: '企业名称',
  component: 'JInput',
  field: 'qymc'
},

  {
    label: '证书编号',
    component: 'JInput',
    field: 'zsbh',
  },
  {
    label: '社会信用代码',
    component: 'JInput',
    field: 'shxydm',
    labelWidth: 100
  },
  {
    label: '发证日期',
    field: 'fzrq',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      //placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
];

export const searchFormSchemahzp: FormSchema[] = [
  {
    label: '企业名称',
    component: 'JInput',
    field: 'qymc',
  },
  {
    label: '证书编号',
    component: 'JInput',
    field: 'zsbh',
  },
  {
    label: '社会信用代码',
    component: 'JInput',
    field: 'shxydm',
  },
  {
    label: '发证日期',
    field: 'fzrq',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
  {
    label: '证书状态',
    field: 'dlzszt',
    component: 'Select',
    defaultValue: '0',
    componentProps: {
      options: [
        {
          label: '有效',
          value: '0',
        },
        {
          label: '过期',
          value: '1',
        },
        {
          label: '注销',
          value: '2',
        },
      ],
    },
  },
  {
    label: '注册地址',
    component: 'JInput',
    field: 'zcdz',
  },
];

export const searchFormSchemaylqx: FormSchema[] = [
  {
    label: '企业名称',
    component: 'JInput',
    field: 'qymc',
  },
  {
    label: '证书编号',
    component: 'JInput',
    field: 'zsbh',
  },
  {
    label: '社会信用代码',
    component: 'JInput',
    field: 'shxydm',
  },

  {
    label: '发证日期',
    field: 'fzrq',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
  {
    label: '证书状态',
    field: 'dlzszt',
    component: 'Select',
    defaultValue: '0',
    componentProps: {
      options: [
        {
          label: '有效',
          value: '0',
        },
        {
          label: '过期',
          value: '1',
        },
        {
          label: '注销',
          value: '2',
        },
      ],
    },
  },
  {
    field: 'dlzslx',
    component: 'ApiSelect',
    label: '证书类型',
    componentProps: {
      // more details see /src/components/Form/src/components/ApiSelect.vue
      api: getCerttypeNameAndValuef,
      params: {
        lx: 'ylqx',
      },
      resultField: 'list',
      // use name as label
      labelField: 'key',
      // use id as value
      valueField: 'certtypeid',
      // not request untill to select
      immediate: false,
      onChange: (e) => {
        console.log('selected:', e);
      },
      onOptionsChange: (options) => {
        console.log('get options', options.length, options);
      },
    },
    colProps: {
      span: 8,
    },
    /* defaultValue: '0',*/
  },
  {
    label: '注册地址',
    component: 'JInput',
    field: 'zcdz',
  },
];
export const searchFormSchemaypzs: FormSchema[] = [
  {
    label: '证书编号',
    component: 'JInput',
    field: 'zsbh',
  },
  {
    label: '企业名称',
    component: 'JInput',
    field: 'qymc',
  },
  {
    label: '社会信用代码',
    component: 'JInput',
    field: 'shxydm',
  },
  {
    label: '发证日期',
    field: 'fzrq',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
  {
    label: '证书状态',
    field: 'dlzszt',
    component: 'Select',
    defaultValue: '0',
    componentProps: {
      options: [
        {
          label: '有效',
          value: '0',
        },
        {
          label: '过期',
          value: '1',
        },
        {
          label: '注销',
          value: '2',
        },
      ],
    },
  },
  {
    field: 'dlzslx',
    component: 'ApiSelect',
    label: '证书类型',
    componentProps: {
      // more details see /src/components/Form/src/components/ApiSelect.vue
      api: getCerttypeNameAndValuef,
      params: {
        lx: 'yp',
      },
      resultField: 'list',
      // use name as label
      labelField: 'key',
      // use id as value
      valueField: 'certtypeid',
      // not request untill to select
      immediate: false,
      onChange: (e) => {
        console.log('selected:', e);
      },
      onOptionsChange: (options) => {
        console.log('get options', options.length, options);
      },
    },
    colProps: {
      span: 8,
    },
    /* defaultValue: '0',*/
  },
  {
    label: '注册地址',
    component: 'JInput',
    field: 'zcdz',
  },
];
export const formSchemacz: FormSchema[] = [
  {
    label: '注销人',
    field: 'certczr',
    component: 'Input',
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入注销人!' }];
    },
  },
  {
    label: '注销原因',
    field: 'logoutcause',
    component: 'InputTextArea',
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入注销原因!' }];
    },
  },
];
export const formSchemabg: FormSchema[] = [
  {
    label: '变更人',
    field: 'bgr',
    component: 'Input',
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入变更人!' }];
    },
  },
  {
    label: '变更原因',
    field: 'bgyy',
    component: 'InputTextArea',
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入变更原因!' }];
    },
  },
];
export const formSchemabf: FormSchema[] = [
  {
    label: '上传纸质文档',
    field: 'bfzzwd',
    component: 'JUpload',
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
  {
    label: '补录情况说明',
    field: 'bfyy',
    component: 'InputTextArea',
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
];

export const formSchemawh: FormSchema[] = [
  {
    label: '维护人',
    field: 'whr',
    component: 'Input',
    colProps: { span: 12 },
    dynamicDisabled: true,
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请填写维护人!' }];
    },
  },
  {
    label: '维护原因',
    field: 'whyy',
    component: 'InputTextArea',
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请填写维护原因!' }];
    },
  },
  {
    label: '上传同意维护文件',
    field: 'fj',
    component: 'JUpload',
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档扫描件!' }];
    },
  },
];

export const formSchemawhjy: FormSchema[] = [
  {
    label: '维护人',
    field: 'whr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
  {
    label: '维护原因',
    field: 'whyy',
    component: 'InputTextArea',
    dynamicDisabled: true,
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
  {
    label: '上传同意维护文件',
    field: 'fj',
    component: 'JUpload',
    dynamicDisabled: true,
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
];
export const formSchemawhTH: FormSchema[] = [
  {
    label: '退回人',
    field: 'qxgzr',
    component: 'Input',
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
  {
    label: '退回原因',
    field: 'whyy',
    component: 'InputTextArea',
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请上传纸质文档!' }];
    },
  },
];
export const formSchemawhqxgz: FormSchema[] = [
  {
    label: '取消盖章人',
    field: 'qxgzr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: { span: 12 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入取消盖章人!' }];
    },
  },
  {
    label: '取消盖章原因',
    field: 'whyy',
    component: 'InputTextArea',
    componentProps: {rows: 5},
    colProps: { span: 24 },
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入取消盖章原因!' }];
    },
  },
  // {
  //   label: '上传同意取消盖章文件',
  //   field: 'fj',
  //   component: 'JUpload',
  //   colProps: { span: 12 },
  //   dynamicRules: ({ model, schema }) => {
  //     return [{ required: true, message: '请上传纸质文档!' }];
  //   },
  // },
];
export const formSchemaxz: FormSchema[] = [
  {
    label: '选择企业信息',
    field: 'qyid',

    component: 'JPopup',
    colProps: { span: 24 },
    componentProps: ({ formActionType }) => {
      const { setFieldsValue } = formActionType;
      return {
        setFieldsValue: setFieldsValue,
        code: 'company',
        fieldConfig: [
          { source: 'entzzjgdm', target: 'shxydm' },
          { source: 'entname', target: 'qymc' },
        ],
        multi: false,
      };
    },
  },
];
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

export const formSchemawgz: FormSchema[] = [
  /*{
    label: '选择企业信息',
    field: 'qyid',
    component: 'JPopup',
    colProps:{ span: 24 },
    componentProps: ({formActionType}) => {
      const {setFieldsValue} = formActionType;
      return {
        setFieldsValue: setFieldsValue,
        code: "company",
        fieldConfig: [
          {source: 'uscc', target: 'shxydm'},{source: 'company_name', target: 'qymc'}
        ],
        multi: false,
      }
    },
  },*/
];
/*[
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
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
  },
  {
    label: '有效期起',
    field: 'fzrqStart',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
  },
  {
    label: '有效期止',
    field: 'fzrqEnd',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
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
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
  },
  {
    label: '数据同步公示平台时间',
    field: 'sjtbGsptTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
  },
  {
    label: '数据同步档案系统时间',
    field: 'sjtbDaTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
  },
  {
    label: '数据同步行政审批',
    field: 'sjtbXzspTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
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
]*/ //子表单数据
//子表表格配置
export const certchildYpscZcColumns: JVxeColumn[] = [
  {
    title: '生产类别',
    key: 'protype',
    type: JVxeTypes.select,
    dictCode: 'ypsclb',
    width: '100px',
    defaultValue: '',
    disabled: true,
  },
  {
    title: '生产地址',
    key: 'addrdetail',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '车间',
    key: 'workshop',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  /*{
    title: '受托/委托企业名称',
    key: 'refcompname',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
  /* {
     title: '受托/委托企业id',
     key: 'refcompId',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },*/
  {
    title: '生产线',
    key: 'preparation',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产范围(正本)',
    key: 'productionscope',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产范围(副本)',
    key: 'productionscopeF',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '年生产能力',
    key: 'throughput',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '计算单位',
    key: 'calculationunit',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产线(条)',
    key: 'preparationnumber',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '有无药品gmp证书编号',
    key: 'isgmp',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  /* {
    title: '生产药类型 ',//1原料 2非原料3暂无品种批次
    key: 'drugtype',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
  {
    title: '药品通用名称',
    key: 'drugname',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '药品GMP证书编码',
    key: 'getgmpcertificate',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: 'GMP认证范围',
    key: 'gmprzscope',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '操作',
    key: 'actions',
    type: JVxeTypes.slot,
    fixed: 'right',
    minWidth: 120,
    align: 'center',
    slotName: 'bianjizc',
  },
  /*  {
      title: '相关药品编码',
      key: 'cordrugid',
      type: JVxeTypes.input,
      width:"100px",
        defaultValue:'',
    },*/
  /*{
    title: '批准文号/登记号',
    key: 'regnumb',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '药品剂型',
    key: 'drugdose',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '药品规格',
    key: 'spec',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '委托有效期',
    key: 'entrustvalidate',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
*/

  /*{
    title: '状态',// 0失效 1有效 2变更
    key: 'zt',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '变更前Id',
    key: 'bgqid',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/

  /*   {
       title: '证书id',
       key: 'zsid',
       type: JVxeTypes.input,
       width:"100px",
          defaultValue:'',
     },*/
  /* {
     title: '创建日期',
     key: 'createtime',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },*/
  /*{
    title: '盖章日期',
    key: 'gztime',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '生产范围正本code',
    key: 'productionscopecode',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
  /* {
     title: '行政审批id',
     key: 'xzspid',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },*/
  /*{
    title: '公告环节状态“1许可 2不予许可”',
    key: 'gghjstatus',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '有无药品gmp证书编号',
    key: 'isgmp',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '信息状态  0正常 1删除',
    key: 'sfsc',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '数量',
    key: 'num',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '某时间',
    key: 'regnumevalidate',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
];
export const certchildYpscWtColumns: JVxeColumn[] = [
  {
    title: '生产类别',
    key: 'protype',
    type: JVxeTypes.select,
    dictCode: 'ypsclb',
    width: '100px',
    defaultValue: '',
    disabled: true,
  },
  {
    title: '委托企业',
    key: 'refcompname',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '车间',
    key: 'workshop',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '药品剂型',
    key: 'drugdose',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产线',
    key: 'preparation',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '注册地址',
    key: 'refcompaddr',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  /*{
    title: '企业编码',
    key: 'refcompId',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
  //受托方生产地址 企业编码
  {
    title: '生产药类型 ', //1原料 2非原料3暂无品种批次
    key: 'drugtype',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '相关药品编码',
    key: 'cordrugid',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '委托有效期',
    key: 'entrustvalidate',
    type: JVxeTypes.date,
    width: '100px',
    defaultValue: '',
  },

  {
    title: '药品规格',
    key: 'spec',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },

  {
    title: '药品通用名称',
    key: 'drugname',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },

  {
    title: '批准文号/登记号',
    key: 'regnumb',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '年生产能力',
    key: 'throughput',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '计算单位',
    key: 'calculationunit',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产线(条)',
    key: 'preparationnumber',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '药品GMP证书编码',
    key: 'getgmpcertificate',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: 'GMP认证范围',
    key: 'gmprzscope',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '操作',
    key: 'actions',
    type: JVxeTypes.slot,
    fixed: 'right',
    minWidth: 120,
    align: 'center',
    slotName: 'bianjiwt',
  },
  /*{
    title: '生产范围(正本)',
    key: 'productionscope',
    type: JVxeTypes.input,
    width:"100px",
    defaultValue:'',
  },
  {
    title: '生产范围(副本)',
    key: 'productionscopeF',
    type: JVxeTypes.input,
    width:"100px",
    defaultValue:'',
  },*/

  /* {
     title: '状态 0失效 1有效 2变更',
     key: 'zt',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '变更前Id',
     key: 'bgqid',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '生产地址详情',
     key: 'addrdetail',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '证书id',
     key: 'zsid',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '创建日期',
     key: 'createtime',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '盖章日期',
     key: 'gztime',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '生产范围正本code',
     key: 'productionscopecode',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '行政审批id',
     key: 'xzspid',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '公告环节状态“1许可 2不予许可”',
     key: 'gghjstatus',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '有无药品gmp证书编号',
     key: 'isgmp',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '信息状态  0正常 1删除',
     key: 'sfsc',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '数量',
     key: 'num',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },
   {
     title: '某时间',
     key: 'regnumevalidate',
     type: JVxeTypes.input,
     width:"100px",
      defaultValue:'',
   },*/
];
export const certchildYpscStColumns: JVxeColumn[] = [
  {
    title: '生产类别',
    key: 'protype',
    type: JVxeTypes.select,
    dictCode: 'ypsclb',
    width: '100px',
    defaultValue: '',
    disabled: true,
  },
  {
    title: '受托企业名称',
    key: 'refcompname',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '注册地址',
    key: 'refcompaddr',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '受托方生产地址',
    key: 'addrdetail',
    type: JVxeTypes.normal,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '车间',
    key: 'workshop',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产线',
    key: 'preparation',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },

  {
    title: '受托企业编码',
    key: 'refcompId',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '药品通用名称',
    key: 'drugname',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },

  {
    title: '生产药类型 1原料 2非原料3暂无品种批次',
    key: 'drugtype',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '批准文号/登记号',
    key: 'regnumb',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  // {
  //   title: '相关药品编码',
  //   key: 'cordrugid',
  //   type: JVxeTypes.normal,
  //   width: '100px',
  //   defaultValue: '',
  // },
  // {
  //   title: '药品规格',
  //   key: 'spec',
  //   type: JVxeTypes.normal,
  //   width: '100px',
  //   defaultValue: '',
  // },
  {
    title: '委托有效期',
    key: 'entrustvalidate',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  // {
  //   title: '药品剂型',
  //   key: 'drugdose',
  //   type: JVxeTypes.normal,
  //   width: '100px',
  //   defaultValue: '',
  // },
  {
    title: '年生产能力',
    key: 'throughput',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '计算单位',
    key: 'calculationunit',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '生产线(条)',
    key: 'preparationnumber',
    type: JVxeTypes.normal,
    width: '100px',
    defaultValue: '',
  },
  {
    title: '操作',
    key: 'actions',
    type: JVxeTypes.slot,
    fixed: 'right',
    minWidth: 120,
    align: 'center',
    slotName: 'bianjist',
  },
  /*{
    title: '生产范围(正本)',
    key: 'productionscope',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '生产范围(副本)',
    key: 'productionscopeF',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },



  {
    title: '药品GMP证书编码',
    key: 'getgmpcertificate',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: 'GMP认证范围',
    key: 'gmprzscope',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '状态 0失效 1有效 2变更',
    key: 'zt',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '变更前Id',
    key: 'bgqid',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '生产地址详情',
    key: 'addrdetail',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '创建日期',
    key: 'createtime',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '盖章日期',
    key: 'gztime',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '生产范围正本code',
    key: 'productionscopecode',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '行政审批id',
    key: 'xzspid',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '公告环节状态“1许可 2不予许可”',
    key: 'gghjstatus',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '有无药品gmp证书编号',
    key: 'isgmp',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '信息状态  0正常 1删除',
    key: 'sfsc',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '数量',
    key: 'num',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },
  {
    title: '某时间',
    key: 'regnumevalidate',
    type: JVxeTypes.input,
    width: "100px",
    defaultValue: '',
  },*/
];
export const certchildYlqxwtbaZbColumns: JVxeColumn[] = [
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品名称',
    key: 'cpmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品备案号',
    key: 'cpbah',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '登记日期',
    key: 'djtime',
    type: JVxeTypes.datetime,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '排序',
    key: 'px',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态0正常 1删除',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildYlqxscbaZbColumns: JVxeColumn[] = [
  {
    title: '证书Id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品名称',
    key: 'cpmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品备案号',
    key: 'cpbah',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '登记日期',
    key: 'djtime',
    type: JVxeTypes.datetime,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '备注',
    key: 'bz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '排序',
    key: 'px',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态  0正常 1删除',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildYpckxkzColumns: JVxeColumn[] = [
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '出口药物名称',
    key: 'ckywmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '出口药物名称英文',
    key: 'ckywmcyw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '商品编码',
    key: 'spid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '剂型',
    key: 'jx',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '出口药物包装',
    key: 'ckywbz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '出口药物规格',
    key: 'ckywgg',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '出口药物数量',
    key: 'ckywsl',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchirdYlqxlcsybaColumns: JVxeColumn[] = [
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '拟生产药品的名称',
    key: 'nscypmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '地址/科室',
    key: 'dz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '批准文号联系人/职务',
    key: 'lxr',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '电话',
    key: 'dh',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '类别 1临床实验机构(如多中心应注明牵头单位)2:研究者',
    key: 'lb',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态 0正常 1删除',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildYlqxcpckxsColumns: JVxeColumn[] = [
  {
    title: '证书Id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品名称',
    key: 'mc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '规格',
    key: 'guige',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '注册证或者备案号',
    key: 'bh',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildMzyphjsypddscColumns: JVxeColumn[] = [
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '药品名称',
    key: 'ypmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '剂型',
    key: 'jx',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '规格',
    key: 'guige',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '管制类别',
    key: 'gzlb',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '批准文号',
    key: 'pzwh',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildYpckxszmColumns: JVxeColumn[] = [
  {
    title: '证书id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '数量',
    key: 'num',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '进口国家中文',
    key: 'jkgjzw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '进口国家英文',
    key: 'jkgjyw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '类型',
    key: 'lx',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildYpscGmpColumns: JVxeColumn[] = [
  {
    title: '证书Id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '认证(检查)名称',
    key: 'authname',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '认证(检查)范围',
    key: 'authrange',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '通过认证(检查)时间',
    key: 'passauthdate',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '认证(检查)机构名称',
    key: 'authorg',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '国家(地区、组织)名称',
    key: 'countryname',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '涉及品种名称',
    key: 'sjpzmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '备注',
    key: 'bz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业id',
    key: 'qyid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '0正常1删除',
    key: 'sfsc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];

export const guojiashuju: JVxeColumn[] = [
  {
    title: '企业id',

    key: 'entid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业名称',

    key: 'entname',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '注册地址',

    key: 'zcdz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '社会信用代码',

    key: 'shxydm',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '邮编',

    key: 'yb',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '许可编号',

    key: 'xkzbh',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业类型',

    key: 'qylx',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '三资企业外方国别或地区名称',

    key: 'areaname',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业创建时间',

    key: 'founddate',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '是否隶属企业集团',

    key: 'isheadquarter',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业集团名称',

    key: 'headquartername',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业集团社会信用代码',

    key: 'headquarterorgcode',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '法定代表人',

    key: 'legalrepresentative',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业负责人',

    key: 'enterprisehead',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量负责人',

    key: 'qualityhead',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '生产负责人',

    key: 'productionhead',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量受权人',

    key: 'licensor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '法定代表人职称',

    key: 'legaltitle',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '法定代表人所学专业',

    key: 'legalschoolmajor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '法定代表人毕业院校',

    key: 'legalschool',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '法定代表人身份证号',

    key: 'legalidno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业负责人职称',

    key: 'enterpristitle',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业负责人所学专业',

    key: 'enterprislschoolmajor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业负责人毕业院校',

    key: 'enterpriseschool',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '企业负责人身份证号',

    key: 'enterpriseidno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量负责人职称',

    key: 'qualitytitle',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量负责人所学专业',

    key: 'qualityschoolmajor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量负责人毕业院校',

    key: 'qualityschool',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量负责人身份证号',

    key: 'qualityidno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '生产负责人职称',

    key: 'productiontitle',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '生产负责人所学专业',

    key: 'productionschoolmajor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '生产负责人毕业院校',

    key: 'productionschool',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '生产负责人身份证号',

    key: 'productionidno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量受权人职称',

    key: 'licensortitle',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量受权人所学专业',

    key: 'licensorschoolmajor',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量受权人毕业院校',

    key: 'licensorschool',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '质量受权人身份证号',

    key: 'licensoridno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '职工人数（人）',

    key: 'staffnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '其中：技术人员（人）',

    key: 'technicalnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '高级职称（人）',

    key: 'seniortitlenumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '初级职称（人）',

    key: 'juniortitlenumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '研究生学历（人）',

    key: 'graduatedegreenumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '本科专科学历（人）',

    key: 'bachelordegreenumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '固定资产原值（万元）',

    key: 'gdoriginalvalue',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '固定资产净值（万元）',

    key: 'gdoriginalnet',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '厂区占地面积（平米）',

    key: 'plantarea',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '建筑面积（平米）',

    key: 'builtuparea',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '上年度产值（万元）',

    key: 'annualoutputvalue',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '上年度利润（万元）',

    key: 'lastyearsprofit',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '原料药注册品种数',

    key: 'crudedrugregnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '制剂注册品种数',

    key: 'preparationregnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '其他类注册产品数',

    key: 'otherregnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '常年生产品种数',

    key: 'annualproductionnumber',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '联系人',

    key: 'contacter',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '传真',

    key: 'faxphone',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '固定电话',

    key: 'telephone',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '手机',

    key: 'mobilephone',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: 'E-mail',

    key: 'email',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '分类码',

    key: 'typecode',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '是否无菌生产',

    key: 'isasepsis',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '备注',

    key: 'remark',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '证书id',

    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '行政审批id',

    key: 'xzspid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: 'createdate',

    key: 'createdate',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: 'instanceno',

    key: 'instanceno',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];
export const certchildCkomylyColumns: JVxeColumn[] = [
  {
    title: '证书Id',
    key: 'zsid',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '条数',
    key: 'ts',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '药品通用名称中文',
    key: 'yptymczw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '药品通用名称英文',
    key: 'yptymcyw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '加工方法中文',
    key: 'jgffzw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '加工方法英文',
    key: 'jjffyw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '中国药品批准文号中文',
    key: 'zgyppzwhzw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '中国药品批准文号英文',
    key: 'zgyypzwhyw',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '是否通过我过gmp认证',
    key: 'sftgrz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '状态0正常1删除',
    key: 'zt',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];

export const wzmformSchema: FormSchema[] = [
  {
    label: '主建',
    field: 'id',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '证书id',
    field: 'zsid',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '证书类型',
    field: 'zslx',
    dynamicDisabled: true,
    component: 'Input',
    colProps: {
      span: 12,
    },
  },
  {
    label: '接受来源',
    field: 'jsly',
    component: 'Select',
    dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '审批', value: 'sp' },
        { label: '市市场局', value: 'sscj' },
        { label: '系统', value: 'xt' },
      ],
    },
    colProps: {
      span: 12,
    },
  },
  {
    label: '同步时间',
    field: 'synctime',
    dynamicDisabled: true,
    component: 'Input',
    colProps: {
      span: 12,
    },
  },
  {
    label: '业务状态',
    field: 'zszt',
    component: 'Select',
    dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '核发', value: '1' },
        { label: '换证', value: '2' },
        { label: '变更', value: '3' },
      ],
    },
    colProps: {
      span: 12,
    },
  },
  {
    label: '有效状态',
    field: 'yxzt',
    component: 'Select',
    dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '有效', value: '10' },
        { label: '注销', value: '50' },
        { label: '过期', value: '60' },
      ],
    },
    colProps: {
      span: 12,
    },
  },
  {
    label: '盖章状态',
    field: 'zt',
    component: 'Select',
    dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '未盖章', value: '3' },
        { label: '已盖章', value: '4' },
      ],
    },
    colProps: {
      span: 12,
    },
  },
  {
    label: '是否系统登记证照',
    field: 'isxt',
    component: 'Select',
    dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '是', value: '1' },
        { label: '否', value: null },
      ],
    },
    colProps: {
      span: 12,
    },
  },
];
export const shiyanformSchema: FormSchema[] = [
  {
    label: '企业id',
    field: 'entid',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业名称',
    field: 'entname',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '注册地址',
    field: 'zcdz',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '社会信用代码',
    field: 'shxydm',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '邮编',
    field: 'yb',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '许可编号',
    field: 'xkzbh',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业类型',
    field: 'qylx',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '三资企业外方国别或地区名称',
    field: 'areaname',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业创建时间',
    field: 'founddate',
    component: 'DatePicker',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '是否隶属企业集团',
    field: 'isheadquarter',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业集团名称',
    field: 'headquartername',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业集团社会信用代码',
    field: 'headquarterorgcode',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人',
    field: 'legalrepresentative',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人',
    field: 'enterprisehead',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人',
    field: 'qualityhead',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '生产负责人',
    field: 'productionhead',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量受权人',
    field: 'licensor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人职称',
    field: 'legaltitle',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人所学专业',
    field: 'legalschoolmajor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人毕业院校',
    field: 'legalschool',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人身份证号',
    field: 'legalidno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人职称',
    field: 'enterpristitle',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人所学专业',
    field: 'enterprislschoolmajor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人毕业院校',
    field: 'enterpriseschool',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人身份证号',
    field: 'enterpriseidno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人职称',
    field: 'qualitytitle',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人所学专业',
    field: 'qualityschoolmajor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人毕业院校',
    field: 'qualityschool',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人身份证号',
    field: 'qualityidno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '生产负责人职称',
    field: 'productiontitle',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '生产负责人所学专业',
    field: 'productionschoolmajor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '生产负责人毕业院校',
    field: 'productionschool',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '生产负责人身份证号',
    field: 'productionidno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量受权人职称',
    field: 'licensortitle',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量受权人所学专业',
    field: 'licensorschoolmajor',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量受权人毕业院校',
    field: 'licensorschool',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量受权人身份证号',
    field: 'licensoridno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '职工人数（人）',
    field: 'staffnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '其中：技术人员（人）',
    field: 'technicalnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '高级职称（人）',
    field: 'seniortitlenumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '初级职称（人）',
    field: 'juniortitlenumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '研究生学历（人）',
    field: 'graduatedegreenumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '本科专科学历（人）',
    field: 'bachelordegreenumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '固定资产原值（万元）',
    field: 'gdoriginalvalue',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '固定资产净值（万元）',
    field: 'gdoriginalnet',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '厂区占地面积（平米）',
    field: 'plantarea',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '建筑面积（平米）',
    field: 'builtuparea',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '上年度产值（万元）',
    field: 'annualoutputvalue',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '上年度利润（万元）',
    field: 'lastyearsprofit',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '原料药注册品种数',
    field: 'crudedrugregnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '制剂注册品种数',
    field: 'preparationregnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '其他类注册产品数',
    field: 'otherregnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '常年生产品种数',
    field: 'annualproductionnumber',
    component: 'InputNumber',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '联系人',
    field: 'contacter',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '传真',
    field: 'faxphone',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '固定电话',
    field: 'telephone',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '手机',
    field: 'mobilephone',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: 'E-mail',
    field: 'email',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '分类码',
    field: 'typecode',
    component: 'InputTextArea',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '是否无菌生产',
    field: 'isasepsis',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '备注',
    field: 'remark',
    component: 'InputTextArea',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '证书id',
    field: 'zsid',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '行政审批id',
    field: 'xzspid',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: 'createdate',
    field: 'createdate',
    component: 'DatePicker',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: 'instanceno',
    field: 'instanceno',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];
export const certchildYlqxwlxsbaColumns: JVxeColumn[] = [
  // {
  //   title: '社会信用代码',
  //   key: 'shxydm',
  //   type: JVxeTypes.input,
  //   width: '200px',
  //   defaultValue: '',
  // },
  {
    title: '医疗器械交易服务第三方平台备案平台名称',
    key: 'dsfptbafptmc',
    type: JVxeTypes.input,
    width: '400px',
    defaultValue: '',
  },
  {
    title: '医疗器械交易服务第三方平台备案凭证编号',
    key: 'pzbh',
    type: JVxeTypes.input,
    width: '300px',
    defaultValue: '',
  },
  {
    title: '备注',
    key: 'bz',
    type: JVxeTypes.textarea,
    width: '400px',
    defaultValue: '',
  },
];
export const bgjlcolumns: JVxeColumn[] = [
  {
    title: '业务类型',
    key: 'bglx_dictText',
    width: '80px',
    type: JVxeTypes.input,
    disabled: true,
  },

  //  {
  //   title: '创造时间',
  //   align:"center",
  //   dataIndex: 'czrq'
  //  },
  //  {
  //   title: '操作人员id',
  //   align:"center",
  //   dataIndex: 'czryid'
  //  },
  //  {
  //   title: '操作人姓名',
  //   align:"center",
  //   dataIndex: 'czrxm'
  //  },
  {
    title: '操作时间',
    align: 'center',
    key: 'czsj',
    width: '180px',
    type: JVxeTypes.input,
    disabled: true,
  },

  {
    title: '变更内容',
    align: 'center',
    key: 'bgnr',
    type: JVxeTypes.input,
  },
];
export const certchildDylylqxscbapzColumns: JVxeColumn[] = [
  {
    title: '产品备案号',
    key: 'zczh',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品名称',
    key: 'cpmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '产品类别代码',
    key: 'cplbDm',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '类别类型',
    key: 'cplbDm',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '是否受托生产',
    key: 'sfwtsc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '注册/备案人名称',
    key: 'zcbarmc',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '注册/备案人地址',
    key: 'zcbardz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '社会信用代码',
    key: 'shxydm',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '委托期限',
    key: 'wtqx',
    type: JVxeTypes.date,
    width: '200px',
    defaultValue: '',
  },
  {
    title: '备注',
    key: 'bz',
    type: JVxeTypes.input,
    width: '200px',
    defaultValue: '',
  },
];

// 高级查询数据
export const superQuerySchema = {
  qyid: { title: '企业编码', order: 0, view: 'text', type: 'string' },
  zslx: { title: '证书类型', order: 1, view: 'text', type: 'string' },
  zsbh: { title: '证书编号', order: 2, view: 'text', type: 'string' },
  shxydm: { title: '社会统一信用代码', order: 3, view: 'text', type: 'string' },
  zcdz: { title: '注册地址', order: 4, view: 'text', type: 'string' },
  fddbr: { title: '法定代表人', order: 5, view: 'text', type: 'string' },
  qyfzr: { title: '企业负责人', order: 6, view: 'text', type: 'string' },
  zlfzr: { title: '质量负责人', order: 7, view: 'text', type: 'string' },
  flm: { title: '分类码', order: 8, view: 'text', type: 'string' },
  rcjdgljg: { title: '日常监管机构', order: 9, view: 'text', type: 'string' },
  rcjdglry: { title: '日常监管人员', order: 10, view: 'text', type: 'string' },
  scdzhfw: { title: '生产地址和生产范围', order: 11, view: 'textarea', type: 'string' },
  fzjg: { title: '发证机关', order: 12, view: 'text', type: 'string' },
  qfr: { title: '签发人', order: 13, view: 'text', type: 'string' },
  fzrq: { title: '发证日期', order: 14, view: 'datetime', type: 'string' },
  yxqq: { title: '有效期起', order: 15, view: 'datetime', type: 'string' },
  yxqz: { title: '有效期止', order: 16, view: 'datetime', type: 'string' },
  scdz: { title: '生产地址', order: 17, view: 'textarea', type: 'string' },
  slh: { title: '受理号', order: 18, view: 'text', type: 'string' },
  ckdz: { title: '仓库地址', order: 19, view: 'textarea', type: 'string' },
  jgyjzc: { title: '结构以及组成', order: 20, view: 'textarea', type: 'string' },
  fw: { title: '范围', order: 21, view: 'text', type: 'string' },
  fwyw: { title: '范围英文', order: 22, view: 'text', type: 'string' },
  bz: { title: '备注', order: 23, view: 'text', type: 'string' },
  zs: { title: '主送', order: 24, view: 'text', type: 'string' },
  cs: { title: '抄送', order: 25, view: 'text', type: 'string' },
  cp: { title: '产品', order: 26, view: 'text', type: 'string' },
  cplb: { title: '产品类别', order: 27, view: 'text', type: 'string' },
  cpmx: { title: '产品明细', order: 28, view: 'textarea', type: 'string' },
  cz: { title: '传真', order: 29, view: 'text', type: 'string' },
  dh: { title: '电话', order: 30, view: 'text', type: 'string' },
  jx: { title: '剂型', order: 31, view: 'text', type: 'string' },
  fj: { title: '附件', order: 32, view: 'text', type: 'string' },
  wzym: { title: '网站域名', order: 33, view: 'text', type: 'string' },
  jsly: { title: '接受来源', order: 34, view: 'text', type: 'string' },
  zt: { title: '状态', order: 35, view: 'text', type: 'string' },
  ywlx: { title: '业务类型', order: 36, view: 'text', type: 'string' },
  bbid: { title: '版本id', order: 37, view: 'text', type: 'string' },
  mbid: { title: '模块id', order: 38, view: 'text', type: 'string' },
  sjtbGspt: { title: '数据同步公示平台', order: 39, view: 'text', type: 'string' },
  sjtbDa: { title: '数据同步档案系统', order: 40, view: 'text', type: 'string' },
  sjtbXzsp: { title: '数据同步行政审批', order: 41, view: 'text', type: 'string' },
  sjtbGjj: { title: '数据同步国家局', order: 42, view: 'text', type: 'string' },
  sjtbError: { title: '数据同步错误信息', order: 43, view: 'text', type: 'string' },
  sjtbGjjTime: { title: '数据同步国家局时间', order: 44, view: 'datetime', type: 'string' },
  sjtbGsptTime: { title: '数据同步公示平台时间', order: 45, view: 'datetime', type: 'string' },
  sjtbDaTime: { title: '数据同步档案系统时间', order: 46, view: 'datetime', type: 'string' },
  sjtbXzspTime: { title: '数据同步行政审批', order: 47, view: 'datetime', type: 'string' },
  ewm: { title: '二维码', order: 48, view: 'text', type: 'string' },
  ewmLj: { title: '二维码路径', order: 49, view: 'text', type: 'string' },
  glzdb: { title: '管理者代表', order: 50, view: 'text', type: 'string' },
  lxryx: { title: '联系人邮箱', order: 51, view: 'text', type: 'string' },
  lxdh: { title: '联系人电话', order: 52, view: 'text', type: 'string' },
  qylx: { title: '企业类型', order: 53, view: 'text', type: 'string' },
  ylzd1: { title: '预留字段1', order: 54, view: 'text', type: 'string' },
  ylzd5: { title: '预留字段5', order: 55, view: 'text', type: 'string' },
  ylzd2: { title: '预留字段2', order: 56, view: 'text', type: 'string' },
  ylzd3: { title: '预留字段3', order: 57, view: 'text', type: 'string' },
  ylzd4: { title: '预留字段4', order: 58, view: 'text', type: 'string' },
};
