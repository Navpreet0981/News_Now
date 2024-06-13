package com.example.vollylibraryexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    ArrayList<DataModelClass.Article> list;

    public NewsAdapter(ArrayList<DataModelClass.Article> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_list, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (list.get(position).source.name == null) {
            holder.textView.setVisibility(View.GONE);
        } else {
            holder.textView.setText(list.get(position).source.name);
        }

        DateFormat formater = new SimpleDateFormat("dd-MM-yy");
            holder.textTime.setText(formater.format(list.get(position).publishedAt));
        holder.textDesc.setText(list.get(position).title);

        if (list.get(position).urlToImage == null) {
            holder.imageView.setVisibility(View.GONE);
        } else {
            Picasso.get().load(list.get(position).urlToImage).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), NewsDetailsPage.class);
                intent.putExtra("key",position);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textDesc, textTime;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDesc = itemView.findViewById(R.id.textView2);
            textView = itemView.findViewById(R.id.textView);
            textTime = itemView.findViewById(R.id.textViewtime);
            imageView = itemView.findViewById(R.id.recycleItemImage);
        }
    }
}
