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
    title: 'refcompaddr',
    align:"center",
    dataIndex: 'refcompaddr'
   },
   {
    title: 'workshop',
    align:"center",
    dataIndex: 'workshop'
   },
   {
    title: 'refcompname',
    align:"center",
    dataIndex: 'refcompname'
   },
   {
    title: 'refcompid',
    align:"center",
    dataIndex: 'refcompid'
   },
   {
    title: 'preparation',
    align:"center",
    dataIndex: 'preparation'
   },
   {
    title: 'drugtype',
    align:"center",
    dataIndex: 'drugtype'
   },
   {
    title: 'drugname',
    align:"center",
    dataIndex: 'drugname'
   },
   {
    title: 'cordrugid',
    align:"center",
    dataIndex: 'cordrugid'
   },
   {
    title: 'regnumb',
    align:"center",
    dataIndex: 'regnumb'
   },
   {
    title: 'drugdose',
    align:"center",
    dataIndex: 'drugdose'
   },
   {
    title: 'spec',
    align:"center",
    dataIndex: 'spec'
   },
   {
    title: 'entrustvalidate',
    align:"center",
    dataIndex: 'entrustvalidate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
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
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'bgqid',
    align:"center",
    dataIndex: 'bgqid'
   },
   {
    title: 'addrdetail',
    align:"center",
    dataIndex: 'addrdetail'
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
    title: 'regnumbvalidate',
    align:"center",
    dataIndex: 'regnumbvalidate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
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
    label: 'refcompaddr',
    field: 'refcompaddr',
    component: 'Input',
  },
  {
    label: 'workshop',
    field: 'workshop',
    component: 'Input',
  },
  {
    label: 'refcompname',
    field: 'refcompname',
    component: 'Input',
  },
  {
    label: 'refcompid',
    field: 'refcompid',
    component: 'Input',
  },
  {
    label: 'preparation',
    field: 'preparation',
    component: 'Input',
  },
  {
    label: 'drugtype',
    field: 'drugtype',
    component: 'Input',
  },
  {
    label: 'drugname',
    field: 'drugname',
    component: 'Input',
  },
  {
    label: 'cordrugid',
    field: 'cordrugid',
    component: 'Input',
  },
  {
    label: 'regnumb',
    field: 'regnumb',
    component: 'Input',
  },
  {
    label: 'drugdose',
    field: 'drugdose',
    component: 'Input',
  },
  {
    label: 'spec',
    field: 'spec',
    component: 'Input',
  },
  {
    label: 'entrustvalidate',
    field: 'entrustvalidate',
    component: 'DatePicker',
  },
  {
    label: 'productionscope',
    field: 'productionscope',
    component: 'InputTextArea',
  },
  {
    label: 'productionscopef',
    field: 'productionscopef',
    component: 'InputTextArea',
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
    component: 'InputTextArea',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'Input',
  },
  {
    label: 'bgqid',
    field: 'bgqid',
    component: 'Input',
  },
  {
    label: 'addrdetail',
    field: 'addrdetail',
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
    label: 'regnumbvalidate',
    field: 'regnumbvalidate',
    component: 'DatePicker',
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
  refcompaddr: {title: 'refcompaddr',order: 1,view: 'text', type: 'string',},
  workshop: {title: 'workshop',order: 2,view: 'text', type: 'string',},
  refcompname: {title: 'refcompname',order: 3,view: 'text', type: 'string',},
  refcompid: {title: 'refcompid',order: 4,view: 'text', type: 'string',},
  preparation: {title: 'preparation',order: 5,view: 'text', type: 'string',},
  drugtype: {title: 'drugtype',order: 6,view: 'text', type: 'string',},
  drugname: {title: 'drugname',order: 7,view: 'text', type: 'string',},
  cordrugid: {title: 'cordrugid',order: 8,view: 'text', type: 'string',},
  regnumb: {title: 'regnumb',order: 9,view: 'text', type: 'string',},
  drugdose: {title: 'drugdose',order: 10,view: 'text', type: 'string',},
  spec: {title: 'spec',order: 11,view: 'text', type: 'string',},
  entrustvalidate: {title: 'entrustvalidate',order: 12,view: 'date', type: 'string',},
  productionscope: {title: 'productionscope',order: 13,view: 'textarea', type: 'string',},
  productionscopef: {title: 'productionscopef',order: 14,view: 'textarea', type: 'string',},
  throughput: {title: 'throughput',order: 15,view: 'text', type: 'string',},
  calculationunit: {title: 'calculationunit',order: 16,view: 'text', type: 'string',},
  preparationnumber: {title: 'preparationnumber',order: 17,view: 'text', type: 'string',},
  getgmpcertificate: {title: 'getgmpcertificate',order: 18,view: 'text', type: 'string',},
  gmprzscope: {title: 'gmprzscope',order: 19,view: 'textarea', type: 'string',},
  zt: {title: 'zt',order: 20,view: 'text', type: 'string',},
  bgqid: {title: 'bgqid',order: 21,view: 'text', type: 'string',},
  addrdetail: {title: 'addrdetail',order: 22,view: 'text', type: 'string',},
  zsid: {title: 'zsid',order: 23,view: 'text', type: 'string',},
  createtime: {title: 'createtime',order: 24,view: 'date', type: 'string',},
  gzrq: {title: 'gzrq',order: 25,view: 'date', type: 'string',},
  productionscopecode: {title: 'productionscopecode',order: 26,view: 'text', type: 'string',},
  regnumbvalidate: {title: 'regnumbvalidate',order: 27,view: 'date', type: 'string',},
  hfrq: {title: 'hfrq',order: 28,view: 'date', type: 'string',},
  xzspid: {title: 'xzspid',order: 29,view: 'text', type: 'string',},
  ggflag: {title: 'ggflag',order: 30,view: 'text', type: 'string',},
  isgmp: {title: 'isgmp',order: 31,view: 'text', type: 'string',},
  throughput1: {title: 'throughput1',order: 32,view: 'text', type: 'string',},
  preparationnumber1: {title: 'preparationnumber1',order: 33,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 34,view: 'text', type: 'string',},
  num: {title: 'num',order: 35,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}