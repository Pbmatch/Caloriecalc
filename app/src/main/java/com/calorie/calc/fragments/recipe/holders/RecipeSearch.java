package com.calorie.calc.fragments.recipe.holders;

import com.calorie.calc.fragments.recipe.holders.recipeholders.RecipeAndLinks;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipeSearch implements Serializable {
    @SerializedName("from")
    @Expose
    private long from;
    @SerializedName("to")
    @Expose
    private long to;
    @SerializedName("count")
    @Expose
    private long count;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("hits")
    @Expose
    private List<RecipeAndLinks> hits = new ArrayList<>();
    private final static long serialVersionUID = -819237844779022930L;

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<RecipeAndLinks> getHits() {
        return hits;
    }

    public void setHits(List<RecipeAndLinks> hits) {
        this.hits = hits;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public class Links implements Serializable {

        @SerializedName("next")
        @Expose
        private Next next;
        @SerializedName("self")
        @Expose
        private Self self;
        private final static long serialVersionUID = 4353973298057249860L;

        public Next getNext() {
            return next;
        }

        public void setNext(Next next) {
            this.next = next;
        }

    }
      class Self implements Serializable
    {

        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("title")
        @Expose
        private String title;
        private final static long serialVersionUID = -1428069260205269612L;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
      class Next implements Serializable {

        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("title")
        @Expose
        private String title;
        private final static long serialVersionUID = -8687100330883425731L;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
