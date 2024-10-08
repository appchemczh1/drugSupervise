import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '列标识',
    align:"center",
    dataIndex: 'lbs'
   },
   {
    title: '列名称',
    align:"center",
    dataIndex: 'lm'
   },
   {
    title: '字段类型',
    align:"center",
    dataIndex: 'zdlx'
   },
   {
    title: '字段长度',
    align:"center",
    dataIndex: 'zdcd'
   },
   {
    title: '默认值',
    align:"center",
    dataIndex: 'mrz'
   },
   {
    title: '映射属性',
    align:"center",
    dataIndex: 'yssx_dictText'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'zt_dictText'
   },
   {
    title: '排序',
    align:"center",
    sorter: true,
    dataIndex: 'px'
   },
   {
    title: '是否必填',
    align:"center",
    dataIndex: 'isbt_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '列标识',
    field: 'lbs',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入列标识!'},
          ];
     },
  },
  {
    label: '列名称',
    field: 'lm',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入列名称!'},
          ];
     },
  },
  {
    label: '字段类型',
    field: 'zdlx',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode:"fieldtype"
    },
  },
  {
    label: '负责部门',
    field: 'departIds',
    component: 'Select',
    componentProps: {
      mode: 'multiple',
    },
    ifShow: ({ values }) => values.zdlx == 'JDictSelectTag',
  },
  {
    label: '字段长度',
    field: 'zdcd',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入字段长度!'},
          ];
     },
  },
  {
    label: '默认值',
    field: 'mrz',
    component: 'Input',
  },
  {
    label: '映射属性',
    field: 'yssx',
    component: 'JPopup',
    componentProps: ({ formActionType }) => {
      const {setFieldsValue} = formActionType;
      return{
        setFieldsValue:setFieldsValue,
        code:"certinfolist",
        fieldConfig: [
          { source: 'comments', target: 'yssx' },
        ],
        multi:true
      }
    },
  },
  {
    label: '状态',
    field: 'zt',
    defaultValue: "1",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"certmetadata_versionstatus"
     },
  },
  {
    label: '排序',
    field: 'px',
    component: 'Input',
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
  {
    label: '是否必填',
    field: 'isbt',
    defaultValue: "1",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
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
  lbs: {title: '列标识',order: 0,view: 'text', type: 'string',},
  lm: {title: '列名称',order: 1,view: 'text', type: 'string',},
  zdlx: {title: '字段类型',order: 2,view: 'text', type: 'string',},
  zdcd: {title: '字段长度',order: 3,view: 'text', type: 'string',},
  mrz: {title: '默认值',order: 4,view: 'text', type: 'string',},
  yssx: {title: '映射属性',order: 5,view: 'list', type: 'string',dictCode: 'certmapping',},
  zt: {title: '状态',order: 6,view: 'list', type: 'string',dictCode: 'certmetadata_versionstatus',},
  px: {title: '排序',order: 7,view: 'text', type: 'string',},
  isbt: {title: '是否必填',order: 9,view: 'list', type: 'string',dictCode: 'istrue',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
