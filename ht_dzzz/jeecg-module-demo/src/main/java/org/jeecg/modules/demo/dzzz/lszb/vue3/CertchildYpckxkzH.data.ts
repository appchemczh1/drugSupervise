import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '证书id',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: '条数',
    align:"center",
    dataIndex: 'ts'
   },
   {
    title: '出口药物名称',
    align:"center",
    dataIndex: 'ckywmc'
   },
   {
    title: '出口药物名称英文',
    align:"center",
    dataIndex: 'ckywmcyw'
   },
   {
    title: '商品编码',
    align:"center",
    dataIndex: 'spid'
   },
   {
    title: '剂型',
    align:"center",
    dataIndex: 'jx'
   },
   {
    title: '出口药物包装',
    align:"center",
    dataIndex: 'ckywbz'
   },
   {
    title: '出口药物规格',
    align:"center",
    dataIndex: 'ckywgg'
   },
   {
    title: '出口药物数量',
    align:"center",
    dataIndex: 'ckywsl'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'zt'
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
    label: '证书id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '条数',
    field: 'ts',
    component: 'Input',
  },
  {
    label: '出口药物名称',
    field: 'ckywmc',
    component: 'Input',
  },
  {
    label: '出口药物名称英文',
    field: 'ckywmcyw',
    component: 'Input',
  },
  {
    label: '商品编码',
    field: 'spid',
    component: 'Input',
  },
  {
    label: '剂型',
    field: 'jx',
    component: 'Input',
  },
  {
    label: '出口药物包装',
    field: 'ckywbz',
    component: 'Input',
  },
  {
    label: '出口药物规格',
    field: 'ckywgg',
    component: 'Input',
  },
  {
    label: '出口药物数量',
    field: 'ckywsl',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'zt',
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
  zsid: {title: '证书id',order: 0,view: 'text', type: 'string',},
  ts: {title: '条数',order: 1,view: 'text', type: 'string',},
  ckywmc: {title: '出口药物名称',order: 2,view: 'text', type: 'string',},
  ckywmcyw: {title: '出口药物名称英文',order: 3,view: 'text', type: 'string',},
  spid: {title: '商品编码',order: 4,view: 'text', type: 'string',},
  jx: {title: '剂型',order: 5,view: 'text', type: 'string',},
  ckywbz: {title: '出口药物包装',order: 6,view: 'text', type: 'string',},
  ckywgg: {title: '出口药物规格',order: 7,view: 'text', type: 'string',},
  ckywsl: {title: '出口药物数量',order: 8,view: 'text', type: 'string',},
  zt: {title: '状态',order: 9,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 10,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 11,view: 'text', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 12,view: 'text', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 13,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 14,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}