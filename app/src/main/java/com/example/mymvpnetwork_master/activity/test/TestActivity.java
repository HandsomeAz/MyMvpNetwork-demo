package com.example.mymvpnetwork_master.activity.test;

import android.util.Log;
import android.widget.TextView;

import com.example.mymvpnetwork_master.R;
import com.example.mymvpnetwork_master.base.BaseActivity;
import com.example.mymvpnetwork_master.base.ViewInject;
import com.example.mymvpnetwork_master.bean.TestBean;
import com.example.mymvpnetwork_master.manager.DialogClickListener;
import com.example.mymvpnetwork_master.manager.DialogManager;

import butterknife.BindView;

@ViewInject(mainLayoutId = R.layout.activity_test)
public class TestActivity extends BaseActivity<TestActivityPresenter> implements ITestActivityContract.IView{
//    private ITestActivityContract.IPresenter mPresenter = new TestActivityPresenter(this);

    @BindView(R.id.tv_test)
    TextView tv_test;

    @BindView(R.id.tv_test2)
    TextView tv_test2;

    @Override
    public void afterBindView() {

    }

    @Override
    protected TestActivityPresenter createPresenter() {
//        TestActivityPresenter testActivityPresenter = new TestActivityPresenter(this);
        return new TestActivityPresenter(this);
    }

    @Override
    public void processData() {
        mPresenter.getUpdateInfo(TestActivity.this);
    }

    @Override
    public void UpdateInfo(TestBean stringHttpBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_test.setText(stringHttpBean.toString());
            }
        });

        if (stringHttpBean.getCode() == 2000){
            if (stringHttpBean.getData()!=null){
                DialogManager.TipDialog(TestActivity.this, new DialogClickListener() {
                    @Override
                    public void Cancel() {

                    }

                    @Override
                    public void Submit() {
                        mPresenter.downloadApk(stringHttpBean.getData());
                    }
                });
            }
        }
    }

    @Override
    public void downloadState(boolean isSuccess) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isSuccess){
                    tv_test2.setText("下载成功！");
                }else {
                    tv_test2.setText("下载失败！");
                }
            }
        });
    }

    @Override
    public void onProgress(int i, long total) {
        Log.d("下载进度条",i+">>>>>>"+total);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_test2.setText(i+" %");
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}