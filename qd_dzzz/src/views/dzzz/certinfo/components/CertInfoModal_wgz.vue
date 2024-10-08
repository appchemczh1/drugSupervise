<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="'证照信息'" :width="1200"
              @ok="handleSubmit">
    <BasicForm @register="registerForm" ref="formRef"/>
    <div style="margin-top: 20px;"></div>
<!--    <div>-->
<!--      <div style="margin-top: 20px;font-size:18px;">非证面信息</div>-->
<!--    </div>-->
<!--    <BasicForm @register="registerFormfzm" ref="formReffzm"/>-->
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated @change="handleChangeTabs" >
      <a-tab-pane tab="自产"  v-if="zc"  key="certchildYpscZc" :forceRender="true" >
        <!--        <a-button preIcon="ion:layers-outline"
                          style="z-index: 9999;float: left;margin-top: 10px;margin-right: 10px;background-color: #0a8fe9;color: azure;"
                          @click="handleAddzc">新增</a-button>-->
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpscZc"
          :loading="certchildYpscZcTable.loading"
          :columns="certchildYpscZcTable.columns"
          :dataSource="certchildYpscZcTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          :toolbarConfig="{
            btn: [ ],
          }"
        >
          <!--          <slot v-if="handleEditzc" name="bianji" :size="90" />-->
          <template #bianjizc="props">
            <a @click="handleEditzc(props)">编辑</a>
          </template>
        </JVxeTable>

      </a-tab-pane>

      <a-tab-pane tab="委托" v-if="wt" key="certchildYpscWt" :forceRender="true">
        <!--        <a-button preIcon="ion:layers-outline"
                          style="z-index: 9999;float: left;margin-top: 10px;margin-right: 10px;background-color: #0a8fe9;color: azure;"
                          @click="handleAddwt">新增</a-button>-->
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpscWt"
          :loading="certchildYpscWtTable.loading"
          :columns="certchildYpscWtTable.columns"
          :dataSource="certchildYpscWtTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          :toolbarConfig="{
            btn: [ ],
          }"
        >
          <!--          <template #bianjiwt="props">
                      <a @click="handleEditwt(props)">编辑</a>
                    </template>-->
        </JVxeTable>
      </a-tab-pane>
      <a-tab-pane tab="受托" v-if="st" key="certchildYpscSt" :forceRender="true" >
        <!--        <a-button preIcon="ion:layers-outline"
                          style="z-index: 9999;float: left;margin-top: 10px;margin-right: 10px;background-color: #0a8fe9;color: azure;"
                          @click="handleAddst">新增</a-button>-->
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpscSt"
          :loading="certchildYpscStTable.loading"
          :columns="certchildYpscStTable.columns"
          :dataSource="certchildYpscStTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          :toolbarConfig="{
            btn: [ ],
          }"
        >
          <!--          <template #bianjist="props">
                      <a @click="handleEditst(props)">编辑</a>
                    </template>-->
        </JVxeTable>
      </a-tab-pane>
      <a-tab-pane tab="第二三类医疗器械委托备案" v-if="qxba23" key="certchildYlqxwtbaZb" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYlqxwtbaZb"
          :loading="certchildYlqxwtbaZbTable.loading"
          :columns="certchildYlqxwtbaZbTable.columns"
          :dataSource="certchildYlqxwtbaZbTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="二三类医疗机械生产" v-if="qxsc" key="certchildYlqxscbaZb" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYlqxscbaZb"
          :loading="certchildYlqxscbaZbTable.loading"
          :columns="certchildYlqxscbaZbTable.columns"
          :dataSource="certchildYlqxscbaZbTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="药品出口准许证" v-if="ypckzxz" key="certchildYpckxkz" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpckxkz"
          :loading="certchildYpckxkzTable.loading"
          :columns="certchildYpckxkzTable.columns"
          :dataSource="certchildYpckxkzTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="医疗器械临床试验备案" v-if="qxbz" key="certchirdYlqxlcsyba" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchirdYlqxlcsyba"
          :loading="certchirdYlqxlcsybaTable.loading"
          :columns="certchirdYlqxlcsybaTable.columns"
          :dataSource="certchirdYlqxlcsybaTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="医疗器械产品出口销售证明" v-if="qxckxs" key="certchildYlqxcpckxs" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYlqxcpckxs"
          :loading="certchildYlqxcpckxsTable.loading"
          :columns="certchildYlqxcpckxsTable.columns"
          :dataSource="certchildYlqxcpckxsTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="麻醉药品和精神药品定点生产批件" v-if="mz" key="certchildMzyphjsypddsc" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildMzyphjsypddsc"
          :loading="certchildMzyphjsypddscTable.loading"
          :columns="certchildMzyphjsypddscTable.columns"
          :dataSource="certchildMzyphjsypddscTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
        />
      </a-tab-pane>
      <a-tab-pane tab="药品出口销售证明" v-if="ypckxs" key="certchildYpckxszm" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpckxszm"
          :loading="certchildYpckxszmTable.loading"
          :columns="certchildYpckxszmTable.columns"
          :dataSource="certchildYpckxszmTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="药瓶生产gmp" v-if="gmp" key="certchildYpscGmp" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYpscGmp"
          :loading="certchildYpscGmpTable.loading"
          :columns="certchildYpscGmpTable.columns"
          :dataSource="certchildYpscGmpTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="出口欧盟原料" v-if="om" key="certchildCkomyly" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildCkomyly"
          :loading="certchildCkomylyTable.loading"
          :columns="certchildCkomylyTable.columns"
          :dataSource="certchildCkomylyTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="医疗器械网络销售备案"  v-if="wlxsba" key="certchildYlqxwlxsba" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildYlqxwlxsba"
          :loading="certchildYlqxwlxsbaTable.loading"
          :columns="certchildYlqxwlxsbaTable.columns"
          :dataSource="certchildYlqxwlxsbaTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
      <a-tab-pane tab="第一类医疗器械生产备案" v-if="dyl"  key="certchildDylylqxscbapz" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="certchildDylylqxscbapz"
          :loading="certchildDylylqxscbapzTable.loading"
          :columns="certchildDylylqxscbapzTable.columns"
          :dataSource="certchildDylylqxscbapzTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="false"
        />
      </a-tab-pane>
<!--      <a-tab-pane tab="国家局推送数据"  key="shiyan" :forceRender="true">-->
<!--        <BasicForm @register="registerFormshiyan" ref="formRefshiyan"/>-->
<!--      </a-tab-pane>-->
      <!--      <a-tab-pane tab="国家局推送数据样式2"  key="guijiashujudata" :forceRender="true">
              <JVxeTable
                keep-source
                resizable
                ref="certchildCkomyly"
                :loading="guijiashuju.loading"
                :columns="guijiashuju.columns"
                :dataSource="guijiashuju.dataSource"
                :height="340"
                :rowNumber="true"
                :rowSelection="true"
                :disabled="formDisabled"
                :toolbar="true"
              />
            </a-tab-pane>-->
    </a-tabs>
    <div v-if="iswgz">
      <div>
        <div style="margin-top: 20px" ><span style="color: red">未盖章内容</span></div>
      </div>
      <div >
        <czjlList :data="czjlInfo"  :isdq="1" :wgz="wgzflag" />
      </div>
    </div>
    <div>
      <div>
        <div style="margin-top: 20px">历史操作记录</div>
      </div>
      <div >
        <czjlList :data="czjlInfo" :wgz="wgzflag" />
      </div>
    </div>
    <div>

      <div v-if="showcz" >
        <div>
          <div style="margin-top: 20px">操作</div>
        </div>
        <BasicForm @register="registerFormcz"  ref="formRefcz">
          <!--插槽:table标题-->

        </BasicForm>
      </div>
      <div v-if="showbg" >
        <div>
          <div style="margin-top: 20px">操作</div>
        </div>
        <BasicForm @register="registerFormbg"  ref="formRefbg">
          <!--插槽:table标题-->

        </BasicForm>
      </div>
      <div  v-if="showwh" >
        <div>
          <div style="margin-top: 20px">操作</div>
        </div>
        <BasicForm @register="registerFormwh"  ref="formRefwh">
          <!--插槽:table标题-->

        </BasicForm>
      </div>
      <div v-if="showqxgz" >
        <div>
          <div style="margin-top: 20px">操作</div>
        </div>
        <BasicForm @register="registerFormqxgz"  ref="formRefqxgz">
          <!--插槽:table标题-->

        </BasicForm>
      </div>
    </div>

  </BasicModal>

  <CertchildYpscZcModal @register="registerModaldata" @success="handleSuccesszc"></CertchildYpscZcModal>
  <CertchildYpscStModal @register="registerModaldatast" @success="handleSuccessst"></CertchildYpscStModal>
  <CertchildYpscWtModal @register="registerModaldatawt" @success="handleSuccesswt"></CertchildYpscWtModal>

</template>

<script lang="ts" setup>
import {ref, computed, unref, reactive, defineProps} from 'vue';
import {BasicModal, useModal, useModalInner} from '/@/components/Modal';
import {BasicForm, useForm} from '/@/components/Form/index';
import {JVxeTable} from '/@/components/jeecg/JVxeTable'
import {useJvxeMethod} from '/@/hooks/system/useJvxeMethods.ts'
import {
  formSchema,
  certchildYpscZcColumns,
  certchildYpscWtColumns,
  certchildYpscStColumns,
  guojiashuju,
  formSchemacz,
  formSchemabg,
  formSchemawh,
  formSchemawhqxgz,
  certchildYlqxwtbaZbColumns,
  certchildYlqxscbaZbColumns,
  certchildYpckxkzColumns,
  certchirdYlqxlcsybaColumns,
  certchildYlqxcpckxsColumns,
  certchildMzyphjsypddscColumns,
  certchildYpckxszmColumns,
  certchildYpscGmpColumns,
  certchildCkomylyColumns,
  shiyanformSchema,
  formSchemawgz, wzmformSchema,
  certchildDylylqxscbapzColumns,
  certchildYlqxwlxsbaColumns
} from '../CertInfo.data';
import {
  saveOrUpdate,
  certchildYpscZcList,
  certchildYpscWtList,
  certchildYpscStList,
  getcertmetelist,
  getzminfodata,
  caoZuo,
  certchildYlqxwtbaZbList,
  certchildYlqxscbaZbList,
  certchildYpckxkzList,
  certchirdYlqxlcsybaList,
  certchildYlqxcpckxsList,
  certchildMzyphjsypddscList,
  certchildYpckxszmList,
  certchildYpscGmpList,
  certchildCkomylyList,
  getshiyanlist,
  certchildYlqxwlxsbaList, certchildDylylqxscbapzList, updataData
} from '../CertInfo.api';
import {VALIDATE_FAILED} from '/@/utils/common/vxeUtils'
import {rules} from "@/utils/helper/validator";
import czjlList from '../../operation/CertInfoOperationRecordList.vue';
import CertchildYpscZcModal from '../components/sub/CertchildYpscZcModal.vue';
import CertchildYpscStModal from '../components/sub/CertchildYpscStModal.vue';
import CertchildYpscWtModal from '../components/sub/CertchildYpscWtModal.vue';
import {findDetail} from "@/views/dzzz/certtyperole/CerttypeRole.api";
import { message } from 'ant-design-vue';
// Emits声明
const nu=ref(false);
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
})
const emit = defineEmits(['register', 'success']);
const isUpdate = ref(true);
const iswh = ref(false);
const formDisabled = ref(false);
const czType  = ref("");
const iswgz=ref(false);
const wgzflag=ref(0);
const refKeys = ref(['certchildYpscZc', 'certchildYpscWt', 'certchildYpscSt',]);
const activeKey = ref('certchildYpscZc');
const certchildYpscZc = ref();
const certchildYpscWt = ref();
const certchildYpscSt = ref();
const czjlInfo=ref();
const formRefcz=ref<BasicForm>();
const formRefshiyan=ref<BasicForm>();
const guijiashujudata=ref<BasicForm>();
const formReffzm=ref<BasicForm>();
let certtypID;
let certid='';
let isbu;
let isbf;
const zc=ref(false);
const wt=ref(false);
const st=ref(false);
const om=ref(false);
const ypqx=ref(false);
const qxsc=ref(false);
const qxba23=ref(false);
const ypckxs=ref(false);
const wlxsba=ref(false);
const dyl=ref(false);
const mz=ref(false);
const ypckzxz=ref(false);
const qxbz=ref(false);
const qxckxs=ref(false);
const gmp=ref(false);
const showcz=ref(false);
const showbg=ref(false);
const showqxgz=ref(false);
const showwh=ref(false);
const certMetadata = ref();
const [registerModaldata, {openModal}] = useModal();
const [registerModaldatawt, {openModal:wtModel}] = useModal();
const [registerModaldatast, {openModal:stModel}] = useModal();
/*
const [registerSelectModal, {openModal: selectmodel}] = useModal();
*/
const tableRefs = {certchildYpscZc, certchildYpscWt, certchildYpscSt,};
const certchildYpscZcTable = reactive({
  loading: false,
  dataSource: <any[]>([]),
  columns: certchildYpscZcColumns
})
const certchildYpscWtTable = reactive({
  loading: false,
  dataSource:  <any[]>([]),
  columns: certchildYpscWtColumns
})
const certchildYpscStTable = reactive({
  loading: false,
  dataSource:  <any[]>([]),
  columns: certchildYpscStColumns
})
const certchildYlqxwtbaZbTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYlqxwtbaZbColumns
})
const certchildYlqxscbaZbTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYlqxscbaZbColumns
})
const certchildYpckxkzTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYpckxkzColumns
})
const certchirdYlqxlcsybaTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchirdYlqxlcsybaColumns
})
const certchildYlqxcpckxsTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYlqxcpckxsColumns
})
const certchildMzyphjsypddscTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildMzyphjsypddscColumns
})
const certchildYpckxszmTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYpckxszmColumns
})
const certchildYpscGmpTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYpscGmpColumns
})
const certchildCkomylyTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildCkomylyColumns
})
const certchildYlqxwlxsbaTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildYlqxwlxsbaColumns
})
const certchildDylylqxscbapzTable = reactive({
  loading: false,
  dataSource: [],
  columns:certchildDylylqxscbapzColumns
})

const guijiashuju = reactive({
  loading: false,
  dataSource: [],
  columns:guojiashuju
})
/*const data = defineProps({
  certmetadatalist: {
    type: Array,  // 数据类型
    default: "未传值"  // 未传值时的默认值
  },
})*/

//表单配置
const [registerForm, {setProps, resetFields, setFieldsValue,resetSchema,appendSchemaByField,removeSchemaByFiled}] = useForm({
  labelWidth: 180,
  schemas: formSchema,
  showActionButtonGroup: false,
  baseColProps: {span: 24},
  labelWrap: true
});
const [registerFormcz, {setProps:setPropscz,  validate:validatecz}] = useForm({
  labelWidth: 120,
  schemas: formSchemacz,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
const [registerFormbg, {setProps:setPropsbg,  validate:validatebg}] = useForm({
  labelWidth: 120,
  schemas: formSchemabg,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
const [registerFormwh, {setProps:setPropswh,  validate:validatewh}] = useForm({
  labelWidth: 120,
  schemas: formSchemawh,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
const [registerFormqxgz, {setProps:setPropsqxgz,  validate:validateqxgz}] = useForm({
  labelWidth: 120,
  schemas: formSchemawhqxgz,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});
/*const [registerFormshiyan, {setProps:setshiyan,  validate:validateshiyan, setFieldsValue:setshiyanFieldsValue}] = useForm({
  labelWidth: 120,
  schemas: shiyanformSchema,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});*/
/*const [registerFormfzm, {setProps:setfzm,  validate:validatefzm, setFieldsValue:setFieldsValuefzm}] = useForm({
  labelWidth: 120,
  schemas: wzmformSchema,
  showActionButtonGroup: false,
  baseColProps: {span: 24}
});*/
var chushizb="certchildYpscZc";
//表单赋值
const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
  //重置表单
  await reset();

  setModalProps({
    confirmLoading: false,
    showCancelBtn: data?.showFooter,
    showOkBtn: data?.showFooter,
  });
  if(uuid?.wgz)
  {
    console.log(uuid);
    iswgz.value=true;
    wgzflag.value=1;

  }
  isUpdate.value = !!data?.isUpdate;
  iswh.value=!!data?.iswh;
  console.log(iswh.value);
  formDisabled.value = !data?.showFooter;
  console.log(data);
  czType.value =data?.czType;
  czjlInfo.value={zsid:data?.record?.zsid}
  console.log(czType);
  if(czType.value=='注销')
  {
    showcz.value=true;
  }
  if(czType.value=='变更')
  {
    showbg.value=true;
  }
  if(czType.value=='维护')
  {
    showwh.value=true;
    console.log(showwh.value);

  }
  if(czType.value=='取消盖章')
  {
    showqxgz.value=true;
  }
  // 隐藏底部时禁用整个表单
  if(data?.certtypeID||data?.record?.certtypeid) {
    certtypID = data.certtypeID ? data.certtypeID : data.record.certtypeid;
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
  if(data?.isbl)
  {
    isbu=data?.isbl;
  }
  if(data?.isbf)
  {
    isbu=data?.isbf;
  }

  //动态渲染表单removeSchemaByFiled

  let  certmetalist=  await getcertmetelist({'id':certtypID});

  console.log(certmetalist);
  let promise = await findDetail({"certtypeid":certtypID});
  if(certmetalist==null)
  {
    message.warn("未配置元数据或权限！");
  }
  //判断子表展示
  let typevalue = certmetalist[0].typevalue;
  //
  console.log(typevalue);
  let split1=[];
  if(typevalue!=null&&typevalue.indexOf(',')) {
    split1 = typevalue.split(',');
  }
  else if(typevalue!=null)
  {
    split1[0]=typevalue;
  }
  console.log("==================================!!!!=");
  console.log(split1);
  console.log( st.value);
  zc.value=false;
  wt.value=false;
  st.value=false;
  om.value=false;
  ypqx.value=false;
  qxsc.value=false;
  qxba23.value=false;
  ypckxs.value=false;
  wlxsba.value=false;
  dyl.value=false;
  mz.value=false;
  ypckzxz.value=false;
  qxbz.value=false;
  qxckxs.value=false;
  gmp.value=false;
  showcz.value=false;
  showbg.value=false;
  showqxgz.value=false;
  showwh.value=false;
  for(let i=0;i<split1.length;i++)
  {
    if(split1[i]=='st')
    {
      st.value=true;
      console.log(st+"111");
      chushizb='certchildYpscSt';
    }
    if(split1[i]=='zc')
    {
      zc.value=true;
      chushizb='certchildYpscZc';
    }
    if(split1[i]=='wt')
    {
      wt.value=true;
      chushizb='certchildYpscWt';
    }
    if(split1[i]=='om')
    {
      om.value=true;
      chushizb='certchildCkomyly';
    }
    if(split1[i]=='gmp')
    {
      gmp.value=true;
      chushizb='certchildYpscGmp';
    }
    /* if(split1[i]=='ypqx')
     {
       ypqx=true;
       chushizb='';
     }*/
    if(split1[i]=='qxxkz')
    {
      qxsc.value=true;
      chushizb='certchildYlqxscbaZb';
    }
    if(split1[i]=='qxba23')
    {
      qxba23.value=true;
      chushizb='certchildYlqxwtbaZb';
    }
    if(split1[i]=='ypxs')
    {
      ypckxs.value=true;
      chushizb='certchildYpckxszm';
    }
    if(split1[i]=='mz')
    {
      mz.value=true;
      chushizb='certchildMzyphjsypddsc';
    }
    if(split1[i]=='ypck')
    {
      ypckzxz.value=true;
      chushizb='certchildYpckxkz';
    }
    if(split1[i]=='qxba')
    {
      qxbz.value=true;
      chushizb='certchirdYlqxlcsyba';
    }
    if(split1[i]=='qxxs')
    {
      qxckxs.value=true;
      chushizb='certchildYlqxcpckxs';
    }
    if(split1[i]=='wlxsba')
    {
      wlxsba.value=true;
      chushizb='certchildYlqxwlxsba';
    }
    if(split1[i]=='dyl')
    {
      dyl.value=true;
      chushizb='certchildDylylqxscbapz';
    }
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
    if( certmetalist[i].yssx.toLowerCase()=='fj')
    {
      flag=false;
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
      colProps: {span: certmetalist[i].bjys},
      disabled:true,
      dynamicDisabled: flag,
      fileType:'all',
      dynamicRules: ({model, schema}) => {
        if (certmetalist[i].isbt == '1') {

          return [
            {
              required: certmetalist[i].isbt == '1' ? true : false,
              message: '请输入' + certmetalist[i].lm + "!"
            },
          ];
        }
      },
    }
    index++;
    await appendSchemaByField( certdata[i],'');

  }
  console.log(certdata);
  if (unref(isUpdate)) {
    certid=data.record.id;
    console.log(data.record);

    //根据这个id获取zminfo的表的信息
    /*    let zminfodata = await getzminfodata({"id":certid});
        //表单赋值

        console.log(zminfodata);*/
    await setFieldsValue({
      ...data.record,
    });
    /*await  setFieldsValuefzm({
      ...data.record,
    });*/
    console.log(data.record);
    var shiyanlist =await getshiyanlist({id:"c6050bb5a531e702458adc6380d29ea5"});

    const proxy = reactive(shiyanlist.records[0]);
    console.log(proxy);
   /* await  setshiyanFieldsValue({
      ...proxy
    });
*/

    requestSubTableData(certchildYpscZcList, {id: data?.record?.zsid,zt:'3'}, certchildYpscZcTable)
    requestSubTableData(certchildYpscWtList, {id: data?.record?.zsid,zt:'3'}, certchildYpscWtTable)
    requestSubTableData(certchildYpscStList, {id: data?.record?.zsid,zt:'3'}, certchildYpscStTable)
    requestSubTableData(certchildYlqxwtbaZbList, {id:data?.record?.zsid,zt:'3'}, certchildYlqxwtbaZbTable)
    requestSubTableData(certchildYlqxscbaZbList, {id:data?.record?.zsid,zt:'3'}, certchildYlqxscbaZbTable)
    requestSubTableData(certchildYpckxkzList, {id:data?.record?.zsid,zt:'3'}, certchildYpckxkzTable)
    requestSubTableData(certchirdYlqxlcsybaList, {id:data?.record?.zsid,zt:'3'}, certchirdYlqxlcsybaTable)
    requestSubTableData(certchildYlqxcpckxsList, {id:data?.record?.zsid,zt:'3'}, certchildYlqxcpckxsTable)
    requestSubTableData(certchildMzyphjsypddscList, {id:data?.record?.zsid,zt:'3'}, certchildMzyphjsypddscTable)
    requestSubTableData(certchildYpckxszmList, {id:data?.record?.zsid,zt:'3'}, certchildYpckxszmTable)
    requestSubTableData(certchildYpscGmpList, {id:data?.record?.zsid,zt:'3'}, certchildYpscGmpTable)
    requestSubTableData(certchildCkomylyList, {id:data?.record?.zsid,zt:'3'}, certchildCkomylyTable)
    requestSubTableData(certchildYlqxwlxsbaList, {id:data?.record?.zsid,zt:'3'}, certchildYlqxwlxsbaTable)
    requestSubTableData(certchildDylylqxscbapzList, {id:data?.record?.zsid,zt:'3'}, certchildDylylqxscbapzTable)
  }

  /* setProps({disabled: !data?.showFooter})*/
});
//方法配置
const [handleChangeTabs, handleSubmit, requestSubTableData, formRef] = useJvxeMethod(requestAddOrEdit, classifyIntoFormData, tableRefs, activeKey, refKeys);

//设置标题
const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));

async function reset() {
  await resetFields();
  activeKey.value = chushizb;
  certchildYpscZcTable.dataSource = [];
  certchildYpscWtTable.dataSource = [];
  certchildYpscStTable.dataSource = [];
  certchildYlqxwtbaZbTable.dataSource = [];
  certchildYlqxscbaZbTable.dataSource = [];
  certchildYpckxkzTable.dataSource = [];
  certchirdYlqxlcsybaTable.dataSource = [];
  certchildYlqxcpckxsTable.dataSource = [];
  certchildMzyphjsypddscTable.dataSource = [];
  certchildYpckxszmTable.dataSource = [];
  certchildYpscGmpTable.dataSource = [];
  certchildCkomylyTable.dataSource = [];
  certchildYlqxwlxsbaTable.dataSource = [];
  certchildDylylqxscbapzTable.dataSource = [];
}

function classifyIntoFormData(allValues) {
  let main = Object.assign({}, allValues.formValue)
  return {
    ...main, // 展开
    certchildYpscZcList: allValues?.tablesValue[0]?.tableData,
    certchildYpscWtList: allValues?.tablesValue[1]?.tableData,
    certchildYpscStList: allValues?.tablesValue[2]?.tableData,
    certchildYlqxwtbaZbList: allValues?.tablesValue[3]?.tableData,
    certchildYlqxscbaZbList: allValues?.tablesValue[4]?.tableData,
    certchildYpckxkzList: allValues?.tablesValue[5]?.tableData,
    certchirdYlqxlcsybaList: allValues?.tablesValue[6]?.tableData,
    certchildYlqxcpckxsList: allValues?.tablesValue[7]?.tableData,
    certchildMzyphjsypddscList: allValues?.tablesValue[8]?.tableData,
    certchildYpckxszmList: allValues?.tablesValue[9]?.tableData,
    certchildYpscGmpList: allValues?.tablesValue[10]?.tableData,
    certchildCkomylyList: allValues?.tablesValue[11]?.tableData,
    certchildYlqxwlxsbaList: allValues?.tablesValue[12]?.tableData,
    certchildDylylqxscbapzList: allValues?.tablesValue[13]?.tableData,
  }
}
function handleAddzc() {
  openModal(true, {
    isUpdate: false,
    showFooter: true,
  });
}

function handleEditzc(record: Recordable) {
  openModal(true, {
    record,
    isUpdate: true,
    showFooter: true,
  });
}
function handleAddst() {
  stModel(true, {
    isUpdate: false,
    showFooter: true,
  });
}
function handleEditst(record: Recordable) {
  stModel(true, {
    record,
    isUpdate: true,
    showFooter: true,
  });
}
function handleAddwt() {
  wtModel(true, {
    isUpdate: false,
    showFooter: true,
  });
}
function handleEditwt(record: Recordable) {
  wtModel(true, {
    record,
    isUpdate: true,
    showFooter: true,
  });
}
function handleSuccesszc(data,rowindex)
{
  randomPagezc(data,rowindex,0,false);
}
function handleSuccessst(data,rowindex)
{
  randomPagest(data,rowindex,0,false);
}
function handleSuccesswt(data,rowindex)
{
  randomPagewt(data,rowindex,0,false);
}
function randomPagezc(valuess, current, pageSize, isLoading = false) {

  certchildYpscZcTable.loading=true;
  const certMetadatavalues: any[] = certchildYpscZc.value!.getTableData();
  console.log(certMetadatavalues);

  if(current||current=='0')
  {
    certMetadatavalues[current]=valuess;
  }
  else {
    certMetadatavalues.push(valuess);
  }
  let values: any[] = certMetadatavalues;
  certchildYpscZcTable.dataSource = values;
  certchildYpscZcTable.loading=false;
}
function randomPagewt(valuess, current, pageSize, isLoading = false) {
  certchildYpscWtTable.loading=true;
  const certMetadatavalues: any[] = certchildYpscWt.value!.getTableData();
  console.log(certMetadatavalues);
  if(current||current=='0')
  {
    certMetadatavalues[current]=valuess;
  }
  else {
    certMetadatavalues.push(valuess);
  }
  let values: any[] = certMetadatavalues;
  certchildYpscWtTable.dataSource = values;
  certchildYpscWtTable.loading=false;
}
function randomPagest(valuess, current, pageSize, isLoading = false) {
  certchildYpscStTable.loading=true;
  const certMetadatavalues: any[] = certchildYpscSt.value!.getTableData();
  console.log(certMetadatavalues);
  if(current||current=='0')
  {
    certMetadatavalues[current]=valuess;
  }
  else {
    certMetadatavalues.push(valuess);
  }
  let values: any[] = certMetadatavalues;
  certchildYpscStTable.dataSource = values;
  certchildYpscStTable.loading=false;
}

//表单提交事件
async function requestAddOrEdit(values) {
  try {
    setModalProps({confirmLoading: true});
    if(czType.value=='注销')
    {
      let promise =await validatecz();
      console.log(promise);
      values.certczr=promise.certczr;
      values.logoutcause=promise.logoutcause;
    }
    if(czType.value=='变更')
    {
      let promise =await validatebg();

      values.bgr=promise.bgr;
      values.bgyy=promise.bgyy;
    }
    if(czType.value=='维护')
    {
      let promise =await validatewh();
      values.whr=promise.whr;
      values.whyy=promise.whyy;

    }
    if(czType.value=='取消盖章')
    {
      let promise =await validateqxgz();
      values.whr=promise.whr;
      values.whyy=promise.whyy;

    }
    values.certtypeid=certtypID;
    values.id=certid;
    values.zt=uuid.zt;
    values.yxzt='10';
    if(isbu)
    {
      values.isbl=isbu;
    }
    if(isbf)
    {
      values.isbf=isbf;
    }
    console.log(czType.value);
    //提交表单
    if(czType.value&&czType.value!=""&&czType.value!='维护'&&czType.value!='查看'){
      console.log(czType.value)
      await caoZuo(values,czType.value);
    }else if(czType.value=='查看'){
      await updataData(values);
    }
    else {
      await saveOrUpdate(values, isUpdate.value);

    }
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
:deep(.ant-input-number) {
  width: 100%
}

:deep(.ant-calendar-picker) {
  width: 100%
}
:deep(.jeecg-basic-table .ant-table-wrapper .ant-table-title){
  min-height: 0;
}
</style>
