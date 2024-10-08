import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {h} from "vue";
import {Tag} from "ant-design-vue";
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '证书类型',
    align: 'center',
    dataIndex: 'zsdlName',
    width: 105,
  },
  {
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'qymc',
  },
  {
    title: '发证机关',
    align: 'center',
    dataIndex: 'fzjg',
  },
  {
    title: '有效期止',
    align: 'center',
    dataIndex: 'yxqz',
    width: 115,
  },
  {
    title: '预警标识',
    align: 'center',
    dataIndex: 'yjbs',
    width: 90,
    customRender: ({ record }) => {
      const status = record.yjbs;
      const enable = status === '红牌';
      const color = enable ? 'red' : 'yellow';
      const text = enable ? '红牌' : '黄牌';
      return h(Tag, { color: color }, () => text);
    },
  },
  {
    title: '处理状态',
    align: 'center',
    dataIndex: 'yjclzt',
    width: 110,
  },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '证书类型',
    field: 'zsdl',
    component: 'Select',
    //       dynamicDisabled: true,
    //填写组件的属性
    componentProps: {
      options: [
        { label: '药品', value: 'yp' },
        { label: '化妆品', value: 'hzp' },
        { label: '医疗器械', value: 'ylqx' },
      ],
    },
  },
  {
    label: '证书编号',
    field: 'zsbh',
    component: 'Input',
  },
  {
    label: '企业名称',
    field: 'qymc',
    component: 'Input',
  },
  //   {
  //       label: '预警标识',
  //       field: 'intervalMonth',
  //       component: 'Select',
  //   //       dynamicDisabled: true,
  //       //填写组件的属性
  //       componentProps: {
  //         options: [
  //           { label: '红牌', value: 1 },
  //           { label: '黄牌', value: 3 },
  //         ],
  //       },
  //   },
  {
    label: '发证机关',
    field: 'fzjg',
    component: 'Input',
  },
  {
    label: '有效期止',
    field: 'yxqz',
    component: 'RangeDate',
    componentProps: {
      //日期格式化
      format: 'YYYY/MM/DD',
      //范围文本描述用集合
      placeholder: ['请选择开始日期', '请选择结束日期'],
    },
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业名称',
    field: 'qymc',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '证书编号',
    field: 'zsbh',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '社会信用代码',
    field: 'shxydm',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '投诉举报电话',
    field: '',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '注册地址',
    field: 'zcdz',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '经营方式',
    field: 'jyfs',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '法定代表人',
    field: 'fddbr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '企业负责人',
    field: 'qyfzr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '质量负责人',
    field: 'zlfzr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '日常监督检查管理机构',
    field: 'rcjdgljg',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '经营范围',
    field: 'fw',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '发证机关',
    field: 'fzjg',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '签发人',
    field: 'qfr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '发证日期',
    field: 'fzrq',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '有效期至',
    field: 'yxqz',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '联系人',
    field: 'lxr',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '联系电话',
    field: 'lxdh',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
    },
  },
  {
    label: '发牌状态',
    field: 'yjbs',
    component: 'Input',
    dynamicDisabled: true,
    colProps: {
      span: 12,
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
