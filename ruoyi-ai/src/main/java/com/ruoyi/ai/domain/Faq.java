package com.ruoyi.ai.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * FAQ管理对象 faq
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Faq extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID", type = Type.EXPORT)
    private Long id;

    /** 会话ID */
    @Excel(name = "会话ID")
    private Long sessionId;

    /** 场景用户ID */
    @Excel(name = "场景用户ID")
    private String sceneUserId;

    /** 问题 */
    @Excel(name = "问题")
    private String question;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date created;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSessionId(Long sessionId) 
    {
        this.sessionId = sessionId;
    }

    public Long getSessionId() 
    {
        return sessionId;
    }
    public void setSceneUserId(String sceneUserId) 
    {
        this.sceneUserId = sceneUserId;
    }

    public String getSceneUserId() 
    {
        return sceneUserId;
    }
    public void setQuestion(String question) 
    {
        this.question = question;
    }

    public String getQuestion() 
    {
        return question;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setCreated(Date created) 
    {
        this.created = created;
    }

    public Date getCreated() 
    {
        return created;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sessionId", getSessionId())
            .append("sceneUserId", getSceneUserId())
            .append("question", getQuestion())
            .append("answer", getAnswer())
            .append("created", getCreated())
            .toString();
    }
}
