<template>
  <div>
    <div style="padding: 5px">
      发证日期：
      <a-space direction="vertical">
        <div>
          <a-date-picker v-model:value="yxqq" value-format="YYYY-MM-DD" />-
          <a-date-picker v-model:value="yxqz" value-format="YYYY-MM-DD" />
          <span style="margin: 10px"><a-button type="primary" shape="round" @click="getData">搜索</a-button></span>
          <span style="margin: 10px"> <a-button shape="round" @click="reset">重置</a-button></span>
          <span style="margin: 10px"> <a-button shape="round" @click="handleExport">导出</a-button></span>
        </div>
      </a-space>
    </div>
    <div style="padding: 5px">
      <a-table
        class="ant-table-striped"
        size="middle"
        :columns="columns"
        :data-source="zslxtjData"
        :row-class-name="(record, index) => (index % 2 === 1 ? 'table-striped' : null)"
        :pagination="false"
        :loading="loading"
      />
    </div>
  </div>
</template>
<script lang="ts" setup>
  import { ref } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMethods, XLSX_FILE_SUFFIX, XLSX_MIME_TYPE } from '@/hooks/system/useMethods';
  import { useMessage } from '@/hooks/web/useMessage';
  import { useGlobSetting } from '@/hooks/setting';
  const zslxtjData = ref([]);
  const yxqq = ref('');
  const yxqz = ref('');
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const { createMessage, createWarningModal } = useMessage();
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const glob = useGlobSetting();
  const loading = ref(true);

  getData();

  const columns = [
    {
      title: '序号',
      align: 'center',
      customRender: (text, record, index) => {
        return text.index + 1;
      },
    },
    {
      title: '证书类型/行政区划',
      dataIndex: 'zsmc',
      key: 'zsmc',
      align: 'left',
    },
    {
      title: '省本级',
      dataIndex: 'sbNum',
      key: 'sbNum',
      align: 'center',
    },
    {
      title: '武汉市',
      dataIndex: 'whNum',
      key: 'whNum',
      align: 'center',
    },
    {
      title: '黄石市',
      dataIndex: 'hsNum',
      key: 'hsNum',
      align: 'center',
    },
    {
      title: '十堰市',
      dataIndex: 'syNum',
      key: 'syNum',
      align: 'center',
    },
    {
      title: '宜昌市',
      dataIndex: 'ycNum',
      key: 'ycNum',
      align: 'center',
    },
    {
      title: '襄阳市',
      dataIndex: 'xyNum',
      key: 'xyNum',
      align: 'center',
    },
    {
      title: '鄂州市',
      dataIndex: 'ezNum',
      key: 'ezNum',
      align: 'center',
    },
    {
      title: '荆门市',
      dataIndex: 'jmNum',
      key: 'jmNum',
      align: 'center',
    },
    {
      title: '孝感市',
      dataIndex: 'xgNum',
      key: 'xgNum',
      align: 'center',
    },
    {
      title: '荆州市',
      dataIndex: 'jzNum',
      key: 'jzNum',
      align: 'center',
    },
    {
      title: '黄冈市',
      dataIndex: 'hgNum',
      key: 'hgNum',
      align: 'center',
    },
    {
      title: '咸宁市',
      dataIndex: 'xnNum',
      key: 'xnNum',
      align: 'center',
    },
    {
      title: '随州市',
      dataIndex: 'szNum',
      key: 'szNum',
      align: 'center',
    },
    {
      title: '恩施州',
      dataIndex: 'esNum',
      key: 'esNum',
      align: 'center',
    },
    {
      title: '仙桃市',
      dataIndex: 'xtNum',
      key: 'xtNum',
      align: 'center',
    },
    {
      title: '潜江市',
      dataIndex: 'qjNum',
      key: 'qjNum',
      align: 'center',
    },
    {
      title: '天门市',
      dataIndex: 'tmNum',
      key: 'tmNum',
      align: 'center',
    },
    {
      title: '神农架',
      dataIndex: 'snjNum',
      key: 'snjNum',
      align: 'center',
    },
    {
      title: '总计',
      dataIndex: 'totalNum',
      key: 'totalNum',
      fixed: 'right',
      align: 'center',
    },
  ];

  function getData() {
    loading.value = true;
    let params = {};
    if(yxqq.value == null) {
      yxqq.value = '';
    }
    if(yxqz.value == null) {
      yxqz.value = '';
    }
    params.yxqq = yxqq.value.toString();
    params.yxqz = yxqz.value.toString();
    defHttp.get({ url: '/dzzz.certStatistics/zslxtj/tjList', params }).then((res) => {
      if (res != null) {
        loading.value = false;
        let a = {};
        res.forEach((el) => {
          a.zsmc = '总计';
          a.sbNum = (a.sbNum || 0) + el.sbNum;
          a.whNum = (a.whNum || 0) + el.whNum;
          a.hsNum = (a.hsNum || 0) + el.hsNum;
          a.syNum = (a.syNum || 0) + el.syNum;
          a.ycNum = (a.ycNum || 0) + el.ycNum;
          a.xyNum = (a.xyNum || 0) + el.xyNum;
          a.ezNum = (a.ezNum || 0) + el.ezNum;
          a.jmNum = (a.jmNum || 0) + el.jmNum;
          a.xgNum = (a.xgNum || 0) + el.xgNum;
          a.jzNum = (a.jzNum || 0) + el.jzNum;
          a.hgNum = (a.hgNum || 0) + el.hgNum;
          a.xnNum = (a.xnNum || 0) + el.xnNum;
          a.esNum = (a.esNum || 0) + el.esNum;
          a.szNum = (a.szNum || 0) + el.szNum;
          a.xtNum = (a.xtNum || 0) + el.xtNum;
          a.qjNum = (a.qjNum || 0) + el.qjNum;
          a.tmNum = (a.tmNum || 0) + el.tmNum;
          a.snjNum = (a.snjNum || 0) + el.snjNum;
          a.totalNum = (a.totalNum || 0) + el.totalNum;
        });
        res.push(a);
        zslxtjData.value = res;
      }
    });
  }

  function reset() {
    yxqq.value = '';
    yxqz.value = '';
  }

  function handleExport() {
    debugger;
    const urll = '/dzzz.certStatistics/zslxtj/export';
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const rq = yxqz.value;
    let jzrq = '';
    if (checkNull(rq)) {
      jzrq = rq;
    } else {
      jzrq = Dateturn(rq);
    }
    const queryMap = { List: JSON.stringify(zslxtjData.value), jzrq: jzrq };
    const name = '证书类型统计';
    // useMethods().handleExportXls(name, urll, queryMap);
    exportXls(name, urll, queryMap);
  }

  function Dateturn(inputDate) {
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
  }

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  function checkNull(obj) {
    if (obj === '' || obj == null || obj.length == 0) {
      return true;
    } else if (obj !== '' && obj != null && obj.length != 0) {
      return false;
    }
  }

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  async function exportXls(name, url, params, isXlsx = false) {
    //update-begin---author:wangshuai---date:2024-01-25---for:【QQYUN-8118】导出超时时间设置长点---
    const data = await defHttp.post({ url: url, data: params, responseType: 'blob', timeout: 60000 }, { isTransformResponse: false });
    //update-end---author:wangshuai---date:2024-01-25---for:【QQYUN-8118】导出超时时间设置长点---
    if (!data) {
      createMessage.warning('文件下载失败');
      return;
    }
    if (!name || typeof name != 'string') {
      name = '导出文件';
    }
    let blobOptions = { type: 'application/vnd.ms-excel' };
    let fileSuffix = '.xls';
    if (isXlsx === true) {
      blobOptions['type'] = XLSX_MIME_TYPE;
      fileSuffix = XLSX_FILE_SUFFIX;
    }
    if (typeof window.navigator.msSaveBlob !== 'undefined') {
      window.navigator.msSaveBlob(new Blob([data], blobOptions), name + fileSuffix);
    } else {
      let url = window.URL.createObjectURL(new Blob([data], blobOptions));
      let link = document.createElement('a');
      link.style.display = 'none';
      link.href = url;
      link.setAttribute('download', name + fileSuffix);
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link); //下载完成移除元素
      window.URL.revokeObjectURL(url); //释放掉blob对象
    }
  }
</script>
<style scoped>
  .ant-table-striped :deep(.table-striped) td {
    background-color: #e8f0f5;
  }
</style>
