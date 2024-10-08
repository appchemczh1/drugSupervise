import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'authname',
    align:"center",
    dataIndex: 'authname'
   },
   {
    title: 'authrange',
    align:"center",
    dataIndex: 'authrange'
   },
   {
    title: 'passauthdate',
    align:"center",
    dataIndex: 'passauthdate'
   },
   {
    title: 'authorg',
    align:"center",
    dataIndex: 'authorg'
   },
   {
    title: 'countryname',
    align:"center",
    dataIndex: 'countryname'
   },
   {
    title: 'varietyname',
    align:"center",
    dataIndex: 'varietyname'
   },
   {
    title: 'remark',
    align:"center",
    dataIndex: 'remark'
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'entid',
    align:"center",
    dataIndex: 'entid'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
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
    label: 'authname',
    field: 'authname',
    component: 'Input',
  },
  {
    label: 'authrange',
    field: 'authrange',
    component: 'Input',
  },
  {
    label: 'passauthdate',
    field: 'passauthdate',
    component: 'Input',
  },
  {
    label: 'authorg',
    field: 'authorg',
    component: 'Input',
  },
  {
    label: 'countryname',
    field: 'countryname',
    component: 'Input',
  },
  {
    label: 'varietyname',
    field: 'varietyname',
    component: 'Input',
  },
  {
    label: 'remark',
    field: 'remark',
    component: 'Input',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'Input',
  },
  {
    label: 'entid',
    field: 'entid',
    component: 'Input',
  },
  {
    label: 'sync',
    field: 'sync',
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
  authname: {title: 'authname',order: 0,view: 'text', type: 'string',},
  authrange: {title: 'authrange',order: 1,view: 'text', type: 'string',},
  passauthdate: {title: 'passauthdate',order: 2,view: 'text', type: 'string',},
  authorg: {title: 'authorg',order: 3,view: 'text', type: 'string',},
  countryname: {title: 'countryname',order: 4,view: 'text', type: 'string',},
  varietyname: {title: 'varietyname',order: 5,view: 'text', type: 'string',},
  remark: {title: 'remark',order: 6,view: 'text', type: 'string',},
  zt: {title: 'zt',order: 7,view: 'text', type: 'string',},
  entid: {title: 'entid',order: 8,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 9,view: 'text', type: 'string',},
  instanceno: {title: 'instanceno',order: 10,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}