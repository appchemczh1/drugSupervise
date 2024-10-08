<template>
  <BasicModal :defaultFullscreen="true" v-bind="$attrs" @register="registerModal" destroyOnClose
              :title="title" width="100%" @ok="handleSubmit">
    <BasicForm @register="registerForm" ref="formRef"/>
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated @change="handleChangeTabs">
      <a-tab-pane tab="证书元数据表" key="certMetadata" :forceRender="true">
<!--        <a-button preIcon="ion:layers-outline"
                  style="z-index: 9999;float: left;margin-top: 10px;margin-right: 10px;background-color: #0a8fe9;color: azure;"
                  @click="handleAdd">新增</a-button>-->
        <a-button preIcon="ion:layers-outline"
                  style="z-index: 9999; float: left;margin-top: 10px;margin-right: 10px;background-color: #0a8fe9;color: azure;"
                  @click="handleAddfordata">数据字典
        </a-button>

        <JVxeTable
          keep-source
          resizable
          ref="certMetadata"
          :loading="certMetadataTable.loading"
          :columns="certMetadataTable.columns"
          :dataSource="certMetadataTable.dataSource"
          :height="'auto'"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"
          :toolbarConfig="{
            btn: ['remove'],
          }"
        />
        <!--
                  <a-button>已下单待回</a-button>-->

      </a-tab-pane>
    </a-tabs>
  </BasicModal>
  <CertMetadataModal @register="registerModaldata" @success="handleSuccess"></CertMetadataModal>
  <CertMetadataSelectModal @register="registerSelectModal"
                           @success="handleSuccesscertinfo"></CertMetadataSelectModal>

</template>

<script lang="ts" setup>
import {ref, computed, unref, reactive, defineProps} from 'vue';
import {BasicModal, useModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {JVxeTable} from '/@/components/jeecg/JVxeTable';
import {useJvxeMethod} from '/@/hooks/system/useJvxeMethods.ts';
import {formSchema, certMetadataJVxeColumns} from '../CertMetadataVersion.data';
import {saveOrUpdate, queryCertMetadata} from '../CertMetadataVersion.api';
import {VALIDATE_FAILED, validateFormModelAndTables} from '/@/utils/common/vxeUtils';
import AButton from "@/components/Button/src/BasicButton.vue";
import CertMetadataModal from '../../components/CertMetadataModal.vue';
import CertMetadataSelectModal from "./CertMetadataSelectModal.vue";
import Icon from "@/components/Icon/src/Icon.vue";
import {random} from "lodash-es";
import dayjs from "dayjs";
import {buildUUID} from "@/utils/uuid";
import {pushIfNotExist} from "@/utils/common/compUtils";
import {defHttp} from "@/utils/http/axios";

// Emits声明
const uuid = defineProps({
  uuid: {
    type: String,  // 数据类型
    default: "未传值"  // 未传值时的默认值
  }
,
  versionnum:{
    type: String,  // 数据类型
    default: "v.1"
  }
})
const emit = defineEmits(['register', 'success']);
const isUpdate = ref(true);
const formDisabled = ref(false);
const refKeys = ref(['certMetadata',]);
const activeKey = ref('certMetadata');
const certMetadata = ref();
const tableRefs = {certMetadata,};
let dataSource = ref<any[]>([]);
const loading = ref(false);
const certMetadataTable = reactive({
  loading: false,
  dataSource: <any[]>([]),
  columns: certMetadataJVxeColumns
})
const [registerModaldata, {openModal}] = useModal();
const [registerSelectModal, {openModal: selectmodel}] = useModal();

//表单配置
const [registerForm, {setProps, resetFields, getFieldsValue, setFieldsValue, validate}] = useForm({
  //labelWidth: 150,
  schemas: formSchema,
  showActionButtonGroup: false,

  baseColProps: {span: 8}
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await reset();

  setModalProps({
    confirmLoading: false,
    showCancelBtn: data?.showFooter,
    showOkBtn: data?.showFooter
  });
  isUpdate.value = !!data?.isUpdate;
  formDisabled.value = !data?.showFooter;
  console.log(data.versionnum2);
  await setFieldsValue(

      {"bbmc":"v."+(parseInt( await data.versionnum2)+1)}


  )

  if (unref(isUpdate)) {
    //表单赋值
    console.log(data.record);
    await setFieldsValue({
      ...data.record,
    });
    requestSubTableData(queryCertMetadata, {id: data?.record?.id}, certMetadataTable)
  }
  else {
    console.log("23");
    defHttp.get({url: 'dzzz/certMetadataVersion/queryCertMetadataByMainId?id=' + data.id}).then( res => {
      console.log( res);
      handleSuccesscertinfo(res);

    })
  }
  // 隐藏底部时禁用整个表单
  setProps({disabled: !data?.showFooter})
});
//方法配置
const [handleChangeTabs, handleSubmit, requestSubTableData, formRef] = useJvxeMethod(requestAddOrEdit, classifyIntoFormData, tableRefs, activeKey, refKeys);

//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

async function reset() {
  await resetFields();
  activeKey.value = 'certMetadata';
  certMetadataTable.dataSource = [];
}


function classifyIntoFormData(allValues) {
  let main = Object.assign({}, allValues.formValue)
  return {
    ...main, // 展开
    certMetadataList: allValues.tablesValue[0].tableData,
  }
}

function handleAdd() {
  openModal(true, {
    isUpdate: false,
    showFooter: true,
  });
}

function handleAddfordata() {
  selectmodel(true, {
    isUpdate: false,
    showFooter: true,
  });
}

function handleSuccess(v) {

  randomPage(v, 0, 1, true);
}

function handleSuccesscertinfo(v) {

  setcertinfo(v, 0, 1, true);
}

/* 随机生成数据 */
function randomPage(valuess, current, pageSize, isLoading = false) {
  if (isLoading) {
    loading.value = true;
  }

  const certMetadatavalues: any[] = certMetadata.value!.getTableData();
  console.log(certMetadatavalues);
  certMetadatavalues.push(valuess);
  let begin = Date.now();
  let values: any[] = certMetadatavalues;

  certMetadataTable.dataSource = values;
  let end = Date.now();
  let diff = end - begin;

  if (isLoading && diff < pageSize) {
    setTimeout(() => (loading.value = false), pageSize - diff);
  }
}

/* 随机生成数据 */
function setcertinfo(valuess, current, pageSize, isLoading = false) {
  if (isLoading) {
    loading.value = true;
  }
  console.log(valuess);
  const certMetadatavalues: any[] = certMetadata.value!.getTableData();

  let index = certMetadatavalues.length;
  /*certMetadatavalues.concat(valuess);*/
  for (let i = 0; i < valuess.length; i++) {
    //控件类型处理
    if (valuess[i].zdlx == 'VARCHAR' || valuess[i].zdlx == 'VARCHAR2') {
      valuess[i].zdlx = 'Input';
    }
    if (valuess[i].zdlx == 'TIMESTAMP') {
      valuess[i].zdlx = 'DatePicker';
    }
    if (valuess[i].lm == '附件'||valuess[i].lbs == 'FJ') {
      valuess[i].zdlx = 'JUpload';
    }
    if (valuess[i].zdlx == 'text'||valuess[i].zdlx == 'TEXT') {
      valuess[i].zdlx = 'InputTextArea';
    }
    //默认一行两列
    valuess[i].bjys='12';

    valuess[i].zt = '0';
    valuess[i].px = index + i;
    valuess[i].isgs = '1';
    valuess[i].isbt = '1';

    certMetadatavalues.push(valuess[i]);
  }
  let begin = Date.now();
  console.log(certMetadatavalues);
  let values: any[] = certMetadatavalues;

  certMetadataTable.dataSource = values;
  let end = Date.now();
  let diff = end - begin;

  if (isLoading && diff < pageSize) {
    setTimeout(() => (loading.value = false), pageSize - diff);
  }
}

//表单提交事件
async function requestAddOrEdit(values) {
  try {
    setModalProps({confirmLoading: true});
    values.certTypeId = uuid.uuid;
    console.log(values);
    //提交表单
    const result= await saveOrUpdate(values, isUpdate.value);
    console.log(result);
    //关闭弹窗
    closeModal();
    //刷新列表
    emit('success');
  } finally {
    setModalProps({confirmLoading: false});
  }
}


</script>

<style lang="less" scoped>
/** 时间和数字输入框样式 */
:deep(.ant-input-number) {
  width: 100%
}

:deep(.ant-calendar-picker) {
  width: 100%
}
</style>
