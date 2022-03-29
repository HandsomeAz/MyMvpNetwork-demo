package com.example.mymvpnetwork_master.manager;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mymvpnetwork_master.R;
import com.example.mymvpnetwork_master.view.MyDialog;

public class DialogManager {
    private static MyDialog mMyDialog =null;

    //下载进度弹窗
    public static void DownloadDialog(){

    }
    //升级提示窗
    public static void TipDialog(Activity activity,DialogClickListener listener){
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        int heightPixels = outMetrics.heightPixels;
        View view = activity.getLayoutInflater().inflate(R.layout.message_dialog, null);

        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        int width = view.getMeasuredWidth();
        Button btn_submit = view.findViewById(R.id.btn_submit);
        Button btn_cancel = view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(v -> {
            listener.Cancel();
            mMyDialog.dismiss();
        });
        btn_submit.setOnClickListener(v -> {
            listener.Submit();
            mMyDialog.dismiss();
        });
        mMyDialog = new MyDialog(activity, (int) (widthPixels*0.65), (int) (heightPixels*0.5), view, R.style.custom_dialog, Gravity.CENTER);
        mMyDialog.setCancelable(true);
        mMyDialog.show();
    }
}
