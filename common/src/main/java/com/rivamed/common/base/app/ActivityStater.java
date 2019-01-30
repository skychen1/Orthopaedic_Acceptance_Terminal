package com.rivamed.common.base.app;

import android.app.Activity;

/**
 * @author : Amos_bo
 * @package: com.rivamed.common.base.app
 * @Created Time: 2018/4/19 17:39
 * @Changed Time: 2018/4/19 17:39
 * @email: 284285624@qq.com
 * @Org: SZKT
 * @version: V1.0
 * @describe: //TODO 添加描述
 */

public interface ActivityStater {
    /**
     * 得到当前Activity
     *
     * @return
     */
    Activity getCurrentActivity();

    /**
     * 任务栈中Activity的总数
     *
     * @return
     */
    int getActivityCount();

    /**
     * 判断应用是否处于前台，即是否可见
     *
     * @return
     */
    boolean isForeground();
}