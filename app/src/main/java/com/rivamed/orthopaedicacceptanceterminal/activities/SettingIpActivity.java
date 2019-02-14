package com.rivamed.orthopaedicacceptanceterminal.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rivamed.common.base.SimpleActivity;
import com.rivamed.common.utils.SPUtils;
import com.rivamed.common.utils.ToastUtils;
import com.rivamed.orthopaedicacceptanceterminal.R;
import com.rivamed.orthopaedicacceptanceterminal.app.Constants;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * @author Amos_Bo
 */
public class SettingIpActivity extends SimpleActivity {
    @BindView(R.id.et_ip)
    EditText etIp;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_cancel)
    Button btnCancel;


    @Override
    public int getLayoutId() {
        return R.layout.activity_setting_ip;
    }

    @Override
    public void initDataAndEvent(Bundle savedInstanceState) {
        String ip = SPUtils.getString(this, Constants.SAVE_SYS_IP, "");
        if (!TextUtils.isEmpty(ip)) {
            etIp.setText(ip);
        }
    }

    @Override
    public void onBindViewBefore() {

    }

    @Override
    public Object newP() {
        return null;
    }


    @OnClick({R.id.btn_save, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                final String newIP = etIp.getText().toString().trim();
                if (!TextUtils.isEmpty(newIP)) {
                    if (checkAddress(newIP)) {

                    } else {
                        ToastUtils.showShort("请输入合法IP和端口号");
                    }
                } else {
                    ToastUtils.showShort("IP和端口号不能为空");
                }
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * ip和端口号校验
     * @param s
     * @return
     */
    boolean checkAddress(String s) {
        return s.matches("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1," + "2}|1\\d\\d|2[0-4" + "]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1," + "2}|1\\d\\d|2" + "[0-4]\\d|25[0-5])\\:([0-9]|[1-9]\\d{1," + "3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5])$");
    }
}
