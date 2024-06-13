package com.example.vollylibraryexample;

import java.util.ArrayList;
import java.util.Date;

public class MyModel {
    public class Article{
        public Source source;
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public Date publishedAt;
        public String content;
    }

    public class Root{
        public String status;
        public int totalResults;
        public ArrayList<Article> articles;
    }

    public class Source{
        public String id;
        public String name;

        public Source(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Source() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}
