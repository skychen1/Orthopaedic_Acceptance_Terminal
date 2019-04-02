package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrdLookUpSuiteDetailsCstEliminnationAdapter;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: AsepticFragment
 * @Description: 供应商验收-套餐明细-复消类耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SupRoomCheckOrdDetailsCstEliminationFragment extends BaseFragment {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private OrdLookUpSuiteDetailsCstEliminnationAdapter mOrdLookUpSuiteDetailsCstEliminnationAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup_suitedetails_cst_elimination;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
