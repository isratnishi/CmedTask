package com.isratjahan.taks2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.isratjahan.taks2.Model.User;
import com.isratjahan.taks2.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomViewHolder> {
    private ArrayList<User> users;
    Context context;

    public UserAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = users.get(position);
        holder.tvemployeeNameFirst.setText(user.getFirstName() + " " + user.getLastName());
        holder.tvemployeeLastName.setText(user.getGender());
        holder.tvMobileNo.setText(user.getPhones().getMobile());
        if (user.getGender().equals("female")) {
            String IMAGE_URL = "https://randomuser.me/api/portraits/women/";
            Glide.with(context).load(IMAGE_URL + user.getPhoto() + ".jpg").diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true).into(holder.imageProfile);
        } else {
            String IMAGE_URL = "https://randomuser.me/api/portraits/men/";
            Glide.with(context).load(IMAGE_URL + user.getPhoto() + ".jpg").diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true).into(holder.imageProfile);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView tvemployeeNameFirst, tvemployeeLastName, tvMobileNo;
        CircularImageView imageProfile;

        public CustomViewHolder(View view) {
            super(view);
            tvemployeeNameFirst = (TextView) view.findViewById(R.id.tvemployeeNameFirst);
            tvemployeeLastName = (TextView) view.findViewById(R.id.tvemployeeLastName);
            tvMobileNo = (TextView) view.findViewById(R.id.tvMobileNo);
            imageProfile = view.findViewById(R.id.imageProfile);

        }
    }
}