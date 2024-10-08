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
    title: 'gg',
    align:"center",
    dataIndex: 'gg'
   },
   {
    title: 'bh',
    align:"center",
    dataIndex: 'bh'
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
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
    component: 'InputTextArea',
  },
  {
    label: 'gg',
    field: 'gg',
    component: 'InputTextArea',
  },
  {
    label: 'bh',
    field: 'bh',
    component: 'InputTextArea',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'InputNumber',
  },
  {
    label: 'sync',
    field: 'sync',
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
  zsid: {title: 'zsid',order: 0,view: 'text', type: 'string',},
  num: {title: 'num',order: 1,view: 'text', type: 'string',},
  mc: {title: 'mc',order: 2,view: 'textarea', type: 'string',},
  gg: {title: 'gg',order: 3,view: 'textarea', type: 'string',},
  bh: {title: 'bh',order: 4,view: 'textarea', type: 'string',},
  zt: {title: 'zt',order: 5,view: 'number', type: 'number',},
  sync: {title: 'sync',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}