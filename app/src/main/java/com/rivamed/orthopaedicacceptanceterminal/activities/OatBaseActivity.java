package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rivamed.common.base.BaseSimpleActivity;
import com.rivamed.orthopaedicacceptanceterminal.R;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OatBaseActivity
 * @Description: 骨科app基类Activity
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/14 10:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/14 10:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract public class OatBaseActivity extends BaseSimpleActivity implements View.OnClickListener {
    TextView tvCenterTitle;
    RelativeLayout rlBack;
    ImageView imgBack;

    @Override
    protected int getAppBarLayoutId() {
        return R.layout.layout_app_bar;
    }

    @Override
    public void bindEvent() {
        rlBack = (RelativeLayout) findViewById(R.id.rl_back);
        imgBack = (ImageView) findViewById(R.id.img_back);
        tvCenterTitle = (TextView) findViewById(R.id.tv_center_title);
        rlBack.setOnClickListener(this);
    }

    /**
     * 设置中间标题文字
     *
     * @param centerTitle
     */
    public void setCenterTitle(@NonNull String centerTitle) {
        if (!TextUtils.isEmpty(centerTitle)) {
            tvCenterTitle.setText(centerTitle);
        }
    }

    /**
     * 设置状态栏左侧按钮背景图片
     * @param resId
     */
    public void setLeftImageViewSrc(int resId) {
        if (imgBack != null) {
            imgBack.setBackgroundResource(resId);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }
}
