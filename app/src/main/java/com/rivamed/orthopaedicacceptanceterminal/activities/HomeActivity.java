package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rivamed.common.base.SimpleActivity;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.common.utils.UIUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.MianFuncationParam;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OrderRequestFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: MainActivity
 * @Description: 主功能界面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/14 13:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/14 13:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeActivity extends SimpleActivity {
    @BindView(R.id.fl_tab_container)
    FrameLayout flTabContainer;
    @BindView(R.id.home_logo)
    ImageView homeLogo;
    @BindView(R.id.home_rg)
    RadioGroup homeRg;
    @BindView(R.id.rg_ll)
    LinearLayout mHomeRg;
    private long TOUCH_TIME = 0;
    /**
     * 再点一次退出程序时间设置
     */
    private static final long WAIT_TIME = 2000L;
    private ArrayList<MianFuncationParam> mMainFuncationList;

    private static final String FUNATION_DATA_TAG = "function_data_tag";

    private Map<String, Fragment> mFragmentMap;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initData();
    }

    @Override
    public void onBindViewBefore() {

    }

    @Override
    public Object newP() {
        return null;
    }

    public static void startHomeActivity(Context context,
                                         ArrayList<MianFuncationParam> funcationList) {
        startActivityWithSerializable(context, HomeActivity.class, FUNATION_DATA_TAG,
                funcationList);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initData() {
        mMainFuncationList =
                (ArrayList<MianFuncationParam>) getBundleSerializableVaule(FUNATION_DATA_TAG,
                        getIntent());
        mFragmentMap = new HashMap<>(3);
        if (homeRg.getChildCount() > 0) {
            homeRg.removeAllViews();
        }
        initPageFragment(mMainFuncationList);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initPageFragment(List<MianFuncationParam> mianFuncationParamList) {
        if (mFragmentMap != null && mianFuncationParamList != null && mianFuncationParamList.size() > 0) {
            mianFuncationParamList.forEach(item -> {
                switch (item.getTitle()) {
                    case "订单申请":
                        mFragmentMap.put(R.id.home_order_application + "",
                                OrderRequestFragment.newInstance());
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_application,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddsq), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_application,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddsq), item.getTitle());
                        }
                        break;
                    case "器械处审核订单":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_audit,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_qxcsh), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_audit,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_qxcsh), item.getTitle());
                        }
                        break;
                    case "供应商确认订单":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_sure,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddcx), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_sure,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddcx), item.getTitle());
                        }
                        break;
                    case "器械处验收订单":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_apparatus_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_qxcys), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_apparatus_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_qxcys), item.getTitle());
                        }
                        break;
                    case "护士验收订单":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_nose_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_hsys), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_nose_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_hsys), item.getTitle());
                        }
                        break;
                    case "供应室验收订单":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_supply_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_gysys), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_supply_acceptance,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_gysys), item.getTitle());
                        }
                        break;
                    case "耗材计费提报":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_cst_submit,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_hcjftb), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_cst_submit,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_hcjftb), item.getTitle());
                        }
                        break;
                    case "订单查询":
                        //TODO 修改item
                        //mFragmentMap.put("订单申请", 订单申请的Fragment);
                        if (item.getTitle().equals(mianFuncationParamList.get(0).getTitle())) {
                            addHomeFuncationRb(true, R.id.home_order_lookup,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddcx), item.getTitle());
                        } else {
                            addHomeFuncationRb(false, R.id.home_order_lookup,
                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddcx), item.getTitle());
                        }
                        break;
                    default:
                        break;
                }
            });
            initCheckListener();
        }
    }

    private void initCheckListener() {
        homeRg.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.home_order_application:
                    break;
                case R.id.home_order_audit:
                    break;
                case R.id.home_order_sure:
                    break;
                case R.id.home_order_apparatus_acceptance:
                    break;
                case R.id.home_order_nose_acceptance:
                    break;
                case R.id.home_order_supply_acceptance:
                    break;
                case R.id.home_cst_submit:
                    break;
                case R.id.home_order_lookup:
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * 左侧功能按钮
     *
     * @param drawableTop 图标
     * @param titleName   文字
     * @param isChecked   是否选中
     */
    private void addHomeFuncationRb(boolean isChecked, @IdRes int id,
                                    @NonNull Drawable drawableTop, @NonNull String titleName) {
        if (homeRg != null) {
            RadioButton radioButton = (RadioButton) View.inflate(this, R.layout.layout_home_rb,
                    null);
            radioButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableTop, null,
                    null);
            radioButton.setText(titleName);
            radioButton.setChecked(isChecked);
            radioButton.setId(id);
            homeRg.addView(radioButton);
        }
    }


    /**
     * 连续点击退出
     */
    @Override
    public void onBackPressedSupport() {
        if ((System.currentTimeMillis() - TOUCH_TIME > WAIT_TIME)) {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtils.showShortSafe(UIUtils.getString(R.string.press_again_exit));
        } else {
            super.onBackPressedSupport();
        }
    }

    /**
     * 是否状态栏沉浸
     *
     * @return
     */
    @Override
    public boolean getIsImmersionBar() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.home_rg)
    public void onViewClicked() {
    }
}
