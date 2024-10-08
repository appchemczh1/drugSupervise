<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="896"
              @ok="handleSubmit">
    <BasicForm @register="registerForm">
      <template #ecgz="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['ecgzX']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #fac="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postleftX1']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facleft1="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postleftX1']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facleft2="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postleftX2']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facleft3="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postleftX3']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facleft4="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postleftX4']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facright1="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postrightX1']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facright2="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postrightX2']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facright3="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postrightX3']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
      <template #facright4="{ model, field }">
        <a-input-group compact>

          <a-input class="pay-input" v-model:value="model['postrightX4']"/>
          *
          <a-input class="pay-input" v-model:value="model[field]"/>
        </a-input-group>
      </template>
    </BasicForm>
  </BasicModal>
</template>

<script lang="ts" setup>
import {ref, computed, unref, defineProps} from 'vue';
import {BasicModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {formSchema} from '../CertMode.data';
import {saveOrUpdate} from '../CertMode.api';
// Emits声明
const uuid = defineProps({
  uuid: {
    type: String,  // 数据类型
    default: "未传值"  // 未传值时的默认值
  }

})
const emit = defineEmits(['register', 'success']);
const isUpdate = ref(true);
//表单配置
const [registerForm, {setProps, resetFields, setFieldsValue, validate}] = useForm({
  labelWidth: 160,
  schemas: formSchema,
  showActionButtonGroup: false,
  baseColProps: {span: 12}
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await resetFields();
  setModalProps({
    confirmLoading: false,
    showCancelBtn: !!data?.showFooter,
    showOkBtn: !!data?.showFooter
  });
  isUpdate.value = !!data?.isUpdate;
  if (unref(isUpdate)) {
    //表单赋值
    await setFieldsValue({
      ...data.record,
    });
  }
  // 隐藏底部时禁用整个表单
  setProps({disabled: !data?.showFooter})
});
//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

//表单提交事件
async function handleSubmit(v) {
  try {
    let values = await validate();
    setModalProps({confirmLoading: true});
    values.certtypeid = uuid.uuid;
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

.pay-input {
  width: 20%;
}
</style>
