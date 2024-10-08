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
    label: '显示顺序',
    field: 'orderNum',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入显示顺序!'},
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
    label: '是否有背景',
    field: 'isbackgroud',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否有背景!'},
          ];
     },
  },
  {
    label: '附件',
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
    label: '证照类型编码',
    field: 'certtypecode',
    component: 'Input',
  },
  {
    label: '盖章位置左一',
    field: 'postLeft1',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左一!'},
          ];
     },
  },
  {
    label: '盖章位置左二',
    field: 'postLeft2',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左二!'},
          ];
     },
  },
  {
    label: '盖章位置左三',
    field: 'postLeft3',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左三!'},
          ];
     },
  },
  {
    label: '盖章位置左四',
    field: 'postLeft4',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置左四!'},
          ];
     },
  },
  {
    label: '盖章位置右一',
    field: 'postRight1',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置右一!'},
          ];
     },
  },
  {
    label: '盖章位置右二',
    field: 'postRight2',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置右二!'},
          ];
     },
  },
  {
    label: '盖章位置右三',
    field: 'postRight3',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置右三!'},
          ];
     },
  },
  {
    label: '盖章位置右四',
    field: 'postRight4',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入盖章位置右四!'},
          ];
     },
  },
  {
    label: '模板状态 1启用2历史',
    field: 'modestatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"usestatus"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板状态 1启用2历史!'},
          ];
     },
  },
  {
    label: '是否合并附件0不合并1合并',
    field: 'ismergeFile',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否合并附件0不合并1合并!'},
          ];
     },
  },
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
  },
  {
    label: '文本定位',
    field: 'wbpost',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入文本定位!'},
          ];
     },
  },
  {
    label: '是否推送企业端',
    field: 'isqy',
    defaultValue: "1",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
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
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否公示!'},
          ];
     },
  },
  {
    label: '是否为变更记录替换模板',
    field: 'iswbgjlthmb',
    defaultValue: "1",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"istrue"
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
    component: 'JMarkdownEditor',//注意string转换问题
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入模板页数!'},
          ];
     },
  },
  {
    label: '变更字数项',
    field: 'bgzsx',
    component: 'JMarkdownEditor',//注意string转换问题
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入变更字数项!'},
          ];
     },
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
    label: '附件盖章位置x轴',
    field: 'fjpostX',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入附件盖章位置x轴!'},
          ];
     },
  },
  {
    label: '附件盖章位置y轴',
    field: 'fjpostY',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入附件盖章位置y轴!'},
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
];

// 高级查询数据
export const superQuerySchema = {
  bbNo: {title: '模板版本号',order: 0,view: 'text', type: 'string',},
  templateCode: {title: '模板编号',order: 1,view: 'text', type: 'string',},
  templateName: {title: '模板名称',order: 2,view: 'text', type: 'string',},
  templateType: {title: '模板类型',order: 3,view: 'list', type: 'string',dictCode: 'cert_mode_lx',},
  orderNum: {title: '显示顺序',order: 4,view: 'text', type: 'string',},
  status: {title: '类型状态',order: 5,view: 'list', type: 'string',dictCode: 'cert_mode_status',},
  modestatus: {title: '模板状态 1启用2历史',order: 20,view: 'list', type: 'string',dictCode: 'usestatus',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}