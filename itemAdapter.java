package com.example.shraddha.rate1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.MyViewHolder> {
   private List<itemInfo> mdata;
    public itemAdapter(List<itemInfo> data)
    {
       // this.context=context;
          //inflater=LayoutInflater.from(context);
        mdata=data;
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,age;
        public MyViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            age= (TextView) itemView.findViewById(R.id.age);

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items,viewGroup,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        itemInfo current=mdata.get(position);
        viewHolder.name.setText(current.getName());
        viewHolder.age.setText(current.getAge());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
