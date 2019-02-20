package com.rivamed.common.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SupportActivity;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.lzy.okgo.OkGo;
import com.rivamed.common.R;
import com.rivamed.common.base.mvp.IPresent;
import com.rivamed.common.base.mvp.IView;
import com.rivamed.common.base.mvp.KnifeKit;
import com.rivamed.common.base.mvp.VDelegate;
import com.rivamed.common.base.mvp.VDelegateBase;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.UIUtils;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 项目名称:    Rivamed_High_2.5
 * 创建者:      DanMing
 * 创建时间:    2018/6/14 16:23
 * 描述:       仿照XActivity写的基类没有标题栏
 * 包名:        high.rivamed.myapplication.fragment
 * <p>
 * 更新者：     $$Author$$
 * 更新时间：   $$Date$$
 * 更新描述：   ${TODO}
 */
public abstract class SimpleActivity<P extends IPresent> extends SupportActivity implements IView<P> {

    private VDelegate vDelegate;
    private P p;
    public Activity mContext;
    private Unbinder unbinder;

    /**
     * 全局网络提示控件
     */
    private View mTipView;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    //默认不检查网络状态
    protected boolean mCheckNetWork = false;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIsFullScreen()) {
            //设置全屏
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (getIsImmersionBar()) {
            ImmersionBar.with(this).init();
        }
        //屏幕常亮
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mContext = this;
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            onBindViewBefore();
            bindUI(null);
            bindEvent();
        }
        initDataAndEvent(savedInstanceState);
    }


    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this);
    }

    protected VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(mContext);
        }
        return vDelegate;
    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getvDelegate().resume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        getvDelegate().pause();
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
        OkGo.getInstance().cancelTag(this);
        UIUtils.removeAllCallbacks();
        if (getP() != null) {
            getP().detachV();
        }
        getvDelegate().destory();
        p = null;
        vDelegate = null;
        unbinder.unbind();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getOptionsMenuId() > 0) {
            getMenuInflater().inflate(getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public void bindEvent() {

    }

    protected void startActivity(Class<? extends Activity> cls) {
        startActivity(cls, null);
    }

    protected void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivityForResult(Class<? extends Activity> cls, Bundle bundle,
                                          int requestCode) {
        Intent localIntent = new Intent();
        if (bundle != null) {
            localIntent.putExtras(bundle);
        }
        localIntent.setClass(this, cls);
        startActivityForResult(localIntent, requestCode);
    }

    protected void startActivityForResult(Class<? extends Activity> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    protected static <T extends Parcelable> void startActivity(Context context, Class<?> actvity,
                                                               String dataTag, T data) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(dataTag, data);
        Intent intent = new Intent(context, actvity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 界面跳转传参
     *
     * @param context
     * @param actvity 界面
     * @param dataTag 数据标签
     * @param data    传输数据
     * @param <T>
     */
    protected static <T extends Serializable> void startActivityWithSerializable(Context context,
                                                                                 Class<?> actvity
            , String dataTag, T data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(dataTag, data);
        Intent intent = new Intent(context, actvity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 界面跳转传参
     *
     * @param context
     * @param actvity 界面
     * @param dataTag 数据标签
     * @param data    传输数据
     * @param <T>
     */
    protected static <T extends Parcelable> void startActivityWithParcelable(Context context,
                                                                             Class<?> actvity,
                                                                             String dataTag,
                                                                             T data) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(dataTag, data);
        Intent intent = new Intent(context, actvity);
        context.startActivity(intent);
    }

    protected void setResult(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(RESULT_OK, intent);
        this.finish();
    }

    protected String getBundleStringVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Vaule = bundle.getString(key);
            if (!TextUtils.isEmpty(Vaule)) {
                return Vaule;
            }
        }
        return null;
    }

    protected boolean getBundleBooleanVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            boolean Vaule = bundle.getBoolean(key, false);
            return Vaule;
        }
        return false;
    }

    protected int getBundleIntVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int Vaule = bundle.getInt(key, -1);
            return Vaule;
        }
        return -1;
    }

    protected <T extends Serializable> T getBundleSerializableVaule(String key, Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            T Vaule = (T) bundle.getSerializable(key);
            return Vaule;
        }
        return null;
    }

    /**
     * 是否全屏
     *
     * @return
     */
    public boolean getIsFullScreen() {
        return false;
    }

    /**
     * 是否状态栏沉浸
     *
     * @return
     */
    public boolean getIsImmersionBar() {
        return false;
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            //获取触摸动作，如果ACTION_UP，计时开始。
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_DOWN:
                View v = getCurrentFocus();
                if (isShouldHideInput(v, ev)) {
                    hideInputWindow(v);
                }
                break;
            default:
                break;
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void hideInputWindow(View v) {
        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否启用无网络提示
     *
     * @param checkNetWork
     */
    public void setCheckNetWork(boolean checkNetWork) {
        mCheckNetWork = checkNetWork;
    }

    public boolean isCheckNetWork() {
        return mCheckNetWork;
    }

    /**
     * 初始化网络提示控件
     */
    private void initTipView() {
        LayoutInflater inflater = getLayoutInflater();
        mTipView = inflater.inflate(R.layout.layout_network_tip, null); //提示View布局
        mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, PixelFormat.TRANSLUCENT);
        //使用非CENTER时，可以通过设置XY的值来改变View的位置
        mLayoutParams.gravity = Gravity.TOP;
        mLayoutParams.x = 0;
        mLayoutParams.y = 0;
    }

    /***
     * 网络监听接受
     * @param has
     */
    private void hasNetWork(boolean has) {
        if (isCheckNetWork()) {
            if (has) {
                if (mTipView != null && mTipView.getParent() != null) {
                    mWindowManager.removeView(mTipView);
                }
            } else {
                if (mTipView.getParent() == null) {
                    mWindowManager.addView(mTipView, mLayoutParams);
                }
            }
        }
    }

    @Override
    public void finish() {
        //当提示View被动态添加后直接关闭页面会导致该View内存溢出，所以需要在finish时移除
        if (mTipView != null && mTipView.getParent() != null) {
            mWindowManager.removeView(mTipView);
        }
        super.finish();
    }
}
