package com.rivamed.common.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.rivamed.common.http.callback.JsonCallback;

import java.util.Map;

import static com.lzy.okgo.OkGo.get;

/***
 * 网络工具
 * @author Amos_BO
 */
public class OkGoUtil {
    private static String ROOT_URL;
    private static Gson gson;
    private static String TOKEN_ID;

    /**
     * 初始化根地址
     *
     * @param rootUrl
     */
   synchronized public static void  initRootUrl(@NonNull String rootUrl) {
        ROOT_URL = rootUrl;
        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
     * 设置TokenId
     *
     * @param tokenId
     */
    synchronized public static void updateTokenId(@NonNull String tokenId) {
        TOKEN_ID = tokenId;
    }


    public static <T> void getRequest(String url, Object tag, Map<String, String> map,
                                      JsonCallback<T> callback) {
        GetRequest getRequest = OkGo.<T>get(ROOT_URL + url).tag(tag).params(map);
        if (!TextUtils.isEmpty(TOKEN_ID)) {
            getRequest.headers("tokenId", TOKEN_ID);
        }
        getRequest.execute(callback);
    }

    public static <T> void postRequest(String url, Object tag, Map<String, String> map,
                                       JsonCallback<T> callback) {
        PostRequest postRequest = OkGo.<T>post(ROOT_URL + url).tag(tag).params(map);
        if (!TextUtils.isEmpty(TOKEN_ID)) {
            postRequest.headers("tokenId", TOKEN_ID);
        }
        postRequest.execute(callback);
    }

    public static <T> void postJsonRequest(String url, Object tag, Object map,
                                           JsonCallback<T> callback) {
        try {
            PostRequest postRequest =
                    OkGo.<T>post(ROOT_URL + url).tag(tag).upJson(gson.toJson(map));
            if (!TextUtils.isEmpty(TOKEN_ID)) {
                postRequest.headers("tokenId", TOKEN_ID);
            }
            postRequest.execute(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancelTagRequest(Object obj) {
        OkGo.getInstance().cancelTag(obj);
    }

    public static void cancelAllRequest() {
        OkGo.getInstance().cancelAll();
    }
}
