<template>
  <div>
    {{props}}
  </div>
</template>

<script lang="ts" setup>
import {  computed,watch} from 'vue';

const emit = defineEmits(['success']);
const keyid = computed(() => props.data?.key)
const props = defineProps({
  data: { require: true, type: Object },
})
watch(() => props.data, () => reload())

function reload(){
  console.log(props.data)
  console.log(keyid)
}
</script>

<style scoped></style>