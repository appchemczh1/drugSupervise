<template>
  <div>
    <!--引用表格-->
    <BasicTable @register="registerTable" :rowSelection="rowSelection" >
      <!--插槽:table标题-->
      <template #tableTitle>
<!--
        <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined" v-if="hasPermission('user:add')"> 新增</a-button>
-->
<!--        <a-button type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>-->
<!--        <j-upload-button type="primary" preIcon="ant-design:import-outlined" @click="onImportXls">导入</j-upload-button>-->
<!--        <a-dropdown v-if="selectedRowKeys.length > 0">
          <template #overlay>
            <a-menu>
              <a-menu-item key="1" @click="batchHandleDelete">
                <Icon icon="ant-design:delete-outlined"></Icon>
                删除
              </a-menu-item>
            </a-menu>
          </template>
          <a-button>批量操作
            <Icon icon="mdi:chevron-down"></Icon>
          </a-button>
        </a-dropdown>-->
<!--        <a-button type="primary" @click="btngz" :loading="loading" preIcon="ant-design:plus-outlined">生成证照</a-button>-->
        <!-- 高级查询 -->
<!--        <super-query :config="superQueryConfig" @search="handleSuperQuery" />-->
      </template>
      <!--操作栏-->
      <template #action="{ record }">
<!--        <TableAction :actions="getTableActionyl(record)" :dropDownActions="getDropDownActionYUlan(record)" />-->
        <TableAction :actions="getTableAction(record)" />
        <!-- <TableAction :actions="getTableAction(record)" :dropDownActions="getDropDownAction(record)" /> -->
<!--        <TableAction :actions="getTableAction(record)" />-->

      </template>
      <!--字段回显插槽-->
      <template v-slot:bodyCell="{ column, record, index, text }">
      </template>
    </BasicTable>
    <!-- 表单区域 -->
    <CertInfoModal @register="registerModal" @success="handleSuccess"></CertInfoModal>
  </div>
</template>

<script lang="ts" name="dzzz.certinfo-certInfo" setup>
import { ref, reactive, computed, unref,watch } from 'vue';
import { BasicTable, useTable, TableAction } from '/@/components/Table';
import { useListPage } from '/@/hooks/system/useListPage'
import { useModal } from '/@/components/Modal';
import CertInfoModal from './modal/CertInfoModal.vue';
import {  searchFormSchema, superQuerySchema} from './CertInfo.data';
import {columns} from './CertInfo.data';
import { useRouter, useRoute } from 'vue-router';
import {
  list,
  deleteOne,
  batchDelete,
  getImportUrl,
  getExportUrl,
  getcertmetelist,
  certmetelist,
  generate_gz_cert, getAttachByCertid, alllist
} from './CertInfo.api';
import {router} from "@/router";
import { downloadFile } from '/@/utils/common/renderUtils';
import { useUserStore } from '/@/store/modules/user';
import { usePermission } from '/@/hooks/web/usePermission';
const { hasPermission } = usePermission();
import { propTypes } from '/@/utils/propTypes';

const emit = defineEmits(['success']);
const keyid = computed(() => props.data?.key);

const props = defineProps({
  data: { require: true, type: Object },
  zsdl:propTypes.string,
})
let loading = ref<boolean>(false);
const queryParam = reactive<any>({});
const checkedKeys = ref<Array<string | number>>([]);
const userStore = useUserStore();
const certtypeId=ref();
/*  const certmetadatalist=  getcertmeta();*/
//注册model
const [registerModal, { openModal }] = useModal();
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
     /* if(keyid.value){
        const str = keyid.value.split('#');
        if(str[0]){
          params.zslb= str[0];
        }
        if(str[1]){
          params.certtypeid= str[1];

        }
      }
      if(props.zsdl){
        console.log(props.zsdl)
        params.zsdl=props.zsdl
      }*/
      params.iswh="1";
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
const [registerTable, { reload }, { rowSelection, selectedRowKeys }] = tableContext
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
 loading.value=true;

  await generate_gz_cert({ids: selectedRowKeys.value},handleSuccessbutton);
   loading.value=false;
}
/**
 * 新增事件
 */
function handleAdd() {
  openModal(true, {
    isUpdate: false,
    showFooter: true,
    certtypeID:certtypeId.value
  });
}
/**
 * 编辑事件
 */
function handleEdit(record: Recordable,czType) {
  openModal(true, { record, czType: '维护审核' })
}
/**
 * 详情
*/
function handleDetail(record: Recordable) {
  openModal(true, { record, showFooter: false });
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

      label: '审核',
      onClick: handleEdit.bind(null, record,"维护"),
    }
    ,{
      label: '查看',
      onClick: handleDetail.bind(null, record),
    }
  ]
}
function getTableActionyl(record) {
  return [
    {
      label: '查看',
      onClick: handleDetail.bind(null, record),
    }
  ]
}

function openYulan(record,name)
{
  // 路由配置地址	/account/settings/base
  //路由配置地址 "/"变成"-"
  //router.push("http://127.0.0.1:8095/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd");
  let attachByCertid = getAttachByCertid({
    "id":record.id,
    "certmodetype":name
  });
  console.log(attachByCertid);

  /*router.push("/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd");*/
  /*window.open("http://127.0.0.1:8095/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd");*/
  /*Readermodel(true, {
    record,
    isUpdate: true,
    showFooter: false,
  });*/


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
  return [
    {
      label: '正本',
      onClick: openYulan.bind(null, record,"正本"),
    }, {
      label: '副本',
      onClick: openYulan.bind(null, record,"副本"),
    },
    {
      label: '副页',
      onClick: openYulan.bind(null, record,"副页"),
    },
    {
      label: '变更记录',
      onClick: openYulan.bind(null, record,"变更记录"),
    }
  ]
}

</script>

<style scoped></style>
