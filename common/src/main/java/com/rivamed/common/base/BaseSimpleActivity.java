package com.rivamed.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rivamed.common.R;

import java.lang.ref.WeakReference;

/**
 * 项目名称:    Rivamed_High_2.5
 * 创建者:      LiangDanMing
 * 创建时间:    2018/6/18 9:31
 * 描述:        有标题栏的activity基类
 * 包名:        high.rivamed.myapplication.base
 * <p>
 * 更新者：     $$Author$$
 * 更新时间：   $$Date$$
 * 更新描述：   ${TODO}
 * @author Administrator
 */

public abstract class BaseSimpleActivity extends SimpleActivity {

    RelativeLayout baseTabContent;
    Toolbar toolbar;
    AppBarLayout appbar;
    ViewStub viewStubLayout;
    /**
     * 处理异常数据
     */
    ViewStub emptyView;
    /**
     * 控件集合
     */
    private SparseArray<WeakReference<View>> mViews;

    private View mAppBarView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_title;
    }

    @Override
    public void onBindViewBefore() {
        viewStubLayout = (ViewStub) findViewById(R.id.view_stub_layout);
        viewStubLayout.setLayoutResource(getContentLayoutId());
        viewStubLayout.inflate();
        initAppBar(getAppBarLayoutId());
    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void initAppBar(int layoutSrc) {
        baseTabContent = findViewById(R.id.base_tab_content);
        mViews = new SparseArray<>();
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mAppBarView = inflater.inflate(layoutSrc, null);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mAppBarView.setLayoutParams(lp);
        if (baseTabContent != null && baseTabContent.getChildCount() > 0) {
            baseTabContent.removeAllViews();
        }
        baseTabContent.addView(mAppBarView);
    }

    protected abstract int getContentLayoutId();

    /**
     * 顶部栏布局，每个应用自由定制
     *
     * @return
     */
    protected abstract int getAppBarLayoutId();

    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 减少查找View次数
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getViewById(@IdRes int viewId) {
        View view = null;
        WeakReference<View> weakReference = mViews.get(viewId);
        if (weakReference != null) {
            view = weakReference.get();
        }
        if (view == null) {
            view = mAppBarView.findViewById(viewId);
            mViews.put(viewId, new WeakReference<View>(view));
        }
        return (T) view;
    }

    //***************************************空页面和数据错误处理*************************************
    protected void showEmptyView(String text) {
        showEmptyOrErrorView(text, R.drawable.ic_empty_data, false);
    }

    protected void showEmptyView() {
        showEmptyView(getString(R.string.no_data));
    }

    protected void showErrorView(String text) {
        showEmptyOrErrorView(text, R.drawable.ic_data_error, true);
    }

    protected void showErrorView() {
        showErrorView(getString(R.string.error_data));
    }

    protected void hideEmptyOrErrorView() {
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
    }

    private void showEmptyOrErrorView(String text, int img, boolean isCanreTry) {
        if (emptyView == null) {
            emptyView = findViewById(R.id.view_stub_empty);
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.VISIBLE);
            findViewById(R.id.img_tip_logo).setBackgroundResource(img);
            ((TextView) findViewById(R.id.tv_tips)).setText(text);
            if (isCanreTry) {
                findViewById(R.id.bt_operate).setVisibility(View.VISIBLE);
                findViewById(R.id.bt_operate).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onReTryClick();
                    }
                });
            } else {
                findViewById(R.id.bt_operate).setVisibility(View.GONE);
            }
        }
    }

    /**
     * 重试按钮被点击
     */
    protected void onReTryClick() {

    }

}
