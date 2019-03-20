package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
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
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByIdResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OptSuiteApparatusFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OptSuiteCstFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OptSuiteDetailsActivity
 * @Description: 订单申请-手术排班-选择套餐-套餐明细页面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 13:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 13:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OptSuiteDetailsActivity extends OatBaseActivity {
    @BindView(R.id.tv_suite_name)
    TextView tvSuiteName;
    @BindView(R.id.tv_supplier_name)
    TextView tvSupplierName;
    @BindView(R.id.rb_content_left)
    RadioButton rbContentLeft;
    @BindView(R.id.rb_content_right)
    RadioButton rbContentRight;
    @BindView(R.id.rg_content_tag)
    RadioGroup rgContentTag;
    @BindView(R.id.vp_content)
    ViewPager vpContext;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;
    private FindByIdResponseParam mBody;
    private String mFrom="";

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_opt_suitedetails;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        btBottomRight.setText("确认");
        btBottomRight.setVisibility(View.GONE);
        tvCenterTitle.setText("套餐明细");
        btBottomLeft.setVisibility(View.GONE);
        String suiteId = getIntent().getStringExtra("suiteId");
        mFrom = getIntent().getStringExtra("from");
        findById(suiteId);
    }

    /**
     * 套餐明细
     *
     * @param suiteId
     */
    private void findById(String suiteId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("suiteId", suiteId);
        OkGoUtil.getRequest(UrlPath.ORDER_FIND_BY_ID, this, map,
                new DialogCallback<FindByIdResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindByIdResponseParam> response) {
                        mBody = response.body();
                        btBottomRight.setVisibility(View.VISIBLE);
                        tvSuiteName.setText(mBody.getSuiteName());
                        tvSupplierName.setText(response.body().getVendorName());
                        initFrag(response.body());
                    }

                    @Override
                    public void onError(Response<FindByIdResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    private void initFrag(FindByIdResponseParam body) {
        rbContentLeft.setText("耗材" + "【" + body.getCstCount() + "】");
        rbContentRight.setText("器械" + "【" + body.getInstrumentCount() + "】");
        mFragments.add(new OptSuiteCstFragment(body.getCsts()));
        mFragments.add(new OptSuiteApparatusFragment(body.getInstruments()));

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(),
                mFragments);
        vpContext.setAdapter(mFragmentAdapter);
        vpContext.setCurrentItem(0);
        rgContentTag.check(R.id.rb_top_left);
        rgContentTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_content_left:
                    vpContext.setCurrentItem(0);
                    break;
                case R.id.rb_content_right:
                    vpContext.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        });

        vpContext.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rgContentTag.check(R.id.rb_content_left);
                } else {
                    rgContentTag.check(R.id.rb_content_right);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick(R.id.bt_bottom_right)
    public void onViewClicked() {
        if (mBody != null) {
            mBody.setFrom(mFrom);
            EventBusUtils.post(new Event.EventSelectSuit(mBody));
            finish();
        }

    }
}
