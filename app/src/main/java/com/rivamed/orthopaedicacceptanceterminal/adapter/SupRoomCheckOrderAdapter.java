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
 * @Description: 供应室验收订单
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SupRoomCheckOrderAdapter extends SimpleRecyclerAdapter<FindOrderResponseParam.OciOrderVosBean,
        SupRoomCheckOrderAdapter.MyHolder> {

    private int mType;

    public SupRoomCheckOrderAdapter(Context context) {
        super(context, R.layout.item_cstcost_submit);
    }

    /*
     * 0 有状态列
     * 1  无状态列
     * */
    public SupRoomCheckOrderAdapter(Context context, int type) {
        super(context, R.layout.item_cstcost_submit);
        mType = type;
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
        holder.mTvState.setText(item.getStatus());
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
        if (mType == 1) {
            holder.mTvState.setVisibility(View.GONE);
            holder.mVStateLine.setVisibility(View.GONE);
        } else {
            holder.mTvState.setVisibility(View.VISIBLE);
            holder.mVStateLine.setVisibility(View.VISIBLE);
        }
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
        TextView mTvState;
        @BindView(R.id.v_state_line)
        View mVStateLine;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
