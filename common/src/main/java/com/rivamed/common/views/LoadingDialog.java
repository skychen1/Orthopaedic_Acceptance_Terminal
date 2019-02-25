package com.rivamed.common.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.R;


/**
 * 项目名称:    Rivamed_High_2.6
 * 创建者:      LiangDanMing
 * 创建时间:    2018/3/28 9:22
 * 描述:        加载的dialog
 * 包名:        high.rivamed.myapplication.views;
 * <p/>
 * 更新者：     $$Author$$
 * 更新时间：   $$Date$$
 * 更新描述：   ${TODO}
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {

        private Context mContext;
        private ImageView mLoading;
        private TextView mTvMsg;
        public LoadingDialog mDialog;
        public AnimationDrawable mAnimationDrawable;

        private String mMsg;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setMsg(String Msg) {
            mMsg = Msg;
            return this;
        }

        public LoadingDialog create() {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            mDialog = new LoadingDialog(mContext, R.style.Dialog);
            mDialog.setCancelable(false);
            mDialog.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (mAnimationDrawable != null) {
                        mAnimationDrawable.stop();
                    }
                }
            });
            View layout = inflater.inflate(R.layout.dialog_loading_layout, null);
            mLoading = (ImageView) layout.findViewById(R.id.animProgress);
            mTvMsg = (TextView) layout.findViewById(R.id.tv_error_layout);
            if (!TextUtils.isEmpty(mMsg)) {
                mTvMsg.setText(mMsg);
            }
            mDialog.addContentView(layout,
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
            Window window = mDialog.getWindow();
            if (mDialog != null && window != null) {
                WindowManager.LayoutParams attr = window.getAttributes();
                if (attr != null) {
                    attr.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    attr.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    attr.gravity = Gravity.CENTER;//设置dialog 在布局中的位置
                }
            }
            mAnimationDrawable = (AnimationDrawable) mLoading.getBackground();
            mAnimationDrawable.start();
            return mDialog;
        }
    }

    @Override
    public void show() {
        // Set the dialog to not focusable.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        // Show the dialog with NavBar hidden.
        super.show();
        // Set the dialog to focusable again.
       //
        // getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}
