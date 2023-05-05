package com.cursos.android.cicloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer = null;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de Vida", "OnCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        mediaPlayer = MediaPlayer.create(this,R.raw.audio);
        mediaPlayer.start();
        Log.i("Ciclo de Vida", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(mediaPlayer != null){
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
        }
        Log.i("Ciclo de Vida", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(mediaPlayer!= null){
            mediaPlayer.pause();
            position = mediaPlayer.getCurrentPosition();
        }
        Log.i("Ciclo de Vida", "onPause");

    }

    @Override
    protected void onStop(){
        super.onStop();
        if(mediaPlayer!= null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Log.i("Ciclo de Vida", "onStop");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida","onRestart");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "On Destroy");
    }
}