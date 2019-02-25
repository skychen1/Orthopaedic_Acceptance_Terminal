package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
 * @Description: 手术排班——套餐
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OperationPlanSuiteAdapter extends SimpleRecyclerAdapter<MianFuncationParam,
        OperationPlanSuiteAdapter.MyHolder> {

    public OperationPlanSuiteAdapter(Context context) {
        super(context, R.layout.item_operation_suit);
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
        @BindView(R.id.tv_op_name)
        TextView tvOpName;
        @BindView(R.id.img_edit)
        ImageView imgEdit;
        @BindView(R.id.tv_supplier)
        TextView tvSupplier;
        @BindView(R.id.et_remark)
        EditText etRemark;
        @BindView(R.id.ll_add)
        LinearLayout llAdd;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
