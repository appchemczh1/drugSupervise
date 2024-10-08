<template>
	<BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="pageInfo.title" width="1200px"
		wrapClassName="cert-info-modal" @ok="handleSubmit" :okButtonProps="{ disabled: true }"
		:closeFunc="onCloseModal">
		<BasicForm ref="formRef" @register="registerForm" class="mt-2 mr-2" />
		<a-tabs v-model:activeKey="SubTableData.activeKey" animated1 v-if="SubTableData.tabs.length > 0"
			class="mx-2 mb-4 -mt-4 sub-table-tabs" :class="[FormDisabled ? '' : 'edit']">
			<a-tab-pane v-for="item in SubTableData.tabs" :tab="item.title" :key="item.key" :forceRender="true">
				<JVxeTable v-bind="item.tableProps" @register="item.register">
					<template #toolbarPrefix>
						<a-button v-if="!FormDisabled" type="primary" shape="circle" @click="item.onAddClick()">
							<a-icon type="plus-outlined" />
						</a-button>
					</template>
					<template #actions="data">
						<a @click="item.onEditClick(data)" href="javascript:;" v-if="item.tableProps.showEditBtn"
							class="mr-2">编辑</a>
						<a-popconfirm title="确定删除？" @confirm="item.onDelClick(data, false)">
							<a href="javascript:;" class="danger">删除</a>
						</a-popconfirm>
					</template>
				</JVxeTable>
			</a-tab-pane>
		</a-tabs>
		<template v-if="isWgzPage">
			<a-divider class="my-0" />
			<CzjlList :data="FormData" isdq="1" :wgz="isWgzPage" class="czjl-list">
				<template #tableTitle>
					<b class="text-red-500 !m-0">未盖章内容</b>
				</template>
			</CzjlList>
		</template>
		<template v-if="!pageInfo.isBl">
			<a-divider :class="['my-0', isWgzPage ? 'mt-3' : '']" />
			<CzjlList :data="FormData" :wgz="isWgzPage" :title="pageInfo.czjlTitle" v-if="FormDisabled"
				@load="onCzjlLoad" />
			<BgjlList v-model:dataSource="bgjlData.dataSource" :loading="bgjlData.loading" :title="pageInfo.czjlTitle"
				v-else />
		</template>
		<template v-if="pageInfo.isWh || pageInfo.isWhSh || pageInfo.isWhView || pageInfo.isZx">
			<a-divider class="my-0" />
			<div class="py-6px">
				<div class="px-6px py-5px"><b class="text-dark-900 !m-0">{{ pageInfo.isZx ? czType : '维护' }}说明</b></div>
				<BasicForm ref="formWhRef" @register="registerFormWh" class="mr-2"
					:disabled="FormDisabled && !pageInfo.isZx" />
			</div>
		</template>

		<template #footer v-if="pageInfo.isWhSh">
			<a-button @click="handleWhSh(false)" :loading="loading" size="large">退回</a-button>
			<a-button @click="handleWhSh(true)" :loading="loading" size="large" type="primary">审核通过</a-button>
		</template>
	</BasicModal>

	<SubTableModal @register="registerSubTableModal" />
</template>
<script lang="ts" setup>
import { ref, reactive, computed, getCurrentInstance, toRaw } from 'vue';
import { BasicModal, useModal, useModalInner } from '/@/components/Modal';
import { BasicForm, useForm } from '/@/components/Form/index';
import { JVxeTable } from '/@/components/jeecg/JVxeTable';
import { validateFormModelAndTables } from '/@/utils/common/vxeUtils';
import { useMessage } from '/@/hooks/web/useMessage';
import { useUserStore } from '/@/store/modules/user';
import { findDetailInner } from '/@/views/dzzz/certtyperole/CerttypeRole.api';
import CzjlList from '/@/views/dzzz/operation/CertInfoOperationRecordList.vue';
import SubTableModal from './components/SubTableModal.vue';
import BgjlList from './components/bgjlList.vue';
import * as CertInfo from '../CertInfo.data';
import * as CertInfoApi from '../CertInfo.api';
import * as SubTable from '../SubTable.data';

const emit = defineEmits(['register', 'success']);

const instance = getCurrentInstance();

const { createMessage, createConfirm } = useMessage();
const userStore = useUserStore();

const loading = ref(false);
const isWgzPage = ref(false);
const czType = ref('');
const formRef = ref();
const FormDisabled = ref(true);
const FormData = ref<any>({});
const SubTableData = reactive<{ activeKey: string, tabs: Array<any> }>({ activeKey: '', tabs: [] });
const bgjlData = reactive({ loading: false, dataSource: [] });
const pageInfo = computed(() => {
	let isWh = czType.value == '维护', isWhSh = czType.value == '维护审核', isWgz = isWgzPage.value,
		isBl = czType.value == '补录', isZx = czType.value == '注销',
		isWhView = !isWh && !isWhSh && !isWgz && !isBl && FormDisabled.value && !!FormData.value.whid;
	return {
		title: (czType.value || '') + '证照信息',
		czjlTitle: isWh ? '操作记录修改' : '历史操作记录',
		isWh, isWhSh, isWgz, isBl, isZx, isWhView
	}
});

const [registerSubTableModal, { openModal: openSubTableModal }] = useModal();

const [registerForm, { resetFields, setFieldsValue, validate, getFieldsValue, appendSchemaByField, updateSchema }] = useForm({
	labelWidth: 170,
	schemas: CertInfo.formSchema,
	showActionButtonGroup: false,
	baseColProps: { span: 24 },
	labelWrap: true
});

const [registerFormWh, { setFieldsValue: setFieldsValueWh, validate: validateWh, updateSchema: updateSchemaWh }] = useForm({
	labelWidth: 170,
	schemas: CertInfo.formSchemawh,
	showActionButtonGroup: false,
	baseColProps: { span: 24 },
	labelWrap: true
});

const [registerModal, { setModalProps, closeModal }] = useModalInner(async (data) => {
	FormDisabled.value = true;
	await resetFields();

	isWgzPage.value = data.sourcePage == 'wgz';
	czType.value = data.czType || '';
	FormData.value = data.record || {};

	let modalProps = data?.showFooter !== false ? { showFooter: true, okButtonProps: { disabled: true } } : { showFooter: false };
	setModalProps(modalProps);

	let certTypeId = FormData.value.certtypeid;
	if (!certTypeId) {
		createMessage.error('无法获取证照类型！');
		return;
	}
	let certMetadata = await CertInfoApi.getcertmetelist({ 'id': certTypeId });
	let promise = await findDetailInner({ 'certtypeid': certTypeId });
	if (!certMetadata || 1 > certMetadata.length) {
		createMessage.error('未配置元数据或权限！');
		return;
	}
	if (pageInfo.value.isWh) promise = (promise?.sjwh || '');
	if (pageInfo.value.isBl) {
		promise = (promise?.sjwh || '');
		await updateSchema({
			field: 'qyid', show: true, dynamicRules: () => [{ required: true, message: '请选择企业信息!' }],
			componentProps: ({ formActionType }) => {
				const { setFieldsValue } = formActionType;
				return {
					setFieldsValue, code: 'company', multi: false,
					fieldConfig: [{ source: 'id', target: 'qyid' }, { source: 'entzzjgdm', target: 'shxydm' }, { source: 'entname', target: 'qymc' }]
				};
			}
		});
		FormDisabled.value = false;
	} else {
		await updateSchema({ field: 'qyid', show: false });
	}
	if (pageInfo.value.isZx) {
		await updateSchemaWh([{ field: 'whr', label: '注销人' }, { field: 'whyy', label: '注销原因' }, { field: 'fj', label: '附件', dynamicRules: () => [] }]);
		await setFieldsValueWh({ whr: userStore.getUserInfo.realname });
	}
	promise = ',' + (promise || '') + ',';
	//初始化主表字段
	certMetadata.forEach(async (meta) => {
		let metaItem: any = {}, yssx = meta.yssx.toLowerCase(), field,
			editable = (pageInfo.value.isWh || pageInfo.value.isBl) && promise.indexOf(',' + meta.yssx + ',') >= 0;
		//企业名称不可修改
		if (!pageInfo.value.isWh && (yssx == 'qymc' || yssx == 'shxydm')) editable = false;
		//未盖章时附件运行修改
		if (pageInfo.value.isWgz && yssx == 'fj') editable = true;
		//处理一下控件样式 if
		if (meta.zdlx == 'VARCHAR2' || meta.zdlx == 'VARCHAR' || meta.zdlx == '1') metaItem.zdlx = 'Input';
		else metaItem.zdlx = meta.zdlx;
		//处理一下抄送 产品 等字段的转化
		if (meta.lbs && yssx != meta.lbs.toLowerCase()) field = meta.lbs;
		else if (yssx == 'cp') field = 'chanping';
		else if (yssx == 'cs') field = 'chaosong';
		else if (yssx == 'gg') field = 'guige';
		else field = yssx;
		metaItem = {
			label: meta.lm, field,
			component: metaItem.zdlx, defaultValue: meta.mrz, colProps: { span: meta.bjys },
			componentProps: metaItem.zdlx == 'DatePicker' ? { format: ['YYYY-MM-DD', 'YYYY-MM-DD HH:mm:ss'], valueFormat: 'YYYY-MM-DD' } : {},
			dynamicDisabled: !editable,
			dynamicRules: () => {
				if (meta.isbt == '1') {
					return [{ required: true, message: '请输入' + meta.lm + "!" }];
				}
			}
		};
		await appendSchemaByField(metaItem, '');
	});
	//表单赋值
	await setFieldsValue({ ...data.record });
	if (pageInfo.value.isWh) {
		await setFieldsValueWh({ whr: userStore.getUserInfo.realname });
		FormDisabled.value = false;
	}
	//初始化子表
	let { tabs: array, reload: reloadSubTable } = SubTable.getSubTableData((certMetadata[0].typevalue || '').split(','), instance, FormDisabled, openSubTableModal);
	SubTableData.tabs = array;
	if (0 < array.length) SubTableData.activeKey = array[0].key;
	await reloadSubTable({ xzspid: FormData.value.id || '-unset-', zt: FormData.value.zt });
	//维护时加载变更记录
	if (pageInfo.value.isWh) {
		let res = await CertInfoApi.bgxxlist({ zsid: FormData.value.zsid, status: '20', mergeBgnr: false });
		res.records.forEach((item, idx) => {
			item.bgcs = (res.total || res.records.length) - idx;
		});
		bgjlData.dataSource = res.records || [];
	}

	setModalProps({ confirmLoading: false, okButtonProps: { disabled: false } });
});

function onCzjlLoad(data) {
	if (pageInfo.value.isWhSh || pageInfo.value.isWhView)
		setFieldsValueWh({ ...data?.records?.[0] });
}

function onCloseModal(): Promise<boolean> {
	return new Promise((resolve) => {
		setModalProps({ okButtonProps: { disabled: true } });
		resolve(true);
	});
}

function handleWhSh(isPass) {
	createConfirm({
		iconType: 'warning', title: '提示', content: '确定' + (isPass ? '通过' : '退回') + '当前申请？', onOk() {
			loading.value = true;
			(isPass ? CertInfoApi.shenhequest : CertInfoApi.back)({ ...toRaw(FormData.value) }).then(() => {
				closeModal();
				emit('success');
			}).finally(() => {
				loading.value = false;
			});
		}
	});
}

function handleSubmit() {
	let handle: Promise<any> = Promise.all([]);
	if (pageInfo.value.isWh || pageInfo.value.isBl) {
		let array: any = [], keys: string[] = [];
		for (let key in instance?.refs) {
			if (key.startsWith('subTable-')) {
				let ref: any[] = instance.refs[key] as any[];
				if (ref && 0 < ref.length) {
					keys.push(key.substring(9));
					array.push(ref[0]);
				}
			}
		}
		handle = new Promise((resove, rejected) => {
			validateFormModelAndTables(validate, getFieldsValue(), array, formRef.value.getProps, false).then(data => {
				let res = { ...data.formValue, subMap: {} };
				keys.forEach((key, idx) => {
					let val = data?.tablesValue[idx]?.tableData;
					if (val) res.subMap[key] = val;
				});
				resove(res);
			}).catch(e => rejected(e));
		});
	} else handle = validate();
	handle.then((data) => {
		return pageInfo.value.isWh || pageInfo.value.isZx ? new Promise((resove, rejected) => {
			validateWh().then((d) => {
				resove({ ...data, ...d });
			}).catch(e => rejected(e));
		}) : Promise.resolve(data);
	}).then((data) => {
		let finalData = { ...toRaw(FormData.value), ...data };
		console.debug(czType.value + '===>', finalData);
		setModalProps({ confirmLoading: true });
		//未盖章时，只修改附件
		if (pageInfo.value.isWgz) {
			return CertInfoApi.updateFj(finalData);
		} else if (pageInfo.value.isWh) {
			finalData.certoperationrecord = bgjlData.dataSource;
			return CertInfoApi.maintainApply(finalData);
		} else if (pageInfo.value.isBl) {
			return CertInfoApi.saveOrUpdateBl(finalData);
		} else if (pageInfo.value.isZx) {
			return CertInfoApi.caoZuo(finalData, '注销');
		} else {
			return Promise.reject('不支持的操作');
		}
	}).then(() => {
		closeModal();
		emit('success');
	}).catch(e => {
		if (e?.errorFields) createMessage.warn('请检查填写内容是否完整！');
		else console.error(e);
	}).finally(() => setModalProps({ confirmLoading: false }));
}

</script>
<style lang="less">
.cert-info-modal .scroll-container .scrollbar__wrap {
	margin-bottom: 0 !important;
}
</style>
<style lang="less" scoped>
a.danger {
	color: #ff4d4f;

	&:hover {
		color: #ff999b;
	}
}

.sub-table-tabs :deep(.vxe-toolbar) {
	position: absolute;
	right: 0;
	top: -58px;
	padding: 0;
	background: transparent;

	.ant-btn {
		margin-right: 0;
	}
}

:deep(.ant-input[disabled]),
:deep(.ant-picker-input>input[disabled]) {
	color: rgba(0, 0, 0, 0.65);
}

:deep(.ant-empty-normal) {
	margin-block: 0;
	margin-bottom: -1rem;
}
</style>