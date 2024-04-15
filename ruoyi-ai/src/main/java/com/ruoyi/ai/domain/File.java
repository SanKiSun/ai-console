package com.ruoyi.ai.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * file对象 file
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public class File extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会话ID */
    @Excel(name = "会话ID")
    private Long sessionId;

    /** 场景用户ID */
    @Excel(name = "场景用户ID")
    private String sceneUserId;

    /** 文件名 */
    @Excel(name = "文件名")
    private String filename;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String contentType;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long size;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date created;

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
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setContentType(String contentType) 
    {
        this.contentType = contentType;
    }

    public String getContentType() 
    {
        return contentType;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
            .append("sessionId", getSessionId())
            .append("sceneUserId", getSceneUserId())
            .append("filename", getFilename())
            .append("contentType", getContentType())
            .append("size", getSize())
            .append("id", getId())
            .append("created", getCreated())
            .toString();
    }
}
