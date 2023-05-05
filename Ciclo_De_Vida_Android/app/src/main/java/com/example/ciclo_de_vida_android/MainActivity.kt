package com.example.ciclo_de_vida_android

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("CiclodeVida", "OnCreate")
    }

    override fun onStart(){
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.music_1)
        mediaPlayer?.start()
        Log.i("CiclodeVida","OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()

        Log.i("CiclodeVida","OnResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer != null)
        position = mediaPlayer!!.currentPosition
        Log.i("CiclodeVida","OnPause")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("CiclodeVida","OnStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("CiclodeVida","OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("CiclodeVida","onDestroy")
    }
}