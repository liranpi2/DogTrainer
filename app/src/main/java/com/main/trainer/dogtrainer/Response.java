package com.main.trainer.dogtrainer;

import java.util.List;

/**
 * Created by Spider on 11/21/2015.
 */
public class Response {


    /**
     * id : 1.0
     * question_male : תאריך תחילת אבחון
     * question_female :
     * answer : datetime
     * options :
     * reference_id : 0
     * category : תיאור הכלב
     * comment :
     */

    private List<QuestionsEntity> questions;

    public void setQuestions(List<QuestionsEntity> questions) {
        this.questions = questions;
    }

    public List<QuestionsEntity> getQuestions() {
        return questions;
    }

    public static class QuestionsEntity {
        private double id;
        private String question_male;
        private String question_female;
        private String answer;
        private String options;
        private double reference_id;
        private String category;
        private String comment;

        public void setId(double id) {
            this.id = id;
        }

        public void setQuestion_male(String question_male) {
            this.question_male = question_male;
        }

        public void setQuestion_female(String question_female) {
            this.question_female = question_female;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public void setOptions(String options) {
            this.options = options;
        }

        public void setReference_id(int reference_id) {
            this.reference_id = reference_id;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setComment(String comment) {
            this.comment = comment;
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

        public String getOptions() {
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
