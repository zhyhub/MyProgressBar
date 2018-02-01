package com.zhy.MyProgressBar;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.zhy.progressbar.HProgressbar;
import com.zhy.progressbar.RProgressbar;

public class MainActivity extends AppCompatActivity {

    private HProgressbar progress;
    private HProgressbar progress1;
    private HProgressbar progress2;

    private RProgressbar progress3;
    private RProgressbar progress4;

    private static final int MSG_UPDATE = 0x110;
    private static final int MSG1_UPDATE = 0x120;
    private static final int MSG2_UPDATE = 0x130;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int prg = progress.getProgress();
            progress.setProgress(++prg);
            progress4.setProgress(++prg);
            progress3.setProgress(++prg);
            if(prg >= 100){
                handler.removeMessages(MSG_UPDATE);
            }
            handler.sendEmptyMessageDelayed(MSG_UPDATE,100);
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int prg = progress1.getProgress();
            progress1.setProgress(++prg);
            if(prg >= 100){
                handler1.removeMessages(MSG1_UPDATE);
            }
            handler1.sendEmptyMessageDelayed(MSG1_UPDATE,100);
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int prg = progress2.getProgress();
            progress2.setProgress(++prg);
            if(prg >= 100){
                handler2.removeMessages(MSG2_UPDATE);
            }
            handler2.sendEmptyMessageDelayed(MSG2_UPDATE,100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.id1);
        progress1 = findViewById(R.id.id2);
        progress2 = findViewById(R.id.id3);
        progress3 = findViewById(R.id.id4);
        progress4 = findViewById(R.id.id5);
        AppCompatButton button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(MSG_UPDATE);
                handler1.sendEmptyMessage(MSG1_UPDATE);
                handler2.sendEmptyMessage(MSG2_UPDATE);
            }
        });
    }
}
