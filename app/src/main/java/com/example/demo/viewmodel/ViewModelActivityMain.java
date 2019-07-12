package com.example.demo.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.databinding.ObservableField;

import com.example.demo.R;
import com.example.demo.data.interactions.SingleLiveEvent;
import com.example.demo.di.DataManager;
import com.example.demo.data.rx.SchedulerProvider;
import com.example.demo.di.ViewModelBase;
import com.example.demo.pojo.PojoUsers;
import com.example.demo.utils.NetworkUtils;
import com.example.demo.utils.Tags;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewModelActivityMain extends ViewModelBase {

    private Context mContext;
    private SingleLiveEvent<Integer> liveClickEvent = new SingleLiveEvent();
    public ObservableField<String> obsSelectedDate = new ObservableField<>("");
    public ObservableField<String> obsSelectedTime = new ObservableField<>("");
    public List<PojoUsers.Userdata> userList = new ArrayList<>();

    public ViewModelActivityMain(Context context, DataManager dataManager, NetworkUtils networkUtils,
                                 SchedulerProvider schedulerProvider) {
        super(dataManager, networkUtils, schedulerProvider);
        mContext = context;
    }

    public SingleLiveEvent<Integer> getLiveClickEvent() {
        return liveClickEvent;
    }

    public void callApiGetUserList() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //temp data
                for(int i=0;i<6;i++){
                    PojoUsers.Userdata userdata = new PojoUsers.Userdata();
                    userdata.setEmail("email"+i+"@gmail.com");
                    userdata.setName("User "+i);
                    userdata.setPhone("9977665544"+i+""+i);
                    userList.add(userdata);
                }

                liveClickEvent.setValue(101);
                liveClickEvent.call();
            }
        }, 2000);


        /*if (getNetworkUtils().isNetworkConnected()) {
            getDataManager().getUserList(generateGeUserListParams())
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(result -> {
                        if (result != null) {
                            if (result.getSuccess() == Tags.SUCCESS) {
                                userList = result.getUserdata();
                                liveClickEvent.setValue(101);
                                liveClickEvent.call();
                            } else if(result.getSuccess() == Tags.UPDATE){
                                // show update dialog here
                            } else {
                                // show failure message here
                            }
                        }
                    }, error -> {
                        Log.e("ApiError", error.getMessage());
                        // show failure message here
                    });
        } else {
            // show network connections message here
        }*/
    }

    private Map<String, Object> generateGeUserListParams() {
        Map<String, Object> paramMap = new HashMap<>();

        return paramMap;
    }
}
