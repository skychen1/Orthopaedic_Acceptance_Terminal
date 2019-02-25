package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.os.Handler;

import com.rivamed.common.base.SimpleActivity;
import com.rivamed.orthopaedicacceptanceterminal.R;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: WelcomeActivity
 * @Description: 启动首页
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/14 10:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/14 10:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WelcomeActivity extends SimpleActivity {

    /**
     * 界面延时跳转
     */
    private Handler mHandler;

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mHandler = new Handler();
        mHandler.postDelayed(() -> {
            startActivity(LoginActivityNew.class);
            finish();
        }, 2000);
    }

    @Override
    public void onBindViewBefore() {

    }

    @Override
    public Object newP() {
        return null;
    }
    /**
     * 是否全屏
     *
     * @return
     */
    @Override
    public boolean getIsFullScreen() {
        return true;
    }
    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
        super.onDestroy();
    }
}
