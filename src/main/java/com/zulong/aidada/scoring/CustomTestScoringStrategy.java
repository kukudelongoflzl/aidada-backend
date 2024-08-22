package com.zulong.aidada.scoring;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zulong.aidada.model.dto.question.QuestionContentDTO;
import com.zulong.aidada.model.entity.App;
import com.zulong.aidada.model.entity.Question;
import com.zulong.aidada.model.entity.ScoringResult;
import com.zulong.aidada.model.entity.UserAnswer;
import com.zulong.aidada.model.vo.QuestionVO;
import com.zulong.aidada.service.QuestionService;
import com.zulong.aidada.service.ScoringResultService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义测评类应用评分策略
 */
@ScoringStrategyConfig(appType = 1,scoringStrategy = 0)
public class CustomTestScoringStrategy implements ScoringStrategy {
    @Resource
    private QuestionService questionService;//查题目

    @Resource
    private ScoringResultService scoringResultService;//查评分结果

    @Override
    public UserAnswer doScore(List<String> choices, App app) throws Exception {
        // 1 根据 id 查询题目和评分结果信息
        Question question = questionService.getOne(
                Wrappers.lambdaQuery(Question.class)
                        .eq(Question::getAppId, app.getId())
        );//拿到题目信息
        List<ScoringResult> scoringResultList = scoringResultService.list(
                Wrappers.lambdaQuery(ScoringResult.class)
                        .eq(ScoringResult::getAppId, app.getId())
        );//拿到评分结果信息
        //2 统计用户每个选择对应的属性个数 如 I= 10 个，E = 5 个
        Map<String, Integer> optionCount = new HashMap<>();//统计每个选项的个数
        QuestionVO questionVO = QuestionVO.objToVo(question);//将题目信息转换为VO对象
        List<QuestionContentDTO> questionContent = questionVO.getQuestionContent();
        for (int i = 0; i < questionContent.size(); i++) {
            List<QuestionContentDTO.Option> options = questionContent.get(i).getOptions();//拿到每个题目的封装选项列表信息
            int size = options.size();
            //遍历对比选项列表
            for (int j = 0; j < size; j++) {
                if (options.get(j).getKey().equals(choices.get(i))) {
                    String result = options.get(j).getResult();//拿到选项属性
                    optionCount.put(result, optionCount.getOrDefault(result, 0) + 1);//属性值加一
                }
            }
        }
        //3 遍历每种评分结果，计算那个结果的得分更高
        int maxScore = 0;
        ScoringResult scoringResultMax = scoringResultList.get(0);
        for (ScoringResult scoringResult:scoringResultList) {
            List<String> propList = JSONUtil.toList(scoringResult.getResultProp(), String.class);//拿到该结果prop
            int sum = propList.stream().mapToInt(prop -> optionCount.getOrDefault(prop, 0)).sum();//计算得到这个prop所有的字段在统计结果中的分数
            if(sum>maxScore){
                maxScore = sum;
                scoringResultMax = scoringResult;
            }
        }
        //4 返回得分最高的UserAnswer 对象
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAppId(app.getId());
        userAnswer.setAppType(app.getAppType());
        userAnswer.setScoringStrategy(app.getScoringStrategy());
        userAnswer.setChoices(JSONUtil.toJsonStr(choices));
        userAnswer.setResultId(scoringResultMax.getId());
        userAnswer.setResultName(scoringResultMax.getResultName());
        userAnswer.setResultDesc(scoringResultMax.getResultDesc());
        userAnswer.setResultPicture(scoringResultMax.getResultPicture());
        userAnswer.setResultProp(scoringResultMax.getResultProp());
        return userAnswer;
    }
}
