package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationSuiteApparatusDetailsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByIdResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OptSuiteCstFragment
 * @Description: 订单申请-手术排班-选择套餐-套餐明细-器械
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 16:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 16:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class OptSuiteApparatusFragment extends BaseFragment {
    private  List<FindByIdResponseParam.InstrumentsBean> mInstruments = new ArrayList<>();
    @BindView(R.id.rv_context)
    RecyclerView rvContext;

    @SuppressLint("ValidFragment")
    public OptSuiteApparatusFragment(List<FindByIdResponseParam.InstrumentsBean> instruments) {
        super();
        mInstruments.clear();
        mInstruments.addAll(instruments);
    }

    private OperationSuiteApparatusDetailsAdapter mOperationSuiteApparatusDetailsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_optsuite_apparatus;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mOperationSuiteApparatusDetailsAdapter = new OperationSuiteApparatusDetailsAdapter(getContext());
        mOperationSuiteApparatusDetailsAdapter.setList(mInstruments);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mOperationSuiteApparatusDetailsAdapter);
    }
}
