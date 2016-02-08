package com.main.trainer.dogtrainer.View.Questions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.R;

import java.util.List;

/**
 * Created by Spider on 2/8/2016.
 */
public class QuestionRadio  extends Question{
    private TextView mText;
    private String selected = "" ;

    public QuestionRadio(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mText = (TextView) findViewById(R.id.questionTextRadio);
        findViewById(R.id.done_button2).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                onDone(mQuestionEntity.getReference_id());
            }
        });
    }

    public static QuestionRadio create(Context context) {
        return (QuestionRadio) inflate(context, R.layout.each_list_item_radio, null);

    }

    public void setQuestionEntity(JsonData.QuestionsEntity questionsEntity) {
        super.setQuestionEntity(questionsEntity);
        mText.setText(questionsEntity.getQuestion_male());
        final List<String> options = questionsEntity.getOptions();

        if (options != null)
        {
            final LinearLayout ll = (LinearLayout) findViewById(R.id.radioLayout);

            for(int i=0;i<options.size();i++)
            {
                final int index = i;
                final RadioButton rb = new RadioButton(getContext());
                rb.setText(options.get(i));
                rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            // perform logic

                            selected = options.get(index);
                            CheckChange(ll,rb);
                        }

                    }
                });
                ll.addView(rb);

            }

        }
    }

    private void CheckChange(LinearLayout layout, RadioButton rb)
    {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof RadioButton && v != rb) {
                ((RadioButton) v).setChecked(false);
                //validate your EditText here
            }
        }

    }
}
