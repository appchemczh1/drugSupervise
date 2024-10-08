<template  destroyOnClose>
  <div>
    <!--引用表格-->
   <BasicTable @register="registerTable"   >
     <!--插槽:table标题-->
      <template #tableTitle>
      </template>
    </BasicTable>
  </div>
</template>

<script lang="ts" name="dzzz-certInfoOperationDetail" setup>
import { ref, computed, unref, onMounted, watch } from "vue";
  import {BasicTable, useTable, TableAction} from '/@/components/Table';
  import { useListPage } from '/@/hooks/system/useListPage'
  import {columns, } from './CertInfoOperationDetail.data';
  import {list} from './CertInfoOperationDetail.api';
  const emit = defineEmits(['success']);
  const props = defineProps({
    data: { require: true, type: Object },
  })
  const czsjid = computed(() => props.data?.czsjid);
  //注册table数据
  const { prefixCls,tableContext,onExportXls,onImportXls } = useListPage({
      tableProps:{
           title: '操作详情表',
           api: list,
           columns,
           canResize:false,
           useSearchForm:false,
           showActionColumn:false,
           beforeFetch: (params) => {
            if(czsjid.value){
              params.zsczjl=czsjid.value
            }
              return params;
           },
      },
   
  });

  const [registerTable, {reload},{ rowSelection, selectedRowKeys }] = tableContext;

  //监听props.data属性
  watch(() => props.data?.czsjid, reload);

   /**
    * 新增事件
    */
  function handleAdd() {
     openModal(true, {
       isUpdate: false,
       showFooter: true,
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
     await batchDelete({ids: selectedRowKeys.value}, handleSuccess);
   }
   /**
    * 成功回调
    */
  function handleSuccess() {
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
           }
         }
       ]
   }


</script>

<style scoped>

</style>
