package com.semilla.globallogic.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.globallogic.model.Vegetable;
import com.semilla.globallogic.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OchardAdapter extends RecyclerView.Adapter<OchardAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private List<Vegetable> data;
    private Context context;
    private OchardAdapterInterface ochardAdapterInterface;

    public interface OchardAdapterInterface {
        void vegetablePressed(Vegetable vegetable);
    }

    public OchardAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = mInflater.inflate(R.layout.view_vegetable_ochard, parent, false);
        return new ViewHolder(view);
    }


    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.vegetableName.setBackground(ContextCompat.getDrawable(context, R.drawable.papa));
        holder.vegetableContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ochardAdapterInterface.vegetablePressed(data.get(position));
            }
        });

    }

    public void setOchardAdapterInterface(OchardAdapterInterface ochardAdapterInterface){
        this.ochardAdapterInterface = ochardAdapterInterface;
    }

    public void setVegetables(List<Vegetable> vegetables){
        data = vegetables;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.im_vegetable_image)
        ImageView vegetableName;

        @BindView(R.id.ll_vegetable_container)
        LinearLayout vegetableContainer;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    };
}
