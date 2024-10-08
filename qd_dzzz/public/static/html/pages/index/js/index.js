// 公示平台
$(function () {
  let tenantId, TIMESTAMP, Sign;
  window.addEventListener('message', (event) => {
    if (event.origin !== window.location.origin) {
      return;
    }
    let { token } = event.data;
    if (!token) return;
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
  if (top === window) initVue();
  function initVue () {
    Vue.component('treeselect', VueTreeselect.Treeselect);
    let vue = new Vue({
      el: '#app',
      data: {
        ztMap: { 1: '核发', 2: '换发', 3: '变更', 4: '注销', 7: '变更' },
        keyWord: '', //顶部搜索关键词
        tabType: 0, //三种tab点击状态
        typeListData: [], //子类数据
        cityData: [], //区域划分数据
        isClick: '0',//是否是点击查询 0 否  1 是
        typeId: '', //子类id
        value1: '', //企业名称
        value2: '', //社会信用代码
        value3: '', //许可编号
        value4: [], //行政区划
        value5: '', //发证机关
        value6: '', //发证日期
        value7: '', //产品名称
        listData: [], //列表数据
        pageindex: 0, //页码
        pagesize: 10, //页数
        loading: true,
        rankState: 'timedown', //证书编号升降\发证日期升降
        chanpingShow:false,
      },
      watch: {
        tabType () {
          this.getTypeData();
          this.typeId = '';
          //this.getListData();
        },
        typeId () {
          //this.pageindex = 0;
          //this.getListData();
        },
        rankState () {
          this.pageindex = 0;
          this.getListData();
        },
      },
      mounted () {
        this.getTypeData();
        this.getCityName();
        //this.getListData();
      },
      methods: {
        formatNestedLabel (node) {
          if (!node.nestedSearchLabel) {
            return "";
          }
          return node.label;
          // return node.nestedSearchLabel.replaceAll(" ", "/");
        },

        //打开弹窗
        openmenu (record) {
          let parma = { recordData: record };
          // window.open("https://zsgs.hubyjj.cn:8096/licenseInfo?id=" + record.zsid, "_blank", "alwaysLowered");
          layer.open({
            type: 2,
            title: ['证照信息','font-size:16px'],
            skin: 'layui-layer-rim',
            area: ['40%', '80%'],
            icon: 1,
            maxmin: false,
            // content: ['http://localhost:3100/licenseInfo?id='+record.zsid, 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            content: ['https://zsgs.hubyjj.cn:8096/licenseInfo?id='+record.zsid, 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
          });
        },

        getZtTitle (zt) {
          // const ztMap = {
          //   1: '待处理',
          //   2: '处理中',
          //   3: '已完成',
          //   // 其他码值映射
          // };
          return this.ztMap[zt] || '未知状态';
        },
        // 请求子类
        // getTypeData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/typeList',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({ type: this.tabType }),
        //     success: function (data) {
        //       debugger
        //       let list = data.custom.list;
        //       _that.typeListData = list;
        //     }
        //   });
        //   // Util.getAjax({
        //   //     url: 'typeList',
        //   // },function(data) {
        //   //     console.log(data)
        //   // })
        // },
        // 请求子类
        getTypeData () {
          let _that = this;
          const url = '/dzzz.homepage/otherPage/typeList'
          this.commonAjaxRequest(url, { type: this.tabType, }, 'POST', function (data) {
            let list = data.result.list;
            _that.typeListData = list;
            _that.typeListData.forEach((item,index) => {
              if (index === 0) {
                _that.handleCertTypeClick(item);
              }
            });
          });
        },
        // 请求区域划分
        getCityName () {
          let _that = this;
          const url = '/dzzz.homepage/otherPage/cityName'
          this.commonAjaxRequest(url, { type: this.tabType, }, 'POST', function (data) {
            let list = data.result.list;
            _that.cityData = list;
          });
          // $.ajax({
          //   url: '/cityName',
          //   type: 'POST',
          //   contentType: 'application/json',
          //   dataType: 'json',
          //   data: JSON.stringify({  }),
          //   success: function (data) {
          //     let list = data.custom.list;
          //     _that.cityData = list;
          //   }
          // });
        },
        // 请求列表数据
        // getListData() {
        //   let _that = this;
        //   $.ajax({
        //     url: '/ListDetail',
        //     type: 'POST',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify({
        //       pageindex: this.pageindex, //页码
        //       pagesize:this.pagesize, //每页个数
        //       typeId: this.typeId,//子类id
        //       type: this.tabType,
        //       keyWord: this.keyWord, //顶部搜索id
        //       value1: this.value1,
        //       value2: this.value2,
        //       value3: this.value3,
        //       value4: this.value4,
        //       value5: this.value5,
        //       value6: this.value6,
        //       value7: this.value7,
        //       rankState: this.rankState,
        //     }),
        //     success: function (data) {
        //
        //       let list = data.custom.list,
        //         total = data.custom.total;
        //       _that.listData = list;
        //       _that.loading = false;
        //       _that.renderPager(_that.pageindex, _that.pagesize, total, _that.getListData);
        //     }
        //   });
        // },

        // 请求列表数据
        getListData () {
          let _that = this;
          _that.loading = true;
          const url = '/dzzz.homepage/otherPage/ListDetail'
          this.commonAjaxRequest(url, {
            pageindex: this.pageindex + 1, //页码
            pagesize: this.pagesize, //每页个数
            typeId: this.typeId, //子类id
            type: this.tabType,
            isClick: this.isClick,
            keyWord: this.keyWord, //顶部搜索id
            value1: this.value1,
            value2: this.value2,
            value3: this.value3,
            value4: this.value4,
            value5: this.value5,
            value6: this.value6 == null ? "" : this.value6,
            value7: this.value7,
            rankState: this.rankState,
          }, 'POST', function (data) {
            let list = data.result.list,
              total = data.result.total;
            _that.listData = list;
            _that.isClick = '0';
            _that.loading = false;
            _that.renderPager(_that.pageindex, _that.pagesize, total, _that.getListData);
          });
        },
        handleCertTypeClick(item) {
          this.typeId = item.key;
          if (item.zslx === 'QX_QXZC_TWSJ' || item.zslx === 'QX_YLQX_DYLCPBA' || item.zslx === 'QX_YLQX_DYLTWZDSJBA' || item.zslx === 'QX_QXZC_CPQX') {
            this.chanpingShow = true;
          } else {
            this.chanpingShow = false;
          }
          this.pageindex = 0;
          this.getListData();
        },
        // 分页
        renderPager (pageindex, pagesize, total, fn) {
          let $pager = $('#pager'),
            _that = this;
          if ($pager.pagination()) {
            $pager.pagination('setPageIndex', pageindex);
            $pager.pagination('setPageSize', pagesize);
            $pager.pagination('render', total);
          } else {
            $pager.pagination({
              pageIndex: pageindex,
              pageSize: pagesize,
              total: total,
              prevBtnText: '<',
              nextBtnText: '>',
              // debug: true,
              pageElementSort: ['$size', '$page', '$jump','$info'],
              showInfo: true,
              infoFormat: ' 共{total}条数据',
              noInfoText: '无记录',
              showJump: true,
              showPageSizes: true,
              showFirstLastBtn: false
            });
            $pager
              .on('pageClicked', function (event, data) {
                _that.pageindex = data.pageIndex,
                  _that.pagesize = data.pageSize;
                fn && fn(data.pageIndex, data.pageSize);
              })
              .on('jumpClicked', function (event, data) {
                _that.pageindex = data.pageIndex,
                  _that.pagesize = data.pageSize;
                fn && fn(data.pageIndex, data.pageSize);
              })
              .on('pageSizeChanged', function (event, data) {
                _that.pageindex = data.pageIndex,
                  _that.pagesize = data.pageSize;
                fn && fn(data.pageIndex, data.pageSize);
              });
          }
        },
        // 行政区划点击
        handleChange () { },
        // 点击搜索
        handleSearch () {
          this.pageindex = 0;
          this.isClick = '1';
          if (this.keyWord !== null && this.keyWord !== '') {
            this.typeId = '';
          }
          if (this.tabType === 1) {
            if (this.typeId === ''){
              this.chanpingShow = true;
            }
          }
          this.getListData();
        },
        //通用ajax方法
        commonAjaxRequest (url, param, type, successCallback) {
          let token = localStorage.getItem('token');
          // let fullUrl = 'http://localhost:3100/hbdzzz' + url;
          var baseUrl = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port : '');
          let fullUrl = baseUrl + '/hbdzzz' + url;

          $.ajax({
            url: fullUrl,
            type: type,
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
        },

        openLayer (id, name) {
          const url = '/dzzz.certinfo/certInfo/getAttachByCertid';
          this.commonAjaxGetRequest(url, {
            id: id,
            certmodetype: name,
            isgz: '1'
          }, 'GET', function (data) {
            window.open('https://zsgs.hubyjj.cn:8095/web-reader/reader?file=https://zsgs.hubyjj.cn:8096/hbdzzz/sys/common/static/' + data.result.modeUrl);
            console.log('data!!!!!!!!:', data.result.modeUrl);
          });
        },

        commonAjaxGetRequest (url, params, type, successCallback) {
          let token = localStorage.getItem('token');
          var baseUrl = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port : '');
          let fullUrl = baseUrl + '/hbdzzz' + url;

          $.ajax({
            url: fullUrl,
            type: type,
            data: params,
            dataType: 'json',
            headers: {
              'Authorization': token,
              'X-Access-Token': token,
              'X-Sign': Sign,
              'X-Tenant-Id': tenantId,
              'X-Timestamp': TIMESTAMP,
              'X-Version': 'v3'
            },
            success: function (data) {
              successCallback(data);
            },
            error: function (xhr, status, error) {
              console.error('Error:', error);
            }
          });
        }
      }
    });
  }
});
