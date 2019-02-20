package com.rivamed.common.http.callback;

import android.media.session.MediaSession;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.common.http.callback
 * @ClassName: TokenUtils
 * @Description: Token检验工具
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 14:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 14:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TokenUtils {
    /**
     * 是否启用Token检验
     */
    public static boolean IS_USE_TOKEN = false;
    /**
     * token标签
     */
    public static String TOKEN_TAG = "opFlg";
    /**
     * token过期码
     */
    public static String TOKEN_INVALID_CODE = "1010";
}
