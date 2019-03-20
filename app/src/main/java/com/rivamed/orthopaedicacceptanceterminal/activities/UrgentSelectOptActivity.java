package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lzy.okgo.model.Response;
import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.common.utils.EventBusUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.adapter.UrgentSelectOptAdapter;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.Event;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByStatusResponseParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

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
public class UrgentSelectOptActivity extends OatBaseActivity {
    @BindView(R.id.rv_context)
    RecyclerView rvContext;
    private UrgentSelectOptAdapter mUrgentSelectOptAdapter;
    List<FindByStatusResponseParam.SurgeryDictsBean> listData = new ArrayList<FindByStatusResponseParam.SurgeryDictsBean>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_urgent_selectopt;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        initView();
        findByStatus("1");
        initEvent();
    }
    private void initEvent() {
        mUrgentSelectOptAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                EventBusUtils.post(new Event.EventSelectOpt(listData.get(position)));
                finish();
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private void initView() {
        tvCenterTitle.setText("选择手术");
        mUrgentSelectOptAdapter = new UrgentSelectOptAdapter(getApplicationContext());
        mUrgentSelectOptAdapter.setList(listData);
        GridLayoutManager layoutManage = new GridLayoutManager(getApplicationContext(), 2);
        rvContext.setLayoutManager(layoutManage);
        rvContext.setAdapter(mUrgentSelectOptAdapter);
    }

    /**
     * 手术信息查询
     *
     * @param status
     */
    private void findByStatus(String status) {
        Map<String, String> map = new HashMap<>(1);
        map.put("status", status);
        OkGoUtil.getRequest(UrlPath.ORDER_FIND_BY_STATUS, this, map,
                new DialogCallback<FindByStatusResponseParam>(this) {
                    @Override
                    public void onSuccess(Response<FindByStatusResponseParam> response) {
                        if (response.body() != null && response.body().getSurgeryDicts() != null) {
                            listData.clear();
                            listData.addAll(response.body().getSurgeryDicts());
                            mUrgentSelectOptAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onError(Response<FindByStatusResponseParam> response) {
                        super.onError(response);
                    }
                });
    }
}
