package com.rivamed.common.utils.crash;

import android.os.Handler;
import android.os.Message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ProjectName: LowValueAcceptSys
 * @Package: com.rivamed.lowvalueacceptsys.utils.crash
 * @ClassName: RePlayTimerUtils
 * @Description: 每隔一段时间执行
 * @Author: Amos_Bo
 * @CreateDate: 2018/11/8 15:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/11/8 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RePlayTimerUtils {


    public static void startRePlay(final Handler handler) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0;
                handler.sendMessage(message);
            }
        }, 0, 6000);
    }

    public static String getAllDate() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return format.format(date);
    }

    public static String getDate() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        return format.format(date);
    }

    public static String getTime() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }


    public static String getWeekDay() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }
}
