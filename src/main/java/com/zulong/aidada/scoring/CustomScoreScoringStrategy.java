package com.zulong.aidada.scoring;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zulong.aidada.common.ErrorCode;
import com.zulong.aidada.exception.BusinessException;
import com.zulong.aidada.model.dto.question.QuestionContentDTO;
import com.zulong.aidada.model.entity.*;
import com.zulong.aidada.model.vo.QuestionVO;
import com.zulong.aidada.service.QuestionService;
import com.zulong.aidada.service.ScoringResultService;

import javax.annotation.Resource;
import java.util.List;

@ScoringStrategyConfig(appType = 0,scoringStrategy = 0)
public class CustomScoreScoringStrategy implements ScoringStrategy {

    @Resource
    private QuestionService questionService;

    @Resource
    private ScoringResultService scoringResultService;

    @Override
    public UserAnswer doScore(List<String> choices, App app) throws Exception {
        //1 根据 id 查询题目和评分结果信息(按分数降序排序)
        Long appId = app.getId();
        Question question = questionService.getOne(
                Wrappers.lambdaQuery(Question.class)
                        .eq(Question::getAppId, appId)
        );
        List<ScoringResult> scoringResultList = scoringResultService.list(
                Wrappers.lambdaQuery(ScoringResult.class)
                        .eq(ScoringResult::getAppId, appId)
                        .orderByDesc(ScoringResult::getResultScoreRange)//按分数降序
        );
        //2 统计用户每个选择对应的属性个数 如 I= 10 个，E = 5 个
        QuestionVO questionVO = QuestionVO.objToVo(question);
        List<QuestionContentDTO> questionContent = questionVO.getQuestionContent();//封装的题目信息，每一个元素是一道题
        int totalScore = 0;
        int size = questionContent.size();
        if (choices.size() != size)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "答案个数与题目总数不匹配");
        for (int i = 0; i < size; i++) {
            List<QuestionContentDTO.Option> options = questionContent.get(i).getOptions();
            for (QuestionContentDTO.Option option : options) {
                if (option.getKey().equals(choices.get(i))) {
                    totalScore += option.getScore();
                }
            }
        }
        //3 遍历评分结果，第一个用户分数分数大于的范围i结果，作为最终结果
        ScoringResult scoringResultMax = scoringResultList.get(0);
        for (ScoringResult scoringResult : scoringResultList) {
            if (scoringResult.getResultScoreRange() <= totalScore) {
                scoringResultMax = scoringResult;
                break;
            }
        }
        //4 返回得分最高的UserAnswer 对象
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAppId(appId);
        userAnswer.setAppType(app.getAppType());
        userAnswer.setScoringStrategy(app.getScoringStrategy());
        userAnswer.setChoices(JSONUtil.toJsonStr(choices));
        userAnswer.setResultId(scoringResultMax.getId());
        userAnswer.setResultName(scoringResultMax.getResultName());
        userAnswer.setResultDesc(scoringResultMax.getResultDesc());
        userAnswer.setResultPicture(scoringResultMax.getResultPicture());
        userAnswer.setResultProp(scoringResultMax.getResultProp());
        userAnswer.setResultScore(scoringResultMax.getResultScoreRange());
        return userAnswer;
    }
}
