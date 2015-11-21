package com.main.trainer.dogtrainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Spider on 11/21/2015.
 */
public class CustomAdapter extends BaseAdapter {

    private List<Response.QuestionsEntity> questionItems;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapter(List<Response.QuestionsEntity> questionItems, Context mContext) {
        this.questionItems = questionItems;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return questionItems.size();
    }

    @Override
    public Object getItem(int position) {
        return questionItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        if(currentView ==null) {
            // Inflating means to read the XML file that describes a layout (or GUI element) and to create the actual objects that correspond to it
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // get view
            currentView = inflater.inflate(R.layout.each_list_item, parent, false);
        }

        Response.QuestionsEntity item = (Response.QuestionsEntity) getItem(position);

        LinearLayout ll = (LinearLayout)currentView.findViewById(R.id.linearLayout2);

        // set question
        TextView question = new TextView(mContext);
        question.setText(item.getQuestion());
        ll.addView(question);

        // set answer by type
        switch (item.getAnswer())
        {
            case "text":
                // create textbox
                EditText et = new EditText(mContext);
                et.setText(item.getAnswer());
                ll.addView(et);
                break;

            case "radio":
                // create radio button
                final RadioButton[] rb = new RadioButton[5];
                RadioGroup rg = new RadioGroup(mContext); //create the RadioGroup
                rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
                for(int i=0; i<2; i++){
                    rb[i]  = new RadioButton(mContext);
                    rb[i].setText(item.getAnswer() + i);
                    rb[i].setId(i);
                    rg.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout

                }
                ll.addView(rg);//you add the whole RadioGroup to the layout
                break;
        }
        return currentView;

    }
}

