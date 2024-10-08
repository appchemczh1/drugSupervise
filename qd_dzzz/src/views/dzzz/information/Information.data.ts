import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '统一社会信用代码',
    align: 'center',
    dataIndex: 'entzzjgdm',
  },

  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'entname',
  },
  // {
  //  title: '企业类型',
  //  align:"center",
  //  dataIndex: 'entintype'
  // },
  {
    title: '注册地址',
    align: 'center',
    dataIndex: 'entregaddr',
  },
  {
    title: '法定代表人',
    align: 'center',
    dataIndex: 'corpname',
    width: 110,
  },
  {
    title: '证书数量',
    align: 'center',
    dataIndex: 'zsNum',
    width: 105,
  },
  // {
  //  title: '企业地址',
  //  align:"center",
  //  dataIndex: 'entregaddr'
  // },
  // {
  //  title: '省',
  //  align:"center",
  //  dataIndex: 'ents'
  // },
  // {
  //  title: '市',
  //  align:"center",
  //  dataIndex: 'entd'
  // },
  // {
  //  title: '区',
  //  align:"center",
  //  dataIndex: 'engx'
  // },
  // {
  //  title: 'entregtypecode',
  //  align:"center",
  //  dataIndex: 'entregtypecode'
  // },
  // {
  //  title: 'entecotype',
  //  align:"center",
  //  dataIndex: 'entecotype'
  // },
  // {
  //  title: 'entbelongarea',
  //  align:"center",
  //  dataIndex: 'entbelongarea'
  // },
  // {
  //  title: '企业联系人',
  //  align:"center",
  //  dataIndex: 'entlinkname'
  // },
  // {
  //  title: '企业移动电话',
  //  align:"center",
  //  dataIndex: 'entlinkmobile'
  // },
  // {
  //  title: '企业座机',
  //  align:"center",
  //  dataIndex: 'entlinktel'
  // },
  // {
  //  title: 'entlinkfax',
  //  align:"center",
  //  dataIndex: 'entlinkfax'
  // },
  // {
  //  title: 'entlinkemail',
  //  align:"center",
  //  dataIndex: 'entlinkemail'
  // },
  // {
  //  title: '法人',
  //  align:"center",
  //  dataIndex: 'corpname'
  // },
  // /*{
  //  title: 'entby14',
  //  align:"center",
  //  dataIndex: 'entby14'
  // },
  // {
  //  title: 'entby7',
  //  align:"center",
  //  dataIndex: 'entby7'
  // },
  // {
  //  title: 'entby8',
  //  align:"center",
  //  dataIndex: 'entby8'
  // },
  // {
  //  title: 'entby12',
  //  align:"center",
  //  dataIndex: 'entby12'
  // },
  // {
  //  title: 'entby17',
  //  align:"center",
  //  dataIndex: 'entby17'
  // },
  // {
  //  title: 'entby20',
  //  align:"center",
  //  dataIndex: 'entby20'
  // },
  // {
  //  title: 'entby19',
  //  align:"center",
  //  dataIndex: 'entby19'
  // },
  // {
  //  title: 'entby18',
  //  align:"center",
  //  dataIndex: 'entby18'
  // },
  // {
  //  title: 'entby16',
  //  align:"center",
  //  dataIndex: 'entby16'
  // },
  // {
  //  title: 'entby15',
  //  align:"center",
  //  dataIndex: 'entby15'
  // },*/
  // {
  //  title: 'auditperson',
  //  align:"center",
  //  dataIndex: 'auditperson'
  // },
  // {
  //  title: 'auditdept',
  //  align:"center",
  //  dataIndex: 'auditdept'
  // },
  // {
  //  title: 'audittiem',
  //  align:"center",
  //  dataIndex: 'audittiem',
  //  customRender:({text}) =>{
  //    return !text?"":(text.length>10?text.substr(0,10):text)
  //  },
  // },
  // {
  //  title: 'delflag',
  //  align:"center",
  //  dataIndex: 'delflag'
  // },
  // {
  //  title: 'createdate',
  //  align:"center",
  //  dataIndex: 'createdate',
  //  customRender:({text}) =>{
  //    return !text?"":(text.length>10?text.substr(0,10):text)
  //  },
  // },
  // {
  //  title: 'creator',
  //  align:"center",
  //  dataIndex: 'creator'
  // },
  // {
  //  title: 'createdept',
  //  align:"center",
  //  dataIndex: 'createdept'
  // },
  // {
  //  title: 'isConfirm',
  //  align:"center",
  //  dataIndex: 'isConfirm'
  // },
  // {
  //  title: 'password',
  //  align:"center",
  //  dataIndex: 'password'
  // },
  // {
  //  title: 'ifwf',
  //  align:"center",
  //  dataIndex: 'ifwf'
  // },
  // {
  //  title: 'entbelongtoCity',
  //  align:"center",
  //  dataIndex: 'entbelongtoCity'
  // },
  // {
  //  title: 'entbelongtoDomain',
  //  align:"center",
  //  dataIndex: 'entbelongtoDomain'
  // },
  // {
  //  title: 'entbelongtoTown',
  //  align:"center",
  //  dataIndex: 'entbelongtoTown'
  // },
  // {
  //  title: 'admindivision',
  //  align:"center",
  //  dataIndex: 'admindivision'
  // },
  // {
  //  title: 'sync',
  //  align:"center",
  //  dataIndex: 'sync'
  // },
  // {
  //  title: 'syncZs',
  //  align:"center",
  //  dataIndex: 'syncZs'
  // },
  // {
  //  title: 'processflag',
  //  align:"center",
  //  dataIndex: 'processflag'
  // },
  // {
  //  title: 'lastudate',
  //  align:"center",
  //  dataIndex: 'lastudate',
  //  customRender:({text}) =>{
  //    return !text?"":(text.length>10?text.substr(0,10):text)
  //  },
  // },
  // {
  //  title: 'lastudept',
  //  align:"center",
  //  dataIndex: 'lastudept'
  // },
  // {
  //  title: 'repeatdel',
  //  align:"center",
  //  dataIndex: 'repeatdel'
  // },
  // {
  //  title: 'sjzlSjly',
  //  align:"center",
  //  dataIndex: 'sjzlSjly'
  // },
  // {
  //  title: 'ckdz',
  //  align:"center",
  //  dataIndex: 'ckdz'
  // },
  // {
  //  title: 'djjg',
  //  align:"center",
  //  dataIndex: 'djjg'
  // },
  // {
  //  title: 'djsj',
  //  align:"center",
  //  dataIndex: 'djsj',
  //  customRender:({text}) =>{
  //    return !text?"":(text.length>10?text.substr(0,10):text)
  //  },
  // },
  // {
  //  title: 'fddbrsjh',
  //  align:"center",
  //  dataIndex: 'fddbrsjh'
  // },
  // {
  //  title: 'gsqylx',
  //  align:"center",
  //  dataIndex: 'gsqylx'
  // },
  // {
  //  title: 'jjhy',
  //  align:"center",
  //  dataIndex: 'jjhy'
  // },
  // {
  //  title: 'jjlx',
  //  align:"center",
  //  dataIndex: 'jjlx'
  // },
  // {
  //  title: 'jydz',
  //  align:"center",
  //  dataIndex: 'jydz'
  // },
  // {
  //  title: 'jyfw',
  //  align:"center",
  //  dataIndex: 'jyfw'
  // },
  // {
  //  title: 'qygm',
  //  align:"center",
  //  dataIndex: 'qygm'
  // },
  // /*{
  //  title: 'qyzclx',
  //  align:"center",
  //  dataIndex: 'qyzclx'
  // },
  // {
  //  title: 'qyzjlx',
  //  align:"center",
  //  dataIndex: 'qyzjlx'
  // },
  // {
  //  title: 'qyzt',
  //  align:"center",
  //  dataIndex: 'qyzt'
  // },
  // {
  //  title: 'sfgmys',
  //  align:"center",
  //  dataIndex: 'sfgmys'
  // },
  // {
  //  title: 'xzjddm',
  //  align:"center",
  //  dataIndex: 'xzjddm'
  // },
  // {
  //  title: 'zczb',
  //  align:"center",
  //  dataIndex: 'zczb'
  // },
  // {
  //  title: 'zczbdw',
  //  align:"center",
  //  dataIndex: 'zczbdw'
  // },
  // {
  //  title: 'sjzlsjly',
  //  align:"center",
  //  dataIndex: 'sjzlsjly'
  // },
  // {
  //  title: 'dashxydm',
  //  align:"center",
  //  dataIndex: 'dashxydm'
  // },
  // {
  //  title: 'fax',
  //  align:"center",
  //  dataIndex: 'fax'
  // },
  // {
  //  title: 'jgfj',
  //  align:"center",
  //  dataIndex: 'jgfj'
  // },
  // {
  //  title: 'scdz',
  //  align:"center",
  //  dataIndex: 'scdz'
  // },
  // {
  //  title: 'syncScj',
  //  align:"center",
  //  dataIndex: 'syncScj'
  // },
  // {
  //  title: 'sessionid',
  //  align:"center",
  //  dataIndex: 'sessionid'
  // },
  // {
  //  title: 'sjly',
  //  align:"center",
  //  dataIndex: 'sjly'
  // },
  // {
  //  title: 'flag',
  //  align:"center",
  //  dataIndex: 'flag'
  // },
  // {
  //  title: 'zwfwparam',
  //  align:"center",
  //  dataIndex: 'zwfwparam'
  // },
  // {
  //  title: 'syncZyzjba',
  //  align:"center",
  //  dataIndex: 'syncZyzjba'
  // },
  // {
  //  title: 'syncSjzl',
  //  align:"center",
  //  dataIndex: 'syncSjzl'
  // },
  // {
  //  title: 'syncZsxt',
  //  align:"center",
  //  dataIndex: 'syncZsxt'
  // },
  // {
  //  title: 'issc',
  //  align:"center",
  //  dataIndex: 'issc'
  // },
  // {
  //  title: 'synctime',
  //  align:"center",
  //  dataIndex: 'synctime'
  // },*/
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '所在地区',
    field: 'admindivision',
    component: 'JTreeSelect',
    componentProps: {
      //字典code配置，比如通过性别字典编码：sex，也可以使用sys_permission,name,id 表名,名称,值的方式
      dict: 'cert_area,areaname,areacode',
      // //父级id字段
      pidField: 'parentid',
    },
  },
  {
    label: '统一社会信用代码',
    field: 'entzzjgdm',
    component: 'Input',
  },
  {
    label: '公司名称',
    field: 'entname',
    component: 'Input',
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '公司名称',
    field: 'entname',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '社会信用代码',
    field: 'entzzjgdm',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '所在地区',
    field: 'engx',
    component: 'JTreeSelect',
    componentProps: {
      //字典code配置，比如通过性别字典编码：sex，也可以使用sys_permission,name,id 表名,名称,值的方式
      dict: 'cert_area,areaname,areacode',
      // //父级id字段
      pidField: 'parentid',
    },
    colProps: { span: 11 },
  },
  {
    label: '工商企业类型',
    field: 'companyType',
    component: 'JDictSelectTag',
    componentProps: {
      dictCode: 'gslx',
    }, //gslx
    colProps: { span: 11 },
  },
  {
    label: '注册地址',
    field: 'entregaddr',
    component: 'InputTextArea',
    colProps: { span: 25 },
  },
  {
    label: '注册资本',
    field: 'zczb',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '法定代表人',
    field: 'corpname',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '法定代表人证件号码',
    field: 'entby14',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '登记机关',
    field: 'djjg',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '登记时间',
    field: 'djsj',
    component: 'DatePicker',
    colProps: { span: 11 },
  },
  // {
  //   label: '营业期限',
  //   field: 'yyqx',
  //   component: 'Input',
  //   colProps: { span: 11 },
  // },
  /* {
    label: '登记状态',
    field: 'djStatus',
    component: 'Input',
    colProps:{ span: 12 },
  },*/
  {
    label: '经营范围',
    field: 'jyfw',
    component: 'InputTextArea',
    colProps: { span: 25 },
  },

  {
    label: '联系人',
    field: 'entlinkname',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '联系人电话（座机）',
    field: 'entlinktel',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '移动电话',
    field: 'entlinkmobile',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '法定代表人电话',
    field: 'fddbrlxdh',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '传真',
    field: 'entlinkfax',
    component: 'Input',
    colProps: { span: 11 },
  },
  {
    label: '历史名称',
    field: 'hisname',
    component: 'Input',
    colProps: { span: 25 },
  },

  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

// 高级查询数据
export const superQuerySchema = {
  entzzjgdm: { title: '社会信用代码', order: 0, view: 'text', type: 'string' },
  entbacode: { title: 'entbacode', order: 1, view: 'text', type: 'string' },
  entname: { title: 'entname', order: 2, view: 'text', type: 'string' },
  entbelongto: { title: 'entbelongto', order: 3, view: 'text', type: 'string' },
  entavailflag: { title: 'entavailflag', order: 4, view: 'text', type: 'string' },
  entintype: { title: 'entintype', order: 5, view: 'text', type: 'string' },
  entregaddr: { title: 'entregaddr', order: 6, view: 'textarea', type: 'string' },
  entregpcode: { title: 'entregpcode', order: 7, view: 'text', type: 'string' },
  ents: { title: 'ents', order: 8, view: 'text', type: 'string' },
  entd: { title: 'entd', order: 9, view: 'text', type: 'string' },
  engx: { title: 'engx', order: 10, view: 'text', type: 'string' },
  entregtypecode: { title: 'entregtypecode', order: 11, view: 'text', type: 'string' },
  entecotype: { title: 'entecotype', order: 12, view: 'text', type: 'string' },
  entbelongarea: { title: 'entbelongarea', order: 13, view: 'text', type: 'string' },
  entlinkname: { title: 'entlinkname', order: 14, view: 'text', type: 'string' },
  entlinkmobile: { title: 'entlinkmobile', order: 15, view: 'text', type: 'string' },
  entlinktel: { title: 'entlinktel', order: 16, view: 'text', type: 'string' },
  entlinkfax: { title: 'entlinkfax', order: 17, view: 'text', type: 'string' },
  entlinkemail: { title: 'entlinkemail', order: 18, view: 'text', type: 'string' },
  corpname: { title: 'corpname', order: 19, view: 'text', type: 'string' },
  entby14: { title: 'entby14', order: 20, view: 'text', type: 'string' },
  entby7: { title: 'entby7', order: 21, view: 'text', type: 'string' },
  entby8: { title: 'entby8', order: 22, view: 'text', type: 'string' },
  entby12: { title: 'entby12', order: 23, view: 'text', type: 'string' },
  entby17: { title: 'entby17', order: 24, view: 'text', type: 'string' },
  entby20: { title: 'entby20', order: 25, view: 'text', type: 'string' },
  entby19: { title: 'entby19', order: 26, view: 'text', type: 'string' },
  entby18: { title: 'entby18', order: 27, view: 'text', type: 'string' },
  entby16: { title: 'entby16', order: 28, view: 'text', type: 'string' },
  entby15: { title: 'entby15', order: 29, view: 'text', type: 'string' },
  auditperson: { title: 'auditperson', order: 30, view: 'text', type: 'string' },
  auditdept: { title: 'auditdept', order: 31, view: 'text', type: 'string' },
  audittiem: { title: 'audittiem', order: 32, view: 'date', type: 'string' },
  delflag: { title: 'delflag', order: 33, view: 'text', type: 'string' },
  createdate: { title: 'createdate', order: 34, view: 'date', type: 'string' },
  creator: { title: 'creator', order: 35, view: 'text', type: 'string' },
  createdept: { title: 'createdept', order: 36, view: 'text', type: 'string' },
  isConfirm: { title: 'isConfirm', order: 37, view: 'text', type: 'string' },
  password: { title: 'password', order: 38, view: 'text', type: 'string' },
  ifwf: { title: 'ifwf', order: 39, view: 'text', type: 'string' },
  entbelongtoCity: { title: 'entbelongtoCity', order: 40, view: 'text', type: 'string' },
  entbelongtoDomain: { title: 'entbelongtoDomain', order: 41, view: 'text', type: 'string' },
  entbelongtoTown: { title: 'entbelongtoTown', order: 42, view: 'text', type: 'string' },
  admindivision: { title: 'admindivision', order: 43, view: 'text', type: 'string' },
  sync: { title: 'sync', order: 44, view: 'text', type: 'string' },
  syncZs: { title: 'syncZs', order: 45, view: 'text', type: 'string' },
  processflag: { title: 'processflag', order: 46, view: 'text', type: 'string' },
  lastudate: { title: 'lastudate', order: 47, view: 'date', type: 'string' },
  lastudept: { title: 'lastudept', order: 48, view: 'text', type: 'string' },
  repeatdel: { title: 'repeatdel', order: 49, view: 'text', type: 'string' },
  sjzlSjly: { title: 'sjzlSjly', order: 50, view: 'text', type: 'string' },
  ckdz: { title: 'ckdz', order: 51, view: 'textarea', type: 'string' },
  djjg: { title: 'djjg', order: 52, view: 'text', type: 'string' },
  djsj: { title: 'djsj', order: 53, view: 'date', type: 'string' },
  fddbrsjh: { title: 'fddbrsjh', order: 54, view: 'text', type: 'string' },
  gsqylx: { title: 'gsqylx', order: 55, view: 'text', type: 'string' },
  jjhy: { title: 'jjhy', order: 56, view: 'text', type: 'string' },
  jjlx: { title: 'jjlx', order: 57, view: 'text', type: 'string' },
  jydz: { title: 'jydz', order: 58, view: 'textarea', type: 'string' },
  jyfw: { title: 'jyfw', order: 59, view: 'textarea', type: 'string' },
  qygm: { title: 'qygm', order: 60, view: 'text', type: 'string' },
  qyzclx: { title: 'qyzclx', order: 61, view: 'text', type: 'string' },
  qyzjlx: { title: 'qyzjlx', order: 62, view: 'text', type: 'string' },
  qyzt: { title: 'qyzt', order: 63, view: 'text', type: 'string' },
  sfgmys: { title: 'sfgmys', order: 64, view: 'text', type: 'string' },
  xzjddm: { title: 'xzjddm', order: 65, view: 'text', type: 'string' },
  zczb: { title: 'zczb', order: 66, view: 'number', type: 'number' },
  zczbdw: { title: 'zczbdw', order: 67, view: 'text', type: 'string' },
  sjzlsjly: { title: 'sjzlsjly', order: 68, view: 'text', type: 'string' },
  dashxydm: { title: 'dashxydm', order: 69, view: 'text', type: 'string' },
  fax: { title: 'fax', order: 70, view: 'text', type: 'string' },
  jgfj: { title: 'jgfj', order: 71, view: 'text', type: 'string' },
  scdz: { title: 'scdz', order: 72, view: 'textarea', type: 'string' },
  syncScj: { title: 'syncScj', order: 73, view: 'text', type: 'string' },
  sessionid: { title: 'sessionid', order: 74, view: 'text', type: 'string' },
  sjly: { title: 'sjly', order: 75, view: 'text', type: 'string' },
  flag: { title: 'flag', order: 76, view: 'text', type: 'string' },
  zwfwparam: { title: 'zwfwparam', order: 77, view: 'textarea', type: 'string' },
  syncZyzjba: { title: 'syncZyzjba', order: 78, view: 'text', type: 'string' },
  syncSjzl: { title: 'syncSjzl', order: 79, view: 'text', type: 'string' },
  syncZsxt: { title: 'syncZsxt', order: 80, view: 'text', type: 'string' },
  issc: { title: 'issc', order: 81, view: 'text', type: 'string' },
  synctime: { title: 'synctime', order: 82, view: 'text', type: 'string' },
};

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
