package com.main.trainer.dogtrainer.Model;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

/**
 * Created by Spider on 11/21/2015.
 */
public class DogTrainerApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        DogTrainerDataModel.init(this, "trainer.json");

    }


}
