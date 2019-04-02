package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostDetailsSterilsAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindCstDetailResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: AsepticFragment
 * @Description: 计费提报-耗材明细-无菌类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class CstCostDetailsSterilsFragment extends BaseFragment {


    private final List<FindCstDetailResponseParam.AsepticCstsBean> listData = new ArrayList<>();
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private CstCostDetailsSterilsAdapter mCstCostDetailsSterilsAdapter;

    public List<FindCstDetailResponseParam.AsepticCstsBean> getListData() {
        return listData;
    }

    @SuppressLint("ValidFragment")
    public CstCostDetailsSterilsFragment(List<FindCstDetailResponseParam.AsepticCstsBean> eliminationCsts) {
        super();
        listData.clear();
        listData.addAll(eliminationCsts);
        for (FindCstDetailResponseParam.AsepticCstsBean listDatum : listData) {
            listDatum.setMaxNum(listDatum.getNum());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cstcost_details_sterils;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mCstCostDetailsSterilsAdapter = new CstCostDetailsSterilsAdapter(getContext());
        mCstCostDetailsSterilsAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mCstCostDetailsSterilsAdapter);

    }

    public void setData(List<FindCstDetailResponseParam.AsepticCstsBean> eliminationCsts) {
        listData.clear();
        listData.addAll(eliminationCsts);
        if (mCstCostDetailsSterilsAdapter != null) {
            mCstCostDetailsSterilsAdapter.notifyDataSetChanged();
        }
    }
}
