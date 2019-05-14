package com.rivamed.common.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.R;
import com.rivamed.common.utils.BaseUtils;


/**
 * 项目名称:    Rivamed_High_2.5
 * 创建者:      DanMing
 * 创建时间:    2018/6/14 16:22
 * 描述:        2个按钮的dialog
 * 包名:        high.rivamed.myapplication.fragment
 * <p>
 * 更新者：     $$Author$$
 * 更新时间：   $$Date$$
 * 更新描述：   ${TODO}
 */
public class EditTipDialog extends Dialog {


    public EditTipDialog(Context context) {
        super(context);
    }

    public EditTipDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {

        private Context mContext;
        private String mMsgTwo;
        private String mMsgText;
        private String mLeftText;
        private String mRightText;
        private TextView mRigtht;
        private TextView mLeft;
        private int mLeftTextColor = -1;
        private int mRightTextColor;
        private int mType;
        private TextView mDialogMsg;
        private TextView mDialogRed;
        private ImageView mDialogCloss;
        private ImageView mDialogIcon;
        private EditText mEtContent;

        //提供接口
        public OnInputBackListener mLeftBtn;
        public OnInputBackListener mRightBtn;

        public interface OnInputBackListener {
            void OnInputBack(EditTipDialog dialog, String content);
        }

        public Builder(Context context, int mType) {
            this.mContext = context;
            this.mType = mType;

        }

        public Builder setTwoMsg(String title) {
            this.mMsgTwo = title;
            return this;
        }

        public Builder setMsg(String msg) {
            this.mMsgText = msg;
            return this;
        }

        public Builder setLeft(String left, int color, OnInputBackListener listener) {
            this.mLeftText = left;
            this.mLeftTextColor = color;
            this.mLeftBtn = listener;
            return this;
        }

        public Builder setLeft(String left, OnInputBackListener listener) {
            this.mLeftText = left;
            this.mLeftBtn = listener;
            return this;
        }

        public Builder setRight(String left, int color, OnInputBackListener listener) {
            this.mRightText = left;
            this.mRightTextColor = color;
            this.mRightBtn = listener;
            return this;
        }

        public Builder setRight(String left, OnInputBackListener listener) {
            this.mRightText = left;
            this.mRightBtn = listener;
            return this;
        }

        public EditTipDialog create() {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            final EditTipDialog dialog = new EditTipDialog(mContext, R.style.Dialog);
            dialog.setCancelable(false);
            View layout = inflater.inflate(R.layout.dialog_edit_tip_layout, null);
            dialog.addContentView(layout,
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
            mDialogIcon = (ImageView) layout.findViewById(R.id.dialog_icon);
            mEtContent = (EditText) layout.findViewById(R.id.et_content);
            mDialogMsg = (TextView) layout.findViewById(R.id.dialog_msg);
            mDialogRed = (TextView) layout.findViewById(R.id.dialog_red);
            mDialogCloss = (ImageView) layout.findViewById(R.id.dialog_closs);
            mLeft = (TextView) layout.findViewById(R.id.dialog_left);
            mRigtht = (TextView) layout.findViewById(R.id.dialog_right);
            mDialogMsg.setText(mMsgText);
            if (mType == 1) {
                mDialogRed.setText(mMsgTwo);
            }
            if (mLeftTextColor != -1) {
                mLeft.setTextColor(mLeftTextColor);
                mRigtht.setTextColor(mRightTextColor);
            }
            mLeft.setText(mLeftText);
            mRigtht.setText(mRightText);

            BaseUtils.setInputLenWithNoBlank(mEtContent,100);
            mDialogCloss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            });
            mLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String content = mEtContent.getText().toString();
                    mLeftBtn.OnInputBack(dialog, content);
                }
            });
            mRigtht.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String content = mEtContent.getText().toString();
                    mRightBtn.OnInputBack(dialog, content);
                }
            });
            return dialog;
        }
    }


}
