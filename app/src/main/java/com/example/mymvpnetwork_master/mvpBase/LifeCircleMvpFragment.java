package com.example.mymvpnetwork_master.mvpBase;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * @package: com.geo.aliaudioplayer_demo.mvp
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpControlLer mvpControlLer;

    @Override
    public MvpControlLer getMvpControlLer() {
        if (this.mvpControlLer == null){
            this.mvpControlLer = new MvpControlLer();
        }
        return mvpControlLer;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = this.getArguments();
        if (arguments == null){
            arguments = new Bundle();
        }

        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onCreate(savedInstanceState,null,arguments);
            mvpControlLer.onActivityCreate(savedInstanceState,null,arguments);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = this.getArguments();
        if (arguments == null){
            arguments = new Bundle();
        }

        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onActivityCreate(savedInstanceState,null,arguments);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onViewDestroy();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onResume();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onPause();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onDestroy();
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onSaveInstanceState(outState);
        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onActivityResult(requestCode,resultCode,data);
        }
    }
}
