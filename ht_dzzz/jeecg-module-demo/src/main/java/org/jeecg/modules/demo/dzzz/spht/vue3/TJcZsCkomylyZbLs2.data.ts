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
    title: 'yptymczw',
    align:"center",
    dataIndex: 'yptymczw'
   },
   {
    title: 'yptymcyw',
    align:"center",
    dataIndex: 'yptymcyw'
   },
   {
    title: 'jgffzw',
    align:"center",
    dataIndex: 'jgffzw'
   },
   {
    title: 'jgffyw',
    align:"center",
    dataIndex: 'jgffyw'
   },
   {
    title: 'zgyppzwhzw',
    align:"center",
    dataIndex: 'zgyppzwhzw'
   },
   {
    title: 'zgyppzwhyw',
    align:"center",
    dataIndex: 'zgyppzwhyw'
   },
   {
    title: 'sftgrz',
    align:"center",
    dataIndex: 'sftgrz'
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
    component: 'InputNumber',
  },
  {
    label: 'yptymczw',
    field: 'yptymczw',
    component: 'Input',
  },
  {
    label: 'yptymcyw',
    field: 'yptymcyw',
    component: 'Input',
  },
  {
    label: 'jgffzw',
    field: 'jgffzw',
    component: 'Input',
  },
  {
    label: 'jgffyw',
    field: 'jgffyw',
    component: 'Input',
  },
  {
    label: 'zgyppzwhzw',
    field: 'zgyppzwhzw',
    component: 'Input',
  },
  {
    label: 'zgyppzwhyw',
    field: 'zgyppzwhyw',
    component: 'Input',
  },
  {
    label: 'sftgrz',
    field: 'sftgrz',
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
  num: {title: 'num',order: 1,view: 'number', type: 'number',},
  yptymczw: {title: 'yptymczw',order: 2,view: 'text', type: 'string',},
  yptymcyw: {title: 'yptymcyw',order: 3,view: 'text', type: 'string',},
  jgffzw: {title: 'jgffzw',order: 4,view: 'text', type: 'string',},
  jgffyw: {title: 'jgffyw',order: 5,view: 'text', type: 'string',},
  zgyppzwhzw: {title: 'zgyppzwhzw',order: 6,view: 'text', type: 'string',},
  zgyppzwhyw: {title: 'zgyppzwhyw',order: 7,view: 'text', type: 'string',},
  sftgrz: {title: 'sftgrz',order: 8,view: 'text', type: 'string',},
  zt: {title: 'zt',order: 9,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}