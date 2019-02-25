package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rivamed.common.adapter.FragmentAdapter;
import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderRequestFragment
 * @Description: 订单申请
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 14:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 14:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderRequestFragment extends BaseFragment {
    @BindView(R.id.rb_top_left)
    RadioButton rbTopLeft;
    @BindView(R.id.rb_top_right)
    RadioButton rbTopRight;
    @BindView(R.id.rg_top_tag)
    RadioGroup rgTopTag;
    @BindView(R.id.bt_bottom_left)
    Button btBottomLeft;
    @BindView(R.id.bt_bottom_medium)
    Button btBottomMedium;
    @BindView(R.id.bt_bottom_right)
    Button btBottomRight;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    private List<Fragment> mFragmentList;
    public FragmentAdapter mFragmentAdapter;
    public static  OrderRequestFragment newInstance() {
        Bundle args = new Bundle();
        OrderRequestFragment fragment = new OrderRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_request;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(OperationPlanFragment.newInstance());
        mFragmentList.add(OperationUrgentFragment.newInstance());
        mFragmentAdapter = new FragmentAdapter(_mActivity.getSupportFragmentManager(),
                mFragmentList);
        vpContent.setAdapter(mFragmentAdapter);
        vpContent.setCurrentItem(0);
        rgTopTag.check(R.id.rb_top_left);
        rgTopTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_top_left:
                    vpContent.setCurrentItem(0);
                    break;
                case R.id.rb_top_right:
                    vpContent.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        });
    }

    @OnClick({R.id.bt_bottom_left, R.id.bt_bottom_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bottom_left:
                break;
            case R.id.bt_bottom_right:
                break;
            default:
                break;
        }
    }
}
