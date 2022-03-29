package com.example.mymvpnetwork_master.mvpBase;

import android.content.Intent;
import android.os.Bundle;

/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onActivityCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

    void  onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
