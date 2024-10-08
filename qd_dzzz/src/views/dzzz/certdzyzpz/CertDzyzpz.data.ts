import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { filterDictTextByCache, getDictItems } from '/@/utils/dict/JDictSelectUtil';
import { forEach } from '/@/utils/helper/treeHelper';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '印章编号',
    align:"center",
    dataIndex: 'sealCode'
   },
   {
    title: '印章名称',
    align:"center",
    dataIndex: 'sealName'
   },
   {
    title: '印章大小',
    align:"center",
    //dataIndex: 'sealSizeLong',
    customRender: function (text){
      let record=text.record;
      return ((record.sealSizeLong||"")+"*"+(record.sealSizeWide||""))
    },
   },
   {
    title: '所属部门',
    align:"center",
    dataIndex: 'sealDeptName'
   },
   {
    title: '对应发证机关',
    align:"center",
    dataIndex: 'var1'
   },
   {
    title: '类型状态',
    align:"center",
    dataIndex: 'state',
    customRender: function (text) {
      return filterDictTextByCache("usestatus", text.text+"")
    },
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "印章编号",
    field: 'sealCode',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: "印章名称",
    field: 'sealName',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: "所属部门",
    field: 'sealDeptName',
    component: 'Input',
    colProps: { span: 6 },
  }, 
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '印章编号',
    field: 'sealCode',
    component: 'Input',
  },
  {
    label: '印章名称',
    field: 'sealName',
    component: 'JSelectDept',
  },
  {
    label: '印章大小长',
    field: 'sealSizeLong',
    component: 'InputNumber',
  },
  {
    label: '印章大小宽',
    field: 'sealSizeWide',
    component: 'InputNumber',
  },
  {
    label: '所属部门',
    field: 'sealDeptName',
    component: 'JSelectDept',
  },
  {
    label: '对应发证机关',
    field: 'var1',
    component: 'JSelectDept',
  },
  {
    label: '类型状态',
    field: 'state',
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
  {
    label: '显示顺序',
    field: 'orderNum',
    component: 'InputNumber',
  },
  {
    label: '印章样式',
    field: 'yzys',
    component: 'JUpload',
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