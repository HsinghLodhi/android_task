package com.example.enfoenum.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.enfoenum.MainActivity;
import com.example.enfoenum.R;
import com.example.enfoenum.activity.ListActivity;
import com.example.enfoenum.activity.MovesDetailsActivity;
import com.example.enfoenum.model.MoviesModel;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

   Context context;
   List<MoviesModel> list;
   public static int itemid = 0;

    public ListAdapter(Context context, List<MoviesModel> list) {
        this.context=context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ListAdapter.ViewHolder holder, int position) {

         holder.tvlist.setText(" "+list.get(position).getMovies());
        holder.tvid.setText(list.get(position).getId()+"");
        holder.tvlist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"id"+holder.tvid.getText().toString(),Toast.LENGTH_LONG).show();
                itemid = Integer.parseInt(holder.tvid.getText().toString());
                context.startActivity(new Intent(context, MovesDetailsActivity.class));
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvlist;
        TextView tvid;

        public ViewHolder( View itemView) {
            super(itemView);

            this.tvlist = itemView.findViewById(R.id.tvlist);
            this.tvid = itemView.findViewById(R.id.tvid2);
        }
    }
}
