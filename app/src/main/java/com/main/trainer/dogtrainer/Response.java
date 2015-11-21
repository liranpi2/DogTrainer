package com.main.trainer.dogtrainer;

import java.util.List;

/**
 * Created by Spider on 11/21/2015.
 */
public class Response {


    /**
     * question : name
     * answer : text
     */

    private List<QuestionsEntity> questions;

    public void setQuestions(List<QuestionsEntity> questions) {
        this.questions = questions;
    }

    public List<QuestionsEntity> getQuestions() {
        return questions;
    }

    public static class QuestionsEntity {
        private String question;
        private String answer;

        public void setQuestion(String question) {
            this.question = question;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
