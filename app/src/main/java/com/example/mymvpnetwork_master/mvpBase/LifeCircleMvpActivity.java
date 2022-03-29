package com.example.mymvpnetwork_master.mvpBase;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @package: com.geo.aliaudioplayer_demo.mvp
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {

    private MvpControlLer mvpControlLer;

    @Override
    public MvpControlLer getMvpControlLer() {
        if (this.mvpControlLer == null){
            this.mvpControlLer = new MvpControlLer();
        }
        return mvpControlLer;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent == null){
            intent = new Intent();
        }

        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onCreate(savedInstanceState,intent,null);
            mvpControlLer.onActivityCreate(savedInstanceState,intent,null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onResume();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onPause();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onStop();
        }
    }

    @Override
    protected void onDestroy() {
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControlLer mvpControlLer = this.getMvpControlLer();
        if (mvpControlLer != null){
            mvpControlLer.onActivityResult(requestCode,resultCode,data);
        }
    }
}
