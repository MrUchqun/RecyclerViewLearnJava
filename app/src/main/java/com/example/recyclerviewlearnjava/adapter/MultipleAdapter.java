package com.example.recyclerviewlearnjava.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlearnjava.R;
import com.example.recyclerviewlearnjava.modul.Post;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Post> posts;

    private final int ITEM_VIEW_TYPE_IMAGE = 0;
    private final int ITEM_VIEW_TYPE_VIDEO = 1;
    private final int ITEM_VIEW_TYPE_FOOTER = 2;

    public MultipleAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM_VIEW_TYPE_IMAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_post, parent, false);
            return new BaseAdapter.ImagePostViewHolder(view);
        }

        if (viewType == ITEM_VIEW_TYPE_VIDEO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_post, parent, false);
            return new BaseAdapter.VideoPostViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
        return new BaseAdapter.FooterViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = posts.get(position);

        if (holder instanceof BaseAdapter.ImagePostViewHolder) {
            ((BaseAdapter.ImagePostViewHolder) holder).profile.setImageResource(post.getProfile());
            ((BaseAdapter.ImagePostViewHolder) holder).userName.setText(post.getUserName());
            ((BaseAdapter.ImagePostViewHolder) holder).post.setImageResource(post.getResource());
            ((BaseAdapter.ImagePostViewHolder) holder).postText.setText(post.getPostText());
            ((BaseAdapter.ImagePostViewHolder) holder).profileSmile.setImageResource(post.getProfile());

            TextView countLikes = ((BaseAdapter.ImagePostViewHolder) holder).countLikes;
            countLikes.setText(post.getCountLikes() + " likes");

            ImageView like = ((BaseAdapter.ImagePostViewHolder) holder).favorite;

            ((BaseAdapter.ImagePostViewHolder) holder).viewFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (like.getVisibility() == View.INVISIBLE) {
                        countLikes.setText(post.getCountLikes() + 1 + " likes");
                        like.setVisibility(View.VISIBLE);
                    } else {
                        countLikes.setText(post.getCountLikes() + " likes");
                        like.setVisibility(View.INVISIBLE);
                    }

                }
            });

            ImageView bookmark = ((BaseAdapter.ImagePostViewHolder) holder).bookmark;

            ((BaseAdapter.ImagePostViewHolder) holder).viewBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bookmark.setVisibility((bookmark.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE);
                }
            });
        }

        if (holder instanceof BaseAdapter.VideoPostViewHolder) {
            ((BaseAdapter.VideoPostViewHolder) holder).profile.setImageResource(post.getProfile());
            ((BaseAdapter.VideoPostViewHolder) holder).userName.setText(post.getUserName());
            ((BaseAdapter.VideoPostViewHolder) holder).postText.setText(post.getPostText());
            ((BaseAdapter.VideoPostViewHolder) holder).profileSmile.setImageResource(post.getProfile());
            ((BaseAdapter.VideoPostViewHolder) holder).post.setVideoURI(post.getResourceVideo());
            ((BaseAdapter.VideoPostViewHolder) holder).post.start();

            TextView countLikes = ((BaseAdapter.VideoPostViewHolder) holder).countLikes;
            countLikes.setText(post.getCountLikes() + " likes");

            ImageView like = ((BaseAdapter.VideoPostViewHolder) holder).favorite;

            ((BaseAdapter.VideoPostViewHolder) holder).viewFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (like.getVisibility() == View.INVISIBLE) {
                        countLikes.setText(post.getCountLikes() + 1 + " likes");
                        like.setVisibility(View.VISIBLE);
                    } else {
                        countLikes.setText(post.getCountLikes() + " likes");
                        like.setVisibility(View.INVISIBLE);
                    }

                }
            });

            ImageView bookmark = ((BaseAdapter.VideoPostViewHolder) holder).bookmark;

            ((BaseAdapter.VideoPostViewHolder) holder).viewBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bookmark.setVisibility((bookmark.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isFooter(position))
            return ITEM_VIEW_TYPE_FOOTER;

        return (posts.get(position).isVideo()) ? ITEM_VIEW_TYPE_VIDEO : ITEM_VIEW_TYPE_IMAGE;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addLoadMore(ArrayList<Post> arrayList) {
        if (posts.size() < 100)
            posts.addAll(arrayList);
        notifyDataSetChanged();
    }

    private boolean isFooter(int position) {
        return position == (posts.size() - 1);
    }
}
