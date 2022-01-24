package com.example.recyclerviewlearnjava.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.example.recyclerviewlearnjava.R;
import com.example.recyclerviewlearnjava.adapter.MultipleAdapter;
import com.example.recyclerviewlearnjava.modul.Post;

public class CustomMultipleActivity extends BaseActivity {

    private Context context;
    private RecyclerView recyclerView;
    MultipleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_multiple);
        initView();
        refreshAdapter();
    }

    Post postOne = new Post(R.drawable.im_post_3,
            "feruza_karimova",
            R.drawable.im_post_2,
            455,
            "Ha ha ha ha ...",
            false
    );

    Post postTwo = new Post(R.drawable.im_post_4,
            "ibrat_mirzayev",
            Uri.parse("android.resource://com.example.recyclerviewlearnjava/raw/video_post_2"),
            800,
            "Zo'r zo'r zo'r ...",
            true
    );

    private void refreshAdapter() {
        adapter = new MultipleAdapter(context, getPosts(postOne, postTwo));
        recyclerView.setAdapter(adapter);
    }

    private void loadingMore(){
        adapter.addLoadMore(getPosts(postOne, postTwo));
    }

    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.view_recycler_multiple);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (! recyclerView.canScrollVertically(1)){
                    loadingMore();
                }
            }
        });
    }
}