package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailResponseParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 复消类耗材adapter
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrdLookUpSuiteDetailsCstEliminnationAdapter extends SimpleRecyclerAdapter<FindSuiteDetailResponseParam.EliminationCstsBean, OrdLookUpSuiteDetailsCstEliminnationAdapter.MyHolder> {
    public OrdLookUpSuiteDetailsCstEliminnationAdapter(Context context) {
        super(context, R.layout.item_ord_lookup_suite_details_cst_eliminnation);
    }

    @Override
    protected void convert(MyHolder holder, FindSuiteDetailResponseParam.EliminationCstsBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvCstName.setText(item.getCstName());
        holder.tvCstCode.setText(item.getCstCode());
        holder.tvSupplierModule.setText(item.getCstSpec());
        holder.tvCstBatch.setText(item.getBatchNo());
        holder.tvCstNumber.setText(item.getNum()+"");
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
        @BindView(R.id.tv_supplier_module)
        TextView tvSupplierModule;
        @BindView(R.id.tv_cst_batch)
        TextView tvCstBatch;
        @BindView(R.id.tv_cst_number)
        TextView tvCstNumber;
        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
