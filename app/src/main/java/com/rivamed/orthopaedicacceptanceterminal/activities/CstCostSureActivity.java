package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostSureAdapter;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: CstCostSureActivity
 * @Description: 确认计费耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostSureActivity extends OatBaseActivity {
    @BindView(R.id.view_top_search)
    SearchView viewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;
    private CstCostSureAdapter mCstCostSureAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cstcost_sure;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }


    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left:
                break;
            case R.id.bt_bottom_right:
                break;
        }
    }
}
