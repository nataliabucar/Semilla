package com.semilla.globallogic.ui.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.globallogic.model.Vegetable;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.util.VegetableUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.ViewHolder> {

    private List<Vegetable> data = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context context;
    private VegetableAdapterInterface vegetableAdapterInterface;

    public interface VegetableAdapterInterface {
        void vegetablePressed(Vegetable vegetable);
    }

    public VegetableAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public VegetableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_vegetable_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final VegetableAdapter.ViewHolder holder, final int position) {
        holder.vIcon.setBackground(ContextCompat.getDrawable(context, VegetableUtil.getIcon(Integer.valueOf(data.get(position).getId()))));
        holder.vName.setText(data.get(position).getName().replace("_", " "));
        holder.vSelectVegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegetableAdapterInterface.vegetablePressed(data.get(position));
                holder.vSelectVegetable.setSelected(true);
            }
        });
    }

    public void setVegetableAdapterInterface(VegetableAdapterInterface vegetableAdapterInterface){
        this.vegetableAdapterInterface = vegetableAdapterInterface;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        data = vegetables;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vegetable_name)
        TextView vName;
        @BindView(R.id.iv_vegetable_icon)
        ImageView vIcon;
        @BindView(R.id.v_select_vegetable)
        View vSelectVegetable;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
