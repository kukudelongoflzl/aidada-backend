package com.zulong.aidada.scoring;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 执行配置注解
 *
 * @author <a href="https://github.com/kukudelong">黎祖龙</a>
 *  
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ScoringStrategyConfig {

    /**
     * 应用类型 0 测评  1得分
     *
     * @return
     */
   int appType();
    /**
     * 评分策略 0自定义 1AI
     */
    int scoringStrategy();
}

