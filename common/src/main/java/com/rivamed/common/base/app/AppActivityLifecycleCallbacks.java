package com.rivamed.common.base.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.LinkedList;

/**
 * @author : Amos_bo
 * @package: com.rivamed.common.base.app
 * @Created Time: 2018/4/19 17:11
 * @Changed Time: 2018/4/19 17:11
 * @email: 284285624@qq.com
 * @Org: SZKT
 * @version: V1.0
 * @describe: //生命周期监听
 */

public class AppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks,
        ActivityStater {

    private LinkedList<Activity> mAllActivityList = new LinkedList<>();
    private LinkedList<Activity> mResumeActivity = new LinkedList<>();

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        mAllActivityList.add(0, activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (!mResumeActivity.contains(activity)) {
            mResumeActivity.add(activity);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        mResumeActivity.remove(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        mAllActivityList.remove(activity);
    }

    //***************************************************************//

    @Override
    public Activity getCurrentActivity() {
        return mAllActivityList.size() > 0 ? mAllActivityList.get(0) : null;
    }

    @Override
    public int getActivityCount() {
        return mAllActivityList.size();
    }

    @Override
    public boolean isForeground() {
        return mResumeActivity.size() > 0 || mAllActivityList.size() > 0;
    }
}
