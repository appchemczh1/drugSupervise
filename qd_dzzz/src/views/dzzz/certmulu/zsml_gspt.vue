<template>
  <a-row style="padding: 5px">
    <a-col :md="24">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '10px 0' }">
        <zslxTree ref="leftTree" :zt="4" @select="onTreeSelect" />
      </a-card>
    </a-col>

    <a>
      说明：1、点击证书编号可查询证书详细信息；2、点击正本、副本等可查看电子证书；3、扫描电子证书中的图形二维码可查询证书详细信息。4、如遇网页打印无法设置纸张大小等情况，请下载安装OFD阅读器，打开下载到本地的OFD格式证书，进行打印。
      (OFD阅读器下载) 5、技术问题可联系027-87110180或QQ咨询群952102219。</a
    >

    <a-col :md="24">
      <a-card :bordered="false" style="height: 100%" :body-style="{ padding: '0 5px' }">
        <zsInfoList :zt="zt" :data="zsInfo" @success="onSuccess" />
      </a-card>
    </a-col>
  </a-row>
</template>

<script lang="ts" setup>
  import { ref, provide } from 'vue';
  import zslxTree from './zslxTree_gspt.vue';
  import zsInfoList from '../certinfo/CertInfoList_gspt.vue';
  //import zsInfoList from './zsInfoList.vue';
  import { useDesign } from '/@/hooks/web/useDesign';
  import AButton from '@/components/Button/src/BasicButton.vue';
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
