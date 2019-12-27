package com.example.mvvmtest;

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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    private Context mContext;
    private ArrayList<String> userImageArray = new ArrayList<>();
    private ArrayList<String> userNameArray = new ArrayList<>();

    public RecycleViewAdapter(Context mContext, ArrayList<String> userImageArray, ArrayList<String> userNameArray) {
        this.mContext = mContext;
        this.userImageArray = userImageArray;
        this.userNameArray = userNameArray;
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
                .load(userImageArray.get(position))
                .into(holder.userImage);

        holder.userName.setText(userNameArray.get(position));

        holder.layoutListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Clicked on"+userImageArray.get(position));
                Toast.makeText(mContext, userNameArray.get(position)+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return userImageArray.size();

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
