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
    title: 'shxydm',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: 'dsfptbafptmc',
    align:"center",
    dataIndex: 'dsfptbafptmc'
   },
   {
    title: 'pzbh',
    align:"center",
    dataIndex: 'pzbh'
   },
   {
    title: 'bz',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: 'xzspid',
    align:"center",
    dataIndex: 'xzspid'
   },
   {
    title: 'num',
    align:"center",
    dataIndex: 'num'
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
    label: 'shxydm',
    field: 'shxydm',
    component: 'Input',
  },
  {
    label: 'dsfptbafptmc',
    field: 'dsfptbafptmc',
    component: 'Input',
  },
  {
    label: 'pzbh',
    field: 'pzbh',
    component: 'Input',
  },
  {
    label: 'bz',
    field: 'bz',
    component: 'InputTextArea',
  },
  {
    label: 'sync',
    field: 'sync',
    component: 'Input',
  },
  {
    label: 'xzspid',
    field: 'xzspid',
    component: 'Input',
  },
  {
    label: 'num',
    field: 'num',
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
  shxydm: {title: 'shxydm',order: 1,view: 'text', type: 'string',},
  dsfptbafptmc: {title: 'dsfptbafptmc',order: 2,view: 'text', type: 'string',},
  pzbh: {title: 'pzbh',order: 3,view: 'text', type: 'string',},
  bz: {title: 'bz',order: 4,view: 'textarea', type: 'string',},
  sync: {title: 'sync',order: 5,view: 'text', type: 'string',},
  xzspid: {title: 'xzspid',order: 6,view: 'text', type: 'string',},
  num: {title: 'num',order: 7,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}