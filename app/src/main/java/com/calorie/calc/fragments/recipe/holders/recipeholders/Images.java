package com.calorie.calc.fragments.recipe.holders.recipeholders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Images implements Serializable{
    @SerializedName("THUMBNAIL")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("SMALL")
    @Expose
    private Small small;
    @SerializedName("REGULAR")
    @Expose
    private Regular regular;
    @SerializedName("LARGE")
    @Expose
    private Large large;
    private final static long serialVersionUID = 3467328735638421664L;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Regular getRegular() {
        return regular;
    }

    public void setRegular(Regular regular) {
        this.regular = regular;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public class Large extends ImageSize{ }

    class Regular extends ImageSize{ }

    class Small  extends ImageSize{ }

    class Thumbnail  extends ImageSize{ }

   public abstract class ImageSize implements Serializable
    {
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private long width;
        @SerializedName("height")
        @Expose
        private long height;
        private final static long serialVersionUID = -1801809870353289087L;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getWidth() {
            return width;
        }

        public void setWidth(long width) {
            this.width = width;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(long height) {
            this.height = height;
        }
    }





}