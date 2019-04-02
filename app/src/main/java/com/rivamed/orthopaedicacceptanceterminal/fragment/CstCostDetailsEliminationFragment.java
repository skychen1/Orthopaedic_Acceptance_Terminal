package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostDetailsEliminationAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindCstDetailResponseParam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: AsepticFragment
 * @Description: 计费提报-耗材明细-复消类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 15:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("ValidFragment")
public class CstCostDetailsEliminationFragment extends BaseFragment {


    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private CstCostDetailsEliminationAdapter mCstCostDetailsEliminationAdapter;
    List<FindCstDetailResponseParam.EliminationCstsBean> listData = new ArrayList<FindCstDetailResponseParam.EliminationCstsBean>();

    public List<FindCstDetailResponseParam.EliminationCstsBean> getListData() {
        return listData;
    }

    @SuppressLint("ValidFragment")
    public CstCostDetailsEliminationFragment(List<FindCstDetailResponseParam.EliminationCstsBean> asepticCsts) {
        super();
        listData.clear();
        listData.addAll(asepticCsts);
        for (FindCstDetailResponseParam.EliminationCstsBean listDatum : listData) {
            listDatum.setMaxNum(listDatum.getNum());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cstcost_details_elimination;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mCstCostDetailsEliminationAdapter = new CstCostDetailsEliminationAdapter(getContext());
        mCstCostDetailsEliminationAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContext.setAdapter(mCstCostDetailsEliminationAdapter);

    }

    public void setData(List<FindCstDetailResponseParam.EliminationCstsBean> asepticCsts) {
        listData.clear();
        listData.addAll(asepticCsts);
        if (mCstCostDetailsEliminationAdapter != null) {
            mCstCostDetailsEliminationAdapter.notifyDataSetChanged();
        }
    }
}
