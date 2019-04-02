package com.rivamed.orthopaedicacceptanceterminal.views;

/**
 * @作者: 钱凯
 * @创建时间: 2018/8/7
 * @功能描述:
 */

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rivamed.orthopaedicacceptanceterminal.R;

import java.util.ArrayList;
import java.util.List;

public class ListPopupWindow {

    private int mPopupWindowType;
    private List<String> list = new ArrayList<>();
    private List<String> data;
    private Context mContext;
    private ListView listView;
    public PopupWindow popwindow;
    private IPopCallBack callback;
    private View parentView;
    public PopupAdapter mAdapter;
    int selectedPosition = -1;
    private TextView tvLeft;
    private TextView tvRight;
    private LinearLayout.LayoutParams mLayoutParams;
    private LinearLayout.LayoutParams mLayoutParams2;
    private LinearLayout.LayoutParams mLayoutParams3;
    private View mView;
    private int mWidthType;


    public ListPopupWindow(Context mContext, List<String> data, View parentView, IPopCallBack callback) {
        this.mContext = mContext;
        this.data = data;
        this.parentView = parentView;
        this.callback = callback;
        mView = setView(1);
        listView = (ListView) mView.findViewById(R.id.first_listview);
        tvLeft = (TextView) mView.findViewById(R.id.tv_left);
        tvRight = (TextView) mView.findViewById(R.id.tv_right);
        mLayoutParams = (LinearLayout.LayoutParams) listView.getLayoutParams();
        mLayoutParams2 = (LinearLayout.LayoutParams) tvRight.getLayoutParams();
        mLayoutParams3 = (LinearLayout.LayoutParams) tvLeft.getLayoutParams();
    }


    public PopupWindow getWindow() {
        return popwindow;
    }

    /**
     * 设置PopupWindow的View
     *
     * @return
     */
    public View setView(int popupWindowCount) {
        View view = null;
        switch (popupWindowCount) {
            case 1:
                view = View.inflate(mContext, R.layout.pop_select_list, null);
                return view;
            default:
                break;
        }
        return view;
    }

    /**
     * @param windowLoaction 展示PopupWindow的位置 0:屏幕中央 1：屏幕底部 2：控件下方
     */
    @SuppressLint("NewApi")
    public void showPopup(int windowLoaction) {
        //如果大于一定数量，设置高度
        if (this.data.size() < 13) {
            //创建PopupWindow
            popwindow = new PopupWindow(mView, LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT, true);
        } else {
            //创建PopupWindow
            popwindow = new PopupWindow(mView, LayoutParams.MATCH_PARENT,
                    parentView.getHeight() / 2 + 200, true);
            //下拉选项框效果
        }

        setData(this.data, listView, 1);
        popwindow.setContentView(mView);
        popwindow.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        popwindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        popwindow.setFocusable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        popwindow.setBackgroundDrawable(dw);
        popwindow.setAnimationStyle(R.style.social_pop_anim);

        //显示的位置
        switch (windowLoaction) {
            //在屏幕中央
            case 0:
                popwindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);
                break;
            //在屏幕底部
            case 1:
                popwindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
                break;
            //在控件下面
            case 2:
                popwindow.showAsDropDown(parentView, 0, 0);
                break;
        }
        //        popwindow.showAtLocation(parentView, Gravity.CENTER,200,(parentView.getHeight()-popwindow.getHeight())/2);
        setListener();
    }

    /**
     * @param widthType 0:宽度充满屏幕  1:和父控件等宽
     * @param rightDistence 距离右侧距离(px)
     * @param leftDistence 距离左侧距离(px)
     */
    @SuppressLint("NewApi")
    public void showPopup(int windowLoaction, int widthType, int rightDistence, int leftDistence) {
        //显示ListView的类型
        setWidthType(widthType);

        setRightDistence(rightDistence);

        setLeftDistence(widthType, leftDistence);
        //Dialog效果
        //如果大于一定数量，设置高度
        if (this.data.size() < 13) {
            //创建PopupWindow
            popwindow = new PopupWindow(mView, LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT, true);
        } else {
            //创建PopupWindow
            popwindow = new PopupWindow(mView, LayoutParams.MATCH_PARENT,
                    parentView.getHeight() / 2 + 200, true);
            //下拉选项框效果
        }

        setData(this.data, listView, 1);
        popwindow.setContentView(mView);
        popwindow.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        popwindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        popwindow.setFocusable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        popwindow.setBackgroundDrawable(dw);
        popwindow.setAnimationStyle(R.style.social_pop_anim);

        //显示的位置
        switch (windowLoaction) {
            //在屏幕中央
            case 0:
                popwindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);
                break;
            //在屏幕底部
            case 1:
                popwindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
                break;
            //在控件下面
            case 2:
                popwindow.showAsDropDown(parentView, 0, 0);
                break;
        }
        //        popwindow.showAtLocation(parentView, Gravity.CENTER,200,(parentView.getHeight()-popwindow.getHeight())/2);
        setListener();
    }

    /**
     * @param leftDistence 距离左侧距离(px)
     */
    public ListPopupWindow setLeftDistence(int widthType, int leftDistence) {
        mWidthType = widthType;
        if (mWidthType == 0) {
            mLayoutParams3.width = leftDistence;
            tvLeft.setLayoutParams(mLayoutParams3);
        }
        return this;
    }

    /**
     * @param rightDistence 距离右侧距离(px)
     */
    public ListPopupWindow setRightDistence(int rightDistence) {
        mLayoutParams2.width = rightDistence;
        tvRight.setLayoutParams(mLayoutParams2);
        return this;
    }

    /**
     * @param widthType 0:宽度充满屏幕  1:和父控件等宽
     */
    public ListPopupWindow setWidthType(int widthType) {
        switch (widthType) {
            case 0:
                mLayoutParams.width = LayoutParams.MATCH_PARENT;
                mLayoutParams.weight = 1;
                listView.setLayoutParams(mLayoutParams);
                break;
            case 1:
                mLayoutParams.width = parentView.getWidth();
                listView.setLayoutParams(mLayoutParams);
                mLayoutParams3.width = LayoutParams.MATCH_PARENT;
                mLayoutParams3.weight = 1;
                tvLeft.setLayoutParams(mLayoutParams3);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * 设置listview点击事件
     */
    private void setListener() {
        // TODO Auto-generated method stub
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //                if (mPopupWindowType == 2) {
                //                    setSelected(position);
                //                }
                if (callback != null) {
                    callback.callBack(list.get(position), position);
                }
                if (popwindow.isShowing()) {
                    popwindow.dismiss();
                }
            }
        });

        tvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popwindow.isShowing()) {
                    popwindow.dismiss();
                }
            }
        });
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popwindow.isShowing()) {
                    popwindow.dismiss();
                }
            }
        });
    }

    /**
     * 给Popup设置数据
     *
     * @param data
     * @param popupWindowType
     */
    public void setData(List<String> data, ListView listView, int popupWindowType) {
        this.list = new ArrayList<String>();
        list.addAll(data);
        mAdapter = new PopupAdapter(list, popupWindowType);
        listView.setAdapter(mAdapter);
    }

    public void setData(List<String> data) {
        this.list.clear();
        list.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    private class PopupAdapter extends BaseAdapter {

        private List<String> list;

        public PopupAdapter(List<String> list, int popupWindowType) {
            super();
            this.list = list;
            mPopupWindowType = popupWindowType;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                if (mPopupWindowType == 1) {
                    convertView = View.inflate(mContext, R.layout.item_list_pop, null);
                }
                holder.getView(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.poptext.setText(list.get(position));

            return convertView;
        }

        class ViewHolder {
            TextView poptext;

            public void getView(View v) {
                poptext = (TextView) v.findViewById(R.id.text);
            }
        }

    }

    public void setSelected(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 点击pop回调接口
     */
    public interface IPopCallBack {
        void callBack(String content, int posotion);
    }

}

