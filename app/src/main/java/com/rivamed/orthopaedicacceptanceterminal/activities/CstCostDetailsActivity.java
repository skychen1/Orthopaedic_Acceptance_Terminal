package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.CstCostSureAdapter;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: CstCostSureActivity
 * @Description: 计费耗材--耗材明细
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 16:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 16:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostDetailsActivity extends OatBaseActivity {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cstcost_details;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        //TODO CstCostDetailsSterilsFragment
        //CstCostDetailsEliminationFragment
    }
}
