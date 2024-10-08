import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes} from "@/components/jeecg/JVxeTable/src/types";
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '证书类型名称',
    align:"center",
    dataIndex: 'licenseTypeName'
   },
   {
    title: '业务类型',
    align:"center",
    dataIndex: 'ywlx_dictText',


   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '证书类型名称',
    field: 'licenseTypeName',
    component: 'JPopup',
    componentProps: ({formActionType}) => {
      const {setFieldsValue} = formActionType;
      return {
        setFieldsValue: setFieldsValue,
        code: "certtypename",
        fieldConfig: [
          {source: 'certtypename', target: 'licenseTypeName'}
        ],

      }
    },
  },
  {
    label: '数据来源',
    field: 'v01',
    component: 'Select',
    componentProps:{
      options: [
        { label: '药监许可', value: '1' },
        { label: '市场许可', value: '2' },
        { label: '系统录入', value: '3' },
        { label: '地市接口', value: '4' },
      ],
    }
  },
  {
    label: '业务类型',
    field: 'ywlx',
    component: 'JSelectMultiple',
    componentProps:{
      dictCode:"changetype"
    }

  },
  {
    label: '状态',
    field: 'status',
    component: 'RadioGroup',
    defaultValue:"1",
    componentProps:{
      options: [
        {
          label: '启用',
          value: '1',
        },
        {
          label: '禁用',
          value: '0',
        },
      ],
    }
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
