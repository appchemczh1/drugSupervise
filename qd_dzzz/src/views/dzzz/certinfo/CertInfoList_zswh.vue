<template>
  <div>
    <!--引用表格-->
    <BasicTable @register="registerTable" :rowSelection="rowSelection">
      <!--插槽:table标题-->
      <template #tableTitle></template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" />
      </template>
      <!--字段回显插槽-->
      <template v-slot:bodyCell="{ column, record, index, text }"></template>
    </BasicTable>
    <!-- 表单区域 -->
    <CertInfoModal @register="registerModal" @success="handleSuccess"></CertInfoModal>
  </div>
</template>

<script lang="ts" name="dzzz.certinfo-certInfo" setup>
import { ref, reactive, computed, watch } from 'vue';
import { propTypes } from '/@/utils/propTypes';
import { useModal } from '/@/components/Modal';
import { useListPage } from '/@/hooks/system/useListPage';
import { BasicTable, TableAction } from '/@/components/Table';
import CertInfoModal from './modal/CertInfoModal.vue';
import * as CertInfoApi from './CertInfo.api';
import * as CertInfoData from './CertInfo.data';

const emit = defineEmits(['success']);
const keyid = computed(() => props.data?.key);

const props = defineProps({
  data: { require: true, type: Object },
  zsdl: propTypes.string,
})

const queryParam = reactive<any>({});
//注册model
const [registerModal, { openModal }] = useModal();
//注册table数据
const { prefixCls, tableContext, onExportXls, onImportXls } = useListPage({
  tableProps: {
    title: '电子证照源数据',
    api: CertInfoApi.alllist,
    columns: CertInfoData.columns,
    immediate: false,
    canResize: false,
    formConfig: {
      //labelWidth: 120,
      schemas: CertInfoData.searchFormSchema,
      autoSubmitOnEnter: true,
      showAdvancedButton: false,
      fieldMapToNumber: [],
      fieldMapToTime: [['fzrq', ['beginDate', 'endDate'], 'YYYY-MM-DD']],
    },
    actionColumn: {
      width: 180,
      fixed: 'right'
    },
    defSort: { column: '' },
    beforeFetch: (params) => {
      if (keyid.value) {
        const str = keyid.value.split('#');
        if (str[0]) {
          params.zslb = str[0];
        }
        if (str[1]) {
          params.certtypeid = str[1];

        }
      }
      params.whid = '1';
      if (props.zsdl) {
        console.log(props.zsdl)
        params.zsdl = props.zsdl
      }
      return Object.assign(params, queryParam);
    },
  }
});

const [registerTable, { reload }, { rowSelection, selectedRowKeys }] = tableContext;

watch(() => props.data, () => reload());

function handleSuccess() {
  (selectedRowKeys.value = []) && reload();
}

function getTableAction(record) {
  return [{
    label: '维护申请',
    onClick: () => openModal(true, { record, czType: '维护' })
  }, {
    label: '查看',
    onClick: () => openModal(true, { record, showFooter: false })
  }]
}
</script>
<style scoped></style>
