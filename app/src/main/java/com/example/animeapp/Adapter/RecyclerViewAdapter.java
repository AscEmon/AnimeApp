package com.example.animeapp.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.animeapp.Model.Anime;
import com.example.animeapp.R;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{


    private Context mContext;
    private List<Anime> mAnime;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Anime> mAnime) {
        this.mContext = mContext;
        this.mAnime = mAnime;

       options=new RequestOptions().centerCrop().placeholder(R.drawable.loading_image).error(R.drawable.loading_image);

    }





    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        view=layoutInflater.inflate(R.layout.anime_row,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.AnimeMovie.setText(mAnime.get(position).getName());
       // holder.Description.setText(mAnime.get(position).getDescription());
        holder.Rating.setText(mAnime.get(position).getRating());
        holder.category.setText(mAnime.get(position).getCategorie());
        holder.Studio.setText(mAnime.get(position).getStudio());

        Glide.with(mContext).load(mAnime.get(position).getImg()).apply(options).into(holder.img_thumbnail);

      //  Picasso.get().load(mAnime.get(position).getImg()).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mAnime.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView AnimeMovie;
       // TextView Description;
        TextView Rating;
        TextView category;
        TextView Studio;
        ImageView img_thumbnail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            AnimeMovie=itemView.findViewById(R.id.AnimeName);
         //   Description=itemView.findViewById(R.id.AnimeDescription);
            Rating=itemView.findViewById(R.id.Rating);
            category=itemView.findViewById(R.id.Category);
            Studio=itemView.findViewById(R.id.Studio);
            img_thumbnail=itemView.findViewById(R.id.thumbnail);




        }
    }






}
