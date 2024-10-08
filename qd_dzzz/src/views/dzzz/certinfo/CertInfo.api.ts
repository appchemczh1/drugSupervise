import { defHttp } from '/@/utils/http/axios';
import { useMessage } from '/@/hooks/web/useMessage';

const { createConfirm } = useMessage();

enum Api {
  list = '/dzzz.certinfo/certInfo/list',
  wgzlist = '/dzzz.wgz/zsYwxxb/list',
  bgxxlist = '/dzzz/certInfoOperationRecord/list',
  save = '/dzzz.certinfo/certInfo/add',
  edit = '/dzzz.certinfo/certInfo/edit',
  editdetial = '/dzzz.certinfo/certInfo/editdetial',
  updateFj = '/dzzz.certinfo/certInfo/updateFj',
  deleteOne = '/dzzz.certinfo/certInfo/delete',
  deleteBatch = '/dzzz.certinfo/certInfo/deleteBatch',
  importExcel = '/dzzz.certinfo/certInfo/importExcel',
  exportXls = '/dzzz.certinfo/certInfo/exportXls',
  exportYgzXls = '/dzzz.certinfo/certInfo/exportYgzXls',
  certchildYpscZcList = '/dzzz.certinfo/certInfo/queryCertchildYpscZcByMainId',
  certchildYpscWtList = '/dzzz.certinfo/certInfo/queryCertchildYpscWtByMainId',
  certchildYpscStList = '/dzzz.certinfo/certInfo/queryCertchildYpscStByMainId',
  certmetelist = '/dzzz.certinfo/certInfo/queryCertMetadateById',
  generate_gz_cert = '/dzzz.certinfo/certInfo/batchGz',
  getAttachByCertid = '/dzzz.certinfo/certInfo/getAttachByCertid',
  bianGeng = '/dzzz.certinfo/certInfo/bianGeng',
  huanZheng = '/dzzz.certinfo/certInfo/huanZheng',
  zhuXiao = '/dzzz.certinfo/certInfo/zhuXiao',
  cancleGz = '/dzzz.certinfo/certInfo/cancleGz',
  getzminfodata = '/dzzz.certinfo/certInfo/getzminfodata',
  certchildYlqxwtbaZbList = '/dzzz.certinfo/certInfo/queryCertchildYlqxwtbaZbByMainId',
  certchildYlqxscbaZbList = '/dzzz.certinfo/certInfo/queryCertchildYlqxscbaZbByMainId',
  certchildYpckxkzList = '/dzzz.certinfo/certInfo/queryCertchildYpckxkzByMainId',
  certchirdYlqxlcsybaList = '/dzzz.certinfo/certInfo/queryCertchirdYlqxlcsybaByMainId',
  certchildYlqxcpckxsList = '/dzzz.certinfo/certInfo/queryCertchildYlqxcpckxsByMainId',
  certchildMzyphjsypddscList = '/dzzz.certinfo/certInfo/queryCertchildMzyphjsypddscByMainId',
  certchildYpckxszmList = '/dzzz.certinfo/certInfo/queryCertchildYpckxszmByMainId',
  certchildYpscGmpList = '/dzzz.certinfo/certInfo/queryCertchildYpscGmpByMainId',
  certchildCkomylyList = '/dzzz.certinfo/certInfo/queryCertchildCkomylyByMainId',
  getCerttypeNameAndValue = '/dzzz/certmulu/queryList',
  alllist='/dzzz.certinfo/certInfo/alllist',
  getshiyanlist = '/dzzz.shiyan2/tJcZsYpscxkJbxxLs/list',
  certchildYlqxwlxsbaList = '/dzzz.certinfo/certInfo/queryCertchildYlqxwlxsbaByMainId',
  certchildDylylqxscbapzList = '/dzzz.certinfo/certInfo/queryCertchildDylylqxscbapzByMainId',
  shenhe='/dzzz.certinfo/certInfo/shenhe',
  back='/dzzz.certinfo/certInfo/back',
  getCertInfoByZsId = '/dzzz.certinfo/certInfo/queryByZsId',
  maintainApply = '/dzzz.certinfo/certInfo/maintainApply',
  saveBl = '/dzzz.certinfo/certInfo/saveBl',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;

/**
 * 已盖章导出api
 * @param params
 */
export const getYgzExportUrl = Api.exportYgzXls;

/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;

export const getCerttypeNameAndValue = Api.getCerttypeNameAndValue;
export const getshiyanlist
  = (params) => defHttp.get({ url: Api.getshiyanlist
  , params });

/**
 * 查询子表数据
 * @param params
 */
export const certchildYpscZcList = Api.certchildYpscZcList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYpscWtList = Api.certchildYpscWtList;

export const certchildYlqxwlxsbaList = Api.certchildYlqxwlxsbaList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildDylylqxscbapzList = Api.certchildDylylqxscbapzList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYpscStList = Api.certchildYpscStList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYlqxwtbaZbList = Api.certchildYlqxwtbaZbList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYlqxscbaZbList = Api.certchildYlqxscbaZbList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYpckxkzList = Api.certchildYpckxkzList;
/**
 * 查询子表数据
 * @param params
 */
export const certchirdYlqxlcsybaList = Api.certchirdYlqxlcsybaList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYlqxcpckxsList = Api.certchildYlqxcpckxsList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildMzyphjsypddscList = Api.certchildMzyphjsypddscList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYpckxszmList = Api.certchildYpckxszmList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildYpscGmpList = Api.certchildYpscGmpList;
/**
 * 查询子表数据
 * @param params
 */
export const certchildCkomylyList = Api.certchildCkomylyList;
/**
 * 查询元数据
 * @param params
 */
export const certmetelist = Api.certmetelist;
/**
 * 列表接口
 * @param params
 */
export const list = (params) => defHttp.get({ url: Api.list, params });
export const alllist = (params) =>
  defHttp.get({url: Api.alllist, params});

export const wgzlist = (params) => defHttp.get({ url: Api.wgzlist, params });
export const bgxxlist = (params) => defHttp.get({ url: Api.bgxxlist, params });

/**
 * 删除单个
 */
export const deleteOne = (params, handleSuccess) => {
  return defHttp.delete({ url: Api.deleteOne, params }, { joinParamsToUrl: true }).then(() => {
    handleSuccess();
  });
};
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
      return defHttp.delete({ url: Api.deleteBatch, data: params }, { joinParamsToUrl: true }).then(() => {
        handleSuccess();
      });
    },
  });
};
/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  const url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({ url: url, params });
};
export const updataData = (params) => {
  return defHttp.post({ url: Api.editdetial, params });
};
export const updateFj = (params) => {
  return defHttp.post({ url: Api.updateFj, params });
};
export const shenhequest = (params) => {
  return defHttp.post({ url: Api.shenhe, params });
};
export const back = (params) => {
  return defHttp.post({ url: Api.back, params });
};
export const getcertmetelist = (params) => {
  const url = Api.certmetelist;
  return defHttp.get({ url: url, params });
};
export const getCerttypeNameAndValuef = (params) => {
  const url = Api.getCerttypeNameAndValue;
  return defHttp.get({ url: url, params });
};
export const getAttachByCertid = (params) => {
  const url = Api.getAttachByCertid;
  return defHttp.get({ url: url, params });
};
export const getzminfodata = (params) => {
  const url = Api.getzminfodata;
  return defHttp.get({ url: url, params });
};
export const generate_gz_cert = (params, handleSuccessbutton) => {
  const url = Api.generate_gz_cert;
  return defHttp
    .get({ url: url, params })
    .then((response) => {
      handleSuccessbutton();
      console.log('certinfo的回调', response);
      return response; // 返回响应
    })
    .catch((error) => {
      console.log("generate内部捕获到错误",error)
      handleSuccessbutton();
    });
};

export const cancleGz = (params, handleSuccessbutton) => {
  const url = Api.cancleGz;
  return defHttp
    .get({ url: url, params })
    .then(() => {
      handleSuccessbutton();
    })
    .catch(() => {
      handleSuccessbutton();
    });
};

export const caoZuo = (params, czType) => {
  if (czType == '变更') {
    const url = Api.bianGeng;
    return defHttp.post({ url: url, params });
  }
  if (czType == '换证') {
    const url = Api.huanZheng;
    return defHttp.post({ url: url, params });
  }
  if (czType == '注销') {
    const url = Api.zhuXiao;
    return defHttp.post({ url: url, params });
  }
};

export const getCertInfoByZsId = (params) => {
  const url = Api.getCertInfoByZsId;
  return defHttp.get({ url: url, params });
};

export const maintainApply = (params) => {
  return defHttp.post({ url: Api.maintainApply, params });
};

export const saveOrUpdateBl = (params) => {
  return defHttp.post({ url: Api.saveBl, params });
};
