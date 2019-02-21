package com.rivamed.orthopaedicacceptanceterminal;

import android.app.Activity;

import com.lzy.okgo.model.Response;
import com.rivamed.common.http.OkGoUtil;
import com.rivamed.common.http.callback.DialogCallback;
import com.rivamed.orthopaedicacceptanceterminal.app.UrlPath;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderDetailResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderRequestParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindOrderStatusResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailCstResponseParam;
import com.rivamed.orthopaedicacceptanceterminal.bean.FindSuiteDetailResponseParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Orthopaedic_Acceptance_Terminal
 * @Package: com.rivamed.orthopaedicacceptanceterminal
 * @ClassName: NetDate
 * @Description: 接口类
 * @Author: Amos_Bo
 * @CreateDate: 2019/2/20 16:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/20 16:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetData {
    /**
     * 订单查询
     *
     * @param context
     * @param findOrderRequestParam
     */
    private void findOrder(Activity context, FindOrderRequestParam findOrderRequestParam) {
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FIND_ORDER, this, findOrderRequestParam,
                new DialogCallback<FindOrderResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindOrderResponseParam> response) {

            }


            @Override
            public void onError(Response<FindOrderResponseParam> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 获取订单详情
     *
     * @param context
     * @param orderId
     */
    private void findOrderDetail(Activity context, String orderId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", orderId);
        OkGoUtil.getRequest(UrlPath.ACCOUNT_FIND_ORDER_BYID, this, map,
                new DialogCallback<FindOrderDetailResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindOrderDetailResponseParam> response) {

            }

            @Override
            public void onError(Response<FindOrderDetailResponseParam> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 获取套餐明细-（无菌、复消，器械）
     *
     * @param context
     * @param suiteId
     */
    private void findSuiteDetailBySuiteId(Activity context, String suiteId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("suiteId", suiteId);
        OkGoUtil.getRequest(UrlPath.ACCOUNT_FINDBY_SUITEID, this, map,
                new DialogCallback<FindSuiteDetailResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindSuiteDetailResponseParam> response) {

            }

            @Override
            public void onError(Response<FindSuiteDetailResponseParam> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 订单操作
     *
     * @param context
     * @param operator
     */
    private void operatorOrder(Activity context, String operator, String orderId) {
        Map<String, String> map = new HashMap<>(2);
        map.put("operator", operator);
        map.put("orderId", orderId);
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_OPERATOR_ORDER, this, map,
                new DialogCallback<FindSuiteDetailResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindSuiteDetailResponseParam> response) {

            }

            @Override
            public void onError(Response<FindSuiteDetailResponseParam> response) {
                super.onError(response);
            }
        });
    }
    /**
     * 获取套餐明细（耗材、器械）
     *
     * @param context
     * @param suiteId
     */
    private void findSuiteDetailCstBySuiteId(Activity context, String suiteId) {
        Map<String, String> map = new HashMap<>(1);
        map.put("suiteId", suiteId);
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_FINDBY_ID, this, map,
                new DialogCallback<FindSuiteDetailCstResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindSuiteDetailCstResponseParam> response) {

            }

            @Override
            public void onError(Response<FindSuiteDetailCstResponseParam> response) {
                super.onError(response);
            }
        });
    }
    /**
     * 获取订单状态
     *
     * @param context
     */
    private void findOrderStatus(Activity context) {
        Map<String, String> map = new HashMap<>(1);
        OkGoUtil.postJsonRequest(UrlPath.ACCOUNT_ORDERSTATUS_LIST, this, map,
                new DialogCallback<FindOrderStatusResponseParam>(context) {
            @Override
            public void onSuccess(Response<FindOrderStatusResponseParam> response) {

            }

            @Override
            public void onError(Response<FindOrderStatusResponseParam> response) {
                super.onError(response);
            }
        });
    }
}
