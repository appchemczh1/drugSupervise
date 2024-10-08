<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="800" @ok="handleSubmit">
    <BasicForm @register="registerForm"/>
  </BasicModal>
</template>

<script lang="ts" setup>
import {ref, computed, unref, reactive, defineProps} from 'vue';
import {BasicModal, useModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {JVxeTable} from '/@/components/jeecg/JVxeTable'
import {useJvxeMethod} from '/@/hooks/system/useJvxeMethods.ts'
import { useUserStore } from '/@/store/modules/user';
// Emits声明
import {
  formSchemabf,formSchemawhqxgz
} from '../CertInfo.data';
import {
  saveOrUpdate,
} from '../CertInfo.api';
const emit = defineEmits(['register','success']);
const userStore = useUserStore();
const isUpdate = ref(true);
let certid="";
//表单配置
const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
  labelWidth: 130,
  schemas: formSchemawhqxgz,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await resetFields();
  setModalProps({confirmLoading: false,showCancelBtn:!!data?.showFooter,showOkBtn:!!data?.showFooter});
  isUpdate.value = !!data?.isUpdate;
  certid=data.certid;
  await setFieldsValue({
    qxgzr: userStore.getUserInfo.realname
  });
  // 隐藏底部时禁用整个表单
  setProps({ disabled: !data?.showFooter })
});
//设置标题
const title = computed(() => "取消盖章");
//表单提交事件
async function handleSubmit(v) {
  try {
    validate().then(values => {
      values.id = certid;
      setModalProps({ confirmLoading: true });
      //关闭弹窗
      closeModal();
      //刷新列表
      emit('success', values);
    }).catch(e => {
      console.log(e);
    });
  } finally {
    setModalProps({ confirmLoading: false });
  }
}
</script>

<style lang="less" scoped>
/** 时间和数字输入框样式 */
:deep(.ant-input-number){
  width: 100%
}

:deep(.ant-calendar-picker){
  width: 100%
}
</style>
