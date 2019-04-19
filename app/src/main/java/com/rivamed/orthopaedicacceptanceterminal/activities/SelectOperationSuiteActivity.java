package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.SelectOperationSuiteAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OperationPlanFragment;
import com.rivamed.orthopaedicacceptanceterminal.fragment.OperationUrgentFragment;
import com.rivamed.orthopaedicacceptanceterminal.views.SearchView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.activities
 * @ClassName: selcetOperationSuiteActivti
 * @Description: 手术排班-选择套餐页面
 * @Author: Amos_Bo
 * @Createate: 2019/2/26 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/26 11:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectOperationSuiteActivity extends OatBaseActivity {

    @BindView(R.id.view_top_search)
    SearchView viewTopSearch;
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private SelectOperationSuiteAdapter mSelectOperationSuiteAdapter;
    List<FindSuiteResponseParam.OciSuiteVosBean> listData = new ArrayList<>();
    private String mFrom = "";

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_select_optsuite;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        mFrom = getIntent().getStringExtra("from");
        EventBusUtils.register(this);
        tvCenterTitle.setText("选择套餐");
        mSelectOperationSuiteAdapter = new SelectOperationSuiteAdapter(getApplicationContext());
        mSelectOperationSuiteAdapter.setList(listData);
        rvContext.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContext.setAdapter(mSelectOperationSuiteAdapter);
        findSuite("");
        mSelectOperationSuiteAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SelectOperationSuiteActivity.this, OptSuiteDetailsActivity.class);
                intent.putExtra("suiteId", listData.get(position).getSuiteId());
                intent.putExtra("vendorId", listData.get(position).getVendorId());
                intent.putExtra("from", mFrom);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        EditText etSeach = viewTopSearch.getEtSeach();
        etSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String content = etSeach.getText().toString();
                findSuite(content);
                hideInputWindow(etSeach);
                return true;
            }
        });
        etSeach.setHint("请输入套餐名称、套餐别名、供应商");
        viewTopSearch.setOnEmptyInputListener(new SearchView.OnEmptyInputListener() {
            @Override
            public void OnEmptyInput() {
                findSuite("");
            }
        });

    }

    /**
     * 套餐查询
     *
     * @param term
     */
    private void findSuite(String term) {
        Map<String, String> map = new HashMap<>(1);
        map.put("term", term);
        Log.e("SelectOperationSuiteAct","mFrom:" +mFrom);
        Log.e("SelectOperationSuiteAct","OperationPlanFragment.mVendorId:" +OperationPlanFragment.mVendorId);
        Log.e("SelectOperationSuiteAct","OperationUrgentFragment.mVendorId:" +OperationUrgentFragment.mVendorId);
        if (mFrom != null && mFrom.equals("OperationPlanFragment") && !TextUtils.isEmpty(OperationPlanFragment.mVendorId)) {
            //手术排班
            map.put("vendorId", OperationPlanFragment.mVendorId);
        }else if (mFrom != null && mFrom.equals("OperationUrgentFragment") && !TextUtils.isEmpty(OperationUrgentFragment.mVendorId)) {
            //加急订单
            map.put("vendorId", OperationUrgentFragment.mVendorId);
        }
        OkGoUtil.getRequest(UrlPath.ORDER_FIND_SUITE, this, map,
                new DialogCallback<FindSuiteResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindSuiteResponseParam> response) {
                        listData.clear();
                        listData.addAll(response.body().getOciSuiteVos());
                        mSelectOperationSuiteAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Response<FindSuiteResponseParam> response) {
                        super.onError(response);
                    }
                });
    }

    /**
     * 选择套餐
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventSelectSuit(Event.EventSelectSuit event) {
        if (event.data != null) {
            finish();
        }
    }
}
