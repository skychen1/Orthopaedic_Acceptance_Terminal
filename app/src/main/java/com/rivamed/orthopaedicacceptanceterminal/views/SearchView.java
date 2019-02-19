package com.rivamed.orthopaedicacceptanceterminal.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rivamed.orthopaedicacceptanceterminal.R;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.views
 * @ClassName: AddAndSubAmountView
 * @Description: 搜索控件
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/15 16:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/15 16:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SearchView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private EditText mEtSeach;
    private ImageView mImgClose;

    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_search_view, this);
        mEtSeach = (EditText) findViewById(R.id.et_search_key);
        mImgClose = (ImageView) findViewById(R.id.img_search_close);
        mImgClose.setOnClickListener(this);
        mEtSeach.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().trim().length() > 0) {
            mImgClose.setVisibility(VISIBLE);
        } else {
            mImgClose.setVisibility(GONE);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_search_close:
                mEtSeach.setText("");
                mImgClose.setVisibility(GONE);
                break;
            default:
                break;
        }
    }
}
