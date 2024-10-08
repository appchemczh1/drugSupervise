<template>
  <!--  <IndexUser v-if="userInfo === 'admin'"></IndexUser>-->
  <!--  <certificateQuery v-if="userInfo === 'admin'"></certificateQuery>-->
  <div style="height: 100%">
    <iframe id="indexIframe" :src="srcurl" width="100%" height="100%"></iframe>
  </div>
  <GsptModal @register="registerModal" ></GsptModal>
</template>
<script lang="ts" setup>
  import { useUserStoreWithOut } from '@/store/modules/user';
  import { onMounted, ref } from 'vue';
  import { getToken, getTenantId } from '/@/utils/auth';
  import signMd5Utils from '/@/utils/encryption/signMd5Utils';
  import GsptModal from './components/GsptModal.vue';
  import { useModal } from '/@/components/Modal';
  let parma = {};
  let tenantId: string | number = getTenantId();
  // const userInfo = useUserStore().getUserInfo.username;
  // const receivedData = ref(null);

  if (!tenantId) {
    tenantId = 0;
  }

  //注册model
  const [registerModal, { openModal }] = useModal();
  // update-begin--author:sunjianlei---date:220230428---for：【QQYUN-5279】修复分享的应用租户和当前登录租户不一致时，提示404的问题
  const userStore = useUserStoreWithOut();
  // 判断是否有临时租户id
  if (userStore.hasShareTenantId && userStore.shareTenantId !== 0) {
    // 临时租户id存在，使用临时租户id
    tenantId = userStore.shareTenantId!;
  }
  const TIMESTAMP = signMd5Utils.getTimestamp();
  var baseUrl = window.location.protocol + '//' + window.location.hostname + (window.location.port ? ':' + window.location.port : '');
  let fullUrl = baseUrl + '/hbdzzz';
  const Sign = signMd5Utils.getSign(fullUrl, parma);

  //获取token
  const token = getToken();

  const srcurl = ref('/static/html/pages/index/index.html');
  //将token传给嵌套页面
  onMounted(() => {
    const iframe = document.getElementById('indexIframe');
    iframe.onload = () => {
      const message = {
        token,
        tenantId,
        TIMESTAMP,
        Sign,
      };
      iframe.contentWindow.postMessage(message, '*');
    };
    window.addEventListener('message', (event) => {
      const record = event.data;
      openModal(true, {
        record,
        isUpdate: true,
        showFooter: false,
      });
    });
  });
</script>
