package com.example.mymvpnetwork_master.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.mymvpnetwork_master.mvpBase.IMvpView;
import com.example.mymvpnetwork_master.mvpBase.LifeCircleMvpPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 * p层的中间过滤类
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    private String TAG ="BaseMvpPresenter_log";
    public BaseMvpPresenter(T view){
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Log.d(TAG,"onActivityCreate");
    }

    @Override
    public void onStart() {
        Log.d(TAG,"onStart");
    }

    @Override
    public void onResume() {
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop() {
        Log.d(TAG,"onStop");
    }

    @Override
    public void destroyView() {
        Log.d(TAG,"destroyView");
    }

    @Override
    public void onViewDestroy() {
        Log.d(TAG,"onViewDestroy");
    }

    @Override
    public void onNewIntent(Intent intent) {
        Log.d(TAG,"onNewIntent");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
        unDisposable();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d(TAG,"onRequestPermissionsResult");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Log.d(TAG,"onSaveInstanceState");
    }

    //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;

    /**
     * 将Disposable添加
     *
     * @param subscription
     */
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

}
