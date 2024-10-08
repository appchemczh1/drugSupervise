<template>
  <div>
    <!--引用表格-->
    <BasicTable @register="registerTable" :rowSelection="rowSelection" >
      <!--插槽:table标题-->
      <template #tableTitle>
<!--        <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>
        -->
        <a-button type="primary" @click="btngz" :disabled="1 != selectedRows.length || !!selectedRows[0].gztime" :loading="loading" preIcon="ant-design:plus-outlined">盖章</a-button>
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction_ZDY :actions="getTableActionyl(record)" :dropDownActions="getDropDownActionYUlan(record)" />
      </template>
      <!--字段回显插槽-->
      <template v-slot:bodyCell="{ column, record, index, text }">
      </template>
    </BasicTable>
    <!-- 表单区域 -->
    <CertInfoModal @register="registerModal" @success="handleSuccess"></CertInfoModal>
    <readermodel @register="registerModalreader" @success="handleSuccess"></readermodel>
    <CertBF  @register="registerModalbf" @success="handleSuccessbf" ></CertBF>
    <CertQz @register="registerModalCertQz" @success="handleSuccessCertQz"></CertQz>
  </div>
</template>

<script lang="ts" name="dzzz.certinfo-certInfo" setup>
import { ref, reactive, computed, unref,watch } from 'vue';
import { BasicTable, useTable, TableAction, TableAction_ZDY } from '/@/components/Table';
import { useListPage } from '/@/hooks/system/useListPage'
import { useModal } from '/@/components/Modal';
import CertInfoModal from './modal/CertInfoModal.vue'
import readermodel from './components/readermodel.vue'
import { columns, searchFormSchema, superQuerySchema } from './CertInfo.data';
import { useRouter, useRoute } from 'vue-router';
import {
  list,alllist,
  deleteOne,
  batchDelete,
  getImportUrl,
  getExportUrl,
  getcertmetelist,
  certmetelist,
  generate_gz_cert, getAttachByCertid
} from './CertInfo.api';
import {router} from "@/router";
import { downloadFile } from '/@/utils/common/renderUtils';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';
import {message} from "ant-design-vue";
import CertBF from "@/views/dzzz/certinfo/components/CertBF.vue";
import CertQz from  './components/Certqz.vue';
import * as Tools from "@/utils/tools";
import {propTypes} from "@/utils/propTypes";

const emit = defineEmits(['success']);
const keyid = computed(() => props.data?.key)
const props = defineProps({
  data: { require: true, type: Object },
  showZyys: propTypes.string,
});

let loading = ref<boolean>(false);
const { createConfirm } = useMessage();
const queryParam = reactive<any>({});
const checkedKeys = ref<Array<string | number>>([]);
const userStore = useUserStore();
const certtypeId=ref();
/*  const certmetadatalist=  getcertmeta();*/
//注册model
const [registerModal, { openModal }] = useModal();
const [registerModalreader, { openModal: Readermodel }] = useModal();
const [registerModalbf, { openModal: bfmodel }] = useModal();
const [registerModalCertQz, { openModal: openModalCertQz }] = useModal();
//注册table数据
const { prefixCls, tableContext, onExportXls, onImportXls } = useListPage({
  tableProps: {
    title: '电子证照源数据',
    api: alllist,
    columns,
    canResize: false,
    formConfig: {
      //labelWidth: 120,
      schemas: searchFormSchema,
      autoSubmitOnEnter: true,
      showAdvancedButton: false,
      fieldMapToNumber: [
      ],
      fieldMapToTime: [
      ],
    },
    actionColumn: {
      width: 180,
      fixed: 'right'
    },
    beforeFetch: (params) => {
      const str = keyid.value.split('#');
      params.zt='4';
      params.isxt='1';
      params._from = 'blgz';
      if(str[0]){
        params.zslb= str[0];
      }
      if(str[1]){
        params.certtypeid= str[1];
        certtypeId.value=str[1];
      }
      if (props.showZyys) {
        params.showZyys = props.showZyys;
      }
      selectedRowKeys.value = []
      return Object.assign(params, queryParam);
    },
  },
  exportConfig: {
    name: "电子证照源数据",
    url: getExportUrl,
    params: queryParam,
  },
  importConfig: {
    url: getImportUrl,
    success: handleSuccess
  },
})

const  userouter=useRouter();
async function getcertmeta() {
  const certmetalist = await getcertmetelist({ 'id': '78d8f71b-b72d-43eb-b11d-af27eedcfc78' });
  console.log(certmetalist);
  const certdata: any[] = [];
  for (let i = 0; i < certmetalist.length; i++) {
    certdata[i] = {
      label: certmetalist[i].lm,
      field: certmetalist[i].yssx,
      component: certmetalist[i].zdlx,
    }
  }
  console.log(certdata);
  return certdata;
}
const [registerTable, { reload }, { rowSelection, selectedRowKeys, selectedRows }] = tableContext
watch(() => props.data, () => reload())

// 高级查询配置
const superQueryConfig = reactive(superQuerySchema);

/**
 * 高级查询事件
 */
function handleSuperQuery(params) {
  Object.keys(params).map((k) => {
    queryParam[k] = params[k];
  });
  reload();
}

/***
 * 生成证照
 */
async function  btngz()
{
  if(selectedRowKeys.value.length<1) {
    message.warn("请选择一条记录！");
    return;
  }
  if(selectedRowKeys.value.length>1) {
    message.warn("只能选择一条记录！");
    return;
  }
  //先上传纸质电子文档 以及补发情况原因说明
  /*bfmodel(true, {
    isUpdate: false,
    showFooter: true,
    certid:selectedRowKeys.value[0],
    isbl:"1",
  });*/
  let modal = createConfirm({
    iconType: 'warning',
    maskClosable: true,
    title: '补录盖章',
    content: '请选择盖章方式？',
    okText: 'Ukey盖章',
    cancelText: '直接盖章',
    onOk() {
      openModalCertQz(true, { showFooter: false });
    },
    cancelButtonProps: {
      onClick() {
        loading.value = true;
        generate_gz_cert({ ids: selectedRowKeys.value, zt: 4 }, handleSuccessbutton).then(() => {
          (selectedRowKeys.value = []) && reload();
        }).catch((error) => {
          console.error(error);
        }).finally(() => loading.value = false);
        modal.destroy();
      }
    }
  });
}

function handleSuccessCertQz(keysn) {
  if (!keysn) return;
  loading.value = true;
  generate_gz_cert({ ids: selectedRowKeys.value, keysn, zt: 4 }, handleSuccessbutton).then(() => {
    (selectedRowKeys.value = []) && reload();
  }).catch((error) => {
    console.error(error);
  }).finally(() => loading.value = false);
}

async function handleSuccessbf() {
  loading.value=true;

  await generate_gz_cert({ids: selectedRowKeys.value},handleSuccessbutton);

  (selectedRowKeys.value = []) && reload();
}
/**
 * 新增事件
 */
function handleAdd() {
  openModal(true, {
    isUpdate: false,
    showFooter: true,
    certtypeID:certtypeId.value,
    isbl:"1",
  });
}
/**
 * 编辑事件
 */
function handleEdit(record: Recordable,czType) {
  let showFooter=false
  if(null!=czType){
    showFooter=true
  }
  openModal(true, {
    record,
    isUpdate: true,
    showFooter: showFooter,
    czType:czType
  });
}
/**
 * 详情
*/
function handleDetail(record: Recordable) {
  openModal(true, {
    record,
    showFooter: false,
  });
}
/**
 * 删除事件
 */
async function handleDelete(record) {
  await deleteOne({ id: record.id }, handleSuccess);
}
/**
 * 批量删除事件
 */
async function batchHandleDelete() {
  await batchDelete({ ids: selectedRowKeys.value }, handleSuccess);
}
/**
 * 成功回调
 */
function handleSuccess() {
  (selectedRowKeys.value = []) && reload();
}
function handleSuccessbutton() {
  loading.value=false;
}
/**
   * 操作栏
   */
function getTableAction(record) {
  return [
    {

      label: '编辑',
      onClick: handleEdit.bind(null, record),
    }
  ]
}
function getTableActionyl(record) {
  return [
    {
      label: '查看',
      onClick: () => openModal(true, { record, showFooter: false }),
    }
  ]
}

  async function openYulan(record, name) {
    // 路由配置地址	/account/settings/base
    //路由配置地址 "/"变成"-"
    //router.push("http://127.0.0.1:8095/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd");
    let attachByCertid = await getAttachByCertid({
      id: record.id,
      certmodetype: name,
      isgz: '0',
    });
    console.log(attachByCertid);
  /*window.open("http://127.0.0.1:8095/reader?file="+attachByCertid.modeUrl);*/

    Tools.toPreview(attachByCertid.modeUrl);
  }

/**
 * 下拉操作栏
 */
/*function getDropDownAction(record) {
  return [
    {
      label: '编辑',
      onClick: handleEdit.bind(null, record),
    }
  ]
}*/


/**
 * 下拉操作栏
 */
function getDropDownAction(record) {
  return [
    {
      label: '查看',
      onClick: handleEdit.bind(null, record,null),
    },
    {
      label: '变更',
      onClick: handleEdit.bind(null, record,"变更"),
    },
    {
      label: '换证',
      onClick: handleEdit.bind(null, record,"换证"),
    },
    {
      label: '注销',
      onClick: handleEdit.bind(null, record,"注销"),
    }
  ]
}
function getDropDownActionYUlan(record) {
  let array: any = [];
  record?.isType?.split(',').forEach(item => {
    array.push({ label: item, onClick: openYulan.bind(null, record, item) });
  });
  return array;
}

</script>

<style scoped></style>
