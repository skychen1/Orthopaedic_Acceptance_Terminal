package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.UrgentSelectPatientAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: UrgentSelectPatintActivity
 * @Description: 订单申请-加急订单-选择手术
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/26 17:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 17:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UrgentSelectPatintActivity extends OatBaseActivity {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private UrgentSelectPatientAdapter mUrgentSelectPatientAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_urgent_selectpatient;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
