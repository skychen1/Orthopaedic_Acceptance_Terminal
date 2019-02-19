package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.MainFuncationAdapter;
import com.rivamed.orthopaedicacceptanceterminal.bean.MianFuncationParam;

import java.io.Serializable;
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
    private ArrayList<MianFuncationParam> mMainFuncationList;

    private static final String FUNATION_DATA_TAG = "function_data_tag";

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initData();
    }

    public static void startMainActivity(Context context,
                                         ArrayList<MianFuncationParam> funcationList) {
        startActivityWithSerializable(context, MainActivity.class, FUNATION_DATA_TAG,
                funcationList);
    }

    private void initData() {
        setCenterTitle("骨科耗材管理系统");
        mMainFuncationList =
                (ArrayList<MianFuncationParam>) getBundleSerializableVaule(FUNATION_DATA_TAG,
                        getIntent());
        mMainFuncationAdapter = new MainFuncationAdapter(this);
        mMainFuncationAdapter.setList(mMainFuncationList);
        rvContext.setLayoutManager(new GridLayoutManager(this, 2));
        rvContext.setAdapter(mMainFuncationAdapter);

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
