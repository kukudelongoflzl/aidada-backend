package com.zulong.aidada.scoring;


import com.zulong.aidada.common.ErrorCode;
import com.zulong.aidada.exception.BusinessException;
import com.zulong.aidada.model.entity.App;
import com.zulong.aidada.model.entity.UserAnswer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判题执行器
 */
@Service
public class ScoringStrategyExecutor {

    @Resource
    private List<ScoringStrategy> scoringStrategyList;

    /**
     * 根据传入的选项列表和应用对象，执行评分策略并返回用户答案
     *
     * @param choiceList 选项列表
     * @param app        应用对象
     * @return 用户答案
     * @throws Exception 异常
     */
    public UserAnswer doScore(List<String> choiceList, App app) throws Exception {
        // 获取应用类型和评分策略
        Integer appType = app.getAppType();
        Integer scoringStrategy = app.getScoringStrategy();
        // 如果应用类型或评分策略为空，抛出参数错误异常
        if (appType == null || scoringStrategy == null)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "应用配置有无，未找到匹配的策略");

        // 根据注解获取策略
        for (ScoringStrategy strategy : scoringStrategyList) {
            // 如果策略类上有ScoringStrategyConfig注解
            if (strategy.getClass().isAnnotationPresent(ScoringStrategyConfig.class)) {

                // 获取注解
                ScoringStrategyConfig scoringStrategyConfig = strategy.getClass().getAnnotation(ScoringStrategyConfig.class);
                // 如果注解中的应用类型和评分策略与传入的应用类型和评分策略相匹配
                if (scoringStrategyConfig.appType() == appType && scoringStrategyConfig.scoringStrategy() == scoringStrategy) {
                    // 找到匹配注解，执行评分策略
                    return strategy.doScore(choiceList, app);
                }
            }
        }
        // 如果没有找到匹配的策略，抛出系统错误异常
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
    }
}
