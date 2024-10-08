import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '部门主键',
    align:"center",
    dataIndex: 'deptId'
   },
   {
    title: '父部门id',
    align:"center",
    dataIndex: 'parentId'
   },
   {
    title: '祖级列表',
    align:"center",
    dataIndex: 'ancestors'
   },
   {
    title: '部门名称',
    align:"center",
    dataIndex: 'deptName'
   },
   {
    title: '显示顺序',
    align:"center",
    dataIndex: 'orderNum'
   },
   {
    title: '负责人',
    align:"center",
    dataIndex: 'leader'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'phone'
   },
   {
    title: '邮箱',
    align:"center",
    dataIndex: 'email'
   },
   {
    title: '部门状态（0正常 1停用）',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '部门类型',
    align:"center",
    dataIndex: 'deptType'
   },
   {
    title: '地区编码',
    align:"center",
    dataIndex: 'areaId'
   },
   {
    title: '地区名称',
    align:"center",
    dataIndex: 'areaName'
   },
   {
    title: '组织类型对应菜单',
    align:"center",
    dataIndex: 'deptPatter'
   },
   {
    title: '是否是顶级机构(0否1是)',
    align:"center",
    dataIndex: 'topDept'
   },
   {
    title: '企业统一社会信用代码 颁发机构代码',
    align:"center",
    dataIndex: 'orgNo'
   },
   {
    title: '创建用户id',
    align:"center",
    dataIndex: 'createByUid'
   },
   {
    title: '前置库部门名称',
    align:"center",
    dataIndex: 'var1'
   },
   {
    title: ' 颁发机构代码',
    align:"center",
    dataIndex: 'var2'
   },
   {
    title: '扩展字符类字段3',
    align:"center",
    dataIndex: 'var3'
   },
   {
    title: 'var4',
    align:"center",
    dataIndex: 'var4'
   },
   {
    title: 'var5',
    align:"center",
    dataIndex: 'var5'
   },
   {
    title: 'var6',
    align:"center",
    dataIndex: 'var6'
   },
   {
    title: 'var7',
    align:"center",
    dataIndex: 'var7'
   },
   {
    title: 'var8',
    align:"center",
    dataIndex: 'var8'
   },
   {
    title: 'date1',
    align:"center",
    dataIndex: 'date1',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'date2',
    align:"center",
    dataIndex: 'date2',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '部门主键',
    field: 'deptId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入部门主键!'},
          ];
     },
  },
  {
    label: '父部门id',
    field: 'parentId',
    component: 'Input',
  },
  {
    label: '祖级列表',
    field: 'ancestors',
    component: 'InputTextArea',
  },
  {
    label: '部门名称',
    field: 'deptName',
    component: 'Input',
  },
  {
    label: '显示顺序',
    field: 'orderNum',
    component: 'InputNumber',
  },
  {
    label: '负责人',
    field: 'leader',
    component: 'Input',
  },
  {
    label: '联系电话',
    field: 'phone',
    component: 'Input',
  },
  {
    label: '邮箱',
    field: 'email',
    component: 'Input',
  },
  {
    label: '部门状态（0正常 1停用）',
    field: 'status',
    component: 'InputNumber',
  },
  {
    label: '部门类型',
    field: 'deptType',
    component: 'Input',
  },
  {
    label: '地区编码',
    field: 'areaId',
    component: 'Input',
  },
  {
    label: '地区名称',
    field: 'areaName',
    component: 'Input',
  },
  {
    label: '组织类型对应菜单',
    field: 'deptPatter',
    component: 'Input',
  },
  {
    label: '是否是顶级机构(0否1是)',
    field: 'topDept',
    component: 'Input',
  },
  {
    label: '企业统一社会信用代码 颁发机构代码',
    field: 'orgNo',
    component: 'Input',
  },
  {
    label: '创建用户id',
    field: 'createByUid',
    component: 'Input',
  },
  {
    label: '前置库部门名称',
    field: 'var1',
    component: 'InputTextArea',
  },
  {
    label: ' 颁发机构代码',
    field: 'var2',
    component: 'Input',
  },
  {
    label: '扩展字符类字段3',
    field: 'var3',
    component: 'InputTextArea',
  },
  {
    label: 'var4',
    field: 'var4',
    component: 'InputTextArea',
  },
  {
    label: 'var5',
    field: 'var5',
    component: 'InputTextArea',
  },
  {
    label: 'var6',
    field: 'var6',
    component: 'InputTextArea',
  },
  {
    label: 'var7',
    field: 'var7',
    component: 'InputTextArea',
  },
  {
    label: 'var8',
    field: 'var8',
    component: 'InputTextArea',
  },
  {
    label: 'date1',
    field: 'date1',
    component: 'DatePicker',
  },
  {
    label: 'date2',
    field: 'date2',
    component: 'DatePicker',
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
  deptId: {title: '部门主键',order: 0,view: 'text', type: 'string',},
  parentId: {title: '父部门id',order: 1,view: 'text', type: 'string',},
  ancestors: {title: '祖级列表',order: 2,view: 'textarea', type: 'string',},
  deptName: {title: '部门名称',order: 3,view: 'text', type: 'string',},
  orderNum: {title: '显示顺序',order: 4,view: 'number', type: 'number',},
  leader: {title: '负责人',order: 5,view: 'text', type: 'string',},
  phone: {title: '联系电话',order: 6,view: 'text', type: 'string',},
  email: {title: '邮箱',order: 7,view: 'text', type: 'string',},
  status: {title: '部门状态（0正常 1停用）',order: 8,view: 'number', type: 'number',},
  deptType: {title: '部门类型',order: 10,view: 'text', type: 'string',},
  areaId: {title: '地区编码',order: 11,view: 'text', type: 'string',},
  areaName: {title: '地区名称',order: 12,view: 'text', type: 'string',},
  deptPatter: {title: '组织类型对应菜单',order: 13,view: 'text', type: 'string',},
  topDept: {title: '是否是顶级机构(0否1是)',order: 14,view: 'text', type: 'string',},
  orgNo: {title: '企业统一社会信用代码 颁发机构代码',order: 15,view: 'text', type: 'string',},
  createByUid: {title: '创建用户id',order: 16,view: 'text', type: 'string',},
  var1: {title: '前置库部门名称',order: 17,view: 'textarea', type: 'string',},
  var2: {title: ' 颁发机构代码',order: 18,view: 'text', type: 'string',},
  var3: {title: '扩展字符类字段3',order: 19,view: 'textarea', type: 'string',},
  var4: {title: 'var4',order: 20,view: 'textarea', type: 'string',},
  var5: {title: 'var5',order: 21,view: 'textarea', type: 'string',},
  var6: {title: 'var6',order: 22,view: 'textarea', type: 'string',},
  var7: {title: 'var7',order: 23,view: 'textarea', type: 'string',},
  var8: {title: 'var8',order: 24,view: 'textarea', type: 'string',},
  date1: {title: 'date1',order: 25,view: 'date', type: 'string',},
  date2: {title: 'date2',order: 26,view: 'date', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}