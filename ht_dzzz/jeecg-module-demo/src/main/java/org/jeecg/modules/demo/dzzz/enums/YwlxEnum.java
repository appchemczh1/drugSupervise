package org.jeecg.modules.demo.dzzz.enums;

import lombok.Data;

import org.jeecg.common.util.StringUtils;

public enum YwlxEnum {

    /** 业务类型：1-核发，2-换发/延续，3-变更，4-注销，5-补发，6-人工维护，7-强制维护**/
    HEFA("1", "核发"),
    HUANFA ("2", "换发/延续"),
    BIANGE("3", "变更"),
    ZHUXIAO("4", "注销"),
    BUFA("5", "补发"),
    RGWH("6", "人工维护"),
    QZWH("7", "强制维护");

    private String code;
    private String name;

    YwlxEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取业务类型描述
     * @param code
     * @return
     */
    public static String getYwlxName(String code) {
        for (YwlxEnum ywlx : values()) {
            if (ywlx.getCode().equals(code)) {
                return ywlx.getName();
            }
        }
        return "";
    }

    public static YwlxEnum byCode(String code) {
        for (YwlxEnum item : values()) {
            if (StringUtils.equalsIgnoreCase(code, item.getCode())) return item;
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
