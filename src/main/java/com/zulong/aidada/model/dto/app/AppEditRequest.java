package com.zulong.aidada.model.dto.app;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 编辑应用请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class AppEditRequest implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    private static final long serialVersionUID = 1L;
}