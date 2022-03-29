package com.example.mymvpnetwork_master;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.mymvpnetwork_master.activity.test.TestActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(99);
        findViewById(R.id.tv_next).setOnClickListener(view -> {
            startActivity(new Intent(this, TestActivity.class));
        });
    }

    public void requestPermissions(int requestCode) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList<String> requestPerssionArr = new ArrayList<>();
                int hasCamrea = checkSelfPermission(Manifest.permission.CAMERA);
                if (hasCamrea != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.CAMERA);
                }

                int hasSdcardRead = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
                if (hasSdcardRead != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                }

                int hasSdcardWrite = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (hasSdcardWrite != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
                requestPerssionArr.add(Manifest.permission.BLUETOOTH);
                requestPerssionArr.add(Manifest.permission.BLUETOOTH_ADMIN);
                requestPerssionArr.add(Manifest.permission.ACCESS_WIFI_STATE);
                requestPerssionArr.add(Manifest.permission.CHANGE_WIFI_STATE);
                requestPerssionArr.add(Manifest.permission.INTERNET);
                requestPerssionArr.add(Manifest.permission.INSTALL_PACKAGES);
                requestPerssionArr.add(Manifest.permission.ACCESS_COARSE_LOCATION);
                requestPerssionArr.add(Manifest.permission.ACCESS_FINE_LOCATION);
                requestPerssionArr.add(Manifest.permission.CHANGE_NETWORK_STATE);
                requestPerssionArr.add(Manifest.permission.ACCESS_FINE_LOCATION);
                requestPerssionArr.add(Manifest.permission.ACCESS_NETWORK_STATE);
                requestPerssionArr.add(Manifest.permission.READ_PHONE_STATE);



                // 是否应该显示权限请求
                if (requestPerssionArr.size() >= 1) {
                    String[] requestArray = new String[requestPerssionArr.size()];
                    for (int i = 0; i < requestArray.length; i++) {
                        requestArray[i] = requestPerssionArr.get(i);
                    }
                    requestPermissions(requestArray, requestCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}