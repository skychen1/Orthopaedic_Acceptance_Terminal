package com.rivamed.common.utils;

import android.content.Context;
import android.os.CountDownTimer;


/**
 * @ProjectName: LowValueAcceptSys
 * @Package: com.rivamed.lowvalueacceptsys.utils
 * @ClassName: CountTimerUtils
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2018/11/7 15:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/11/7 15:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CountTimerUtils extends CountDownTimer {
    private Context context;

    /**
     * 参数 millisInFuture       倒计时总时间（如60S，120s等）
     * 参数 countDownInterval    渐变时间（每次倒计1s）
     */
    public CountTimerUtils(long millisInFuture, long countDownInterval, Context context) {
        super(millisInFuture, countDownInterval);
        this.context = context;
    }

    // 计时完毕时触发
    @Override
    public void onFinish() {

    }


    // 计时过程显示
    @Override
    public void onTick(long millisUntilFinished) {
    }
}
