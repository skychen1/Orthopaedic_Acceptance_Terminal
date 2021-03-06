package com.rivamed.orthopaedicacceptanceterminal.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rivamed.common.adapter.SimpleRecyclerAdapter;
import com.rivamed.common.adapter.SimpleViewHolder;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.bean.MianFuncationParam;

import butterknife.BindView;

/**
 * @author : Amos_bo
 * @package: com.rivamed.tiger.haocai.adapter
 * @Created Time: 2018/8/27 17:46
 * @Changed Time: 2018/8/27 17:46
 * @email: 284285624@qq.com
 * @Org: SZKT
 * @version: V1.0
 * @describe: 主界面功能
 */
public class MainFuncationAdapter extends SimpleRecyclerAdapter<MianFuncationParam,
        MainFuncationAdapter.MyHolder> {

    public MainFuncationAdapter(Context context) {
        super(context, R.layout.item_mian_funcation);
    }

    @Override
    protected void convert(MyHolder holder, MianFuncationParam item, final int position) {
        if (item == null || holder == null) {
            return;
        }
        if (!TextUtils.isEmpty(item.getTitle())) {
            holder.tvFucationName.setText(item.getTitle());
        } else {
            holder.tvFucationName.setText("");
        }
        holder.imgFuncation.setBackgroundResource(R.mipmap.ic_main_order_application);
        holder.mRoot.setOnClickListener((View v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.img_funcation)
        ImageView imgFuncation;
        @BindView(R.id.tv_funcation_name)
        TextView tvFucationName;

        MyHolder(View itemView) {
            super(itemView);
        }
    }
}
