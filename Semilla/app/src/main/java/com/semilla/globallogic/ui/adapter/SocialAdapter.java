package com.semilla.globallogic.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globallogic.model.SocialItem;
import com.semilla.globallogic.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author gino.ghiotto
 */
public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<SocialItem> data;
    private Context context;
    private SocialAdapter.SocialAdapterInterface socialInterface;

    public interface SocialAdapterInterface {
        void elementPressed(int id);
    }

    public SocialAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public SocialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_social_item, parent, false);
        return new SocialAdapter.ViewHolder(view);
    }


    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(SocialAdapter.ViewHolder holder, final int position) {
        holder.vName.setText(data.get(position).getName());
        holder.vShares.setText(data.get(position).getShares());
        holder.vDistance.setText(data.get(position).getDistance());


    }

    public void setInterface(SocialAdapter.SocialAdapterInterface socialInterface) {
        this.socialInterface = socialInterface;
    }

    public void setItems(List<SocialItem> items) {
        data = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView vName;
        @BindView(R.id.tv_share)
        TextView vShares;
        @BindView(R.id.tv_distance)
        TextView vDistance;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
