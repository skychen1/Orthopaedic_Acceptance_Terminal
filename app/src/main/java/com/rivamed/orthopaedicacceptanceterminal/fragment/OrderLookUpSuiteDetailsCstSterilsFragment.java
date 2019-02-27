package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrdLookUpSuiteDetailsCstSterilsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderLookUpSuiteDetailsCstSterilsFragment
 * @Description: 订单查询-套餐明细-无菌类耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderLookUpSuiteDetailsCstSterilsFragment extends BaseFragment {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private OrdLookUpSuiteDetailsCstSterilsAdapter mOrdLookUpSuiteDetailsCstSterilsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup_suitedetails_cst_sterile;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
