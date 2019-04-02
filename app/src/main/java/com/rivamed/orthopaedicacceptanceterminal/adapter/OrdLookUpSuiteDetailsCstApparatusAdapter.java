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
 * @Description: 器械类耗材adapter
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrdLookUpSuiteDetailsCstApparatusAdapter extends SimpleRecyclerAdapter<FindSuiteDetailResponseParam.InstrumentsBean, OrdLookUpSuiteDetailsCstApparatusAdapter.MyHolder> {


    public OrdLookUpSuiteDetailsCstApparatusAdapter(Context context) {
        super(context, R.layout.item_ord_lookup_suite_details_cst_apparatus);
    }

    @Override
    protected void convert(MyHolder holder, FindSuiteDetailResponseParam.InstrumentsBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvApparatusName.setText(item.getName());
        holder.tvApparatusCode.setText(item.getCode());
        holder.tvApparatusNumber.setText(item.getNum()+"");
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_apparatus_name)
        TextView tvApparatusName;
        @BindView(R.id.tv_apparatus_code)
        TextView tvApparatusCode;
        @BindView(R.id.tv_apparatus_number)
        TextView tvApparatusNumber;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
