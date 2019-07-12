package com.example.demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.databinding.ItemRowBinding;
import com.example.demo.pojo.PojoUsers;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyViewHolder> {

    //https://www.journaldev.com/23989/android-recyclerview-data-binding

    private List<PojoUsers.Userdata> dataModelList;
    private Context context;
    private CustomClickListener customClickListener;

    public AdapterUsers(Context context, List<PojoUsers.Userdata> dataModelList, CustomClickListener customClickListener) {
        this.context = context;
        this.dataModelList = dataModelList;
        this.customClickListener = customClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PojoUsers.Userdata dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListener(customClickListener);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public void setItems(List<PojoUsers.Userdata> userList) {
        this.dataModelList = userList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ItemRowBinding itemRowBinding;

        public MyViewHolder(@NonNull ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(PojoUsers.Userdata dataModel) {
            itemRowBinding.setUser(dataModel);
            itemRowBinding.executePendingBindings();
        }
    }

    public interface CustomClickListener {
        void itemClicked(PojoUsers.Userdata f);
    }
}
