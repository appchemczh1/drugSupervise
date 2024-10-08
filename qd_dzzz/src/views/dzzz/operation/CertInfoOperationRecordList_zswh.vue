<template>
  <div>
    <!--引用表格-->
<!--   <BasicTable @register="registerTable">
     &lt;!&ndash;插槽:table标题&ndash;&gt;
      <template #tableTitle>
      </template>
       &lt;!&ndash;操作栏&ndash;&gt;
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" />
      </template>
    </BasicTable>-->

    <div>

      <div>操作记录修改</div>
      <div>
        <JVxeTable
          keep-source
          resizable
          ref="bgjldata"
          :loading="bgjl.loading"
          :columns="bgjl.columns"
          :dataSource="bgjl.dataSource"
          :height="'auto'"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"
        />
      </div>

      <div  >
        <div>
          <div style="margin-top: 20px">维护操作</div>
        </div>
        <BasicForm @register="registerFormwh"  ref="formRefwh">
          <!--插槽:table标题-->

        </BasicForm>
      </div>
    </div>
  </div>
  <a-modal v-model:visible="showCzDetail" title="操作记录详情" :footer="null" width="1200px">
    <div style="padding: 10px;">
      <div >
        <div style="margin-top: 20px">操作记录详情</div>
      </div>
      <div >
        <czjlDetailList :data="czjlDetailInfo"/>    
      </div>
    </div>
    
  </a-modal>
</template>

<script lang="ts" name="dzzz-certInfoOperationRecord" setup>
  import {ref, computed, unref} from 'vue';
  import {BasicTable, useTable, TableAction} from '/@/components/Table';
  import {useModal} from '/@/components/Modal';
  import { useListPage } from '/@/hooks/system/useListPage'
  import {columns} from './CertInfoOperationRecord.data';
  import {list } from './CertInfoOperationRecord.api';
  import czjlDetailList from './CertInfoOperationDetailList.vue';
  const showCzDetail=ref(false)
  const emit = defineEmits(['success']);
  const props = defineProps({
    data: { require: true, type: Object },
    isdq: { type: String },
    wgz:{type: String}
  })
  const zsid = computed(() => props.data?.zsid)
  const czjlDetailInfo=ref()
  //注册model
  const [registerModal, {openModal}] = useModal();
  //注册table数据
  const { prefixCls,tableContext,onExportXls,onImportXls } = useListPage({
      tableProps:{
           title: '操作记录表',
           api: list,
           columns,
           canResize:false,
           useSearchForm:false,
           formConfig: {
              //labelWidth: 120,
              autoSubmitOnEnter:true,
              showAdvancedButton:false,
              fieldMapToNumber: [
              ],
              fieldMapToTime: [
              ],
            },
           actionColumn: {
               width: 150,
               fixed:'right'
            },
            beforeFetch: (params) => {
               if(props.isdq)
               {
                 params.isdq='1';
               }
              if(props.wgz)
              {
                params.iwgz='1';
              }
              if(zsid.value){
                console.log("!");
                params.zsid=zsid.value;
                //删除默认排序
                delete params.column;
                delete params.order;

                console.log("!!");
              }
              return params;
            },
      },
  })

  const [registerTable, {reload},{ rowSelection, selectedRowKeys }] = tableContext

   /**
    * 详情
   */
  function handleDetail(record: Recordable) {
     showCzDetail.value=true;
     czjlDetailInfo.value={czsjid:record.id}
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
           label: '查看',
           onClick: handleDetail.bind(null, record),
         }
       ]
  }


</script>

<style scoped>

</style>
