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
    title: 'cpmc',
    align:"center",
    dataIndex: 'cpmc'
   },
   {
    title: 'cpzch',
    align:"center",
    dataIndex: 'cpzch'
   },
   {
    title: 'wtrq',
    align:"center",
    dataIndex: 'wtrq'
   },
   {
    title: 'px',
    align:"center",
    dataIndex: 'px'
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
    label: 'cpmc',
    field: 'cpmc',
    component: 'Input',
  },
  {
    label: 'cpzch',
    field: 'cpzch',
    component: 'Input',
  },
  {
    label: 'wtrq',
    field: 'wtrq',
    component: 'Input',
  },
  {
    label: 'px',
    field: 'px',
    component: 'InputNumber',
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
  cpmc: {title: 'cpmc',order: 1,view: 'text', type: 'string',},
  cpzch: {title: 'cpzch',order: 2,view: 'text', type: 'string',},
  wtrq: {title: 'wtrq',order: 3,view: 'text', type: 'string',},
  px: {title: 'px',order: 4,view: 'number', type: 'number',},
  zt: {title: 'zt',order: 5,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}