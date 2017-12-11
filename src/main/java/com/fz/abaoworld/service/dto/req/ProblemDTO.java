package com.fz.abaoworld.service.dto.req;

import java.util.Date;

public class ProblemDTO {
	
    private String memberId;

    private String proTitle;

    private String proType;

    private String proDegree;

    private String proContent;
    
    private String tagIds;
    
    private String proId;

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

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent == null ? null : proContent.trim();
    }

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}


    
    

}
