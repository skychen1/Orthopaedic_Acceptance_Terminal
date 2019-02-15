package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.MainFuncationAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: MainActivity
 * @Description: 主功能界面
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/14 13:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/14 13:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MainActivity extends OatMainTitleActivity {

    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private MainFuncationAdapter mMainFuncationAdapter;
    private List<Object> mMainFuncationList;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        setCenterTitle("骨科耗材管理系统");
        mMainFuncationList = new ArrayList<>();
        mMainFuncationAdapter = new MainFuncationAdapter(this);
        rvContext.setLayoutManager(new GridLayoutManager(this, 2));
        rvContext.setAdapter(mMainFuncationAdapter);
        testData();
    }

    private void testData() {
        mMainFuncationList.add("1");
        mMainFuncationList.add("1");
        mMainFuncationList.add("1");
        mMainFuncationList.add("1");
        mMainFuncationAdapter.setList(mMainFuncationList);
        mMainFuncationAdapter.notifyDataSetChanged();
    }
    /**
     * 是否状态栏沉浸
     *
     * @return
     */
    @Override
    public boolean getIsImmersionBar() {
        return true;
    }

}
