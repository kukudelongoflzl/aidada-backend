package com.zulong.aidada.model.dto.userAnswer;

import com.zulong.aidada.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询用户答案请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAnswerQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 应用类型（0-得分类 1测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义 AI）
     */
    private Integer scoringStrategy;

    /**
     * 用户答案（JSON）
     */
    private List<String> choices;

    /**
     * 评分结果ID
     */
    private Long resultId;

    /**
     * 结果名称，如物流师
     */
    private String resultName;

    /**
     * 结果描述
     */
    private String resultDesc;

    /**
     * 结果图片
     */
    private String resultPicture;


    /**
     * 结果得分范围，如80，表示80以及以上的分数命中此结果
     */
    private Integer resultScore;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * id
     */
    private Long notId;

    /**
     * 搜索词
     */
    private String searchText;
    private static final long serialVersionUID = 1L;
}