<template>
  <div style="background: #2f75e1;height: 60px;width: 100%;display: flex;justify-content: center;align-items: center;">
    <p style="font-size: 20px;color:white;margin-bottom: 0px !important;text-align: center">{{orgName}}</p>
  </div>
  <BasicForm @register="registerForm" ref="formRef" style="margin-top: 1%"/>
</template>
<script lang="ts" >
  import { onMounted, ref ,defineComponent,unref,defineEmits} from 'vue';
  import {BasicForm, useForm} from '@/components/Form';

  import {
    formSchema,
  } from '../../../../public/static/html/pages/index/js/Index.data';
  import {
    getcertmetelist,
    getCertInfoByZsId,
  } from '@/views/dzzz/certinfo/CertInfo.api';
  import {findDetail} from "@/views/dzzz/certtyperole/CerttypeRole.api";
  import { message } from 'ant-design-vue';

  let parma = new URLSearchParams(window.location.search);

  export default defineComponent({
    name: "informationForm",
    components:{
      BasicForm
    },
    setup(props){
      const orgName = ref('');

      const emit = defineEmits(['register', 'success']);
      const isUpdate = ref(true);
      const iswh = ref(false);
      const formDisabled = ref(false);
      const czType  = ref("");
      let certtypID;
      //表单配置
      const [registerForm, {resetFields,setFieldsValue,appendSchemaByField}] = useForm({
        labelWidth: 150,
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: {span: 24},
        labelWrap: true
      });
      //表单赋值
      async function initFormData() {
        //重置表单
        await reset();
        let  certInfo=  await getCertInfoByZsId({'zsid':parma.get('id')});
        let data={
          isUpdate:true,
          record:{recordData:certInfo},
          showFooter:false
        };
        orgName.value = data?.record.recordData?.qymc;

        isUpdate.value = !!data?.isUpdate;
        iswh.value=!!data?.iswh;
        console.log(iswh.value);
        formDisabled.value = !data?.showFooter;
        console.log(data);
        czType.value =data?.czType;
        console.log(czType);
        // 隐藏底部时禁用整个表单
        if(data?.certtypeID||data?.record.recordData?.certtypeid) {
          certtypID = data.certtypeID ? data.certtypeID : data.record.recordData.certtypeid;
        }
        else{
          message.warn("未选择证照，默认药品生产许可证");
          certtypID="78d8f71b-b72d-43eb-b11d-af27eedcfc78";
          iswh.value=true;
        }
        if(data?.certtypeID)
        {
          iswh.value=true;
        }

        //动态渲染表单removeSchemaByFiled

        let  certmetalist=  await getcertmetelist({'id':certtypID});

        console.log(certmetalist);
        let promise = await findDetail({"certtypeid":certtypID});
        if(certmetalist==null)
        {
          message.warn("未配置元数据或权限！");
        }


        let bgtext;
        let split=[];
        //变更
        if(czType.value=='变更'&&promise)
        {
          bgtext= promise.bg;
        }
        if(czType.value=='换证'&&promise)
        {
          bgtext= promise.hz;
        }

        if(bgtext&&bgtext.includes(","))
        {
          split= bgtext.split(",");
        }

        const certdata :any[] =[];

        let index=0;
        for (let i=0;i<certmetalist.length;i++)
        {
          let flag=true;
          //如果是维护
          if(unref(iswh))
          {
            flag=false;
          }
          else {
            for (let f = 0; f < split.length; f++) {

              if (certmetalist[i].yssx == split[f]) {
                flag = false;
              }

            }
          }
          //企业名称不可修改
          if( certmetalist[i].yssx.toLowerCase()=='qymc'||certmetalist[i].yssx.toLowerCase()=='shxydm')
          {
            flag=true;
          }
          //处理一下控件样式 if
          if(certmetalist[i].zdlx=='VARCHAR2'||certmetalist[i].zdlx=='VARCHAR'||certmetalist[i].zdlx=='1')
          {
            certmetalist[i].zdlx='Input';
          }
          //处理一下抄送 产品 等字段的转化
          if(certmetalist[i].yssx=='cp')
          {
            certmetalist[i].yssx='chanping';
          }
          if(certmetalist[i].yssx=='cs')
          {
            certmetalist[i].yssx='chaosong';
          }
          if(certmetalist[i].yssx=='gg')
          {
            certmetalist[i].yssx='guige';
          }
          certdata[index] = {
            label: certmetalist[i].lm,
            field: certmetalist[i].yssx.toLowerCase(),
            component: certmetalist[i].zdlx,
            defaultValue: certmetalist[i].mrz,
            colProps: {span: certmetalist[i].bjys==12?24:certmetalist[i].bjys},
            /*componentProps: {
              showTime: true,
              valueFormat: 'YYYY-MM-DD'
            },*/
            disabled:true,
            dynamicDisabled: flag,
            // dynamicRules: ({model, schema}) => {
            //   if (certmetalist[i].isbt == '1') {
            //
            //     return [
            //       {
            //         required: certmetalist[i].isbt == '1' ? true : false,
            //         message: '请输入' + certmetalist[i].lm + "!"
            //       },
            //     ];
            //   }
            // },
          };
          index++;
          if(certmetalist[i].isgs == '1'){
            await appendSchemaByField( certdata[i],'');
          }
        }
        console.log(certdata);
        if (unref(isUpdate)) {
          //表单赋值
          await setFieldsValue({
            ...data.record.recordData,
          });
        }
      };

      initFormData();

      async function reset() {
        await resetFields();
      }

      return {
        registerForm,
        formDisabled,
        orgName,
      }
    }
  });
</script>
<style>
  .jeecg-basic-form .ant-form-item:not(.ant-form-item-with-help) {
    margin-bottom: 0 !important;
  }
  .ant-form .ant-form-item .ant-form-item-label{
    flex: none !important;
    text-align: end;
    padding-right: 5px;
  }
  .ant-form .ant-form-item .ant-form-item-control{
    flex: none !important;
  }
  .ant-input-affix-wrapper-disabled{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    background-color: white !important;
    border-color: white !important;
  }
  .ant-input-affix-wrapper-textarea-with-clear-btn textarea.ant-input {
    background-color: white !important;
    border-color: white !important;
    color: #595959 !important;
    white-space: normal !important;
    word-break: break-all !important;
    padding-left: 10px !important;
  }
  .ant-picker .ant-picker-input >input{
    color: #595959 !important;
  }
  .ant-picker.ant-picker-disabled{
    background-color: white !important;
    border-color: white !important;
  }
  .ant-picker .ant-picker-suffix{
    display: none !important;
  }
  .ant-input-suffix{
    display: none !important;
  }

  .ant-btn-default:disabled {
    display: none;
  }
</style>
