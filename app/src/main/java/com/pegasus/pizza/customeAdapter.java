package com.pegasus.pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class customeAdapter extends RecyclerView.Adapter<customeAdapter.ViewHolder> {

    private List<Integer> imageData;
    private LayoutInflater inflater;

    customeAdapter(Context context, List<Integer> imageData){
        this.inflater = LayoutInflater.from(context);
        this.imageData = imageData;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        Integer image_id = imageData.get(position);
        holder.myImageView.setImageResource(image_id);
    }

    public int getItemCount(){return imageData.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView myImageView;

        ViewHolder(View view){
            super(view);

            myImageView = view.findViewById(R.id.image);

        }

        Integer getItem(int id){
            return imageData.get(id);
        }



    }
}