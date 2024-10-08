import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [

  {
    title: '社会信用代码',
    align:"center",
    dataIndex: 'uscc'
  },
  {
    title: '公司名称',
    align:"center",
    dataIndex: 'companyName'
  },
  {
    title: '注册地址',
    align:"center",
    dataIndex: 'regAdd'
  },
  {
    title: '法定代表人',
    align:"center",
    dataIndex: 'legal'
  },
]
/* [{
  title: '企业类型',
  align:"center",
  dataIndex: 'companyType'
 },
 {
  title: '企业性质',
  align:"center",
  dataIndex: 'companyXz'
 },

 {
  title: '地区id',
  align:"center",
  dataIndex: 'distid'
 },
 {
  title: '地区名称',
  align:"center",
  dataIndex: 'distname'
 },
 {
  title: '机构Id',
  align:"center",
  dataIndex: 'jgId'
 },
 {
  title: '机构名称',
  align:"center",
  dataIndex: 'jgName'
 },
 {
  title: '邮箱',
  align:"center",
  dataIndex: 'email'
 },
 {
  title: '移动电话',
  align:"center",
  dataIndex: 'phone'
 },
 {
  title: '联系人',
  align:"center",
  dataIndex: 'telName'
 },
 {
  title: '联系人电话',
  align:"center",
  dataIndex: 'telNum'
 },
 {
  title: '上级机构Id',
  align:"center",
  dataIndex: 'orgaFatid'
 },

 {
  title: '法定代表人证件号码',
  align:"center",
  dataIndex: 'legalCertnum'
 },
 {
  title: '法定代表人证件类型',
  align:"center",
  dataIndex: 'legalCerttype'
 },
 {
  title: '法定代表人电话',
  align:"center",
  dataIndex: 'legalTel'
 },
 {
  title: '法人类型',
  align:"center",
  dataIndex: 'legalType'
 },
 {
  title: '状态 1：注销；0正常',
  align:"center",
  dataIndex: 'status'
 },
 {
  title: '备注',
  align:"center",
  dataIndex: 'remark'
 },
 {
  title: '成立时间',
  align:"center",
  dataIndex: 'createtime'
 },
 {
  title: '上级机构',
  align:"center",
  dataIndex: 'orgaFat'
 },
 {
  title: '邮政编码',
  align:"center",
  dataIndex: 'yzbm'
 },
 {
  title: '营业期限',
  align:"center",
  dataIndex: 'yyqx'
 },
 {
  title: '注册资本',
  align:"center",
  dataIndex: 'zczb'
 },
 {
  title: '经营范围',
  align:"center",
  dataIndex: 'jyfw'
 },
 {
  title: '传真',
  align:"center",
  dataIndex: 'cz'
 },
 {
  title: '历史名称',
  align:"center",
  dataIndex: 'histName'
 },
 {
  title: '登记机关',
  align:"center",
  dataIndex: 'djjg'
 },
 {
  title: '登记状态',
  align:"center",
  dataIndex: 'djStatus'
 },
 {
  title: '数据创造时间',
  align:"center",
  dataIndex: 'sjcztime'
 },
 {
  title: '创建人',
  align:"center",
  dataIndex: 'cjr'
 },
 {
  title: '创造时间',
  align:"center",
  dataIndex: 'cjtime'
 },
 {
  title: '更新人',
  align:"center",
  dataIndex: 'gxr'
 },
 {
  title: '更新时间',
  align:"center",
  dataIndex: 'gxtime'
 },
 {
  title: '数据交换状态 0：为交换 1：已交换',
  align:"center",
  dataIndex: 'sync'
 },
 {
  title: '公示平台数据交 0删除1新增 2更改 3已交换',
  align:"center",
  dataIndex: 'gsptSync'
 },
 {
  title: '审批系统数据推送状态',
  align:"center",
  dataIndex: 'spxtSync'
 },
]*/
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '社会信用代码',
    component: 'Input',
    field: 'uscc'
  },
  {
    label: '公司名称',
    component: 'Input',
    field: 'companyName'
  },
  {
    label: '注册地址',
    component: 'Input',
    field: 'regAdd'
  },
  {
    label: '法定代表人',
    component: 'Input',
    field: 'legal'
  },

];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '公司名称',
    field: 'entzzjgdm',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '社会信用代码',
    field: 'uscc',
    component: 'Input',
    colProps:{ span: 12 },

  },
  {
    label: '地区',
    field: 'distid',
    component: 'JTreeSelect',
    componentProps: {
      //字典code配置，比如通过性别字典编码：sex，也可以使用sys_permission,name,id 表名,名称,值的方式
      dict: 'cert_area,areaname,areacode',
      // //父级id字段
      pidField: 'parentid',

    },
    colProps:{ span: 12 },
  },
  {
    label: '工商企业类型',
    field: 'companyType',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode:"gslx"
    },  //gslx
    colProps:{ span: 12 },
  },
  {
    label: '注册地址',
    field: 'regAdd',
    component: 'Input',
    colProps:{ span: 24 },
  },
  {
    label: '注册资本',
    field: 'zczb',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '法定代表人',
    field: 'legal',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '法定代表人证件号码',
    field: 'legalCertnum',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '登记机关',
    field: 'djjg',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '成立时间',
    field: 'createtime',
    component: 'Input',

  },
  {
    label: '营业期限',
    field: 'yyqx',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '登记状态',
    field: 'djStatus',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '经营范围',
    field: 'jyfw',
    component: 'Input',
    colProps:{ span: 24 },
  },

  {
    label: '联系人',
    field: 'telName',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '移动电话',
    field: 'phone',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '联系人电话（座机）',
    field: 'telNum',
    component: 'Input',
    colProps:{ span: 12 },
  },

  {
    label: '法定代表人电话',
    field: 'legalTel',
    component: 'Input',
    colProps:{ span: 12 },
  },



  {
    label: '传真',
    field: 'cz',
    component: 'Input',
    colProps:{ span: 12 },
  },
  {
    label: '历史名称',
    field: 'histName',
    component: 'Input',
    colProps:{ span: 24 },
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
  companyName: {title: '公司名称',order: 0,view: 'text', type: 'string',},
  uscc: {title: '社会信用代码',order: 1,view: 'text', type: 'string',},
  companyType: {title: '企业类型',order: 2,view: 'text', type: 'string',},
  companyXz: {title: '企业性质',order: 3,view: 'text', type: 'string',},
  regAdd: {title: '注册信息',order: 4,view: 'text', type: 'string',},
  distid: {title: '地区id',order: 5,view: 'text', type: 'string',},
  distname: {title: '地区名称',order: 6,view: 'text', type: 'string',},
  jgId: {title: '机构Id',order: 7,view: 'text', type: 'string',},
  jgName: {title: '机构名称',order: 8,view: 'text', type: 'string',},
  email: {title: '邮箱',order: 9,view: 'text', type: 'string',},
  phone: {title: '移动电话',order: 10,view: 'text', type: 'string',},
  telName: {title: '联系人',order: 11,view: 'text', type: 'string',},
  telNum: {title: '联系人电话',order: 12,view: 'text', type: 'string',},
  orgaFatid: {title: '上级机构Id',order: 13,view: 'text', type: 'string',},
  legal: {title: '法定代表人',order: 14,view: 'text', type: 'string',},
  legalCertnum: {title: '法定代表人证件号码',order: 15,view: 'text', type: 'string',},
  legalCerttype: {title: '法定代表人证件类型',order: 16,view: 'text', type: 'string',},
  legalTel: {title: '法定代表人电话',order: 17,view: 'text', type: 'string',},
  legalType: {title: '法人类型',order: 18,view: 'text', type: 'string',},
  status: {title: '状态 1：注销；0正常',order: 19,view: 'text', type: 'string',},
  remark: {title: '备注',order: 20,view: 'text', type: 'string',},
  createtime: {title: '成立时间',order: 21,view: 'text', type: 'string',},
  orgaFat: {title: '上级机构',order: 22,view: 'text', type: 'string',},
  yzbm: {title: '邮政编码',order: 23,view: 'text', type: 'string',},
  yyqx: {title: '营业期限',order: 24,view: 'text', type: 'string',},
  zczb: {title: '注册资本',order: 25,view: 'text', type: 'string',},
  jyfw: {title: '经营范围',order: 26,view: 'text', type: 'string',},
  cz: {title: '传真',order: 27,view: 'text', type: 'string',},
  histName: {title: '历史名称',order: 28,view: 'text', type: 'string',},
  djjg: {title: '登记机关',order: 29,view: 'text', type: 'string',},
  djStatus: {title: '登记状态',order: 30,view: 'text', type: 'string',},
  sjcztime: {title: '数据创造时间',order: 31,view: 'datetime', type: 'string',},
  cjr: {title: '创建人',order: 32,view: 'text', type: 'string',},
  cjtime: {title: '创造时间',order: 33,view: 'text', type: 'string',},
  gxr: {title: '更新人',order: 34,view: 'text', type: 'string',},
  gxtime: {title: '更新时间',order: 35,view: 'text', type: 'string',},
  sync: {title: '数据交换状态 0：为交换 1：已交换',order: 36,view: 'text', type: 'string',},
  gsptSync: {title: '公示平台数据交 0删除1新增 2更改 3已交换',order: 37,view: 'text', type: 'string',},
  spxtSync: {title: '审批系统数据推送状态',order: 38,view: 'text', type: 'string',},
};

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
