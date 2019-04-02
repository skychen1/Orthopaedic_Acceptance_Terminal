package com.rivamed.orthopaedicacceptanceterminal.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rivamed.common.base.BaseFragment;
import com.rivamed.orthopaedicacceptanceterminal.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OrderRequestFragment
 * @Description: 器械处审核
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 14:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 14:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomeHckDeptExamineOrderFragment extends BaseFragment {
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
    @BindView(R.id.fl_tab_container)
    FrameLayout mFlTabContainer;
    Unbinder unbinder;

    private List<SupportFragment> mFragmentList;

    public static HomeHckDeptExamineOrderFragment newInstance() {
        Bundle args = new Bundle();
        HomeHckDeptExamineOrderFragment fragment = new HomeHckDeptExamineOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_examine_order;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        rbTopLeft.setText("待审核");
        rbTopRight.setText("待确认撤销");
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HckDeptUnExamineOrderFragment(1));
        mFragmentList.add(new HckDeptUnExamineOrderFragment(2));
        rgTopTag.check(R.id.rb_top_left);
        loadMultipleRootFragment(R.id.fl_tab_container, 0,
                mFragmentList.get(0),
                mFragmentList.get(1)
        );
        rgTopTag.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_top_left:
                    showHideFragment( mFragmentList.get(0),  mFragmentList.get(1));
                    break;
                case R.id.rb_top_right:
                    showHideFragment( mFragmentList.get(1),  mFragmentList.get(0));
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
