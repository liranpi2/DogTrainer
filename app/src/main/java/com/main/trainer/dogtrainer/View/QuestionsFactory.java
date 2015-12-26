package com.main.trainer.dogtrainer.View;

import android.content.Context;

import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.View.Questions.Question;
import com.main.trainer.dogtrainer.View.Questions.QuestionText;

/**
 * Created by Eli on 26/12/2015.
 */
public class QuestionsFactory {

    public enum eQuestionsType{
        text,
        CheckBox,
        Radio,
        Date,
        Image,
        Combo
    }
    public static Question getQuestion(Context context, JsonData.QuestionsEntity questionsEntity) {
        eQuestionsType type = eQuestionsType.valueOf(questionsEntity.getAnswer());
        Question question = null;
        switch (type) {
            case text:
                question= QuestionText.create(context);
                break;
            case CheckBox:
                break;
            case Radio:
                break;
            case Date:
                break;
            case Image:
                break;
            case Combo:
                break;
        }
        question.setQuestionEntity(questionsEntity);
        return question;
    }

}
