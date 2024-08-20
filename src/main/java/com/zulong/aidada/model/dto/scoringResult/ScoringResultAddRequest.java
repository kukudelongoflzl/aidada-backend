package com.zulong.aidada.model.dto.scoringResult;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建评分结果请求
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Data
public class ScoringResultAddRequest implements Serializable {


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
     * 结果属性集合 JSON,如[I,S,T,J]
     */
    private List<String> resultProp;

    /**
     * 结果得分范围，如80，表示80以及以上的分数命中此结果
     */
    private Integer resultScoreRange;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 创建用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}