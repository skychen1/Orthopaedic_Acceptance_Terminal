package com.rivamed.common.base.app;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.common.base.app
 * @ClassName: LoginInvalidListener
 * @Description: token失效监听
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 15:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 15:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface LoginInvalidListener {
    /**
     * token失效回调
     */
    void tokenInvalid();
}
