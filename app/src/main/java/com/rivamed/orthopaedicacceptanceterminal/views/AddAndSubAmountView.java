package com.rivamed.orthopaedicacceptanceterminal.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rivamed.orthopaedicacceptanceterminal.R;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.views
 * @ClassName: AddAndSubAmountView
 * @Description: 加减数量控件
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/15 16:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/15 16:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddAndSubAmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private TextView mTvAmount;
    protected Button mBtnSub;
    private Button mBtnAdd;
    private int mAmount = 10;
    private int mMaxAmount = 100;
    private int mMinAmount = 0;


    public AddAndSubAmountView(Context context) {
        super(context);
    }

    public AddAndSubAmountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public AddAndSubAmountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AddAndSubAmountView(Context context, AttributeSet attrs, int defStyleAttr,
                               int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_addandsub_amount, this);
        mTvAmount = (TextView) findViewById(R.id.tv_number);
        mBtnSub = (Button) findViewById(R.id.btn_sub);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mTvAmount.setText(mAmount + "");
        mBtnSub.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mTvAmount.addTextChangedListener(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs,
                R.styleable.AddAndSubAmountView);
        int btnWidth =
                obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddAndSubAmountView_btnWidth, 44);

        int tvWidth =
                obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddAndSubAmountView_tvWidth, 80);
        int tvTextSize =
                obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddAndSubAmountView_tvTextSize, 18);
        int btnTextSize =
                obtainStyledAttributes.getDimensionPixelSize(R.styleable.AddAndSubAmountView_btnTextSize, 18);
        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);
        mBtnSub.setLayoutParams(btnParams);
        mBtnAdd.setLayoutParams(btnParams);
        if (btnTextSize != 0) {
            mBtnSub.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
            mBtnAdd.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }
        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);
        mTvAmount.setLayoutParams(textParams);
        if (tvTextSize != 0) {
            mTvAmount.setTextSize(tvTextSize);
        }
        obtainStyledAttributes.recycle();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sub:
                if (mAmount == mMaxAmount) {
                    mBtnAdd.setClickable(true);
                    mBtnAdd.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                if (mAmount > mMinAmount) {
                    mAmount--;
                    mTvAmount.setText("" + mAmount);
                } else {
                    mAmount = mMinAmount;
                    mTvAmount.setText("" + mMinAmount);
                    mBtnSub.setBackgroundColor(Color.parseColor("#B7BCC8"));
                    mBtnSub.setClickable(false);
                }
                if (mAmountChangeListener != null) {
                    mAmountChangeListener.OnAmountChange(mAmount);
                }
                break;
            case R.id.btn_add:
                if (mAmount == mMinAmount) {
                    mBtnSub.setClickable(true);
                    mBtnSub.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                if (mAmount < mMaxAmount) {
                    mAmount++;
                    mTvAmount.setText("" + mAmount);
                } else {
                    mAmount = mMaxAmount;
                    mTvAmount.setText("" + mMaxAmount);
                    mBtnAdd.setBackgroundColor(Color.parseColor("#B7BCC8"));
                    mBtnAdd.setClickable(false);
                }
                if (mAmountChangeListener != null) {
                    mAmountChangeListener.OnAmountChange(mAmount);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 设置允许最大数
     *
     * @param maxAmount
     */
    public void setMaxAmount(int maxAmount) {
        this.mMaxAmount = maxAmount;
    }

    /**
     * 设置允许最小数
     *
     * @param minAmount
     */
    public void setMinAmount(int minAmount) {
        this.mMinAmount = minAmount;
    }

    /**
     * 获取数量
     *
     * @return
     */
    public int getAmount() {
        return mAmount;
    }

    /**
     * 获取数量
     *
     * @return
     */
    public void setAmount(int amount) {
        mAmount = amount;
        mTvAmount.setText("" + mAmount);
    }

    //提供接口
    public  OnAmountChangeListener mAmountChangeListener;

    public interface OnAmountChangeListener {
        void OnAmountChange(int amount);
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        mAmountChangeListener = onAmountChangeListener;
    }


}
