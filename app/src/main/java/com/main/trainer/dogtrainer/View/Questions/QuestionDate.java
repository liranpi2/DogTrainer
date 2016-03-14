package com.main.trainer.dogtrainer.View.Questions;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.main.trainer.dogtrainer.Controller.MainActivity;
import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.R;

import java.util.Calendar;

/**
 * Created by Liran on 3/13/2016.
 */


public class QuestionDate extends Question {

    private TextView mText;
    private MainActivity activity;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;


    public QuestionDate(Context context, AttributeSet attrs) {
        super(context, attrs);
        activity = (MainActivity)context;

        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mText = (TextView) findViewById(R.id.questionTextDate);

        // handle set date click
        findViewById(R.id.date_button2).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                activity.ShowDialogResult(999,QuestionDate.this);
            }
        });

        // handle done click
        findViewById(R.id.done_button3).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                onDone(mQuestionEntity.getReference_id());
            }
        });
    }

    public static QuestionDate create(Context context) {
        return (QuestionDate) inflate(context, R.layout.each_list_item_datetime,null);
    }

    public void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @Override
    public void setQuestionEntity(JsonData.QuestionsEntity questionsEntity) {
        super.setQuestionEntity(questionsEntity);

        mText.setText(questionsEntity.getQuestion_male());

    }

    public void setDate(int year, int monthOfYear, int dayOfMonth) {
        //TODO: update the view
        Toast.makeText(getContext(),year + "/" + monthOfYear + "/" +dayOfMonth,Toast.LENGTH_LONG).show();
    }
}
