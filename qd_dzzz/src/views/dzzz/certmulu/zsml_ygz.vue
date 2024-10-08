<template>
  <a-row style="padding: 5px">
    <a-col :xl="5" :lg="6" :md="10">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '10px 0' }">
        <zslxTree ref="leftTree" :zt="zt" @select="onTreeSelect" />
      </a-card>
    </a-col>

    <a-col :xl="19" :lg="18" :md="14">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '0 5px' }">
        <zsInfoList :zt="zt" :data="zsInfo" @success="onSuccess" />
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { ref, provide } from 'vue';
  import zslxTree from './zslxTree.vue';
  import zsInfoList from '../certinfo/CertInfoList_ygz.vue';
  //import zsInfoList from './zsInfoList.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  const { prefixCls } = useDesign('depart-manage');
  provide('prefixCls', prefixCls);

  const zt = '4';
  const zsInfo = ref({});
  const leftTree = ref<any>(null);

  function onTreeSelect(data) {
    zsInfo.value = data;
  }
  function onSuccess() {
    leftTree.value.loadDepartTreeData();
  }
</script>

<style lang="less"></style>
