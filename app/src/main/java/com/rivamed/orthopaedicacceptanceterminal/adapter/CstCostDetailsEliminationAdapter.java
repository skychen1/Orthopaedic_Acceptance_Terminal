package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindCstDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.views.AddAndSubAmountView;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 计费提报-详情-复消类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CstCostDetailsEliminationAdapter extends SimpleRecyclerAdapter<FindCstDetailResponseParam.EliminationCstsBean,
        CstCostDetailsEliminationAdapter.MyHolder> {


    public CstCostDetailsEliminationAdapter(Context context) {
        super(context, R.layout.item_cstcost_details_sterils);
    }

    @Override
    protected void convert(MyHolder holder, FindCstDetailResponseParam.EliminationCstsBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvCstName.setText(item.getCstName());
        holder.tvCstCode.setText(item.getCstCode());
        holder.tvCstModule.setText(item.getCstSpec());
        holder.tvCstBatch.setText(item.getBatchNo());
        holder.tvCstNumber.setAmount(item.getNum());
        holder.tvCstNumber.setMaxAmount(item.getMaxNum());
        holder.tvCstNumber.setOnAmountChangeListener(new AddAndSubAmountView.OnAmountChangeListener() {
            @Override
            public void OnAmountChange(int amount) {
                item.setNum(amount);
                notifyDataSetChanged();
            }
        });
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_cst_name)
        TextView tvCstName;
        @BindView(R.id.tv_cst_code)
        TextView tvCstCode;
        @BindView(R.id.tv_cst_module)
        TextView tvCstModule;
        @BindView(R.id.tv_cst_batch)
        TextView tvCstBatch;
        @BindView(R.id.aas_cst_number)
        AddAndSubAmountView tvCstNumber;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
