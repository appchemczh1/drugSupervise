import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {getAllRolesListNoByTenant} from "@/views/system/user/user.api";
import {
getcertmetelist
} from '../../dzzz/certinfo/CertInfo.api';
import {defHttp} from "@/utils/http/axios";
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '角色名',
    align:"center",
    dataIndex: 'rolename'
   },
   {
    title: '启用状态',
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
    label: '角色',
    field: 'rolename',
    component: 'ApiSelect',
    componentProps: {
      mode: 'multiple',
      api: getAllRolesListNoByTenant,
      labelField: 'roleName',
      valueField: 'id',
      immediate: false,
    },
  },
  {
    label: '启用状态',
    field: 'zt',
    component: 'RadioGroup',
    defaultValue: 1,
    componentProps: ({ formModel }) => {
      return {
        options: [
          { label: '启用', value: 1, key: '1' },
          { label: '不启用', value: 0, key: '0' },
        ],
      };
    },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
export const formSchemaset: FormSchema[] = [

      /*mode: 'multiple',
      api: getAllRolesListNoByTenant,
      labelField: 'roleName',
      valueField: 'id',
      immediate: false,
    },*/

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
  rolename: {title: '角色名',order: 0,view: 'text', type: 'string',},
  zt: {title: '启用状态',order: 1,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
