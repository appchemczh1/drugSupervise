// 首页-证书查询
$(function () {
  let tenantId,TIMESTAMP,Sign;
  window.addEventListener('message', (event) => {
    if (event.origin !== window.location.origin) {
      return;
    }
    let { token } = event.data;
    tenantId = event.data.tenantId;
    TIMESTAMP = event.data.TIMESTAMP;
    Sign = event.data.Sign;
    // 现在你可以在iframe中的代码中使用token了
    console.log('Received token:', token);
    // 你可以在这里存储token，以便在后续请求中使用
    localStorage.setItem('token', token);
    localStorage.setItem('tenantId', tenantId);
    localStorage.setItem('TIMESTAMP', TIMESTAMP);
    localStorage.setItem('Sign', Sign);
    initVue();
  });
  function initVue() {
    let vue = new Vue({
      el: '#app',
      data: {
        token:'',
        tenantId:'',
        TIMESTAMP:'',
        Sign:'',
        stampCaseData: {}, //待盖章情况数据
        stampWarnData: [], //证书有效期预警数据
        stampDistributionData: {
          list: []
        }, //证书分布
        chartMap: null, //地图实例
        stampRankData: [], //证书数量排名数据
        stampInfoData: [], //证书总览
        firmInfoData: {}, //企业总览数据
      },
      created() {
        this.getStampCaseData();
        this.getStampWarnData();
        this.initMap();
        this.getStampRankData();
        this.getStampInfoData();
        this.getFirmInfoData();
      },
      watch: {},
      mounted() {

      },
      methods: {
        // 请求待盖章情况
        getStampCaseData() {
          let _that = this;
          let parma={};
          const  url  = '/dzzz.homepage/adminpage/stampCase'
          this.commonAjaxRequest(url,parma,(data)=>{
            this.stampCaseData = data.result;
          })
          // $.ajax({
          //   url: '/stampCase',
          //   type: 'POST',
          //   contentType: 'application/json',
          //   dataType: 'json',
          //   headers: {
          //     // 'Authorization': token , // 将token添加到请求头中
          //     // 'X-Access-Token': token,
          //     'X-Sign': Sign,
          //     'X-Tenant-Id': tenantId,
          //     'X-Timestamp': TIMESTAMP,
          //     'X-Version': 'v3'
          //   },
          //   data: JSON.stringify(parma),
          //   success: function (data) {
          //     debugger
          //     // _that.stampCaseData = data.result;
          //     _that.stampCaseData = data.custom;
          //   }
          // });
        },
        // 请求证书有效期预警数据
        getStampWarnData() {
          const url = '/dzzz.homepage/adminpage/stampWarnList'
          this.commonAjaxRequest(url, {}, (data) => {
            //debugger
            this.stampWarnData = data.result.list;
          });
        },

        // 请求证书分布数据
        getStampDistributionData() {
          const  url  = '/dzzz.homepage/adminpage/stampDistribution'
          this.commonAjaxRequest(url, {}, (data) => {
            data.result.total = Util.addCommas(data.result.total);
            data.result.pro_total = Util.addCommas(data.result.pro_total);
            data.result.drug_total = Util.addCommas(data.result.drug_total);
            data.result.app_total = Util.addCommas(data.result.app_total);
            data.result.cosmetics_total = Util.addCommas(data.result.cosmetics_total);
            this.stampDistributionData = data.result;
            this.chartMap.setOption({
              visualMap: {
                min: Util.getMin(this.stampDistributionData.list, 'value'),
                max: Util.getMax(this.stampDistributionData.list, 'value'),
                left: '1%',
                bottom: '6%',
                align: 'left',
                calculable: true,
                textStyle: {
                  fontSize: 16,
                  color: 'rgba(153, 153, 153, 1)'
                },
                inRange: {
                  color: ['rgba(199, 229, 254, 1)', 'rgba(68, 155, 245, 1)']
                },
                show: true
              },
              series: [
                {
                  data: this.stampDistributionData.list
                }
              ]
            });
            Util.areaHight(this.chartMap, this.stampDistributionData.list.length)
          });
        },
        // 请求证书分布数据
        // getStampDistributionData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/stampDistribution',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({}),
        //     success: function (data) {
        //       debugger
        //       data.custom.total = Util.addCommas(data.custom.total);
        //       data.custom.pro_total = Util.addCommas(data.custom.pro_total);
        //       data.custom.drug_total = Util.addCommas(data.custom.drug_total);
        //       data.custom.app_total = Util.addCommas(data.custom.app_total);
        //       data.custom.cosmetics_total = Util.addCommas(data.custom.cosmetics_total);
        //       _that.stampDistributionData = data.custom;
        //       _that.chartMap.setOption({
        //         visualMap: {
        //           min: Util.getMin(
        //             _that.stampDistributionData.list,
        //             'value'
        //           ),
        //           max: Util.getMax(
        //             _that.stampDistributionData.list,
        //             'value'
        //           ),
        //           left: '1%',
        //           bottom: '6%',
        //           align: 'left',
        //           calculable: true,
        //           textStyle: {
        //             fontSize: 16,
        //             color: 'rgba(153, 153, 153, 1)'
        //           },
        //           inRange: {
        //             color: [
        //               'rgba(199, 229, 254, 1)',
        //               'rgba(68, 155, 245, 1)'
        //             ]
        //           },
        //           show: true
        //         },
        //         series: [
        //           {
        //             data: _that.stampDistributionData.list
        //           }
        //         ]
        //       });
        //       Util.areaHight(_that.chartMap, _that.stampDistributionData.list.length)
        //     }
        //   });
        // },

        // 请求证书数量排名
        // getStampRankData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/stampRank',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({}),
        //     success: function (data) {
        //       debugger
        //       data.custom.list.forEach(val=>{
        //         val.value = Util.addCommas(val.value)
        //       })
        //       _that.stampRankData = data.custom.list;
        //       _that.$nextTick(()=>{
        //         var mySwiper = new Swiper(_that.$refs.mySwiper, {
        //           direction : 'vertical',
        //           slidesPerView : 8,
        //           autoplay: {
        //             delay: 3000,
        //             disableOnInteraction: false
        //           },
        //           // centeredSlides : true,
        //         })
        //       })
        //     }
        //   });
        // },

        getStampRankData() {
          const url = '/dzzz.homepage/adminpage/stampRank'
          this.commonAjaxRequest(url, {}, (data) => {
            data.result.list.forEach(val => {
              val.value = Util.addCommas(val.value);
              if (val.ratio > 100) {
                val.ratio = 100;
              }
            });
            this.stampRankData = data.result.list;
            this.$nextTick(() => {
              var mySwiper = new Swiper(this.$refs.mySwiper, {
                direction: 'vertical',
                slidesPerView: 8,
                autoplay: {
                  delay: 3000,
                  disableOnInteraction: false
                }
              });
            });
          });
        },

        // 请求证书总览
        // getStampInfoData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/stampInfo',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({}),
        //     success: function (data) {
        //       data.custom.list.forEach(val=>{
        //         debugger
        //         val.total = Util.addCommas(val.total);
        //         val.month_total = Util.addCommas(val.month_total);
        //         val.day_total = Util.addCommas(val.day_total);
        //       })
        //       _that.stampInfoData = data.custom.list;
        //     }
        //   });
        // },
        // 请求证书总览
        getStampInfoData() {
          const url = '/dzzz.homepage/adminpage/stampInfo'
          this.commonAjaxRequest(url, {}, (data) => {
            data.result.list.forEach(val => {
              val.total = Util.addCommas(val.total);
              val.month_total = Util.addCommas(val.month_total);
              val.day_total = Util.addCommas(val.day_total);
            });
            this.stampInfoData = data.result.list;
          });
        },
        // // 请求企业总览数据
        // getFirmInfoData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/firmInfo',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({}),
        //     success: function (data) {
        //       debugger
        //       for(let i in data.custom) {
        //         data.custom[i] = Util.addCommas(data.custom[i]);
        //       }
        //       _that.firmInfoData = data.custom;
        //     }
        //   });
        // },

        //请求持证企业数据
        getFirmInfoData() {
          const url = '/dzzz.homepage/adminpage/firmInfo'
          this.commonAjaxRequest(url, {}, (data) => {
            for (let i in data.result) {
              data.result[i] = Util.addCommas(data.result[i]);
            }
            this.firmInfoData = data.result;
          });
        },
        // 初始化地图
        initMap() {
          let _that = this;
          fetch('./js/hubei.json').then((data) => {
            data.json().then((res) => {
              echarts.registerMap('hubei', res);
              this.chartMap = echarts.init(_that.$refs.chartMap);
              this.chartMap.setOption({
                geo: [
                  {
                    map: 'hubei',
                    zoom: 1.1,
                    label: {
                      show: false
                    },
                    itemStyle: {
                      areaColor: 'rgba(205, 220, 233, 1)',
                      shadowColor: 'rgba(205, 220, 233, 1)',
                      shadowBlur: 1,
                      shadowOffsetX: -6,
                      shadowOffsetY: 10
                      // borderColor: 'rgba(205, 220, 233, 1)',
                      // borderWidth: 5,
                    },
                    z: 3,
                    silent: true
                  }
                ],
                tooltip: {
                  textStyle: {
                    color: '#fff',
                    fontSize: 18
                  },
                  padding: [10, 15],
                  color: '#fff',
                  backgroundColor: 'rgba(4,35,91,0.8)'
                },

                series: [
                  {
                    name: '证书分布',
                    type: 'map',
                    map: 'hubei',
                    zoom: 1.1,
                    label: {
                      show: true,
                      color: '#fff',
                      fontSize: 14,
                      textBorderColor: 'rgba(9, 112, 217, 1)',
                      textBorderWidth: 3,
                    },
                    itemStyle: {
                      areaColor: 'rgba(43,143,255,0.1)',
                      borderColor: '#fff',
                      borderWidth: 2
                    },
                    emphasis: {
                      label: {
                        color: '#fff',
                        fontSize: 16,
                        textBorderColor: 'rgba(255, 190, 89, 1)',
                        textBorderWidth: 3,
                      },
                      // itemStyle: {
                      // 	color: 'red',
                      // 	borderColor: '#fff',
                      // 	borderWidth: 1
                      // }
                    },
                    z: 4,
                    data: []
                  }
                ]
              });
              _that.getStampDistributionData();
            });
          });
        },
        // 打开新页面
        openLayer(name,url) {
          let parma = { name:name,isWgz:true,iframeUrl:url };
          window.parent.postMessage(parma, '*');
        },

        openWarn() {
          let dataToSend = {isWarn:true};
          window.parent.postMessage(dataToSend, '*');
        },
        //打开新菜单
        openmenu(url) {
          let parma = { iframeUrl:url };
          window.parent.postMessage(parma, '*');
        },

        //通用ajax方法
        commonAjaxRequest(url, param, successCallback) {
          let token = localStorage.getItem('token');
          var baseUrl = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port : '');
          let fullUrl = baseUrl + '/hbdzzz' + url;

          $.ajax({
            url: fullUrl,
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            headers: {
              'Authorization': token,
              'X-Access-Token': token,
              'X-Sign': Sign,
              'X-Tenant-Id': tenantId,
              'X-Timestamp': TIMESTAMP,
              'X-Version': 'v3'
            },
            data: JSON.stringify(param),
            success: function (data) {
              successCallback(data);
            }
          });
        }
      }

    });
    window.onresize = function() {
      vue.chartMap.resize();
    }
  }

});
