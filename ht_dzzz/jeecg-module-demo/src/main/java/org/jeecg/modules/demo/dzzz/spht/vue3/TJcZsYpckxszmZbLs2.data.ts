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
    title: 'jkgjzw',
    align:"center",
    dataIndex: 'jkgjzw'
   },
   {
    title: 'jkgjyw',
    align:"center",
    dataIndex: 'jkgjyw'
   },
   {
    title: 'cksl',
    align:"center",
    dataIndex: 'cksl'
   },
   {
    title: 'lx',
    align:"center",
    dataIndex: 'lx'
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
    label: 'jkgjzw',
    field: 'jkgjzw',
    component: 'Input',
  },
  {
    label: 'jkgjyw',
    field: 'jkgjyw',
    component: 'Input',
  },
  {
    label: 'cksl',
    field: 'cksl',
    component: 'Input',
  },
  {
    label: 'lx',
    field: 'lx',
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
  jkgjzw: {title: 'jkgjzw',order: 2,view: 'text', type: 'string',},
  jkgjyw: {title: 'jkgjyw',order: 3,view: 'text', type: 'string',},
  cksl: {title: 'cksl',order: 4,view: 'text', type: 'string',},
  lx: {title: 'lx',order: 5,view: 'text', type: 'string',},
  zt: {title: 'zt',order: 6,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}