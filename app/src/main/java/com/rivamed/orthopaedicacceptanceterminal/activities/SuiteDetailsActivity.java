package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.FragmentAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.SaveOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.fragment.AsepticFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.EliminationFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.InstrumentsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: SuiteDetailsActivity
 * @Description: 套餐明细页面(无菌, 复消, 器械)
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 14:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 14:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SuiteDetailsActivity extends OatBaseActivity {
    @BindView(R.id.tv_suite_name)
    TextView tvSuiteName;
    @BindView(R.id.tv_supplier_name)
    TextView tvSupplierName;
    @BindView(R.id.rb_content_left)
    RadioButton rbContentLeft;
    @BindView(R.id.rb_content_center)
    RadioButton rbContentCenter;
    @BindView(R.id.rb_content_right)
    RadioButton rbContentRight;
    @BindView(R.id.rg_content_tag)
    RadioGroup rgContentTag;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.bt_bottom_left)
    Button mBtBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button mBtBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button mBtBottomRight;
    @BindView(R.id.ll_bottom_root)
    LinearLayout mLlBottomRoot;
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;
    private FindSuiteDetailResponseParam mBody;
    private String mFrom = "";
    private String mOrderId = "";

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_orderlookup_suitedeails;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        tvCenterTitle.setText("套餐明细");
        String suiteId = getIntent().getStringExtra("suiteId");
        mOrderId = getIntent().getStringExtra("mOrderId");
        mFrom = getIntent().getStringExtra("from");
        if (mFrom.equals("HomeHckDeptCheckOrderFragment")) {
            //器械处验收订单--订单详情
            mBtBottomRight.setText("确认");
            mBtBottomLeft.setText("拒绝");
        } else if (mFrom.equals("HomeNoseCheckOrderFragment")) {
            //护士验收订单--订单详情
            mBtBottomRight.setText("确认");
            mBtBottomLeft.setText("拒绝");
        } else if (mFrom.equals("HomeSupRoomCheckOrderFragment")) {
            //供应室验收订单--订单详情
            mBtBottomRight.setText("确认");
            mBtBottomLeft.setText("拒绝");
            //            mBtBottomMedium.setText("打印标签");
            //            mBtBottomMedium.setVisibility(View.VISIBLE);
        } else if (mFrom.equals("HomeOrderLookUpFragment")) {
            //订单查询--订单详情
            mLlBottomRoot.setVisibility(View.GONE);
        }
        findSuiteDetailBySuiteId(suiteId);
        mBtBottomRight.setVisibility(View.GONE);
        mBtBottomLeft.setVisibility(View.GONE);
    }


    /**
     * 获取套餐明细-（无菌、复消，器械）
     *
     * @param suiteId
     */
    private void findSuiteDetailBySuiteId(String suiteId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("suiteId", suiteId);
        map.put("orderId", mOrderId);
        OkGoUtil.getRequest(UrlPath.ACCOUNT_FINDBY_SUITEID, this, map,
                new DialogCallback<FindSuiteDetailResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindSuiteDetailResponseParam> response) {
                        mBody = response.body();
                        if (mBody != null) {
                            tvSuiteName.setText(mBody.getSuiteName());
                            tvSupplierName.setText(response.body().getVendorName());
                            initFrag(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<FindSuiteDetailResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    private void initFrag(FindSuiteDetailResponseParam body) {
        rbContentLeft.setText("无菌类耗材" + "【" + body.getAsepticCstCount() + "】");
        rbContentCenter.setText("复消类耗材" + "【" + body.getEliminationCstCount() + "】");
        rbContentRight.setText("器械" + "【" + body.getInstrumentCount() + "】");
        mFragments.add(new AsepticFragment(body.getAsepticCsts()));
        mFragments.add(new EliminationFragment(body.getEliminationCsts()));
        mFragments.add(new InstrumentsFragment(body.getInstruments()));

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),
                mFragments);
        vpContent.setAdapter(mFragmentAdapter);
        vpContent.setCurrentItem(0);
        rgContentTag.check(R.id.rb_content_left);
        rgContentTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_content_left:
                    vpContent.setCurrentItem(0);
                    break;
                case R.id.rb_content_center:
                    vpContent.setCurrentItem(1);
                    break;
                case R.id.rb_content_right:
                    vpContent.setCurrentItem(2);
                    break;
                default:
                    break;
            }
        });
        vpContent.setOffscreenPageLimit(3);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rgContentTag.check(R.id.rb_content_left);
                } else if (position == 1) {
                    rgContentTag.check(R.id.rb_content_center);
                } else {
                    rgContentTag.check(R.id.rb_content_right);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_medium, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left://拒绝
                switch (mFrom) {
                    case "HomeHckDeptCheckOrderFragment"://器械处验收订单
                        operatorOrder("5");
                        break;
                    case "HomeNoseCheckOrderFragment"://护士验收订单
                        operatorOrder("9");
                        break;
                    case "HomeSupRoomCheckOrderFragment"://供应室验收订单
                        operatorOrder("11");
                        break;
                    default:
                        break;
                }
                break;
            case R.id.bt_bottom_medium:
                break;
            case R.id.bt_bottom_right://确认
                switch (mFrom) {
                    case "HomeHckDeptCheckOrderFragment"://器械处验收订单
                        operatorOrder("4");
                        break;
                    case "HomeNoseCheckOrderFragment"://护士验收订单
                        operatorOrder("8");
                        break;
                    case "HomeSupRoomCheckOrderFragment"://供应室验收订单
                        operatorOrder("10");
                        break;
                    default:
                        break;
                }
                break;
        }
    }

    /**
     * 订单操作
     *
     * @param operator
     */
    private void operatorOrder(String operator) {
        Map<String, String> map = new HashMap<>(2);
        map.put("operator", operator);
        map.put("orderId", mOrderId);
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_OPERATOR_ORDER, this, map,
                new DialogCallback<SaveOrderResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<SaveOrderResponseParam> response) {
                        if (response.body() != null) {
                            if (response.body().isOperateSuccess()) {
                                ToastUtils.showShort("操作成功");
                                EventBusUtils.post(new Event.EventOrderOpt(mFrom));
                                finish();
                            } else {
                                String msg = response.body().getMsg();
                                if (!TextUtils.isEmpty(msg)) {
                                    ToastUtils.showShort(msg);
                                } else {
                                    ToastUtils.showShort("申请失败");
                                }
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
