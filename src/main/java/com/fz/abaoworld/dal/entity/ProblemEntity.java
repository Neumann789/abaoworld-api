package com.fz.abaoworld.dal.entity;

import java.util.Date;
import java.util.List;

public class ProblemEntity {
    private Long id;

    private String memberId;

    private String proTitle;

    private String proType;

    private String proDegree;

    private Date createTime;

    private Date modifyTime;

    private String proContent;
    
    /**
     * 问题来源
     */
    private String source;
    
    /**
     * 标签集
     */
    private String tagIds;
    
    private List<TagEntity> tagList;
    
    /**
     * 浏览次数
     */
    private Long visitCount;
    
    /**
     * 点赞数
     */
    private Long agreeCount;
    
    /**
     * 评论数
     */
    private Long commentCount;
    
    /**
     * 问题状态
     */
    private String proStatus;
    
    /**
     * 积分数
     */
    private Long proPoint;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public List<TagEntity> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagEntity> tagList) {
		this.tagList = tagList;
	}

	public Long getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Long visitCount) {
		this.visitCount = visitCount;
	}

	public Long getAgreeCount() {
		return agreeCount;
	}

	public void setAgreeCount(Long agreeCount) {
		this.agreeCount = agreeCount;
	}

	public String getProStatus() {
		return proStatus;
	}

	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}

	public Long getProPoint() {
		return proPoint;
	}

	public void setProPoint(Long proPoint) {
		this.proPoint = proPoint;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	
    
}