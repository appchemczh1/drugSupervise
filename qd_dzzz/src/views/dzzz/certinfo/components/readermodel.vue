<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="1200"
              @ok="handleSubmit">
    <BasicForm @register="registerForm" ref="formRef"/>
    <!-- 子表单区域 -->
    <iframe style="width: 1200px;height:600px"
            id="view"
            src="http://127.0.0.1:8095/reader?file=upFiles/1775066179684618242_20240410115713_1_zb.ofd">
    </iframe>
  </BasicModal>

</template>

<script lang="ts" setup>
import {ref, computed, unref, reactive, defineProps} from 'vue';
import {BasicModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {JVxeTable} from '/@/components/jeecg/JVxeTable'
import {useJvxeMethod} from '/@/hooks/system/useJvxeMethods.ts'
import {
  formSchema,
  certchildYpscZcColumns,
  certchildYpscWtColumns,
  certchildYpscStColumns
} from '../CertInfo.data';
import {
  saveOrUpdate,
  certchildYpscZcList,
  certchildYpscWtList,
  certchildYpscStList, getcertmetelist
} from '../CertInfo.api';
import {VALIDATE_FAILED} from '/@/utils/common/vxeUtils'
import {rules} from "@/utils/helper/validator";
// Emits声明
const emit = defineEmits(['register', 'success']);
const isUpdate = ref(true);
const formDisabled = ref(false);
const refKeys = ref(['certchildYpscZc', 'certchildYpscWt', 'certchildYpscSt',]);
const activeKey = ref('certchildYpscZc');
const certchildYpscZc = ref();
const certchildYpscWt = ref();
const certchildYpscSt = ref();
let certid='';
const tableRefs = {certchildYpscZc, certchildYpscWt, certchildYpscSt,};
const certchildYpscZcTable = reactive({
  loading: false,
  dataSource: [],
  columns: certchildYpscZcColumns
})
const certchildYpscWtTable = reactive({
  loading: false,
  dataSource: [],
  columns: certchildYpscWtColumns
})
const certchildYpscStTable = reactive({
  loading: false,
  dataSource: [],
  columns: certchildYpscStColumns
})
/*const data = defineProps({
  certmetadatalist: {
    type: Array,  // 数据类型
    default: "未传值"  // 未传值时的默认值
  },
})*/

//表单配置
const [registerForm, {setProps, resetFields, setFieldsValue, validate,resetSchema,appendSchemaByField,removeSchemaByFiled}] = useForm({
  labelWidth: 1200,
  schemas: [],
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await reset();
  console.log(data.record);

  setModalProps({
    confirmLoading: false,
    showCancelBtn: data?.showFooter,
    showOkBtn: data?.showFooter
  });
  isUpdate.value = !!data?.isUpdate;
  formDisabled.value = !data?.showFooter;

  // 隐藏底部时禁用整个表单
  setProps({disabled: !data?.showFooter})

  //动态渲染表单removeSchemaByFiled






});
//方法配置
const [handleChangeTabs, handleSubmit, requestSubTableData, formRef] = useJvxeMethod(requestAddOrEdit, classifyIntoFormData, tableRefs, activeKey, refKeys);

//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

async function reset() {
  await resetFields();
  activeKey.value = 'certchildYpscZc';
  certchildYpscZcTable.dataSource = [];
  certchildYpscWtTable.dataSource = [];
  certchildYpscStTable.dataSource = [];
}

function classifyIntoFormData(allValues) {
  let main = Object.assign({}, allValues.formValue)
  return {
    ...main, // 展开
    certchildYpscZcList: allValues.tablesValue[0].tableData,
    certchildYpscWtList: allValues.tablesValue[1].tableData,
    certchildYpscStList: allValues.tablesValue[2].tableData,
  }
}

//表单提交事件
async function requestAddOrEdit(values) {
  try {
    setModalProps({confirmLoading: true});
    values.certtypeid="78d8f71b-b72d-43eb-b11d-af27eedcfc78";
    values.id=certid;
    console.log(values);
    //提交表单
    await saveOrUpdate(values, isUpdate.value);
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
