package com.rivamed.common.base.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.rivamed.common.BuildConfig;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.TokenUtils;
import com.rivamed.common.utils.crash.CrashHandler;
import com.rivamed.common.utils.crash.LogcatHelper;
import com.rivamed.common.utils.crash.MyHttpLoggingInterceptor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * @author Administrator
 */
abstract public class BaseApplication extends Application {
    /**
     * 用于存放所有启动的Activity的集合
     */
    private List<Activity> mAllStackActivityList = new LinkedList<>();
    private static BaseApplication instance;
    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    private LoginInvalidListener mLoginInvalidListener;

    public static synchronized BaseApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks =
                new AppActivityLifecycleCallbacks());
        if (!BuildConfig.DEBUG) {
            CrashHandler crashHandler = CrashHandler.getInstance();
            crashHandler.init(this);
            LogcatHelper.getInstance(this).start();
        } else {
            //开启严苛模式
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
        instance = this;
        initOkGo();
        initAppConfigure();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * 加载网络框架
     */
    private void initOkGo() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //log相关
        MyHttpLoggingInterceptor loggingInterceptor = new MyHttpLoggingInterceptor("OkGo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setColorLevel(Level.INFO);
        //log颜色级别，决定了log在控制台显示的颜色
        builder.addInterceptor(loggingInterceptor);
        //添加OkGo默认debug日志
        //第三方的开源库，使用通知显示当前请求的log，不过在做文件下载的时候，这个库好像有问题，对文件判断不准确
        //builder.addInterceptor(new ChuckInterceptor(this));
        //超时时间设置，默认60秒
        builder.readTimeout(15000, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(15000, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(15000, TimeUnit.MILLISECONDS);   //全局的连接超时时间

        //自动管理cookie（或者叫session的保持），以下几种任选其一就行
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        // 使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));
        //使用数据库保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
        // 使用内存保持cookie，app退出后，cookie消失

        // 其他统一的配置
        // 详细说明看GitHub文档：https://github.com/jeasonlzy/
        OkGo.getInstance().init(this)                           //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置会使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(0);                              //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次
        // (一次原始请求，三次重连请求)，不需要可以设置为0
        OkGoUtil.initRootUrl(getRootUrl());
    }

    /**
     * 添加Activity
     */
    public void addActivity_(Activity activity) {
        // 判断当前集合中不存在该Activity
        if (!mAllStackActivityList.contains(activity)) {
            mAllStackActivityList.add(activity);//把当前Activity添加到集合中
        }
    }

    /**
     * 销毁单个Activity
     */
    public void removeActivity_(Activity activity) {
        //判断当前集合中存在该Activity
        if (mAllStackActivityList.contains(activity)) {
            mAllStackActivityList.remove(activity);//从集合中移除
            activity.finish();//销毁当前Activity
        }
    }

    /**
     * 销毁单个Activity
     */
    /**
     * 删除指定Activity
     *
     * @param name
     */
    public void reMoveActivity(String name) {
        for (Activity activity : mAllStackActivityList) {
            if (activity.getClass().getName().equals(name)) {
                activity.finish();
            }
        }
    }

    /**
     * 销毁所有的Activity
     */
    public void removeALLActivity_() {
        //通过循环，把集合中的所有Activity销毁
        for (Activity activity : mAllStackActivityList) {
            activity.finish();
        }
    }


    public ActivityLifecycleCallbacks getInstanceActivityLifecycleCallbacks() {
        if (mActivityLifecycleCallbacks != null) {
            return mActivityLifecycleCallbacks;
        }
        return null;
    }

    /**
     * @param
     * @return void 返回类型
     * @throws
     * @Title: exitApp
     * @Description: 退出APP
     */
    public void exitApp() {
        for (Activity activity : mAllStackActivityList) {
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 重写 getResource 方法，防止系统字体影响;禁止app字体大小跟随系统字体大小调节
     */
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources != null && resources.getConfiguration().fontScale != 1.0f) {
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    /**
     * 设置Token失效监听
     *
     * @param loginInvalidListener
     * @param tokenTag             token检验关键字
     * @param tokenInvalidCode     过期id标志码
     */
    public void addLoginInvalidListener(@NonNull LoginInvalidListener loginInvalidListener,
                                        String tokenTag, String tokenInvalidCode) {
        this.mLoginInvalidListener = loginInvalidListener;
        TokenUtils.TOKEN_TAG = tokenTag;
        TokenUtils.TOKEN_INVALID_CODE = tokenInvalidCode;
        TokenUtils.IS_USE_TOKEN = true;
    }

    /**
     * 设置Token失效监听
     *
     * @param loginInvalidListener
     */
    public void addLoginInvalidListener(@NonNull LoginInvalidListener loginInvalidListener) {
        this.addLoginInvalidListener(loginInvalidListener, "opFlg", "1010");
    }

    public LoginInvalidListener getLoginInvalidListener() {
        return mLoginInvalidListener;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //非默认值
        if (newConfig.fontScale != 1) {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 初始化根地址
     *
     * @return
     */
    protected abstract String getRootUrl();

    /**
     * 初始化配置
     */
    protected abstract void initAppConfigure();
}
