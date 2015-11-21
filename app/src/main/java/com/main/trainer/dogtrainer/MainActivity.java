package com.main.trainer.dogtrainer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.err.println("Liran Activity - onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.err.println("Liran Activity - onReStart()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.err.println("Liran Activity - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.err.println("Liran Activity - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.err.println("Liran Activity - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.err.println("Liran Activity - onStop()");
    }

    @Override
    public void finish() {
        super.finish();
        System.err.println("Liran Activity - finish()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.err.println("Liran Activity - onDestroy()");
    }
}
