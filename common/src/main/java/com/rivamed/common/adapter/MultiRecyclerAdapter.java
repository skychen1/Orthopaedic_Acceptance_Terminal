package com.rivamed.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title:基类
 * @Package com.zowee.roadbusiness.adapter
 * @Description: 混合布局
 * @date 2016/12/12 16:51
 */
public abstract class MultiRecyclerAdapter<T> extends
        RecyclerView.Adapter<MultiViewHolder> {

    protected OnItemClickListener mOnItemClickListener;
    protected Context mContext;
    protected List<T> mList;
    protected MultiViewHolder.IMulItemViewType<T> mIMulItemViewType;
    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }

    public MultiRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mIMulItemViewType = getMultiItemViewType();
    }


    @Override
    public void onBindViewHolder(MultiViewHolder holder, int position) {
        if (mList != null && mList.size() > 0) {
            convert(holder, mList.get(position), position);
        }
    }

    protected abstract void convert(final MultiViewHolder holder, T t, final int position);

    @Override
    public MultiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(mIMulItemViewType.getLayoutId(viewType), parent,
                    false);
            return new MultiViewHolder(itemView, viewType);
        } catch (Exception e) {
            throw new IllegalArgumentException("泛型错误");
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mIMulItemViewType.getItemViewType(position, mList.get(position));
    }

    /**
     * 获取指定的布局类型的抽象方法，让子类继承实现:以布局Id为Type
     *
     * @param
     * @return
     */
    protected abstract MultiViewHolder.IMulItemViewType<T> getMultiItemViewType();


    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    /**
     * 设置数据源-数组
     */
    public void setList(T[] list) {

        ArrayList<T> arrayList = new ArrayList<T>(list.length);
        for (T t : list) {
            arrayList.add(t);
        }
        setList(arrayList);
    }

    /**
     * 设置数据源-List
     */
    public void setList(List<T> list) {
        this.mList = list;
    }

    /**
     * 获取数据源-List
     */
    public List<T> getList() {
        return mList;
    }


    /**
     * 获取position位置的数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {

        return mList == null ? null : mList.get(position);
    }

    public void addAll(List<T> list) {

        int positionStart = 0;
        if (mList == null) {
            mList = list;
        } else {
            positionStart += mList.size();
            mList.addAll(list);
        }
        notifyItemRangeInserted(positionStart, list.size());
    }

    public void add(T item) {

        if (mList == null) {
            mList = new ArrayList<>(1);
        }
        int size = 0;
        mList.add(item);
        notifyDataSetChanged();
    }

    /**
     * 添加到某一个位置
     **/
    public void add(T item, int position) {

        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(position, item);
        notifyItemInserted(position);
    }

    public void update(T item) {

        if (mList == null) {
            mList = new ArrayList<>();
        }
        int idx = mList.indexOf(item);
        if (idx < 0) {
            add(item);
        } else {
            mList.set(idx, item);
            notifyItemChanged(idx);
        }
    }

    public void update(T item, int position) {

        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.set(position, item);
        notifyItemChanged(position);
    }

    public void reset(List<T> list) {

        mList = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public abstract static class OnItemRootClickListener implements OnItemClickListener {
        @Override
        public void onItemLongClick(View view, int position) {

        }
    }
}
