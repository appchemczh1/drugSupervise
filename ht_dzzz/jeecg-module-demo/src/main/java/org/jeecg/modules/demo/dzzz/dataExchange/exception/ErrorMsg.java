package org.jeecg.modules.demo.dzzz.dataExchange.exception;


public class ErrorMsg {

    /**
     * 省市场局-字段不能为空（药品、器械相同字段）
     */
    public static final String PARAMS_NOT_NULL = "请求参数不能为空";
    public static final String QYMC_NOT_NULL = "企业名称不能为空！";
    public static final String SHXYDM_NOT_NULL = "统一社会信用代码不能为空";
    public static final String FDDBR_NOT_NULL = "法定代表人不能为空";
    public static final String LXR_NOT_NULL = "联系人不能为空";
    public static final String LXDH_NOT_NULL = "联系电话不能为空";
    public static final String SZSF_NOT_NULL = "所在省不能为空";
    public static final String SZDS_NOT_NULL = "所在市不能为空";
    public static final String SZQX_NOT_NULL = "所在县不能为空";
    public static final String YWLX_NOT_NULL = "业务类型不能为空";
    public static final String ZSLX_NOT_NULL = "证书类型不能为空";
    public static final String ZSBH_NOT_NULL = "证书编号不能为空";
    public static final String JZRQ_NOT_NULL = "许可证有效截止日期不能为空";
    public static final String QYFZR_NOT_NULL = "企业负责人不能为空";
    public static final String FZRQ_NOT_NULL = "发证日期不能为空";
    public static final String FZJG_NOT_NULL = "发证机关不能为空";
    public static final String CKDZ_NOT_NULL = "仓库地址不能为空";
    public static final String SINGID_NOT_NULL = "【市场局证书数据主键】的值不能为空！。谢谢";
    public static final String XKXKWS_NOT_NULL = "行政许可决定文书名称不能为空";
    public static final String XKWSH_NOT_NULL = "行政许可决定文书号不能为空";
    public static final String XKXKLB_NOT_NULL = "（许可类别填写普通、 特许、 认可、 核准、登记或其他）不能为空";
    public static final String XKXKZS_NOT_NULL = "行政许可证书名称不能为空";
    public static final String XKNR_NOT_NULL = "行政许可决定书的主要内容不能为空";
    public static final String XKXKJGDM_NOT_NULL = "许可机关统一社会信用代码不能为空";

    /**
     * 省市场局-药品经营许可字段-不能为空
     */
    public static final String QYDZ_NOT_NULL = "企业地址不能为空";
    public static final String ZLGLR_NOT_NULL = "质量管理人不能为空";
    public static final String RCJGJG_NOT_NULL = "日常监管机构不能为空";
    public static final String QFR_NOT_NULL = "签发人不能为空";
    public static final String FW_NOT_NULL = "范围不能为空";
    public static final String XKXDRLB_NOT_NULL = "行政相对人类别不能为空";
    public static final String NOT_92_START_WITH = "行政相对人类别为：自然人，【xkxdrgszc】应当以92开头";
    public static final String NOT_91_START_WITH = "行政相对人类别为：法人及非法人组织，【xkxdrgszc】应当以91开头";

    /**
     * 省市场局-医疗器械许可字段-不能为空
     */
    public static final String ZS_NOT_NULL = "住所不能为空";
    public static final String JYFW_NOT_NULL = "经营范围不能为空";
    public static final String JYCS_NOT_NULL = "经营场所不能为空";
    public static final String JYFS_NOT_NULL = "经营方式不能为空";
    public static final String XKXDRLB2_NOT_NULL = "（填写法人及非法人组织、自然人、个体工商户三个类别中的一个）不能为空";

    /**
     * 省市场局-换发、变更不能为空
     */
    public static final String BGNR_NOT_NULL = "变更内容不能为空";
    public static final String BGSJ_NOT_NULL = "变更时间不能为空";

    /**
     * 省市场局-注销不能为空
     */
    public static final String BJBH_NOT_NULL = "办件编号不能为空";
    public static final String BJSXBM_NOT_NULL = "办件事项编码不能为空";

    // 省市场局-具体业务相关
    public static final String ZS_LX_NOT_FIND = "证书类型错误,请联系管理员!";
    // public static final String SHXYDM_LENGTH = "社会信用代码不正确";
    public static final String TS_ZF = "里包含特殊字符信息!";
    public static final String FZ_RQ = "发证日期不能大于当前日期！";
    public static final String JZ_RQ = "截止日期不能小于当前日期！";
    public static final String HF_ZS_EXIST = "当前企业已有该核发类型许可，无需继续推送！";
    public static final String ZS_NO_EXIST = "未查询到该企业的证书！";
    public static final String ZS_YZX = "当前企业该证书已注销，无需继续推送！";
    public static final String NO_ZX_YWLX = "当前业务类型不是注销！";
    public static final String NO_HF_ZX_NO_FIND_HISTORY = "证书【%s】证书编号【%s】与企业名称【%s】社会信用代码【%s】: 没有找到相关的历史证书信息!";
    public static final String LICENSE_ID_NOT_FIND_HISTORY = "证书【%s】证书编号【%s】与企业名称【%s】社会信用代码【%s】: 证书主键值与历史数据不一致【%s】，请检查!";

    public static final String ZS_EXIST = "证书已生成";
    public static final String FZ_JG_ERROR = "发证机关【%s】有误，请联系管理员";
    public static final String BG_JL_CF = "推送的证书【%s】证书编号【%s】:有重复信息,最近推送入库时间【%s】,无需继续推送!";
    public static final String ZS_LX_NOT_EXIST = "证书类型不存在";
    public static final String NOT_ZX_JK = "注销业务请走注销接口，谢谢！";
    public static final String NO_FIND_HISTORY = "推送的证书【%s】,证书编号【%s】:没有找到相关的历史证书信息!";

    // 省市场局-证书编号
    public static final String ZS_BH_ZM_FIRST = "证书编号首字母为省份简称'鄂'，请检查。谢谢！";
    public static final String ZS_BH_ZM_SECOND = "证书编号第二位字母有误：A表示批发企业，B表示零售连锁企业，C表示零售连锁门店，D表示单体零售企业，请检查。谢谢！";
    public static final String ZS_BH_LENGTH = "证书编号的长度有误，示例:鄂AA0271*****，请检查。谢谢！";

    // 省市场局-注销-证书编号
    public static final String ZS_BH_ZX_ZM_FIRST = "注销时发证日期为2024年1月1日之后的证书编号首字母为省份简称'鄂'，请检查。谢谢！";
    public static final String ZS_BH_ZX_ZM_SECOND = "注销时发证日期为2024年1月1日之后的证书编号第二位字母有误：A表示批发企业，B表示零售连锁企业，C表示零售连锁门店，D表示单体零售企业，请检查。谢谢！";
    public static final String ZS_BH_ZX_LENGTH = "注销时发证日期为2024年1月1日之后的证书编号的长度有误，示例:鄂AA0271*****，请检查。谢谢！";

    //==============================武汉市局==============================
    public static final String BGMX_LIST_NOT_NULL = "变更明细信息不能为空";
    public static final String AREA_INFO_NOT_NULL = "地区信息不能为空！";
    public static final String BJBM_SXBM_NOT_NULL = "办件编码或事项编码不能为空！";
    public static final String LICENSE_ID_LENGTH = "证书id【licenseId】的值不能大于32位！";
    public static final String ZSBH_ZSLX_ZSID_REPEAT = "同一个类型的证号：【%s】推送重复，请稍后再推送。谢谢";
    public static final String SHXYDM_WHSJ_NOT_NULL = "证书：%s社会信用代码不能为空";
    public static final String FZJG_WHSJ_NOT_NULL = "证书:%s发证机关不能为空";
    public static final String SHXYDM_LENGTH = "证书：%s社会信用代码需大于等于18位！";
    public static final String ZSLX_ZSBH_SHXYDM = "证书【%s】证书编号【%s】社会信用代码【%s】:";
    public static final String ZS_LX_WHSJ_NOT_FIND = ZSLX_ZSBH_SHXYDM + "没有找到对应的证书类,请联系管理员!";
    public static final String YW_LX_WHSJ_NOT_FIND = ZSLX_ZSBH_SHXYDM + "业务类型错误,请联系管理员!";
    public static final String LICENSE_ID_NOT_NULL = ZSLX_ZSBH_SHXYDM + "主键id不能为空！";
    public static final String FZRQ_WHSJ_NOT_NULL = ZSLX_ZSBH_SHXYDM + "发证日期不能为空！";
    public static final String FZRQ_WHSJ_PATTERN = ZSLX_ZSBH_SHXYDM + "发证日期格式不对【yyyy-MM-dd HH:mm:ss】";
    public static final String YXQZ_NOT_NULL = ZSLX_ZSBH_SHXYDM + "有效日期不能为空！";
    public static final String YXQZ_WHSJ_PATTERN = ZSLX_ZSBH_SHXYDM + "有效日期格式不对【yyyy-MM-dd HH:mm:ss】！";
    public static final String WHSJ_BGMX_REPEAT = ZSLX_ZSBH_SHXYDM + "变更明细信息重复推送！";
    public static final String WHSJ_BGMX_FEILD_NOT_NULL = ZSLX_ZSBH_SHXYDM + "变更明细里旧值、新值、字段名称、字段中文名称不能为空！";
    public static final String YJQXWLXSBA_ZBLIST_IS_NULL = "医疗器械网络销售备案，子表不能为空！";
    public static final String ZC_NOT_NULL = "住所不能为空！";
    public static final String QYLX_WHSJ_NOT_NULL = "企业类型不能为空";
    public static final String QYLX_WHSJ_ERROR = "企业类型有误";

}
