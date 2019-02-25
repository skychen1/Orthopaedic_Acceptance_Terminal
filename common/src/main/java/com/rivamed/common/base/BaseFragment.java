package com.rivamed.common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.rivamed.common.R;

/**
 * @ProjectName: AmosBoCommon
 * @Package: com.rivamed.common.base
 * @ClassName: BaseFragment
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2018/11/26 15:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/11/26 15:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract public class BaseFragment extends AmosBoLazyFragment {
    private ViewStub emptyView;
    private View mRootView;
    @Override
    View getLayoutView() {
        if (mRootView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mRootView = inflater.inflate(R.layout.fragment_base_layout, null);
            ViewGroup contentView = mRootView.findViewById(R.id.fl_content);
            if (contentView != null && contentView.getChildCount() > 0) {
                contentView.removeAllViews();
            }
            contentView.addView(getLayoutInflater().inflate(getLayoutId(), null));
        }
        return mRootView;
    }

    @Override
    public void onBindViewBefore() {

    }

    @Override
    public Object newP() {
        return null;
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
            emptyView = mRootView.findViewById(R.id.vs_empty);
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.VISIBLE);
            mRootView.findViewById(R.id.img_tip_logo).setBackgroundResource(img);
            ((TextView) mRootView.findViewById(R.id.tv_tips)).setText(text);
            if (isCanreTry) {
                mRootView.findViewById(R.id.bt_operate).setVisibility(View.VISIBLE);
                mRootView.findViewById(R.id.bt_operate).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onReTryClick();
                    }
                });
            } else {
                mRootView.findViewById(R.id.bt_operate).setVisibility(View.GONE);
            }
        }
    }

    /**
     * 重试按钮被点击
     */
    protected void onReTryClick() {

    }

}
