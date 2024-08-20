package com.zulong.aidada.model.dto.userAnswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建用户答案请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class UserAnswerAddRequest implements Serializable {


    /**
     * 应用ID
     */
    private Long appId;


    /**
     * 用户答案（JSON）
     */
    private List<String> choices;


    private static final long serialVersionUID = 1L;
}