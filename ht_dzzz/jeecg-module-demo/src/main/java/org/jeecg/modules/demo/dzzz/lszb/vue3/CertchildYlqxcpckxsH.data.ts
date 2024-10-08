import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '证书Id',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: '产品名称',
    align:"center",
    dataIndex: 'mc'
   },
   {
    title: '规格',
    align:"center",
    dataIndex: 'guige'
   },
   {
    title: '注册证或者备案号',
    align:"center",
    dataIndex: 'bh'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: '条数',
    align:"center",
    dataIndex: 'ts'
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
    label: '证书Id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '产品名称',
    field: 'mc',
    component: 'InputTextArea',
  },
  {
    label: '规格',
    field: 'guige',
    component: 'InputTextArea',
  },
  {
    label: '注册证或者备案号',
    field: 'bh',
    component: 'InputTextArea',
  },
  {
    label: '状态',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '条数',
    field: 'ts',
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
  zsid: {title: '证书Id',order: 0,view: 'text', type: 'string',},
  mc: {title: '产品名称',order: 1,view: 'textarea', type: 'string',},
  guige: {title: '规格',order: 2,view: 'textarea', type: 'string',},
  bh: {title: '注册证或者备案号',order: 3,view: 'textarea', type: 'string',},
  zt: {title: '状态',order: 4,view: 'text', type: 'string',},
  ts: {title: '条数',order: 5,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 6,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 7,view: 'text', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 8,view: 'text', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 9,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 10,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}