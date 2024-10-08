package org.jeecg.modules.demo.dzzz.util;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public abstract class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 系统用户授权缓存
     */
    public static final String SYS_AUTH_CACHE = "sys-authCache";

    /**
     * 参数管理 cache name
     */
    public static final String SYS_CONFIG_CACHE = "sys-config";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache name
     */
    public static final String SYS_DICT_CACHE = "sys-dict";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
    //文件上传路径前缀
    public static final String RESOURCE_PUBTEMPlATE = "PubTemplate";//证书模板附件上传前缀
    //广告附件上传前缀
    public static final String RESOURCE_SJ = "sj";//证书模板附件上传前缀
    //打印预览文件路径前缀
    public static final String RESOURCE_PRINTURL = "pdf";
    //文件表文件上传类型
    public static final String FJ_PUBTEMPlATE = "PubTemplate";//附件表类型
    
    //文件表文件上传类型
    public static final String FJ_GGFJ = "ggfj";//附件表类型
    public static final String FJ_ZCFJ = "zcfj";//附件表类型 医疗器械注册证


    //证书权限-操作类型(1:核发2:延续3:变更4:注销5:补发6:吊销7:盖章)
    public static final String CARD_PRINT_HF = "1";
    public static final String CARD_PRINT_YX = "2";
    public static final String CARD_PRINT_BG = "3";
    public static final String CARD_PRINT_ZX = "4";
    public static final String CARD_PRINT_BF = "5";
    public static final String CARD_PRINT_DX = "6";
    public static final String CARD_PRINT_GZ = "7";

    //部门层级 01：省 02：市03：区县04：所
    public static final String SYS_DEPT_LAYERCODE_PROVINCE = "01";
    public static final String SYS_DEPT_LAYERCODE_CITY = "02";
    public static final String SYS_DEPT_LAYERCODE_COUNTRY = "03";
    public static final String SYS_DEPT_LAYERCODE_PLACE = "04";


    //企业证书状态 0有效,1删除,4注销,5吊销,6取消
    public static final int CARD_STATUS_VALID = 0; //有效
    public static final int CARD_STATUS_DEL = 1; //删除
    public static final int CARD_STATUS_LOGOUT = 4; //注销
    public static final int CARD_STATUS_REVOKE = 5; //吊销
    public static final int CARD_STATUS_CANCEL = 6; //取消
    public static final int CARD_STATUS_GZ = 7; //盖章


    //企业基本信息状态
    public static final Integer GY_ENTBASEINFO_TYPE_DELETE = 1; // 企业基本信息状态，删除
    public static final Integer GY_ENTBASEINFO_TYPE_DELETE_NOT = 0; //企业基本信息状态，未删除

    //证书操作记录业务类别
    public static final Integer CZJL_YWLB_NEW = 1;//核发
    public static final Integer CZJL_YWLB_REPEAT = 2;//换发/延续
    public static final Integer CZJL_YWLB_CHANGE = 3;//变更
    public static final Integer CZJL_YWLB_CANCEL = 4;//注销
    public static final Integer CZJL_YWLB_ADD = 5;//补发
    public static final Integer CZJL_YWLB_REVOKE  = 6;//吊销
    public static final Integer CZJL_YWLB_MANDATORY  = 7;//强制维护
    public static final Integer CZJL_YWLB_QXGZ= 8;//取消盖章
    
    public static final Integer CZJL_SJLY_SJ = 2;
    
    //重复标识,配置validate remote验证
    public static final String UNIQUE = "0"; //唯一
    public static final String NOT_UNIQUE = "1"; //重复
    
    //表名称
    public static  final String TABLE_LS_ZS="t_yw_zs_ls";//证书临时表
    public static  final String TABLE_LS_ZS_CZJL="t_yw_zs_czjl_ls";//证书操作记录临时表
    public static  final String TABLE_LS_ZS_CZJLMX="t_yw_zs_czjlmx_ls";//证书操作记录明细临时表
    
    //行政审批项目类型(证书对应业务类别)
    public static final int XZSP_SERVICETYPE_NEW = 1;			//核发
    public static final int XZSP_SERVICETYPE_REPEAT = 2;		//换发
    public static final int XZSP_SERVICETYPE_CHANGE = 3;		//变更
    public static final int XZSP_SERVICETYPE_DESTORY = 4;		//注销
    public static final int XZSP_SERVICETYPE_ADD = 5;			//补发
    public static final int XZSP_SERVICETYPE_REVOKE = 6;		//吊销
    public static final int XZSP_SERVICETYPE_QZWH = 7;		    //强制维护
    //public static final int XZSP_SERVICETYPE_JZHZ = 8;			//集中换证
    
    //证书保存字段类型
    public static final String XZSP_CARDRECORD_TYPE_STRING = "1";			//字符型
    public static final String XZSP_CARDRECORD_TYPE_INTEGER = "2";			//整数型
    public static final String XZSP_CARDRECORD_TYPE_FLOAT = "3";			//数字型
    public static final String XZSP_CARDRECORD_TYPE_DATE = "4";			//时间型
    
    //子表操作类型
    public static final int CZJL_ZBCZ_ADD = 0;
    public static final int CZJL_ZBCZ_UPDATE = 1;
    public static final int CZJL_ZBCZ_REMOVE = 2;
    
    //删除状态
    public static final int NOT_DELETED = 0;
    public static final int DELETED = 1;
}
