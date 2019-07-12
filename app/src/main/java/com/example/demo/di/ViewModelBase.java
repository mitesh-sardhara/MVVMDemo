package com.example.demo.di;

import androidx.lifecycle.ViewModel;

import com.example.demo.data.interactions.SingleLiveEvent;
import com.example.demo.data.rx.SchedulerProvider;
import com.example.demo.utils.NetworkUtils;

import io.reactivex.disposables.CompositeDisposable;

public class ViewModelBase extends ViewModel {

    private final DataManager mDataManager;
    private final NetworkUtils mNetworkUtils;
    private final SchedulerProvider mSchedulerProvider;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private final SingleLiveEvent<Object> mSnackBarMessage = new SingleLiveEvent<>();
    private final SingleLiveEvent<Void> mHideKeyBoardEvent = new SingleLiveEvent<>();
    private final SingleLiveEvent<Void> mShowUpdateDialogEvent = new SingleLiveEvent<>();


    public ViewModelBase(DataManager dataManager, NetworkUtils networkUtils,
                         SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mNetworkUtils = networkUtils;
        this.mSchedulerProvider = schedulerProvider;
    }

    /**
     * Getter method for get {@link DataManager}
     *
     * @return
     */
    public DataManager getDataManager() {
        return mDataManager;
    }

    /**
     * Getter method for get {@link NetworkUtils}
     *
     * @return
     */
    public NetworkUtils getNetworkUtils() {
        return mNetworkUtils;
    }

    /**
     * Getter method for get {@link SchedulerProvider}
     *
     * @return
     */
    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
