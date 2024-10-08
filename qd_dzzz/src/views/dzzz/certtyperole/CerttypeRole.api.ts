import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/dzzz.certtyperole/certtypeRole/list',
  save='/dzzz.certtyperole/certtypeRole/add',
  edit='/dzzz.certtypedetail/certtypeRoledetail/add',
  findDetail='/dzzz.certtypedetail/certtypeRoledetail/getDetail',
  findDetailInner='/dzzz.certtypedetail/certtypeRoledetail/getDetailInner',
  deleteOne = '/dzzz.certtyperole/certtypeRole/delete',
  deleteBatch = '/dzzz.certtyperole/certtypeRole/deleteBatch',
  importExcel = '/dzzz.certtyperole/certtypeRole/importExcel',
  exportXls = '/dzzz.certtyperole/certtypeRole/exportXls',
  certmetelist='/dzzz.certinfo/certInfo/queryCertMetadateByIdelse',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;
/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;
export const certmetelist = Api.certmetelist;

/**
 * 列表接口
 * @param params
 */
export const list = (params) =>
  defHttp.get({url: Api.list, params});

/**
 * 删除单个
 */
export const deleteOne = (params,handleSuccess) => {
  return defHttp.delete({url: Api.deleteOne, params}, {joinParamsToUrl: true}).then(() => {
    handleSuccess();
  });
}
/**
 * 批量删除
 * @param params
 */
export const batchDelete = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({url: Api.deleteBatch, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({url: url, params});
}
export const getcertmetelist = (params) => {
  let url =  Api.certmetelist ;
  return defHttp.get({url: url, params});
}

export const findDetail = (params) => {
  let url =  Api.findDetail ;
  return defHttp.post({url: url, params});
}

export const findDetailInner = (params) => {
  let url =  Api.findDetailInner ;
  return defHttp.post({url: url, params});
}
