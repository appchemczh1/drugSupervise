<template>
  <div>
    <!--    <a-table :data-source="dataSource" :columns="columnss" />-->
    <!--引用表格-->
    <BasicTable :row-selection="rowSelection" @register="registerTable">
      <!--插槽:table标题-->
      <template #tableTitle>
        <!--
                    <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined" v-if="hasPermission('user:add')"> 新增</a-button>
            -->
        <!--        <a-button type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出
            </a-button>-->
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
        <a-button type="primary" :loading="loading" pre-icon="ant-design:plus-outlined" @click="btngz">盖章(可多选) </a-button>
        <!-- 高级查询 -->
        <!--        <super-query :config="superQueryConfig" @search="handleSuperQuery" />-->
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <!--        <TableAction :actions="getTableActionyl(record)" :dropDownActions="getDropDownActionYUlan(record)" />-->

        <TableAction_ZDY
          :actions="[
            /*{
              label: '查看',
              onClick: handleEdit.bind(null, record,'查看'),
              //   auth: 'other', // 根据权限控制是否显示: 无权限，不显示
            },*/
            {
        label: '查看', onClick() {
          openModal2(true, { record, sourcePage: 'wgz' });
        }
      },
            {
              label: '生成证照',
              onClick: chuli.bind(null, record, '生成证照'),
            },
            /* {
                  label: '盖章',
                  onClick: chuli.bind(null, record,'盖章'),
                }*/
          ]"
          :drop-down-actions="getDynamicDropDownActions(record)"
        />

        <!-- <TableAction :actions="getTableAction(record)" :dropDownActions="getDropDownAction(record)" /> -->
        <!--        <TableAction :actions="getTableAction(record)" />-->
      </template>
      <!--字段回显插槽-->
      <template #bodyCell="{ column, record, index, text }">
        <template v-if="column.dataIndex === 'fj'">
          <a-tag v-if="record.fj != null && record.fj != ''" color="success">已上传</a-tag>
          <a-tag v-if="record.fj == null || record.fj === ''" color="error">未上传</a-tag>
        </template>
      </template>
    </BasicTable>
    <!-- 表单区域 -->
    <CertInfoModal @register="registerModal" wgz="1" @success="handleSuccess"></CertInfoModal>
    <CertInfoModal2 @register="registerModal2" @success="handleSuccess"/>
    <readermodel @register="registerModalreader" @success="handleSuccess"></readermodel>
<qz  @register="qzmodelreader" @success="handleSuccessqz"></qz>
  </div>

  <a-modal v-model:visible="visible" title="请选择盖章方式？" @ok="handleOk" :centered="true">
    <a-form :model="formState" :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item style="text-align: center; padding-top: 20px">
        <a-radio-group v-model:value="formState.resource">
          <a-radio value="2">直接盖章</a-radio>
          <a-radio value="1">Ukey盖章</a-radio>
        </a-radio-group>
      </a-form-item>
    </a-form>
  </a-modal>

</template>


<script lang="ts" name="dzzz.certinfo-certInfo" setup>
  import { ref, reactive, computed, unref, watch, UnwrapRef } from 'vue';
  import { BasicTable, useTable, TableAction, TableAction_ZDY } from '/@/components/Table';
  /*import TableAction_ZDY from './components/TableAction_ZDY.vue';*/
  import { useListPage } from '/@/hooks/system/useListPage';
  import { useModal } from '/@/components/Modal';
  import CertInfoModal from './components/CertInfoModal_wgz.vue';
  import readermodel from './components/readermodel.vue';
  import {
    searchFormSchema,
    superQuerySchema,
    columnsZyys,
    searchFormSchemaZyys,
    columns
  } from "./CertInfo.data";
  import { useRouter, useRoute } from 'vue-router';
  import  qz from  './components/Certqz.vue';
  import { BasicColumn } from '/@/components/Table';
  import CertInfoModal2 from './modal/CertInfoModal.vue';


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
    wgzlist,
  } from './CertInfo.api';
  import { router } from '@/router';
  import { downloadFile } from '/@/utils/common/renderUtils';
  import { useUserStore } from '/@/store/modules/user';
  import { usePermission } from '/@/hooks/web/usePermission';

  const { hasPermission } = usePermission();
  import { propTypes } from '/@/utils/propTypes';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { message } from 'ant-design-vue';
  import * as Tools from "@/utils/tools";

  const { createConfirm } = useMessage();
  const responseData = ref({});
  const dataSource = [
    {
      key: '1',
      name: '胡彦斌',
      age: 32,
      address: '西湖区湖底公园1号',
    },
    {
      key: '2',
      name: '胡彦祖',
      age: 42,
      address: '西湖区湖底公园1号',
    },
  ];

  const emit = defineEmits(['success']);
  const keyid = computed(() => props.data?.key);
  const props = defineProps({
    data: { require: true, type: Object },
    zsdl: propTypes.string,
    isReload: { //是否立即请求接口
      type: Boolean,
      default: true,
    },
    zt: propTypes.string,
  });
  let loading = ref<boolean>(false);
  const queryParam = reactive<any>({});
  const checkedKeys = ref<Array<string | number>>([]);
  const userStore = useUserStore();
  const isReload = props.isReload;
  const columnsConfig = ref<any>(columns);
  const searchFormConfig = ref<any>(searchFormSchema);

  /*  const certmetadatalist=  getcertmeta();*/
  //注册model
  const [registerModal, { openModal }] = useModal();
  const [registerModal2, { openModal : openModal2 }] = useModal();
  const [registerModalreader, { openModal: Readermodel }] = useModal();
  const [qzmodelreader, { openModal: qzmodel }] = useModal();
  const ifShow = ref(false); // 是否上传附件栏位 默认不显示
  const visible = ref(false);

  interface FormState {
    resource: string;
  }
  const formState: UnwrapRef<FormState> = reactive({
    resource: '',
  });

  const labelCol= { span: 4 };
  const wrapperCol = { span: 14 };

  //未盖章列表数据
  const columnsWgz: BasicColumn[] = [
    {
      title: '企业名称',
      align: 'center',
      dataIndex: 'qymc',
    },
    {
      title: '证书编号',
      align: 'center',
      dataIndex: 'zsbh',
    },
    {
      title: '社会统一信用代码',
      align: 'center',
      dataIndex: 'shxydm',
    },
    {
      title: '注册地址',
      align: 'center',
      dataIndex: 'zcdz',
    },
    {
      title: '发证日期',
      align: 'center',
      dataIndex: 'fzrq',
    },
    {
      title: '是否上传附件',
      align: "center",
      dataIndex: 'fj',
      width: '105px',
      ifShow: ifShow,
    },

  ];


  //注册table数据
  const { prefixCls, tableContext, onExportXls, onImportXls } = useListPage({
    tableProps: {
      title: '电子证照源数据',
      api: wgzlist,
      columns: columnsConfig,
      canResize: false,
      immediate: isReload, //是否立即请求接口
      formConfig: {
        //labelWidth: 120,
        schemas: searchFormConfig,
        autoSubmitOnEnter: true,
        showAdvancedButton: false,
        fieldMapToNumber: [],
        fieldMapToTime: [['fzrq', ['beginDate', 'endDate'], 'YYYY-MM-DD']],
      },
      actionColumn: {
        width: 250,
        fixed: 'right',
      },
      beforeFetch: (params) => {
        if(props.data.zslx === '68' || props.data.zslx === '69' || props.data.zslx === '75' ||
          props.data.zslx === '35' || props.data.zslx === '26' || props.data.zslx === '3'){ //广告附件类型 显示是否上传附件
          ifShow.value = true;
        } else {
          ifShow.value = false;
        }

        if(props.data.zslx === '95'){ //执业药师类型
          columnsConfig.value = columnsZyys;
          searchFormConfig.value = searchFormSchemaZyys;
        } else {
          columnsConfig.value = columnsWgz;
          searchFormConfig.value = searchFormSchema;
        }

        //删除默认排序
        delete params.column;
        delete params.order;
        if (keyid.value) {
          const str = keyid.value.split('#');
          if (str[0]) {
            params.zslb = str[0];
          }
          if (str[1]) {
            params.certtypeid = str[1];
          }
        }
        if (props.zsdl) {
          console.log(props.zsdl);
          params.zsdl = props.zsdl;
        }
        params._from = 'wgz';
        return Object.assign(params, queryParam);
      },
    },
    exportConfig: {
      name: '电子证照源数据',
      url: getExportUrl,
      params: queryParam,
    },
    importConfig: {
      url: getImportUrl,
      success: handleSuccess,
    },
  });

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


  function getDynamicDropDownActions11(record) {
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
          label: '副页',//副页
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
          label: '副页',
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

  interface DataItem {
    label: string;
    onClick: Function;
  }

    function getDynamicDropDownActions(record) {
      const certdata: DataItem[]=[];
      if (record?.isType) {
        let type = record.isType;
        // debugger;
        var sdf:[]= type.split(',');
        for(let i=0;i<sdf.length;i++)
        {
          let a={
            label:  sdf[i],
            onClick: openYulan.bind(null, record,  sdf[i]),
          }
          certdata.push(a);
        }


        return certdata;
      }
    }
  /***
   * 生成证照
   */
  function btngz(type) {
    if (selectedRowKeys.value.length == 0) {
      message.warn('请选择一条记录！');
      return;
    }
    if (selectedRowKeys.value.length > 10) {
      message.warn('批量盖章一次最多选10条！');
      return;
    }
    visible.value = true;

    // createConfirm({
    //   iconType: 'warning',
    //   title: '批量盖章',
    //   content: '请选择盖章方式？',
    //   okText: 'Ukey盖章',
    //   cancelText: '直接盖章',
    //   maskClosable: true,
    //   onOk: () => {
    //     var name="";
    //    qzmodel(true, {
    //      isUpdate: false,
    //      showFooter: true,
    //    });
    //
    //     console.log(name);
    //
    //
    //
    //     console.log('生成证照之后');
    //   },
    //   onCancel:() => {
    //     loading.value = true;
    //     console.log(selectedRowKeys.value);
    //     generate_gz_cert({ ids: selectedRowKeys.value }, handleSuccessbutton)
    //       .then((response) => {
    //         console.log('wgzcer的回调', response);
    //         // 处理成功的响应
    //         responseData.value = response; // 将返回值传递给 Vue 属性
    //         loading.value = false;
    //       })
    //       .catch((error) => {
    //         // 处理错误的响应
    //         console.error(error);
    //         loading.value = false;
    //       });
    //   }
    // });
  }


  function handleOk() {
    if (!formState.resource) {
      message.warn('请选择盖章方式！');
      return;
    }
    // debugger;
    if (formState.resource === '1') {
      var name = "";
      qzmodel(true, {
        isUpdate: false,
        showFooter: true,
      });
    } else if (formState.resource === '2') {
      loading.value = true;
      console.log(selectedRowKeys.value);
      generate_gz_cert({ ids: selectedRowKeys.value }, handleSuccessbutton)
        .then((response) => {
          console.log('wgzcer的回调', response);
          // 处理成功的响应
          responseData.value = response; // 将返回值传递给 Vue 属性
          loading.value = false;
        })
        .catch((error) => {
          // 处理错误的响应
          console.error(error);
          loading.value = false;
        });
    }
    visible.value = false;
  };
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

  async function chuli(record: Recordable, Type) {
    loading.value = true;
    console.log(record.id);
    console.log('chuli的方法');
    await generate_gz_cert({ ids: record.id, type: 'sczz' }, handleSuccessbutton)
      .then((response) => {
        console.log('wgzcer的回调', response);
        // 处理成功的响应
        responseData.value = response; // 将返回值传递给 Vue 属性
        loading.value = false;
        reload();
      })
      .catch((error) => {
        // 处理错误的响应
        console.error(error);
        loading.value = false;
      });
    loading.value = false;

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
  function handleSuccessqz(e) {
    console.log(e);
    if(e!=null) {
      generate_gz_cert({ids: selectedRowKeys.value, keysn: e}, handleSuccessbutton)
        .then((response) => {
          console.log('wgzcer的回调', response);
          // 处理成功的响应
          responseData.value = response; // 将返回值传递给 Vue 属性
          loading.value = false;
        })
        .catch((error) => {
          // 处理错误的响应
          console.error(error);
          loading.value = false;
        });
    }
  }

  function handleSuccessbutton() {
    loading.value = false;
    reload();
    selectedRowKeys.value = [];
    console.log('执行完了handleSuccessbutton');
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
      },
    ];
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

  function getDropDownActionYUlan(record) {
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
  }
</script>

<style scoped></style>
