package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindByStatusResponseParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 订单申请-加急订单-选择手术
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UrgentSelectOptAdapter extends SimpleRecyclerAdapter<FindByStatusResponseParam.SurgeryDictsBean,
        UrgentSelectOptAdapter.MyHolder> {

    public UrgentSelectOptAdapter(Context context) {
        super(context, R.layout.item_urgent_selectopt);
    }

    @Override
    protected void convert(MyHolder holder, FindByStatusResponseParam.SurgeryDictsBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvOptName.setText(item.getName());
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_opt_name)
        TextView tvOptName;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
