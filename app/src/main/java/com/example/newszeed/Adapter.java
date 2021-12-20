package com.example.newszeed;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model> models;

    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @NotNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",models.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.time.setText(models.get(position).getPublishedAt());
        holder.author.setText(models.get(position).getAuthor());
        holder.heading.setText(models.get(position).getTitle());
        holder.content.setText(models.get(position).getDescription());
        Glide.with(context).load(models.get(position).getUrltoimage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return models.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.mainheading);
            author=itemView.findViewById(R.id.author);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imager);
            cardView=itemView.findViewById(R.id.cardview);
            content=itemView.findViewById(R.id.content);
        }
    }
}
