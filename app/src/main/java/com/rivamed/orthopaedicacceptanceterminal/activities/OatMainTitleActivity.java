package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.rivamed.common.base.BaseSimpleActivity;
import com.rivamed.orthopaedicacceptanceterminal.R;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OatBaseActivity
 * @Description: 主页面基类Activity
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/14 10:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/14 10:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract public class OatMainTitleActivity extends BaseSimpleActivity {
    TextView tvCenterTitle;

    @Override
    protected int getAppBarLayoutId() {
        return R.layout.layout_main_bar;
    }

    @Override
    public void bindEvent() {
        tvCenterTitle = (TextView) findViewById(R.id.tv_center_title);
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
}
