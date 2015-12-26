package com.main.trainer.dogtrainer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

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
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(mContext,myDateListener,year,month,day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    public void setDate(View view) {
        ((Activity)mContext).showDialog(999);
    }
    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {

        // Inflating means to read the XML file that describes a layout (or GUI element) and to create the actual objects that correspond to it
        Response.QuestionsEntity item = (Response.QuestionsEntity) getItem(position);
        if (item.getAnswer().equals("datetime")) {

            // get view
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.each_list_item_datetime, parent, false);

            // inflate each_list_item_datetime view
            if (currentView != null)
            {
                calendar = Calendar.getInstance();

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                showDate(year, month+1, day);

                /*

                View.OnClickListener onSetDateClicked =  new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    try {
                         System.out.print("click");
                         android.support.v4.app.FragmentActivity fragmentActivity = (android.support.v4.app.FragmentActivity) mContext;
                         FragmentManager fm = fragmentActivity.getSupportFragmentManager();

                          fragmentActivity.showDialog(999);
                          Toast.makeText(mContext.getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                                  .show();
                    } catch (Exception ex) {
                        System.out.print("error :" + ex.getMessage());
                    }
                    }

                };
                setDate.setOnClickListener(onSetDateClicked);
                */
            }
        }
        if (item.getAnswer().equals("image"))
        {
            // get view
            //inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //currentView = inflater.inflate(R.layout.each_list_item_image, parent, false);
        }
        if (item.getAnswer().equals("combo"))
        {
            // get view
            //inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //currentView = inflater.inflate(R.layout.each_list_item_combo, parent, false);
        }
        if (item.getAnswer().equals("checkbox"))
        {
            // get view
           // inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           // currentView = inflater.inflate(R.layout.each_list_item_checkbox, parent, false);
        }
        if (item.getAnswer().equals("text"))
        {
            // get view
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.each_list_item_text, parent, false);
        }
        if (item.getAnswer().equals("radio"))
        {
            // get view
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.each_list_item_radio, parent, false);
        }

        TextView question = (TextView)currentView.findViewById(R.id.questionText);
        question.setText((item.getQuestion_male()));

        return currentView;


        /*
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
        */

    }
}

