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
    title: 'cpbah',
    align:"center",
    dataIndex: 'cpbah'
   },
   {
    title: 'dzrq',
    align:"center",
    dataIndex: 'dzrq',
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
    label: 'cpbah',
    field: 'cpbah',
    component: 'Input',
  },
  {
    label: 'dzrq',
    field: 'dzrq',
    component: 'DatePicker',
  },
  {
    label: 'bz',
    field: 'bz',
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
  cpbah: {title: 'cpbah',order: 2,view: 'text', type: 'string',},
  dzrq: {title: 'dzrq',order: 3,view: 'date', type: 'string',},
  bz: {title: 'bz',order: 4,view: 'text', type: 'string',},
  px: {title: 'px',order: 5,view: 'number', type: 'number',},
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