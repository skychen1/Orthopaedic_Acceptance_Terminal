package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrdLookUpSuiteDetailsCstApparatusAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: AsepticFragment
 * @Description: 订单查询-套餐明细-器械类耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class InstrumentsFragment extends BaseFragment {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    List<FindSuiteDetailResponseParam.InstrumentsBean> listData = new ArrayList<>();
    private OrdLookUpSuiteDetailsCstApparatusAdapter mAdapter;

    @SuppressLint("ValidFragment")
    public InstrumentsFragment(List<FindSuiteDetailResponseParam.InstrumentsBean> instruments) {
        super();
        listData.clear();
        listData.addAll(instruments);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup_suitedetails_cst_apparatus;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mAdapter = new OrdLookUpSuiteDetailsCstApparatusAdapter(getContext());
        mAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mAdapter);
    }
}
