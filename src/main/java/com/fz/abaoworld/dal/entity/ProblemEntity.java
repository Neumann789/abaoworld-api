package com.fz.abaoworld.dal.entity;

import java.util.Date;

public class ProblemEntity {
    private Long id;

    private String memberId;

    private String proTitle;

    private String proType;

    private String proDegree;

    private Date createTime;

    private Date modifyTime;

    private String proContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle == null ? null : proTitle.trim();
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType == null ? null : proType.trim();
    }

    public String getProDegree() {
        return proDegree;
    }

    public void setProDegree(String proDegree) {
        this.proDegree = proDegree == null ? null : proDegree.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent == null ? null : proContent.trim();
    }
}