package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.base.SimpleActivity;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.BaseUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.BuildConfig;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.LoginRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.LoginResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.MianFuncationParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Amos_bo
 */
public class LoginActivityNew extends SimpleActivity {


    private static final String TAG = "LoginActivity";
    @BindView(R.id.iv_top_logo)
    ImageView mIvTopLogo;
    @BindView(R.id.iv_username)
    ImageView mIvUsername;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.iv_password)
    ImageView mIvPassword;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_login_tip)
    TextView mTvLoginTip;
    @BindView(R.id.iv_login_eye)
    ImageView mIvEye;
    @BindView(R.id.tv_version_code)
    TextView tvVersionCode;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login_new;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        tvVersionCode.setText("v" + BuildConfig.VERSION_NAME);
        mEtUsername.setCursorVisible(false);
        mEtPassword.setCursorVisible(false);
        BaseUtils.setInputLenWithNoBlank(mEtUsername, 16);
        BaseUtils.setInputLenWithNoBlank(mEtPassword, 16);
        mIvEye.setSelected(false);
        mEtUsername.setOnTouchListener((View view, MotionEvent motionEvent) -> {
            mEtUsername.setCursorVisible(true);
            mIvUsername.setSelected(true);
            mIvPassword.setSelected(false);
            return false;
        });
        mEtPassword.setOnTouchListener((View view, MotionEvent motionEvent) -> {
            mEtPassword.setCursorVisible(true);
            mIvUsername.setSelected(false);
            mIvPassword.setSelected(true);
            return false;

        });
        if (BuildConfig.DEBUG) {
            mEtUsername.setText("admin");
            mEtPassword.setText("000000");
        }
    }

    @Override
    public void onBindViewBefore() {
    }

    @Override
    public Object newP() {
        return null;
    }


    @OnClick({R.id.iv_login_eye, R.id.et_username, R.id.et_password,
            R.id.btn_login, R.id.iv_top_logo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_username:
                mEtUsername.setCursorVisible(true);
                mIvUsername.setSelected(true);
                mIvPassword.setSelected(false);
                break;
            case R.id.et_password:
                mEtPassword.setCursorVisible(true);
                mIvUsername.setSelected(false);
                mIvPassword.setSelected(true);
                break;
            case R.id.btn_login:
                String userName = mEtUsername.getText().toString().trim();
                String pass = mEtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(pass) | TextUtils.isEmpty(userName)) {
                    mTvLoginTip.setText("账号或密码不能为空");
                    mTvLoginTip.setVisibility(View.VISIBLE);
                } else {
                    login(userName, pass);
                }
                break;
            //设置
            case R.id.iv_top_logo:
                continuousClick(COUNTS, DURATION);
                break;
            case R.id.iv_login_eye:
                mIvEye.setSelected(!mIvEye.isSelected());
                if (mIvEye.isSelected()) {
                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mEtPassword.setSelection(mEtPassword.getText().toString().length());
                } else {
                    mEtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mEtPassword.setSelection(mEtPassword.getText().toString().length());
                }
                break;
            default:
                break;
        }
    }


    /**
     * 登录
     *
     * @param name
     * @param pass
     */
    private void login(String name, String pass) {
        LoginRequestParam loginRequestParam = new LoginRequestParam();
        loginRequestParam.setSystemType("OCI");
        loginRequestParam.setAccount(new LoginRequestParam.AccountBean());
        loginRequestParam.getAccount().setAccountName(name);
        loginRequestParam.getAccount().setPassword(pass);
        OkGoUtil.postJsonRequest(UrlPath.LOGIN_NAME_PASSWORD, this, loginRequestParam,
                new DialogCallback<LoginResponseParam>(this) {
            @Override
            public void onSuccess(Response<LoginResponseParam> response) {
                if (response.body().isOperateSuccess()) {
                    if (response.body().getAccessToken() != null && !TextUtils.isEmpty(response.body().getAccessToken().getTokenId())) {
                        OkGoUtil.updateTokenId(response.body().getAccessToken().getTokenId());
                        OkGoUtil.updateTokenId(response.body().getAccessToken().getTokenId());
                        updateMainFunction(response.body().getAppAccountInfoVo().getAccountId());
                    }
                } else {
                    ToastUtils.showShort("登录异常，请联系管理员!");
                }
            }

            @Override
            public void onError(Response<LoginResponseParam> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 获取后端配置的主界面功能按钮接口
     *
     * @param accountId
     */
    private void updateMainFunction(String accountId) {
        HashMap<String, String> requestKeyMap = new HashMap<>(2);
        requestKeyMap.put("account.accountId", accountId);
        requestKeyMap.put("systemType", "OCI");
        OkGoUtil.getRequest(UrlPath.ACCOUNT_FUNCS, this, requestKeyMap,
                new DialogCallback<List<MianFuncationParam>>(LoginActivityNew.this) {
            @Override
            public void onSuccess(Response<List<MianFuncationParam>> response) {
                if (response.body() != null && response.body().size() > 0) {
                    HomeActivity.startHomeActivity(mContext,
                            (ArrayList<MianFuncationParam>) response.body());
                    finish();
                } else {
                    ToastUtils.showShort("此账号未配置权限，请联系管理员!");
                }
            }

            @Override
            public void onError(Response<List<MianFuncationParam>> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 是否状态栏沉浸
     *
     * @return
     */
    @Override
    public boolean getIsImmersionBar() {
        return true;
    }

    /**
     * 点击次数
     */
    final static int COUNTS = 5;
    /**
     * 规定有效时间
     */
    final static long DURATION = 1000;
    long[] mHits = new long[COUNTS];

    /**
     * 点击多次触发事件
     */
    private void continuousClick(int count, long time) {
        //每次点击时，数组向前移动一位
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
        //为数组最后一位赋值
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        if (mHits[0] >= (SystemClock.uptimeMillis() - time)) {
            //重新初始化数组
            mHits = new long[count];
            Intent intent = new Intent(this, SettingIpActivity.class);
            startActivity(intent);
        }
    }
}
