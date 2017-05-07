package com.chibire.terence.cakehut.adapter;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chibire.terence.cakehut.R;
import com.chibire.terence.cakehut.constructors.MenuConstructor;
import com.chibire.terence.cakehut.data.MenuData;
import com.chibire.terence.cakehut.data.restMenu;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 4/23/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    OnItemClickListener mItemClickListener;

    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView menuName;
        public ImageView menuMedia;
        public TextView menuPrice;
        public LinearLayout placeNameHolder;
        public LinearLayout placeHolder;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            menuName = (TextView) itemView.findViewById(R.id.menu_name);
            menuMedia = (ImageView) itemView.findViewById(R.id.menu_media);
            menuPrice = (TextView) itemView.findViewById(R.id.menu_price);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);

            placeHolder.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final restMenu rest = new MenuData().allList().get(position);
        holder.menuName.setText(rest.name);
        Picasso.with(context)
                .load(rest.getImageResourceId(context))
                .placeholder(R.drawable.logo)
                .into(holder.menuMedia);
        holder.menuPrice.setText(rest.price);

    }
    @Override
    public int getItemCount() {
        return new MenuData().allList().size();
    }
}