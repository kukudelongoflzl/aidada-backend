package com.zulong.aidada.model.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 题目封装类
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionContentDTO {


    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目选项列表  比如一个题目常见的有四个选项
     */
    private List<Option> options;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option{
        private String result;//对应测评类应用，选某个选项对应 I F T J 标签
        private int score;//对应的分类应用，选某个选项得分记录在这
        private String value;//每个选项对应的描述 比如A选项：是的
        private String key;//A B C D选项

    }
}