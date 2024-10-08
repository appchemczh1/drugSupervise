package org.jeecg.modules.demo.dzzz.homepage.entity;

public class Area {
    private String deptId;
    private String areaId;
    private String deptName;
    private String parentId;

    private String XZQH;

    // Getters and Setters


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getXZQH() {
        return XZQH;
    }

    public void setXZQH(String XZQH) {
        this.XZQH = XZQH;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}