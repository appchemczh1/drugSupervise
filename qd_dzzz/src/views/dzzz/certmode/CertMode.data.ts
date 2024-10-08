import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '模板版本号',
    align:"center",
    dataIndex: 'bbNo'
   },
   {
    title: '模板编号',
    align:"center",
    dataIndex: 'templateCode'
   },
   {
    title: '模板名称',
    align:"center",
    dataIndex: 'templateName'
   },
   {
    title: '模板类型',
    align:"center",
    dataIndex: 'templateType_dictText'
   },
   {
    title: '显示顺序',
    align:"center",
    dataIndex: 'orderNum'
   },
   {
    title: '类型状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '模板状态 1启用2历史',
    align:"center",
    dataIndex: 'modestatus_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '模板版本号',
    field: 'bbNo',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板版本号!'},
          ];
     },
  },
  {
    label: '模板编号',
    field: 'templateCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板编号!'},
          ];
     },
  },
  {
    label: '模板名称',
    field: 'templateName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板名称!'},
          ];
     },
  },
  {
    label: '模板类型',
    field: 'templateType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cert_mode_lx"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板类型!'},
          ];
     },
  },

  {
    label: '类型状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cert_mode_status"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入类型状态!'},
          ];
     },
  },
  {
    label: '纸张类型',
    field: 'papertype',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"papertye"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纸张类型!'},
          ];
     },
  },


  {
    label: '模板格式',
    field: 'modeformat',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"cert_mode_gs"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板格式!'},
          ];
     },
  },
  {
    label: '模板状态 ',//1启用2历史
    field: 'modestatus',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode:"usestatus"
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入模板状态!'},
      ];
    },
  },
 /* {
    label: '证照类型编码',
    field: 'certtypecode',
    component: 'Input',
  },*/
  {
    label: '定位方式',
    field: 'postmethod',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode:"postmethod"
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入定位方式!'},
      ];
    },
  },
  {
    label: '排版类型',
    field: 'pblx',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode:"pblx"
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入排版类型!'},
      ];
    },
    ifShow: ({ values }) => values.postmethod == "1"&&values.templateType == "4",//变更记录才显示

  },
  {
    label: '定位文本',
    field: 'wbpost',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入文本定位!'},
      ];
    },
    ifShow: ({ values }) => values.postmethod == "2",//变更记录才显示

  },

  {
    label: '盖章位置x,y轴',
    field: 'postLeft1',
    component: 'InputGroup',
    slot: 'fac',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入附件盖章位置x轴!'},
      ];
    },
    ifShow: ({ values }) => (values.postmethod == "1"&&values.templateType != "4")||(values.postmethod == "1"&&values.templateType == "4"&&values.pblx == "3"),//变更记录才显示

  },

  {
    label: '盖章位置左一',
    field: 'postLeft1',
    component: 'InputGroup',
    slot: 'facleft1',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左一!'},
          ];
     },
    ifShow: ({ values }) => values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3",//变更记录才显示
  },
  {
    label: '盖章位置右一',
    field: 'postRight1',
    component: 'InputGroup',
    slot: 'facright1',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入盖章位置右一!'},
      ];
    },
    ifShow: ({ values }) =>  values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3",//变更记录才显示

  },
  {
    label: '盖章位置左二',
    field: 'postLeft2',
    component: 'InputGroup',
    slot: 'facleft2',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左二!'},
          ];
     },
    ifShow: ({ values }) =>  values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3",//变更记录才显示

  },
  {
    label: '盖章位置右二',
    field: 'postRight2',
    component: 'InputGroup',
    slot: 'facright2',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入盖章位置右二!'},
      ];
    },
    ifShow: ({ values }) =>  values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3",//变更记录才显示

  },
  {
    label: '盖章位置左三',
    field: 'postLeft3',
    component: 'InputGroup',
    slot: 'facleft3',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左三!'},
          ];
     },
    ifShow: ({ values }) =>  values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3"&&values.pblx != "4",//变更记录才显示

  },
  {
    label: '盖章位置右三',
    field: 'postRight3',
    component: 'InputGroup',
    slot: 'facright3',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入盖章位置右三!'},
      ];
    },
    ifShow: ({ values }) => values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "3"&&values.pblx != "4",//变更记录才显示

  },
  {
    label: '盖章位置左四',
    field: 'postLeft4',
    component: 'InputGroup',
    slot: 'facleft4',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左四!'},
          ];
     },
    ifShow: ({ values }) => values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "4"&&values.pblx != "3"&&values.pblx != "1",//变更记录才显示

  },
  {
    label: '盖章位置右四',
    field: 'postRight4',
    component: 'InputGroup',
    slot: 'facright4',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入盖章位置右四!'},
      ];
    },
    ifShow: ({ values }) => values.postmethod == "1"&&values.templateType == "4"&&values.pblx != "4"&&values.pblx != "3"&&values.pblx != "1",//变更记录才显示

  },
  {
    label: '附件是否盖章',
    field: 'isSeal',
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
    dynamicRules: () => {
      return [
        { required: true, message: '请选择附件是否盖章!'},
      ];
    },
    ifShow: ({ values }) => (values.templateType == "5")
  },
  {
    label: '是否二次盖章',
    field: 'isecgz',
    defaultValue: "0",
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
  },
  {
    label: '二次盖章位置x,y轴',
    field: 'ecgzY',
    component: 'InputGroup',
    slot: 'ecgz',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入二次盖章位置x轴!'},
      ];
    },
    ifShow: ({ values }) => (values.isecgz == "1"),//变更记录才显示

  },


  {
    label: '是否合并附件',//0不合并1合并
    field: 'ismergeFile',
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
                 { required: true, message: '请输入是否合并附件0不合并1合并!'},
          ];
     },
  },


  {
    label: '是否推送企业端',
    field: 'isqy',
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
                 { required: true, message: '请输入是否推送企业端!'},
          ];
     },
  },
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
  {
    label: '过期时间',
    field: 'gqTime',
    component: 'DatePicker',
    componentProps: {
      showTime: true,
      valueFormat: 'YYYY-MM-DD HH:mm:ss'
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入过期时间!'},
      ];
    },
  },
  {
    label: '是否为变更记录替换模板',
    field: 'iswbgjlthmb',
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
                 { required: true, message: '请输入是否为变更记录替换模板!'},
          ];
     },
  },
  {
    label: '模板页数',
    field: 'mbys',
    component: 'Input',//注意string转换问题
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板页数!'},
          ];
     },
  },
  {
    label: '变更字数项',
    field: 'bgzsx',
    component: 'Input',//注意string转换问题
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入变更字数项!'},
          ];
     },
    ifShow: ({ values }) => values.iswbgjlthmb == "1"
  },
  {
    label: '附件来源',
    field: 'fjly',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"fjly"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入附件来源!'},
          ];
     },
  },
  {
    label: '是否有背景',
    field: 'isbackgroud',
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
        { required: true, message: '请输入是否有背景!'},
      ];
    },
  },

  {
    label: '模板文件',
    field: 'file',
    component: 'JUpload',
    componentProps:{
    },
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输入附件!'},
      ];
    },
  },
  {
    label: '显示顺序',
    field: 'orderNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
        { required: true, message: '请输显示顺序!'},
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
  {
    label: '',
    field: 'fjpostY',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postleftX1',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postleftX2',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postleftX3',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postleftX4',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postrightX1',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postrightX2',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postrightX3',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'postrightX4',
    component: 'Input',
    show: false
  },
  {
    label: '',
    field: 'ecgzX',
    component: 'Input',
    show: false
  },


];

// 高级查询数据
export const superQuerySchema = {
  bbNo: {title: '模板版本号',order: 0,view: 'text', type: 'string',},
  templateCode: {title: '模板编号',order: 1,view: 'text', type: 'string',},
  templateName: {title: '模板名称',order: 2,view: 'text', type: 'string',},
  templateType: {title: '模板类型',order: 3,view: 'list', type: 'string',dictCode: 'cert_mode_lx',},
  orderNum: {title: '显示顺序',order: 4,view: 'text', type: 'string',},
  status: {title: '类型状态',order: 5,view: 'list', type: 'string',dictCode: 'cert_mode_status',},
  /*modestatus: {title: '模板状态 1启用2历史',order: 20,view: 'list', type: 'string',dictCode: 'usestatus',},*/
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
