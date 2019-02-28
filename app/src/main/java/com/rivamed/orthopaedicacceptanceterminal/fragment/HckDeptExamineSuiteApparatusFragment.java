package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationSuiteApparatusDetailsAdapter;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OptSuiteCstFragment
 * @Description: 器械处审核订单--订单详情-套组-套餐明细-器械
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 16:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 16:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HckDeptExamineSuiteApparatusFragment extends BaseFragment {
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private OperationSuiteApparatusDetailsAdapter mOperationSuiteApparatusDetailsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_optsuite_apparatus;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
