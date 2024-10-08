import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '业务类型',
    align: 'center',
    dataIndex: 'bglx_dictText',
    width: '80px',
  },
  //  {
  //   title: '创造时间',
  //   align:"center",
  //   dataIndex: 'czrq'
  //  },
  //  {
  //   title: '操作人员id',
  //   align:"center",
  //   dataIndex: 'czryid'
  //  },
  //  {
  //   title: '操作人姓名',
  //   align:"center",
  //   dataIndex: 'czrxm'
  //  },
  {
    title: '操作时间',
    align: 'center',
    dataIndex: 'czsj',
    width: '160px',
  },
  //  {
  //   title: '变更次数',
  //   align:"center",
  //   dataIndex: 'bgcs'
  //  },
  //  {
  //   title: '变更状态',
  //   align:"center",
  //   dataIndex: 'bgzt'
  //  },
  // {
  //   title: '变更内容',
  //   align: 'center',
  //   dataIndex: 'bgnr',
  // },
  // {
  //   title: '变更内容',
  //   align: 'center',
  //   dataIndex: 'bgnr',
  //   customRender: ({ text }) => {
  //     return render({
  //       content: text,
  //       style: {
  //         whiteSpace: 'pre-wrap',
  //         wordBreak: 'break-all',
  //       },
  //     });
  //   },
  // },
  //zz修改
  {
    title: '操作内容',
    align: 'center',
    dataIndex: 'bgnr',
    customCell: ({ text }) => {
      return {
        style: 'white-space:pre-wrap;word-break:break-all;'
      };
    },
  },
  {
    title: '办件过程',
    align: 'center',
    dataIndex: 'xzspslh',
    width: 80
  },
  //  {
  //   title: '取值维护状态',
  //   align:"center",
  //   dataIndex: 'qzwhzt'
  //  },
  //  {
  //   title: '盖章状态',
  //   align:"center",
  //   dataIndex: 'gzstutas'
  //  },
  //  {
  //   title: '操作记录版本',
  //   align:"center",
  //   dataIndex: 'czjlbb'
  //  },
  //  {
  //   title: '操作次数',
  //   align:"center",
  //   dataIndex: 'operateNo'
  //  },
  //  {
  //   title: '实际变更内容',
  //   align:"center",
  //   dataIndex: 'sjbgnr'
  //  },
  //  {
  //   title: '变更类型',
  //   align:"center",
  //   dataIndex: 'bglx'
  //  },
  //  {
  //   title: '表名',
  //   align:"center",
  //   dataIndex: 'tablename'
  //  },
  //  {
  //   title: '父id',
  //   align:"center",
  //   dataIndex: 'pid'
  //  },
  //  {
  //   title: '附件信息',
  //   align:"center",
  //   dataIndex: 'fjxx'
  //  },
  //  {
  //   title: '已签章回退待签章历史id',
  //   align:"center",
  //   dataIndex: 'oldId'
  //  },
  //  {
  //   title: '是否初始化数据',
  //   align:"center",
  //   dataIndex: 'iscsh'
  //  },
  //  {
  //   title: '数据标识0无效1有效 无业务，数据问题处理20231108，原data_flag的值',
  //   align:"center",
  //   dataIndex: 'oldDataFlag'
  //  },
  //  {
  //   title: '印章编号数据初始化使用',
  //   align:"center",
  //   dataIndex: 'selcode'
  //  },
  //  {
  //   title: '印章名称数据初始化使用',
  //   align:"center",
  //   dataIndex: 'selname'
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
    label: '业务类型',
    field: 'bglx',
    component: 'JDictSelectTag',
    componentProps: {
      dictCode: 'changetype',
    },
  },
  {
    label: '创造时间',
    field: 'czrq',
    component: 'Input',
  },
  {
    label: '数据来源',
    field: 'sjly',
    component: 'Input',
  },
  {
    label: '状态 0无效1有效',
    field: 'stutas',
    component: 'Input',
  },
  {
    label: '行政审批受理号',
    field: 'xzspslh',
    component: 'Input',
  },
  {
    label: '操作人员id',
    field: 'czryid',
    component: 'Input',
  },
  {
    label: '操作人姓名',
    field: 'czrxm',
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
    label: '变更次数',
    field: 'bgcs',
    component: 'Input',
  },
  {
    label: '变更状态',
    field: 'bgzt',
    component: 'Input',
  },
  {
    label: '变更内容',
    field: 'bgsj',
    component: 'Input',
  },
  {
    label: '取值维护状态',
    field: 'qzwhzt',
    component: 'Input',
  },
  {
    label: '盖章状态',
    field: 'gzstutas',
    component: 'Input',
  },
  {
    label: '操作记录版本',
    field: 'czjlbb',
    component: 'Input',
  },
  {
    label: '操作次数',
    field: 'operateNo',
    component: 'Input',
  },
  {
    label: '实际变更内容',
    field: 'sjbgnr',
    component: 'Input',
  },
  {
    label: '变更类型',
    field: 'bglx',
    component: 'Input',
  },
  {
    label: '表名',
    field: 'tablename',
    component: 'Input',
  },
  {
    label: '父id',
    field: 'pid',
    component: 'Input',
  },
  {
    label: '附件信息',
    field: 'fjxx',
    component: 'Input',
  },
  {
    label: '已签章回退待签章历史id',
    field: 'oldId',
    component: 'Input',
  },
  {
    label: '是否初始化数据',
    field: 'iscsh',
    component: 'Input',
  },
  {
    label: '数据标识0无效1有效 无业务，数据问题处理20231108，原data_flag的值',
    field: 'oldDataFlag',
    component: 'Input',
  },
  {
    label: '印章编号数据初始化使用',
    field: 'selcode',
    component: 'Input',
  },
  {
    label: '印章名称数据初始化使用',
    field: 'selname',
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
