package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.OrderLookUpAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderLookUpFragment
 * @Description: 订单查询
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/27 9:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/27 9:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeOrderLookUpFragment extends BaseFragment {
    @BindView(R.id.tv_center_title)
    TextView tvCenterTitle;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.ll_start_time)
    LinearLayout llStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.ll_end_time)
    LinearLayout llEndTime;
    @BindView(R.id.ll_select_time)
    LinearLayout llSelectTime;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.ll_state)
    LinearLayout llState;
    @BindView(R.id.et_search_key)
    EditText etSearchKey;
    @BindView(R.id.btn_lookup)
    Button btnLookup;

    private OrderLookUpAdapter mOrderLookUpAdapter;

    public static HomeOrderLookUpFragment newInstance() {
        Bundle args = new Bundle();
        HomeOrderLookUpFragment fragment = new HomeOrderLookUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_lookup;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {

    }

    @OnClick({R.id.ll_start_time, R.id.ll_end_time, R.id.ll_state, R.id.btn_lookup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_start_time:
                break;
            case R.id.ll_end_time:
                break;
            case R.id.ll_state:
                break;
            case R.id.btn_lookup:
                break;
            default:
                break;
        }
    }
}
