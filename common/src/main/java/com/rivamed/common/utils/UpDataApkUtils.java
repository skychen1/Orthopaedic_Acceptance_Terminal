package com.rivamed.common.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.rivamed.common.R;
import com.rivamed.common.bean.VersionBean;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.JsonCallback;
import com.rivamed.common.views.UpDateDialog;

import java.io.File;
import java.util.HashMap;



/**
 * @ProjectName:com.rivamed.common
 * @Package: com.rivamed.tiger.haocai.utils
 * @ClassName: UpDataApkUtils
 * @Description: java类作用描述
 * @Author: Amos_Bo
 * @CreateDate: 2018/12/26 18:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/26 18:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UpDataApkUtils {
    private static final String TAG = "UpDataApkUtils";
    private static  String mUrlVersion;
    private static  String mUrlFileApk;
    private static  String mSystemType;

    /**
     * 版本检测
     * @param context
     * @param urlVersion 查询是否有更新的地址
     * @param urlFileApk 如果有更新要下载的APK地址
     * @param systemType    终端名称
     */
    public static void getUpDataVersion(final Context context,String urlVersion,String urlFileApk,String systemType) {
        mUrlVersion=urlVersion;
        mUrlFileApk=urlFileApk;
        mSystemType=systemType;
        HashMap<String, String> keyMap = new HashMap<>(1);
        keyMap.put("systemType", mSystemType);
        OkGoUtil.getRequest(mUrlVersion, context, keyMap, new JsonCallback<VersionBean>() {
            @Override
            public void onSuccess(Response<VersionBean> response) {
                // 本地版本号
                String localVersion = PackageUtils.getVersionName(context);
                // 网络版本
                if (response.body() == null || response.body().getSystemVersion() == null) {
                    return;
                }
                String netVersion = response.body().getSystemVersion().getVersion();
                if (netVersion != null) {
                    int i = StringUtils.compareVersion(netVersion, localVersion);
                    if (i == 1) {
                        showUpdateDialog(response.body().getSystemVersion().getDescription(), context);
                    }
                }
            }

            @Override
            public void onError(Response<VersionBean> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 展现更新的dialog
     */
    private static void showUpdateDialog(String desc, final Context context) {
        UpDateDialog.Builder builder = new UpDateDialog.Builder(context);
        builder.setTitle(UIUtils.getString(R.string.ver_title));
        builder.setMsg(desc);
        builder.setLeft(UIUtils.getString(R.string.ver_cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
        builder.setRight(UIUtils.getString(R.string.ver_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //未下载就开始下载
                downloadNewVersion(context);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private static void downloadNewVersion(Context context) {
        // 1.显示进度的dialog
        ProgressDialog mDialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDialog.setCancelable(false);
        mDialog.setMax(100);
        mDialog.show();
        loadUpDataVersion(mDialog, context);

    }

    private static void loadUpDataVersion(final ProgressDialog mDialog, final Context context) {
        //文件下载时，需要指定下载的文件目录和文件名
        HashMap<String, String> keyMap = new HashMap<>(1);
        keyMap.put("systemType", mSystemType);
        OkGo.<File>get(mUrlFileApk).tag(context).params(keyMap)
                .execute(new FileCallback(FileUtils.getDiskCacheDir(context),
                        "Rivamed.apk") {
                    @Override
                    public void onSuccess(Response<File> response) {
                        mDialog.dismiss();
                        upActivity(response.body(), context);
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        mDialog.setProgress((int) (progress.fraction / -1024));
                        super.downloadProgress(progress);
                    }

                    @Override
                    public void onError(Response<File> response) {
                        super.onError(response);
                        ToastUtils.showShort(R.string.connection_fails);
                        mDialog.dismiss();
                    }
                });
    }

    private static void upActivity(File file, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 7.0+以上版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");

        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            LogUtils.i(TAG, "apkUri " + Uri.fromFile(file));
        }
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
