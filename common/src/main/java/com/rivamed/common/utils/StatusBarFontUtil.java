package com.rivamed.common.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.common.utils
 * @ClassName: StatusBarFontUtil
 * @Description: 状态栏字体颜色修改
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/15 11:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/15 11:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StatusBarFontUtil {
    /**
     * 黑色字体状态栏,版本>=6.0
     * @param activity
     */
    public static void setLightStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow()
                    .getDecorView()
                    .setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 白色字体状态栏,版本>=6.0
     * @param activity
     */
    public static void setWhiteStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }
}
