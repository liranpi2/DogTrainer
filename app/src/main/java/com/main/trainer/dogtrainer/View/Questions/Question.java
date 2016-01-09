package com.main.trainer.dogtrainer.View.Questions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.main.trainer.dogtrainer.Controller.QuestionListener;
import com.main.trainer.dogtrainer.Controller.QuestionsManager;
import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.R;

/**
 * Created by Eli on 26/12/2015.
 */
public abstract class Question extends RelativeLayout{
    protected Context context;
    private QuestionListener mListener;
    protected JsonData.QuestionsEntity mQuestionEntity;

    public Question(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public JsonData.QuestionsEntity getQuestionEntity() {
        return mQuestionEntity;
    }

    public void setQuestionEntity(JsonData.QuestionsEntity questionsEntity) {
        mQuestionEntity = questionsEntity;
    }


    public void setListener(QuestionListener questionListener) {
        mListener =questionListener;
    }

    protected void onDone(double referenceId) {
        mListener.onQuestionFinish( this);
    }
}
