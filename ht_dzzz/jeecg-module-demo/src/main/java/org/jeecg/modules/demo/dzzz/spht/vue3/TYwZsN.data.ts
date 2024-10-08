import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'qyid',
    align:"center",
    dataIndex: 'qyid'
   },
   {
    title: 'zslx',
    align:"center",
    dataIndex: 'zslx'
   },
   {
    title: 'zsbh',
    align:"center",
    dataIndex: 'zsbh'
   },
   {
    title: 'qymc',
    align:"center",
    dataIndex: 'qymc'
   },
   {
    title: 'shxydm',
    align:"center",
    dataIndex: 'shxydm'
   },
   {
    title: 'zcdz',
    align:"center",
    dataIndex: 'zcdz'
   },
   {
    title: 'fddbr',
    align:"center",
    dataIndex: 'fddbr'
   },
   {
    title: 'qyfzr',
    align:"center",
    dataIndex: 'qyfzr'
   },
   {
    title: 'zlfzr',
    align:"center",
    dataIndex: 'zlfzr'
   },
   {
    title: 'flm',
    align:"center",
    dataIndex: 'flm'
   },
   {
    title: 'rcjdgljg',
    align:"center",
    dataIndex: 'rcjdgljg'
   },
   {
    title: 'rcjdglry',
    align:"center",
    dataIndex: 'rcjdglry'
   },
   {
    title: 'scdzhfw',
    align:"center",
    dataIndex: 'scdzhfw'
   },
   {
    title: 'fzjg',
    align:"center",
    dataIndex: 'fzjg'
   },
   {
    title: 'qfr',
    align:"center",
    dataIndex: 'qfr'
   },
   {
    title: 'fzrq',
    align:"center",
    dataIndex: 'fzrq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'yxqq',
    align:"center",
    dataIndex: 'yxqq',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'yxqz',
    align:"center",
    dataIndex: 'yxqz',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'scdz',
    align:"center",
    dataIndex: 'scdz'
   },
   {
    title: 'slh',
    align:"center",
    dataIndex: 'slh'
   },
   {
    title: 'ckdz',
    align:"center",
    dataIndex: 'ckdz'
   },
   {
    title: 'jgjzc',
    align:"center",
    dataIndex: 'jgjzc'
   },
   {
    title: 'fw',
    align:"center",
    dataIndex: 'fw'
   },
   {
    title: 'fwyw',
    align:"center",
    dataIndex: 'fwyw'
   },
   {
    title: 'bz',
    align:"center",
    dataIndex: 'bz'
   },
   {
    title: 'zs',
    align:"center",
    dataIndex: 'zs'
   },
   {
    title: 'cs',
    align:"center",
    dataIndex: 'cs'
   },
   {
    title: 'cp',
    align:"center",
    dataIndex: 'cp'
   },
   {
    title: 'cplb',
    align:"center",
    dataIndex: 'cplb'
   },
   {
    title: 'cpmx',
    align:"center",
    dataIndex: 'cpmx'
   },
   {
    title: 'dh',
    align:"center",
    dataIndex: 'dh'
   },
   {
    title: 'cz',
    align:"center",
    dataIndex: 'cz'
   },
   {
    title: 'gg',
    align:"center",
    dataIndex: 'gg'
   },
   {
    title: 'jx',
    align:"center",
    dataIndex: 'jx'
   },
   {
    title: 'fj',
    align:"center",
    dataIndex: 'fj'
   },
   {
    title: 'wzym',
    align:"center",
    dataIndex: 'wzym'
   },
   {
    title: 'jsly',
    align:"center",
    dataIndex: 'jsly'
   },
   {
    title: 'zt',
    align:"center",
    dataIndex: 'zt'
   },
   {
    title: 'ywlb',
    align:"center",
    dataIndex: 'ywlb'
   },
   {
    title: 'bbid',
    align:"center",
    dataIndex: 'bbid'
   },
   {
    title: 'mbid',
    align:"center",
    dataIndex: 'mbid'
   },
   {
    title: 'ylzd1',
    align:"center",
    dataIndex: 'ylzd1'
   },
   {
    title: 'ylzd2',
    align:"center",
    dataIndex: 'ylzd2'
   },
   {
    title: 'ylzd3',
    align:"center",
    dataIndex: 'ylzd3'
   },
   {
    title: 'ylzd4',
    align:"center",
    dataIndex: 'ylzd4'
   },
   {
    title: 'ylzd5',
    align:"center",
    dataIndex: 'ylzd5'
   },
   {
    title: 'fzjgid',
    align:"center",
    dataIndex: 'fzjgid'
   },
   {
    title: 'sjtbZsgs',
    align:"center",
    dataIndex: 'sjtbZsgs'
   },
   {
    title: 'sjtbDa',
    align:"center",
    dataIndex: 'sjtbDa'
   },
   {
    title: 'sjtbXzsp',
    align:"center",
    dataIndex: 'sjtbXzsp'
   },
   {
    title: 'sjtbGj',
    align:"center",
    dataIndex: 'sjtbGj'
   },
   {
    title: 'sjtbCwxx',
    align:"center",
    dataIndex: 'sjtbCwxx'
   },
   {
    title: 'sjtbGjsj',
    align:"center",
    dataIndex: 'sjtbGjsj',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: 'ylzd6',
    align:"center",
    dataIndex: 'ylzd6'
   },
   {
    title: 'ylzd7',
    align:"center",
    dataIndex: 'ylzd7'
   },
   {
    title: 'ylzd8',
    align:"center",
    dataIndex: 'ylzd8'
   },
   {
    title: 'ylzd9',
    align:"center",
    dataIndex: 'ylzd9'
   },
   {
    title: 'ylzd10',
    align:"center",
    dataIndex: 'ylzd10'
   },
   {
    title: 'ylzd11',
    align:"center",
    dataIndex: 'ylzd11'
   },
   {
    title: 'ylzd12',
    align:"center",
    dataIndex: 'ylzd12'
   },
   {
    title: 'ylzd13',
    align:"center",
    dataIndex: 'ylzd13'
   },
   {
    title: 'ylzd14',
    align:"center",
    dataIndex: 'ylzd14'
   },
   {
    title: 'ylzd15',
    align:"center",
    dataIndex: 'ylzd15'
   },
   {
    title: 'ylzd16',
    align:"center",
    dataIndex: 'ylzd16'
   },
   {
    title: 'ylzd17',
    align:"center",
    dataIndex: 'ylzd17'
   },
   {
    title: 'ylzd18',
    align:"center",
    dataIndex: 'ylzd18'
   },
   {
    title: 'ylzd19',
    align:"center",
    dataIndex: 'ylzd19'
   },
   {
    title: 'ylzd20',
    align:"center",
    dataIndex: 'ylzd20'
   },
   {
    title: 'ylzd21',
    align:"center",
    dataIndex: 'ylzd21'
   },
   {
    title: 'ylzd22',
    align:"center",
    dataIndex: 'ylzd22'
   },
   {
    title: 'ylzd23',
    align:"center",
    dataIndex: 'ylzd23'
   },
   {
    title: 'ylzd24',
    align:"center",
    dataIndex: 'ylzd24'
   },
   {
    title: 'ylzd25',
    align:"center",
    dataIndex: 'ylzd25'
   },
   {
    title: 'ylzd26',
    align:"center",
    dataIndex: 'ylzd26'
   },
   {
    title: 'ylzd27',
    align:"center",
    dataIndex: 'ylzd27'
   },
   {
    title: 'ylzd28',
    align:"center",
    dataIndex: 'ylzd28'
   },
   {
    title: 'ylzd29',
    align:"center",
    dataIndex: 'ylzd29'
   },
   {
    title: 'ylzd30',
    align:"center",
    dataIndex: 'ylzd30'
   },
   {
    title: 'ylzd31',
    align:"center",
    dataIndex: 'ylzd31'
   },
   {
    title: 'ylzd32',
    align:"center",
    dataIndex: 'ylzd32'
   },
   {
    title: 'ylzd33',
    align:"center",
    dataIndex: 'ylzd33'
   },
   {
    title: 'ylzd34',
    align:"center",
    dataIndex: 'ylzd34'
   },
   {
    title: 'ylzd35',
    align:"center",
    dataIndex: 'ylzd35'
   },
   {
    title: 'ylzd36',
    align:"center",
    dataIndex: 'ylzd36'
   },
   {
    title: 'ylzd37',
    align:"center",
    dataIndex: 'ylzd37'
   },
   {
    title: 'ylzd38',
    align:"center",
    dataIndex: 'ylzd38'
   },
   {
    title: 'ylzd39',
    align:"center",
    dataIndex: 'ylzd39'
   },
   {
    title: 'ylzd40',
    align:"center",
    dataIndex: 'ylzd40'
   },
   {
    title: 'ewm',
    align:"center",
    dataIndex: 'ewmString'
   },
   {
    title: 'ewmlj',
    align:"center",
    dataIndex: 'ewmlj'
   },
   {
    title: 'sync',
    align:"center",
    dataIndex: 'sync'
   },
   {
    title: 'glzdb',
    align:"center",
    dataIndex: 'glzdb'
   },
   {
    title: 'qylx',
    align:"center",
    dataIndex: 'qylx'
   },
   {
    title: 'lxryx',
    align:"center",
    dataIndex: 'lxryx'
   },
   {
    title: 'lxdh',
    align:"center",
    dataIndex: 'lxdh'
   },
   {
    title: 'typelevel',
    align:"center",
    dataIndex: 'typelevel'
   },
   {
    title: 'mobile',
    align:"center",
    dataIndex: 'mobile'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'qyid',
    field: 'qyid',
    component: 'Input',
  },
  {
    label: 'zslx',
    field: 'zslx',
    component: 'InputNumber',
  },
  {
    label: 'zsbh',
    field: 'zsbh',
    component: 'InputTextArea',
  },
  {
    label: 'qymc',
    field: 'qymc',
    component: 'Input',
  },
  {
    label: 'shxydm',
    field: 'shxydm',
    component: 'InputTextArea',
  },
  {
    label: 'zcdz',
    field: 'zcdz',
    component: 'InputTextArea',
  },
  {
    label: 'fddbr',
    field: 'fddbr',
    component: 'Input',
  },
  {
    label: 'qyfzr',
    field: 'qyfzr',
    component: 'Input',
  },
  {
    label: 'zlfzr',
    field: 'zlfzr',
    component: 'Input',
  },
  {
    label: 'flm',
    field: 'flm',
    component: 'Input',
  },
  {
    label: 'rcjdgljg',
    field: 'rcjdgljg',
    component: 'Input',
  },
  {
    label: 'rcjdglry',
    field: 'rcjdglry',
    component: 'InputTextArea',
  },
  {
    label: 'scdzhfw',
    field: 'scdzhfw',
    component: 'InputTextArea',
  },
  {
    label: 'fzjg',
    field: 'fzjg',
    component: 'Input',
  },
  {
    label: 'qfr',
    field: 'qfr',
    component: 'Input',
  },
  {
    label: 'fzrq',
    field: 'fzrq',
    component: 'DatePicker',
  },
  {
    label: 'yxqq',
    field: 'yxqq',
    component: 'DatePicker',
  },
  {
    label: 'yxqz',
    field: 'yxqz',
    component: 'DatePicker',
  },
  {
    label: 'scdz',
    field: 'scdz',
    component: 'InputTextArea',
  },
  {
    label: 'slh',
    field: 'slh',
    component: 'Input',
  },
  {
    label: 'ckdz',
    field: 'ckdz',
    component: 'InputTextArea',
  },
  {
    label: 'jgjzc',
    field: 'jgjzc',
    component: 'InputTextArea',
  },
  {
    label: 'fw',
    field: 'fw',
    component: 'InputTextArea',
  },
  {
    label: 'fwyw',
    field: 'fwyw',
    component: 'InputTextArea',
  },
  {
    label: 'bz',
    field: 'bz',
    component: 'InputTextArea',
  },
  {
    label: 'zs',
    field: 'zs',
    component: 'Input',
  },
  {
    label: 'cs',
    field: 'cs',
    component: 'Input',
  },
  {
    label: 'cp',
    field: 'cp',
    component: 'Input',
  },
  {
    label: 'cplb',
    field: 'cplb',
    component: 'InputTextArea',
  },
  {
    label: 'cpmx',
    field: 'cpmx',
    component: 'Input',
  },
  {
    label: 'dh',
    field: 'dh',
    component: 'Input',
  },
  {
    label: 'cz',
    field: 'cz',
    component: 'Input',
  },
  {
    label: 'gg',
    field: 'gg',
    component: 'InputTextArea',
  },
  {
    label: 'jx',
    field: 'jx',
    component: 'Input',
  },
  {
    label: 'fj',
    field: 'fj',
    component: 'InputTextArea',
  },
  {
    label: 'wzym',
    field: 'wzym',
    component: 'Input',
  },
  {
    label: 'jsly',
    field: 'jsly',
    component: 'InputNumber',
  },
  {
    label: 'zt',
    field: 'zt',
    component: 'InputNumber',
  },
  {
    label: 'ywlb',
    field: 'ywlb',
    component: 'InputNumber',
  },
  {
    label: 'bbid',
    field: 'bbid',
    component: 'Input',
  },
  {
    label: 'mbid',
    field: 'mbid',
    component: 'Input',
  },
  {
    label: 'ylzd1',
    field: 'ylzd1',
    component: 'Input',
  },
  {
    label: 'ylzd2',
    field: 'ylzd2',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd3',
    field: 'ylzd3',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd4',
    field: 'ylzd4',
    component: 'Input',
  },
  {
    label: 'ylzd5',
    field: 'ylzd5',
    component: 'Input',
  },
  {
    label: 'fzjgid',
    field: 'fzjgid',
    component: 'Input',
  },
  {
    label: 'sjtbZsgs',
    field: 'sjtbZsgs',
    component: 'InputNumber',
  },
  {
    label: 'sjtbDa',
    field: 'sjtbDa',
    component: 'InputNumber',
  },
  {
    label: 'sjtbXzsp',
    field: 'sjtbXzsp',
    component: 'InputNumber',
  },
  {
    label: 'sjtbGj',
    field: 'sjtbGj',
    component: 'InputNumber',
  },
  {
    label: 'sjtbCwxx',
    field: 'sjtbCwxx',
    component: 'InputTextArea',
  },
  {
    label: 'sjtbGjsj',
    field: 'sjtbGjsj',
    component: 'DatePicker',
  },
  {
    label: 'ylzd6',
    field: 'ylzd6',
    component: 'Input',
  },
  {
    label: 'ylzd7',
    field: 'ylzd7',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd8',
    field: 'ylzd8',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd9',
    field: 'ylzd9',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd10',
    field: 'ylzd10',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd11',
    field: 'ylzd11',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd12',
    field: 'ylzd12',
    component: 'Input',
  },
  {
    label: 'ylzd13',
    field: 'ylzd13',
    component: 'Input',
  },
  {
    label: 'ylzd14',
    field: 'ylzd14',
    component: 'Input',
  },
  {
    label: 'ylzd15',
    field: 'ylzd15',
    component: 'Input',
  },
  {
    label: 'ylzd16',
    field: 'ylzd16',
    component: 'Input',
  },
  {
    label: 'ylzd17',
    field: 'ylzd17',
    component: 'Input',
  },
  {
    label: 'ylzd18',
    field: 'ylzd18',
    component: 'Input',
  },
  {
    label: 'ylzd19',
    field: 'ylzd19',
    component: 'Input',
  },
  {
    label: 'ylzd20',
    field: 'ylzd20',
    component: 'Input',
  },
  {
    label: 'ylzd21',
    field: 'ylzd21',
    component: 'Input',
  },
  {
    label: 'ylzd22',
    field: 'ylzd22',
    component: 'Input',
  },
  {
    label: 'ylzd23',
    field: 'ylzd23',
    component: 'Input',
  },
  {
    label: 'ylzd24',
    field: 'ylzd24',
    component: 'Input',
  },
  {
    label: 'ylzd25',
    field: 'ylzd25',
    component: 'Input',
  },
  {
    label: 'ylzd26',
    field: 'ylzd26',
    component: 'Input',
  },
  {
    label: 'ylzd27',
    field: 'ylzd27',
    component: 'Input',
  },
  {
    label: 'ylzd28',
    field: 'ylzd28',
    component: 'Input',
  },
  {
    label: 'ylzd29',
    field: 'ylzd29',
    component: 'Input',
  },
  {
    label: 'ylzd30',
    field: 'ylzd30',
    component: 'Input',
  },
  {
    label: 'ylzd31',
    field: 'ylzd31',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd32',
    field: 'ylzd32',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd33',
    field: 'ylzd33',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd34',
    field: 'ylzd34',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd35',
    field: 'ylzd35',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd36',
    field: 'ylzd36',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd37',
    field: 'ylzd37',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd38',
    field: 'ylzd38',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd39',
    field: 'ylzd39',
    component: 'InputTextArea',
  },
  {
    label: 'ylzd40',
    field: 'ylzd40',
    component: 'InputTextArea',
  },
  {
    label: 'ewm',
    field: 'ewmString',
    component: 'Input',
  },
  {
    label: 'ewmlj',
    field: 'ewmlj',
    component: 'Input',
  },
  {
    label: 'sync',
    field: 'sync',
    component: 'InputNumber',
  },
  {
    label: 'glzdb',
    field: 'glzdb',
    component: 'Input',
  },
  {
    label: 'qylx',
    field: 'qylx',
    component: 'Input',
  },
  {
    label: 'lxryx',
    field: 'lxryx',
    component: 'Input',
  },
  {
    label: 'lxdh',
    field: 'lxdh',
    component: 'Input',
  },
  {
    label: 'typelevel',
    field: 'typelevel',
    component: 'Input',
  },
  {
    label: 'mobile',
    field: 'mobile',
    component: 'Input',
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
  qyid: {title: 'qyid',order: 0,view: 'text', type: 'string',},
  zslx: {title: 'zslx',order: 1,view: 'number', type: 'number',},
  zsbh: {title: 'zsbh',order: 2,view: 'textarea', type: 'string',},
  qymc: {title: 'qymc',order: 3,view: 'text', type: 'string',},
  shxydm: {title: 'shxydm',order: 4,view: 'textarea', type: 'string',},
  zcdz: {title: 'zcdz',order: 5,view: 'textarea', type: 'string',},
  fddbr: {title: 'fddbr',order: 6,view: 'text', type: 'string',},
  qyfzr: {title: 'qyfzr',order: 7,view: 'text', type: 'string',},
  zlfzr: {title: 'zlfzr',order: 8,view: 'text', type: 'string',},
  flm: {title: 'flm',order: 9,view: 'text', type: 'string',},
  rcjdgljg: {title: 'rcjdgljg',order: 10,view: 'text', type: 'string',},
  rcjdglry: {title: 'rcjdglry',order: 11,view: 'textarea', type: 'string',},
  scdzhfw: {title: 'scdzhfw',order: 12,view: 'textarea', type: 'string',},
  fzjg: {title: 'fzjg',order: 13,view: 'text', type: 'string',},
  qfr: {title: 'qfr',order: 14,view: 'text', type: 'string',},
  fzrq: {title: 'fzrq',order: 15,view: 'date', type: 'string',},
  yxqq: {title: 'yxqq',order: 16,view: 'date', type: 'string',},
  yxqz: {title: 'yxqz',order: 17,view: 'date', type: 'string',},
  scdz: {title: 'scdz',order: 18,view: 'textarea', type: 'string',},
  slh: {title: 'slh',order: 19,view: 'text', type: 'string',},
  ckdz: {title: 'ckdz',order: 20,view: 'textarea', type: 'string',},
  jgjzc: {title: 'jgjzc',order: 21,view: 'textarea', type: 'string',},
  fw: {title: 'fw',order: 22,view: 'textarea', type: 'string',},
  fwyw: {title: 'fwyw',order: 23,view: 'textarea', type: 'string',},
  bz: {title: 'bz',order: 24,view: 'textarea', type: 'string',},
  zs: {title: 'zs',order: 25,view: 'text', type: 'string',},
  cs: {title: 'cs',order: 26,view: 'text', type: 'string',},
  cp: {title: 'cp',order: 27,view: 'text', type: 'string',},
  cplb: {title: 'cplb',order: 28,view: 'textarea', type: 'string',},
  cpmx: {title: 'cpmx',order: 29,view: 'text', type: 'string',},
  dh: {title: 'dh',order: 30,view: 'text', type: 'string',},
  cz: {title: 'cz',order: 31,view: 'text', type: 'string',},
  gg: {title: 'gg',order: 32,view: 'textarea', type: 'string',},
  jx: {title: 'jx',order: 33,view: 'text', type: 'string',},
  fj: {title: 'fj',order: 34,view: 'textarea', type: 'string',},
  wzym: {title: 'wzym',order: 35,view: 'text', type: 'string',},
  jsly: {title: 'jsly',order: 36,view: 'number', type: 'number',},
  zt: {title: 'zt',order: 37,view: 'number', type: 'number',},
  ywlb: {title: 'ywlb',order: 38,view: 'number', type: 'number',},
  bbid: {title: 'bbid',order: 39,view: 'text', type: 'string',},
  mbid: {title: 'mbid',order: 40,view: 'text', type: 'string',},
  ylzd1: {title: 'ylzd1',order: 41,view: 'text', type: 'string',},
  ylzd2: {title: 'ylzd2',order: 42,view: 'textarea', type: 'string',},
  ylzd3: {title: 'ylzd3',order: 43,view: 'textarea', type: 'string',},
  ylzd4: {title: 'ylzd4',order: 44,view: 'text', type: 'string',},
  ylzd5: {title: 'ylzd5',order: 45,view: 'text', type: 'string',},
  fzjgid: {title: 'fzjgid',order: 46,view: 'text', type: 'string',},
  sjtbZsgs: {title: 'sjtbZsgs',order: 47,view: 'number', type: 'number',},
  sjtbDa: {title: 'sjtbDa',order: 48,view: 'number', type: 'number',},
  sjtbXzsp: {title: 'sjtbXzsp',order: 49,view: 'number', type: 'number',},
  sjtbGj: {title: 'sjtbGj',order: 50,view: 'number', type: 'number',},
  sjtbCwxx: {title: 'sjtbCwxx',order: 51,view: 'textarea', type: 'string',},
  sjtbGjsj: {title: 'sjtbGjsj',order: 52,view: 'date', type: 'string',},
  ylzd6: {title: 'ylzd6',order: 53,view: 'text', type: 'string',},
  ylzd7: {title: 'ylzd7',order: 54,view: 'textarea', type: 'string',},
  ylzd8: {title: 'ylzd8',order: 55,view: 'textarea', type: 'string',},
  ylzd9: {title: 'ylzd9',order: 56,view: 'textarea', type: 'string',},
  ylzd10: {title: 'ylzd10',order: 57,view: 'textarea', type: 'string',},
  ylzd11: {title: 'ylzd11',order: 58,view: 'textarea', type: 'string',},
  ylzd12: {title: 'ylzd12',order: 59,view: 'text', type: 'string',},
  ylzd13: {title: 'ylzd13',order: 60,view: 'text', type: 'string',},
  ylzd14: {title: 'ylzd14',order: 61,view: 'text', type: 'string',},
  ylzd15: {title: 'ylzd15',order: 62,view: 'text', type: 'string',},
  ylzd16: {title: 'ylzd16',order: 63,view: 'text', type: 'string',},
  ylzd17: {title: 'ylzd17',order: 64,view: 'text', type: 'string',},
  ylzd18: {title: 'ylzd18',order: 65,view: 'text', type: 'string',},
  ylzd19: {title: 'ylzd19',order: 66,view: 'text', type: 'string',},
  ylzd20: {title: 'ylzd20',order: 67,view: 'text', type: 'string',},
  ylzd21: {title: 'ylzd21',order: 68,view: 'text', type: 'string',},
  ylzd22: {title: 'ylzd22',order: 69,view: 'text', type: 'string',},
  ylzd23: {title: 'ylzd23',order: 70,view: 'text', type: 'string',},
  ylzd24: {title: 'ylzd24',order: 71,view: 'text', type: 'string',},
  ylzd25: {title: 'ylzd25',order: 72,view: 'text', type: 'string',},
  ylzd26: {title: 'ylzd26',order: 73,view: 'text', type: 'string',},
  ylzd27: {title: 'ylzd27',order: 74,view: 'text', type: 'string',},
  ylzd28: {title: 'ylzd28',order: 75,view: 'text', type: 'string',},
  ylzd29: {title: 'ylzd29',order: 76,view: 'text', type: 'string',},
  ylzd30: {title: 'ylzd30',order: 77,view: 'text', type: 'string',},
  ylzd31: {title: 'ylzd31',order: 78,view: 'textarea', type: 'string',},
  ylzd32: {title: 'ylzd32',order: 79,view: 'textarea', type: 'string',},
  ylzd33: {title: 'ylzd33',order: 80,view: 'textarea', type: 'string',},
  ylzd34: {title: 'ylzd34',order: 81,view: 'textarea', type: 'string',},
  ylzd35: {title: 'ylzd35',order: 82,view: 'textarea', type: 'string',},
  ylzd36: {title: 'ylzd36',order: 83,view: 'textarea', type: 'string',},
  ylzd37: {title: 'ylzd37',order: 84,view: 'textarea', type: 'string',},
  ylzd38: {title: 'ylzd38',order: 85,view: 'textarea', type: 'string',},
  ylzd39: {title: 'ylzd39',order: 86,view: 'textarea', type: 'string',},
  ylzd40: {title: 'ylzd40',order: 87,view: 'textarea', type: 'string',},
  ewm: {title: 'ewm',order: 88,view: 'text', type: 'string',},
  ewmlj: {title: 'ewmlj',order: 89,view: 'text', type: 'string',},
  sync: {title: 'sync',order: 90,view: 'number', type: 'number',},
  glzdb: {title: 'glzdb',order: 91,view: 'text', type: 'string',},
  qylx: {title: 'qylx',order: 92,view: 'text', type: 'string',},
  lxryx: {title: 'lxryx',order: 93,view: 'text', type: 'string',},
  lxdh: {title: 'lxdh',order: 94,view: 'text', type: 'string',},
  typelevel: {title: 'typelevel',order: 95,view: 'text', type: 'string',},
  mobile: {title: 'mobile',order: 96,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}