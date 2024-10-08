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
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '版本名称',
    field: 'bbmc',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入版本名称!'},
          ];
     },
  },
  {
    label: '定版时间',
    field: 'dbsj',
    component: 'DatePicker',
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
//子表表格配置
export const certMetadataColumns: JVxeColumn[] = [
    {
      title: '列标识',
      key: 'lbs',
      type: JVxeTypes.input,
      width:"200px",
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
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
    {
      title: '字段类型',
      key: 'zdlx',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '字段长度',
      key: 'zdcd',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
    {
      title: '默认值',
      key: 'mrz',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '映射属性',
      key: 'yssx',
      type: JVxeTypes.select,
      options:[],
      dictCode:"certmapping",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '状态',
      key: 'zt',
      type: JVxeTypes.select,
      options:[],
      dictCode:"certmetadata_versionstatus",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:"1",
    },
    {
      title: '排序',
      key: 'px',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否公示',
      key: 'isgs',
      type: JVxeTypes.select,
      options:[],
      dictCode:"istrue",
      width:"200px",
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
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:"1",
    },
  ]


// 高级查询数据
export const superQuerySchema = {
  bbmc: {title: '版本名称', order: 0, view: 'text', type: 'string',},
  dbsj: {title: '定版时间', order: 1, view: 'date', type: 'string',},
  status: {
    title: '状态',
    order: 2,
    view: 'list',
    type: 'string',
    dictCode: 'certmetadata_versionstatus',
  },
  //子表高级查询
}
