<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="800" @ok="handleSubmit">
    <BasicForm @register="registerForm"/>
<!--    <a-form >
      <a-row class="form-row" :gutter="16">
        <a-col :lg="24">
          <a-form-item label="变更:" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
            <JCheckbox   :options="sportOptions"/>
          </a-form-item>
        </a-col>
&lt;!&ndash;        <a-col :lg="8">
          <a-form-item label="dictCode式用法" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
            <JCheckbox v-model:value="form.sex" dictCode="sex"/>
          </a-form-item>
        </a-col>&ndash;&gt;
      </a-row>
      <a-row class="form-row" :gutter="16">
        <a-col :lg="24">
          <a-form-item label="换证:" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
            <JCheckbox   :options="sportOptions"/>
          </a-form-item>
        </a-col>
        &lt;!&ndash;        <a-col :lg="8">
                  <a-form-item label="dictCode式用法" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
                    <JCheckbox v-model:value="form.sex" dictCode="sex"/>
                  </a-form-item>
                </a-col>&ndash;&gt;
      </a-row>
      <a-row class="form-row" :gutter="16">
        <a-col :lg="24">
          <a-form-item label="证书纠错:" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
            <JCheckbox   :options="sportOptions"/>
          </a-form-item>
        </a-col>
        &lt;!&ndash;        <a-col :lg="8">
                  <a-form-item label="dictCode式用法" :label-col="{ span: 6 }" :wrapper-col="{ span: 15 }">
                    <JCheckbox v-model:value="form.sex" dictCode="sex"/>
                  </a-form-item>
                </a-col>&ndash;&gt;
      </a-row>
    </a-form>-->
  </BasicModal>
</template>

<script lang="ts" setup>
import {ref, computed, unref, defineProps,reactive} from 'vue';
import {BasicModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {formSchema, formSchemaset} from '../CerttypeRole.data';
import {saveOrUpdate, certmetelist, getcertmetelist, findDetailInner} from '../CerttypeRole.api';
import {JCheckbox} from '/@/components/Form';
import {message} from "ant-design-vue";
// Emits声明
const emit = defineEmits(['register','success']);
const isUpdate = ref(true);
const uuid=defineProps({
  certtypeid:{
    type:String,  // 数据类型
    default:"未传值"  // 未传值时的默认值
  }
})
const formData = ref({});
/*const  form = reactive({
  sex : '1',
  sport: '1,3'
});*/
/*  let certmetelist1 =   certmetelist({'id':"12312"});
  console.log(certmetelist1);*/
  let sportOptions = /*certmetelist({'id':"12312"});*/[]/*,[
  {
    label:"足球",
    value:"1"
  },{
    label:"篮球",
    value:"2"
  },{
    label:"乒乓球",
    value:"3"
  }]*/
//表单配置
const [registerForm, {setProps,resetFields, setFieldsValue, validate,appendSchemaByField,updateSchema}] = useForm({
  labelWidth: 150,
  schemas: formSchemaset,
  showActionButtonGroup: false,
  baseColProps: {span: 24},

});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await resetFields();
  setModalProps({confirmLoading: false,showCancelBtn:!!data?.showFooter,showOkBtn:!!data?.showFooter});
  isUpdate.value = !!data?.isUpdate;
  let alldata  ='';
  const certdata :any[] =[];
  let index=0;
  sportOptions= await  getcertmetelist({"id":uuid.certtypeid});
  if(sportOptions.length==0)
  {
    message.warn("请先配置元数据！");

  }

  for (let i=0;i<sportOptions.length;i++)
  {
    if(i==sportOptions.length-1)
    {
      alldata+=sportOptions[i].value;
    }
    else {
      alldata += sportOptions[i].value + ",";
    }

  }
  const lines3 :any= {
    field: 'divider-api-select',
    component: 'Divider',
    label: '变更',
  }
  await appendSchemaByField(lines3,'');
  //全选按钮

    certdata[0] = {
      field: 'bg',
      component: 'JCheckbox',
      label: '变更',
      componentProps: {
        options: sportOptions,
      },

    },
    await appendSchemaByField( certdata[0],'');
  const quanxuanbg:any={
    field: 'qxbg',
    component: 'JCheckbox',
    label: '全选',
    componentProps:({ formModel }) => {
      return {
        options: [
          { label:"",
            value:"1"
          }
        ],
        onChange: (e) => {
          if(e==1)
          {
            formModel.bg=alldata;
          }
          else {
            formModel.bg = '';
          }
        },
      };
    },

  }
  await appendSchemaByField( quanxuanbg,'');

    const lines :any= {
      field: 'divider-api-select',
      component: 'Divider',
      label: '换证',
    }
  await appendSchemaByField(lines,'');


  certdata[1] = {
    field: 'hz',
    component: 'JCheckbox',
    label: '换证',
    componentProps: {
      options: sportOptions,
    },
  },
  await appendSchemaByField( certdata[1],'');
  const quanxuanhz:any={
    field: 'qxhz',
    component: 'JCheckbox',
    label: '全选',
    componentProps:({ formModel }) => {
      return {
        options: [
          { label:"",
            value:"1"
          }
        ],
        onChange: (e) => {
          if(e==1)
          {
            formModel.hz=alldata;
          }
          else {
            formModel.hz = '';
          }
        },
      };
    },
  }
  await appendSchemaByField( quanxuanhz,'');

  const lines1 :any= {
    field: 'divider-api-select',
    component: 'Divider',
    label: '证书纠错',
  }
  await appendSchemaByField(lines1,'');


  certdata[2] = {
    field: 'zsjc',
    component: 'JCheckbox',
    label: '证书纠错',
    componentProps: {
      options: sportOptions,
    },
  },
  await appendSchemaByField( certdata[2],'');
  const quanxuanzsjc:any={
    field: 'qxzsjc',
    component: 'JCheckbox',
    label: '全选',
    componentProps:({ formModel }) => {
      return {
        options: [
          { label:"",
            value:"1"
          }
        ],
        onChange: (e) => {
          if(e==1)
          {
            formModel.zsjc=alldata;
          }
          else {
            formModel.zsjc = '';
          }
        },
      };
    },


  }
  await appendSchemaByField( quanxuanzsjc,'');
  const lines2 :any= {
    field: 'divider-api-select',
    component: 'Divider',
    label: '数据维护',
  }
  await appendSchemaByField(lines2,'');

  certdata[3] = {
    field: 'sjwh',
    component: 'JCheckbox',
    label: '数据维护',
    componentProps: {
      options: sportOptions,
    },

  },
  await appendSchemaByField( certdata[3],'');
  const quanxuansjwh:any={
    field: 'qxsjwh',
    component: 'JCheckbox',
    label: '全选',
    componentProps:({ formModel }) => {
      return {
        options: [
          { label:"",
            value:"1"
          }
        ],
        onChange: (e) => {
          if(e==1)
          {
            formModel.sjwh=alldata;
          }
          else {
            formModel.sjwh = '';
          }
        },
      };
    },
  }
  await appendSchemaByField( quanxuansjwh,'');

  if (unref(isUpdate)) {
    //获取后端接口
    let promise = await findDetailInner({"certtypeid":uuid.certtypeid, roleId: data?.record?.roleid}) || {};
    if(promise!=null) {
      //表单赋值
      promise.roleId = data?.record?.roleid;
      formData.value = promise;
      await setFieldsValue(promise);
    }
  }
  // 隐藏底部时禁用整个表单
  /*setProps({ disabled: !data?.showFooter })*/
});
//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '字段权限'));
//表单提交事件
async function handleSubmit(v) {
  try {
    let values=await validate();
    setModalProps({confirmLoading: true});
    //提交表单
    await saveOrUpdate({...formData.value, ...values, certtypeid: uuid.certtypeid}, isUpdate.value);
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
:deep(.ant-input-number){
  width: 100%
}

:deep(.ant-calendar-picker){
  width: 100%
}
</style>
