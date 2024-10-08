package org.jeecg.modules.demo.dzzz.certmulu.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ZsmlVo {
    private String key;
    private String value;
    private String title;
    private Integer qty;
    private String isgs;
    private List<?> children = new ArrayList<>();
    private String zslx;
}
