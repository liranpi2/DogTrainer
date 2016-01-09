package com.main.trainer.dogtrainer.View.Questions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.main.trainer.dogtrainer.R;

import com.main.trainer.dogtrainer.Model.JsonData;

import java.util.List;

/**
 * Created by Spider on 1/9/2016.
 */
public class QuestionCheckbox extends Question {

    private TextView mText;

    public QuestionCheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mText = (TextView) findViewById(R.id.questionTextCheckbox);
        findViewById(R.id.done_button1).setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
               onDone(mQuestionEntity.getReference_id());
           }
        });
    }

    public static QuestionCheckbox create(Context context) {
        return (QuestionCheckbox) inflate(context, R.layout.each_list_item_checkbox, null);

    }

    @Override
    public void setQuestionEntity(JsonData.QuestionsEntity questionsEntity) {
        super.setQuestionEntity(questionsEntity);
        mText.setText(questionsEntity.getQuestion_male());
        List<String> options = questionsEntity.getOptions();

        if (options != null)
        {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
            checkBox1.setText(options.get(0));
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
            checkBox2.setText(options.get(1));
        }
    }
}
