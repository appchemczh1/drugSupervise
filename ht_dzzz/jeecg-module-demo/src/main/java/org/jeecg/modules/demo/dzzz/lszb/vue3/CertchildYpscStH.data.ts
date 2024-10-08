import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '受托',
    align:"center",
    dataIndex: 'protype'
   },
   {
    title: '注册地址',
    align:"center",
    dataIndex: 'refcompaddr'
   },
   {
    title: '车间',
    align:"center",
    dataIndex: 'workshop'
   },
   {
    title: '受托/委托企业名称',
    align:"center",
    dataIndex: 'refcompname'
   },
   {
    title: '受托/委托企业id',
    align:"center",
    dataIndex: 'refcompId'
   },
   {
    title: '生产线',
    align:"center",
    dataIndex: 'preparation'
   },
   {
    title: '生产药类型 1原料 2非原料3暂无品种批次',
    align:"center",
    dataIndex: 'drugtype'
   },
   {
    title: '药品通用名称',
    align:"center",
    dataIndex: 'drugname'
   },
   {
    title: '相关药品编码',
    align:"center",
    dataIndex: 'cordrugid'
   },
   {
    title: '批准文号/登记号',
    align:"center",
    dataIndex: 'regnumb'
   },
   {
    title: '药品剂型',
    align:"center",
    dataIndex: 'drugdose'
   },
   {
    title: '药品规格',
    align:"center",
    dataIndex: 'spec'
   },
   {
    title: '委托有效期',
    align:"center",
    dataIndex: 'entrustvalidate'
   },
   {
    title: '生产范围(正本)',
    align:"center",
    dataIndex: 'productionscope'
   },
   {
    title: '生产范围(副本)',
    align:"center",
    dataIndex: 'productionscopeF'
   },
   {
    title: '年生产能力',
    align:"center",
    dataIndex: 'throughput'
   },
   {
    title: '计算单位',
    align:"center",
    dataIndex: 'calculationunit'
   },
   {
    title: '生产线(条)',
    align:"center",
    dataIndex: 'preparationnumber'
   },
   {
    title: '药品GMP证书编码',
    align:"center",
    dataIndex: 'getgmpcertificate'
   },
   {
    title: 'gmp认证范围',
    align:"center",
    dataIndex: 'gmprzscope'
   },
   {
    title: '状态 0失效 1有效 2变更',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: '变更前Id',
    align:"center",
    dataIndex: 'bgqid'
   },
   {
    title: '生产地址详情',
    align:"center",
    dataIndex: 'addrdetail'
   },
   {
    title: '证书id',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: '创建日期',
    align:"center",
    dataIndex: 'createtime'
   },
   {
    title: '盖章日期',
    align:"center",
    dataIndex: 'gztime'
   },
   {
    title: '生产范围正本code',
    align:"center",
    dataIndex: 'productionscopecode'
   },
   {
    title: '行政审批id',
    align:"center",
    dataIndex: 'xzspid'
   },
   {
    title: '公告环节状态“1许可 2不予许可”',
    align:"center",
    dataIndex: 'gghjstatus'
   },
   {
    title: '有无药品gmp证书编号',
    align:"center",
    dataIndex: 'isgmp'
   },
   {
    title: '信息状态  0正常 1删除',
    align:"center",
    dataIndex: 'sfsc'
   },
   {
    title: '数量',
    align:"center",
    dataIndex: 'num'
   },
   {
    title: '某时间',
    align:"center",
    dataIndex: 'regnumevalidate'
   },
   {
    title: '生产类别',
    align:"center",
    dataIndex: 'sclb'
   },
   {
    title: '前置库子表Id',
    align:"center",
    dataIndex: 'qzkid'
   },
   {
    title: '同步标识',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: '交换状态',
    align:"center",
    dataIndex: 'jhzt'
   },
   {
    title: '核减时间',
    align:"center",
    dataIndex: 'gzrq'
   },
   {
    title: '历史受托数据备份',
    align:"center",
    dataIndex: 'protypebak'
   },
   {
    title: 'zsoldid',
    align:"center",
    dataIndex: 'zsoldid'
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
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '受托',
    field: 'protype',
    component: 'Input',
  },
  {
    label: '注册地址',
    field: 'refcompaddr',
    component: 'InputTextArea',
  },
  {
    label: '车间',
    field: 'workshop',
    component: 'Input',
  },
  {
    label: '受托/委托企业名称',
    field: 'refcompname',
    component: 'Input',
  },
  {
    label: '受托/委托企业id',
    field: 'refcompId',
    component: 'Input',
  },
  {
    label: '生产线',
    field: 'preparation',
    component: 'Input',
  },
  {
    label: '生产药类型 1原料 2非原料3暂无品种批次',
    field: 'drugtype',
    component: 'Input',
  },
  {
    label: '药品通用名称',
    field: 'drugname',
    component: 'Input',
  },
  {
    label: '相关药品编码',
    field: 'cordrugid',
    component: 'Input',
  },
  {
    label: '批准文号/登记号',
    field: 'regnumb',
    component: 'Input',
  },
  {
    label: '药品剂型',
    field: 'drugdose',
    component: 'Input',
  },
  {
    label: '药品规格',
    field: 'spec',
    component: 'Input',
  },
  {
    label: '委托有效期',
    field: 'entrustvalidate',
    component: 'Input',
  },
  {
    label: '生产范围(正本)',
    field: 'productionscope',
    component: 'Input',
  },
  {
    label: '生产范围(副本)',
    field: 'productionscopeF',
    component: 'Input',
  },
  {
    label: '年生产能力',
    field: 'throughput',
    component: 'Input',
  },
  {
    label: '计算单位',
    field: 'calculationunit',
    component: 'Input',
  },
  {
    label: '生产线(条)',
    field: 'preparationnumber',
    component: 'Input',
  },
  {
    label: '药品GMP证书编码',
    field: 'getgmpcertificate',
    component: 'Input',
  },
  {
    label: 'gmp认证范围',
    field: 'gmprzscope',
    component: 'Input',
  },
  {
    label: '状态 0失效 1有效 2变更',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '变更前Id',
    field: 'bgqid',
    component: 'Input',
  },
  {
    label: '生产地址详情',
    field: 'addrdetail',
    component: 'Input',
  },
  {
    label: '证书id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '创建日期',
    field: 'createtime',
    component: 'Input',
  },
  {
    label: '盖章日期',
    field: 'gztime',
    component: 'Input',
  },
  {
    label: '生产范围正本code',
    field: 'productionscopecode',
    component: 'Input',
  },
  {
    label: '行政审批id',
    field: 'xzspid',
    component: 'Input',
  },
  {
    label: '公告环节状态“1许可 2不予许可”',
    field: 'gghjstatus',
    component: 'Input',
  },
  {
    label: '有无药品gmp证书编号',
    field: 'isgmp',
    component: 'Input',
  },
  {
    label: '信息状态  0正常 1删除',
    field: 'sfsc',
    component: 'Input',
  },
  {
    label: '数量',
    field: 'num',
    component: 'Input',
  },
  {
    label: '某时间',
    field: 'regnumevalidate',
    component: 'Input',
  },
  {
    label: '生产类别',
    field: 'sclb',
    component: 'Input',
  },
  {
    label: '前置库子表Id',
    field: 'qzkid',
    component: 'Input',
  },
  {
    label: '同步标识',
    field: 'sync',
    component: 'Input',
  },
  {
    label: '交换状态',
    field: 'jhzt',
    component: 'Input',
  },
  {
    label: '核减时间',
    field: 'gzrq',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '历史受托数据备份',
    field: 'protypebak',
    component: 'Input',
  },
  {
    label: 'zsoldid',
    field: 'zsoldid',
    component: 'Input',
  },
  {
    label: 'ylzd1',
    field: 'ylzd1',
    component: 'Input',
  },
  {
    label: 'ylzd2',
    field: 'ylzd2',
    component: 'Input',
  },
  {
    label: 'ylzd3',
    field: 'ylzd3',
    component: 'Input',
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
  protype: {title: '受托',order: 0,view: 'text', type: 'string',},
  refcompaddr: {title: '注册地址',order: 1,view: 'textarea', type: 'string',},
  workshop: {title: '车间',order: 2,view: 'text', type: 'string',},
  refcompname: {title: '受托/委托企业名称',order: 3,view: 'text', type: 'string',},
  refcompId: {title: '受托/委托企业id',order: 4,view: 'text', type: 'string',},
  preparation: {title: '生产线',order: 5,view: 'text', type: 'string',},
  drugtype: {title: '生产药类型 1原料 2非原料3暂无品种批次',order: 6,view: 'text', type: 'string',},
  drugname: {title: '药品通用名称',order: 7,view: 'text', type: 'string',},
  cordrugid: {title: '相关药品编码',order: 8,view: 'text', type: 'string',},
  regnumb: {title: '批准文号/登记号',order: 9,view: 'text', type: 'string',},
  drugdose: {title: '药品剂型',order: 10,view: 'text', type: 'string',},
  spec: {title: '药品规格',order: 11,view: 'text', type: 'string',},
  entrustvalidate: {title: '委托有效期',order: 12,view: 'text', type: 'string',},
  productionscope: {title: '生产范围(正本)',order: 13,view: 'text', type: 'string',},
  productionscopeF: {title: '生产范围(副本)',order: 14,view: 'text', type: 'string',},
  throughput: {title: '年生产能力',order: 15,view: 'text', type: 'string',},
  calculationunit: {title: '计算单位',order: 16,view: 'text', type: 'string',},
  preparationnumber: {title: '生产线(条)',order: 17,view: 'text', type: 'string',},
  getgmpcertificate: {title: '药品GMP证书编码',order: 18,view: 'text', type: 'string',},
  gmprzscope: {title: 'gmp认证范围',order: 19,view: 'text', type: 'string',},
  zt: {title: '状态 0失效 1有效 2变更',order: 20,view: 'text', type: 'string',},
  bgqid: {title: '变更前Id',order: 21,view: 'text', type: 'string',},
  addrdetail: {title: '生产地址详情',order: 22,view: 'text', type: 'string',},
  zsid: {title: '证书id',order: 23,view: 'text', type: 'string',},
  createtime: {title: '创建日期',order: 24,view: 'text', type: 'string',},
  gztime: {title: '盖章日期',order: 25,view: 'text', type: 'string',},
  productionscopecode: {title: '生产范围正本code',order: 26,view: 'text', type: 'string',},
  xzspid: {title: '行政审批id',order: 27,view: 'text', type: 'string',},
  gghjstatus: {title: '公告环节状态“1许可 2不予许可”',order: 28,view: 'text', type: 'string',},
  isgmp: {title: '有无药品gmp证书编号',order: 29,view: 'text', type: 'string',},
  sfsc: {title: '信息状态  0正常 1删除',order: 30,view: 'text', type: 'string',},
  num: {title: '数量',order: 31,view: 'text', type: 'string',},
  regnumevalidate: {title: '某时间',order: 32,view: 'text', type: 'string',},
  sclb: {title: '生产类别',order: 33,view: 'text', type: 'string',},
  qzkid: {title: '前置库子表Id',order: 34,view: 'text', type: 'string',},
  sync: {title: '同步标识',order: 35,view: 'text', type: 'string',},
  jhzt: {title: '交换状态',order: 36,view: 'text', type: 'string',},
  gzrq: {title: '核减时间',order: 37,view: 'datetime', type: 'string',},
  protypebak: {title: '历史受托数据备份',order: 38,view: 'text', type: 'string',},
  zsoldid: {title: 'zsoldid',order: 39,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 40,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 41,view: 'text', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 42,view: 'text', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 43,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 44,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}