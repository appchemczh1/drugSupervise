<template>
  <div class="h-full">
    <iframe id="certificateQueryIframe" :src="frameUrl" width="100%" height="100%"></iframe>
  </div>
</template>
<script lang="ts" setup>
  import { ref, onMounted } from 'vue';
  import { useUserStore, useUserStoreWithOut } from '@/store/modules/user';
  import { getToken, getTenantId } from '/@/utils/auth';
  import { useGo } from '/@/hooks/web/usePage';
  import signMd5Utils from '/@/utils/encryption/signMd5Utils';

  const frameUrl = ref('/static/html/pages/certificateQuery/certificateQuery.html');
  const userStore = useUserStoreWithOut();

  let tenantId: string | number = getTenantId() || 0;
  let parma = {};
  if (userStore.hasShareTenantId && userStore.shareTenantId !== 0) {
    tenantId = userStore.shareTenantId!;
  }
  const token = getToken();
  const go = useGo();
  const TIMESTAMP = signMd5Utils.getTimestamp();
  const Sign = signMd5Utils.getSign('http://192.168.0.104:81/hbdzzz/dzzz.homepage/adminpage/stampCase', parma);
  //将token传给嵌套页面
  onMounted(() => {
    const iframe = document.getElementById('certificateQueryIframe') || {onload: null};
    iframe.onload = () => {
      const message = {
        token,
        tenantId,
        TIMESTAMP,
        Sign,
      };
      iframe.contentWindow?.postMessage(message, '*');
    };

    //给未盖章页面传数据
    window.addEventListener('message', (event) => {
      const data = event.data;
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