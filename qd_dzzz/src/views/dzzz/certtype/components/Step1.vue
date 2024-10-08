<template>
  <div class="step1">
    <div class="step1-form">
      <BasicForm  @register="register" ref="ruleFormRef"
                >
      </BasicForm>
    </div>
    <a-divider />
  </div>
</template>
<script lang="ts">
import {defineComponent, ref, unref} from 'vue';
  import { BasicForm, useForm } from '/@/components/Form';
  import { step1Schemas } from './step.data';
import {saveOrUpdate} from "@/views/dzzz/certtype/CertType.api";
import {useModalInner} from "@/components/Modal";
import {string} from "vue-types";
import {defHttp} from "@/utils/http/axios";
 let step1data={};
  export default defineComponent({
    components: {
      BasicForm,
    },
    props: {
      certtypeid: String,
      isupdate:String,
      listdata:Object,
    },
    emits: ['next'],
    setup(props, { emit }) {
       console.log(props.isupdate);
      //如果是编辑

      const [register, { validate,getFieldsValue ,setFieldsValue}] = useForm({
        labelWidth: 200,
        schemas: step1Schemas,
        actionColOptions: {
          span: 14,
        },
        showResetButton: false,
        showSubmitButton:false,
      });



       function panduanbianji(){

      if( props.isupdate=='0')
      {
        alert("进来了");
          setFieldsValue({'certtypename':'1232132'});
      }
    }

      async function initFormData(id){
        let params = {'id': id};
        const queryByIdUrl = '/dzzz/certType/queryById';
        const data = await defHttp.get({url: queryByIdUrl, params});

        //设置表单的值
        await setFieldsValue(data);
        //默认是禁用
        /*await setProps({disabled: formDisabled.value})*/
      }
      /*initFormData();*/
     /* if (unref(isUpdate)) {
        //表单赋值
        await setFieldsValue({
          ...data.record,
        });
      }*/
    /*  async function customSubmitFunc() {
        try {
          const values = await validate();
          step1data=values;
          emit('next', values);
        } catch (error) {}
      }*/

      async  function customSubmitFunc()
      {
        const values =  await validate();
        step1data=getFieldsValue();
        return values;
      }

      async  function customSubmitFunc1()
      {
        const values =  await validate();

        return values;
      }
    /*  const ruleFormRef = ref<FormInstance>();
      const validateJbxx = async ()=> {
        //校验成功则方法自动返回true，校验方法报错则说明校验失败，返回false
        try {
          return await ruleFormRef.value.validate()
        } catch (error) {
          return false
        }
      }
//将方法暴露出去
 /!*     defineExpose({validateJbxx});*!/*/

      //表单提交事件
      async function handleSubmit(v) {
        try {
          let values = v;
          console.log(values);
          values.id=props.certtypeid;
        /*  setModalProps({confirmLoading: true});*/
          //提交表单
           if(props.isupdate=='0') {
             await saveOrUpdate(values, 1);
           }
          if(props.isupdate=='1') {
            await saveOrUpdate(values, 0);
          }
          //关闭弹窗

          //刷新列表
         /* emit('success');*/
        } finally {
      /*    setModalProps({confirmLoading: false});*/
        }
      }
      /*panduanbianji();*/
      return { register,customSubmitFunc,customSubmitFunc1,handleSubmit,getFieldsValue,initFormData};
    },
  });


</script>
<style lang="less" scoped>
  .step1 {
    &-form {
      width: 550px;
      margin: 0 auto;
    }

  }

</style>
