<template>
  <div>
    <!--引用表格-->
    <BasicTable :row-selection="rowSelection" @register="registerTable">
      <!--插槽:table标题-->
      <template #tableTitle>
        <!--
        <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>
-->

        <!--        <a-button type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>
        -->
        <!--        <a-button type="primary" :loading="loading" pre-icon="ant-design:plus-outlined" @click="btngz1">取消盖章(可多选)</a-button>-->
        <a-button type="primary" :loading="loading" pre-icon="ant-design:plus-outlined" @click="btngz1">取消盖章(可多选)</a-button>
        <a-button type="primary" :loading="exportloading" pre-icon="ant-design:export-outlined" @click="exportXls"> 导出</a-button>
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
        <!--        <super-query :config="superQueryConfig" @search="handleSuperQuery" />
        -->
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction_ZDY :actions="getTableActionyl(record)" :drop-down-actions="getDropDownActionYUlan(record)" />
      </template>
      <!--字段回显插槽-->
      <template #bodyCell="{ column, record, index, text }"> </template>
    </BasicTable>
    <!-- 表单区域 -->
    <CertInfoModal zt="4" @register="registerModal" @success="handleSuccess"></CertInfoModal>
    <CertInfoModal2 @register="registerModal2" @success="handleSuccess"/>
    <readermodel @register="registerModalreader" @success="handleSuccess"></readermodel>
    <CertQXGZ @register="registerModalreaderqxgz" @success="handleSuccessqxgz"></CertQXGZ>
  </div>
</template>

<script lang="ts" name="dzzz.certinfo-certInfo" setup>
  import CertInfoModal2 from './modal/CertInfoModal.vue';
  import { ref, reactive, computed, unref, watch } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { useListPage } from '/@/hooks/system/useListPage';
  import { useModal } from '/@/components/Modal';
  import CertInfoModal from './components/CertInfoModal.vue';
  import CertQXGZ from './components/CertQXGZ.vue';
  import readermodel from './components/readermodel.vue';
  import { columns, searchFormSchema, superQuerySchema, columnsZyys, searchFormSchemaZyys } from './CertInfo.data';
  import { useRouter, useRoute } from 'vue-router';
  import {
    list,
    deleteOne,
    batchDelete,
    getImportUrl,
    getExportUrl,
    getcertmetelist,
    certmetelist,
    generate_gz_cert,
    getAttachByCertid,
    cancleGz,
    getYgzExportUrl,
  } from './CertInfo.api';
  import { router } from '@/router';
  import { downloadFile } from '/@/utils/common/renderUtils';
  import { useUserStore } from '/@/store/modules/user';
  import { message } from 'ant-design-vue';
  import { propTypes } from '/@/utils/propTypes';
  import { useMessage } from '@/hooks/web/useMessage';
  import TableAction_ZDY from '@/components/Table/src/components/TableAction_ZDY.vue';
  import * as Tools from "@/utils/tools";
  const emit = defineEmits(['success']);
  const keyid = computed(() => props.data?.key);
  const props = defineProps({
    data: { require: true, type: Object },
    zt: propTypes.string,
  });
  const { createConfirm } = useMessage();
  let loading = ref<boolean>(false);
  let exportloading = ref<boolean>(false);
  const queryParam = reactive<any>({});
  const checkedKeys = ref<Array<string | number>>([]);
  const userStore = useUserStore();
  const columnsConfig = ref<any>(columns);
  const searchFormConfig = ref<any>(searchFormSchema);
  /*  const certmetadatalist=  getcertmeta();*/
  //注册model
  const [registerModal, { openModal }] = useModal();
  const [registerModal2, { openModal : openModal2 }] = useModal();
  const [registerModalreader, { openModal: Readermodel }] = useModal();
  const [registerModalreaderqxgz, { openModal: qxgzmodel }] = useModal();
  //注册table数据
  const { prefixCls, tableContext, customEportXls, onImportXls } = useListPage({
    tableProps: {
      title: '电子证照源数据',
      api: list,
      columns: columnsConfig,
      canResize: false,
      formConfig: {
        //labelWidth: 120,
        schemas: searchFormConfig,
        autoSubmitOnEnter: true,
        showAdvancedButton: false,
        fieldMapToNumber: [],
        fieldMapToTime: [['fzrq', ['beginDate', 'endDate'], 'YYYY-MM-DD']],
      },
      actionColumn: {
        width: 180,
        fixed: 'right',
      },
      beforeFetch: (params) => {
        if(props.data.zslx === '95'){ //执业药师类型
          columnsConfig.value = columnsZyys;
          searchFormConfig.value = searchFormSchemaZyys;
        } else {
          columnsConfig.value = columns;
          searchFormConfig.value = searchFormSchema;
        }

        // 删除默认排序
        delete params.column;
        delete params.order;

        const str = keyid.value.split('#');
        if (str[0]) {
          params.zslb = str[0];
        }
        if (str[1]) {
          params.certtypeid = str[1];
        }

        if (props.data.certtypeid) {
          params.certtypeid = props.data.certtypeid;
        }
        params._from = 'ygz';
        return Object.assign(params, queryParam);
      },
    },
    /*exportConfig: {
      name: '电子证照源数据',
      url: getYgzExportUrl,
      customParams: {
        certtypeid: props.data.key,
      },
    },*/
    importConfig: {
      url: getImportUrl,
      success: handleSuccess,
    },
  });

  function exportXls() {
    const key = props.data.key.split('#');
    let certtypeid = '';
    if (key[1]) {
      certtypeid = key[1];
    }
    if (certtypeid === '') {
      message.warn('请先选择证书类型！');
      return;
    }
    exportloading.value = true;
    const exportConfigs = { name: '电子证照源数据', url: getYgzExportUrl, params: { certtypeid: certtypeid } };
    customEportXls(exportConfigs)
      .then(() =>
        exportloading.value = false
      ).catch((error) => {
        // 处理错误的响应
        console.error(error);
        exportloading.value = false;
      });
  }
  function btngz1() {
    if (selectedRowKeys.value.length == 0) {
      message.warn('请选择一条记录！');
      return;
    }
    createConfirm({
      iconType: 'warning',
      title: '取消盖章',
      content: '是否取消选中数据的盖章',
      okText: '确认',
      cancelText: '取消',
      onOk: () => {
        qxgzmodel(true, {
          isUpdate: false,
          showFooter: true,
          certid: selectedRowKeys.value[0],
        });
        // handleSuccessqxgz();
        // loading.value = true;
      },
    });
  }
  function handleSuccessqxgz(e) {
    loading.value = true;
    cancleGz({ ids: selectedRowKeys.value, whyy: e?.whyy }, handleSuccessbutton).finally(() => loading.value = false);
  }
  const userouter = useRouter();
  async function getcertmeta() {
    const certmetalist = await getcertmetelist({ id: '78d8f71b-b72d-43eb-b11d-af27eedcfc78' });
    console.log(certmetalist);
    const certdata: any[] = [];
    for (let i = 0; i < certmetalist.length; i++) {
      certdata[i] = {
        label: certmetalist[i].lm,
        field: certmetalist[i].yssx,
        component: certmetalist[i].zdlx,
      };
    }
    console.log(certdata);
    return certdata;
  }
  const [registerTable, { reload }, { rowSelection, selectedRowKeys }] = tableContext;
  watch(
    () => props.data,
    () => reload()
  );

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
  async function btngz() {
    loading.value = true;

    await generate_gz_cert({ ids: selectedRowKeys.value }, handleSuccessbutton);
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
  function handleEdit(record: Recordable, czType) {
    let showFooter = false;
    if (null != czType) {
      showFooter = true;
    }
    openModal(true, {
      record,
      isUpdate: true,
      showFooter: showFooter,
      czType: czType,
    });
  }
  /**
   * 详情
   */
  function handleDetail(record: Recordable) {
    openModal2(true, {
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
    (selectedRowKeys.value = []) && reload();
  }
  function handleSuccessbutton() {
    loading.value = false;
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
      },
    ];
  }
  function getTableActionyl(record) {
    return [
      {
        label: '查看',
        onClick: handleDetail.bind(null, record),
      }
    ];
  }

  async function openYulan(record, name) {
    // 路由配置地址	/account/settings/base
    //路由配置地址 "/"变成"-"
    //router.push("http://127.0.0.1:8095/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd");
    let attachByCertid = await getAttachByCertid({
      id: record.id,
      certmodetype: name,
      isgz: '1',
    });
    console.log(attachByCertid);

    Tools.toPreview(attachByCertid.modeUrl);
  }

  function escapeSpecialChars(str) {
    return str
      .split('')
      .map((char) => {
        return char.charCodeAt(0) > 255 ? encodeURIComponent(char) : char;
      })
      .join('');
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
        onClick: handleEdit.bind(null, record, null),
      },
      {
        label: '变更',
        onClick: handleEdit.bind(null, record, '变更'),
      },
      {
        label: '换证',
        onClick: handleEdit.bind(null, record, '换证'),
      },
      {
        label: '注销',
        onClick: handleEdit.bind(null, record, '注销'),
      },
    ];
  }
  function getDropDownActionYUlan11(record) {
    if (record.isType === '0') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '1') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
      ];
    } else if (record.isType === '2') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '3') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '4') {
      return [
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '5') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
      ];
    } else if (record.isType === '6') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
      ];
    } else if (record.isType === '7') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '8') {
      return [
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
      ];
    } else if (record.isType === '9') {
      return [
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '10') {
      return [
        {
          label: '副页',
          onClick: openYulan.bind(null, record, '副页'),
        },
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else if (record.isType === '11') {
      return [
        {
          label: '正本',
          onClick: openYulan.bind(null, record, '正本'),
        },
      ];
    } else if (record.isType === '12') {
      return [
        {
          label: '副本',
          onClick: openYulan.bind(null, record, '副本'),
        },
      ];
    } else if (record.isType === '13') {
      return [
        {
          label: '副页', //副页
          onClick: openYulan.bind(null, record, '副页'),
        },
      ];
    } else if (record.isType === '14') {
      return [
        {
          label: '变更记录',
          onClick: openYulan.bind(null, record, '变更记录'),
        },
      ];
    } else {
      return [
        {
          label: '未生成',
          onClick: openYulan.bind(null, record, '正本'),
        },
      ];
    }
  }

  function getDropDownActionYUlan(record) {
    const certdata: DataItem[] = [];
    if (record?.isType) {
      let type = record.isType;
      // debugger;
      var sdf: [] = type.split(',');
      for (let i = 0; i < sdf.length; i++) {
        let a = {
          label: sdf[i],
          onClick: openYulan.bind(null, record, sdf[i]),
        };
        certdata.push(a);
      }

      return certdata;
    }
  }
</script>

<style scoped></style>
