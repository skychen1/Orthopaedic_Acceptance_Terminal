package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostSubmitAdapter;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: CstCostSubmitFregment
 * @Description: 计费提报
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeCstCostSubmitFragment extends BaseFragment {

    @BindView(R.id.view_top_search)
    SearchView viewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private CstCostSubmitAdapter mCstCostSubmitAdapter;

    public static HomeCstCostSubmitFragment newInstance() {
        Bundle args = new Bundle();
        HomeCstCostSubmitFragment fragment = new HomeCstCostSubmitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ordcstcost_submit;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
