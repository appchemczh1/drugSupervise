<template>
  <div >

    <a-spin :spinning="loading">
      <!--组织机构树-->
      <a-tabs default-active-key="1" centered size="large">
        <a-tab-pane key="1" tab="药品" @tabClick="getyp">

          <a-list  style="margin-block-end:0px" class="no-gutter" :grid="{ column: 4 }" size="small" :data-source="datalist1">
            <template #renderItem="{ item }">
              <a-list-item style="margin-block-end:0px">
                <a-list-item-meta  style="margin-block-end:0px" >
                  <template #description>
                    <a-button type="text" style="margin-block-end:0px"  @click="changeCerinfoList({item})"> {{
                        item.key
                      }}
                    </a-button>
                  </template>
                </a-list-item-meta>
              </a-list-item>
            </template>
          </a-list>

        </a-tab-pane>
        <a-tab-pane key="2" tab="器械">

          <a-list :grid="{ gutter: -1, column: 4 }"  size="small" :data-source="datalist2">
            <template #renderItem="{ item }">
              <a-list-item class="no-gutter1" style="margin-block-end:0px">
                <a-list-item-meta  style="margin-block-end:0px">
                  <template #description>
                    <a-button type="text" class="no-gutter1" style="margin-block-end:0px" @click="changeCerinfoList({item})"> {{
                        item.key
                      }}
                    </a-button>
                  </template>
                </a-list-item-meta>
              </a-list-item>
            </template>
          </a-list>
        </a-tab-pane>
        <a-tab-pane key="3" tab="化妆品">
          <a-list :grid="{ gutter: -1, column: 4 }" size="small" :data-source="datalist3">
            <template #renderItem="{ item }">
              <a-list-item>
                <a-list-item-meta>
                  <template #description>

                    <a-button type="text" @click="changeCerinfoList({item})"> {{
                        item.key
                      }}
                    </a-button>
                  </template>
                </a-list-item-meta>
              </a-list-item>
            </template>
          </a-list>
        </a-tab-pane>
      </a-tabs>
      <!--      <BasicTable ref="treeRef" v-if="!treeReloading" title="证书类型" toolbar showLine :checkStrictly="true"
                       :clickRowToExpand="false" :treeData="treeData" :selectedKeys="selectedKeys" :expandedKeys="expandedKeys"
                       :autoExpandParent="autoExpandParent" @select="onSelect" @expand="onExpand">
                      <template #title="{ title, qty }">

                        <span> {{ title }}</span>
                        <span v-if="qty && 0 < qty" style="color:red;">（{{ qty }}）</span>
                      </template>
            </BasicTable>-->
      <!--      <BasicTree ref="treeRef" v-if="!treeReloading" title="证书类型" toolbar showLine :checkStrictly="true"
                       :clickRowToExpand="false" :treeData="treeData" :selectedKeys="selectedKeys" :expandedKeys="expandedKeys"
                       :autoExpandParent="autoExpandParent" @select="onSelect" @expand="onExpand">
              &lt;!&ndash;        <template #title="{ title, qty }">

                        <span> {{ title }}</span>
                        <span v-if="qty && 0 < qty" style="color:red;">（{{ qty }}）</span>
                      </template>&ndash;&gt;
            </BasicTree>-->
    </a-spin>


  </div>
</template>
<script lang="ts" setup>
import {nextTick, ref, unref, inject, defineProps} from 'vue';
import {BasicTree, TreeActionType} from '/@/components/Tree';
import {useRoute} from 'vue-router';
import {defHttp} from '/@/utils/http/axios';
import BaiduMap from "@/views/demo/charts/map/Baidu.vue";
import BasicForm from "@/components/Form/src/BasicForm.vue";
import BasicTable from "@/components/Table/src/BasicTable.vue";
import CardList from "@/components/CardList/src/CardList.vue";
import AButton from "@/components/Button/src/BasicButton.vue";

const fatherdata = defineProps({
  zt: {
    type: String,  // 数据类型
    default: "未传值"  // 未传值时的默认值
  }

})
const prefixCls = inject('prefixCls');
const emit = defineEmits(['select'])
const params = ref({})
const route = useRoute();

let loading = ref<boolean>(false)
const treeRef = ref<Nullable<TreeActionType>>(null);
// 树列表数据
let treeData = ref<any[]>([])
let box1 = ref<any[]>([]);
// 当前展开的项
let expandedKeys = ref<any[]>([])
// 当前选中的项
let selectedKeys = ref<any[]>([])
// 是否自动展开父级
let autoExpandParent = ref<boolean>(true)
// 树组件重新加载
let treeReloading = ref<boolean>(false)

interface DataItem {
  key: string;
  certtypeid: string;
}

const datalist1: DataItem[] = [
  {
    "key": "药品生产许可证",
    "certtypeid": "76d0e6250ee54a9db032da22c95af5e8"
  },
  {
    "key": "药品经营许可证（零售连锁总部）",
    "certtypeid": "343af983fcf4449e863277f0f5498a0d"
  },
  {
    "key": "药品经营许可证（零售连锁门店）",
    "certtypeid": "d2dd9f71f5f34145af595fd79504e683"
  },
  {
    "key": "药品经营许可证(零售)",
    "certtypeid": "4e7ff714f0cf4f81b46eb16c1155744f"
  },
  {
    "key": "药品经营许可证（批发）",
    "certtypeid": "eb436e84a16b4fbbaec251c1abf1a339"
  },
  {
    "key": "放射性药品生产许可证",
    "certtypeid": "18d8c52f34fc4096b61c53e3ac50e6b9"
  },
  {
    "key": "放射性药品经营许可证",
    "certtypeid": "cf8ffc2aa62646acad30c3f8790441eb"
  },
  {
    "key": "放射性药品使用许可证",
    "certtypeid": "f45a7f934d4245d2a2a595365ebfd175"
  },
  {
    "key": "药品进口准许证",
    "certtypeid": "3ab68be4d6054abc8e1a6a36bef5efa7"
  },
  {
    "key": "药品出口准许证",
    "certtypeid": "3862d91d387d412e95d43a96866df815"
  },
  {
    "key": "麻醉药品、第一类精神药品运输证明",
    "certtypeid": "35676f5e5381406d91ddc16391673698"
  },
  {
    "key": "麻醉药品和精神药品邮寄证明",
    "certtypeid": "325d555ff0954083a7f2e2e9fbbfe220"
  },
  {
    "key": "非麻醉药品精神药品购用证明",
    "certtypeid": "549f0b9123724f3a950917d3931cb84c"
  },
  {
    "key": "麻醉药品和精神药品定点生产批件",
    "certtypeid": "8db3b49ba43f4685a15812c14bbe67c8"
  },
  {
    "key": "第二类精神药品制剂生产企业批准批件",
    "certtypeid": "9007d104b0df4a20a985e2e045ee1d14"
  },
  {
    "key": "药品广告审查准予许可决定书",
    "certtypeid": "0e5ef670ca034ec4b4b414c47a1bae92"
  },
  {
    "key": "药品委托生产批件",
    "certtypeid": "f6dd07df6211441ea0f8ac0dd265ef1a"
  },
  {
    "key": "医疗机构制剂许可证",
    "certtypeid": "2c0fef3cada14372859b7c5a2798edeb"
  },
  {
    "key": "医疗机构制剂调剂使用批件",
    "certtypeid": "fbf7001c20e94ac4afae0fed70ac1608"
  },
  {
    "key": "医疗机构制剂注册批件",
    "certtypeid": "a24c54a49b4b42a2a31bd309c8931fe1"
  },
  {
    "key": "医疗机构制剂再注册批件",
    "certtypeid": "76fb5546ea2442cfb9be79176fa06cf3"
  },
  {
    "key": "医疗机构中药制剂委托配制批件",
    "certtypeid": "d40cb52f6b08449a9ea02dfd2365e8e5"
  },
  {
    "key": "医疗机构制剂临床研究批件",
    "certtypeid": "77bf802fd36b4b98bea4c248e2c868a3"
  },
  {
    "key": "医疗机构制剂注册补充申请批件",
    "certtypeid": "714dc44bf79c43bd9c44a02936533b85"
  },
  {
    "key": "医疗机构应用传统工艺配制中药制剂首次备案",
    "certtypeid": "a27e1ace479c4cef90bce24007cb7046"
  },
  {
    "key": "医疗机构应用传统工艺配制中药制剂变更备案",
    "certtypeid": "a572ea43c0754b518f9c99833e087738"
  },
  {
    "key": "互联网药品信息服务资格证书",
    "certtypeid": "93f116242ece4bc2b670961fdd314a28"
  },
  {
    "key": "药品网络交易第三方平台备案",
    "certtypeid": "2b4c985a30c646e288be427147aad354"
  },
  {
    "key": "药品补充申请批件",
    "certtypeid": "e1ddd5776284459b9fd6f01050d93e00"
  },
  {
    "key": "药品再注册批件",
    "certtypeid": "c10465eb568b40d49bac640cd4ac422a"
  },
  {
    "key": "湖北省药品生产企业有关事项备案表",
    "certtypeid": "f0b952181f04482ea91e82e9e7a5381b"
  },
  {
    "key": "湖北省药品生产企业质量受权人备案表",
    "certtypeid": "6058dd4cf6ad4f8b8c99c83b50af071a"
  },
  {
    "key": "出口欧盟原料药证明文件",
    "certtypeid": "5cd6b409e2aa4b388c450d0a008eb283"
  },
  {
    "key": "药品出口销售证明已在中国批准上市药品",
    "certtypeid": "0cfb0d0d33a641f0aa0a9592a37c2cbe"
  },
  {
    "key": "药品出口销售证明已在中国批准上市药品的未注册规格",
    "certtypeid": "29d3e61e5561488ca2410ed653d0350a"
  },
  {
    "key": "药品出口销售证明未在中国注册药品",
    "certtypeid": "59dd64be4a0e462d9b1e86ef58d6567b"
  },
  {
    "key": "药品GMP符合性检查结果通知书",
    "certtypeid": "10c9cade084946e98eccf8526a07c710"
  },
/*  {
    "key": "企业排查和整改情况表",
    "certtypeid": "1f3ac55eb3cd4fceb0ec0896ded05fcd"
  },*/
  {
    "key": "药品GMP认证证书",
    "certtypeid": "6a75dcb629de4f1288ff9170e123490c"
  },
  {
    "key": "药品GSP认证证书",
    "certtypeid": "182d301f69764fd7ae19cde4c30483aa"
  },
  {
    "key": "医疗机构中药新制剂首次委托配制备案件",
    "certtypeid": "32bb12e60f054823af802e7406f0cb1a"
  }
];
const datalist2: DataItem[] = [
  {
    "key": "第一类医疗器械生产备案",
    "certtypeid": "96ea1381b969417482ca9bf962267bc8"
  },
  {
    "key": "第一类医疗器械生产委托备案",
    "certtypeid": "820ac909eb9241179b56821947f88dac"
  },
  {
    "key": "第一类医疗器械产品备案",
    "certtypeid": "6ba240bd62b5466d847dee380410a3a1"
  },
  {
    "key": "第一类体外诊断试剂备案",
    "certtypeid": "69eae11e12d54aa189a8c2693a461fad"
  },
  {
    "key": "第二类医疗器械注册证",
    "certtypeid": "a7a0ec011cbf499983f1959349e7a79c"
  },
  {
    "key": "第二类体外诊断试剂注册证",
    "certtypeid": "e060f441873e41dba90394267b32a224"
  },
  {
    "key": "第二类医疗器械经营备案",
    "certtypeid": "ba6cb616fe02495a89b80b5f53e6bf29"
  },
  {
    "key": "第二、三类医疗器械生产许可证",
    "certtypeid": "bf79efa1352a43b691aae25cbec58ced"
  },
  {
    "key": "第二三类医疗器械委托生产备案",
    "certtypeid": "3b535afb86c94dd382ab1837a6c6954b"
  },
  {
    "key": "第三类医疗器械经营许可证(批发)",
    "certtypeid": "4957bebb1de340cc90502265a456d303"
  },
  {
    "key": "第三类医疗器械经营许可证(零售)",
    "certtypeid": "5102457a62a04aee8c93ea0873c8a39e"
  },
  {
    "key": "医疗器械网络销售备案",
    "certtypeid": "e6276f6f610f42a99f011da610f66a04"
  },
  {
    "key": "医疗器械注册变更文件",
    "certtypeid": "eb92705474384e428313ec589acd5815"
  },
  {
    "key": "医疗器械注册变更文件(体外诊断试剂)",
    "certtypeid": "00b06ade754a453587e9b2bd50a88c9e"
  },
  {
    "key": "医疗器械广告审查准予许可决定书",
    "certtypeid": "64bda39ac4b64be197de657d87241285"
  },
  {
    "key": "医疗器械第三方平台备案",
    "certtypeid": "866d673c5cca4a8d832b776bec6d8c25"
  },
  {
    "key": "医疗器械产品出口销售证明",
    "certtypeid": "96d35864d41545a5b72cb3ffb866a31e"
  },
  {
    "key": "注册指定检验通知单",
    "certtypeid": "23a6f8cf27c24d55bbe62fabbf1f636d"
  },
  {
    "key": "境内第三类医疗器械注册质量管理体系核查结果通知",
    "certtypeid": "8a1c5eb616284617aa613446b7f3bac5"
  },
  {
    "key": "创新医疗器械特别审查申请表",
    "certtypeid": "28dbfc6e35784c56bef03983f68301eb"
  },
  {
    "key": "医疗器械临床试验备案表",
    "certtypeid": "e12a2bc6944d4b4fb9bd73bf1cf12cd5"
  },
  {
    "key": "定制式医疗器械备案信息表",
    "certtypeid": "d6a5113e5d8d49d3aacb26ab40b94e80"
  }
];
const datalist3: DataItem[] = [
  {
    "key": "化妆品生产许可证",
    "certtypeid": "e857a80febc34556a5f68445221e6aed"
  }
];
/*function  getyp()
{
   let data;
   data.zsdl='yp';
  data.zt='5';
      emit('select', e.item);

}*/
/*function changeCerinfoList(e) {
  console.log(e);
  emit('select', e.item);
}*/
function loadlist() {
  /*defHttp.get({url: "/dzzz/certmulu/queryList?lx=yp"}).then(res => {
    if (Array.isArray(res)) {
      /!*for (let i=0;i<res.length;i++){
        datalist1.push(res[i]);
     }*!/
      datalist1.push(res);
      console.log(res);


    }
  }).finally();
  defHttp.get({url: "/dzzz/certmulu/queryList?lx=ylqx"}).then(res => {
    if (Array.isArray(res)) {
      /!* for (let i=0;i<res.length;i++){
         datalist.push(res[i]);
       }*!/
      datalist2.push(res);
      console.log(res);


    }
  }).finally();
  defHttp.get({url: "/dzzz/certmulu/queryList?lx=hzp"}).then(res => {
    if (Array.isArray(res)) {
      /!*  for (let i=0;i<res.length;i++){
          datalist3.push(res[i]);
        }*!/
      datalist3.push(res);
      console.log(res);


    }
  }).finally()*/
}

loadlist();


// 加载信息
function loadDepartTreeData() {
  treeData.value = [];
  defHttp.get({url: "/dzzz/certmulu/queryTree?status=1&zt=" + fatherdata.zt}).then(res => {
    if (Array.isArray(res)) {
      treeData.value = res;
      console.log(res);
      autoExpandParentNode();

    }
  }).finally()
  /*defHttp.get({url: "/dzzz/certmulu/queryTree?zt=" + fatherdata.zt}).then(res => {
    if (Array.isArray(res)) {
      treeData.value = res;
      autoExpandParentNode();
    }
  }).finally()*/

}

loadDepartTreeData()
function changeCerinfoList(e) {
  console.log(e);
  emit('select', e.item);
}

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
    event.selectedNodes[0].props = event.selectedNodes[0]
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
<style>
.no-gutter .ant-list-item {
  margin-block-end: 0;
}
.no-gutter1 {
  margin-block-end: 0;
}
</style>
