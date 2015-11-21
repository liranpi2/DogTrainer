package com.main.trainer.dogtrainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
       LayoutInflater inflater = (LayoutInflater) mContext
               .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // get view
        View rowView = inflater.inflate(R.layout.each_list_item,parent,false);
        Response.QuestionsEntity item = (Response.QuestionsEntity) getItem(position);

        // get view elements
        TextView question = (TextView) rowView.findViewById(R.id.questionText);
        TextView answer = (TextView) rowView.findViewById(R.id.questionType);

        // set view elements
        question.setText(item.getQuestion());
        answer.setText(item.getAnswer());

        return rowView;

    }
}

