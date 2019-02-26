package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.MianFuncationParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 订单申请-手术排班-选择套餐-套餐明细-器械
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OperationSuiteApparatusDetailsAdapter extends SimpleRecyclerAdapter<MianFuncationParam, OperationSuiteApparatusDetailsAdapter.MyHolder> {


    public OperationSuiteApparatusDetailsAdapter(Context context) {
        super(context, R.layout.item_select_optsuite_details_apparatus);
    }

    @Override
    protected void convert(MyHolder holder, MianFuncationParam item, final int position) {
        if (item == null || holder == null) {
            return;
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
        @BindView(R.id.tv_cst_number)
        TextView tvCstNumber;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
