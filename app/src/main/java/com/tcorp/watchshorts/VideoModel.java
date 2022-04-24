package com.tcorp.watchshorts;

public class VideoModel {
        private String id;
        private String title;

        private String imgUrl;

    public VideoModel() {
    }

    public VideoModel(String id, String title) {
        this.id = id;
        this.title = title;

    }

    public VideoModel(String id, String title, String imgUrl) {
        this.id = id;
        this.title = title;

        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
