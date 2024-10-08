<template>
  <BasicModal    v-bind="$attrs" @register="registerModal" title="添加证照类型信息" @cancel="closeModal" :showOkBtn="false"
    width="80%"    v-model:visible="isClose" destroyOnClose>
    <div class="step-form-form">
      <a-steps :current="current">
        <a-step title="证照类型" style="padding-left: 10%" />
        <a-step title="证书元" />
        <a-step title="证书模板" />
        <a-step title="证书权限" style="padding-right: 10%"/>

      </a-steps>
    </div>
    <div class="mt-5">
      <Step1  @next="handleStep1Next"  ref="step11" :certtypeid="uuid" :isupdate="certlistdata.isinsert" :isxq="certlistdata.isxq"  v-show="current === 0" />
      <Step2 @prev="handleStepPrev" ref="step22" @next="handleStep2Next" :certtypeid="uuid" :isxq="certlistdata.isxq" v-show="current === 1" v-if="initSetp2"/>
      <Step3 @prev="handleStepPrev" ref="step33" @next="handleStep3Next" :certtypeid="uuid" :isxq="certlistdata.isxq" @submit="submit" v-show="current === 2" v-if="initSetp3" />
      <Step4 @prev="handleStepPrev" ref="step44" @next="handleStep4Next" :certtypeid="uuid" :isxq="certlistdata.isxq" @submit="submit" v-show="current === 3" v-if="initSetp4" />

      <Step5 v-show="current === 3" @prev="handleStepPrev" @redo="handleRedo" v-if="initSetp5" />
    </div>

    <a-button @click="handleStep1Next" v-show="current === 0" style="background-color: #0a8fe9;color: azure;float: right;margin-right: 50px;width: 100px;height: 50px"  >
      下一步
    </a-button>
  </BasicModal>

</template>

<script lang="ts" setup name="tenant-recycle-bin-modal">
import { useListPage } from '/@/hooks/system/useListPage';
import { BasicModal, useModalInner } from '/@/components/Modal';
import {defineComponent, defineProps, ref, unref} from 'vue';
import Step1 from './Step1.vue';
import Step2 from './Step2.vue';
import Step3 from './Step3.vue';
import Step5 from './Step4.vue';
import Step4 from '../../certtyperole/CerttypeRoleList.vue';
import AButton from "@/components/Button/src/BasicButton.vue";
import PopButton from "@/components/Button/src/PopConfirmButton.vue";
import {BasicForm} from "@/components/Form";
const certlistdata=defineProps({
  isinsert:{
    type:String,  // 数据类型
    default:"0"  // 未传值时的默认值
  },
  isxq:{
    type:String,
    default:'0'
  }
  ,
  typeid:{
    type:String,
    default:'0'
  }
})
console.log("父窗体刚打开的uuid:"+certlistdata.typeid);
function submitStepForm() {
  
}
const  step11=ref('');
const  step22=ref('');
const  step33=ref('');
const  step44=ref('');
const current = ref(0);
const modal1Visible = ref<boolean>(false);
const uuid = ref(guid());
let setp1date={};
const [registerModal,{setModalProps}] = useModalInner(async (data) => {

  //如果传来了值 说明是编辑啊
 if(data.record) {
   step11.value.initFormData(data.record.id);
   uuid.value=data.record.id;
 }
 else {
   uuid.value=guid();
 }

});
function handleStep1Next(step1Values: any) {

/*  const validate = Step1.value.validate();*/
  uuid.value=certlistdata.typeid;
  console.log('按钮下一步：uuid的值'+uuid);
  step11.value.customSubmitFunc1().then(()=>{
    current.value++;
    initSetp2.value = true;
    setp1date=step11.value.getFieldsValue();
    console.log(step1Values);

  }).catch(()=>{

    console.log("验证未通过");
  })



}
function submit(step1Values: any) {
  /*  const validate = Step1.value.validate();*/
  step11.value.handleSubmit(setp1date).then(()=>{

    console.log("成功");
    closeModal();
    emit('success');

  }).catch((e)=>{
    console.log(e);
    console.log("验证未通过"+e);
  })



}
function handleStepPrev() {
  current.value--;
}

function handleStep2Next(step2Values: any) {
  console.log(step2Values)
  current.value++;
  initSetp3.value = true;
}
function handleStep4Next(step2Values: any) {
  console.log(step2Values)
  current.value++;
  initSetp5.value = true;
}

function handleStep3Next(step3Values: any) {
  console.log(step3Values)
  current.value++;
  initSetp4.value = true;
}

function handleRedo() {
  current.value = 0;
  initSetp4.value = false;
  initSetp5.value = false;
  initSetp2.value = false;
  initSetp3.value = false;
}


//初始化
const initSetp2 = ref<boolean>(false);
const initSetp3 = ref<boolean>(false);
const initSetp4 = ref<boolean>(false);
const initSetp5 = ref<boolean>(false);





// 列表页面公共参数、方法
const { tableContext } = useListPage({
  tableProps: {
    size: 'small',
    actionColumn: {
      width: 100,
      ifShow: false
    },
    ellipsis: true,
  },
});
const emit = defineEmits(['success', 'register', 'parent-reload']);
//注册table数据
const [registerTable] = tableContext
//获取操作栏事件


const isClose = ref<boolean>(false);

function closeModal() {
  isClose.value = false;
  current.value=0;
  emit('success');
}


function guid() {
  if(certlistdata.isinsert=='1') {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }
/*  if(certlistdata.isinsert=='0') {
    console.log("进来判断了");
    console.log(certlistdata.typeid);
      return  certlistdata.typeid;
  }*/
  else
  {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }
}



</script>

<style lang="less" scoped>
:deep(.ant-popover-inner-content) {
  width: 100px !important;
}
</style>
