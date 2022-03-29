package com.example.mymvpnetwork_master.baseFile;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @package: com.example.mymvpnetwork_master.baseFile
 * 创建人： created by zlj
 * 时间：2022/03/27 16
 */
public class BaseNetwork extends RetrofitUtils{

    /**by zlj
     * 插入观察者
     * @param observable
     * @param observer
     * @param <T>
     */
    public  <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
}
