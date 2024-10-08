<template>
  <div>
    <!--引用表格-->
    <BasicTable :row-selection="rowSelection" @register="registerTable">
      <!--插槽:table标题-->
      <template #tableTitle>
        <!--          <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>-->
        <a-button v-if="hasPermission('user:add')" type="primary" pre-icon="ant-design:plus-outlined" @click="openStepForm"> 新增</a-button>

        <a-button type="primary" pre-icon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>
        <j-upload-button type="primary" pre-icon="ant-design:import-outlined" @click="onImportXls">导入</j-upload-button>
        <a-dropdown v-if="selectedRowKeys.length > 0">
          <template #overlay>
            <a-menu>
              <a-menu-item key="1" @click="batchHandleDelete">
                <Icon icon="ant-design:delete-outlined"></Icon>
                删除
              </a-menu-item>
            </a-menu>
          </template>
          <a-button
            >批量操作
            <Icon icon="mdi:chevron-down"></Icon>
          </a-button>
        </a-dropdown>
        <!-- 高级查询 -->
        <super-query :config="superQueryConfig" @search="handleSuperQuery" />
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" :drop-down-actions="getDropDownAction(record)" />
      </template>
      <!--字段回显插槽-->
      <template #bodyCell="{ column, record, index, text }"> </template>
    </BasicTable>
    <!-- 表单区域 -->
    <!--    <CertTypeModal @register="registerModal" @success="handleSuccess"></CertTypeModal>-->
    <StepModal
      :isinsert="isinsert"
      :isxq="isxq"
      :typeid="typeid"
      @register="registerStepModal"
      @success="handleSuccess"
      @parent-reload="reload"
    ></StepModal>
    <Step2 :facerttypeid="typeid" style="display: none" />
  </div>
</template>

<script lang="ts" name="dzzz-certType" setup>
  import { ref, reactive, computed, unref, getCurrentInstance } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { useModal } from '/@/components/Modal';
  import { useListPage } from '/@/hooks/system/useListPage';
  import Step2 from '../certtype/components/Step2.vue';
  import CertTypeModal from './components/CertTypeModal.vue';
  import { columns, searchFormSchema, superQuerySchema } from './CertType.data';
  import { list, deleteOne, batchDelete, getImportUrl, getExportUrl } from './CertType.api';
  import { downloadFile } from '/@/utils/common/renderUtils';
  import { useUserStore } from '/@/store/modules/user';
  import StepModal from './components/StepModal.vue';
  import { usePermission } from '/@/hooks/web/usePermission';
  const { hasPermission } = usePermission();
  const queryParam = reactive<any>({});
  const checkedKeys = ref<Array<string | number>>([]);
  const userStore = useUserStore();

  const { proxy: ctx } = getCurrentInstance();
  //注册model
  const [registerModal, { openModal }] = useModal();
  const [registerStepModal, { openModal: stepModal }] = useModal();
  const isinsert = ref('0');
  const isxq = ref('0');
  const typeid = ref('NO');
  //注册table数据
  const { prefixCls, tableContext, onExportXls, onImportXls } = useListPage({
    tableProps: {
      title: '证照类型',
      api: list,
      columns,
      canResize: false,
      formConfig: {
        //labelWidth: 120,
        schemas: searchFormSchema,
        autoSubmitOnEnter: true,
        showAdvancedButton: false,
        fieldMapToNumber: [],
        fieldMapToTime: [],
      },
      actionColumn: {
        width: 120,
        fixed: 'right',
      },
      beforeFetch: (params) => {
        return Object.assign(params, queryParam);
      },
    },
    exportConfig: {
      name: '证照类型',
      url: getExportUrl,
      params: queryParam,
    },
    importConfig: {
      url: getImportUrl,
      success: handleSuccess,
    },
  });

  const [registerTable, { reload }, { rowSelection, selectedRowKeys }] = tableContext;

  // 高级查询配置
  const superQueryConfig = reactive(superQuerySchema);

  /**
   * 分布不走
   */
  function openStepForm() {
    isinsert.value = '1';
    typeid.value = guid();
    stepModal(true, {
      isUpdate: false,
      showFooter: true,
    });
  }
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
    isinsert.value = '0';
    typeid.value = record.id;
    console.log('进来编辑了' + typeid.value);
    stepModal(true, {
      record,
      isUpdate: true,
      showFooter: true,
    });
  }
  /**
   * 详情
   */
  function handleDetail(record: Recordable) {
    isinsert.value = '0';
    isxq.value = '1';
    typeid.value = record.id;
    stepModal(true, {
      record,
      isUpdate: true,
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
    ctx.$forceUpdate();
    (selectedRowKeys.value = []) && reload();
  }
  /**
   * 操作栏
   */
  function getTableAction(record) {
    return [
      {
        label: '编辑',
        onClick: handleEdit.bind(null, record),
        ifShow: () => hasPermission('user:edit'),
      },
    ];
  }
  function getTableActionyl(record) {
    return [
      {
        label: '预览',
        onClick: handleEdit.bind(null, record),
      },
    ];
  }
  /**
   * 下拉操作栏
   */
  function getDropDownAction(record) {
    return [
      {
        label: '详情',
        onClick: handleDetail.bind(null, record),
      },
      {
        label: '删除',
        popConfirm: {
          title: '是否确认删除',
          confirm: handleDelete.bind(null, record),
          placement: 'topLeft',
        },
      },
    ];
  }
  function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = (Math.random() * 16) | 0,
        v = c == 'x' ? r : (r & 0x3) | 0x8;
      return v.toString(16);
    });
  }
</script>

<style scoped></style>
