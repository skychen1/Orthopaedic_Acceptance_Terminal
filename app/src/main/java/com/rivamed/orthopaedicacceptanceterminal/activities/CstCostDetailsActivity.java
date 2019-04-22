package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.FragmentAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindCstDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.fragment.CstCostDetailsEliminationFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.CstCostDetailsSterilsFragment;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: CstCostSureActivity
 * @Description: 计费耗材--耗材明细页面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostDetailsActivity extends OatBaseActivity {

    @BindView(R.id.tv_opt_name)
    TextView mTvOptName;
    @BindView(R.id.tv_patient_id)
    TextView mTvPatientId;
    @BindView(R.id.tv_patient_case_id)
    TextView mTvPatientCaseId;
    @BindView(R.id.tv_patient_sex)
    TextView mTvPatientSex;
    @BindView(R.id.tv_opt_doctor)
    TextView mTvOptDoctor;
    @BindView(R.id.tv_opt_time)
    TextView mTvOptTime;
    @BindView(R.id.rb_content_left)
    RadioButton mRbContentLeft;
    @BindView(R.id.rb_content_right)
    RadioButton mRbContentRight;
    @BindView(R.id.rg_content_tag)
    RadioGroup mRgContentTag;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    @BindView(R.id.bt_bottom_left)
    Button mBtBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button mBtBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button mBtBottomRight;
    @BindView(R.id.ll_bottom_root)
    LinearLayout mLlBottomRoot;
    @BindView(R.id.view_top_search)
    SearchView mViewTopSearch;
    private String mOrderId;
    private FindCstDetailResponseParam mBody;
    private FragmentAdapter mFragmentAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private CstCostDetailsSterilsFragment mCstCostDetailsSterilsFragment;
    private CstCostDetailsEliminationFragment mCstCostDetailsEliminationFragment;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cstcost_details;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        EventBusUtils.register(this);
        tvCenterTitle.setText("耗材明细");
        mBtBottomLeft.setVisibility(View.GONE);
        mBtBottomRight.setText("提交计费");
        mOrderId = getIntent().getStringExtra("orderId");
        EditText etSeach = mViewTopSearch.getEtSeach();
        etSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String content = etSeach.getText().toString();
                FindCstDetailData(content);
                hideInputWindow(etSeach);
                return true;
            }
        });
        etSeach.setHint("请输入套餐名称、套餐别名、供应商");
        mViewTopSearch.setOnEmptyInputListener(new SearchView.OnEmptyInputListener() {
            @Override
            public void OnEmptyInput() {
                FindCstDetailData("");
            }
        });

        FindCstDetailData("");

        mBtBottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    List<FindCstDetailResponseParam.AsepticCstsBean> mCstCostDetailsSterilsFragmentListData = mCstCostDetailsSterilsFragment.getListData();
                    List<FindCstDetailResponseParam.EliminationCstsBean> mCstCostDetailsEliminationFragmentListData = mCstCostDetailsEliminationFragment.getListData();
                    Intent intent = new Intent(CstCostDetailsActivity.this, CstCostSureActivity.class);
                    intent.putExtra("mOrderId", mOrderId);
                    intent.putExtra("mCstCostDetailsSterilsFragmentListData", (Serializable) mCstCostDetailsSterilsFragmentListData);
                    intent.putExtra("mCstCostDetailsEliminationFragmentListData", (Serializable) mCstCostDetailsEliminationFragmentListData);
                    startActivity(intent);
            }
        });
    }

    /**
     * 耗材明细
     */
    private void FindCstDetailData(String content) {
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", mOrderId);
        map.put("cstCondition", content);
        OkGoUtil.postRequest(UrlPath.ACCOUNT_CST_DETAIL, this, map,
                new DialogCallback<FindCstDetailResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindCstDetailResponseParam> response) {
                        mBody = response.body();
                        try {
                            if (mBody != null) {
                                if (mCstCostDetailsSterilsFragment != null && mCstCostDetailsEliminationFragment != null) {
                                    reSetData(response.body());
                                } else {
                                    initFrag(response.body());
                                    initTopData(response.body().getSurgeryPatientVo());
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<FindCstDetailResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    private void initTopData(FindCstDetailResponseParam.SurgeryPatientVoBean item) {
        mTvOptName.setText(item.getSurgeryName());
        mTvPatientId.setText(item.getPatientName() + "/" + item.getHisPatientId());
        mTvPatientCaseId.setText(item.getCaseNo());
        mTvPatientSex.setText(item.getGender());
        mTvOptDoctor.setText(item.getDoctorName());
        mTvOptTime.setText(item.getScheduleTime());
    }

    private void reSetData(FindCstDetailResponseParam body) {
        mRbContentLeft.setText("无菌类耗材" + "【" + body.getAsepticCsts().size() + "】");
        mRbContentRight.setText("复消类耗材" + "【" + body.getEliminationCsts().size() + "】");
        mCstCostDetailsSterilsFragment.setData(body.getAsepticCsts());
        mCstCostDetailsEliminationFragment.setData(body.getEliminationCsts());
    }

    private void initFrag(FindCstDetailResponseParam body) {

        mRbContentLeft.setText("无菌类耗材" + "【" + body.getAsepticCsts().size() + "】");
        mRbContentRight.setText("复消类耗材" + "【" + body.getEliminationCsts().size() + "】");
        mCstCostDetailsSterilsFragment = new CstCostDetailsSterilsFragment(body.getAsepticCsts());
        mCstCostDetailsEliminationFragment = new CstCostDetailsEliminationFragment(body.getEliminationCsts());
        mFragments.add(mCstCostDetailsSterilsFragment);
        mFragments.add(mCstCostDetailsEliminationFragment);

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),
                mFragments);
        mVpContent.setAdapter(mFragmentAdapter);
        mVpContent.setCurrentItem(0);
        mRgContentTag.check(R.id.rb_top_left);
        mVpContent.setOffscreenPageLimit(3);
        mRgContentTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_content_left:
                    mVpContent.setCurrentItem(0);
                    break;
                case R.id.rb_content_right:
                    mVpContent.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        });

        mVpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mRgContentTag.check(R.id.rb_content_left);
                } else if (position == 1) {
                    mRgContentTag.check(R.id.rb_content_right);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }

    /**
     * 计费提报成功
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectPatint(Event.EventOrderOpt event) {
        if (event.mFrom.equals("CstCostSureActivity")) {
           finish();
        }
    }
}
