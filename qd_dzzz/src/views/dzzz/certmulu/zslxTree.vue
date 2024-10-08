<template>
  <div class="bg-white m-1 overflow-hidden">
    <a-spin :spinning="loading">
      <!--组织机构树-->
      <BasicTree
        v-if="!treeReloading"
        ref="treeRef"
        title="证书类型"
        toolbar
        :check-strictly="true"
        :click-row-to-expand="false"
        :tree-data="treeData"
        :selected-keys="selectedKeys"
        :expanded-keys="expandedKeys"
        :auto-expand-parent="autoExpandParent"
        @select="onSelect"
        @expand="onExpand"
      >
        <template #title="{ title, qty, label }">
          <span style="font-size: 12px;" :title="label">{{ title }}
            <label v-if="qty && 0 <qty" style="color: red;">({{ qty }})</label>
          </span>
<!--          <span v-if="qty && 0 < qty" style="color: red"></span>-->
        </template>
      </BasicTree>
    </a-spin>
  </div>
</template>
<script lang="ts" setup>
  import { nextTick, ref, unref, inject, defineProps } from 'vue';
  import { BasicTree, TreeActionType } from '/@/components/Tree';
  import { useRoute } from 'vue-router';
  import { defHttp } from '/@/utils/http/axios';
  const fatherdata = defineProps({
    zt: {
      type: String, // 数据类型
      default: '未传值', // 未传值时的默认值
    },
    lx: {
      type: String, // 数据类型
      default: '0', // 未传值时的默认值
    },
    selName: { // 传参选中的树节点名
      type: String,
      default: '',
    },
  });
  const prefixCls = inject('prefixCls');
  const emit = defineEmits(['select']);
  const params = ref({});
  const route = useRoute();

  let loading = ref<boolean>(false);
  const treeRef = ref<Nullable<TreeActionType>>(null);
  // 树列表数据
  let treeData = ref<any[]>([]);
  // 当前展开的项
  let expandedKeys = ref<any[]>([]);
  // 当前选中的项
  let selectedKeys = ref<any[]>([]);
  // 是否自动展开父级
  let autoExpandParent = ref<boolean>(true);
  // 树组件重新加载
  let treeReloading = ref<boolean>(false);

  //默认选中的key
  const selTreeInfo = ref({});


  function loadSelDepartTreeData(){
    if(fatherdata.selName && fatherdata.selName != null && fatherdata.selName != '') {
      let parma = { name: fatherdata.selName }; //根据证书类型名获取信息
      defHttp.get({ url: '/dzzz.homepage/adminpage/getinfo', params: parma }).then((res) => {
        if (res != null) {
          selTreeInfo.value = res.data;
          loadDepartTreeData();
        }
      });
    } else {
      loadDepartTreeData();
    }
  }
  // 加载信息
  function loadDepartTreeData() {
    treeData.value = [];
    // debugger
    //先加载出来，在统计数量
    defHttp
      .get({ url: '/dzzz/certmulu/queryTree?status=1&zt=' + fatherdata.zt })
      .then((res) => {
        // debugger
        if (Array.isArray(res)) {
          treeTitle(res);
          treeData.value = res;
          console.log(res);
          autoExpandParentNode();
        }
      })
      .finally();

    defHttp
      .get({ url: '/dzzz/certmulu/queryTree?zt=' + fatherdata.zt })
      .then((res) => {
        // debugger
        if (Array.isArray(res)) {
          treeTitle(res);
          treeData.value = res;
          autoExpandParentNode();
        }
        //emit('tree-data-loaded');
      })
      .finally();


  }

  /**
   * 封装label参数用于显示tree tag
   * @param res
   */
  function treeTitle(res){
    res.forEach(val => {
      if(val.qty && val.qty > 0){
        val.label = val.title + '(' + val.qty + ')';
      } else {
        val.label = val.title;
      }
      if(val.children && val.children.length > 0) {
        val.children.forEach(valChild => {
          if(valChild.qty && valChild.qty > 0){
            valChild.label = valChild.title + '(' + valChild.qty + ')';
          } else {
            valChild.label = valChild.title;
          }
        });
      }
    });
  }

  loadSelDepartTreeData();

  //若组件有传入的选中节点则展开父节点和选中节点 若没有 自动展开父节点，只展开一级
  function autoExpandParentNode() {
    if (selTreeInfo.value && selTreeInfo.value && selTreeInfo.value.key != null && selTreeInfo.value.key != '') {
      const selKeys = selTreeInfo.value.key.split('#');
      if (selKeys[0]) {
        expandedKeys.value = [selKeys[0]];
        unref(treeRef)?.setSelectedKeys([selTreeInfo.value.key]);
        setSelectedKey(selTreeInfo.value.key, selTreeInfo.value);
      }
    } else {
      let keys: Array<any> = [],
        datas = [];
      treeData.value.forEach((item) => {
        if (1 > keys.length && item.children && item.children.length > 0) {
          keys.push(item.key);
          datas.push(item);
        }
      });
      if (keys.length > 0) {
        reloadTree();
        expandedKeys.value = keys;
        unref(treeRef)?.setSelectedKeys([keys[0]]);
        setSelectedKey(keys[0], datas[0]);
      }
    }
  }

  // 重新加载树组件，防止无法默认展开数据
  async function reloadTree() {
    await nextTick();
    treeReloading.value = true;
    await nextTick();
    treeReloading.value = false;
  }

  /**
   * 设置当前选中的行
   */
  function setSelectedKey(key: string, data?: object) {
    selectedKeys.value = [key];
    if (data) {
      emit('select', data);
    }
  }

  // 树选择事件
  function onSelect(selKeys, event) {
    if (selKeys.length > 0 && selectedKeys.value[0] !== selKeys[0]) {
      event.selectedNodes[0].props = event.selectedNodes[0];
      setSelectedKey(selKeys[0], event.selectedNodes[0].props);
    } else {
      // 这样可以防止用户取消选择
      setSelectedKey(selectedKeys.value[0]);
    }
  }

  // 树展开事件
  function onExpand(keys) {
    expandedKeys.value = keys;
    autoExpandParent.value = false;
  }


  defineExpose({
    loadDepartTreeData,
  });
</script>
