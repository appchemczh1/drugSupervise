<template>
  <div v-bind="$attrs">
    <!--引用表格-->
    <BasicTable @register="registerTable">
      <!--插槽:table标题-->
      <template #tableTitle v-if="title"><b class="text-dark-900 !m-0">{{ title }}</b></template>
      <template #tableTitle v-if="$slots.tableTitle"><slot name="tableTitle"/></template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" />
      </template>

      <template #bodyCell="{ column, text }">
        <template v-if="column.dataIndex === 'xzspslh'">
          <TableAction v-if="text != null && text != ''" :actions="getTableAction2(text)" />
        </template>
      </template>
    </BasicTable>
    <a-modal v-model:visible="showCzDetail" title="操作记录详情" :footer="null" width="1200px">
      <div style="padding: 10px">
        <div>
          <div style="margin-top: 20px">操作记录详情</div>
        </div>
        <div>
          <czjlDetailList :data="czjlDetailInfo" />
        </div>
      </div>
    </a-modal>
  </div>
</template>

<script lang="ts" name="dzzz-certInfoOperationRecord" setup>
  import { ref, computed, unref } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { useModal } from '/@/components/Modal';
  import { useListPage } from '/@/hooks/system/useListPage';
  import { columns } from './CertInfoOperationRecord.data';
  import { list } from './CertInfoOperationRecord.api';
  import czjlDetailList from './CertInfoOperationDetailList.vue';
  import { propTypes } from '/@/utils/propTypes';

  const showCzDetail = ref(false);
  const emit = defineEmits(['success', 'load']);
  const props = defineProps({
    data: { require: true, type: Object },
    title: { type: String},
    isdq: { type: String },
    wgz: propTypes.oneOfType([propTypes.string, propTypes.bool.def(false)]),
  });
  const zsid = computed(() => props.data?.zsid);
  const czjlDetailInfo = ref();
  //注册model
  const [registerModal, { openModal }] = useModal();
  //注册table数据
  const { prefixCls, tableContext, onExportXls, onImportXls } = useListPage({
    tableProps: {
      title: '操作记录表',
      api: (params) => {
        return new Promise((resolve, reject) => {
          list(params).then((res) => {
            emit('load', res);
            resolve(res);
          }).catch(e => {
            reject(e);
          });
        });
      },
      columns,
      canResize: false,
      useSearchForm: false,
      size: 'small',
      ...(props.isdq == '1' ? {pagination: false} : {}),
      formConfig: {
        //labelWidth: 120,
        autoSubmitOnEnter: true,
        showAdvancedButton: false,
        fieldMapToNumber: [],
        fieldMapToTime: [],
      },
      actionColumn: {
        width: 80,
        fixed: 'right',
      },
      customRow(record, _) {
        //console.log("0000000000-" + props.wgz);
        return {
          style: {
            color: props.isdq == '1' ? 'red' : 'black',
          },
        };
      },
      beforeFetch: (params) => {
        if (props.isdq) {
          params.isdq = '1';
        }
        if (props.wgz) {
          params.iwgz = '1';
        }
        if (zsid.value) {
          params.zsid = zsid.value;
          //删除默认排序
          delete params.column;
          delete params.order;
        }
        return params;
      },
    },
  });

  const [registerTable, { reload }, { rowSelection, selectedRowKeys }] = tableContext;

  /**
   * 详情
   */
  function handleDetail(record: Recordable) {
    showCzDetail.value = true;
    czjlDetailInfo.value = { czsjid: record.id.startsWith('wh-') ? record.id.substring(3) : record.id };
  }

  /**
   * 跳转 办件过程页面
   */
  function handleDetail2(xzspid) {
    window.open("http://192.168.0.107:8090/weboa/yjj/zwfw/instancelistinfo?xzspid="+xzspid+"&systemId=1", '_blank');
  }

  /**
   * 成功回调
   */
  function handleSuccess() {
    (selectedRowKeys.value = []) && reload();
  }

  function getTableAction2(val) {
    return [
      {
        label: '查看',
        onClick: handleDetail2.bind(null, val),
      },
    ];
  }

  /**
   * 操作栏
   */
  function getTableAction(record) {
    return [
      {
        label: '查看',
        onClick: handleDetail.bind(null, record),
      },
    ];
  }
</script>

<style scoped>
  /* 表格单元格自动换行和自适应高度 */
  .ant-table-cell {
    white-space: pre-wrap;
    word-break: break-all;
  }
</style>
