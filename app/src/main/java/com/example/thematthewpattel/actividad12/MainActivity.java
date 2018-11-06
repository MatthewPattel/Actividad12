package com.example.thematthewpattel.actividad12;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView vvVideoview;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        vvVideoview = findViewById(R.id.iVideoview);

        //Set Video View to Media Controller
        MediaController mcController = new MediaController(this);
        mcController.setMediaPlayer(vvVideoview);

        //Set Media Controller to Video View
        vvVideoview.setMediaController(mcController);
    }

    private void initializePlayer() {
        vvVideoview.setVideoPath("https://www.ebookfrenzy.com/android_book/movie.mp4");
        vvVideoview.start();
    }

    private void releasePlayer() {
        vvVideoview.stopPlayback();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            vvVideoview.pause();
        }
    }

}
