package com.example.ass5;

import androidx.room.*;

@Entity
public class Post {
@PrimaryKey(autoGenerate = true)
private int id;
private String content;

        public Post(String content) {
        this.content = content;
        }

        public int getId() {
        return id;
        }

        public String getContent() {
        return content;
        }

        public void setId(int id) {
        this.id = id;
        }
        public void setContent(String content) {
        this.content = content;
        }
}
