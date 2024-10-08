<template>
  <a-row style="padding: 5px">
    <a-col :span="6">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '10px 0' }">
        <zslxTree ref="leftTree" :zt="6" @select="onTreeSelect" />
      </a-card>
    </a-col>
    <a-col :span="18">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '0 5px' }">
        <zsInfoList :data="zsInfo" @success="onSuccess" />
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { ref, provide } from 'vue';
  import zslxTree from './zslxTree.vue';
  import zsInfoList from '../certinfo/CertInfoList_zsbu.vue';
  //import zsInfoList from './zsInfoList.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  const { prefixCls } = useDesign('depart-manage');
  provide('prefixCls', prefixCls);

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
