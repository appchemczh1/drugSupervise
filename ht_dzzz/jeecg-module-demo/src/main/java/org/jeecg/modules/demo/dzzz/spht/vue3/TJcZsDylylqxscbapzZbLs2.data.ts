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
    title: 'zczh',
    align:"center",
    dataIndex: 'zczh'
   },
   {
    title: 'cplbDm',
    align:"center",
    dataIndex: 'cplbDm'
   },
   {
    title: 'sfwtsc',
    align:"center",
    dataIndex: 'sfwtsc'
   },
   {
    title: 'zcbarmc',
    align:"center",
    dataIndex: 'zcbarmc'
   },
   {
    title: 'zcbardz',
    align:"center",
    dataIndex: 'zcbardz'
   },
   {
    title: 'shxydm',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: 'wtqx',
    align:"center",
    dataIndex: 'wtqx',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'bz',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: 'cpmc',
    align:"center",
    dataIndex: 'cpmc'
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
    label: 'zczh',
    field: 'zczh',
    component: 'Input',
  },
  {
    label: 'cplbDm',
    field: 'cplbDm',
    component: 'Input',
  },
  {
    label: 'sfwtsc',
    field: 'sfwtsc',
    component: 'Input',
  },
  {
    label: 'zcbarmc',
    field: 'zcbarmc',
    component: 'Input',
  },
  {
    label: 'zcbardz',
    field: 'zcbardz',
    component: 'Input',
  },
  {
    label: 'shxydm',
    field: 'shxydm',
    component: 'Input',
  },
  {
    label: 'wtqx',
    field: 'wtqx',
    component: 'DatePicker',
  },
  {
    label: 'bz',
    field: 'bz',
    component: 'Input',
  },
  {
    label: 'cpmc',
    field: 'cpmc',
    component: 'Input',
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
  zczh: {title: 'zczh',order: 1,view: 'text', type: 'string',},
  cplbDm: {title: 'cplbDm',order: 2,view: 'text', type: 'string',},
  sfwtsc: {title: 'sfwtsc',order: 3,view: 'text', type: 'string',},
  zcbarmc: {title: 'zcbarmc',order: 4,view: 'text', type: 'string',},
  zcbardz: {title: 'zcbardz',order: 5,view: 'text', type: 'string',},
  shxydm: {title: 'shxydm',order: 6,view: 'text', type: 'string',},
  wtqx: {title: 'wtqx',order: 7,view: 'date', type: 'string',},
  bz: {title: 'bz',order: 8,view: 'text', type: 'string',},
  cpmc: {title: 'cpmc',order: 9,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 10,view: 'text', type: 'string',},
  xzspid: {title: 'xzspid',order: 11,view: 'text', type: 'string',},
  num: {title: 'num',order: 12,view: 'number', type: 'number',},
  zt: {title: 'zt',order: 13,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}