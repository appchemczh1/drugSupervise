import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '版本名称',
    align:"center",
    dataIndex: 'bbmc'
   },
   {
    title: '定版时间',
    align:"center",
    dataIndex: 'dbsj',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
];

//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '版本名称',
    field: 'bbmc',
    component: 'Input',
    disabled:false,
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入版本名称!'},
          ];
     },
    dynamicDisabled: ({ values }) => {
      return !!values.bbmc;
    },
  },
  {
    label: '定版时间',
    field: 'dbsj',
    component: 'DatePicker',
    disabled: true,
  },
  {
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"certmetadata_versionstatus"
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
//子表单数据
//子表列表数据
export const certMetadataColumns: BasicColumn[] = [
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
    dataIndex: 'yssx'
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

//子表列表数据
export const certMetadataColumns2: BasicColumn[] = [
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
    dataIndex: 'yssx'
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
//子表表格配置
export const certMetadataJVxeColumns: JVxeColumn[] = [
    {
      title: '列标识',
      key: 'lbs',
      type: JVxeTypes.input,
      disabled:true,
      dictCode:"certmapping",
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:'',
      validateRules: [
        { required: true, message: '${title}不能为空' },
      ],
    },
    {
      title: '列名称',
      key: 'lm',
      type: JVxeTypes.input,
      width:"150px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
    {
      title: '控件类型',
      key: 'zdlx',
      type: JVxeTypes.select,
      options:[],
      width:"120px",
      dictCode:"fieldtype",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
   /* {
      title: '控件长度',
      key: 'kjcd',
      type: JVxeTypes.input,
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },*/
    {
      title: '默认值',
      key: 'mrz',
      type: JVxeTypes.input,
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '映射属性',
      key: 'yssx',
      type: JVxeTypes.input,
      options:[],
      width:"150px",
      placeholder: '请输入${title}',
      defaultValue:'',
      validateRules: [
        { required: true, message: '${title}不能为空' },
      ],
    },
    {
      title: '状态',
      key: 'zt',
      type: JVxeTypes.select,
      options:[],
      dictCode:"certmetadata_versionstatus",
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:"1",
    },
    {
      title: '排序',
      key: 'px',
      type: JVxeTypes.input,
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  {
    title: '布局样式',
    key: 'bjys',
    type: JVxeTypes.select,
    options:[],
    dictCode:"certinfostyle",
    width:"120px",
    placeholder: '请输入${title}',
    defaultValue:"1",
  },

    {
      title: '是否公示',
      key: 'isgs',
      type: JVxeTypes.select,
      options:[],
      dictCode:"istrue",
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:"1",
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
  {
    title: '是否隐藏',
    key: 'sfsc',
    type: JVxeTypes.select,
    options:[],
    dictCode:"istrue",
    width:"120px",
    placeholder: '请输入${title}',
    defaultValue:"1",
    validateRules: [
      { required: true, message: '${title}不能为空' },
    ],
  },
    {
      title: '是否必填',
      key: 'isbt',
      type: JVxeTypes.select,
      options:[],
      dictCode:"istrue",
      width:"120px",
      placeholder: '请输入${title}',
      defaultValue:"1",
    },
  ]
export const certMetadataJVxeColumns2: JVxeColumn[] = [
  {
    title: '列标识',
    key: 'lbs',
    type: JVxeTypes.input,
    disabled: true,
    width:"120px",
    placeholder: '请输入${title}',
    defaultValue:'',
  },
  {
    title: '列名称',
    key: 'lm',
    type: JVxeTypes.input,
    width:"150px",
    placeholder: '请输入${title}',
    defaultValue:'',
    validateRules: [
      { required: true, message: '${title}不能为空' },
    ],
  },
  {
    title: '字段类型',
    key: 'zdlx',
    type: JVxeTypes.select,
    options:[],
    width:"120px",
    align:"center",
    dictCode:"fieldtype",
    placeholder: '请输入${title}',
    defaultValue:'',
  },
  {
    title: '字段长度',
    key: 'zdcd',
    type: JVxeTypes.input,
    width:"120px",
    align:"center",
    placeholder: '请输入${title}',
    defaultValue:'',
    validateRules: [
      { required: true, message: '${title}不能为空' },
    ],
  },
  {
    title: '映射属性',
    key: 'yssx',
    type: JVxeTypes.input,
    align:"center",
    width:"150px",
    placeholder: '请输入${title}',
    defaultValue:'',
    validateRules: [
      { required: true, message: '${title}不能为空' },
    ],
  },
]
