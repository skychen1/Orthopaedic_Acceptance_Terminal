package com.rivamed.common.views.amosbodialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.rivamed.common.R;


/**
 * @author : Amos_bo
 * @package: com.xb.myapplication.amosbodialog
 * @Created Time: 2018/7/31 17:55
 * @Changed Time: 2018/7/31 17:55
 * @email: 284285624@qq.com
 * @Org: SZKT
 * @version: V1.0
 * @describe: //TODO 添加描述
 */
public class AmosBoDialog extends Dialog {

    private AmosBoDialogController mController;

    public AmosBoDialog(Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mController = new AmosBoDialogController(this, getWindow());
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */

    public void setText(int viewId, CharSequence text) {
        mController.setText(viewId, text);
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listener
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        mController.setOnClickListener(viewId, listener);
    }

    public <T extends View> T getView(int viewId) {
        return mController.getView(viewId);
    }

    public static class Builder {

        private AmosBoDialogController.DialogParams mDialogParams;

        public Builder(Context context) {
            this(context, R.style.Dialog);
        }

        public Builder(Context context, int themeResId) {
            mDialogParams = new AmosBoDialogController.DialogParams(context, themeResId);
        }

        public Builder setContentView(View view) {
            mDialogParams.mRootView = view;
            mDialogParams.mViewLayoutResId = 0;
            return this;
        }

        public Builder setContentView(int layoutId) {
            mDialogParams.mRootView = null;
            mDialogParams.mViewLayoutResId = layoutId;
            return this;
        }

        public Builder setText(int viewId, CharSequence text) {
            mDialogParams.mTextArray.put(viewId, text);
            return this;
        }

        public Builder setOnClickListener(int view, View.OnClickListener listener) {
            mDialogParams.mClickArray.put(view, listener);
            return this;
        }

        //配置一些万能的参数
        //全屏
        public Builder fullWidth() {
            mDialogParams.mWidth = ViewGroup.LayoutParams.MATCH_PARENT;
            return this;
        }

        //从底部弹出
        public Builder fromBottom(boolean isAnimation) {
            if (isAnimation) {
                mDialogParams.mAnimation = R.style.dialog_from_bottom_anim;
            }
            mDialogParams.mGravity = Gravity.BOTTOM;
            return this;
        }

        //设置宽高
        public Builder fromWidthHeight(int width, int height) {
            mDialogParams.mWidth = width;
            mDialogParams.mHeight = height;
            return this;
        }

        //设置默认动画
        public Builder addDefaultAnimation() {
            mDialogParams.mAnimation = R.style.Dialog;
            return this;
        }

        //设置自定义动画
        public Builder addAnimations(int styleAnimation) {
            mDialogParams.mAnimation = styleAnimation;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            mDialogParams.mCanceable = cancelable;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            mDialogParams.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            mDialogParams.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            mDialogParams.mOnKeyListener = onKeyListener;
            return this;
        }

        private AmosBoDialog create() {
            final AmosBoDialog dialog = new AmosBoDialog(mDialogParams.mContext, mDialogParams
                    .mThemeResId);
            mDialogParams.apply(dialog.mController);
            dialog.setCancelable(mDialogParams.mCanceable);
            if (mDialogParams.mCanceable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(mDialogParams.mOnCancelListener);
            dialog.setOnDismissListener(mDialogParams.mOnDismissListener);
            if (mDialogParams.mOnKeyListener != null) {
                dialog.setOnKeyListener(mDialogParams.mOnKeyListener);
            }
            return dialog;
        }

        public AmosBoDialog show() {
            final AmosBoDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }

    /**
     * 防止有底部虚拟键的手机先弹出底部虚拟键
     */
    @Override
    public void show() {
        // Set the dialog to not focusable.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        // Show the dialog with NavBar hidden.
        super.show();
//        // Set the dialog to focusable again.//TODO  放开会出现底部虚拟键BUG暂时保留
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    @SuppressLint("NewApi")
    private void copySystemUiVisibility() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    this.getWindow().getDecorView().getSystemUiVisibility());
        }
    }
}
