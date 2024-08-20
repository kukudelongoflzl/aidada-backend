package com.zulong.aidada.model.dto.app;

import com.zulong.aidada.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.web.PagedResourcesAssembler;

import java.io.Serializable;

/**
 * 查询应用请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用图标
     */
    private String appIcon;

    /**
     * 应用类型（0-得分类 1测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义 AI）
     */
    private Integer scoringStrategy;

    /**
     * 审核状态0-待审核 1-审核通过 2-审核不通过
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    /**
     * 审核者ID
     */
    private Long reviewerId;


    /**
     * 创建用户 id
     */
    private Long userId;


    /**
     * 搜索词
     */
    private String searchText;

    private int notId;

    private static final long serialVersionUID = 1L;
}