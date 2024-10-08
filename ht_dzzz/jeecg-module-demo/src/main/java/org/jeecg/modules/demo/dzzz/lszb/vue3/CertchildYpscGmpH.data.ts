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
    title: '认证(检查)名称',
    align:"center",
    dataIndex: 'authname'
   },
   {
    title: '认证(检查)范围',
    align:"center",
    dataIndex: 'authrange'
   },
   {
    title: '通过认证(检查)时间',
    align:"center",
    dataIndex: 'passauthdate'
   },
   {
    title: '认证(检查)机构名称',
    align:"center",
    dataIndex: 'authorg'
   },
   {
    title: '国家(地区、组织)名称',
    align:"center",
    dataIndex: 'countryname'
   },
   {
    title: '涉及品种名称',
    align:"center",
    dataIndex: 'sjpzmc'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: '企业id',
    align:"center",
    dataIndex: 'qyid'
   },
   {
    title: '0正常1删除',
    align:"center",
    dataIndex: 'sfsc'
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
    label: '认证(检查)名称',
    field: 'authname',
    component: 'Input',
  },
  {
    label: '认证(检查)范围',
    field: 'authrange',
    component: 'Input',
  },
  {
    label: '通过认证(检查)时间',
    field: 'passauthdate',
    component: 'Input',
  },
  {
    label: '认证(检查)机构名称',
    field: 'authorg',
    component: 'Input',
  },
  {
    label: '国家(地区、组织)名称',
    field: 'countryname',
    component: 'Input',
  },
  {
    label: '涉及品种名称',
    field: 'sjpzmc',
    component: 'InputTextArea',
  },
  {
    label: '备注',
    field: 'bz',
    component: 'InputTextArea',
  },
  {
    label: '状态',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '企业id',
    field: 'qyid',
    component: 'Input',
  },
  {
    label: '0正常1删除',
    field: 'sfsc',
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
  authname: {title: '认证(检查)名称',order: 1,view: 'text', type: 'string',},
  authrange: {title: '认证(检查)范围',order: 2,view: 'text', type: 'string',},
  passauthdate: {title: '通过认证(检查)时间',order: 3,view: 'text', type: 'string',},
  authorg: {title: '认证(检查)机构名称',order: 4,view: 'text', type: 'string',},
  countryname: {title: '国家(地区、组织)名称',order: 5,view: 'text', type: 'string',},
  sjpzmc: {title: '涉及品种名称',order: 6,view: 'textarea', type: 'string',},
  bz: {title: '备注',order: 7,view: 'textarea', type: 'string',},
  zt: {title: '状态',order: 8,view: 'text', type: 'string',},
  qyid: {title: '企业id',order: 9,view: 'text', type: 'string',},
  sfsc: {title: '0正常1删除',order: 10,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 11,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 12,view: 'text', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 13,view: 'text', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 14,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 15,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}