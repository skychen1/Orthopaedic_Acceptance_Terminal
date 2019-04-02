package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 订单查询
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderLookUpAdapter extends SimpleRecyclerAdapter<FindOrderResponseParam.OciOrderVosBean,
        OrderLookUpAdapter.MyHolder> {

    public OrderLookUpAdapter(Context context) {
        super(context, R.layout.item_order_lookup);
    }

    @Override
    protected void convert(MyHolder holder, FindOrderResponseParam.OciOrderVosBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvOptName.setText(item.getSurgeryName());
        holder.tvPatientName.setText(item.getPatientName());
        holder.tvPatientCaseId.setText(item.getCaseNo());
        holder.tvOrderId.setText(item.getOrderNo());
        holder.tvUseTime.setText(item.getCreateTime());
        holder.tvState.setText(item.getStatus());
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_opt_name)
        TextView tvOptName;
        @BindView(R.id.tv_patient_name)
        TextView tvPatientName;
        @BindView(R.id.tv_patient_case_id)
        TextView tvPatientCaseId;
        @BindView(R.id.tv_order_id)
        TextView tvOrderId;
        @BindView(R.id.tv_use_time)
        TextView tvUseTime;
        @BindView(R.id.tv_state)
        TextView tvState;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
