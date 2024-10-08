package org.jeecg.modules.demo.dzzz.certStatistics.util;

import java.util.HashMap;
import java.util.Map;

public class PivotResult {
    private String qylx;
    private Map<String, Integer> counts;

    public PivotResult(String qylx) {
        this.qylx = qylx;
        this.counts = new HashMap<>();
    }

    public String getQylx() {
        return qylx;
    }

    public void setQylx(String qylx) {
        this.qylx = qylx;
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }

    public void setCounts(Map<String, Integer> counts) {
        this.counts = counts;
    }

    public void addCount(String key, int value) {
        this.counts.put(key, value);
    }
}
