package com.solfastory.testapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.solfastory.testapp.DetailActivity;
import com.solfastory.testapp.R;
import com.solfastory.testapp.model.ItemModel;

public class ItemAdapter extends ListAdapter<ItemModel, ItemAdapter.ItemHolder> {
    Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemHolder holder = new ItemHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        final ItemModel result = get(position);
        holder.imgItem.setImageResource(result.getPictList().get(0));
        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("item", result);
                context.startActivity(i);
            }
        });
    }

    public void initData() {

    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgItem;

        public ItemHolder(View itemView) {
            super(itemView);
            imgItem = (ImageView) itemView.findViewById(R.id.img_item);

        }

        public ItemHolder(ViewGroup parrent) {
            this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.item_picture, parrent, false));
        }
    }
}