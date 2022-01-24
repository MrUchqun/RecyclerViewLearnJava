package com.example.recyclerviewlearnjava.adapter;

import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlearnjava.R;
import com.google.android.material.imageview.ShapeableImageView;

public class BaseAdapter  {

    public static class ImagePostViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        TextView userName;
        ImageView post;
        TextView countLikes;
        TextView postText;
        ShapeableImageView profileSmile;
        ImageView favorite;
        ImageView favoriteBorder;
        ImageView bookmark;
        ImageView bookmarkBorder;
        FrameLayout viewFavorite;
        FrameLayout viewBookmark;

        public ImagePostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.iv_profile_img_post);
            this.userName = itemView.findViewById(R.id.tv_profile_img_post);
            this.post = itemView.findViewById(R.id.iv_post);
            this.countLikes = itemView.findViewById(R.id.tv_count_like_img_post);
            this.postText = itemView.findViewById(R.id.tv_post_img_post);
            this.profileSmile = itemView.findViewById(R.id.iv_profile_img_post_smile);
            this.favorite = itemView.findViewById(R.id.img_favorite_img);
            this.favoriteBorder = itemView.findViewById(R.id.img_favorite_border_img);
            this.bookmark = itemView.findViewById(R.id.img_bookmark_img);
            this.bookmarkBorder = itemView.findViewById(R.id.img_bookmark_border_img);
            this.viewFavorite = itemView.findViewById(R.id.view_favorite_img);
            this.viewBookmark = itemView.findViewById(R.id.view_bookmark_img);
        }
    }

    public static class VideoPostViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        TextView userName;
        VideoView post;
        TextView countLikes;
        TextView postText;
        ShapeableImageView profileSmile;
        ImageView favorite;
        ImageView favoriteBorder;
        ImageView bookmark;
        ImageView bookmarkBorder;
        FrameLayout viewFavorite;
        FrameLayout viewBookmark;

        public VideoPostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.iv_profile_video_post);
            this.userName = itemView.findViewById(R.id.tv_profile_video_post);
            this.post = itemView.findViewById(R.id.vv_post);
            this.countLikes = itemView.findViewById(R.id.tv_count_like_video_post);
            this.postText = itemView.findViewById(R.id.tv_post_video_post);
            this.profileSmile = itemView.findViewById(R.id.iv_profile_video_post_smile);
            this.favorite = itemView.findViewById(R.id.img_favorite_vid);
            this.favoriteBorder = itemView.findViewById(R.id.img_favorite_border_vid);
            this.bookmark = itemView.findViewById(R.id.img_bookmark_vid);
            this.bookmarkBorder = itemView.findViewById(R.id.img_bookmark_border_vid);
            this.viewFavorite = itemView.findViewById(R.id.view_favorite_vid);
            this.viewBookmark = itemView.findViewById(R.id.view_bookmark_vid);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
