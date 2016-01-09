package com.main.trainer.dogtrainer.Controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.gson.Gson;
import com.main.trainer.dogtrainer.Model.DogTrainerDataModel;
import com.main.trainer.dogtrainer.R;
import com.main.trainer.dogtrainer.Model.JsonData;
import com.main.trainer.dogtrainer.View.Questions.Question;
import com.main.trainer.dogtrainer.View.QuestionsFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private static final int LOCAL_REQ_OPEN = 5 ;
    private static final int DRIVE_REQ_OPEN = 1 ;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.err.println("Liran Activity - onCreate()");
        setContentView(R.layout.activity_main);

       /* mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Drive.API)
                .addScope(Drive.SCOPE_FILE)
                .addScope(Drive.SCOPE_APPFOLDER) // required for App Folder sample
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        */



//        Button btnLoad = (Button) findViewById(R.id.button_id);
//        View.OnClickListener oclbtnLoad = new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {

//                try
//                {
//                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                    Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
//                            + "/myFolder/");
//                    intent.setDataAndType(uri, "application/json");
//                    startActivityForResult(Intent.createChooser(intent, "Open storage"), LOCAL_REQ_OPEN);
//                }
//                catch (Exception ex)
//                {
//                    System.out.print("error :" +ex.getMessage());
//                }
//            }
//        };
//        btnLoad.setOnClickListener(oclbtnLoad);
        //datePickerView = new DateView(MainActivity.this);

    }

    // open folder result
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode)
//        {
//            case LOCAL_REQ_OPEN:
//                try
//                {
//                    ListView listview = (ListView) findViewById(R.id.questionlist);
//                    JsonData responseObj;
//                    CustomAdapter adapter;
//                    Gson gson;
//
//                    Uri uri = data.getData();
//                    String content = getFileContent(uri.getPath());
//
//                    gson = new Gson();
//                    responseObj = gson.fromJson(content, JsonData.class);
//                    adapter = new CustomAdapter(responseObj.getQuestions(),MainActivity.this);
//                    listview.setAdapter(adapter);
//                }
//                catch (Exception ex)
//                {
//                    System.out.println("error: "+ex.getMessage());
//                }
//                break;
//
//            case DRIVE_REQ_OPEN:
//                String clientID = "352195573043-m0bk67mq00iktd62rsjblrj800lkq0q5.apps.googleusercontent.com";
//                if (resultCode == RESULT_OK)
//                {
//                    DriveId driveId = data.getParcelableExtra(
//                            OpenFileActivityBuilder.EXTRA_RESPONSE_DRIVE_ID);
//                }
//                break;
//
//        }
//
//    }
//    private String getFileContent(String path) {
//        File sdcard = Environment.getExternalStorageDirectory();
//
//        //Get the text file
//        File file = new File(path);
//
//        //Read text from file
//        StringBuilder text = new StringBuilder();
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                text.append(line);
//                text.append('\n');
//            }
//            br.close();
//        } catch (IOException e) {
//            //You'll need to add proper error handling here
//        }
//        return text.toString();
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.err.println("Liran Activity - onReStart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.err.println("Liran Activity - onStart()");
       //mGoogleApiClient.connect();
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


//    @Override
//    public void onConnected(Bundle bundle) {
//        try
//        {
//
//            IntentSender i = Drive.DriveApi
//                    .newOpenFileActivityBuilder()
//                    .setMimeType(new String[] { "text/plain", "text/html" })
//                    .build(mGoogleApiClient);
//
//            startIntentSenderForResult(i,DRIVE_REQ_OPEN,null,0,0,0);
//        }
//        catch (IntentSender.SendIntentException e)
//        {
//            Log.w("test", "Unable to send intent", e);
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
////        Log.w("test", "Unable to connect", i);
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//        System.out.println("connection failed");
//
//    }

}

