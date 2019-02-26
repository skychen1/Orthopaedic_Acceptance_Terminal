package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OperationSuiteCstDetailsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
public class OptSuiteCstFragment extends BaseFragment {
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private OperationSuiteCstDetailsAdapter mOperationSuiteCstDetailsAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_optsuite_cst;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
