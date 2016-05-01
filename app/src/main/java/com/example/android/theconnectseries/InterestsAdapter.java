package com.example.android.theconnectseries;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by markvandermerwe on 3/6/16.
 */
public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.MyViewHolderInt>{

    List<Interest> data = Collections.emptyList();

    private LayoutInflater layoutInflater;

    public InterestsAdapter(Context context, List<Interest> data){
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolderInt onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolderInt holderInt = new MyViewHolderInt(view);
        return holderInt;
    }

    @Override
    public void onBindViewHolder(MyViewHolderInt holder, int position) {
        Interest current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
        holder.description.setText(current.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolderInt extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        TextView description;

        public MyViewHolderInt(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.image);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
