import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'zsid',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: 'num',
    align:"center",
    dataIndex: 'num'
   },
   {
    title: 'mc',
    align:"center",
    dataIndex: 'mc'
   },
   {
    title: 'dz',
    align:"center",
    dataIndex: 'dz'
   },
   {
    title: 'lxr',
    align:"center",
    dataIndex: 'lxr'
   },
   {
    title: 'dh',
    align:"center",
    dataIndex: 'dh'
   },
   {
    title: 'lb',
    align:"center",
    dataIndex: 'lb'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'zsid',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: 'num',
    field: 'num',
    component: 'Input',
  },
  {
    label: 'mc',
    field: 'mc',
    component: 'Input',
  },
  {
    label: 'dz',
    field: 'dz',
    component: 'Input',
  },
  {
    label: 'lxr',
    field: 'lxr',
    component: 'Input',
  },
  {
    label: 'dh',
    field: 'dh',
    component: 'Input',
  },
  {
    label: 'lb',
    field: 'lb',
    component: 'Input',
  },
  {
    label: 'sync',
    field: 'sync',
    component: 'Input',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'InputNumber',
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
  zsid: {title: 'zsid',order: 0,view: 'text', type: 'string',},
  num: {title: 'num',order: 1,view: 'text', type: 'string',},
  mc: {title: 'mc',order: 2,view: 'text', type: 'string',},
  dz: {title: 'dz',order: 3,view: 'text', type: 'string',},
  lxr: {title: 'lxr',order: 4,view: 'text', type: 'string',},
  dh: {title: 'dh',order: 5,view: 'text', type: 'string',},
  lb: {title: 'lb',order: 6,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 7,view: 'text', type: 'string',},
  zt: {title: 'zt',order: 8,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}