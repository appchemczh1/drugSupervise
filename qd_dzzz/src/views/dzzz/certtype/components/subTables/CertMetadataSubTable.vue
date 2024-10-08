<template>
  <div>
      <!--引用表格-->
     <BasicTable bordered size="middle" :loading="loading" rowKey="id" :canResize="false" :columns="certMetadataColumns" :dataSource="dataSource" :pagination="false">

        <!--字段回显插槽-->
        <template v-slot:bodyCell="{ column, record, index, text }">
        </template>
      </BasicTable>
    </div>
</template>

<script lang="ts" setup>
  import {ref,watchEffect} from 'vue';
  import {BasicTable} from '/@/components/Table';
  import {certMetadataColumns} from '../CertMetadataVersion.data';
  import {certMetadataList} from '../CertMetadataVersion.api';
  import { downloadFile } from '/@/utils/common/renderUtils';

  const props = defineProps({
    id: {
       type: String,
       default: '',
     },
  })

  const loading = ref(false);
  const dataSource = ref([]);

  watchEffect(() => {
      props.id && loadData(props.id);
   });

   function loadData(id) {
         dataSource.value = []
         loading.value = true
          certMetadataList({id}).then((res) => {
           if (res.success) {
              dataSource.value = res.result
           }
         }).finally(() => {
           loading.value = false
         })
    }
</script>
