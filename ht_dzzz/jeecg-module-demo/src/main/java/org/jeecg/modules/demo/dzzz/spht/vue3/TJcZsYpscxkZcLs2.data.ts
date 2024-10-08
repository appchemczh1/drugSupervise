import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'protype',
    align:"center",
    dataIndex: 'protype'
   },
   {
    title: 'workshop',
    align:"center",
    dataIndex: 'workshop'
   },
   {
    title: 'preparation',
    align:"center",
    dataIndex: 'preparation'
   },
   {
    title: 'productionscope',
    align:"center",
    dataIndex: 'productionscope'
   },
   {
    title: 'productionscopef',
    align:"center",
    dataIndex: 'productionscopef'
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'addrdetail',
    align:"center",
    dataIndex: 'addrdetail'
   },
   {
    title: 'throughput',
    align:"center",
    dataIndex: 'throughput'
   },
   {
    title: 'calculationunit',
    align:"center",
    dataIndex: 'calculationunit'
   },
   {
    title: 'preparationnumber',
    align:"center",
    dataIndex: 'preparationnumber'
   },
   {
    title: 'getgmpcertificate',
    align:"center",
    dataIndex: 'getgmpcertificate'
   },
   {
    title: 'gmprzscope',
    align:"center",
    dataIndex: 'gmprzscope'
   },
   {
    title: 'bgqid',
    align:"center",
    dataIndex: 'bgqid'
   },
   {
    title: 'zsid',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: 'createtime',
    align:"center",
    dataIndex: 'createtime',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'gzrq',
    align:"center",
    dataIndex: 'gzrq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'productionscopecode',
    align:"center",
    dataIndex: 'productionscopecode'
   },
   {
    title: 'hfrq',
    align:"center",
    dataIndex: 'hfrq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'xzspid',
    align:"center",
    dataIndex: 'xzspid'
   },
   {
    title: 'ggflag',
    align:"center",
    dataIndex: 'ggflag'
   },
   {
    title: 'isgmp',
    align:"center",
    dataIndex: 'isgmp'
   },
   {
    title: 'throughput1',
    align:"center",
    dataIndex: 'throughput1'
   },
   {
    title: 'preparationnumber1',
    align:"center",
    dataIndex: 'preparationnumber1'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: 'num',
    align:"center",
    dataIndex: 'num'
   },
   {
    title: 'instanceno',
    align:"center",
    dataIndex: 'instanceno'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'protype',
    field: 'protype',
    component: 'Input',
  },
  {
    label: 'workshop',
    field: 'workshop',
    component: 'Input',
  },
  {
    label: 'preparation',
    field: 'preparation',
    component: 'Input',
  },
  {
    label: 'productionscope',
    field: 'productionscope',
    component: 'Input',
  },
  {
    label: 'productionscopef',
    field: 'productionscopef',
    component: 'InputTextArea',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'Input',
  },
  {
    label: 'addrdetail',
    field: 'addrdetail',
    component: 'Input',
  },
  {
    label: 'throughput',
    field: 'throughput',
    component: 'Input',
  },
  {
    label: 'calculationunit',
    field: 'calculationunit',
    component: 'Input',
  },
  {
    label: 'preparationnumber',
    field: 'preparationnumber',
    component: 'Input',
  },
  {
    label: 'getgmpcertificate',
    field: 'getgmpcertificate',
    component: 'Input',
  },
  {
    label: 'gmprzscope',
    field: 'gmprzscope',
    component: 'Input',
  },
  {
    label: 'bgqid',
    field: 'bgqid',
    component: 'Input',
  },
  {
    label: 'zsid',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: 'createtime',
    field: 'createtime',
    component: 'DatePicker',
  },
  {
    label: 'gzrq',
    field: 'gzrq',
    component: 'DatePicker',
  },
  {
    label: 'productionscopecode',
    field: 'productionscopecode',
    component: 'Input',
  },
  {
    label: 'hfrq',
    field: 'hfrq',
    component: 'DatePicker',
  },
  {
    label: 'xzspid',
    field: 'xzspid',
    component: 'Input',
  },
  {
    label: 'ggflag',
    field: 'ggflag',
    component: 'Input',
  },
  {
    label: 'isgmp',
    field: 'isgmp',
    component: 'Input',
  },
  {
    label: 'throughput1',
    field: 'throughput1',
    component: 'Input',
  },
  {
    label: 'preparationnumber1',
    field: 'preparationnumber1',
    component: 'Input',
  },
  {
    label: 'sync',
    field: 'sync',
    component: 'Input',
  },
  {
    label: 'num',
    field: 'num',
    component: 'Input',
  },
  {
    label: 'instanceno',
    field: 'instanceno',
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
  protype: {title: 'protype',order: 0,view: 'text', type: 'string',},
  workshop: {title: 'workshop',order: 1,view: 'text', type: 'string',},
  preparation: {title: 'preparation',order: 2,view: 'text', type: 'string',},
  productionscope: {title: 'productionscope',order: 3,view: 'text', type: 'string',},
  productionscopef: {title: 'productionscopef',order: 4,view: 'textarea', type: 'string',},
  zt: {title: 'zt',order: 5,view: 'text', type: 'string',},
  addrdetail: {title: 'addrdetail',order: 6,view: 'text', type: 'string',},
  throughput: {title: 'throughput',order: 7,view: 'text', type: 'string',},
  calculationunit: {title: 'calculationunit',order: 8,view: 'text', type: 'string',},
  preparationnumber: {title: 'preparationnumber',order: 9,view: 'text', type: 'string',},
  getgmpcertificate: {title: 'getgmpcertificate',order: 10,view: 'text', type: 'string',},
  gmprzscope: {title: 'gmprzscope',order: 11,view: 'text', type: 'string',},
  bgqid: {title: 'bgqid',order: 12,view: 'text', type: 'string',},
  zsid: {title: 'zsid',order: 13,view: 'text', type: 'string',},
  createtime: {title: 'createtime',order: 14,view: 'date', type: 'string',},
  gzrq: {title: 'gzrq',order: 15,view: 'date', type: 'string',},
  productionscopecode: {title: 'productionscopecode',order: 16,view: 'text', type: 'string',},
  hfrq: {title: 'hfrq',order: 17,view: 'date', type: 'string',},
  xzspid: {title: 'xzspid',order: 18,view: 'text', type: 'string',},
  ggflag: {title: 'ggflag',order: 19,view: 'text', type: 'string',},
  isgmp: {title: 'isgmp',order: 20,view: 'text', type: 'string',},
  throughput1: {title: 'throughput1',order: 21,view: 'text', type: 'string',},
  preparationnumber1: {title: 'preparationnumber1',order: 22,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 23,view: 'text', type: 'string',},
  num: {title: 'num',order: 24,view: 'text', type: 'string',},
  instanceno: {title: 'instanceno',order: 25,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}