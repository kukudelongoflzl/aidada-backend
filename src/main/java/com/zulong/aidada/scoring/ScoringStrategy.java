package com.zulong.aidada.scoring;

import com.zulong.aidada.model.entity.App;
import com.zulong.aidada.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 * 应用策略模式的开发模式
 */
public interface ScoringStrategy {


    /**
     * 执行评分
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws  Exception;
}
