package com.rivamed.common.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 公共工具
 *
 * @author WRB @createtime2105/9/26
 */
public class BaseUtils {
    public static int pagesize = 10;
    public static boolean isLogin = false;
    public static String user_id = "";
    public static String contentFlag = "one";
    public static int rebackTag = 0;// 标示是否隐藏底部view
    private static InputMethodManager mImm;
    // public static LinkedList<ChatInfo> infos = new LinkedList<ChatInfo>();


    /**
     * 判断是否是正确手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobiles(String mobiles) {
        Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 拿到正确的url
     *
     * @param homeUrl
     * @param url
     * @return
     */
    public static String makeUrlRight(String homeUrl, String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.contains("http")) {
                return url;
            } else {
                return homeUrl + url;
            }
        } else {

            return "";
        }
    }

    /**
     * 判断手机号是联通 、移动、电信
     *
     * @param mobiles
     * @return
     */
    public static int isYYSMobiles(String mobiles) {
        String gsm = "^((13[4-9])|(147)|(15[0-2,7-9])|(18[2-3,7-8]))\\d{8}$";
        String wcdma = "^((13[0-2])|(145)|(15[5-6])|(186))\\d{8}$";
        String cdma = "^((133)|(153)|(18[0,9]))\\d{8}$";
        int flag = 0;
        if (mobiles.matches(wcdma)) {
            flag = 1;
            System.out.println("联通号码");
        } else if (mobiles.matches(gsm)) {
            flag = 2;
            System.out.println("移动号码");
        } else if (mobiles.matches(cdma)) {
            flag = 3;
            System.out.println("电信号码");
        } else {
            flag = 4;
            System.out.println("号码有误");
        }
        return flag;
    }

    /**
     * 判断是否是正确身份证�?
     *
     * @param
     * @return
     */
    public static boolean isSFZCards(String idcard) {
        Pattern p = Pattern
                .compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])(\\d{4}|\\d{3}[x|X])$");
        Matcher m = p.matcher(idcard);
        return m.matches();
    }

    /**
     * 判断账号是否符合
     *
     * @param account
     * @return
     */
    public static boolean isAccounts(String account) {
        Pattern p = Pattern.compile("^(?![0-9])[a-zA-Z0-9_]{6,8}$");
        Matcher m = p.matcher(account);
        return m.matches();
    }

    /**
     * 只能输入数字
     *
     * @param mobiles
     * @return
     */
    public static boolean onlynumber(String mobiles) {
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断是否网络链接正常
     *
     * @param context
     * @return true or false
     * @author: WRB
     * @Createtime: 2015/9/26
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean flag = false;
        ConnectivityManager localConnectivityManager = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (localConnectivityManager != null) {
            try {
                NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
                if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable())) {
                    flag = false;
                } else {
                    flag = true;
                }
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 判断是否存在SD�?
     *
     * @return true or false
     * @author WRB
     */
    public static boolean hasSDCard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }


    /**
     * 提取手机号码
     *
     * @param text
     * @return
     */
    public static String cutPhoneNumber(String text) {
        List<Integer> datas = new ArrayList<Integer>();
        String phone = "";
        String str2 = text.replace(" ", "");
        for (int i = 0; i < str2.length() - 1; i++) {
            if ("1".equals(String.valueOf(str2.charAt(i)))) {
                datas.add(i);
            }
        }
        if (datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                int dex = datas.get(i) + 11;
                if (dex <= str2.length()) {
                    String str3 = str2.substring(datas.get(i), dex);
                    if (isMobiles(str3)) {
                        phone = str3;
                    }
                }

            }

        }
        return phone;
    }

    // 二进�?
    public static String getBitmapByte(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray().toString();
    }


    /**
     * 判断是否安装微信
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }

    //判断是否安装目标应用
    public static boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName)
                .exists();
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 系统提示音播放
     *
     * @param context
     */
    public static void soundRing(Context context) {

        MediaPlayer mp = new MediaPlayer();
        mp.reset();
        try {
            mp.setDataSource(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            mp.prepare();
            mp.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 判断网络是否连接 true 连接 ；false 断开
     *
     * @param context
     * @return
     */
    public static boolean InternetStatus(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {// unconnect
            // network
            return false;
        } else {// connect network
            return true;
        }
    }


    /**
     * 截取含有多个index的字符串,返回集合
     *
     * @param index
     * @param picture
     * @return
     */
    public static List<String> multiSubString(String index, String picture) {

        List<String> subArr = new ArrayList<String>();

        subStr(index, picture, subArr);

        return subArr;
    }

    private static void subStr(String index, String picture, List<String> subArr) {

        String substring = picture.substring(0, picture.indexOf(index));
        if (!TextUtils.isEmpty(substring)) {
            subArr.add(substring);
        }

        String substring1 = picture.substring(picture.indexOf(index) + 1, picture.length());
        if (!TextUtils.isEmpty(substring1) && substring1.contains(index) && substring1.length() > 1) {
            subStr(index, substring1, subArr);
        }
    }


    /* 定义一个倒计时的内部类 */
    static class TimeCount extends CountDownTimer {

        TextView textView;

        public TimeCount(long millisInFuture, long countDownInterval, TextView textView) {

            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
            this.textView = textView;
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            textView.setText("重新获取");
            textView.setEnabled(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            textView.setEnabled(false);
            textView.setText(millisUntilFinished / 1000 + "秒");
        }
    }

    /**
     * 获取验证码计时器
     *
     * @param millisInFuture    总时长
     * @param countDownInterval 计时的时间间隔
     * @param textView          验证码按钮
     */
    public static void startCaptureTimeCount(long millisInFuture, long countDownInterval, TextView textView) {

        new TimeCount(millisInFuture, countDownInterval, textView).start();
    }

    /**
     * 设置不能输入空格
     *
     * @param textView 输入控件
     */
    public static void setNotBlankInput(TextView textView) {

        textView.setFilters(new InputFilter[]{filter});

    }

    /**
     * 设置最大输入长度
     *
     * @param textView
     * @param max
     */
    public static void setInputLength(TextView textView, int max) {

        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});

    }

    public static void setInputLenWithNoBlank(TextView textView, int max) {

        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max), filter});

    }

    /**
     * 可滚动,限制长度,无空格editText
     *
     * @param textView
     * @param max
     */
    public static void setInputLenWithNoBlankScroll(EditText textView, int max) {

        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max), filter});
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setSelection(textView.getText().length(), textView.getText().length());


    }

    private static InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            //返回null表示接收输入的字符,返回空字符串表示不接受输入的字符
            if (source.equals(" "))
                return "";
            else
                return null;
        }
    };


    /**
     * 验证邮箱格式是否正确
     */
    public static boolean emailValidation(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }


    /**
     * 四舍五入保留小数点后n位
     *
     * @param d
     * @return
     */
    public static double GetDoubleRound(double d, int n) {

        return new BigDecimal(d).setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入保留小数点后2位
     *
     * @param d
     * @return
     */
    public static double GetDoubleRoundTwo(double d) {
        return ((double) Math.round(d * 100) / 100.0);
    }

    /**
     * 强制四舍五入保留小数点后2位
     *
     * @param d
     * @return
     */
    public static String ForceSetDoubleRoundTwo(double d) {

        double money = BaseUtils.GetDoubleRoundTwo(d);
        String myMoney = formatFloatNumber(money);
        if (myMoney.length() - myMoney.indexOf(".") == 2) {
            myMoney = myMoney + "0";
        }
        return myMoney;

    }

    /**
     * 当浮点型数据位数超过10位之后，数据变成科学计数法显示。用此方法可以使其正常显示。
     *
     * @param value
     * @return Sting
     */
    public static String formatFloatNumber(double value) {
        if (value != 0.00) {
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
            return df.format(value);
        } else {
            return "0.00";
        }

    }

    /**
     * 取消输入框
     *
     * @param context
     * @param windowToken v.getWindowToken()
     */
    public static void hideEditextWindow(Context context, IBinder windowToken) {

        //隐藏输入框
        if (mImm == null) {
            mImm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        }

        mImm.hideSoftInputFromWindow(windowToken, 0);
    }

    /**
     * 从路径获取文件名
     *
     * @param pathName
     * @return
     */
    public static String getFileName(String pathName) {
        int start = pathName.lastIndexOf("/");
        int end = pathName.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathName.substring(start + 1, end);
        } else {
            return null;
        }
    }

    public interface OnConfirm {

        void onConfirm();

    }


    public interface OnSuccess {

        void onSuccess();

    }

    /**
     * 添加删除线
     *
     * @param textView
     */
    public static void addDeleteLine(TextView textView) {
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

    /**
     * 滑动屏幕 可重新显示出来
     * //隐藏虚拟按键，并且全屏
     *
     * @param activity
     */
    public static void hideBottomUIMenu(Activity activity) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = activity.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * 滑动屏幕 可重新显示出来
     * //隐藏虚拟按键，并且全屏
     *
     * @param activity
     */
    public static void hideBottomUIMenuOfDailog(final Dialog activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        activity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        //布局位于状态栏下方
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        //全屏
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        //隐藏导航栏
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (Build.VERSION.SDK_INT >= 19) {
                    uiOptions |= 0x00001000;
                } else {
                    uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
            }
        });

    }

    /**
     * 滑动也不能重新显示
     * //隐藏虚拟按键，并且全屏
     *
     * @param activity
     */
    public static void hideBottomUIMenuAlways(Activity activity) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = activity.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            Window _window = activity.getWindow();
            WindowManager.LayoutParams params = _window.getAttributes();
            params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
            _window.setAttributes(params);
        }
    }

    /**
     * 渠道标志为：
     * 1，andriod（a）
     * <p>
     * 识别符来源标志：
     * 1， wifi mac地址（wifi）；
     * 2， IMEI（imei）；
     * 3， 序列号（sn）；
     * 4， id：随机码。若前面的都取不到时，则随机生成一个随机码，需要缓存。
     *
     * @param context
     */
    public static String getDeviceId(Context context) {
        StringBuilder deviceId = new StringBuilder();
        // 渠道标志
        deviceId.append("a");
        try {
            //wifi mac地址
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            String wifiMac = info.getMacAddress();
            if (!TextUtils.isEmpty(wifiMac)) {
                deviceId.append("wifi");
                deviceId.append(wifiMac);
                return deviceId.toString();
            }
            //IMEI（imei）
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            @SuppressLint("MissingPermission") String imei = tm.getDeviceId();
            if (!TextUtils.isEmpty(imei)) {
                deviceId.append("imei");
                deviceId.append(imei);
                return deviceId.toString();
            }
            //序列号（sn）
            @SuppressLint("MissingPermission") String sn = tm.getSimSerialNumber();
            if (!TextUtils.isEmpty(sn)) {
                deviceId.append("sn");
                deviceId.append(sn);
                return deviceId.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceId.toString();
    }

    private static final int MIN_DELAY_TIME= 2000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime;
    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }

    public static void hideInputWindow(Context context,View v) {
        InputMethodManager imm =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
    /**
     * 获取当前屏幕宽度px(像素)
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * 获取当前屏幕高度px(像素)
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
