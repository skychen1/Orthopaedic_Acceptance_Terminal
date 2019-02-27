package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rivamed.orthopaedicacceptanceterminal.R;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OrderLookUpSuiteDetailsActivity
 * @Description: 订单查询-套餐明细
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 14:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 14:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderLookUpSuiteDetailsActivity extends OatBaseActivity {
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

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_orderlookup_suitedeails;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        //TODO  OrderLookUpSuiteDetailsCstSterilsFragment
        //OrderLookUpSuiteDetailsCstEliminationFragment
        //OrderLookUpSuiteDetailsCstApparatusFragment
    }
}
