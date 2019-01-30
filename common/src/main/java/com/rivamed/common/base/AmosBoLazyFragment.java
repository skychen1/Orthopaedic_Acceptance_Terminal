package com.rivamed.common.base;

import android.os.Bundle;
import android.view.View;

import com.rivamed.common.R;
import com.rivamed.common.base.mvp.IPresent;
import com.rivamed.common.base.mvp.IView;
import com.rivamed.common.base.mvp.KnifeKit;
import com.rivamed.common.base.mvp.LazyFragment;
import com.rivamed.common.base.mvp.VDelegate;
import com.rivamed.common.base.mvp.VDelegateBase;

import butterknife.Unbinder;

/**
 * Created by wanglei on 2017/1/26.
 */

public abstract class AmosBoLazyFragment<P extends IPresent>
        extends LazyFragment implements IView<P> {

    private VDelegate vDelegate;
    private P         p;
    
    private Unbinder unbinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        if (getLayoutView()!=null) {
            setContentView(getLayoutView());
            bindUI(getRealRootView());
        }
        bindEvent();
        initDataAndEvent(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
    }

    @Override
    public void bindEvent() {

    }
    public VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(context);
        }
        return vDelegate;
    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    protected void onDestoryLazy() {
        super.onDestoryLazy();
        if (getP() != null) {
            getP().detachV();
        }
        getvDelegate().destory();

        p = null;
        vDelegate = null;
    }
    


    @Override
    public int getOptionsMenuId() {
        return 0;
    }


    @Override
    public boolean useEventBus() {
        return false;
    }

    abstract  View getLayoutView();


}
