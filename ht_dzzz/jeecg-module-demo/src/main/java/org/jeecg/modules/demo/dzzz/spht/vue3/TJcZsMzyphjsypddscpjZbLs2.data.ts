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
    title: 'ypmc',
    align:"center",
    dataIndex: 'ypmc'
   },
   {
    title: 'jy',
    align:"center",
    dataIndex: 'jy'
   },
   {
    title: 'gg',
    align:"center",
    dataIndex: 'gg'
   },
   {
    title: 'gzlb',
    align:"center",
    dataIndex: 'gzlb'
   },
   {
    title: 'pzwh',
    align:"center",
    dataIndex: 'pzwh'
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
    label: 'ypmc',
    field: 'ypmc',
    component: 'Input',
  },
  {
    label: 'jy',
    field: 'jy',
    component: 'Input',
  },
  {
    label: 'gg',
    field: 'gg',
    component: 'Input',
  },
  {
    label: 'gzlb',
    field: 'gzlb',
    component: 'Input',
  },
  {
    label: 'pzwh',
    field: 'pzwh',
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
  ypmc: {title: 'ypmc',order: 2,view: 'text', type: 'string',},
  jy: {title: 'jy',order: 3,view: 'text', type: 'string',},
  gg: {title: 'gg',order: 4,view: 'text', type: 'string',},
  gzlb: {title: 'gzlb',order: 5,view: 'text', type: 'string',},
  pzwh: {title: 'pzwh',order: 6,view: 'text', type: 'string',},
  zt: {title: 'zt',order: 7,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}