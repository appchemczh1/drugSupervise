import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '证照类型编码',
    align:"center",
    dataIndex: 'certtypecode'
   },
   {
    title: '证书类型名称',
    align:"center",
    dataIndex: 'certtypename'
   },

   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText',
     width: 140,
   },
   {
    title: '证书分类',
    align:"center",
    dataIndex: 'certtypeClassification_dictText',
     width: 160,
   },
  {
    title: '显示顺序',
    align:"center",
    sorter: true,
    dataIndex: 'ordernum',
    width: 140,
  },
  /* {
    title: '企业类型',
    align:"center",
    dataIndex: 'qytype_dictText'
   },*/
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "证照类型编码",
      field: 'certtypecode',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "证书类型名称",
      field: 'certtypename',
      component: 'JInput',
      //colProps: {span: 6},
 	},
	{
      label: "状态",
      field: 'status',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"certtypestatus"
      },
      //colProps: {span: 6},
 	},
	{
      label: "证书分类",
      field: 'certtypeClassification',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"cert_type_lx"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '证照类型编码',
    field: 'certtypecode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证照类型编码!'},
          ];
     },
  },
  {
    label: '证书类型名称',
    field: 'certtypename',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书类型名称!'},
          ];
     },
  },
  {
    label: '显示顺序',
    field: 'ordernum',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"certtypestatus"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '证书分类',
    field: 'certtypeClassification',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cert_type_lx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入证书分类!'},
          ];
     },
  },
  {
    label: '企业类型',
    field: 'qytype',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"qytype"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入企业类型!'},
          ];
     },
  },
  {
    label: '是否公示',
    field: 'isgs',
    defaultValue: "1",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否公示!'},
          ];
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

// 高级查询数据
export const superQuerySchema = {
  certtypecode: {title: '证照类型编码',order: 0,view: 'text', type: 'string',},
  certtypename: {title: '证书类型名称',order: 1,view: 'text', type: 'string',},
  ordernum: {title: '显示顺序',order: 2,view: 'text', type: 'string',},
  status: {title: '状态',order: 3,view: 'list', type: 'string',dictCode: 'certtypestatus',},
  certtypeClassification: {title: '证书分类',order: 4,view: 'list', type: 'string',dictCode: 'cert_type_lx',},
  qytype: {title: '企业类型',order: 5,view: 'list_multi', type: 'string',dictCode: 'qytype',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
