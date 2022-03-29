package com.example.mymvpnetwork_master.base;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;

import com.example.mymvpnetwork_master.mvpBase.LifeCircleMvpFragment;

import butterknife.ButterKnife;

/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContent;
    private View  mView = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContent = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0){
                mView = initFragmentView(inflater,mainLayoutId);
//                setContentView(mainLayoutId);
                bindView(mView);
                afterBindView();
                processData();
            }else {
                throw new RuntimeException("mainLayoutId 加载<0");
            }
        }else {
            throw new RuntimeException("mainLayoutId is null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int mainLayoutId) {

        return  inflater.inflate(mainLayoutId,null);
    }


    public abstract void afterBindView();

    public abstract void processData();


    //view的依赖绑定注入
    private void bindView(View view) {
        ButterKnife.bind(this,view);
    }
}
