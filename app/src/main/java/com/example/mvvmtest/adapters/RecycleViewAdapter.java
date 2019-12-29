package com.example.mvvmtest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmtest.R;
import com.example.mvvmtest.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    private Context mContext;
    private List<NicePlace> nicePlace;

    public RecycleViewAdapter(Context mContext, List<NicePlace> nicePlace) {
        this.mContext = mContext;
        this.nicePlace=nicePlace;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: Called");
        Glide.with(mContext)
                .asBitmap()
                .load(nicePlace.get(position).getUserImage())
                .into(holder.userImage);

        holder.userName.setText(nicePlace.get(position).getUserName());

        holder.layoutListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Clicked on"+nicePlace.get(position).getUserName());
                Toast.makeText(mContext, (nicePlace.get(position).getUserName())+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return nicePlace.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout layoutListItem;
        CircleImageView userImage;
        TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            userName = itemView.findViewById(R.id.user_name);
            layoutListItem = itemView.findViewById(R.id.layout_list);


        }
    }

}
