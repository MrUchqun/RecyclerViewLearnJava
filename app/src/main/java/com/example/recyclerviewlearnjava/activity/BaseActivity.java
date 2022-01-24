package com.example.recyclerviewlearnjava.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewlearnjava.R;
import com.example.recyclerviewlearnjava.modul.Post;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public ArrayList<Post> getPosts(Post postOne, Post postTwo) {

        ArrayList<Post> posts = new ArrayList<Post>();

        for (int i = 1; i <= 20; i++) {
            posts.add( (i % 4 == 0) ? postTwo : postOne);
        }

        return posts;
    }

}
