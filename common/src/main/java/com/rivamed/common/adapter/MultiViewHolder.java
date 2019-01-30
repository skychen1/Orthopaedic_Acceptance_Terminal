package com.rivamed.common.adapter;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.method.MovementMethod;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @ClassName
 * @Description
 * @Author Xiangbo
 * @Date 2016/12/15 14:16
 */

public class MultiViewHolder extends RecyclerView.ViewHolder {

    /**
     * 多布局列表类型
     */
    private int mViewType;

    private SparseArray<View> childViews = new SparseArray<>();

    public MultiViewHolder(View itemView) {
        super(itemView);
    }

    public MultiViewHolder(View itemView, int viewType) {
        super(itemView);
        mViewType = viewType;
    }


    public int getViewType() {
        return mViewType;
    }

    /**
     * Deprecated. Use {@link #findViewById(int)} instead for a better understanding.
     * It will be removed in a future release!
     */
    @Deprecated
    public <T extends View> T getView(int id) {
        Log.e("MultiViewHolder", "Deprecated method 'getView(int)', please use 'findViewById(int)' instead.");
        return findViewById(id);
    }

    /**
     * @param id  View id
     * @param <T> Subclass of View
     * @return Child view
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int id) {
        View childView = childViews.get(id);
        if (childView == null) {
            childView = itemView.findViewById(id);
            if (childView != null)
                childViews.put(id, childView);
            else
                return null;
        }
        return (T) childView;
    }



    public MultiViewHolder setText(int viewId, CharSequence text) {
        TextView textView = findViewById(viewId);
        textView.setText(text);
        return this;
    }

    public MultiViewHolder setTextColor(int viewId, int textColor) {
        TextView view = findViewById(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public MultiViewHolder setTextColor(int viewId, ColorStateList colorStateList) {
        TextView view = findViewById(viewId);
        view.setTextColor(colorStateList);
        return this;
    }

    public MultiViewHolder setMovementMethod(int viewId, MovementMethod method) {
        TextView textView = findViewById(viewId);
        textView.setMovementMethod(method);
        return this;
    }

    public MultiViewHolder setImageResource(int viewId, @DrawableRes int resId) {
        ImageView view = findViewById(viewId);
        view.setImageResource(resId);
        return this;
    }

    public MultiViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = findViewById(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public MultiViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = findViewById(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public MultiViewHolder setImageUri(int viewId, Uri imageUri) {
        ImageView view = findViewById(viewId);
        view.setImageURI(imageUri);
        return this;
    }

    public MultiViewHolder setScaleType(int viewId, ImageView.ScaleType type) {
        ImageView view = findViewById(viewId);
        view.setScaleType(type);
        return this;
    }

    public MultiViewHolder setBackgroundColor(int viewId, @ColorInt int bgColor) {
        View view = findViewById(viewId);
        view.setBackgroundColor(bgColor);
        return this;
    }

    public MultiViewHolder setBackgroundResource(int viewId, @DrawableRes int bgRes) {
        View view = findViewById(viewId);
        view.setBackgroundResource(bgRes);
        return this;
    }

    public MultiViewHolder setColorFilter(int viewId, ColorFilter colorFilter) {
        ImageView view = findViewById(viewId);
        view.setColorFilter(colorFilter);
        return this;
    }

    public MultiViewHolder setColorFilter(int viewId, int colorFilter) {
        ImageView view = findViewById(viewId);
        view.setColorFilter(colorFilter);
        return this;
    }

    public MultiViewHolder setAlpha(int viewId, @FloatRange(from = 0.0, to = 1.0) float value) {
        View view = findViewById(viewId);
        ViewCompat.setAlpha(view, value);
        return this;
    }

    public MultiViewHolder setVisibility(int viewId, int visibility) {
        View view = findViewById(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public MultiViewHolder setMax(int viewId, int max) {
        ProgressBar view = findViewById(viewId);
        view.setMax(max);
        return this;
    }

    public MultiViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = findViewById(viewId);
        view.setProgress(progress);
        return this;
    }

    public MultiViewHolder setRating(int viewId, float rating) {
        RatingBar view = findViewById(viewId);
        view.setRating(rating);
        return this;
    }

    public MultiViewHolder setTag(int viewId, Object tag) {
        View view = findViewById(viewId);
        view.setTag(tag);
        return this;
    }

    public MultiViewHolder setEnabled(int viewId, boolean enabled) {
        View view = findViewById(viewId);
        view.setEnabled(enabled);
        return this;
    }

    public MultiViewHolder setAdapter(int viewId, Adapter adapter) {
        AdapterView<Adapter> view = findViewById(viewId);
        view.setAdapter(adapter);
        return this;
    }

   
    public MultiViewHolder setAdapter(int viewId, RecyclerView.Adapter adapter) {
        RecyclerView view = findViewById(viewId);
        view.setAdapter(adapter);
        return this;
    }

   
    public MultiViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = findViewById(viewId);
        view.setChecked(checked);
        return this;
    }

   
    public MultiViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
        return this;
    }

   
    public MultiViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        findViewById(viewId).setOnLongClickListener(listener);
        return this;
    }

   
    public MultiViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        findViewById(viewId).setOnTouchListener(listener);
        return this;
    }

    public interface IMulItemViewType<T> {
        /**
         * Item view type, a non-negative integer is better.
         *
         * @param position current position of ViewHolder
         * @param t        model item
         * @return viewType
         */
        int getItemViewType(int position, T t);

        /**
         * Layout res.
         *
         * @param viewType {@link #getItemViewType(int, T)}
         * @return {@link android.support.annotation.LayoutRes}
         */
        @LayoutRes
        int getLayoutId(int viewType);
    }
}
