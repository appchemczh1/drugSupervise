<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="1000" :height="200" >
    <iframe  id="iframeContainer"  :src="srcurl" width="100%" height="100%"  @iframeDoAction="iframeLoad"></iframe>
<!--
    <BasicForm @register="registerForm"/>
-->

  </BasicModal>
</template>

<script lang="ts" setup>


import {ref, computed, unref, reactive, defineProps,watch,onMounted, onUnmounted } from 'vue';
import {BasicModal, useModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {JVxeTable} from '/@/components/jeecg/JVxeTable'
import '../../../../../public/static/qz/html/content/Web_js/jquery-1.10.2.min.js';
// Emits声明

import {
  saveOrUpdate,
} from '../CertInfo.api';
import _default from "ant-design-vue/es/vc-slick/inner-slider";
import mounted = _default.mounted;
const srcurl = ref('/static/qz/html/content/mTokenOperateCer.html');


const emit = defineEmits(['register','success']);
const isUpdate = ref(true);
let certid="";
//表单配置
const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
  labelWidth: 150,
  schemas: [],
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  setModalProps({confirmLoading: false,showCancelBtn:false,showOkBtn:true});
  isUpdate.value = !!data?.isUpdate;
  certid=data.certid;
});
//设置标题
const title = computed(() => (!unref(isUpdate) ? '获取ukey信息' : '获取ukey信息'));

//获取iframe的值
window.addEventListener('message', handleMessage);
//获取iframe传过来的信息
function handleMessage(e) {
  //e为传过来的信息
  if (e.data?.act === 'doUkey') {
    closeModal();
    //刷新列表
    emit('success', e.data.key);
  }
}



//表单提交事件
async function handleSubmit(v) {
  /*try {
    let values = await validate();
    values.id=certid;
    setModalProps({confirmLoading: true});
    //提交表单
    /!* await saveOrUpdate(values, isUpdate.value);*!/
    //关闭弹窗
    closeModal();
    //刷新列表
    emit('success');
  } finally {
    setModalProps({confirmLoading: false});
  }*/
  console.log("1111");
// 获取iframe传过来的信息




}
//表单提交事件

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
