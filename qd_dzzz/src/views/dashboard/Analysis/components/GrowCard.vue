<template>
  <div class="md:flex" style="background-color: #c2d1f0;">
    <div class="divW  lg:w-1/3">
        <div>
          <span style="font-size: 20px; color: blue; font-weight: bold;">待盖章情况</span>
        </div>
        <div>
           <a-row>
            <div style="margin: 10px; font-size: 15px; background-color: #c2d1f0; width: 45%; padding-left: 15px; border-radius: 10px;">
                <div>待盖章总量</div>
                <div>6</div>
            </div>
            <div style="margin: 10px; font-size: 15px; background-color: #ff6666; width: 45%; padding-left: 15px; border-radius: 10px;">
              <div>盖章超时预警量</div>
              <div>6</div>
            </div>
           </a-row>
        </div>
        <div class="table-container" ref="tableContainer">
          <table>
            <thead>
              <tr>
                <th class="text-left">证书类型</th>
                <th class="text-right">数量</th>
              </tr>
            </thead>
            <tbody >
              <tr v-for="item in data">
                <td class="text-left">{{ item.zslx }}</td>
                <td class="text-right">{{ item.num }}</td>
              </tr>
            </tbody>
          </table>
        </div> 
      </div>
    <div class="divW lg:w-1/3">
      <div class="h-full overflow-auto">
            <ul class="list-decimal pl-2rem m-0">
                <li>您有<span class="text-red-500 px-1">0</span>条风险处置需要处理。</li>
                <li>您有<span class="text-red-500 px-1">0</span>条协同处置需要处理。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>家企业未填写药品生产企业年报。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>即将到期的药品生产许可证。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>个集采药品未达到检查、抽检验及追溯全覆盖。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次集采或特药专项检查未绑定品种。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次检查未上传整改报告。</li>
            </ul>
        </div> 
    </div>
    <div class="divW lg:w-1/3">
      <div class="h-full overflow-auto">
            <ul class="list-decimal pl-2rem m-0">
                <li>您有<span class="text-red-500 px-1">0</span>条风险处置需要处理。</li>
                <li>您有<span class="text-red-500 px-1">0</span>条协同处置需要处理。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>家企业未填写药品生产企业年报。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>即将到期的药品生产许可证。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>个集采药品未达到检查、抽检验及追溯全覆盖。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次集采或特药专项检查未绑定品种。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次检查未上传整改报告。</li>
            </ul>
        </div> 
    </div>
  </div>
  <div class="md:flex">
    <div class="divW  lg:w-1/3">
        <div>
          <div>
            <span>待盖章情况</span>
            <span class="line"></span>
          </div>
        </div>
        <div>
          <ul class="list-decimal pl-2rem m-0">
                <li>您有<span class="text-red-500 px-1">0</span>条风险处置需要处理。</li>
                <li>您有<span class="text-red-500 px-1">0</span>条协同处置需要处理。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>家企业未填写药品生产企业年报。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>即将到期的药品生产许可证。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>个集采药品未达到检查、抽检验及追溯全覆盖。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次集采或特药专项检查未绑定品种。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次检查未上传整改报告。</li>
            </ul>
        </div>      
      </div>
    <div class="divW lg:w-1/3">
      <div class="h-full overflow-auto">
            <ul class="list-decimal pl-2rem m-0">
                <li>您有<span class="text-red-500 px-1">0</span>条风险处置需要处理。</li>
                <li>您有<span class="text-red-500 px-1">0</span>条协同处置需要处理。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>家企业未填写药品生产企业年报。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>即将到期的药品生产许可证。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>个集采药品未达到检查、抽检验及追溯全覆盖。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次集采或特药专项检查未绑定品种。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次检查未上传整改报告。</li>
            </ul>
        </div> 
    </div>
    <div class="divW lg:w-1/3">
      <div class="h-full overflow-auto">
            <ul class="list-decimal pl-2rem m-0">
                <li>您有<span class="text-red-500 px-1">0</span>条风险处置需要处理。</li>
                <li>您有<span class="text-red-500 px-1">0</span>条协同处置需要处理。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>家企业未填写药品生产企业年报。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>即将到期的药品生产许可证。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>个集采药品未达到检查、抽检验及追溯全覆盖。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次集采或特药专项检查未绑定品种。</li>
                <li>当前有<span class="text-red-500 px-1">0</span>次检查未上传整改报告。</li>
            </ul>
        </div> 
    </div>
  </div>      
</template>
<script lang="ts" setup>
import { ref } from 'vue';
const data = ref([])
for(var i= 0 ;i<10;i++){
  data.value.push({zslx:'证书'+i,num:i})
}
  defineProps({
    loading: {
      type: Boolean,
    },
  });
</script>
<style>
.divW{
  padding: 10px;
  width: 33.3%;
  margin: 10px;
  background-color: rgb(239, 243, 243);
}
.table-container {
  overflow-x: auto;
  overflow-y: hidden;
  width: 100%;
  max-height: 260px; /* 设置最大高度以实现滚动效果 */
}
 
.table-container table {
  width: 100%;
  table-layout: fixed;
}
 
.table-container tbody {
  display: block;
  height: 260px; /* 与.table-container的max-height相同 */
  overflow-y: scroll;
}

.table-container thead {
  background-color: rgb(137, 198, 238);
  border-radius: 10px;
}

.text-left{
  padding: 8px;
}
.text-right{
  padding: 8px;
}

.table-container thead {
  background-color: rgb(136, 238, 241);
  padding: 10px;
}
 
.table-container thead, .table-container tbody tr {
  display: table;
  width: 100%;
  table-layout: fixed;
  
}
 
.table-container tbody td {
  width: 100px; /* 根据实际需要设置宽度 */
  word-break: break-all;
}
</style>
