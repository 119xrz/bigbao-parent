package com.bigbao.data.beans;

import java.io.Serializable;
import java.util.Date;

public class HistoryBean implements Serializable {

    private static final long serialVersionUID = -5767302001444238912L;
    private Long id;

    private String keyword;

    private Integer riskLevel;

    private Integer nodeCount;

    private Integer riskNodeCount;

    private Integer hitRuleCount;

    private String selector;

    private Date selectDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }

    public Integer getRiskNodeCount() {
        return riskNodeCount;
    }

    public void setRiskNodeCount(Integer riskNodeCount) {
        this.riskNodeCount = riskNodeCount;
    }

    public Integer getHitRuleCount() {
        return hitRuleCount;
    }

    public void setHitRuleCount(Integer hitRuleCount) {
        this.hitRuleCount = hitRuleCount;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public Date getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(Date selectDate) {
        this.selectDate = selectDate;
    }

    @Override
    public String toString() {
        return "HistoryBean{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", riskLevel=" + riskLevel +
                ", nodeCount=" + nodeCount +
                ", riskNodeCount=" + riskNodeCount +
                ", hitRuleCount=" + hitRuleCount +
                ", selector='" + selector + '\'' +
                ", selectDate=" + selectDate +
                '}';
    }
}
