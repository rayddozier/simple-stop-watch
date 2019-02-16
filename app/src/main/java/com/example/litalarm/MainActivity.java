package com.example.litalarm;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView plainText; //sets variable for plaintext which user enters
    TextView textView;
    MediaPlayer mediaPlayer;



    public void select(View view) {

        plainText = findViewById(R.id.editText);//why is this necessary for activity to run
        textView = findViewById(R.id.textView);
        mediaPlayer = new MediaPlayer().create(this, R.raw.alarm);
        try{
            int time = Integer.parseInt(plainText.getText().toString());


            int milliSecond = time * 1000;
            //value is needed in milliseconds so we convert value into milliseconds
            new CountDownTimer(milliSecond,1000) {//1000ms is 1 second

                @Override
                public void onTick(long millisUnitFinished) {
                    textView.setText("0.0" +String.valueOf(millisUnitFinished/1000));

                }

                public void onFinish() {
                textView.setText("Times Up!");
                mediaPlayer.start();



                }


            }.start();



        }catch (NumberFormatException e) {
            Toast.makeText(this, "Enter Value in integer Only",Toast.LENGTH_LONG).show();
        }

    }


    public void stop(View view) {
        mediaPlayer.stop();
    }
    @Override  //overide command basically overides the mainactivity externsion from mainactivity class so that it can run its own methods without
    //essentially being bound by main activity classes extension
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
