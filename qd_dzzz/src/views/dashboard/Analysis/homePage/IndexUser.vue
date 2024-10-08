<template>
  <div class="background-img">
    <!-- <div style="font-size: 42px; padding-left: 14%;padding-top: 17%;">
      <h1 style="font-weight: bold; color:rgb(0, 153, 255); ">欢 迎 进 入</h1>
      <h1 style="font-weight: bold; color:rgb(0, 153, 255); ">电 子 证 书 管 理 系 统</h1>
      <h1 style="font-size: 28px; color:rgb(102, 153, 153) ;padding-top: 10px;">开启您的使用之旅吧!</h1>
    </div> -->
  </div>
</template>
<script lang="ts" setup>
  import { ref } from 'vue';
  const loading = ref(true);

  setTimeout(() => {
    loading.value = false;
  }, 500);
</script>
<style>
.background-img {
  background-image: url("/src/assets/images/bj.png");
  background-size: cover;
  background-position: top center;
  background-repeat: no-repeat;
  width: 100%;
  height: 100%;
}
</style>
