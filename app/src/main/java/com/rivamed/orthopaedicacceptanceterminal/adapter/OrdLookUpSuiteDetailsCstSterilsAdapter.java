package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.text.TextUtils;
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
 * @Description: 无菌类耗材adapter
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrdLookUpSuiteDetailsCstSterilsAdapter extends SimpleRecyclerAdapter<FindSuiteDetailResponseParam.AsepticCstsBean, OrdLookUpSuiteDetailsCstSterilsAdapter.MyHolder> {
    public OrdLookUpSuiteDetailsCstSterilsAdapter(Context context) {
        super(context, R.layout.item_ord_lookup_suite_details_cst_sterils);
    }

    @Override
    protected void convert(MyHolder holder, FindSuiteDetailResponseParam.AsepticCstsBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvCstName.setText(item.getCstName());
        holder.tvCstCode.setText(item.getCstCode());
        holder.tvSupplierModule.setText(item.getCstSpec());
        holder.tvCstBatch.setText(item.getBatchNo());
        holder.tvCstValidityTime.setText(item.getExpireDate());
        if (!TextUtils.isEmpty(item.getFeeNum())) {
            holder.tvCstNumber.setText(item.getFeeNum() + "");
        } else {
            holder.tvCstNumber.setText(item.getNum() + "");
        }
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
        @BindView(R.id.tv_cst_validity_time)
        TextView tvCstValidityTime;
        @BindView(R.id.tv_cst_number)
        TextView tvCstNumber;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
