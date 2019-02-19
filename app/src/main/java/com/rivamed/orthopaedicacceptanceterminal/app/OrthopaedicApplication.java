package com.rivamed.orthopaedicacceptanceterminal.app;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.rivamed.common.base.app.BaseApplication;
import com.rivamed.common.utils.SPUtils;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal.app
 * @ClassName: OrthopaedicApplication
 * @Description: 骨科App
 * @Author: Amos_Bo
 * @CreateDate: 2019/1/30 9:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/30 9:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@SuppressLint("Registered")
public class OrthopaedicApplication extends BaseApplication {

    @Override
    protected String getRootUrl() {
        String SysIP = SPUtils.getString(BaseApplication.getInstance(), Constants.SAVE_SYS_IP);
        if (TextUtils.isEmpty(SysIP)) {
            SysIP = UrlPath.ROOT_URL;
        }
        return SysIP;
    }
}
