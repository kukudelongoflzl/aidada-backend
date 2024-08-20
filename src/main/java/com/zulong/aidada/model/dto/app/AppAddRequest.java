package com.zulong.aidada.model.dto.app;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;


/**
 * 创建应用请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class AppAddRequest implements Serializable {


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



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}