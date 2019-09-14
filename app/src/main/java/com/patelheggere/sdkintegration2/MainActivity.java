package com.patelheggere.sdkintegration2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oustme.oustsdk.interfaces.common.OustLoginCallBack;
import com.oustme.oustsdk.launcher.OustAuthData;
import com.oustme.oustsdk.launcher.OustExceptions.OustException;
import com.oustme.oustsdk.launcher.OustLauncher;
import com.oustme.oustsdk.launcher.OustNotificationConfig;
import com.oustme.oustsdk.launcher.PushNotificationType;


public class MainActivity extends AppCompatActivity implements OustLoginCallBack {
    private static final String TAG = "MainActivity";
    private Button mOustButton;
    private TextView mTextViewProgress;
    private TextView textViewHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHtml = findViewById(R.id.textViewHtml);
        textViewHtml.setText("");

        mOustButton = findViewById(R.id.oustButton);
        mTextViewProgress = findViewById(R.id.progress);
        mOustButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OustAuthData oustAuthData = new OustAuthData();
                oustAuthData.setOrgId("uat");
                oustAuthData.setUsername("chqtest1");

                OustNotificationConfig notificationConfig = new OustNotificationConfig();
                notificationConfig.setPushNotificationType(PushNotificationType.FCM);
                notificationConfig.setToken("your FCM Token");
                notificationConfig.setServerKey("Your server Key");
                try {
                    OustLauncher.getInstance().launch(MainActivity.this, oustAuthData, notificationConfig, MainActivity.this);
                } catch (OustException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onStartDownloadingResourses() {

    }

    @Override
    public void onProgressChanged(int i) {
        Log.d(TAG, "onProgressChanged: "+i);
        mTextViewProgress.setText("progess: "+i);
    }

    @Override
    public void onError(String s) {
        Log.d(TAG, "onError: "+s);
    }


    @Override
    public void onLoginError(String s) {

    }

    @Override
    public void onLoginProcessStart() {

    }

    @Override
    public void onLoginSuccess(boolean b) {

    }

    @Override
    public void onNetworkError() {

    }

}
