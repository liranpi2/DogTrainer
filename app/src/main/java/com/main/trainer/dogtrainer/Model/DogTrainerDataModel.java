package com.main.trainer.dogtrainer.Model;

import android.content.Context;

import com.main.trainer.dogtrainer.View.Questions.Question;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Eli on 26/12/2015.
 */
public class DogTrainerDataModel {

    private static DogTrainerDataModel mInstance = null;
    private JsonData mJsonData;
    private List<JsonData.QuestionsEntity> mQuestions;
    private DogTrainerDataModel(Context context, String fileName)  {
        mJsonData = new JsonData(fileName);
        mQuestions =  mJsonData.getQuestions();
    }
    public static void init(Context context, String fileName) {
        if(mInstance == null) {
            mInstance = new DogTrainerDataModel(context, fileName);
        }
    }
    public static DogTrainerDataModel getInstance() {
        return mInstance;
    }

    private JsonData.QuestionsEntity getNextQuestion(JsonData.QuestionsEntity questionsEntity) {
        boolean found =false;
        for (JsonData.QuestionsEntity curr : mQuestions) {
            if(found) {
                return curr;
            }
            if(curr == questionsEntity) {
                found = true;
            }
        }
        return null;
    }
    public JsonData.QuestionsEntity getQuestionByRefId(JsonData.QuestionsEntity questionsEntity) {
        double referenceId = questionsEntity.getReference_id();

        for(int i=0; i< mQuestions.size();i++) {
            if(mQuestions.get(i).getId() == referenceId) {
                return mQuestions.get(i);
            }
        }
        return getNextQuestion(questionsEntity);
    }

    public JsonData.QuestionsEntity getFirstQuestion() {
        if(mQuestions.size()>0) {
            return mQuestions.get(0);
        }
        return null;
    }
}
