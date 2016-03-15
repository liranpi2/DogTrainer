package com.main.trainer.dogtrainer.View.Questions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.main.trainer.dogtrainer.R;

import com.main.trainer.dogtrainer.Model.JsonData;

import java.util.List;



public class QuestionCheckbox extends Question {

    private TextView mText;
    private String selected = "" ;
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
        final List<String> options = questionsEntity.getOptions();

        if (options != null)
        {
            final LinearLayout ll = (LinearLayout) findViewById(R.id.checkboxLayout);

            for(int i=0;i<options.size();i++)
            {
              final int index = i;
                final CheckBox cb = new CheckBox(getContext());
                cb.setText(options.get(i));
                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            // perform logic

                            selected = options.get(index);
                            CheckChange(ll, cb);
                        }

                    }
                });
                cb.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

                ll.addView(cb);

            }

        }
    }

    private void CheckChange(LinearLayout layout, CheckBox cb)
    {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof CheckBox && v != cb) {
                ((CheckBox) v).setChecked(false);
                //validate your EditText here
            }
        }

    }
}
