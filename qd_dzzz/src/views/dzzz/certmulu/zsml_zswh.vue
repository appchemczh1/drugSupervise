<template>
    <a-row style="padding: 5px;">
        <a-col :xl="5" :lg="8" :md="10">
            <a-card :bordered="false" style="height:100%;" :bodyStyle="{ padding: '10px 0' }">
                <zslxTree ref="leftTree" :lx="wh" @select="onTreeSelect" />
            </a-card>
        </a-col>
        <a-col :xl="19" :lg="15" :md="14">
            <a-card :bordered="false" style="height: 100%;" :bodyStyle="{ padding: '0 5px' }">
                <zsInfoList :data="zsInfo" @success="onSuccess" />
            </a-card>
        </a-col>
    </a-row>
</template>
  
<script lang="ts" setup>
import { ref, provide,  } from 'vue';
import zslxTree from './zslxTreezswh.vue';
import zsInfoList from '../certinfo/CertInfoList_zswh.vue';
//import zsInfoList from './zsInfoList.vue';
import { useDesign } from '/@/hooks/web/useDesign';
const { prefixCls } = useDesign('depart-manage')
provide('prefixCls', prefixCls)
const wh="wh";
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
