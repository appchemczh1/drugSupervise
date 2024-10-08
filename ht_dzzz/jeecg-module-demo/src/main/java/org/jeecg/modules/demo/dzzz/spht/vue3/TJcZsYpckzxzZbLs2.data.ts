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
    title: 'ckywmc',
    align:"center",
    dataIndex: 'ckywmc'
   },
   {
    title: 'ckywywmc',
    align:"center",
    dataIndex: 'ckywywmc'
   },
   {
    title: 'spbm',
    align:"center",
    dataIndex: 'spbm'
   },
   {
    title: 'jx',
    align:"center",
    dataIndex: 'jx'
   },
   {
    title: 'ckywbz',
    align:"center",
    dataIndex: 'ckywbz'
   },
   {
    title: 'ckywgz',
    align:"center",
    dataIndex: 'ckywgz'
   },
   {
    title: 'ckywsl',
    align:"center",
    dataIndex: 'ckywsl'
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
    label: 'ckywmc',
    field: 'ckywmc',
    component: 'Input',
  },
  {
    label: 'ckywywmc',
    field: 'ckywywmc',
    component: 'Input',
  },
  {
    label: 'spbm',
    field: 'spbm',
    component: 'Input',
  },
  {
    label: 'jx',
    field: 'jx',
    component: 'Input',
  },
  {
    label: 'ckywbz',
    field: 'ckywbz',
    component: 'Input',
  },
  {
    label: 'ckywgz',
    field: 'ckywgz',
    component: 'Input',
  },
  {
    label: 'ckywsl',
    field: 'ckywsl',
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
  ckywmc: {title: 'ckywmc',order: 2,view: 'text', type: 'string',},
  ckywywmc: {title: 'ckywywmc',order: 3,view: 'text', type: 'string',},
  spbm: {title: 'spbm',order: 4,view: 'text', type: 'string',},
  jx: {title: 'jx',order: 5,view: 'text', type: 'string',},
  ckywbz: {title: 'ckywbz',order: 6,view: 'text', type: 'string',},
  ckywgz: {title: 'ckywgz',order: 7,view: 'text', type: 'string',},
  ckywsl: {title: 'ckywsl',order: 8,view: 'text', type: 'string',},
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