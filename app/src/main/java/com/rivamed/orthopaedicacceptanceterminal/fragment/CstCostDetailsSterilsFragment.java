package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostDetailsSterilsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrdLookUpSuiteDetailsCstApparatusAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderLookUpSuiteDetailsCstSterilsFragment
 * @Description: 计费提报-耗材明细-无菌类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostDetailsSterilsFragment extends BaseFragment {


    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private CstCostDetailsSterilsAdapter mCstCostDetailsSterilsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cstcost_details_sterils;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
