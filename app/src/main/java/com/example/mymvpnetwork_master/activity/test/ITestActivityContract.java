package com.example.mymvpnetwork_master.activity.test;

import android.app.Activity;

import com.example.mymvpnetwork_master.bean.TestBean;
import com.example.mymvpnetwork_master.mvpBase.ILifeCircle;
import com.example.mymvpnetwork_master.mvpBase.IMvpView;
import com.example.mymvpnetwork_master.mvpBase.MvpControlLer;

/**
 * @package: com.example.mymvpnetwork_master.activity.Test
 * 创建人： created by zlj
 * 时间：2022/03/27 20
 */
public interface ITestActivityContract {
    interface IView extends IMvpView {

        void UpdateInfo(TestBean stringHttpBean);

        void downloadState(boolean isSuccess);

        void onProgress(int i, long total);
    }
    interface IPresenter extends ILifeCircle {

        void getUpdateInfo(Activity activity);

        void downloadApk(String url);
    }

    IView emptyView = new IView() {

        @Override
        public void UpdateInfo(TestBean stringHttpBean) {

        }

        @Override
        public void downloadState(boolean isSuccess) {


        }

        @Override
        public void onProgress(int i, long total) {

        }

        @Override
        public MvpControlLer getMvpControlLer() {
            return null;
        }
    };
}
