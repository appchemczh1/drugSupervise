import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
export const step1Schemas: FormSchema[] = [
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
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    colProps: {
      span: 18,
    },
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
    colProps: {
      span: 18,
    },
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
    label: '证书子表配置',
    field: 'zszb',
    component: 'JSelectMultiple',
    componentProps:{
      dictCode:"subtable"
    },
  },
 /* {
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
  },*/
  {
    label: '是否公示',
    field: 'isgs',
    defaultValue: "1",
    component: 'RadioGroup',
    componentProps:{
      options: [
        {
          label: '是',
          value: '1',
        },
        {
          label: '否',
          value: '0',
        },
      ],
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入是否公示!'},
      ];
    },
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '显示顺序',
    field: 'ordernum',
    component: 'Input',
    colProps: {
      span: 18,
    },
  },
];

export const step2Schemas: FormSchema[] = [
  {
    field: 'label1',
    component: 'Select',
    label: 'label2',
    required: true,
    defaultValue: '1',
  },
  {
    field: 'label2',
    component: 'JInput',
    label: 'label2',
    required: true,
  },
  {
    field: 'label3',
    component: 'JInput',
    label: 'label3',
    defaultValue: 'label3',
  },
  {
    field: 'label4',
    component: 'Input',
    label: 'label4',
    required: true,
  },
  {
    field: 'label5',
    component: 'Input',
    label: 'label5',
    defaultValue: '500',
  }
];
