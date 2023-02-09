package com.example.youtubeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WatchVideo extends AppCompatActivity {
    RecyclerView mRecyclerView;
    VideoModel videoModel;
    ImageView btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_video);
        mRecyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(WatchVideo.this,2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        btn=findViewById(R.id.imageView_Btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WatchVideo.this,MainActivity.class));
            }
        });


        List<VideoModel> mList = new ArrayList<>();
        videoModel = new VideoModel(R.drawable.aastha,"Aastha","6sgflRX8hPc");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.annirudh,"Aniruddhacharya ji", "ji0Hv-wMl2A");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.satsang,"Satsang","CdhiuffRHI8");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.bhakti,"Bhakthi TV","rHt-XtPiSfY");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.dekinandan,"Shri Devkinandan Thakur Ji ","zgXIUxLo61Q");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.pandit,"Pandit Pradeep Ji Mishra Sehore Wale","8SxW7oNyUzQ");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.bhakti_sangeet,"Bhakti Sangeet HDN","sFPLwBwi0cM");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.jayakishori,"JayaKishori Motivation","I_QwbiPiZNA");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.jayakishori,"Iamjayakishori","VchalV11zo8");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.sanskar_tv,"SanskarTV","f0czkWF0x1s");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.sadhna_gold,"SADHNA GOLD","kZ317I0YW64");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.saregama,"Saregama Bhakti ","5mG5n-fmvhM");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.gauri,"Gauri Gopal Tv","0Mh9iJPpSCQ");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.swami,"Swami Raghvacharya","Ll3DNQyho8E");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.bhakti_sagar,"BhaktiSagar Tv","MHNZB4q9c-c");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.shemaroo,"Shemaroo Bhakti","dnCE-kSHES0");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.t_series,"T-Series Bhakti Sagar","4k3ZRQ5Hi6c");
        mList.add(videoModel);
        videoModel = new VideoModel(R.drawable.pen,"Pen Bhakti","9SCW9BbcR_c");
        mList.add(videoModel);

        AdapterClass myAdapter = new AdapterClass(WatchVideo.this, mList);
        mRecyclerView.setAdapter(myAdapter);



    }
}