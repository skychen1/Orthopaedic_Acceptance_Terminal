package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostDetailsEliminationAdapter;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostDetailsSterilsAdapter;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderLookUpSuiteDetailsCstSterilsFragment
 * @Description: 计费提报-耗材明细-复消类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostDetailsEliminationFragment extends BaseFragment {


    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private CstCostDetailsEliminationAdapter mCstCostDetailsEliminationAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cstcost_details_elimination;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
