package com.main.trainer.dogtrainer.View.Questions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.R;

/**
 * Created by Eli on 26/12/2015.
 */
public class QuestionText extends Question {

    private TextView mText;
    public QuestionText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mText = (TextView) findViewById(R.id.questionText);
        findViewById(R.id.done_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onDone(mQuestionEntity.getReference_id());
            }
        });
    }

    public static QuestionText create(Context context) {
        return (QuestionText) inflate(context, R.layout.each_list_item_text,null);
    }

    @Override
    public void setQuestionEntity(JsonData.QuestionsEntity questionsEntity) {
        super.setQuestionEntity(questionsEntity);
        mText.setText(questionsEntity.getQuestion_male());
    }
}
