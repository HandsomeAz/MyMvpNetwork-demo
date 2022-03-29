package com.example.mymvpnetwork_master.base;

import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;

import com.example.mymvpnetwork_master.manager.AppManager;
import com.example.mymvpnetwork_master.baseFile.UserNetWork;
import com.example.mymvpnetwork_master.mvpBase.LifeCircleMvpActivity;

import butterknife.ButterKnife;


/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public abstract class BaseActivity<P extends BaseMvpPresenter> extends LifeCircleMvpActivity {
    public UserNetWork userNetWork;
    protected P mPresenter;
    public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mContext = this;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0){
                setContentView(mainLayoutId);
                bindView();
                afterBindView();
                processData();
            }else {
                throw new RuntimeException("mainLayoutId 加载<0");
            }
        }else {
            throw new RuntimeException("mainLayoutId is null");
        }
        AppManager.getAppManager(this).addActivity(this);
        if (userNetWork==null) {
            userNetWork = new UserNetWork();
        }
    }

    public abstract void afterBindView();
    protected abstract P createPresenter();
    public abstract void processData();


    //view的依赖绑定注入
    private void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager(this).finishActivity(this);
    }
}
