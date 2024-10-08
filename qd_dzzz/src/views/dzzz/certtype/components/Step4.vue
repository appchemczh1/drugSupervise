<template>
  <div class="step4">
    <a-result status="success" title="新增成功">
      <template #extra>
<!--        <a-button type="primary" @click="redo"> 再次新增 </a-button>-->
      </template>
    </a-result>
  </div>
</template>
<script lang="ts">
  import { defineComponent } from 'vue';
  export default defineComponent({
    emits: ['redo'],
    setup(_, { emit }) {
      return {
        redo: () => {
          emit('redo');
        },
      };
    },
  });
</script>
<style lang="less" scoped>
  .step4 {
    width: 600px;
    margin: 0 auto;
  }

</style>
