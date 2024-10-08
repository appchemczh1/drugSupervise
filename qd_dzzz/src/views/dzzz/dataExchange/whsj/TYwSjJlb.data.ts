import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { h } from 'vue';
import { Tag } from 'ant-design-vue';
//列表数据
export const columns: BasicColumn[] = [
  // 列表显示【证书编号】、【证书类型】、【业务类型】、【接收时间】、【是否成功】、【操作-详情】
  {
    title: '证书类型',
    align: 'center',
    dataIndex: 'zslxName',
  },
  {
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '业务类型',
    align: 'center',
    dataIndex: 'ywlxName',
    width: 120,
  },
  {
    title: '接收时间',
    align: 'center',
    dataIndex: 'jlsj',
  },
  {
    title: '是否成功',
    align: 'center',
    dataIndex: 'jlztName',
    width: 110,
    customRender: ({ record }) => {
      const status = record.jlzt;
      const enable = ~~status === 0;
      const color = enable ? 'green' : 'red';
      const text = enable ? '成功' : '失败';
      return h(Tag, { color: color }, () => text);
    },
  },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '证书类型',
    field: 'zslxName',
    component: 'Input',
  },
  {
    label: '证书编号',
    field: 'zsbh',
    component: 'Input',
  },
  {
    label: '业务类型',
    field: 'ywlx',
    component: 'Select',
    //       dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '核发', value: '1' },
        { label: '换发/延续', value: '2' },
        { label: '变更', value: '3' },
        { label: '注销', value: '4' },
        { label: '补发', value: '5' },
        { label: '强制维护', value: '7' },
      ],
    },
  },
  {
    label: '接收时间',
    field: 'jlsj',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
  {
    label: '是否成功',
    field: 'jlzt',
    component: 'Select',
    //       dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '成功', value: 0 },
        { label: '失败', value: 1 },
      ],
    },
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  //   {
  //     label: '主键ID',
  //     field: 'id',
  //     component: 'InputNumber',
  //     dynamicRules: ({model,schema}) => {
  //           return [
  //                  { required: true, message: '请输入主键ID!'},
  //           ];
  //      },
  //   },
  {
    label: '业务类型',
    field: 'ywlxName',
    //     component: 'Input',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
  },
  //   {
  //     label: '数据来源',
  //     field: 'jllyName',
  //     component: 'InputNumber',
  //     dynamicRules: ({model,schema}) => {
  //           return [
  //                  { required: true, message: '请输入来源!'},
  //           ];
  //      },
  //   },
  {
    label: '证书类型',
    field: 'zslxName',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
  },
  {
    label: '证书编号',
    field: 'zsbh',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
  },
  {
    label: '接收时间',
    field: 'jlsj',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
  },
  {
    label: '是否成功',
    field: 'jlztName',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
  },
  {
    label: '返回值',
    field: 'jlOutJson',
    component: 'InputTextArea',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
    componentProps: {
      rows: 4,
    },
  },
  {
    label: '接收参数',
    field: 'jlInJson',
    component: 'InputTextArea',
    dynamicDisabled: true,
    colProps: {
      span: 21,
    },
    componentProps: {
      rows: 18,
    },
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '主键',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

// 高级查询数据
export const superQuerySchema = {
  //   zsbh: {title: '证书编号',order: 0,view: 'text', type: 'string',},
  //   zslxName: {title: '证书类型',order: 1,view: 'text', type: 'string',},
  //   jlzt: {title: '推送状态：0-成功 1：失败',order: 2,view: 'number', type: 'number',},
};

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
