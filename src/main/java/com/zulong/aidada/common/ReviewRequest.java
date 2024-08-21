package com.zulong.aidada.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用审核请求
 *
 * @param <T>
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class ReviewRequest<T> implements Serializable {

    /**
     * 审核的app
     */
    private Long appId;


    /**
     * 审核的状态
     */
    private Integer reviewStatus;

    /**
     * 审核的信息
     */
    private String reviewMessage;

    private static final long serialVersionUID = 1L;
}
