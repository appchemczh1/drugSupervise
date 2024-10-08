import { BasicColumn } from '/@/components/Table';

export const columns: BasicColumn[] = [
  {
    title: '证书类型',
    align: 'center',
    dataIndex: 'certtypename',
    width: 200,
  },
  {
    title: '企业名称',
    align: 'center',
    dataIndex: 'qymc',
    width: 200,
  },
  /*{
    title: '证书类型',
    align: "center",
    dataIndex: 'zslx'
  },*/
  {
    width: 150,
    title: '证书编号',
    align: 'center',
    dataIndex: 'zsbh',
  },
  {
    width: 150,
    title: '社会统一信用代码',
    align: 'center',
    dataIndex: 'shxydm',
  },
  {
    title: '盖章状态',
    width: 100,
    align: 'center',
    dataIndex: 'zt_dictText',
  },
  {
    width: 100,
    title: '状态',
    align: 'center',
    dataIndex: 'czzt_dictText',
  },
];
