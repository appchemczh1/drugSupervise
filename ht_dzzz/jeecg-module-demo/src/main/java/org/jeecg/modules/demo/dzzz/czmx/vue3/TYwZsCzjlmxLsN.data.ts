import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'zdmc',
    align:"center",
    dataIndex: 'zdmc'
   },
   {
    title: 'jz',
    align:"center",
    dataIndex: 'jz'
   },
   {
    title: 'xz',
    align:"center",
    dataIndex: 'xz'
   },
   {
    title: 'czsj',
    align:"center",
    dataIndex: 'czsj',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'bz',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: 'zsczjlid',
    align:"center",
    dataIndex: 'zsczjlid'
   },
   {
    title: 'bm',
    align:"center",
    dataIndex: 'bm'
   },
   {
    title: 'jlid',
    align:"center",
    dataIndex: 'jlid'
   },
   {
    title: 'pxm',
    align:"center",
    dataIndex: 'pxm'
   },
   {
    title: 'pid',
    align:"center",
    dataIndex: 'pid'
   },
   {
    title: 'zdzwmc',
    align:"center",
    dataIndex: 'zdzwmc'
   },
   {
    title: 'bgcs',
    align:"center",
    dataIndex: 'bgcs'
   },
   {
    title: 'synctime',
    align:"center",
    dataIndex: 'synctime'
   },
   {
    title: 'issc',
    align:"center",
    dataIndex: 'issc'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'zdmc',
    field: 'zdmc',
    component: 'Input',
  },
  {
    label: 'jz',
    field: 'jz',
    component: 'InputTextArea',
  },
  {
    label: 'xz',
    field: 'xz',
    component: 'InputTextArea',
  },
  {
    label: 'czsj',
    field: 'czsj',
    component: 'DatePicker',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'InputNumber',
  },
  {
    label: 'bz',
    field: 'bz',
    component: 'InputTextArea',
  },
  {
    label: 'zsczjlid',
    field: 'zsczjlid',
    component: 'Input',
  },
  {
    label: 'bm',
    field: 'bm',
    component: 'Input',
  },
  {
    label: 'jlid',
    field: 'jlid',
    component: 'Input',
  },
  {
    label: 'pxm',
    field: 'pxm',
    component: 'InputNumber',
  },
  {
    label: 'pid',
    field: 'pid',
    component: 'Input',
  },
  {
    label: 'zdzwmc',
    field: 'zdzwmc',
    component: 'Input',
  },
  {
    label: 'bgcs',
    field: 'bgcs',
    component: 'InputNumber',
  },
  {
    label: 'synctime',
    field: 'synctime',
    component: 'Input',
  },
  {
    label: 'issc',
    field: 'issc',
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
  zdmc: {title: 'zdmc',order: 0,view: 'text', type: 'string',},
  jz: {title: 'jz',order: 1,view: 'textarea', type: 'string',},
  xz: {title: 'xz',order: 2,view: 'textarea', type: 'string',},
  czsj: {title: 'czsj',order: 3,view: 'date', type: 'string',},
  zt: {title: 'zt',order: 4,view: 'number', type: 'number',},
  bz: {title: 'bz',order: 5,view: 'textarea', type: 'string',},
  zsczjlid: {title: 'zsczjlid',order: 6,view: 'text', type: 'string',},
  bm: {title: 'bm',order: 7,view: 'text', type: 'string',},
  jlid: {title: 'jlid',order: 8,view: 'text', type: 'string',},
  pxm: {title: 'pxm',order: 9,view: 'number', type: 'number',},
  pid: {title: 'pid',order: 10,view: 'text', type: 'string',},
  zdzwmc: {title: 'zdzwmc',order: 11,view: 'text', type: 'string',},
  bgcs: {title: 'bgcs',order: 12,view: 'number', type: 'number',},
  synctime: {title: 'synctime',order: 13,view: 'text', type: 'string',},
  issc: {title: 'issc',order: 14,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}