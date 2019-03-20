package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.common.utils.BaseUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteResponseParam;

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
public class OperationPlanSuiteAdapter extends SimpleRecyclerAdapter<FindSuiteResponseParam.OciSuiteVosBean,
        OperationPlanSuiteAdapter.MyHolder> {

    public OperationPlanSuiteAdapter(Context context) {
        super(context, R.layout.item_operation_suit);
    }

    @Override
    protected void convert(MyHolder holder, FindSuiteResponseParam.OciSuiteVosBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvOpName.setText(item.getSuiteName());
        holder.tvSupplier.setText(item.getVendorName());
        if (position == getItemCount() - 1) {
            holder.llAdd.setVisibility(View.VISIBLE);
        } else {
            holder.llAdd.setVisibility(View.GONE);
        }
        BaseUtils.setInputLenWithNoBlank(holder.etRemark, 100);
        holder.etRemark.setTag(item.getId());
        if (holder.etRemark.getTag().equals(item.getId())) {
            holder.etRemark.setText(item.getRemark());
            holder.etRemark.setSelection(item.getRemark().length());
        }
        //        holder.etRemark.setText(item.getRemark());
        holder.llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickSuitListener != null) {
                    mClickSuitListener.OnAdd(position);
                }
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickSuitListener != null) {
                    mClickSuitListener.OnSelectSuit(position);
                }
            }
        });

        holder.etRemark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (holder.etRemark.getTag().equals(item.getId())) {

                    String content1 = item.getRemark();
                    if (!charSequence.equals(content1)) {
                        item.setRemark(charSequence.toString());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

    //提供接口
    public OnClickSuitListener mClickSuitListener;

    public interface OnClickSuitListener {
        void OnSelectSuit(int position);//选择套餐

        void OnAdd(int position);//添加

        //        void OnAfterEditRemark(int position, String content);//医嘱备注
    }

    public void setOnSelectSuitListener(OnClickSuitListener onClickSuitListener) {
        mClickSuitListener = onClickSuitListener;
    }


}
