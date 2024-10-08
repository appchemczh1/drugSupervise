<template>
  <div>
    <BasicForm @register="registerForm" ref="formRef"/>
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated  @change="handleChangeTabs">
          <a-tab-pane tab="药品生产子表自产" key="certchildYpscZc" :forceRender="true">
            <JVxeTable
              keep-source
              resizable
              ref="certchildYpscZc"
              v-if="certchildYpscZcTable.show"
              :loading="certchildYpscZcTable.loading"
              :columns="certchildYpscZcTable.columns"
              :dataSource="certchildYpscZcTable.dataSource"
              :height="340"
              :rowNumber="true"
              :rowSelection="true"
              :disabled="formDisabled"
              :toolbar="true"
            />
          </a-tab-pane>
          <a-tab-pane tab="药品生产子表委托" key="certchildYpscWt" :forceRender="true">
            <JVxeTable
              keep-source
              resizable
              ref="certchildYpscWt"
              v-if="certchildYpscWtTable.show"
              :loading="certchildYpscWtTable.loading"
              :columns="certchildYpscWtTable.columns"
              :dataSource="certchildYpscWtTable.dataSource"
              :height="340"
              :rowNumber="true"
              :rowSelection="true"
              :disabled="formDisabled"
              :toolbar="true"
            />
          </a-tab-pane>
          <a-tab-pane tab="药品生产子表受托" key="certchildYpscSt" :forceRender="true">
            <JVxeTable
              keep-source
              resizable
              ref="certchildYpscSt"
              v-if="certchildYpscStTable.show"
              :loading="certchildYpscStTable.loading"
              :columns="certchildYpscStTable.columns"
              :dataSource="certchildYpscStTable.dataSource"
              :height="340"
              :rowNumber="true"
              :rowSelection="true"
              :disabled="formDisabled"
              :toolbar="true"
            />
          </a-tab-pane>
    </a-tabs>

    <div style="width: 100%;text-align: center" v-if="!formDisabled">
      <a-button @click="handleSubmit" pre-icon="ant-design:check" type="primary">提 交</a-button>
    </div>
  </div>
</template>

<script lang="ts">

  import {BasicForm, useForm} from '/@/components/Form/index';
  import { computed, defineComponent, reactive, ref, unref } from 'vue';
  import {defHttp} from '/@/utils/http/axios';
  import { propTypes } from '/@/utils/propTypes';
  import { useJvxeMethod } from '/@/hooks/system/useJvxeMethods';
  import { VALIDATE_FAILED } from '/@/utils/common/vxeUtils';
  import {certchildYpscZcColumns,certchildYpscWtColumns,certchildYpscStColumns} from '../CertInfo.data';
  import {saveOrUpdate,certchildYpscZcList,certchildYpscWtList,certchildYpscStList} from '../CertInfo.api';

  export default defineComponent({
    name: "CertInfoForm",
    components:{
      BasicForm,
    },
    props:{
      formData: propTypes.object.def({}),
      formBpm: propTypes.bool.def(true),
    },
    setup(props){
      const [registerForm, { setFieldsValue, setProps }] = useForm({
        labelWidth: 150,
        schemas: [],
        showActionButtonGroup: false,
        baseColProps: {span: 24}
      });

      const formDisabled = computed(()=>{
        if(props.formData.disabled === false){
          return false;
        }
        return true;
      });

      const refKeys = ref(['certchildYpscZc', 'certchildYpscWt', 'certchildYpscSt', ]);
      const activeKey = ref('certchildYpscZc');
      const certchildYpscZc = ref();
      const certchildYpscWt = ref();
      const certchildYpscSt = ref();
      const tableRefs = {certchildYpscZc, certchildYpscWt, certchildYpscSt, };
      const certchildYpscZcTable = reactive({
        loading: false,
        dataSource: [],
        columns:certchildYpscZcColumns,
        show: false
      })
      const certchildYpscWtTable = reactive({
        loading: false,
        dataSource: [],
        columns:certchildYpscWtColumns,
        show: false
      })
      const certchildYpscStTable = reactive({
        loading: false,
        dataSource: [],
        columns:certchildYpscStColumns,
        show: false
      })

      const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys,validateSubForm);

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
        await saveOrUpdate(values, true);
      }

      const queryByIdUrl = '/dzzz.certinfo/certInfo/queryById';
      async function initFormData(){
        let params = {id: props.formData.dataId};
        const data = await defHttp.get({url: queryByIdUrl, params});
        //设置表单的值
        await setFieldsValue({...data});
        requestSubTableData(certchildYpscZcList, {id: data.id}, certchildYpscZcTable, ()=>{
          certchildYpscZcTable.show = true;
        });
        requestSubTableData(certchildYpscWtList, {id: data.id}, certchildYpscWtTable, ()=>{
          certchildYpscWtTable.show = true;
        });
        requestSubTableData(certchildYpscStList, {id: data.id}, certchildYpscStTable, ()=>{
          certchildYpscStTable.show = true;
        });
        //默认是禁用
        await setProps({disabled: formDisabled.value})
      }

      initFormData();

      return {
        registerForm,
        formDisabled,
        formRef,
        handleSubmit,
        activeKey,
        handleChangeTabs,
        certchildYpscZc,
        certchildYpscWt,
        certchildYpscSt,
        certchildYpscZcTable,
        certchildYpscWtTable,
        certchildYpscStTable,
      }
    }
  });
</script>
