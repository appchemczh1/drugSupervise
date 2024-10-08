<template>
  <div>
    <BasicForm @register="registerForm" ref="formRef"/>
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated  @change="handleChangeTabs">
          <a-tab-pane tab="certchild_ylqxwlxsba" key="certchildYlqxwlxsba" :forceRender="true">
            <JVxeTable
              keep-source
              resizable
              ref="certchildYlqxwlxsba"
              v-if="certchildYlqxwlxsbaTable.show"
              :loading="certchildYlqxwlxsbaTable.loading"
              :columns="certchildYlqxwlxsbaTable.columns"
              :dataSource="certchildYlqxwlxsbaTable.dataSource"
              :height="340"
              :rowNumber="true"
              :rowSelection="true"
              :disabled="formDisabled"
              :toolbar="true"
            />
          </a-tab-pane>
          <a-tab-pane tab="certchild_dylylqxscbapz" key="certchildDylylqxscbapz" :forceRender="true">
            <JVxeTable
              keep-source
              resizable
              ref="certchildDylylqxscbapz"
              v-if="certchildDylylqxscbapzTable.show"
              :loading="certchildDylylqxscbapzTable.loading"
              :columns="certchildDylylqxscbapzTable.columns"
              :dataSource="certchildDylylqxscbapzTable.dataSource"
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
  import {getBpmFormSchema,certchildYlqxwlxsbaColumns,certchildDylylqxscbapzColumns} from '../CertInfo.data';
  import {saveOrUpdate,certchildYlqxwlxsbaList,certchildDylylqxscbapzList} from '../CertInfo.api';

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
        schemas: getBpmFormSchema(props.formData),
        showActionButtonGroup: false,
        baseColProps: {span: 24}
      });

      const formDisabled = computed(()=>{
        if(props.formData.disabled === false){
          return false;
        }
        return true;
      });

      const refKeys = ref(['certchildYlqxwlxsba', 'certchildDylylqxscbapz', ]);
      const activeKey = ref('certchildYlqxwlxsba');
      const certchildYlqxwlxsba = ref();
      const certchildDylylqxscbapz = ref();
      const tableRefs = {certchildYlqxwlxsba, certchildDylylqxscbapz, };
      const certchildYlqxwlxsbaTable = reactive({
        loading: false,
        dataSource: [],
        columns:certchildYlqxwlxsbaColumns,
        show: false
      })
      const certchildDylylqxscbapzTable = reactive({
        loading: false,
        dataSource: [],
        columns:certchildDylylqxscbapzColumns,
        show: false
      })

      const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys,validateSubForm);

      function classifyIntoFormData(allValues) {
        let main = Object.assign({}, allValues.formValue)
        return {
          ...main, // 展开
          certchildYlqxwlxsbaList: allValues.tablesValue[0].tableData,
          certchildDylylqxscbapzList: allValues.tablesValue[1].tableData,
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
        requestSubTableData(certchildYlqxwlxsbaList, {id: data.id}, certchildYlqxwlxsbaTable, ()=>{
          certchildYlqxwlxsbaTable.show = true;
        });
        requestSubTableData(certchildDylylqxscbapzList, {id: data.id}, certchildDylylqxscbapzTable, ()=>{
          certchildDylylqxscbapzTable.show = true;
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
        certchildYlqxwlxsba,
        certchildDylylqxscbapz,
        certchildYlqxwlxsbaTable,
        certchildDylylqxscbapzTable,
      }
    }
  });
</script>