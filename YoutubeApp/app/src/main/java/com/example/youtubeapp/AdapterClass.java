package com.example.youtubeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    Context context;
    List<VideoModel> videoModelList;

    public AdapterClass(Context context, List<VideoModel> videoModelList) {
        this.context = context;
        this.videoModelList = videoModelList;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_layout, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        holder.chanelText.setText(videoModelList.get(position).getChannelName());
        holder.imageView.setImageResource(videoModelList.get(position).getImage());

        holder.viewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ViewVideo.class);
                intent.putExtra("video", videoModelList.get(holder.getAdapterPosition()).getVideo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView chanelText,viewVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_logo);
            chanelText = itemView.findViewById(R.id.tvTitle);
            viewVideo=itemView.findViewById(R.id.view_btn);

        }
    }
}
