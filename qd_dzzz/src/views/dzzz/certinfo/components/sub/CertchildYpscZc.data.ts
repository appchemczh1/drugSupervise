import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { JVxeTypes } from '@/components/jeecg/JVxeTable/src/types';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '受托',
    align: 'center',
    dataIndex: 'protype',
  },
  {
    title: '注册地址',
    align: 'center',
    dataIndex: 'refcompAddr',
  },
  {
    title: '车间',
    align: 'center',
    dataIndex: 'workshop',
  },
  {
    title: '受托/委托企业名称',
    align: 'center',
    dataIndex: 'refcompName',
  },
  {
    title: '受托/委托企业id',
    align: 'center',
    dataIndex: 'refcompId',
  },
  {
    title: '生产线',
    align: 'center',
    dataIndex: 'prearation',
  },
  {
    title: '生产药类型 1原料 2非原料3暂无品种批次',
    align: 'center',
    dataIndex: 'drugtype',
  },
  {
    title: '药品通用名称',
    align: 'center',
    dataIndex: 'drugname',
  },
  {
    title: '相关药品编码',
    align: 'center',
    dataIndex: 'cordrugid',
  },
  {
    title: '批准文号/登记号',
    align: 'center',
    dataIndex: 'regnmb',
  },
  {
    title: '药品剂型',
    align: 'center',
    dataIndex: 'drugdose',
  },
  {
    title: '药品规格',
    align: 'center',
    dataIndex: 'spec',
  },
  {
    title: '委托有效期',
    align: 'center',
    dataIndex: 'entrustvalidate',
  },
  {
    title: '生产范围(正本)',
    align: 'center',
    dataIndex: 'productionscope',
  },
  {
    title: '生产范围(副本)',
    align: 'center',
    dataIndex: 'productionscopeF',
  },
  {
    title: '年生产能力',
    align: 'center',
    dataIndex: 'throughput',
  },
  {
    title: '计算单位',
    align: 'center',
    dataIndex: 'calculationunit',
  },
  {
    title: '生产线(条)',
    align: 'center',
    dataIndex: 'preparationnumber',
  },
  {
    title: '药品GMP证书编码',
    align: 'center',
    dataIndex: 'getgmpcertificate',
  },
  {
    title: 'gmp认证范围',
    align: 'center',
    dataIndex: 'gmprzscope',
  },
  {
    title: '状态 0失效 1有效 2变更',
    align: 'center',
    dataIndex: 'zt',
  },
  {
    title: '变更前Id',
    align: 'center',
    dataIndex: 'bgqid',
  },
  {
    title: '生产地址详情',
    align: 'center',
    dataIndex: 'adddetal',
  },
  {
    title: '证书id',
    align: 'center',
    dataIndex: 'zsid',
  },
  {
    title: '创建日期',
    align: 'center',
    dataIndex: 'createtime',
  },
  {
    title: '盖章日期',
    align: 'center',
    dataIndex: 'gztime',
  },
  {
    title: '生产范围正本code',
    align: 'center',
    dataIndex: 'productionscopecode',
  },
  {
    title: '行政审批id',
    align: 'center',
    dataIndex: 'xzspid',
  },
  {
    title: '公告环节状态“1许可 2不予许可”',
    align: 'center',
    dataIndex: 'gghjstatus',
  },
  {
    title: '有无药品gmp证书编号',
    align: 'center',
    dataIndex: 'isgmp',
  },
  {
    title: '信息状态  0正常 1删除',
    align: 'center',
    dataIndex: 'sfsc',
  },
  {
    title: '数量',
    align: 'center',
    dataIndex: 'num',
  },
  {
    title: '某时间',
    align: 'center',
    dataIndex: 'regnumevalidate',
  },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
    //colProps: {span: 6},
  },
  {
    label: '创建日期',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
    //colProps: {span: 6},
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '生产类别',
    field: 'protype',
    component: 'JDictSelectTag',
    colProps: { span: 12 },
    componentProps: {
      dictCode: 'ypsclb',
    },
    defaultValue: '1',
    dynamicDisabled: true,
    required: true,
  },
  {
    label: '生产地址',
    field: 'addrdetail',
    component: 'InputTextArea',
    colProps: { span: 24 },
    required: true,
  },
  {
    label: '车间',
    field: 'workshop',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '生产线',
    field: 'preparation',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },

  {
    label: '生产范围(正本)',
    field: 'productionscope',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '生产范围(副本)',
    field: 'productionscopeF',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '年生产能力',
    field: 'throughput',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '计算单位',
    field: 'calculationunit',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '生产线(条)',
    field: 'preparationnumber',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
/*  {
    label: '有无药品gmp证书编号',
    field: 'isgmp',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: '药品通用名称',
    field: 'drugname',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },*/
  {
    label: '药品GMP证书编码',
    labelWidth: 140,
    field: 'getgmpcertificate',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  {
    label: 'GMP认证范围',
    field: 'gmprzscope',
    component: 'Input',
    colProps: { span: 12 },
    required: true,
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

// 高级查询数据
export const superQuerySchema = {
  protype: { title: '受托', order: 2, view: 'text', type: 'string' },
  refcompAddr: { title: '注册地址', order: 3, view: 'text', type: 'string' },
  workshop: { title: '车间', order: 4, view: 'text', type: 'string' },
  refcompName: { title: '受托/委托企业名称', order: 5, view: 'text', type: 'string' },
  refcompId: { title: '受托/委托企业id', order: 6, view: 'text', type: 'string' },
  prearation: { title: '生产线', order: 7, view: 'text', type: 'string' },
  drugtype: { title: '生产药类型 1原料 2非原料3暂无品种批次', order: 8, view: 'text', type: 'string' },
  drugname: { title: '药品通用名称', order: 9, view: 'text', type: 'string' },
  cordrugid: { title: '相关药品编码', order: 10, view: 'text', type: 'string' },
  regnmb: { title: '批准文号/登记号', order: 11, view: 'text', type: 'string' },
  drugdose: { title: '药品剂型', order: 12, view: 'text', type: 'string' },
  spec: { title: '药品规格', order: 13, view: 'text', type: 'string' },
  entrustvalidate: { title: '委托有效期', order: 14, view: 'text', type: 'string' },
  productionscope: { title: '生产范围(正本)', order: 15, view: 'text', type: 'string' },
  productionscopeF: { title: '生产范围(副本)', order: 16, view: 'text', type: 'string' },
  throughput: { title: '年生产能力', order: 17, view: 'text', type: 'string' },
  calculationunit: { title: '计算单位', order: 18, view: 'text', type: 'string' },
  preparationnumber: { title: '生产线(条)', order: 19, view: 'text', type: 'string' },
  getgmpcertificate: { title: '药品GMP证书编码', order: 20, view: 'text', type: 'string' },
  gmprzscope: { title: 'gmp认证范围', order: 21, view: 'text', type: 'string' },
  zt: { title: '状态 0失效 1有效 2变更', order: 22, view: 'text', type: 'string' },
  bgqid: { title: '变更前Id', order: 23, view: 'text', type: 'string' },
  adddetal: { title: '生产地址详情', order: 24, view: 'text', type: 'string' },
  zsid: { title: '证书id', order: 25, view: 'text', type: 'string' },
  createtime: { title: '创建日期', order: 26, view: 'text', type: 'string' },
  gztime: { title: '盖章日期', order: 27, view: 'text', type: 'string' },
  productionscopecode: { title: '生产范围正本code', order: 28, view: 'text', type: 'string' },
  xzspid: { title: '行政审批id', order: 29, view: 'text', type: 'string' },
  gghjstatus: { title: '公告环节状态“1许可 2不予许可”', order: 30, view: 'text', type: 'string' },
  isgmp: { title: '有无药品gmp证书编号', order: 31, view: 'text', type: 'string' },
  sfsc: { title: '信息状态  0正常 1删除', order: 32, view: 'text', type: 'string' },
  num: { title: '数量', order: 33, view: 'text', type: 'string' },
  regnumevalidate: { title: '某时间', order: 34, view: 'text', type: 'string' },
};

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
