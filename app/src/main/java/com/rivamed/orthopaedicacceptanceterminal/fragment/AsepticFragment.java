package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrdLookUpSuiteDetailsCstSterilsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: AsepticFragment
 * @Description: 订单查询-套餐明细-无菌类耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class AsepticFragment extends BaseFragment {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    List<FindSuiteDetailResponseParam.AsepticCstsBean> listData = new ArrayList<FindSuiteDetailResponseParam.AsepticCstsBean>();
    private OrdLookUpSuiteDetailsCstSterilsAdapter mOrdLookUpSuiteDetailsCstSterilsAdapter;

    @SuppressLint("ValidFragment")
    public AsepticFragment(List<FindSuiteDetailResponseParam.AsepticCstsBean> eliminationCsts) {
        super();
        listData.clear();
        listData.addAll(eliminationCsts);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup_suitedetails_cst_sterile;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mOrdLookUpSuiteDetailsCstSterilsAdapter = new OrdLookUpSuiteDetailsCstSterilsAdapter(getContext());
        mOrdLookUpSuiteDetailsCstSterilsAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mOrdLookUpSuiteDetailsCstSterilsAdapter);
    }
}
