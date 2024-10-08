<template>
  <a-row style="padding: 5px">
    <a-col :xl="'5'" :lg="5" :md="10" >
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '10px 0' }">
        <zslxTree ref="leftTree" :zt="zt" @tree-data-loaded="handleTreeDataLoaded" :selName="selName" @select="onTreeSelect" />
      </a-card>
    </a-col>
    <a-col :xl="'19'" :lg="19" :md="14" >
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '0 5px' }">
        <zsInfoList :data="zsInfo" :zt="zt" :is-reload="false" @success="onSuccess" />
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { ref, provide } from "vue";
  import { useRoute } from 'vue-router';
  import zslxTree from './zslxTree.vue';
  import zsInfoList from '../certinfo/CertInfoList_wgz.vue';
  //import zsInfoList from './zsInfoList.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import { defHttp } from '@/utils/http/axios';
  const { prefixCls } = useDesign('depart-manage');
  provide('prefixCls', prefixCls);
  const zt = '3';
  const zsInfo = ref({});
  const zsInfo2 = ref({});
  const leftTree = ref<any>(null);
  const route = useRoute();
  const selName = ref(route.query.name);//获取首页路由传参

function onTreeSelect(data) {
    // debugger;
    zsInfo.value = data;
}
function onSuccess() {
    leftTree.value.loadDepartTreeData();
}
  // ���մӸ�������ݹ���������
  const props = defineProps({
    receivedData: Object,
  });

  function handleTreeDataLoaded() {
    // �� zslxTree �ķ���ִ����ɺ�ֵ�� zsInfoList
    updateZsInfoList();
  }
  function updateZsInfoList() {
    // �����д���� zsInfoList ���߼�
    zsInfo.value = zsInfo2.value;
  }

  /*onMounted(() => {
    /!*if (props.receivedData) {
      let parma = { name: props.receivedData };
      defHttp.get({ url: '/dzzz.homepage/adminpage/getinfo', params: parma }).then((res) => {
        if (res != null) {
          // debugger;
          zsInfo2.value = res.data;
          // onTreeSelect(res.data);
        }
      });
      // debugger;
      console.log('Received data from parent:', props.receivedData);
      // ������յ�������
    }*!/
    //debugger;
    if (route.query.name && route.query.name != null && route.query.name != '') {
      let parma = { name: route.query.name };
      defHttp.get({ url: '/dzzz.homepage/adminpage/getinfo', params: parma }).then((res) => {
        if (res != null) {
          debugger;
          //zsInfo2.value = res.data;
          //onTreeSelect(res.data);
          selKey.value = res.data;
        }
      });
    }
  });*/
</script>

<style lang="less"></style>
