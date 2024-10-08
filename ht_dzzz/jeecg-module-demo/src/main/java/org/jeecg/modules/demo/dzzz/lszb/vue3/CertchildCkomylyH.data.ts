import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '证书Id',
    align:"center",
    dataIndex: 'zsid'
   },
   {
    title: '条数',
    align:"center",
    dataIndex: 'ts'
   },
   {
    title: '药品通用名称中文',
    align:"center",
    dataIndex: 'yptymczw'
   },
   {
    title: '药品通用名称英文',
    align:"center",
    dataIndex: 'yptymcyw'
   },
   {
    title: '加工方法中文',
    align:"center",
    dataIndex: 'jgffzw'
   },
   {
    title: '加工方法英文',
    align:"center",
    dataIndex: 'jjffyw'
   },
   {
    title: '中国药品批准文号中文',
    align:"center",
    dataIndex: 'zgyppzwhzw'
   },
   {
    title: '中国药品批准文号英文',
    align:"center",
    dataIndex: 'zgyypzwhyw'
   },
   {
    title: '是否通过我过gmp认证',
    align:"center",
    dataIndex: 'sftgrz'
   },
   {
    title: '状态0正常1删除',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'ylzd1',
    align:"center",
    dataIndex: 'ylzd1'
   },
   {
    title: 'ylzd2',
    align:"center",
    dataIndex: 'ylzd2'
   },
   {
    title: 'ylzd3',
    align:"center",
    dataIndex: 'ylzd3'
   },
   {
    title: 'ylzd4',
    align:"center",
    dataIndex: 'ylzd4'
   },
   {
    title: 'ylzd5',
    align:"center",
    dataIndex: 'ylzd5'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '证书Id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '条数',
    field: 'ts',
    component: 'Input',
  },
  {
    label: '药品通用名称中文',
    field: 'yptymczw',
    component: 'Input',
  },
  {
    label: '药品通用名称英文',
    field: 'yptymcyw',
    component: 'Input',
  },
  {
    label: '加工方法中文',
    field: 'jgffzw',
    component: 'Input',
  },
  {
    label: '加工方法英文',
    field: 'jjffyw',
    component: 'Input',
  },
  {
    label: '中国药品批准文号中文',
    field: 'zgyppzwhzw',
    component: 'Input',
  },
  {
    label: '中国药品批准文号英文',
    field: 'zgyypzwhyw',
    component: 'Input',
  },
  {
    label: '是否通过我过gmp认证',
    field: 'sftgrz',
    component: 'Input',
  },
  {
    label: '状态0正常1删除',
    field: 'zt',
    component: 'Input',
  },
  {
    label: 'ylzd1',
    field: 'ylzd1',
    component: 'Input',
  },
  {
    label: 'ylzd2',
    field: 'ylzd2',
    component: 'Input',
  },
  {
    label: 'ylzd3',
    field: 'ylzd3',
    component: 'Input',
  },
  {
    label: 'ylzd4',
    field: 'ylzd4',
    component: 'Input',
  },
  {
    label: 'ylzd5',
    field: 'ylzd5',
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
  zsid: {title: '证书Id',order: 0,view: 'text', type: 'string',},
  ts: {title: '条数',order: 1,view: 'text', type: 'string',},
  yptymczw: {title: '药品通用名称中文',order: 2,view: 'text', type: 'string',},
  yptymcyw: {title: '药品通用名称英文',order: 3,view: 'text', type: 'string',},
  jgffzw: {title: '加工方法中文',order: 4,view: 'text', type: 'string',},
  jjffyw: {title: '加工方法英文',order: 5,view: 'text', type: 'string',},
  zgyppzwhzw: {title: '中国药品批准文号中文',order: 6,view: 'text', type: 'string',},
  zgyypzwhyw: {title: '中国药品批准文号英文',order: 7,view: 'text', type: 'string',},
  sftgrz: {title: '是否通过我过gmp认证',order: 8,view: 'text', type: 'string',},
  zt: {title: '状态0正常1删除',order: 9,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 10,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 11,view: 'text', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 12,view: 'text', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 13,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 14,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}