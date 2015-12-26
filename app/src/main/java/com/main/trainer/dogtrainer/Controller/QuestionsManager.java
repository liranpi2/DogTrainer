package com.main.trainer.dogtrainer.Controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.main.trainer.dogtrainer.Model.DogTrainerDataModel;
import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.View.Questions.Question;
import com.main.trainer.dogtrainer.View.QuestionsFactory;

import java.util.ArrayList;

/**
 * Created by Eli on 26/12/2015.
 */
public class QuestionsManager extends LinearLayout implements QuestionListener{

    private ArrayList<Question> mQuestions;
    private DogTrainerDataModel mDogTrainerDataModel;

    public QuestionsManager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        show();
    }

    public void show() {
        mDogTrainerDataModel = DogTrainerDataModel.getInstance();
        onQuestionFinish(null);
    }

    @Override
    public void onQuestionFinish(Question question) {
        clearIfNeeded(question);
        JsonData.QuestionsEntity questionData;
        if(question == null){
            questionData = mDogTrainerDataModel.getFirstQuestion();
        }else {
            questionData = mDogTrainerDataModel.getQuestionByRefId(question.getQuestionEntity());
        }
        if(questionData != null) {
            Question nextQuestion = QuestionsFactory.getQuestion(getContext(), questionData);
            addView(nextQuestion);
            nextQuestion.setListener(this);
        }
    }

    private void clearIfNeeded(Question question) {
        boolean found =false;
        ArrayList<Integer> viewsToRemove = new ArrayList<>();
        if(question !=null){
            for(int i=0;i<getChildCount();i++){
                if(found) {
                    viewsToRemove.add(i);
                }else if(question == getChildAt(i)){
                    found = true;
                }
            }
            for(int index:viewsToRemove){
                removeViewAt(index);
            }
            forceLayout();
        }
    }
}
