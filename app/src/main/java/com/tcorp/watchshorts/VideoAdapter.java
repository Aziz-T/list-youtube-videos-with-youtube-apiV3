package com.tcorp.watchshorts;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {


    private List<VideoModel> videoModelList;

    public VideoAdapter(List<VideoModel> videoModelList) {
        this.videoModelList = videoModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
         return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(
                videoModelList.get(position).getId(),
                videoModelList.get(position).getImgUrl(),
                videoModelList.get(position).getTitle(),position);
    }

    @Override
    public int getItemCount() {
        Log.d("tttttttttttt",videoModelList.size()+"");
        return videoModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTxt;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.videoImage);
            titleTxt = itemView.findViewById(R.id.titleTxt);

        }

        public void setData(String id, String imgUrl, String title, int position) {
            titleTxt.setText(title);
            Picasso.get().load(imgUrl).into(imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(),VideoViewActivity.class);
                    intent.putExtra("videoId",id);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
