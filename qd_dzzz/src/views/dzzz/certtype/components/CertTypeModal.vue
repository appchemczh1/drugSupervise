<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="800" @ok="handleSubmit">
      <BasicForm @register="registerForm"/>
  </BasicModal>

<!--  <BasicModal v-bind="$attrs" @register="registerModal" title="添加证照类型信息" @cancel="closeModal" :showOkBtn="false"
              width="1100px" :showCancelBtn="false" v-model:visible="isClose" destroyOnClose>
    <div class="step-form-form">
      <a-steps :current="current">
        <a-step title="证照类型" />
        <a-step title="证书元" />
        <a-step title="证书模板" />
      </a-steps>
    </div>
    <div class="mt-5">
      <Step1 @next="handleStep1Next" v-show="current === 0" />
      <Step2 @prev="handleStepPrev" @next="handleStep2Next" v-show="current === 1" v-if="initSetp2"/>
      <Step3 @prev="handleStepPrev" @next="handleStep3Next" v-show="current === 2" v-if="initSetp3" />
      <Step4 v-show="current === 3" @prev="handleStepPrev" @redo="handleRedo" v-if="initSetp4" />
    </div>

  </BasicModal >-->
</template>

<script lang="ts" setup>
    import {ref, computed, unref} from 'vue';
    import {BasicModal, useModalInner} from '/@/components/Modal';
    import {BasicForm, useForm} from '/@/components/Form/index';
    import {formSchema} from '../CertType.data';
    import {saveOrUpdate} from '../CertType.api';
    import Step1 from './CertTypeForm.vue';
    import Step2 from './Step2.vue';
    import Step3 from './Step3.vue';
    import Step4 from './Step4.vue';
    import {uuid} from "@tinymce/tinymce-vue/lib/es2015/main/ts/Utils";
    // Emits声明
    const emit = defineEmits(['register','success']);
    const isUpdate = ref(true);
    //表单配置
    const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
        //labelWidth: 150,
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: {span: 24}
    });
    //表单赋值
    const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
        //重置表单
        await resetFields();
        setModalProps({confirmLoading: false,showCancelBtn:!!data?.showFooter,showOkBtn:!!data?.showFooter});
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
            //表单赋值
            await setFieldsValue({
                ...data.record,
            });
        }
        // 隐藏底部时禁用整个表单
       setProps({ disabled: !data?.showFooter })
    });
    //设置标题
    const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));
    //表单提交事件
    async function handleSubmit(v) {
        try {
            let values = await validate();
            console.log(values);
          values.id=guid();
            setModalProps({confirmLoading: true});
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

    function guid() {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
      });
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
