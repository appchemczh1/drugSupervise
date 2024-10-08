import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/dzzz.certmatadataversion/certMetadataVersion/list',
  save='/dzzz.certmatadataversion/certMetadataVersion/add',
  edit='/dzzz.certmatadataversion/certMetadataVersion/edit',
  deleteOne = '/dzzz.certmatadataversion/certMetadataVersion/delete',
  deleteBatch = '/dzzz.certmatadataversion/certMetadataVersion/deleteBatch',
  importExcel = '/dzzz.certmatadataversion/certMetadataVersion/importExcel',
  exportXls = '/dzzz.certmatadataversion/certMetadataVersion/exportXls',
  certMetadataList = '/dzzz.certmatadataversion/certMetadataVersion/listCertMetadataByMainId',
  certMetadataSave='/dzzz.certmatadataversion/certMetadataVersion/addCertMetadata',
  certMetadataEdit='/dzzz.certmatadataversion/certMetadataVersion/editCertMetadata',
  certMetadataDelete = '/dzzz.certmatadataversion/certMetadataVersion/deleteCertMetadata',
  certMetadataDeleteBatch = '/dzzz.certmatadataversion/certMetadataVersion/deleteBatchCertMetadata',
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
/**
 * 列表接口
 * @param params
 */
export const certMetadataList = (params) => {
  if(params['certmetadataversionId']){
    return defHttp.get({url: Api.certMetadataList, params});
  }
  return Promise.resolve({});
}


/**
 * 删除单个
 */
export const certMetadataDelete = (params,handleSuccess) => {
  return defHttp.delete({url: Api.certMetadataDelete, params}, {joinParamsToUrl: true}).then(() => {
    handleSuccess();
  });
}
/**
 * 批量删除
 * @param params
 */
export const certMetadataDeleteBatch = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({url: Api.certMetadataDeleteBatch, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
/**
 * 保存或者更新
 * @param params
 */
export const  certMetadataSaveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.certMetadataEdit : Api.certMetadataSave;
  return defHttp.post({url: url, params});
}
/**
 * 导入
 */
export const certMetadataImportUrl = '/dzzz.certmatadataversion/certMetadataVersion/importCertMetadata'

/**
 * 导出
 */
export const certMetadataExportXlsUrl = '/dzzz.certmatadataversion/certMetadataVersion/exportCertMetadata'
