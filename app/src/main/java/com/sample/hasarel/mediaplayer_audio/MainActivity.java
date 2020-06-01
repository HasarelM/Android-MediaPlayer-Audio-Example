package com.sample.hasarel.mediaplayer_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Ui Components
    private Button mBtnStart,mBtnPause,mBtnStop;
    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        try{

            audio.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3");

            audio.prepare();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private void initView() {
        mBtnPause = findViewById(R.id.main_activity_btn_pause);
        mBtnStart = findViewById(R.id.main_activity_btn_start);
        mBtnStop = findViewById(R.id.main_activity_btn_stop);
        mBtnStop.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_activity_btn_start:
                audio.start();
                break;
            case R.id.main_activity_btn_pause:
                audio.pause();
                break;
            case R.id.main_activity_btn_stop:
                audio.stop();
                break;
            default:
                break;
        }
    }
}