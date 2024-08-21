package com.zulong.aidada.model.dto.userAnswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新用户答案请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class UserAnswerUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;


    /**
     * 选项
     */
    private List<String> choices;

    private static final long serialVersionUID = 1L;
}