package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationSuiteCstDetailsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByIdResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OptSuiteCstFragment
 * @Description: 订单申请-手术排班-选择套餐-套餐明细-耗材
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 16:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 16:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class OptSuiteCstFragment extends BaseFragment {
    private List<FindByIdResponseParam.CstsBean> mCsts = new ArrayList<>();
    @BindView(R.id.rv_context)
    RecyclerView rvContext;

    @SuppressLint("ValidFragment")
    public OptSuiteCstFragment(List<FindByIdResponseParam.CstsBean> csts) {
        super();
        mCsts.clear();
        mCsts.addAll(csts);
    }

    private OperationSuiteCstDetailsAdapter mOperationSuiteCstDetailsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_optsuite_cst;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mOperationSuiteCstDetailsAdapter = new OperationSuiteCstDetailsAdapter(getContext());
        mOperationSuiteCstDetailsAdapter.setList(mCsts);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mOperationSuiteCstDetailsAdapter);
    }
}
