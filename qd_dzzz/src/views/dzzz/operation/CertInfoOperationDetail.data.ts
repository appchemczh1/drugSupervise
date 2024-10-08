import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  //  {
  //   title: '证书id',
  //   align:"center",
  //   dataIndex: 'zsid'
  //  },

  {
    title: '变更字段名称',
    align: 'center',
    dataIndex: 'bgzdms',
  },
  {
    title: '变更前(字段历史)',
    align: 'center',
    dataIndex: 'zdlszt',
  },
  {
    title: '变更后(字段现状)',
    align: 'center',
    dataIndex: 'zdxz',
  },
  {
    title: '操作时间',
    align: 'center',
    dataIndex: 'czsj',
  },
  //  {
  //   title: '状态（0新增1修改2删除）',
  //   align:"center",
  //   dataIndex: 'zt'
  //  },
  {
    title: '备注',
    align: 'center',
    dataIndex: 'bz',
  },
  //  {
  //   title: '证书操作记录id',
  //   align:"center",
  //   dataIndex: 'zsczjl'
  //  },
  //  {
  //   title: '操作表名',
  //   align:"center",
  //   dataIndex: 'czbm'
  //  },
  //  {
  //   title: '记录版本',
  //   align:"center",
  //   dataIndex: 'jlbb'
  //  },

  //  {
  //   title: '变更次数',
  //   align:"center",
  //   dataIndex: 'bgcs'
  //  },

  //  {
  //   title: '数据标识0无效1有效',
  //   align:"center",
  //   dataIndex: 'dataFlg'
  //  },
  //  {
  //   title: '操作表数据id',
  //   align:"center",
  //   dataIndex: 'czsjid'
  //  },
];
//查询数据
export const searchFormSchema: FormSchema[] = [];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '证书id',
    field: 'zsid',
    component: 'Input',
  },
  {
    label: '变更前,字段历史',
    field: 'zdlszt',
    component: 'Input',
  },
  {
    label: '变更后，字段现',
    field: 'zdxz',
    component: 'Input',
  },
  {
    label: '操作时间',
    field: 'czsj',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
    },
  },
  {
    label: '状态（0新增1修改2删除）',
    field: 'zt',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'bz',
    component: 'Input',
  },
  {
    label: '证书操作记录id',
    field: 'zsczjl',
    component: 'Input',
  },
  {
    label: '操作表名',
    field: 'czbm',
    component: 'Input',
  },
  {
    label: '记录版本',
    field: 'jlbb',
    component: 'Input',
  },
  {
    label: '变更字段名称 -数据库名称',
    field: 'bgzdmc',
    component: 'Input',
  },
  {
    label: '变更次数',
    field: 'bgcs',
    component: 'Input',
  },
  {
    label: '变更字段描述名称',
    field: 'bgzdms',
    component: 'Input',
  },
  {
    label: '数据标识0无效1有效',
    field: 'dataFlg',
    component: 'Input',
  },
  {
    label: '操作表数据id',
    field: 'czsjid',
    component: 'Input',
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
