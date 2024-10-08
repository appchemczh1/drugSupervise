package org.jeecg.modules.demo.dzzz.constant;


import java.util.*;

public class YwConstant {

    /** 成功：200，失败：300/500 */
    public static final int SUCCESS_CODE_200 = 200;
    public static final int ERROR_CODE_300 = 300;
    public static final int ERROR_CODE_500 = 500;
    public static final int ERROR_CODE_400 = 400;

    /** 记录来源：1-省市场局，2-武汉市局*/
    public static final String JLLY_SSCJ = "SSCJ";
    public static final String JLLY_WHSJ = "WHSJ";

    /** 是否：0-是 1-否 **/
    public static final int CONFIRM = 0;
    public static final int DENY = 1;
    public static final String SUCCESS_MSG = "成功";
    public static final String FAIL_MSG = "失败";

    /** 盖章生成状态： 0-同步，2-未生成，3-生成未盖章，4-盖章 **/
    public static final String GZ_SCZT_TB = "0";
    public static final String GZ_SCZT_WSC = "2";
    public static final String GZ_SCZT_WGZ = "3";
    public static final String GZ_SCZT_GZ = "4";

    /** 证书状态：10-有效，50-注销，60-过期，70-吊销，80-撤销，99-作废 **/
    public static final String ZSZT_YX = "10";
    public static final String ZSZT_ZX = "50";
    public static final String ZSZT_GQ = "60";
    public static final String ZSZT_DX = "70";
    public static final String ZSZT_CX = "80";
    public static final String ZSZT_ZF = "99";

    /** 医疗器械网络销售备案-zslx **/
    public static final String ZSLX_YLQXWLXSBA = "64";
    /** 第一类医疗器械生产备案-zslx **/
    public static final String ZSLX_DYLYLQXSCBA = "46";

    /** 证书编号-第二个字符 **/
    public static final Map<String, String> ZSBH_ZM_SECOND = new HashMap<>();

    /** 证书类型-省市场局 **/
    public static final Map<String, String> ZSLX_SSCJ = new HashMap<>();
    /** 证书类型-武汉市局 **/
    public static final Map<String, String> ZSLX_WHSJ = new HashMap<>();
    /** 业务类型 **/
    public static final String[] YWLX_LIST = new String[] { "1", "2", "3", "4", "5", "6", "7" };

    /** 麻醉药品和精神药品邮寄证明-zslx **/
    public static final String ZSLX_MZYP_AND_JSYPYJZM = "33";

    /** 【第一类医疗器械产品备案】、【麻醉药品、第一类精神药品运输证明】、【麻醉药品和精神药品邮寄证明】-zslx**/
    public static final String[] DYLCPBA_MZ_JSYP = new String[] {"27", "32", "33"};

    /** 日期格式化 **/
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD = "yyyy-MM-dd";

    public static final String WHSJ_LOG = "武汉市市场局接口日志";
    public static final String SSCJ_LOG = "湖北省市场局接口日志";

    public static final String HBS_CODE = "420000";
    public static final String HBS_LIKE = "420";
    public static final String WHS_CODE = "420100";
    public static final String WHS_LIKE = "4201";

    /** 预警处理状态 **/
    public static final String YJCLZT_YCL = "已处理";
    public static final String YJCLZT_WCL = "未处理";

    /** 盖章提示信息 **/
    public static final String GZ_SUCCESS = "盖章成功";
    public static final String SC_ZS_SUCCESS = "生成证照成功";

    /** 日期-时分秒 **/
    public static final String DATE_HMS_Q = " 00:00:00";
    public static final String DATE_HMS_Z = " 23:59:59";

    /** 状态（3：未盖章 4：已盖章） **/
    public static final String ZT_WGZ = "3";
    public static final String ZT_YGZ = "4";

    /** 状态（1：起草 2：发布 3：注销 4：历史） **/
    public static final String CERT_TYPE_STATUS_FB = "2";

    /** 第一类医疗器械生产备案 **/
    public static final String WHSJ_DYLYLQXSCBA = "46";
    /** 执业药师 **/
    public static final String ZYYS = "95";
    /** 执业药师ID **/
    public static final String CERTTYPEID_ZYYS = "fb79ccde-ebea-4da6-a080-2fe07df05e33";

    /** 省市场局-机构ID、名称、机构代码 **/
    public static final String SSCJ_JG_ID = "4028e49e404d20ed01404d33c1db0004";
    public static final String SSCJ_JG_NAME = "湖北省药品监督管理局";
    public static final String SSCJ_JG_DM = "11420000MB15291767";
    public static final String SSCJ_XK_XDRLB = "法人及非法人组织";
    public static final String SSCJ_XK_XKLB = "普通";

    /** 药品经营许可证 **/
    public static final String YPJYXKZ = "药品经营许可证";
    /** 医疗器械 **/
    public static final String YLQX = "医疗器械";
    /** 放射性药品经营许可证 **/
    public static final String FSXYPJYXKZ = "放射性药品经营许可证";
    /** 放射性药品生产许可证 **/
    public static final String FSXYPSCXKZ = "放射性药品生产许可证";
    /** 医疗器械广告审查准予许可决定书 **/
    public static final String YLQXGZSCZYXKJDS = "医疗器械广告审查准予许可决定书";
    /** 药品广告审查准予许可决定书 **/
    public static final String YPGGSCZYXKJDS = "药品广告审查准予许可决定书";
    /** 药品生产许可证 **/
    public static final String YPJYXKZPF = "药品经营许可证（批发）";
    /** 药品生产许可证 **/
    public static final String YPSCXKZ = "药品生产许可证";
    /** 医疗机构制剂调剂使用批件（批发） **/
    public static final String YLJGZJTJSYPJPF = "医疗机构制剂调剂使用批件（批发）";
    /** 化妆品生产许可证 **/
    public static final String HZPSCXKZ = "化妆品生产许可证";
    /** 第二、三类医疗器械生产许可证 **/
    public static final String DESLYLQXSCXKZ = "第二、三类医疗器械生产许可证";
    /** 第二类医疗器械注册证 **/
    public static final String DELYLQXZCZ = "第二类医疗器械注册证";
    /** 放射性药品使用许可证 **/
    public static final String FSXYPSYXKZ = "放射性药品使用许可证";
    /** 医疗机构制剂许可证 **/
    public static final String YLJGZJXKZ = "医疗机构制剂许可证";
    /** 互联网药品信息服务资格证书 **/
    public static final String HLWYPXXFWXZGZS = "互联网药品信息服务资格证书";

    /** 第一类医疗器械生产备案 **/
    public static final String DYLYLQXSCBA = "46";
    /** 一类 **/
    public static final String YL = "一类";

    /** 证书编号-第二个字符 **/
    public static final Map<String, String> SSCJ_SXBM = new HashMap<>();

    /** 省市场局四类证书类型ID **/
    public static List<String> SSCJ_CERTTYPEID = new ArrayList<>();

    static {
        ZSBH_ZM_SECOND.put("12", "D");
        ZSBH_ZM_SECOND.put("13", "C");

        ZSLX_SSCJ.put("12", "药品经营许可证(零售)");
        ZSLX_SSCJ.put("13", "药品经营许可证（零售连锁门店）");
        ZSLX_SSCJ.put("14", "第三类医疗器械经营许可证(批发)");
        ZSLX_SSCJ.put("15", "第三类医疗器械经营许可证(零售)");

        ZSLX_WHSJ.put("27", "第一类医疗器械产品备案");
        ZSLX_WHSJ.put("28", "第一类体外诊断试剂备案");
        ZSLX_WHSJ.put("30", "第二类医疗器械经营备案");
        ZSLX_WHSJ.put("32", "麻醉药品、第一类精神药品运输证明");
        ZSLX_WHSJ.put("33", "麻醉药品和精神药品邮寄证明");
        ZSLX_WHSJ.put("46", "第一类医疗器械生产备案");
        ZSLX_WHSJ.put("47", "第一类医疗器械生产委托备案");
        ZSLX_WHSJ.put("64", "医疗器械网络销售备案");


        /**
         * 许可内容-取值
         * 药品经营存范围，第三类医疗器械存经营范围，放射性经营存经营地址和经营范围，放射性生产存生产地址和生产范围，医疗器械广告和药品广告存产品名称，
         * 药品生产存生产地址和生产范围，化妆品生产存许可项目，医疗机构制剂许可证存配置范围，二、三类医疗器械生产许可存生产范围，
         * 第二类医疗器械注册证存产品名称，放射性使用存科室地址，医疗机构制剂调剂使用批件存制剂名称
         */
        SSCJ_SXBM.put(YPJYXKZ, "000172005000");
        SSCJ_SXBM.put(YLQX, "000172028000");
        // 420172026W04	《放射性药品经营许可证》变更-FW
        SSCJ_SXBM.put(FSXYPJYXKZ + "-3", "420172026W04");
        // 420172026W03	《放射性药品经营许可证》核发-FW
        SSCJ_SXBM.put(FSXYPJYXKZ + "-1", "420172026W03");
        // 420172026W02	《放射性药品生产许可证》变更-FW
        SSCJ_SXBM.put(FSXYPSCXKZ + "-3", "420172026W02");
        // 420172026W01	《放射性药品生产许可证》核发-FW
        SSCJ_SXBM.put(FSXYPSCXKZ + "-1", "420172026W01");
        // 420172015W02	医疗器械广告审批-CHANPING
        SSCJ_SXBM.put(YLQXGZSCZYXKJDS, "420172015W02");
        // 420172015W01	药品广告审批-CHANPING
        SSCJ_SXBM.put(YPGGSCZYXKJDS, "420172015W01");
        // 000172004000	药品批发企业许可-FW
        SSCJ_SXBM.put(YPJYXKZPF, "000172004000");
        // 000172003000	药品生产企业许可-FW
        SSCJ_SXBM.put(YPSCXKZ, "000172003000");
        // 000172002000	医疗机构配制的制剂品种和制剂调剂审批-YLZD2
        SSCJ_SXBM.put(YLJGZJTJSYPJPF, "000172002000");
        // 000172001000	化妆品生产许可-FW
        SSCJ_SXBM.put(HZPSCXKZ, "000172001000");
        // 000172027000	第二类、第三类医疗器械生产许可-FW
        SSCJ_SXBM.put(DESLYLQXSCXKZ, "000172027000");
        // 000172026000	第二类医疗器械产品注册审批-CHANPING
        SSCJ_SXBM.put(DELYLQXZCZ, "000172026000");
        // 000172023000	医疗单位使用放射性药品许可-YLZD6
        SSCJ_SXBM.put(FSXYPSYXKZ, "000172023000");
        // 000172006000	医疗机构配制制剂许可-FW
        SSCJ_SXBM.put(YLJGZJXKZ, "000172006000");
        // 000172030000	互联网药品信息服务资格证书-YLZD9
        SSCJ_SXBM.put(HLWYPXXFWXZGZS, "000172030000");

        SSCJ_CERTTYPEID = Arrays.asList("4e7ff714f0cf4f81b46eb16c1155744f", "d2dd9f71f5f34145af595fd79504e683",
                "4957bebb1de340cc90502265a456d303", "5102457a62a04aee8c93ea0873c8a39e");
    }

    public static final String[] FZJGID = new String[] {
            "4f1765520d6346f9bd9c79e2479e5b12",
            "57197590443c44f083d42ae24ef26a2c",
            "ff8080814645831f01464b123a8f01bb",
            "ff8080814645831f01464b129cc601bc",
            "ff8080814645831f01464b14c13e01c2",
            "ff8080814645831f01464b160c6601c6",
            "ff8080814645831f01464b159a1f01c4",
            "ff8080814645831f01464b131ce301be",
            "ff8080814645831f01464b171f3101cb",
            "ff8080814645831f01464b1b5aaa01d5",
            "ff8080814645831f01464b17861101cd",
            "ff8080814645831f01464b18514301d0",
            "ff8080814645831f01464b1f3fb701d9",
            "ff8080814645831f01464b1ea54401d8",
            "ff8080816ce2137c016f1880aac6268e",
            "5a3d34e273ff446badf4916ad7d569ed",
            "736d1c7005d64bbfa12397ca08ddd22d",
            "ff8080814645831f01464b1fb63401db"};

}
