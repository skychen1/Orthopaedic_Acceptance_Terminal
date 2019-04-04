package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.FragmentAdapter;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.activities.LoginActivityNew;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByIdResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByStatusResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.GetAllPatientResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SaveOrderRequestBean;
import com.rivamed.orthopaedicacceptanceterminal.bean.SaveOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SurgeryPatientResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderRequestFragment
 * @Description: 订单申请页面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 14:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 14:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeOrderRequestFragment extends BaseFragment {
    @BindView(R.id.rb_top_left)
    RadioButton rbTopLeft;
    @BindView(R.id.rb_top_right)
    RadioButton rbTopRight;
    @BindView(R.id.rg_top_tag)
    RadioGroup rgTopTag;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.tv_top_username)
    TextView mTvTopUsername;
    @BindView(R.id.rl_logout)
    RelativeLayout mRlLogout;

    private List<Fragment> mFragmentList;
    public FragmentAdapter mFragmentAdapter;
    private OperationPlanFragment mOperationPlanFragment;
    private OperationUrgentFragment mOperationUrgentFragment;

    public static HomeOrderRequestFragment newInstance() {
        Bundle args = new Bundle();
        HomeOrderRequestFragment fragment = new HomeOrderRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_request;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mTvTopUsername.setText(SPUtils.getString(getContext(), Constants.ORTHOPAEDIC_USER_NNAME, ""));
        mRlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut(LoginActivityNew.class);
            }
        });
        btBottomLeft.setVisibility(View.GONE);
        btBottomRight.setVisibility(View.VISIBLE);
        mFragmentList = new ArrayList<>();
        mOperationPlanFragment = OperationPlanFragment.newInstance();
        mOperationUrgentFragment = OperationUrgentFragment.newInstance();
        mFragmentList.add(mOperationPlanFragment);
        mFragmentList.add(mOperationUrgentFragment);
        mFragmentAdapter = new FragmentAdapter(_mActivity.getSupportFragmentManager(),
                mFragmentList);
        vpContent.setAdapter(mFragmentAdapter);
        vpContent.setCurrentItem(0);
        rgTopTag.check(R.id.rb_top_left);
        rgTopTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_top_left:
                    vpContent.setCurrentItem(0);
                    break;
                case R.id.rb_top_right:
                    vpContent.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        });
        rbTopLeft.setText("手术排班");
        rbTopRight.setText("加急订单");
        btBottomMedium.setVisibility(View.GONE);
        btBottomLeft.setText("取消");
        btBottomRight.setText("确认");
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rgTopTag.check(R.id.rb_top_left);
                } else {
                    rgTopTag.check(R.id.rb_top_right);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left://取消
                break;
            case R.id.bt_bottom_right://确认
                int currentItem = vpContent.getCurrentItem();
                if (currentItem == 0) {
                    //手术排班
                    boolean IsAllEmpty = true;
                    for (FindSuiteResponseParam.OciSuiteVosBean ociSuiteVosBean : mOperationPlanFragment.listSuit) {
                        IsAllEmpty = TextUtils.isEmpty(ociSuiteVosBean.getSuiteId()) && IsAllEmpty;
                    }
                    if (TextUtils.isEmpty(mOperationPlanFragment.mPatientId) | TextUtils.isEmpty(mOperationPlanFragment.mSurgeryId)) {
                        ToastUtils.showShort("请选择手术排班");
                    } else if (mOperationPlanFragment.listSuit.size() == 0 | IsAllEmpty) {
                        ToastUtils.showShort("请选择套餐");
                    } else {
                        SaveOrderRequestBean saveOrderRequestBean = new SaveOrderRequestBean();
                        SaveOrderRequestBean.OciOrderBean ociOrderBean = new SaveOrderRequestBean.OciOrderBean();
                        ociOrderBean.setOrderType("1");
                        ociOrderBean.setPatientId(mOperationPlanFragment.mPatientId);
                        ociOrderBean.setSurgeryId(mOperationPlanFragment.mSurgeryId);
                        saveOrderRequestBean.setOciOrder(ociOrderBean);
                        for (FindSuiteResponseParam.OciSuiteVosBean ociSuiteVosBean : mOperationPlanFragment.listSuit) {
                            SaveOrderRequestBean.OciSuiteVosBean ociSuiteVosBean1 = new SaveOrderRequestBean.OciSuiteVosBean();
                            ociSuiteVosBean1.setSuiteId(ociSuiteVosBean.getSuiteId());
                            ociSuiteVosBean1.setRemark(ociSuiteVosBean.getRemark());
                            saveOrderRequestBean.getOciSuiteVos().add(ociSuiteVosBean1);
                        }
                        saveOrder(saveOrderRequestBean, 1);
                    }
                } else {
                    //加急订单
                    boolean IsAllEmpty = true;
                    for (FindSuiteResponseParam.OciSuiteVosBean ociSuiteVosBean : mOperationUrgentFragment.listSuit) {
                        IsAllEmpty = TextUtils.isEmpty(ociSuiteVosBean.getSuiteId()) && IsAllEmpty;
                    }
                    if (TextUtils.isEmpty(mOperationUrgentFragment.mSurgeryDictId)) {
                        ToastUtils.showShort("请选择手术");
                    } else if (TextUtils.isEmpty(mOperationUrgentFragment.mPatientId)) {
                        ToastUtils.showShort("请选择患者");
                    } else if (mOperationUrgentFragment.listSuit.size() == 0 | IsAllEmpty) {
                        ToastUtils.showShort("请选择套餐");
                    } else {
                        SaveOrderRequestBean saveOrderRequestBean = new SaveOrderRequestBean();
                        SaveOrderRequestBean.OciOrderBean ociOrderBean = new SaveOrderRequestBean.OciOrderBean();
                        ociOrderBean.setOrderType("2");
                        ociOrderBean.setPatientId(mOperationUrgentFragment.mPatientId);
                        ociOrderBean.setSurgeryDictId(mOperationUrgentFragment.mSurgeryDictId);
                        saveOrderRequestBean.setOciOrder(ociOrderBean);
                        for (FindSuiteResponseParam.OciSuiteVosBean ociSuiteVosBean : mOperationUrgentFragment.listSuit) {
                            SaveOrderRequestBean.OciSuiteVosBean ociSuiteVosBean1 = new SaveOrderRequestBean.OciSuiteVosBean();
                            ociSuiteVosBean1.setSuiteId(ociSuiteVosBean.getSuiteId());
                            ociSuiteVosBean1.setRemark(ociSuiteVosBean.getRemark());
                            saveOrderRequestBean.getOciSuiteVos().add(ociSuiteVosBean1);
                        }
                        saveOrder(saveOrderRequestBean, 2);
                    }
                }

                break;
            default:
                break;
        }
    }

    /**
     * 提交订单申请
     *
     * @param saveOrderRequestBean
     * @param type                 1手术排班  2加急订单
     */
    private void saveOrder(SaveOrderRequestBean saveOrderRequestBean, int type) {
        OkGoUtil.postJsonRequest(UrlPath.ORDER_SAVE, this, saveOrderRequestBean,
                new DialogCallback<SaveOrderResponseParam>(context) {
                    @Override
                    public void onSuccess(Response<SaveOrderResponseParam> response) {

                        if (response.body() != null) {
//                            String msg = response.body().getMsg();
//                            if (!TextUtils.isEmpty(msg)) {
//                                ToastUtils.showShort(msg);
//                            } else {
//                                ToastUtils.showShort("申请失败");
//                            }
                            if (response.body().isOperateSuccess()) {
                                ToastUtils.showShort("申请成功");
                                EventBusUtils.post(new Event.EventOrderOpt("HomeOrderRequestFragment"));
                                if (type == 1) {
                                    EventBusUtils.post(new Event.EventSelectOperationPlan(new SurgeryPatientResponseParam.SurgeryPatientVosBean()));
                                    FindByIdResponseParam findByIdResponseParam = new FindByIdResponseParam();
                                    findByIdResponseParam.setFrom("OperationPlanFragmentSubmit");
                                    EventBusUtils.post(new Event.EventSelectSuit(findByIdResponseParam));
                                } else if (type == 2) {
                                    EventBusUtils.post(new Event.EventSelectOpt(new FindByStatusResponseParam.SurgeryDictsBean()));
                                    EventBusUtils.post(new Event.EventSelectPatint(new GetAllPatientResponseParam.PatientsBean()));
                                    FindByIdResponseParam findByIdResponseParam = new FindByIdResponseParam();
                                    findByIdResponseParam.setFrom("OperationUrgentFragmentSubmit");
                                    EventBusUtils.post(new Event.EventSelectSuit(findByIdResponseParam));
                                }
                            }else {
                                ToastUtils.showShort("申请失败");
                            }
                        }

                    }

                    @Override
                    public void onError(Response<SaveOrderResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

}
