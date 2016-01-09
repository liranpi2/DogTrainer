package com.main.trainer.dogtrainer.Model;

import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Spider on 11/21/2015.
 */
public class JsonData {

    private Data mData;
    /**
     * id : 1.0
     * question_male : תאריך תחילת אבחון
     * question_female :
     * answer : datetime
     * options : []
     * reference_id : 0
     * category : תיאור הכלב
     * comment :
     */



    public JsonData(String fileName) {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(Environment.getExternalStorageDirectory()
                    + File.separator+"DogTrainer"+File.separator+fileName));
            mData = gson.fromJson(reader, Data.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setQuestions(List<QuestionsEntity> questions) {
        mData.questions = questions;
    }

    public List<QuestionsEntity> getQuestions() {
        return mData.questions;
    }

    private class Data{
        private List<QuestionsEntity> questions;
    }

    public static class QuestionsEntity {
        private double id;
        private String question_male;
        private String question_female;
        private String answer;
        private List<String> options;
        private double reference_id;
        private String category;
        private String comment;

        public void setId(double id) {
            this.id = id;
        }

        public double getId() {
            return id;
        }

        public String getQuestion_male() {
            return question_male;
        }

        public String getQuestion_female() {
            return question_female;
        }

        public String getAnswer() {
            return answer;
        }

        public List<String> getOptions() {
            return options;
        }

        public double getReference_id() {
            return reference_id;
        }

        public String getCategory() {
            return category;
        }

        public String getComment() {
            return comment;
        }
    }
}
