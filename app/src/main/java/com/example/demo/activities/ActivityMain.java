package com.example.demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.adapters.AdapterUsers;
import com.example.demo.databinding.ActivityMainBinding;
import com.example.demo.di.ActivityBase;
import com.example.demo.pojo.PojoUsers;
import com.example.demo.viewmodel.ViewModelActivityMain;

import javax.inject.Inject;

public class ActivityMain extends ActivityBase<ViewModelActivityMain> implements AdapterUsers.CustomClickListener {

    @Inject
    ViewModelActivityMain viewModelActivityMain;
    Context mContext;
    ActivityMainBinding mainBinding;
    private AdapterUsers adapterUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setVmObj(viewModelActivityMain);
        mContext  = this;

        initViews();
        setUpEvents();
    }

    private void initViews() {
        adapterUsers = new AdapterUsers(mContext, viewModelActivityMain.userList, this);
        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        mainBinding.recycler.setNestedScrollingEnabled(false);
        mainBinding.recycler.setAdapter(adapterUsers);

        viewModelActivityMain.callApiGetUserList();
    }

    private void setUpEvents() {
        viewModelActivityMain.getLiveClickEvent().observe(this, viewId ->{
            if(viewId!=null){
                if(viewId == 101){
                    //set adapter items here
                    adapterUsers.setItems(viewModelActivityMain.userList);
                }

            }
        });
    }

    @Override
    public ViewModelActivityMain getViewModel() {
        return viewModelActivityMain;
    }

    @Override
    public void setAppTitle(Object appTitle) {

    }

    @Override
    public void itemClicked(PojoUsers.Userdata userdata) {
        Toast.makeText(mContext, "Clicked ::: "+userdata.getName(),Toast.LENGTH_SHORT).show();
    }
}
