<template>
	<div class="p-6px pb-4">
		<div class="pb-2 min-h-40px flex items-center justify-between">
			<template v-if="title"><b class="text-dark-900 !m-0">{{ props.title }}</b></template>
			<template v-else-if="$slots.tableTitle">
				<slot name="tableTitle" />
			</template>
		</div>
		<a-table :dataSource="dataSource" :pagination="false" :columns="tableProps.columns" size="small"
			:bordered="true" rowClassName="text-black" tableLayout="fixed">
			<template #bodyCell="{ column, record, text }">
				<template
					v-if="column.dataIndex === 'bglx_dictText' && ',1,2,3,7,9,10,'.includes(',' + record.bglx + ',') || column.dataIndex === 'czsj' || column.dataIndex === 'bgnr' || column.dataIndex === 'bgyy'">
					<div class="editable-cell">
						<div v-if="editableData.currentColumn == column.dataIndex && editableData.currentId == record.id && editableData[record.id]"
							class="editable-cell-input-wrapper">
							<JDictSelectTag v-model:value="editableData[record.id].bglx"
								v-model:showText="editableData[record.id].bglx_dictText" dictCode="changetype"
								valueLimit="1,2,3,7,9,10" :showChooseOption="false"
								v-if="column.dataIndex === 'bglx_dictText'" style="width:98px;" />
							<a-date-picker v-if="column.dataIndex === 'czsj'"
								v-model:value="editableData[record.id].czsj" valueFormat="YYYY-MM-DD HH:mm:ss" show-time
								:placeholder="'选择' + column.title" />
							<a-textarea v-model:value="editableData[record.id].bgnr"
								:autoSize="{ minRows: 1, maxRows: 5 }" v-if="column.dataIndex === 'bgnr'" />
							<a-textarea v-model:value="editableData[record.id].bgyy"
								:autoSize="{ minRows: 1, maxRows: 5 }" v-if="column.dataIndex === 'bgyy'" />
							<a-icon type="check-outlined" class="editable-cell-icon-check" @click="toSave(record.id)" />
						</div>
						<div v-else class="editable-cell-text-wrapper">
							{{ text || ' ' }}
							<a-icon type="edit-outlined" class="editable-cell-icon"
								@click="toEdit(record.id, column.dataIndex)" />
						</div>
					</div>
				</template>
				<a-button v-if="column.dataIndex === 'xzspslh' && !!text" @click="goto(text)" type="link" size="small">
					查看
				</a-button>
			</template>
			<template #action="{ record }">
				<a-button type="link" size="small" @click="showDetail(record)">
					查看
				</a-button>
			</template>
		</a-table>
		<a-modal v-model:visible="detailModalProps.visible" title="操作记录详情" :footer="null" width="1200px">
			<div style="padding: 10px">
				<div>
					<div style="margin-top: 20px">操作记录详情</div>
				</div>
				<div>
					<czjlDetailList :data="detailModalProps.data" />
				</div>
			</div>
		</a-modal>
	</div>
</template>
<script lang="ts" setup>
import { reactive, UnwrapRef } from 'vue';
import { cloneDeep } from 'lodash-es';
import { propTypes } from '/@/utils/propTypes';
import { JDictSelectTag } from '/@/components/Form';
import czjlDetailList from '/@/views/dzzz/operation/CertInfoOperationDetailList.vue';

const props = defineProps({
	dataSource: propTypes.array.def([]),
	title: propTypes.string.def('变更记录'),
	loading: propTypes.bool.def(false)
});
const emit = defineEmits(['update:dataSource']);

const tableProps = reactive({
	columns: [{
		dataIndex: 'bglx_dictText', title: '业务类型', align: 'center', width: 80,
	}, {
		dataIndex: 'czsj', title: '操作时间', align: 'center', width: 155,
	}, {
		dataIndex: 'bgnr', title: '变更内容', align: 'center', customCell: () => { style: 'white-space:pre-wrap;word-break:break-all;' },
	}, {
		dataIndex: 'bgyy', title: '变更原因', align: 'center', customCell: () => { style: 'white-space:pre-wrap;word-break:break-all;' },
	}, {
		dataIndex: 'xzspslh', title: '办件过程', align: 'center', width: 80
	}, {
		title: '操作', width: 80, align: 'center', fixed: 'right', slots: { customRender: 'action' }
	}]
});
const detailModalProps = reactive({ visible: false, data: {} });
const editableData: UnwrapRef<Record<string, any>> = reactive({});

function goto(xzspid) {
	window.open("http://192.168.0.107:8090/weboa/yjj/zwfw/instancelistinfo?xzspid=" + xzspid + "&systemId=1", '_blank');
}
function showDetail(record) {
	detailModalProps.data = { czsjid: record.id };
	detailModalProps.visible = true;
}
function toEdit(id, column) {
	if (editableData.currentId !== id) toSave(editableData.currentId);
	editableData.currentColumn = column;
	editableData.currentId = id;
	editableData[id] = cloneDeep(props.dataSource.filter(item => id === item.id)[0]);
}
function toSave(id) {
	if (!editableData[id] || editableData.currentColumn === 'czsj' && !editableData[id].czsj) return;
	emit('update:dataSource', props.dataSource.map(item => {
		let data = editableData[id];
		data.bgnr = (data.bgnr || '').replace(/(\r\n|\n)/ig, '');
		data.bgyy = (data.bgyy || '').replace(/(\r\n|\n)/ig, '');
		return item.id === id ? data : item;
	}));
	delete editableData.currentId;
	delete editableData[id];
}
</script>
<style lang="less" scoped>
.editable-cell {
	margin: -8px;
	padding: 8px;
	position: relative;

	.editable-cell-input-wrapper {
		padding-right: 18px;
	}

	.editable-cell-icon,
	.editable-cell-icon-check {
		position: absolute;
		top: 50%;
		right: 5px;
		cursor: pointer;
		transform: translateY(-50%);
		transition: all 0.2s;
	}

	.editable-cell-icon {
		padding: 5px 10px;
		left: 50%;
		right: unset;
		display: none !important;
		background-color: #e5f4ff;
		border: 1px solid #99d5ff;
		border-radius: 5px;
		transform: translate(-50%, -50%);
		box-shadow: 0px 0px 6px 0px #b3b3b3;
	}

	.editable-cell-icon:hover,
	.editable-cell-icon-check:hover {
		color: #108ee9;
	}

	&:hover {
		.editable-cell-icon {
			display: inline-flex !important;
		}
	}
}
</style>