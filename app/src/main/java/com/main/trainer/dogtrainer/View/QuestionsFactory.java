package com.main.trainer.dogtrainer.View;

import android.content.Context;

import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.View.Questions.Question;
import com.main.trainer.dogtrainer.View.Questions.QuestionCheckbox;
import com.main.trainer.dogtrainer.View.Questions.QuestionText;

/**
 * Created by Eli on 26/12/2015.
 */
public class QuestionsFactory {

    public enum eQuestionsType{
        text,
        checkbox,
        radio,
        date,
        image,
        combo
    }
    public static Question getQuestion(Context context, JsonData.QuestionsEntity questionsEntity) {
        eQuestionsType type = eQuestionsType.valueOf(questionsEntity.getAnswer());
        Question question = null;
        switch (type) {
            case text:
                question= QuestionText.create(context);
                break;
            case checkbox:
                question = QuestionCheckbox.create(context);
                break;
            case radio:
                break;
            case date:
                break;
            case image:
                break;
            case combo:
                break;
        }
        question.setQuestionEntity(questionsEntity);
        return question;
    }

}
