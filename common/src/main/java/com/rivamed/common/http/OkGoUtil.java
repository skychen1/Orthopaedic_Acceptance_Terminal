package com.rivamed.common.http;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.rivamed.common.http.callback.JsonCallback;

import java.util.Map;

/***
 * 网络工具
 */
public class OkGoUtil {

    public static <T> void getRequest(String url, Object tag, Map<String, String> map, JsonCallback<T> callback) {
        OkGo.<T>get(url)
                .tag(tag)
                .params(map)
                .execute(callback);
    }

    public static <T> void postRequest(String url, Object tag, Map<String, String> map, JsonCallback<T> callback) {
        OkGo.<T>post(url)
                .tag(tag)
                .params(map)
                .execute(callback);
    }

    public static <T> void postJsonRequest(String url, Object tag, Object map, JsonCallback<T> callback) {
        Gson gson = new Gson();
        OkGo.<T>post(url)
                .tag(tag)
                .upJson(gson.toJson(map))
                .execute(callback);
    }

    public static void cancelTagRequest(Object obj) {
        OkGo.getInstance().cancelTag(obj);
    }

    public static void cancelAllRequest() {
        OkGo.getInstance().cancelAll();
    }
}
