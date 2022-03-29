package com.example.mymvpnetwork_master.mvpBase;

import java.lang.ref.WeakReference;

/**
 * @package: com.geo.aliaudioplayer_demo.base
 * 创建人： created by zlj
 * 时间：2022/02/20 20
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle{

    protected WeakReference<T> weakReference;
    protected LifeCircleMvpPresenter(){
        super();
    }

    protected LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        MvpControlLer mvpControlLer =iMvpView.getMvpControlLer();
        mvpControlLer.savePresenter(this);
    }

    /**
     * 弱引用
     * @param iMvpView
     */
    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else {
            T view = (T) weakReference.get();
            if (view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView(){
        T view = weakReference !=null ? (T) weakReference.get() : null;
        if (view == null){
            return getEmptyView();
        }

        return  view;
    }

    protected abstract T getEmptyView();
}
