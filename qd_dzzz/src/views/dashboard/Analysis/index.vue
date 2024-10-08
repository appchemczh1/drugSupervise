<template>
  <!--  <IndexUser v-if="userInfo === 'admin'"></IndexUser>-->
  <!--  <certificateQuery v-if="userInfo === 'admin'"></certificateQuery>-->
  <div v-if="userInfo === 'admin'" style="height: 100%">
    <iframe v-if="isComponent" id="certificateQueryIframe" :src="srcurl" width="100%" height="100%"></iframe>
<!--    <certWarn v-else-if="isWarn"></certWarn>-->
<!--    <zsml_wgz v-else-if="isWgz" :received-data="receivedData"></zsml_wgz>-->

  </div>

  <GlUser v-else></GlUser>
  <!-- <div style="width: 100%; text-align: right; margin-top: 20px">
    请选择首页样式：
    <a-radio-group v-model:value="userInfo">
      <a-radio :value="0">默认用户</a-radio>
      <a-radio :value="1">管理用户</a-radio>
    </a-radio-group>
  </div> -->
</template>
<script lang="ts" setup>
  import IndexUser from './homePage/IndexUser.vue';
  import certificateQuery from './homePage/certificateQuery.vue';
  import GlUser from './homePage/GlUser.vue';
  import zsml_wgz from '@/views/dzzz/certmulu/zsml_wgz.vue';
  import certWarn from '@/views/dzzz/certWarning/yxq/CertWarningList.vue';
  import { useUserStore, useUserStoreWithOut } from '@/store/modules/user';
  import { onMounted, ref, provide } from 'vue';
  import { getToken, getTenantId } from '/@/utils/auth';
  import { useGo } from '/@/hooks/web/usePage';
  import signMd5Utils from '/@/utils/encryption/signMd5Utils';
  let parma = {};
  let tenantId: string | number = getTenantId();
  const userInfo = useUserStore().getUserInfo.username;
  const receivedData = ref(null);

  if (!tenantId) {
    tenantId = 0;
  }

  // update-begin--author:sunjianlei---date:220230428---for：【QQYUN-5279】修复分享的应用租户和当前登录租户不一致时，提示404的问题
  const userStore = useUserStoreWithOut();
  // 判断是否有临时租户id
  if (userStore.hasShareTenantId && userStore.shareTenantId !== 0) {
    // 临时租户id存在，使用临时租户id
    tenantId = userStore.shareTenantId!;
  }
  const TIMESTAMP = signMd5Utils.getTimestamp();
  const Sign = signMd5Utils.getSign('http://localhost:3100/hbdzzz/dzzz.homepage/adminpage/stampCase', parma);

  //获取token
  const token = getToken();
  //路由跳转
  const go = useGo();

  const isComponent = ref(true);
  const isWgz = ref(false);
  const isWarn = ref(false);

  const srcurl = ref('/static/html/pages/certificateQuery/certificateQuery.html');
  //将token传给嵌套页面
  onMounted(() => {
    const iframe = document.getElementById('certificateQueryIframe');
    iframe.onload = () => {
      const message = {
        token,
        tenantId,
        TIMESTAMP,
        Sign,
      };
      iframe.contentWindow.postMessage(message, '*');
    };

    //给未盖章页面传数据
    window.addEventListener('message', (event) => {
      const data = event.data;
      /*if (data.isWgz) {
        debugger;
        isComponent.value = false;
        isWarn.value = false;
        isWgz.value = true;
        receivedData.value = data.name;
        // srcurl.value = '/dzzz/certmulu/zsml_wgz.vue';
      } else if (data.isWarn) {
        isComponent.value = false;
        isWgz.value = false;
        isWarn.value = true;
      }*/
      if (data.iframeUrl && data.iframeUrl != null && data.iframeUrl != '') {
        if (data.isWgz && data.name != '') {
          go(data.iframeUrl + `?name=${data.name}`);
        } else {
          go(data.iframeUrl);
        }
      }
    });
  });
</script>
