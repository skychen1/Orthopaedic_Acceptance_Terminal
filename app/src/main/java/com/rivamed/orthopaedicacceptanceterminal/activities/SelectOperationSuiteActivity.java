package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SelectOperationSuiteAdapter;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: selcetOperationSuiteActivti
 * @Description: 手术排班-选择套餐
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 11:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectOperationSuiteActivity extends OatBaseActivity {

    @BindView(R.id.view_top_search)
    SearchView viewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private SelectOperationSuiteAdapter mSelectOperationSuiteAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_select_optsuite;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
