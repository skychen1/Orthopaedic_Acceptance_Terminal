package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
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
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeCstCostSubmitFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeHckDeptCheckOrderFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeHckDeptExamineOrderFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeNoseCheckOrderFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeOrderLookUpFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeOrderRequestFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.HomeSupRoomCheckOrderFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OperationPlanFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OperationUrgentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

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

    private static final String FUNATION_DATA_TAG = "function_data_tag";
    private SparseArray<SupportFragment> mFragmentMap;
    List<SupportFragment> llContainer = new ArrayList<SupportFragment>();
    SupportFragment[] mFragmentMapArr;
    private int mShowingFragId;
    private boolean isFirst = true;

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
                                         ArrayList<MianFuncationParam> functionList) {
        startActivityWithSerializable(context, HomeActivity.class, FUNATION_DATA_TAG, functionList);
    }

    private void initData() {
        ArrayList<MianFuncationParam> mMainFunctionList =
                (ArrayList<MianFuncationParam>) getBundleSerializableVaule(FUNATION_DATA_TAG,
                        getIntent());
        initPageFragment(mMainFunctionList);
    }

    private void initPageFragment(List<MianFuncationParam> mianFunctionParamList) {
        mFragmentMap = new SparseArray<>(3);
        if (homeRg.getChildCount() > 0) {
            homeRg.removeAllViews();
        }
        if (mFragmentMap != null && mianFunctionParamList != null && mianFunctionParamList.size() > 0) {
            for (MianFuncationParam item : mianFunctionParamList) {
                switch (item.getTitle()) {
                    case "订单申请":
                        setPageData(R.id.home_order_application,
                                R.drawable.selector_icon_home_rb_ddsq, item.getTitle(),
                                HomeOrderRequestFragment.newInstance());
                        break;
                    case "器械处审核订单":
                        setPageData(R.id.home_order_audit, R.drawable.selector_icon_home_rb_qxcsh
                                , item.getTitle(), HomeHckDeptExamineOrderFragment.newInstance());
                        break;
//                                        case "供应商确认订单"://该功能已取消
//                                            addHomeFuncationRb(false, R.id.home_order_sure,
//                                                    this.getResources().getDrawable(R.drawable.selector_icon_home_rb_ddcx), item.getTitle());
//                                            break;
                    case "器械处验收订单":
                        setPageData(R.id.home_order_apparatus_acceptance,
                                R.drawable.selector_icon_home_rb_qxcys, item.getTitle(),
                                HomeHckDeptCheckOrderFragment.newInstance());
                        break;
                    case "护士验收订单":
                        setPageData(R.id.home_order_nose_acceptance,
                                R.drawable.selector_icon_home_rb_hsys, item.getTitle(),
                                HomeNoseCheckOrderFragment.newInstance());
                        break;
                    case "供应室验收订单":
                        setPageData(R.id.home_order_supply_acceptance,
                                R.drawable.selector_icon_home_rb_gysys, item.getTitle(),
                                HomeSupRoomCheckOrderFragment.newInstance());
                        break;
                    case "耗材计费提报":
                        setPageData(R.id.home_cst_submit, R.drawable.selector_icon_home_rb_hcjftb
                                , item.getTitle(), HomeCstCostSubmitFragment.newInstance());
                        break;
                    case "订单查询":
                        setPageData(R.id.home_order_lookup, R.drawable.selector_icon_home_rb_ddcx
                                , item.getTitle(), HomeOrderLookUpFragment.newInstance());
                        break;
                    default:
                        break;
                }
            }
            mFragmentMapArr = new SupportFragment[llContainer.size()];
            for (int i = 0; i < llContainer.size(); i++) {
                SupportFragment supportFragment = llContainer.get(i);
                mFragmentMapArr[i] = supportFragment;
            }
            if (mFragmentMapArr.length > 0) {
                loadMultipleRootFragment(R.id.fl_tab_container, 0,
                        mFragmentMapArr
                );
            }
            initCheckListener();
        }
    }

    private void initCheckListener() {
        ((RadioButton) homeRg.getChildAt(0)).setChecked(true);
        homeRg.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.home_order_application://订单申请
                    showHideFragment(mFragmentMap.get(R.id.home_order_application), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_application;
                    break;
                case R.id.home_order_audit://器械处审核订单
                    showHideFragment(mFragmentMap.get(R.id.home_order_audit), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_audit;
                    break;
                case R.id.home_order_apparatus_acceptance://器械处验收订单
                    showHideFragment(mFragmentMap.get(R.id.home_order_apparatus_acceptance), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_apparatus_acceptance;
                    break;
                case R.id.home_order_nose_acceptance://护士验收订单
                    showHideFragment(mFragmentMap.get(R.id.home_order_nose_acceptance), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_nose_acceptance;
                    break;
                case R.id.home_order_supply_acceptance://供应室验收订单
                    showHideFragment(mFragmentMap.get(R.id.home_order_supply_acceptance), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_supply_acceptance;
                    break;
                case R.id.home_cst_submit://耗材计费提报
                    showHideFragment(mFragmentMap.get(R.id.home_cst_submit), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_cst_submit;
                    break;
                case R.id.home_order_lookup://订单查询
                    showHideFragment(mFragmentMap.get(R.id.home_order_lookup), mFragmentMap.get(mShowingFragId));
                    mShowingFragId = R.id.home_order_lookup;
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OperationPlanFragment.mVendorId="";
        OperationUrgentFragment.mVendorId="";
    }

    /**
     * @param id           控件ID
     * @param bgId         背景Id
     * @param pageFragment 页面
     */
    private void setPageData(@IdRes int id, @DrawableRes int bgId, @NonNull String pageTitle,
                             SupportFragment pageFragment) {
        mFragmentMap.put(id, pageFragment);
        addHomeFuncationRb(false, id, this.getResources().getDrawable(bgId), pageTitle);
        llContainer.add(pageFragment);
        if (isFirst) {
            mShowingFragId = id;
            isFirst = false;
        }
    }

    /**
     * 左侧功能按钮
     *
     * @param drawableTop 图标
     * @param titleName   文字
     * @param isChecked   是否选中
     */
    private int addHomeFuncationRb(boolean isChecked, @IdRes int id,
                                   @NonNull Drawable drawableTop, @NonNull String titleName) {
        int resId = 0;
        if (homeRg != null) {
            RadioButton radioButton = (RadioButton) View.inflate(this, R.layout.layout_home_rb,
                    null);
            radioButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableTop, null,
                    null);
            radioButton.setText(titleName);
            radioButton.setChecked(isChecked);
            radioButton.setId(id);
            homeRg.addView(radioButton);
            resId = id;
        }
        return resId;
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

    @OnClick(R.id.home_rg)
    public void onViewClicked() {
    }
}
