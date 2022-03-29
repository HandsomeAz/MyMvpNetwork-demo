package com.example.mymvpnetwork_master.mvpBase;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @package: com.geo.aliaudioplayer_demo.mvp
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 * 静态代理
 */
public class MvpControlLer implements ILifeCircle {


    /**
     * 存放的是P层的实例
     */
    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    public void savePresenter(ILifeCircle lifeCircle){
        this.lifeCircles.add(lifeCircle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            next.onCreate(savedInstanceState,intent,getArguments);
        }

    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArguments == null){
                getArguments = new Bundle();
            }
            next.onActivityCreate(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStart();
        }

    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onResume();
        }

    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.destroyView();
        }

    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.attachView(iMvpView);
        }

    }
}
