package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rivamed.orthopaedicacceptanceterminal.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: OptSuiteDetailsActivity
 * @Description: 器械处验收--订单详情-套餐明细
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 13:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 13:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HckDeptCheckOrdDetailsSuiteActivity extends OatBaseActivity {

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
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_suproom_checkorddetails_suite;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
//        TODO 该页面包含的两个界面
//                HckDeptCheckOrdDetailsCstSterilsFragment
//                HckDeptCheckOrdDetailsCstEliminationFragment
//                HckDeptCheckOrdDetailsCstApparatusFragment
    }


    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_medium, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left:
                break;
            case R.id.bt_bottom_medium:
                break;
            case R.id.bt_bottom_right:
                break;
        }
    }
}
