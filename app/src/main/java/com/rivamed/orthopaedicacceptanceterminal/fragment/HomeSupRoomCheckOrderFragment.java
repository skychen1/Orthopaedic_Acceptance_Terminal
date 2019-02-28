package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SupRoomCheckOrderAdapter;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: SupRoomCheckFragment
 * @Description: 供应室验收订单
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/28 10:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/28 10:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeSupRoomCheckOrderFragment extends BaseFragment {

    public static HomeSupRoomCheckOrderFragment newInstance() {
        Bundle args = new Bundle();
        HomeSupRoomCheckOrderFragment fragment = new HomeSupRoomCheckOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private SupRoomCheckOrderAdapter mSupRoomCheckOrderAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_suproom_checkord;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }
}
