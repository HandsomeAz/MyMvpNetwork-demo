package com.example.mymvpnetwork_master.baseFile;

import com.example.mymvpnetwork_master.constants.ConstantConfig;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @package: com.example.mymvpnetwork_master.baseFile
 * 创建人： created by zlj
 * 时间：2022/03/27 16
 */
public class RetrofitUtils {
    private Retrofit mRetrofit = null;
    private Retrofit mRetrofit2 = null;
    private OkHttpClient mOkHttpClient;

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    public Retrofit getRetrofit() {
        if (null == mRetrofit) {
            if (null == mOkHttpClient) {
                OkHttp3Utils okHttp3Utils = new OkHttp3Utils();
                mOkHttpClient = okHttp3Utils.getOkHttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ConstantConfig.BaseUrl)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    /**
     * 获取Retrofit对象
     *这个主要是为了应对多个BaseUrl而准备的
     * @return
     */
    public Retrofit getRetrofit2() {
        if (null == mRetrofit2) {
            if (null == mOkHttpClient) {
                OkHttp3Utils okHttp3Utils = new OkHttp3Utils();
                mOkHttpClient = okHttp3Utils.getOkHttpClient();
            }
            mRetrofit2 = new Retrofit.Builder()
                    .baseUrl(ConstantConfig.BaseUrl)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit2;
    }


    public class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody body) throws IOException {
                    if (body.contentLength() == 0) return null;
                    return delegate.convert(body);
                }
            };
        }
    }

}
