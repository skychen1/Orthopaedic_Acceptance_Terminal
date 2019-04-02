package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.SurgeryPatientResponseParam;

import butterknife.BindView;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.fragment
 * @ClassName: OperationPlanFragment
 * @Description: 选择手术排班
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/25 18:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/25 18:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectOperationPlanAdapter extends SimpleRecyclerAdapter<SurgeryPatientResponseParam.SurgeryPatientVosBean,
        SelectOperationPlanAdapter.MyHolder> {

    public SelectOperationPlanAdapter(Context context) {
        super(context, R.layout.item_select_optplan);
    }

    @Override
    protected void convert(MyHolder holder, SurgeryPatientResponseParam.SurgeryPatientVosBean item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        holder.tvOptName.setText(item.getSurgeryName());
        holder.tvPatientName.setText(item.getPatientName());
        holder.tvPatientBrth.setText(item.getBirthday());
        holder.tvPatientId.setText(item.getHisPatientId());
        holder.tvPatientHigh.setText("--");
        holder.tvMedicalRecordNumber.setText(item.getCaseNo());
        holder.tvDoctorName.setText(item.getDoctorName());
        holder.tvPatientSex.setText(item.getGender());
        holder.tvOpTime.setText(item.getScheduleTime());
        holder.tvOptRoom.setText(item.getRoomName());
        holder.tvPatientBed.setText(item.getBedNo());

        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_opt_name)
        TextView tvOptName;
        @BindView(R.id.tv_patient_name)
        TextView tvPatientName;
        @BindView(R.id.tv_patient_brth)
        TextView tvPatientBrth;
        @BindView(R.id.tv_patient_area)
        TextView tvPatientArea;
        @BindView(R.id.tv_patient_id)
        TextView tvPatientId;
        @BindView(R.id.tv_patient_high)
        TextView tvPatientHigh;
        @BindView(R.id.tv_opt_diagnosis)
        TextView tvOptDiagnosis;
        @BindView(R.id.tv_medical_record_number)
        TextView tvMedicalRecordNumber;
        @BindView(R.id.tv_opt_room)
        TextView tvOptRoom;
        @BindView(R.id.tv_doctor_name)
        TextView tvDoctorName;
        @BindView(R.id.tv_patient_sex)
        TextView tvPatientSex;
        @BindView(R.id.tv_patient_bed)
        TextView tvPatientBed;
        @BindView(R.id.tv_op_time)
        TextView tvOpTime;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
