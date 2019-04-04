package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rivamed.common.base.BaseSimpleActivity;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;

import butterknife.BindView;

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
    @BindView(R.id.tv_top_username)
    TextView mTvTopUsername;
    @BindView(R.id.rl_logout)
    RelativeLayout mRlLogout;

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
        mTvTopUsername.setText(SPUtils.getString(getApplicationContext(), Constants.ORTHOPAEDIC_USER_NNAME, ""));
        mRlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut(LoginActivityNew.class);
            }
        });
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
     *
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
