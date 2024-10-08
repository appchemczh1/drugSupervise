import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业id',
    align:"center",
    dataIndex: 'entid'
   },
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'entname'
   },
   {
    title: '注册地址',
    align:"center",
    dataIndex: 'zcdz'
   },
   {
    title: '社会信用代码',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: '邮编',
    align:"center",
    dataIndex: 'yb'
   },
   {
    title: '许可编号',
    align:"center",
    dataIndex: 'xkzbh'
   },
   {
    title: '企业类型',
    align:"center",
    dataIndex: 'qylx'
   },
   {
    title: '三资企业外方国别或地区名称',
    align:"center",
    dataIndex: 'areaname'
   },
   {
    title: '企业创建时间',
    align:"center",
    dataIndex: 'founddate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '是否隶属企业集团',
    align:"center",
    dataIndex: 'isheadquarter'
   },
   {
    title: '企业集团名称',
    align:"center",
    dataIndex: 'headquartername'
   },
   {
    title: '企业集团社会信用代码',
    align:"center",
    dataIndex: 'headquarterorgcode'
   },
   {
    title: '法定代表人',
    align:"center",
    dataIndex: 'legalrepresentative'
   },
   {
    title: '企业负责人',
    align:"center",
    dataIndex: 'enterprisehead'
   },
   {
    title: '质量负责人',
    align:"center",
    dataIndex: 'qualityhead'
   },
   {
    title: '生产负责人',
    align:"center",
    dataIndex: 'productionhead'
   },
   {
    title: '质量受权人',
    align:"center",
    dataIndex: 'licensor'
   },
   {
    title: '法定代表人职称',
    align:"center",
    dataIndex: 'legaltitle'
   },
   {
    title: '法定代表人所学专业',
    align:"center",
    dataIndex: 'legalschoolmajor'
   },
   {
    title: '法定代表人毕业院校',
    align:"center",
    dataIndex: 'legalschool'
   },
   {
    title: '法定代表人身份证号',
    align:"center",
    dataIndex: 'legalidno'
   },
   {
    title: '企业负责人职称',
    align:"center",
    dataIndex: 'enterpristitle'
   },
   {
    title: '企业负责人所学专业',
    align:"center",
    dataIndex: 'enterprislschoolmajor'
   },
   {
    title: '企业负责人毕业院校',
    align:"center",
    dataIndex: 'enterpriseschool'
   },
   {
    title: '企业负责人身份证号',
    align:"center",
    dataIndex: 'enterpriseidno'
   },
   {
    title: '质量负责人职称',
    align:"center",
    dataIndex: 'qualitytitle'
   },
   {
    title: '质量负责人所学专业',
    align:"center",
    dataIndex: 'qualityschoolmajor'
   },
   {
    title: '质量负责人毕业院校',
    align:"center",
    dataIndex: 'qualityschool'
   },
   {
    title: '质量负责人身份证号',
    align:"center",
    dataIndex: 'qualityidno'
   },
   {
    title: '生产负责人职称',
    align:"center",
    dataIndex: 'productiontitle'
   },
   {
    title: '生产负责人所学专业',
    align:"center",
    dataIndex: 'productionschoolmajor'
   },
   {
    title: '生产负责人毕业院校',
    align:"center",
    dataIndex: 'productionschool'
   },
   {
    title: '生产负责人身份证号',
    align:"center",
    dataIndex: 'productionidno'
   },
   {
    title: '质量受权人职称',
    align:"center",
    dataIndex: 'licensortitle'
   },
   {
    title: '质量受权人所学专业',
    align:"center",
    dataIndex: 'licensorschoolmajor'
   },
   {
    title: '质量受权人毕业院校',
    align:"center",
    dataIndex: 'licensorschool'
   },
   {
    title: '质量受权人身份证号',
    align:"center",
    dataIndex: 'licensoridno'
   },
   {
    title: '职工人数（人）',
    align:"center",
    dataIndex: 'staffnumber'
   },
   {
    title: '其中：技术人员（人）',
    align:"center",
    dataIndex: 'technicalnumber'
   },
   {
    title: '高级职称（人）',
    align:"center",
    dataIndex: 'seniortitlenumber'
   },
   {
    title: '初级职称（人）',
    align:"center",
    dataIndex: 'juniortitlenumber'
   },
   {
    title: '研究生学历（人）',
    align:"center",
    dataIndex: 'graduatedegreenumber'
   },
   {
    title: '本科专科学历（人）',
    align:"center",
    dataIndex: 'bachelordegreenumber'
   },
   {
    title: '固定资产原值（万元）',
    align:"center",
    dataIndex: 'gdoriginalvalue'
   },
   {
    title: '固定资产净值（万元）',
    align:"center",
    dataIndex: 'gdoriginalnet'
   },
   {
    title: '厂区占地面积（平米）',
    align:"center",
    dataIndex: 'plantarea'
   },
   {
    title: '建筑面积（平米）',
    align:"center",
    dataIndex: 'builtuparea'
   },
   {
    title: '上年度产值（万元）',
    align:"center",
    dataIndex: 'annualoutputvalue'
   },
   {
    title: '上年度利润（万元）',
    align:"center",
    dataIndex: 'lastyearsprofit'
   },
   {
    title: '原料药注册品种数',
    align:"center",
    dataIndex: 'crudedrugregnumber'
   },
   {
    title: '制剂注册品种数',
    align:"center",
    dataIndex: 'preparationregnumber'
   },
   {
    title: '其他类注册产品数',
    align:"center",
    dataIndex: 'otherregnumber'
   },
   {
    title: '常年生产品种数',
    align:"center",
    dataIndex: 'annualproductionnumber'
   },
   {
    title: '联系人',
    align:"center",
    dataIndex: 'contacter'
   },
   {
    title: '传真',
    align:"center",
    dataIndex: 'faxphone'
   },
   {
    title: '固定电话',
    align:"center",
    dataIndex: 'telephone'
   },
   {
    title: '手机',
    align:"center",
    dataIndex: 'mobilephone'
   },
   {
    title: 'E-mail',
    align:"center",
    dataIndex: 'email'
   },
   {
    title: '分类码',
    align:"center",
    dataIndex: 'typecode'
   },
   {
    title: '是否无菌生产',
    align:"center",
    dataIndex: 'isasepsis'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
   {
    title: '证书id',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: '行政审批id',
    align:"center",
    dataIndex: 'xzspid'
   },
   {
    title: 'createdate',
    align:"center",
    dataIndex: 'createdate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'instanceno',
    align:"center",
    dataIndex: 'instanceno'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业id',
    field: 'entid',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'entname',
    component: 'Input',
  },
  {
    label: '注册地址',
    field: 'zcdz',
    component: 'Input',
  },
  {
    label: '社会信用代码',
    field: 'shxydm',
    component: 'Input',
  },
  {
    label: '邮编',
    field: 'yb',
    component: 'Input',
  },
  {
    label: '许可编号',
    field: 'xkzbh',
    component: 'Input',
  },
  {
    label: '企业类型',
    field: 'qylx',
    component: 'Input',
  },
  {
    label: '三资企业外方国别或地区名称',
    field: 'areaname',
    component: 'Input',
  },
  {
    label: '企业创建时间',
    field: 'founddate',
    component: 'DatePicker',
  },
  {
    label: '是否隶属企业集团',
    field: 'isheadquarter',
    component: 'Input',
  },
  {
    label: '企业集团名称',
    field: 'headquartername',
    component: 'Input',
  },
  {
    label: '企业集团社会信用代码',
    field: 'headquarterorgcode',
    component: 'Input',
  },
  {
    label: '法定代表人',
    field: 'legalrepresentative',
    component: 'Input',
  },
  {
    label: '企业负责人',
    field: 'enterprisehead',
    component: 'Input',
  },
  {
    label: '质量负责人',
    field: 'qualityhead',
    component: 'Input',
  },
  {
    label: '生产负责人',
    field: 'productionhead',
    component: 'Input',
  },
  {
    label: '质量受权人',
    field: 'licensor',
    component: 'Input',
  },
  {
    label: '法定代表人职称',
    field: 'legaltitle',
    component: 'Input',
  },
  {
    label: '法定代表人所学专业',
    field: 'legalschoolmajor',
    component: 'Input',
  },
  {
    label: '法定代表人毕业院校',
    field: 'legalschool',
    component: 'Input',
  },
  {
    label: '法定代表人身份证号',
    field: 'legalidno',
    component: 'Input',
  },
  {
    label: '企业负责人职称',
    field: 'enterpristitle',
    component: 'Input',
  },
  {
    label: '企业负责人所学专业',
    field: 'enterprislschoolmajor',
    component: 'Input',
  },
  {
    label: '企业负责人毕业院校',
    field: 'enterpriseschool',
    component: 'Input',
  },
  {
    label: '企业负责人身份证号',
    field: 'enterpriseidno',
    component: 'Input',
  },
  {
    label: '质量负责人职称',
    field: 'qualitytitle',
    component: 'Input',
  },
  {
    label: '质量负责人所学专业',
    field: 'qualityschoolmajor',
    component: 'Input',
  },
  {
    label: '质量负责人毕业院校',
    field: 'qualityschool',
    component: 'Input',
  },
  {
    label: '质量负责人身份证号',
    field: 'qualityidno',
    component: 'Input',
  },
  {
    label: '生产负责人职称',
    field: 'productiontitle',
    component: 'Input',
  },
  {
    label: '生产负责人所学专业',
    field: 'productionschoolmajor',
    component: 'Input',
  },
  {
    label: '生产负责人毕业院校',
    field: 'productionschool',
    component: 'Input',
  },
  {
    label: '生产负责人身份证号',
    field: 'productionidno',
    component: 'Input',
  },
  {
    label: '质量受权人职称',
    field: 'licensortitle',
    component: 'Input',
  },
  {
    label: '质量受权人所学专业',
    field: 'licensorschoolmajor',
    component: 'Input',
  },
  {
    label: '质量受权人毕业院校',
    field: 'licensorschool',
    component: 'Input',
  },
  {
    label: '质量受权人身份证号',
    field: 'licensoridno',
    component: 'Input',
  },
  {
    label: '职工人数（人）',
    field: 'staffnumber',
    component: 'InputNumber',
  },
  {
    label: '其中：技术人员（人）',
    field: 'technicalnumber',
    component: 'InputNumber',
  },
  {
    label: '高级职称（人）',
    field: 'seniortitlenumber',
    component: 'InputNumber',
  },
  {
    label: '初级职称（人）',
    field: 'juniortitlenumber',
    component: 'InputNumber',
  },
  {
    label: '研究生学历（人）',
    field: 'graduatedegreenumber',
    component: 'InputNumber',
  },
  {
    label: '本科专科学历（人）',
    field: 'bachelordegreenumber',
    component: 'InputNumber',
  },
  {
    label: '固定资产原值（万元）',
    field: 'gdoriginalvalue',
    component: 'InputNumber',
  },
  {
    label: '固定资产净值（万元）',
    field: 'gdoriginalnet',
    component: 'InputNumber',
  },
  {
    label: '厂区占地面积（平米）',
    field: 'plantarea',
    component: 'InputNumber',
  },
  {
    label: '建筑面积（平米）',
    field: 'builtuparea',
    component: 'InputNumber',
  },
  {
    label: '上年度产值（万元）',
    field: 'annualoutputvalue',
    component: 'InputNumber',
  },
  {
    label: '上年度利润（万元）',
    field: 'lastyearsprofit',
    component: 'InputNumber',
  },
  {
    label: '原料药注册品种数',
    field: 'crudedrugregnumber',
    component: 'InputNumber',
  },
  {
    label: '制剂注册品种数',
    field: 'preparationregnumber',
    component: 'InputNumber',
  },
  {
    label: '其他类注册产品数',
    field: 'otherregnumber',
    component: 'InputNumber',
  },
  {
    label: '常年生产品种数',
    field: 'annualproductionnumber',
    component: 'InputNumber',
  },
  {
    label: '联系人',
    field: 'contacter',
    component: 'Input',
  },
  {
    label: '传真',
    field: 'faxphone',
    component: 'Input',
  },
  {
    label: '固定电话',
    field: 'telephone',
    component: 'Input',
  },
  {
    label: '手机',
    field: 'mobilephone',
    component: 'Input',
  },
  {
    label: 'E-mail',
    field: 'email',
    component: 'Input',
  },
  {
    label: '分类码',
    field: 'typecode',
    component: 'InputTextArea',
  },
  {
    label: '是否无菌生产',
    field: 'isasepsis',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'InputTextArea',
  },
  {
    label: '证书id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '行政审批id',
    field: 'xzspid',
    component: 'Input',
  },
  {
    label: 'createdate',
    field: 'createdate',
    component: 'DatePicker',
  },
  {
    label: 'instanceno',
    field: 'instanceno',
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
  entid: {title: '企业id',order: 0,view: 'text', type: 'string',},
  entname: {title: '企业名称',order: 1,view: 'text', type: 'string',},
  zcdz: {title: '注册地址',order: 2,view: 'text', type: 'string',},
  shxydm: {title: '社会信用代码',order: 3,view: 'text', type: 'string',},
  yb: {title: '邮编',order: 4,view: 'text', type: 'string',},
  xkzbh: {title: '许可编号',order: 5,view: 'text', type: 'string',},
  qylx: {title: '企业类型',order: 6,view: 'text', type: 'string',},
  areaname: {title: '三资企业外方国别或地区名称',order: 7,view: 'text', type: 'string',},
  founddate: {title: '企业创建时间',order: 8,view: 'date', type: 'string',},
  isheadquarter: {title: '是否隶属企业集团',order: 9,view: 'text', type: 'string',},
  headquartername: {title: '企业集团名称',order: 10,view: 'text', type: 'string',},
  headquarterorgcode: {title: '企业集团社会信用代码',order: 11,view: 'text', type: 'string',},
  legalrepresentative: {title: '法定代表人',order: 12,view: 'text', type: 'string',},
  enterprisehead: {title: '企业负责人',order: 13,view: 'text', type: 'string',},
  qualityhead: {title: '质量负责人',order: 14,view: 'text', type: 'string',},
  productionhead: {title: '生产负责人',order: 15,view: 'text', type: 'string',},
  licensor: {title: '质量受权人',order: 16,view: 'text', type: 'string',},
  legaltitle: {title: '法定代表人职称',order: 17,view: 'text', type: 'string',},
  legalschoolmajor: {title: '法定代表人所学专业',order: 18,view: 'text', type: 'string',},
  legalschool: {title: '法定代表人毕业院校',order: 19,view: 'text', type: 'string',},
  legalidno: {title: '法定代表人身份证号',order: 20,view: 'text', type: 'string',},
  enterpristitle: {title: '企业负责人职称',order: 21,view: 'text', type: 'string',},
  enterprislschoolmajor: {title: '企业负责人所学专业',order: 22,view: 'text', type: 'string',},
  enterpriseschool: {title: '企业负责人毕业院校',order: 23,view: 'text', type: 'string',},
  enterpriseidno: {title: '企业负责人身份证号',order: 24,view: 'text', type: 'string',},
  qualitytitle: {title: '质量负责人职称',order: 25,view: 'text', type: 'string',},
  qualityschoolmajor: {title: '质量负责人所学专业',order: 26,view: 'text', type: 'string',},
  qualityschool: {title: '质量负责人毕业院校',order: 27,view: 'text', type: 'string',},
  qualityidno: {title: '质量负责人身份证号',order: 28,view: 'text', type: 'string',},
  productiontitle: {title: '生产负责人职称',order: 29,view: 'text', type: 'string',},
  productionschoolmajor: {title: '生产负责人所学专业',order: 30,view: 'text', type: 'string',},
  productionschool: {title: '生产负责人毕业院校',order: 31,view: 'text', type: 'string',},
  productionidno: {title: '生产负责人身份证号',order: 32,view: 'text', type: 'string',},
  licensortitle: {title: '质量受权人职称',order: 33,view: 'text', type: 'string',},
  licensorschoolmajor: {title: '质量受权人所学专业',order: 34,view: 'text', type: 'string',},
  licensorschool: {title: '质量受权人毕业院校',order: 35,view: 'text', type: 'string',},
  licensoridno: {title: '质量受权人身份证号',order: 36,view: 'text', type: 'string',},
  staffnumber: {title: '职工人数（人）',order: 37,view: 'number', type: 'number',},
  technicalnumber: {title: '其中：技术人员（人）',order: 38,view: 'number', type: 'number',},
  seniortitlenumber: {title: '高级职称（人）',order: 39,view: 'number', type: 'number',},
  juniortitlenumber: {title: '初级职称（人）',order: 40,view: 'number', type: 'number',},
  graduatedegreenumber: {title: '研究生学历（人）',order: 41,view: 'number', type: 'number',},
  bachelordegreenumber: {title: '本科专科学历（人）',order: 42,view: 'number', type: 'number',},
  gdoriginalvalue: {title: '固定资产原值（万元）',order: 43,view: 'number', type: 'number',},
  gdoriginalnet: {title: '固定资产净值（万元）',order: 44,view: 'number', type: 'number',},
  plantarea: {title: '厂区占地面积（平米）',order: 45,view: 'number', type: 'number',},
  builtuparea: {title: '建筑面积（平米）',order: 46,view: 'number', type: 'number',},
  annualoutputvalue: {title: '上年度产值（万元）',order: 47,view: 'number', type: 'number',},
  lastyearsprofit: {title: '上年度利润（万元）',order: 48,view: 'number', type: 'number',},
  crudedrugregnumber: {title: '原料药注册品种数',order: 49,view: 'number', type: 'number',},
  preparationregnumber: {title: '制剂注册品种数',order: 50,view: 'number', type: 'number',},
  otherregnumber: {title: '其他类注册产品数',order: 51,view: 'number', type: 'number',},
  annualproductionnumber: {title: '常年生产品种数',order: 52,view: 'number', type: 'number',},
  contacter: {title: '联系人',order: 53,view: 'text', type: 'string',},
  faxphone: {title: '传真',order: 54,view: 'text', type: 'string',},
  telephone: {title: '固定电话',order: 55,view: 'text', type: 'string',},
  mobilephone: {title: '手机',order: 56,view: 'text', type: 'string',},
  email: {title: 'E-mail',order: 57,view: 'text', type: 'string',},
  typecode: {title: '分类码',order: 58,view: 'textarea', type: 'string',},
  isasepsis: {title: '是否无菌生产',order: 59,view: 'text', type: 'string',},
  remark: {title: '备注',order: 60,view: 'textarea', type: 'string',},
  zsid: {title: '证书id',order: 61,view: 'text', type: 'string',},
  xzspid: {title: '行政审批id',order: 62,view: 'text', type: 'string',},
  createdate: {title: 'createdate',order: 63,view: 'date', type: 'string',},
  instanceno: {title: 'instanceno',order: 64,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}