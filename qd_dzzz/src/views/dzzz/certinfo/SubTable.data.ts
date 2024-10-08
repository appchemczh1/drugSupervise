import { reactive, watch, Ref, toRaw } from 'vue';
import dayjs from "dayjs";
import { tryOnUnmounted } from '@vueuse/core';
import { JVxeColumn, JVxeTypes } from '/@/components/jeecg/JVxeTable/types';
import { FormSchema } from '/@/components/Table';
import { defHttp } from '/@/utils/http/axios';
import { isProdMode } from '/@/utils/env';
import { isFunction } from '/@/utils/is';
import { useMessage } from '/@/hooks/web/useMessage';
import { error } from '/@/utils/log';

const { createConfirm } = useMessage();

export function getSubTableData(keys: Array<string>, instance, disabledRef: Ref<boolean>, openModal: <T = any>(props?: boolean, data?: T, openOnSet?: boolean) => void) {
	let array: any = [];
	keys.forEach((key) => {
		let tab = initSubTableItem(key, instance, disabledRef, openModal);
		tab && array.push(tab);
	});
	return {
		tabs: array,
		async reload(params = {}) {
			for (let i = 0; i < array.length; i++) {
				await array[i].reload(params);
			};
		}
	};
}

const SubTableInstance = reactive<{ [key: string]: any }>({});

function initSubTableItem(key: string, parentInst, disabledRef: Ref<boolean>, openModal: <T = any>(props?: boolean, data?: T, openOnSet?: boolean) => void) {
	let res = {
		key, title: '', tableProps: {}, register(instance) {
			isProdMode() && tryOnUnmounted(() => {
				delete SubTableInstance.value[key];
			});
			tableProps.instance = instance;
		}, getInstance: () => {
			const [instance] = parentInst.refs['subTable-' + key];
			if (!instance) error('subTable[' + key + '] instance is undefined!');
			return instance;
		}, async reload(params = {}) {
			if (isFunction(params)) params = params(res);
			tableProps.loading = true;
			try {
				tableProps.dataSource = await defHttp.get({ url: '/dzzz/certSubTable/' + key + '/listAll', params });
			} finally {
				tableProps.loading = false;
			}
		}, onAddClick() {
			if (tableProps.showEditBtn) openModal(true, {
				isUpdate: false, key, title: res.title, schemas: toRaw(tableProps.formSchemas), record: toRaw(tableProps.defaultRecord), success(data) {
					res.getInstance().addRows(data);
				}
			});
			else res.getInstance().addRows({});
		}, onEditClick({ rowIndex, rowId, row }) {
			console.debug('edit', rowIndex, rowId, row);
			openModal(true, {
				isUpdate: true, key, title: res.title, schemas: toRaw(tableProps.formSchemas), rowIndex, record: toRaw(row), success(data) {
					let inst = res.getInstance();
					inst.removeRows(row);
					inst.insertRows({ ...row, ...data, _id: row.id }, rowIndex);
				}
			});
		}, onDelClick({ rowId }, isConfirm = true) {
			let handle = () => {
				res.getInstance().removeRowsById(rowId);
			};
			if (isConfirm) {
				createConfirm({
					iconType: 'warning', title: '删除', content: '是否删除当前行？', onOk: handle
				});
			} else handle();
		}
	}, tableProps = reactive<{ columns: JVxeColumn[], dataSource: any[], [key: string]: any }>({
		ref: 'subTable-' + key, columns: [], dataSource: [], height: 300, loading: false, rowNumber: true, rowSelection: false, showEditBtn: false,
		disabled: disabledRef, keepSource: true, resizable: true, toolbar: true, toolbarConfig: { btns: [], slots: ['toolbarPrefix'] },
		formSchemas: []
	});
	if ('zc' == key) {
		res.title = '自产';
		tableProps.showEditBtn = true;
		tableProps.columns = SubTableColumnsZc;
		tableProps.formSchemas = SubTableFormSchemaZc;
		tableProps.defaultRecord = { protype: '1' };
	} else if ('wt' == key) {
		res.title = '委托';
		tableProps.showEditBtn = true;
		tableProps.columns = SubTableColumnsWt;
		tableProps.formSchemas = SubTableFormSchemaWt;
		tableProps.defaultRecord = { protype: '2' };
	} else if ('st' == key) {
		res.title = '受托';
		tableProps.showEditBtn = true;
		tableProps.columns = SubTableColumnsSt;
		tableProps.formSchemas = SubTableFormSchemaSt;
		tableProps.defaultRecord = { protype: '3' };
	} else if ('mz' == key) {
		res.title = '麻醉药品和精神药品定点生产批件';
		tableProps.columns = SubTableColumnsMz;
	} else if ('ypck' == key) {
		res.title = '药品出口准许证';
		tableProps.columns = SubTableColumnsYpck;
	} else if ('ypxs' == key) {
		res.title = '药品出口销售证明';
		tableProps.columns = SubTableColumnsYpxs;
	} else if ('om' == key) {
		res.title = '出口欧盟原料';
		tableProps.columns = SubTableColumnsOm;
	} else if ('dyl' == key) {
		res.title = '第一类医疗器械生产备案';
		tableProps.columns = SubTableColumnsDyl;
	} else if ('qxba23' == key) {
		res.title = '第二三类医疗器械委托备案';
		tableProps.columns = SubTableColumnsQxba23;
	} else if ('qxxkz' == key) {
		res.title = '第二三类医疗机械生产备案';
		tableProps.columns = SubTableColumnsQxxkz;
	} else if ('qxba' == key) {
		res.title = '医疗器械临床试验备案';
		tableProps.columns = SubTableColumnsQxba;
	} else if ('qxxs' == key) {
		res.title = '医疗器械产品出口销售证明';
		tableProps.columns = SubTableColumnsQxxs;
	} else if ('wlxsba' == key) {
		res.title = '医疗器械网络销售备案';
		tableProps.columns = SubTableColumnsWlxsba;
	} else return null;
	watch(() => disabledRef.value, () => {
		if (!disabledRef.value) {
			tableProps.columns = [...tableProps.columns, {
				title: '操作', key: 'actions', type: JVxeTypes.slot, fixed: 'right', minWidth: tableProps.showEditBtn ? 90 : 60, align: 'center', slotName: 'actions'
			}];
		} else {
			tableProps.columns = [...tableProps.columns].filter(item => item.key != 'actions');
		}
	}, { immediate: true });
	res.tableProps = tableProps;
	return res;
}

function dateFormatter({ cellValue }) {
	if (!cellValue) return '';
	return 10 < cellValue.length ? dayjs(cellValue).format('YYYY-MM-DD') : cellValue;
}

export const SubTableColumnsZc: JVxeColumn[] = [{
	title: '生产类别', key: 'protype', type: JVxeTypes.select, dictCode: 'ypsclb', width: '100px', defaultValue: '', disabled: true
}, {
	title: '生产地址', key: 'addrdetail', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '车间', key: 'workshop', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线', key: 'preparation', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产范围(正本)', key: 'productionscope', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产范围(副本)', key: 'productionscopef', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '年生产能力', key: 'throughput', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '计算单位', key: 'calculationunit', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线(条)', key: 'preparationnumber', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '有无药品gmp证书编号', key: 'isgmp', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '药品GMP证书编码', key: 'getgmpcertificate', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: 'GMP认证范围', key: 'gmprzscope', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}];

export const SubTableFormSchemaZc: FormSchema[] = [{
	label: '生产类别', field: 'protype', component: 'JDictSelectTag', colProps: { span: 12 }, componentProps: { dictCode: 'ypsclb', }, defaultValue: '1', dynamicDisabled: true, required: true,
}, {
	label: '生产地址', field: 'addrdetail', component: 'InputTextArea', colProps: { span: 24 }, required: true,
}, {
	label: '车间', field: 'workshop', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产线', field: 'preparation', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产范围(正本)', field: 'productionscope', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产范围(副本)', field: 'productionscopef', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '年生产能力', field: 'throughput', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '计算单位', field: 'calculationunit', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产线(条)', field: 'preparationnumber', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '药品GMP证书编码', labelWidth: 140, field: 'getgmpcertificate', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: 'GMP认证范围', field: 'gmprzscope', component: 'Input', colProps: { span: 12 }, required: true,
}];

export const SubTableColumnsWt: JVxeColumn[] = [{
	title: '生产类别', key: 'protype', type: JVxeTypes.select, dictCode: 'ypsclb', width: '100px', defaultValue: '', disabled: true,
}, {
	title: '委托企业', key: 'refcompname', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '车间', key: 'workshop', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '药品剂型', key: 'drugdose', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线', key: 'preparation', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '注册地址', key: 'refcompaddr', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产药类型 ', key: 'drugtype', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '相关药品编码', key: 'cordrugid', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '委托有效期', key: 'entrustvalidate', type: JVxeTypes.date, width: '100px', defaultValue: '', formatter: dateFormatter
}, {
	title: '药品规格', key: 'spec', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '药品通用名称', key: 'drugname', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '批准文号/登记号', key: 'regnumb', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '年生产能力', key: 'throughput', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '计算单位', key: 'calculationunit', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线(条)', key: 'preparationnumber', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '药品GMP证书编码', key: 'getgmpcertificate', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: 'GMP认证范围', key: 'gmprzscope', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}];

export const SubTableFormSchemaWt: FormSchema[] = [{
	label: '生产类别', field: 'protype', component: 'JDictSelectTag', colProps: { span: 12 }, componentProps: { dictCode: "ypsclb" }, defaultValue: '2', dynamicDisabled: true, required: true,
}, {
	label: '受托企业', field: 'refcompname', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '委托方生产地址', field: 'addrdetail', required: true, component: 'InputTextArea', colProps: { span: 24 },
}, {
	label: '车间', field: 'workshop', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '生产线', field: 'preparation', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '注册地址', field: 'refcompaddr', component: 'InputTextArea', required: true, colProps: { span: 24 },
}, {
	label: '企业编码', field: 'refcompId', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产药类型', field: 'drugtype', required: true, component: 'RadioGroup', componentProps: { options: [{ label: '原料药', value: '1', }, { label: '非原料药', value: '2', }, { label: '暂无', value: '3', },], }, colProps: { span: 12 },
}, {
	label: '相关药品编码', field: 'cordrugid', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '委托有效期', field: 'entrustvalidate', component: 'DatePicker', componentProps: { valueFormat: 'YYYY-MM-DD' }, colProps: { span: 12 }, required: true,
}, {
	label: '药品剂型', field: 'drugdose', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '药品规格', field: 'spec', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '药品通用名称', field: 'drugname', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '批准文号/登记号', field: 'regnumb', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '年生产能力', field: 'throughput', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '计算单位', field: 'calculationunit', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '生产线(条)', field: 'preparationnumber', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '药品GMP证书编码', labelWidth: 140, field: 'getgmpcertificate', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: 'GMP认证范围', field: 'gmprzscope', component: 'Input', colProps: { span: 12 }, required: true,
}];

export const SubTableColumnsSt: JVxeColumn[] = [{
	title: '生产类别', key: 'protype', type: JVxeTypes.select, dictCode: 'ypsclb', width: '100px', defaultValue: '', disabled: true,
}, {
	title: '受托企业名称', key: 'refcompname', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '注册地址', key: 'refcompaddr', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '受托方生产地址', key: 'addrdetail', type: JVxeTypes.normal, width: '200px', defaultValue: '',
}, {
	title: '车间', key: 'workshop', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线', key: 'preparation', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '受托企业编码', key: 'refcompid', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '药品通用名称', key: 'drugname', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产药类型 1原料 2非原料3暂无品种批次', key: 'drugtype', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '批准文号/登记号', key: 'regnumb', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '委托有效期', key: 'entrustvalidate', type: JVxeTypes.normal, width: '100px', defaultValue: '', formatter: dateFormatter
}, {
	title: '年生产能力', key: 'throughput', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '计算单位', key: 'calculationunit', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}, {
	title: '生产线(条)', key: 'preparationnumber', type: JVxeTypes.normal, width: '100px', defaultValue: '',
}];

export const SubTableFormSchemaSt: FormSchema[] = [{
	label: '生产类别', field: 'protype', component: 'JDictSelectTag', required: true, colProps: { span: 12 }, componentProps: { dictCode: "ypsclb" }, defaultValue: '3', dynamicDisabled: true,
}, {
	label: '委托企业', field: 'refcompname', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '企业编码', field: 'refcompid', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: '注册地址', field: 'refcompaddr', required: true, component: 'InputTextArea', colProps: { span: 24 },
}, {
	label: '受托方生产地址', field: 'addrdetail', required: true, component: 'InputTextArea', colProps: { span: 24 },
}, {
	label: '车间', field: 'workshop', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '生产线', field: 'preparation', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '生产药类型', field: 'drugtype', required: true, component: 'RadioGroup', componentProps: { options: [{ label: '原料药', value: '1', }, { label: '非原料药', value: '2', }, { label: '暂无', value: '3', },], }, colProps: { span: 12 },
}, {
	label: '药品通用名称', field: 'drugname', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '批准文号/登记号', field: 'regnumb', required: true, component: 'Input', colProps: { span: 12 },
}, {
	label: '相关药品编码', field: 'cordrugid', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '药品规格', field: 'spec', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '药品剂型', field: 'drugdose', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '委托有效期', field: 'entrustvalidate', component: 'DatePicker', componentProps: { valueFormat: 'YYYY-MM-DD' }, colProps: { span: 12 }, required: true,
}, {
	label: '年生产能力', field: 'throughput', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '计算单位', field: 'calculationunit', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '生产线(条)', field: 'preparationnumber', component: 'Input', required: true, colProps: { span: 12 },
}, {
	label: '药品GMP证书编码', labelWidth: 140, field: 'getgmpcertificate', component: 'Input', colProps: { span: 12 }, required: true,
}, {
	label: 'GMP认证范围', field: 'gmprzscope', component: 'Input', colProps: { span: 12 }, required: true,
}];

export const SubTableColumnsMz: JVxeColumn[] = [{
	title: '证书id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '药品名称', key: 'ypmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '剂型', key: 'jy', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '规格', key: 'gg', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '管制类别', key: 'gzlb', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '批准文号', key: 'pzwh', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsYpck: JVxeColumn[] = [{
	title: '证书id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口药物名称', key: 'ckywmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口药物名称英文', key: 'ckywywmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '商品编码', key: 'spbm', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '剂型', key: 'jx', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口药物包装', key: 'ckywbz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口药物规格', key: 'ckywgz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口药物数量', key: 'ckywsl', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsYpxs: JVxeColumn[] = [{
	title: '证书id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '进口国家中文', key: 'jkgjzw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '进口国家英文', key: 'jkgjyw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '出口数量', key: 'cksl', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '类型', key: 'lx', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsOm: JVxeColumn[] = [{
	title: '证书Id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '药品通用名称中文', key: 'yptymczw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '药品通用名称英文', key: 'yptymcyw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '加工方法中文', key: 'jgffzw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '加工方法英文', key: 'jgffyw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '中国药品批准文号中文', key: 'zgyppzwhzw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '中国药品批准文号英文', key: 'zgyppzwhyw', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '是否通过我过gmp认证', key: 'sftgrz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsDyl: JVxeColumn[] = [{
	title: '产品备案号', key: 'zczh', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品名称', key: 'cpmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品类别代码', key: 'cplbDm', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '类别类型', key: 'cplbDm', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '是否受托生产', key: 'sfwtsc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '注册/备案人名称', key: 'zcbarmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '注册/备案人地址', key: 'zcbardz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '社会信用代码', key: 'shxydm', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '委托期限', key: 'wtqx', type: JVxeTypes.date, width: '200px', defaultValue: '', formatter: dateFormatter
}, {
	title: '备注', key: 'bz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsQxba23: JVxeColumn[] = [{
	title: '证书id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品名称', key: 'cpmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品备案号', key: 'cpzch', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '登记日期', key: 'wtrq', type: JVxeTypes.datetime, width: '200px', defaultValue: '',
}, {
	title: '排序', key: 'px', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsQxxkz: JVxeColumn[] = [{
	title: '证书Id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品名称', key: 'cpmc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '产品备案号', key: 'cpbah', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '登记日期', key: 'dzrq', type: JVxeTypes.datetime, width: '200px', defaultValue: '', formatter: dateFormatter
}, {
	title: '备注', key: 'bz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '排序', key: 'px', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsQxba: JVxeColumn[] = [{
	title: '证书id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '100px', defaultValue: '',
}, {
	title: '名称', key: 'mc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '地址/科室', key: 'dz', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '联系人/职务', key: 'lxr', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '电话', key: 'dh', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '类别 1临床实验机构(如多中心应注明牵头单位)2:研究者', key: 'lb', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsQxxs: JVxeColumn[] = [{
	title: '证书Id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '100px', defaultValue: '',
}, {
	title: '产品名称', key: 'mc', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '规格', key: 'gg', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '注册证或者备案号', key: 'bh', type: JVxeTypes.input, width: '200px', defaultValue: '',
}];

export const SubTableColumnsWlxsba: JVxeColumn[] = [{
	title: '证书Id', key: 'zsid', type: JVxeTypes.input, width: '200px', defaultValue: '',
}, {
	title: '条数', key: 'num', type: JVxeTypes.input, width: '100px', defaultValue: '',
}, {
	title: '医疗器械交易服务第三方平台备案平台名称', key: 'dsfptbafptmc', type: JVxeTypes.input, width: '400px', defaultValue: '',
}, {
	title: '医疗器械交易服务第三方平台备案凭证编号', key: 'pzbh', type: JVxeTypes.input, width: '300px', defaultValue: '',
}, {
	title: '备注', key: 'bz', type: JVxeTypes.textarea, width: '400px', defaultValue: '',
}];