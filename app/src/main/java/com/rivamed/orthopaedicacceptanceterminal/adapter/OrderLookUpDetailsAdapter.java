package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderDetailResponseParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 订单查询-详情
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderLookUpDetailsAdapter extends SimpleRecyclerAdapter<FindOrderDetailResponseParam.OciSuiteVosBean,
        OrderLookUpDetailsAdapter.MyHolder> {
    public OrderLookUpDetailsAdapter(Context context) {
        super(context, R.layout.item_order_lookup_details);
    }

    @Override
    protected void convert(MyHolder holder, FindOrderDetailResponseParam.OciSuiteVosBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvOpName.setText(item.getSuiteName());
        holder.tvSupplier.setText(item.getVendorName());
        holder.tvRemark.setText(item.getRemark());
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
        holder.tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSuitDetailClickListener != null) {
                    mSuitDetailClickListener.OnSuitDetailClick(position);
                }
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_op_name)
        TextView tvOpName;
        @BindView(R.id.tv_details)
        TextView tvDetails;
        @BindView(R.id.tv_supplier)
        TextView tvSupplier;
        @BindView(R.id.tv_remark)
        TextView tvRemark;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

    //提供点击接口
    public OnSuitDetailClickListener mSuitDetailClickListener;

    public interface OnSuitDetailClickListener {
        void OnSuitDetailClick(int position);
    }

    public void setOnSuitDetailClickListener(OnSuitDetailClickListener onSuitDetailClickListener) {
        mSuitDetailClickListener = onSuitDetailClickListener;
    }

}
