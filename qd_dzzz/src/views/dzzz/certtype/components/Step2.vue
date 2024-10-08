<template>
  <div>

    <!--引用表格-->
    <BasicTable ref="tableRef" @register="registerTable" :rowSelection="rowSelection" :expandedRowKeys="expandedRowKeys"  @expand="handleExpand">
      <!-- 内嵌table区域 begin -->


      <template #expandedRowRender="{record}">
        <a-tabs tabPosition="top">
          <a-tab-pane tab="证书元数据表" key="certMetadata" forceRender>
            <certMetadataSubTable :id="expandedRowKeys[0]"/>
          </a-tab-pane>
        </a-tabs>
      </template>
      <!-- 内嵌table区域 end -->
      <!--插槽:table标题-->
      <template #tableTitle>
        <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>

<!--        <a-button  type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>
        <j-upload-button  type="primary" preIcon="ant-design:import-outlined" @click="onImportXls">导入</j-upload-button>-->
        <a-dropdown v-if="selectedRowKeys.length > 0">
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
        </a-dropdown>
<!--         高级查询
        <super-query :config="superQueryConfig" @search="handleSuperQuery" />-->
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" :dropDownActions="getDropDownAction(record)"/>
      </template>
      <!--字段回显插槽-->
      <template v-slot:bodyCell="{ column, record, index, text }">
      </template>

    </BasicTable>


    <a-button @click="nextbuttion" style="background-color: #0a8fe9;color: azure;float: right;margin-right: 50px;width: 100px;height: 50px"  >
      下一步
    </a-button>
    <a-button @click="prevbuttion" style="float: right;margin-right: 10px;width: 100px;height: 50px"  >
      上一步
    </a-button>
    <!-- 表单区域 -->
    <CertMetadataVersionModal @register="registerModal" :uuid="uuid.certtypeid" :versionnum="versionnum"  @success="handleSuccess"></CertMetadataVersionModal>




  </div>

</template>

<script lang="ts" name="dzzz-certMetadataVersion" setup>

import {ref, reactive, computed, unref,defineProps} from 'vue';
import {BasicTable, useTable, TableAction, FormSchema,TableActionType} from '/@/components/Table';
import { useListPage } from '/@/hooks/system/useListPage'
import {useModal} from '/@/components/Modal';
import CertMetadataVersionModal from './components/CertMetadataVersionModal.vue'
import CertMetadataSubTable from './subTables/CertMetadataSubTable.vue'
import {columns} from './CertMetadataVersion.data';
import { deleteOne, batchDelete, getImportUrl,getExportUrl} from './CertMetadataVersion.api';
import {downloadFile} from '/@/utils/common/renderUtils';
import { useUserStore } from '/@/store/modules/user';
import AButton from "@/components/Button/src/BasicButton.vue";
import {defHttp} from "@/utils/http/axios";
import {func} from "vue-types";
import {JVxeTableInstance} from "@/components/jeecg/JVxeTable/types";
const queryParam = reactive<any>({});
// 展开key
const expandedRowKeys = ref<any[]>([]);
//注册model
const [registerModal, {openModal}] = useModal();
const userStore = useUserStore();
const emit = defineEmits(['next', 'prev']);
const uuid=defineProps({
  certtypeid:{
    type:String,  // 数据类型
    default:"未传值"  // 未传值时的默认值
  },
  facerttypeid:{
    type:String
  },
})

console.log("setp2:uuid:"+uuid.facerttypeid);
const tableRef = ref<Nullable<TableActionType>>(null);

let versionnum="0";

const list = (params) =>

  defHttp.get({url: '/dzzz/certMetadataVersion/list?certTypeId='+uuid.certtypeid, params});
 const params={"certTypeId":uuid.certtypeid};
//注册table数据
const { prefixCls,tableContext,onExportXls,onImportXls,g } = useListPage({
  tableProps:{
    title: '证书元数据版本',
    api: list,
    columns,
    canResize:false,
    useSearchForm:false,
    formConfig: {
      //labelWidth: 120,

      autoSubmitOnEnter:true,
      showAdvancedButton:true,
      showResetButton:false,
      showSubmitButton:false,

      fieldMapToNumber: [
      ],
      fieldMapToTime: [
      ],
    },
    actionColumn: {
      width: 120,
      fixed:'right'
    },
    beforeFetch: (params) => {
      return Object.assign(params, queryParam);
    },
  },
  exportConfig: {
    name:"证书元数据版本",
    url: getExportUrl,
    params: queryParam,

  },
  importConfig: {
    url: getImportUrl,
    success: handleSuccess
  },

})

 async function getversionnum()
{ const values =  await list();
  console.log(values.records.length);


  return values.records.length;
}
function  nextbuttion()
{

  emit('next',1);
}
function  prevbuttion()
{

  emit('prev',1);
}
const [registerTable, {reload},{ rowSelection, selectedRowKeys }] = tableContext

// 高级查询配置
/*const superQueryConfig = reactive(searchFormSchema);*/

/**
 * 高级查询事件
 */
function handleSuperQuery(params) {
  Object.keys(params).map((k) => {
    queryParam[k] = params[k];
  });
  reload();
}

/**
 * 展开事件
 * */
function handleExpand(expanded, record){
  expandedRowKeys.value=[];
  console.log(expanded);
  console.log(record);
  if (expanded === true) {
    expandedRowKeys.value.push(record.id)
  }
}
function getTableActionnew() {
  const tableAction = unref(tableRef);
  if (!tableAction) {
    throw new Error('tableAction is null');
  }
  return tableAction;
}
/**
 * 新增事件
 */
 function handleAdd(record: Recordable) {
  let versionnum1 =  getversionnum();
  versionnum=versionnum1;
   let dataSource = getTableActionnew().getDataSource();
   console.log(dataSource);
   let id='';
   for (let i=0;i<dataSource.length;i++)
   {
     if(dataSource[i].status==0)
     {
       id=dataSource[i].id;
     }
   }

  openModal(true, {
     id:id,
    showFooter: true,
    versionnum2:versionnum1,
  });
}
/**
 * 编辑事件
 */
function handleEdit(record: Recordable) {
  openModal(true, {
    record,
    isUpdate: true,
    showFooter: true,
  });
}
/**
 * 详情
 */
function handleDetail(record: Recordable) {
  openModal(true, {
    record,
    isUpdate: true,
    showFooter: false,
  });
}
/**
 * 删除事件
 */
async function handleDelete(record) {
  await deleteOne({id: record.id}, handleSuccess);
}
/**
 * 批量删除事件
 */
async function batchHandleDelete() {
  await batchDelete({ids: selectedRowKeys.value},handleSuccess);
}
/**
 * 成功回调
 */
function handleSuccess() {
  console.log("成功回调");
  reload();
  (selectedRowKeys.value = []) && reload();
}
/**
 * 操作栏
 */
function getTableAction(record){
  return [
    {
      label: '编辑',
      onClick: handleEdit.bind(null, record),
    }
  ]
}


/**
 * 下拉操作栏
 */
function getDropDownAction(record){
  return [
    {
      label: '详情',
      onClick: handleDetail.bind(null, record),
    }, {
      label: '删除',
      popConfirm: {
        title: '是否确认删除',
        confirm: handleDelete.bind(null, record),
        placement: 'topLeft',
      }
    }
  ]
}

</script>

<style scoped>

</style>
