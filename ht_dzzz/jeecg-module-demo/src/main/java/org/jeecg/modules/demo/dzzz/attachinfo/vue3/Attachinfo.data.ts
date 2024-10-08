import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '创建人',
    align:"center",
    dataIndex: 'createBy'
   },
   {
    title: '创建日期',
    align:"center",
    dataIndex: 'createTime'
   },
   {
    title: '更新人',
    align:"center",
    dataIndex: 'updateBy'
   },
   {
    title: '更新日期',
    align:"center",
    dataIndex: 'updateTime'
   },
   {
    title: '所属部门',
    align:"center",
    dataIndex: 'sysOrgCode'
   },
   {
    title: '证书类型名称',
    align:"center",
    dataIndex: 'modeName'
   },
   {
    title: '证书类型',
    align:"center",
    dataIndex: 'type'
   },
   {
    title: '证书存储路径',
    align:"center",
    dataIndex: 'modeUrl',
    customRender:render.renderImage,
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '创建人',
    align:"center",
    dataIndex: 'userName'
   },
   {
    title: '创建人id',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '文件名称',
    align:"center",
    dataIndex: 'fileName'
   },
   {
    title: '证书id',
    align:"center",
    dataIndex: 'zsid'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建日期',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新人',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '更新日期',
    field: 'updateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '所属部门',
    field: 'sysOrgCode',
    component: 'Input',
  },
  {
    label: '证书类型名称',
    field: 'modeName',
    component: 'Input',
  },
  {
    label: '证书类型',
    field: 'type',
    component: 'Input',
  },
  {
    label: '证书存储路径',
    field: 'modeUrl',
     component: 'JImageUpload',
     componentProps:{
      },
  },
  {
    label: '状态',
    field: 'status',
    component: 'Input',
  },
  {
    label: '创建人',
    field: 'userName',
    component: 'Input',
  },
  {
    label: '创建人id',
    field: 'userId',
    component: 'Input',
  },
  {
    label: '文件名称',
    field: 'fileName',
    component: 'Input',
  },
  {
    label: '证书id',
    field: 'zsid',
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
  createBy: {title: '创建人',order: 0,view: 'text', type: 'string',},
  createTime: {title: '创建日期',order: 1,view: 'datetime', type: 'string',},
  updateBy: {title: '更新人',order: 2,view: 'text', type: 'string',},
  updateTime: {title: '更新日期',order: 3,view: 'datetime', type: 'string',},
  sysOrgCode: {title: '所属部门',order: 4,view: 'text', type: 'string',},
  modeName: {title: '证书类型名称',order: 5,view: 'text', type: 'string',},
  type: {title: '证书类型',order: 6,view: 'text', type: 'string',},
  modeUrl: {title: '证书存储路径',order: 7,view: 'image', type: 'string',},
  status: {title: '状态',order: 8,view: 'text', type: 'string',},
  userName: {title: '创建人',order: 9,view: 'text', type: 'string',},
  userId: {title: '创建人id',order: 10,view: 'text', type: 'string',},
  fileName: {title: '文件名称',order: 11,view: 'text', type: 'string',},
  zsid: {title: '证书id',order: 12,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}