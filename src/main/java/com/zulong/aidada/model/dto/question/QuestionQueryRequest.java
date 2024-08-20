package com.zulong.aidada.model.dto.question;

import com.zulong.aidada.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询题目请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 题目内容
     */
    private String questionContent;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * id
     */
    private int notId;
    private static final long serialVersionUID = 1L;
}