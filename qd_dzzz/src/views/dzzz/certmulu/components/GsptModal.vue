<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="'证照信息'" :width="1200"
              >
    <div style="background: #2196F3;height: 50px;width: 100%;display: flex;justify-content: center;align-items: center;">
      <p style="font-size: 24px;color:white;margin-bottom: 0px !important;">{{orgName}}</p>
    </div>
    <BasicForm @register="registerForm" ref="formRef" style="margin-top: 1%"/>

  </BasicModal>
</template>

<script lang="ts" setup>
import {ref, computed, unref, reactive, defineProps,defineEmits} from 'vue';
import {BasicModal, useModal, useModalInner} from '@/components/Modal';
import {BasicForm, useForm} from '@/components/Form';
import {
  formSchema,
} from '../../../../../public/static/html/pages/index/js/Index.data';
import {
  getcertmetelist,
  getCertInfoByZsId,
} from '@/views/dzzz/certinfo/CertInfo.api';
import {findDetail} from "@/views/dzzz/certtyperole/CerttypeRole.api";
import { message } from 'ant-design-vue';
// Emits声明
const uuid=defineProps({
  certtypeid:{
    type:String,  // 数据类型
    default:"未传值"  // 未传值时的默认值
  },
  zt:{
    type:String,  // 数据类型
    default:"3"  // 未传值时的默认值
  },
  wgz:{
    type:String,  // 数据类型
     // 未传值时的默认值
  }
});

const orgName = ref('');

const emit = defineEmits(['register', 'success']);
const isUpdate = ref(true);
const iswh = ref(false);
const formDisabled = ref(false);
const czType  = ref("");
let certtypID;
const [registerModaldata, {openModal}] = useModal();

//表单配置
const [registerForm, {setProps, resetFields, setFieldsValue,resetSchema,appendSchemaByField,removeSchemaByFiled}] = useForm({
  labelWidth: 180,
  schemas: formSchema,
  showActionButtonGroup: false,
  baseColProps: {span: 24},
  labelWrap: true
});
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await reset();
  if(data?.zsid){
    let  certInfo=  await getCertInfoByZsId({'zsid':data.zsid});
    data={
      isUpdate:true,
      record:{recordData:certInfo},
      showFooter:false
    };
  }
  orgName.value = data?.record.recordData?.qymc;

  setModalProps({
    confirmLoading: false,
    showCancelBtn: false,
    showOkBtn: false,
  });
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
        dynamicRules: ({model, schema}) => {
          if (certmetalist[i].isbt == '1') {

            // return [
            //   {
            //     required: certmetalist[i].isbt == '1' ? true : false,
            //     message: '请输入' + certmetalist[i].lm + "!"
            //   },
            // ];
          }
        },
      }
   index++;
    if(certmetalist[i].isgs == '1'){
      await appendSchemaByField( certdata[i],'');
    }
    // await appendSchemaByField( certdata[i],'');

  }
console.log(certdata);
  if (unref(isUpdate)) {
    //表单赋值
    await setFieldsValue({
      ...data.record.recordData,
    });
  }
});

//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

async function reset() {
  await resetFields();
}


</script>

<style lang="less" scoped>
/** 时间和数字输入框样式 */
:deep(.ant-input-number) {
  width: 100%
}

:deep(.ant-calendar-picker) {
  width: 100%
}
</style>
