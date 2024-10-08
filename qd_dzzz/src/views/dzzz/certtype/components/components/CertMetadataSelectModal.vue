<template>
  <BasicModal   v-bind="$attrs" @register="registerModal" destroyOnClose  width="50%" @ok="handleSubmits">

  <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated @change="handleChangeTabs">
      <a-tab-pane tab="证书主表数据" key="certMetadata" :forceRender="true">
        <BasicForm @register="registersearchForm" @submit="handleSubmitsearch" style="margin-top: 20px" />
        <JVxeTable
          keep-source
          resizable
          ref="certMetadata"
          :loading="certMetadataTable.loading"
          :columns="certMetadataTable.columns"
          :dataSource="certMetadataTable.dataSource"
          :height="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="false"


        />
<!--
          <a-button>已下单待回</a-button>-->

      </a-tab-pane>
    </a-tabs>
  </BasicModal>


</template>

<script lang="ts" setup>
    import {ref, computed, unref,reactive,defineProps} from 'vue';
    import {BasicModal, useModal, useModalInner} from '/@/components/Modal';
    import {BasicForm, FormSchema, useForm} from '/@/components/Form/index';
    import { JVxeTable } from '/@/components/jeecg/JVxeTable';
    import { useJvxeMethod } from '/@/hooks/system/useJvxeMethods.ts';
    import {
      formSchema,
      certMetadataJVxeColumns,
      certMetadataJVxeColumns2
    } from '../CertMetadataVersion.data';
    import {
      saveOrUpdate,
      queryCertMetadata,
      getCertinfo,
      certMetadataList
    } from '../CertMetadataVersion.api';
    import { VALIDATE_FAILED } from '/@/utils/common/vxeUtils';
    import AButton from "@/components/Button/src/BasicButton.vue";
    import CertMetadataModal from '../../components/CertMetadataModal.vue';
    import Icon from "@/components/Icon/src/Icon.vue";
    import {random} from "lodash-es";
    import dayjs from "dayjs";
    import {buildUUID} from "@/utils/uuid";
    import {pushIfNotExist} from "@/utils/common/compUtils";
    import {sync} from "rimraf";
    import JInput from "@/components/Form/src/jeecg/components/JInput.vue";
    import BasicFormSearch from "@/views/demo/document/form/BasicFormSearch.vue";
    import useSearchConfig from "ant-design-vue/es/vc-cascader/hooks/useSearchConfig";
    // Emits声明
    const uuid=defineProps({
      uuid:{
        type:String,  // 数据类型
        default:"未传值"  // 未传值时的默认值
      }

    })
    const formSchemas: FormSchema[] = [
      {
        field: 'lm',
        label: '列名',
        component: 'Input',
      },
    ];
    const pagination = reactive({
      current: 1,
      pageSize: 10,
      pageSizeOptions: ['10', '20', '30', '100', '200'],
      total: 1000,
    });

    const [registersearchForm] = useForm({
      //将表单内时间区域的值映射成 2个字段, 'YYYY-MM-DD'日期格式化
      fieldMapToTime: [['joinTime', ['joinTime_begin', 'joinTime_end'], 'YYYY-MM-DD']],
      //注册表单列
      schemas: formSchemas,
      //是否显示展开收起按钮，默认false
      showAdvancedButton: false,
      //超过指定行数折叠，默认3行
      autoAdvancedCol: 3,
      //折叠时默认显示行数，默认1行
      alwaysShowLines: 2,

      //将表单内数值类型区域的值映射成 2个字段
      fieldMapToNumber: [['workYears', ['workYears_begin', 'workYears_end']]],
      //每列占比，默认一行为24
      baseColProps: { span: 12 },
    });

    //设置标题
    const title = computed(() => (!unref(isUpdate) ? '选择主表字段' : '编辑'));
    const emit = defineEmits(['register','success']);
    const isUpdate = ref(true);
    const formDisabled = ref(false);
    const refKeys = ref(['certMetadata', ]);
    const activeKey = ref('certMetadata');
    const certMetadata = ref();
    const tableRefs = {certMetadata, };
    let dataSource = ref<any[]>([]);
    const loading = ref(false);
    const certMetadataTable = reactive({
          loading: false,
          dataSource: <any[]>([]),
          columns:certMetadataJVxeColumns2
    })
   /* const [search]=   useSearchConfig({searchConfig:{

      }});*/
    const [registerModaldata, {openModal}] = useModal();
    //表单配置
     //表单赋值
    const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
        //重置表单


        setModalProps({confirmLoading: false,showCancelBtn:data?.showFooter,showOkBtn:data?.showFooter});
        isUpdate.value = !!data?.isUpdate;
        formDisabled.value = !data?.showFooter;

        await getcerinfo(null,0,1,true);
        // 隐藏底部时禁用整个表单

    });
    //方法配置
    const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys);

  function handleSubmits() {
   const values=  certMetadata.value!.getSelectionData();
   for(let i=0;i<values.length;i++)
   {
     values[i].id=guid();
   }
   console.log(values);
    closeModal();
    //刷新列表
    emit('success',values);
  }

    async  function  handleSubmitsearch(values: any) {
      const certinfo = await getCertinfo({lm:values.lm});
      console.log('提交按钮数据::::', certinfo);

      certMetadataTable.dataSource=certinfo;
    }


    function classifyIntoFormData(allValues) {
         let main = Object.assign({}, allValues.formValue)
         return {
           ...main, // 展开
           certMetadataList: allValues.tablesValue[0].tableData,
         }
       }
    function handleAdd() {
      openModal(true, {
        isUpdate: false,
        showFooter: true,
      });
    }
    function handleSuccess(v) {

      randomPage(v,0,1,true);
    }
    /* 随机生成数据 */
    function randomPage(valuess,current, pageSize, isLoading = false) {
      if (isLoading) {
        loading.value = true;
      }

      const certMetadatavalues :any[] = certMetadata.value!.getTableData();
      console.log(certMetadatavalues);
      certMetadatavalues.push(valuess);
      let begin = Date.now();
      let values: any[] = certMetadatavalues;

      certMetadataTable.dataSource= values;
      let end = Date.now();
      let diff = end - begin;

      if (isLoading && diff < pageSize) {
        setTimeout(() => (loading.value = false), pageSize - diff);
      }
    }

    /* 随机生成数据 */
   async  function getcerinfo(valuess,current, pageSize, isLoading = false) {
      if (isLoading) {
        loading.value = true;
      }


      const certlist:any []=  await getCertinfo();
      console.log(certlist);

      let begin = Date.now();
      let values: any[] = certlist;

      certMetadataTable.dataSource= values;
      let end = Date.now();
      let diff = end - begin;

      if (isLoading && diff < pageSize) {
        setTimeout(() => (loading.value = false), pageSize - diff);
      }
    }
    //表单提交事件
    async function requestAddOrEdit(values) {
        try {
            setModalProps({confirmLoading: true});
          values.certTypeId=uuid.uuid;

          console.log(values);
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

      /*  if(certlistdata.isinsert=='0') {
          console.log("进来判断了");
          console.log(certlistdata.typeid);
            return  certlistdata.typeid;
        }*/

        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
          var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
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
