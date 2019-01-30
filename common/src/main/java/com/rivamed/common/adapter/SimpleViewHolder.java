package com.rivamed.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @ClassName
 * @Description
 * @Author Xiangbo
 * @Date 2016/12/15 14:16
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    public View mRoot;
    /**
     * 多布局列表类型
     */
    public int mViewType;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        mRoot = itemView;
        ButterKnife.bind(this, itemView);
    }

    public SimpleViewHolder(View itemView, int viewType) {
        super(itemView);
        mRoot = itemView;
        mViewType = viewType;
        ButterKnife.bind(this, itemView);
    }
}
