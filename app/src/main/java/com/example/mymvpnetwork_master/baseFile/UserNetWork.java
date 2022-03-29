package com.example.mymvpnetwork_master.baseFile;

import com.example.mymvpnetwork_master.api.ServiceApi;
import com.example.mymvpnetwork_master.bean.TestBean;

import java.util.HashMap;

import io.reactivex.Observer;
import okhttp3.ResponseBody;

/**
 * @package: com.example.mymvpnetwork_master.baseFile
 * 创建人： created by zlj
 * 时间：2022/03/27 18
 */
public class UserNetWork  extends BaseNetwork {
    protected final ServiceApi service = getRetrofit().create(ServiceApi.class);


    public void toGetUpdateInfo(Observer<TestBean> observer) {
         HashMap<String, Object> map = new HashMap<>();
         map.put("versionCode",33);
         map.put("type",3);
        setSubscribe(service.getUpdateInfo(map), observer);
    }


    public void toDownloadApk(Observer<ResponseBody> observer,String url) {
        setSubscribe(service.downloadApk(url), observer);
    }
}
