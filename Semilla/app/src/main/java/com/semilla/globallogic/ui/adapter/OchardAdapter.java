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
import com.semilla.globallogic.ui.util.VegetableUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;


public class OchardAdapter extends RecyclerView.Adapter<OchardAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private List<Vegetable> data;
    private Context context;
    private OchardAdapterInterface ochardAdapterInterface;
    private static final String SOW = "sow";

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
        holder.vegetableName.setBackground(ContextCompat.getDrawable(context, VegetableUtil.getIcon(Integer.valueOf(data.get(position).getId()))));
        holder.vegetableContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ochardAdapterInterface.vegetablePressed(data.get(position));
            }
        });
        holder.vSing.setVisibility(context.getSharedPreferences(SOW, MODE_PRIVATE).getBoolean(SOW, false) ? View.GONE : View.VISIBLE);

    }

    public void setOchardAdapterInterface(OchardAdapterInterface ochardAdapterInterface) {
        this.ochardAdapterInterface = ochardAdapterInterface;
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

        @BindView(R.id.im_vegetable_image)
        ImageView vegetableName;

        @BindView(R.id.ll_vegetable_container)
        LinearLayout vegetableContainer;

        @BindView(R.id.iv_sing)
        ImageView vSing;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    ;
}
