package com.example.youtubeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ViewVideo extends AppCompatActivity {
    String api_key="AIzaSyCWksKBbGGRdGui4TM6zcPGSIu9om2xXKY";
    YouTubePlayerView ytPlayer;
    String video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_video);

         ytPlayer = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(ytPlayer);

        ytPlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                Bundle mBundle = getIntent().getExtras();
                if (mBundle != null) {
//                  video= ytPlayer.(mBundle.getString("video"));
                    youTubePlayer.loadVideo(mBundle.getString("video"), 0);
                }

            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ytPlayer.release();
    }

}