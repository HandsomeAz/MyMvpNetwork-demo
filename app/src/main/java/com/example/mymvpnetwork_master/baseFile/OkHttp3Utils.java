package com.example.mymvpnetwork_master.baseFile;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @package: com.example.mymvpnetwork_master.baseFile
 * 创建人： created by zlj
 * 时间：2022/03/27 17
 */
public class OkHttp3Utils {
    private static final String TAG = "OkHttp3Utils_log";
    private OkHttpClient mOkHttpClient;
    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public OkHttpClient getOkHttpClient() {

        if (null == mOkHttpClient) {

            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    //添加网络连接器
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)//日志拦截
//                    .cache(cache)//设置缓存
                    .retryOnConnectionFailure(true)//自动重试
                    .build();
        }
        return mOkHttpClient;
    }


    //日志
    static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.e("RetrofitLog", "retrofitBack = " + message);
        }
    });

    /**
     * 请求访问quest    打印日志
     * response拦截器
     */
//    private Interceptor interceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            long startTime = System.currentTimeMillis();
//            Response response = chain.proceed(chain.request());
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//            MediaType mediaType = response.body().contentType();
//            String content = response.body().string();
//
//            Logger.wtf(TAG, "----------Request Start----------------");
//            Logger.e(TAG, "| " + request.toString() + "===========" + request.headers().toString());
//            Logger.json(content);
//            Logger.e(content);
//            Logger.wtf(TAG, "----------Request End:" + duration + "毫秒----------");
//
//            return response.newBuilder()
//                    .body(ResponseBody.create(mediaType, content))
//                    .build();
//        }
//    };

}
