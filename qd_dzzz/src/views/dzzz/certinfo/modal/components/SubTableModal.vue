<template>
	<BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="pageInfo.title" :width="900"
		@ok="handleSubmit">
		<BasicForm ref="formRef" @register="registerForm" class="mt-2 mr-2" />
	</BasicModal>
</template>
<script lang="ts" setup>
import { ref, reactive, toRaw } from 'vue';
import { useMessage } from '/@/hooks/web/useMessage';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { BasicForm, useForm } from '/@/components/Form/index';
import { isFunction } from '/@/utils/is';

const emit = defineEmits(['register', 'success']);

const { createMessage } = useMessage();

const pageInfo = reactive<{ title: string, formDisabled: boolean, key: string, rowIndex?: string, success?: (data, rowIndex) => void }>({
	title: '查看', formDisabled: true, key: ''
});
const formData = ref({});

const [registerForm, { resetFields, setFieldsValue, validate, appendSchemaByField }] = useForm({
	labelWidth: 130,
	schemas: [{ label: 'ID', field: 'id', component: 'Input', show: false }],
	showActionButtonGroup: false,
	baseColProps: { span: 6 },
	labelWrap: true
});

const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
	await resetFields();
	pageInfo.key = data.key;
	pageInfo.rowIndex = data.rowIndex;
	pageInfo.success = data.success;
	if (data.isUpdate === true) {
		pageInfo.title = '编辑' + data.title;
		pageInfo.formDisabled = false;
	} else if (data.isUpdate === false) {
		pageInfo.title = '新增' + data.title;
		pageInfo.formDisabled = false;
	} else pageInfo.title = '查看' + data.title;

	formData.value = data.record;

	setModalProps(!pageInfo.formDisabled ? { showFooter: true, okButtonProps: { disabled: true } } : { showFooter: false });

	data.schemas.forEach(async item => {
		await appendSchemaByField(item, '');
	});

	await setFieldsValue({ ...data.record });

	setModalProps({ confirmLoading: false, okButtonProps: { disabled: false } });
});

function handleSubmit() {
	validate().then((data) => {
		console.debug(pageInfo.key + ' ===>', data);
		closeModal();
		emit('success', { ...toRaw(formData.value), ...data }, pageInfo.rowIndex);
		pageInfo.success && isFunction(pageInfo.success) && pageInfo.success(data, pageInfo.rowIndex);
	}).catch(e => {
		if (e?.errorFields) createMessage.warn('请检查填写内容是否完整！');
		else console.error(e);
	}).finally(() => setModalProps({ confirmLoading: false }));
}
</script>