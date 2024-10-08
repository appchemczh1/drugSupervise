<template>
  <div style="padding: 5px;">
        <el-form
          ref="formRef"
          :model="formState"
        >
          <el-row>
<!--            <el-col :span="2">-->
<!--              发证日期：-->
<!--            </el-col>-->
            <el-col :span="4">
              <el-form-item label="开始日期" prop="yxqq">
                <el-date-picker
                  v-model="formState.yxqq"
                  type="date"
                  placeholder="选择月"
                  style="width: 200px">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="4">
               <el-form-item label="结束日期" prop="yxqz">
              <el-date-picker
                v-model="formState.yxqz"
                type="date"
                placeholder="选择月"
                style="width: 200px">
              </el-date-picker>
            </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item :label-width="0" :style="{ textAlign: 'center' }">
                <el-button type="primary" @click="onSubmit">搜索</el-button>
                <el-button style="margin-left: 10px" @click="resetForm">重置</el-button>
                <el-button type="info" @click="handleExport">
                  导出 <el-icon><Download /></el-icon>
                </el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
  </div>
  <el-table :data="dataList" border style="width: 100%">
    <el-table-column label="行政区划" prop="xzqh" align="center" width="100px">
      <template v-slot="scope">
        {{ renderXzqh(scope.row.xzqh) }}
      </template>
    </el-table-column>
    <el-table-column label="药品类">
      <el-table-column label="药品生产企业(含放射性药品生产)" prop="ypschfsyp" align="center"></el-table-column>
      <el-table-column label="医疗机构制剂生产" prop="ylzj" align="center"></el-table-column>
      <el-table-column label="药品批发" prop="ypjypf" align="center"></el-table-column>
      <el-table-column label="药品零售连锁总部" prop="ypjylszb" align="center"></el-table-column>
      <el-table-column label="药品零售连锁门店" prop="ypjylsmd" align="center"></el-table-column>
      <el-table-column label="药品零售单体门店" prop="ypjyls" align="center"></el-table-column>
      <el-table-column label="放射性药品经营" prop="fsxypjy" align="center"></el-table-column>
      <el-table-column label="放射性药品使用" prop="fsxypsy" align="center"></el-table-column>
    </el-table-column>
    <el-table-column label="小计" prop="xj1" align="center"></el-table-column>
    <el-table-column label="医疗类器械">
      <el-table-column label="第一类医疗器械生产备案" prop="ylylqxba" align="center"></el-table-column>
      <el-table-column label="二、三类医疗器械生产企业" prop="rslylqx" align="center"></el-table-column>
      <el-table-column label="第三类医疗器械经营（批发）" prop="slylqxpf" align="center"></el-table-column>
      <el-table-column label="第三类医疗器械经营（零售）" prop="slylqxls" align="center"></el-table-column>
    </el-table-column>
    <el-table-column label="小计" prop="xj2" align="center"></el-table-column>
    <el-table-column label="化妆品类">
      <el-table-column label="化妆品生产企业" prop="hzpsc" align="center"></el-table-column>
    </el-table-column>
    <el-table-column label="合计" prop="zj" align="center"></el-table-column>
  </el-table>
</template>

<script>
import { ref } from 'vue';
import { defHttp } from '/@/utils/http/axios';
import { useMethods } from '/@/hooks/system/useMethods';

export default {
  name: "qylxtj",
  data() {
    return {

      formState: {
        yxqq:null,
        yxqz:null,
      },
      dataList: [],
      xzqhDict: {
        '1': '武汉市',
        '2': '黄石市',
        '3': '十堰市',
        '4': '宜昌市',
        '5': '襄阳市',
        '6': '鄂州市',
        '7': '荆门市',
        '8': '孝感市',
        '9': '荆州市',
        '10': '黄冈市',
        '11': '咸宁市',
        '12': '随州市',
        '13': '恩施市',
        '14': '仙桃市',
        '15': '潜江市',
        '16': '天门市',
        '17': '神农架',
        '18': '合计',
        // 添加更多的映射
      }
    };
  },

  created() {
    /*let date = new Date();
    date.setHours(0);
    date.setMinutes(0);
    date.setSeconds(0);

    this.formState.yxqq = date;
    this.formState.yxqz= date;*/
    this.getData();
  },

  methods: {
    checkNull(obj) {
      if (obj === "" || obj == null || obj.length == 0) {
        return true;
      } else if (obj !== "" && obj != null && obj.length != 0) {
        return false;
      }
    },

    renderXzqh(text) {
      return this.xzqhDict[text] || text;
    },

    getData() {
      let params = {};
      if(this.formState.yxqq && this.formState.yxqq != null && this.formState.yxqq != ''){
        this.formState.yxqq = this.Dateturn(this.formState.yxqq);
      }
      if(this.formState.yxqz && this.formState.yxqz != null && this.formState.yxqz != ''){
        this.formState.yxqz = this.Dateturn(this.formState.yxqz);
      }
      params = this.formState;
      defHttp.get({ url: '/dzzz.certStatistics/qylxtj/tjList', params }).then(res => {
        if (res != null) {
          this.dataList = res;
        }
      });
    },
    Dateturn(inputDate){
      if (!(inputDate instanceof Date)) {
        inputDate = new Date(inputDate);
      }
      var year = inputDate.getFullYear();
      var month = inputDate.getMonth() + 1; // 月份从0开始，所以要加1
      var day = inputDate.getDate();

// 月份和日期如果是个位数，前面补零
      month = month < 10 ? '0' + month : month;
      day = day < 10 ? '0' + day : day;

// 构造新的日期字符串
      var outputDateString = year + '-' + month + '-' + day;
      return outputDateString;
    },

    onSubmit() {
      this.getData()
    },

    resetForm() {
      this.$refs.formRef.resetFields();
    },
    // handleExport() {
    //   debugger
    //    const queryMap = {};
    //   queryMap.List = JSON.stringify(this.dataList);
    //   defHttp.get({
    //     url: '/dzzz.certStatistics/qylxtj/export',
    //     params:queryMap,
    //     responseType: 'blob'
    //   }).then((res) => {
    //     debugger
    //     if (res != null) {
    //       const blob = new Blob([res], { type: 'application/excel' });
    //       const downloadUrl = window.URL.createObjectURL(blob);
    //       const link = document.createElement('a');
    //       link.href = downloadUrl;
    //       link.download = 'export.xlsx';
    //       document.body.appendChild(link);
    //       link.click();
    //       document.body.removeChild(link);
    //     }
    //   });
    //   // debugger
    //   // const selectData = {};
    //   // const queryMap = this.formState;
    //   //   this.download('dzzz.certStatistics/qylxtj/export', {
    //   //     queryMap
    //   //   }, `采油井日报${new Date().getTime()}.xlsx`)
    //
    // },

    handleExport() {
      const urll = '/dzzz.certStatistics/qylxtj/export'
      const queryMap = { List: JSON.stringify(this.dataList),jzrq: this.Dateturn(this.formState.yxqz) };
      const name = "统计两品一械"
      useMethods().handleExportXls(name,urll,queryMap);
      // console.log('Query Map:', queryMap); // 输出请求参数以进行调试
      // defHttp.get({
      //   url: '/dzzz.certStatistics/qylxtj/export',
      //   params: queryMap,
      //   responseType: 'blob'
      // }).then((res) => {
      //   console.log('Response:', res); // 输出响应内容以进行调试
      //   const blob = new Blob([res], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      //   if (window.navigator && window.navigator.msSaveOrOpenBlob) {
      //     window.navigator.msSaveOrOpenBlob(blob, '统计两品一械.xlsx');
      //   } else {
      //     const link = document.createElement('a');
      //     link.style.display = 'none';
      //     link.href = URL.createObjectURL(blob);
      //     link.download = '统计两品一械.xlsx';
      //     document.body.appendChild(link);
      //     link.click();
      //     document.body.removeChild(link);
      //   }
      // }).catch(error => {
      //   console.error('Error:', error); // 输出详细错误信息
      //   console.error('Error Message:', error.message); // 输出错误消息
      //   console.error('Error Stack:', error.stack); // 输出错误堆栈
      //   console.error('Error Response:', error.response); // 输出错误响应
      //   alert('导出失败，请稍后重试'); // 显示错误信息给用户
      // });
    },


    exportExcel() {
      const queryMap = { List: JSON.stringify(this.dataList) };
      console.log('Query Map:', queryMap); // 输出请求参数以进行调试
      defHttp.get({
        url: '/dzzz.certStatistics/qylxtj/exportExcel',
        params: queryMap,
        responseType: 'blob'
      }).then((res) => {
        console.log('Response:', res); // 输出响应内容以进行调试
        const blob = new Blob([res], { type: 'application/vnd.ms-excel' });
        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(blob, '统计两品一械.xlsx');
        } else {
          const link = document.createElement('a');
          link.style.display = 'none';
          link.href = URL.createObjectURL(blob);
          link.download = '统计两品一械.xlsx';
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
        }
      }).catch(error => {
        console.error('Error:', error); // 输出详细错误信息
        console.error('Error Message:', error.message); // 输出错误消息
        console.error('Error Stack:', error.stack); // 输出错误堆栈
        console.error('Error Response:', error.response); // 输出错误响应
        alert('导出失败，请稍后重试'); // 显示错误信息给用户
      });
    },

  },
};
</script>

<style>
.el-table th,
.el-table .el-table__header-wrapper thead th {
  background-color: rgb(45, 82, 159) !important; /* 使用 !important */
  color: white !important;
  text-align: center;
}
</style>
