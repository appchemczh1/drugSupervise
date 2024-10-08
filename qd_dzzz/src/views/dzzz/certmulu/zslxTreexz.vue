<template>
  <div class="bg-white m-1 overflow-hidden">
    <a-spin :spinning="loading">
      <!--组织机构树-->
      <BasicTree ref="treeRef" v-if="!treeReloading" title="证书类型" toolbar :checkStrictly="true"
        :clickRowToExpand="false" :treeData="treeData" :selectedKeys="selectedKeys" :expandedKeys="expandedKeys"
        :autoExpandParent="autoExpandParent" @select="onSelect" @expand="onExpand">
        <template #title="{ title, qty }">
          <span style="font-size: 12px;" :title="title">{{ title }}
            <label v-if="qty && 0 <qty" style="color: red;">({{ qty }})</label>
          </span>
        </template>
      </BasicTree>
    </a-spin>
  </div>
</template>
<script lang="ts" setup>
import {nextTick, ref, unref, inject, defineProps} from 'vue';
import { BasicTree, TreeActionType } from '/@/components/Tree';
import { useRoute } from 'vue-router';
import {defHttp} from '/@/utils/http/axios';
const fatherdata=defineProps({
  zt:{
    type:String,  // 数据类型
    default:"未传值"  // 未传值时的默认值
  }
  ,
  lx:{
    type:String,  // 数据类型
    default:"0"  // 未传值时的默认值
  },
  // 是否显示职业药师（0：显示，1：不显示）
  showZyys: {
    type: String,
    default: "0",
  },
})
const prefixCls = inject('prefixCls');
const emit = defineEmits(['select'])
const params=ref({})
const route = useRoute();

let loading = ref<boolean>(false)
const treeRef = ref<Nullable<TreeActionType>>(null);
// 树列表数据
let treeData = ref<any[]>([])
// 当前展开的项
let expandedKeys = ref<any[]>([])
// 当前选中的项
let selectedKeys = ref<any[]>([])
// 是否自动展开父级
let autoExpandParent = ref<boolean>(true)
// 树组件重新加载
let treeReloading = ref<boolean>(false)


// 加载信息
function loadDepartTreeData() {

  treeData.value = [];
  //先加载出来，在统计数量
  defHttp.get({url:"/dzzz/certmulu/queryTree?status=1&zt="+fatherdata.zt+"&showZyys="+fatherdata.showZyys}).then(res=>{
    if (Array.isArray(res)) {
      treeData.value = res;
      console.log(res);
      autoExpandParentNode();

    }
  }).finally();

    defHttp.get({url:"/dzzz/certmulu/queryTree?zt="+fatherdata.zt+"&status=xz&showZyys="+fatherdata.showZyys}).then(res=>{
    if (Array.isArray(res)) {

      treeData.value = res;
      autoExpandParentNode();
    }
  }).finally()

 
}

loadDepartTreeData()

// 自动展开父节点，只展开一级
function autoExpandParentNode() {
  let keys: Array<any> = [], datas = [];
  treeData.value.forEach((item) => {
    if (1 > keys.length && item.children && item.children.length > 0) {
      keys.push(item.key);
      datas.push(item);
    }
  })
  if (keys.length > 0) {
    reloadTree()
    expandedKeys.value = keys
    unref(treeRef)?.setSelectedKeys([keys[0]]);
    setSelectedKey(keys[0], datas[0]);
  }
}

// 重新加载树组件，防止无法默认展开数据
async function reloadTree() {
  await nextTick()
  treeReloading.value = true
  await nextTick()
  treeReloading.value = false
}

/**
 * 设置当前选中的行
 */
function setSelectedKey(key: string, data?: object) {
  selectedKeys.value = [key]
  if (data) {
    emit('select', data)
  }
}

// 树选择事件
function onSelect(selKeys, event) {
  if (selKeys.length > 0 && selectedKeys.value[0] !== selKeys[0]) {
    event.selectedNodes[0].props=event.selectedNodes[0]
    setSelectedKey(selKeys[0], event.selectedNodes[0].props)
  } else {
    // 这样可以防止用户取消选择
    setSelectedKey(selectedKeys.value[0])
  }
}

// 树展开事件
function onExpand(keys) {
  expandedKeys.value = keys
  autoExpandParent.value = false
}

defineExpose({
  loadDepartTreeData,
})


</script>
