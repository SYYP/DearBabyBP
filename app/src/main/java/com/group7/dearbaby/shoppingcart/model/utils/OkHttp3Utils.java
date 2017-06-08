package com.group7.dearbaby.shoppingcart.model.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-05-10.
 */

public class OkHttp3Utils {
    private volatile static OkHttp3Utils mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;
    private Context mContext;
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private OkHttp3Utils(Context context){
        super();
        OkHttpClient.Builder clientBuilder=new OkHttpClient().newBuilder();
        clientBuilder.readTimeout(30,TimeUnit.SECONDS);
        clientBuilder.connectTimeout(15,TimeUnit.SECONDS);
        clientBuilder.writeTimeout(60,TimeUnit.SECONDS);
        mOkHttpClient=clientBuilder.build();
        this.mContext=context.getApplicationContext();
        mHandler=new Handler(mContext.getMainLooper());

    }

    /**
     * 返回Okhttp3Utils的单例
     * @param context
     * @return
     */
    public static  OkHttp3Utils getmInstance(Context context){

    if (mInstance==null){
        synchronized (OkHttp3Utils.class){
                mInstance=new OkHttp3Utils(context);
        }
    }
    return mInstance;
}

    /**
     * 设置请求头
     *
     * @param headersParams
     * @return
     */

    private Headers setHeaders(Map headersParams){
        Headers headers=null;
        Headers.Builder headersBuilder=new Headers.Builder();
//        if (headersParams!=null){
//            for (Object  key:headersParams.keySet()){
//                headersBuilder.add((String) key,headersBuilder.get((String) key));
//            }
//        }
        headersBuilder.add("application-key","58424776034ff82470d06d3d");
        headersBuilder.add("user-token","584cfabb4918e4186a77ff1e");
        headersBuilder.add("Content-Type","application/json");
        return  headersBuilder.build();
    }
    /**
     * post请求参数
     *
     * @param bodyParams
     * @return
     */

    private RequestBody setPostRequestBody(Map bodyParams){
        RequestBody body=null;
        FormBody.Builder formEncodingBuilder=new FormBody.Builder();

if (bodyParams!=null){
    for (Object key:bodyParams.keySet()) {
        formEncodingBuilder.add((String)key,(String )bodyParams.get(key));
    }
}
body =formEncodingBuilder.build();
        return body;
    }
    /**
     * Post上传图片的参数
     *
     * @param bodyParams
     * @param filePathParams
     * @return
     */

    private RequestBody setFileRequestBody(Map bodyParams, Map filePathParams){
        // 带文件的Post参数
        RequestBody body=null;
        MultipartBody.Builder MultipartBodyBuilder=new MultipartBody.Builder();
        MultipartBodyBuilder .setType(MultipartBody.FORM);
        RequestBody fileBody = null;
        if (bodyParams != null) {
           for(Object key:bodyParams.keySet()) {
                MultipartBodyBuilder.addFormDataPart((String)key, (String)bodyParams.get(key));
            }
        }
        if (filePathParams != null) {
            Iterator iterator = filePathParams.keySet().iterator();

            int i = 0;
            for (Object key:filePathParams.keySet()){
                i++;
                MultipartBodyBuilder.addFormDataPart((String)key, (String)filePathParams.get(key));
                fileBody = RequestBody.create(MEDIA_TYPE_PNG, new File((String)filePathParams.get(key)));
                MultipartBodyBuilder.addFormDataPart((String)key, i + ".png", fileBody);
            }
        }
        body=MultipartBodyBuilder.build();
        return body;
    }


    /**
     * get方法连接拼加参数
     *
     * @param mapParams
     * @return
     */
    private String setGetUrlParams(Map mapParams) {
        String strParams = "";
        if (mapParams!=null) {
            strParams+="?";
            int i=0;
            for(Object key:mapParams.keySet()) {
                if (i==0){
                    strParams += key + "=" + mapParams.get(key);
                }else {
                strParams += "&" + key + "=" + mapParams.get(key);}
                i++;
            }
        }
        return strParams;
    }
    /**
     * 实现post请求
     *
     * @param reqUrl
     * @param headersParams
     * @param params
     * @param callback
     */
    public void doPost(final String reqUrl, Map headersParams, Map params,String productIds,int count,int type,boolean isSelected, final NetCallback callback) throws IOException {
        Request.Builder RequestBuilder = new Request.Builder();
        RequestBuilder.url(reqUrl);// 添加URL地址

       // RequestBuilder.method("POST", setPostRequestBody(params));//设置请求方法类型和请求参数<"GET"请求没有RequestBody>
        RequestBuilder.headers(setHeaders(headersParams));// 添加请求头
        RequestBuilder.post(RequestBody.create(
                            MediaType.parse("application/json; charset=utf-8"),
                               getBodyJson(productIds,count,isSelected,type)));// post json提交
        LogUtils.e("DOPOST",getBodyJson(productIds,count,isSelected,type));
        Request request = RequestBuilder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                try {
                   final String result = response.body().string();
                    mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                   callback.onSuccess(0,result);//接口回调方法
                    call.cancel();
                    }
                });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(final Call call, final IOException exception) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(-1, exception.getMessage());
                        call.cancel();
                    }
                });
            }
        });
    }
    /**
     * 实现post请求
     *
     * @param reqUrl
     * @param headersParams
     * @param params
     * @param callback
     */
    public void doPost(final String reqUrl, Map headersParams, Map params, final NetCallback callback) throws IOException {
        Request.Builder RequestBuilder = new Request.Builder();
        RequestBuilder.url(reqUrl);// 添加URL地址
        RequestBuilder.post(setPostRequestBody(params));
        // RequestBuilder.method("POST", setPostRequestBody(params));//设置请求方法类型和请求参数<"GET"请求没有RequestBody>
        RequestBuilder.headers(setHeaders(headersParams));// 添加请求头


        Request request = RequestBuilder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                try {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(0,result);//接口回调方法
                            call.cancel();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(final Call call, final IOException exception) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(-1, exception.getMessage());
                        call.cancel();
                    }
                });
            }
        });
    }
    private String getBodyJson(String productIds, int count, boolean isSelected, int type){

        if (type==0){
            return "{\"productIds\":[\""+productIds+"\"],\"quantities\":["+count+"]}";

        }
        if (type==1){
            return "{\"productId\":\""+productIds+"\",\"count\":1}";
        }

        return"{\"productId\":\""+productIds+"\",\"count\":"+count+",\"selected\":"+isSelected+"}";
    }
    /**
     * 实现get请求
     *
     * @param reqUrl
     * @param headersParams
     * @param params
     * @param callback
     */
    public void doGet(final String reqUrl, Map headersParams, Map params, final NetCallback callback) {
        Request.Builder RequestBuilder = new Request.Builder();
        RequestBuilder.url(reqUrl + setGetUrlParams(params));// 添加URL地址 自行加 ?
        RequestBuilder.headers(setHeaders(headersParams));// 添加请求头
        Request request = RequestBuilder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                try { final String result=   response.body().string();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                callback.onSuccess(0, result);
                call.cancel();
                    }
                });
            }   catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(final Call call, final IOException exception) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(-1, exception.getMessage());
                        call.cancel();
                    }
                });
            }
        });
    }
    /**
     * 实现加载图片
     *
     * @param context
     * @param reqUrl 请求的url
     * @param headersParams 请求头参数
     * @param imageView  要绑定的imageView
     * @param defResImag 设置默认的图片资源
     */
    public void loadImage(final Context context, final String reqUrl, Map headersParams, final ImageView imageView, final String defResImag) {
        Bitmap result;
        // 从内存缓存中获取图片
        final ImageMemoryCache memoryCache = new ImageMemoryCache(context);
        result = memoryCache.getBitmapFromCache(reqUrl);//看内存中是否有缓存
        if (result != null) {
            imageView.setImageBitmap(result);
            return;
        }
        // 从硬盘缓存中获取图片
        final ImageFileCache fileCache = new ImageFileCache(context);
        result = fileCache.getImage(context, reqUrl);
        if (result != null) {
            imageView.setImageBitmap(result);
            // 添加到内存缓存
            memoryCache.addBitmapToCache(reqUrl, result);
            return;
        }
        Request.Builder RequestBuilder = new Request.Builder();
        RequestBuilder.url(reqUrl);// 添加URL地址
        // RequestBuilder.headers(setHeaders(headersParams));// 添加请求头
        Request request = RequestBuilder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                final Bitmap decodeStream = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);//不注意二次采样容易内存溢出
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (decodeStream != null) {
                                imageView.setImageBitmap(decodeStream);
                                // 缓存在文件
                                fileCache.saveBitmap(context, decodeStream, reqUrl);
                                // 缓存在内存
                                memoryCache.addBitmapToCache(reqUrl, decodeStream);
                            } else {
                                // 加载图片
                                imageView.setImageResource(context.getResources().getIdentifier(defResImag, "drawable", context.getPackageName()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            call.cancel();
                        }
                    }
                });
            }
            @Override
            public void onFailure(final Call call, final IOException exception) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 加载图片
                        imageView.setImageResource(context.getResources().getIdentifier(defResImag, "drawable", context.getPackageName()));
                        call.cancel();
                    }
                });
            }
        });
    }
    public  interface NetCallback {
        public abstract void onFailure(int code, String msg);
        public abstract void onSuccess(int code, String content);
        public abstract void loadImage(Bitmap bitmap);//这个方法在这里就没什么用了
    }
}

