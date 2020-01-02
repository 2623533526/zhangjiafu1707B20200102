package com.bawei.zhangjiafu1707b20200102;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2020/01/02
 */
public class MyRecycler extends RecyclerView.Adapter<MyRecycler.MyHoder> {
    Context context;
    List<ListEntity.ResultBean> result;

    public MyRecycler(Context context, List<ListEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        MyHoder myHoder = new MyHoder(inflate);
        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        Glide.with(context).load(result.get(position).getImageUrl()).into(holder.image);
        holder.text.setText(result.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyHoder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public MyHoder(@NonNull View itemView) {
            super(itemView);
          image =  itemView.findViewById(R.id.lay_image);
          text  =  itemView.findViewById(R.id.lay_text);
        }
    }
}
