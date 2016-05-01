package com.example.android.theconnectseries;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by markvandermerwe on 3/5/16.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    List<Event> data = Collections.emptyList();

    private LayoutInflater inflater;

    public EventsAdapter(Context context, List<Event> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
        holder.description.setText(current.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.image);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
