import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '编码值',
    align:"center",
    dataIndex: 'areacode'
   },
   {
    title: '区划名称',
    align:"center",
    dataIndex: 'areaname'
   },
   {
    title: '父id',
    align:"center",
    dataIndex: 'parentid'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '编码值',
    field: 'areacode',
    component: 'Input',
  },
  {
    label: '区划名称',
    field: 'areaname',
    component: 'Input',
  },
  {
    label: '父id',
    field: 'parentid',
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
  areacode: {title: '编码值',order: 0,view: 'text', type: 'string',},
  areaname: {title: '区划名称',order: 1,view: 'text', type: 'string',},
  parentid: {title: '父id',order: 2,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}