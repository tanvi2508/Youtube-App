package com.example.youtubeapp;

public class VideoModel {
    int image;
    String channelName;
    String video;

    public VideoModel(int image, String channelName, String video) {
        this.image = image;
        this.channelName = channelName;
        this.video = video;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
