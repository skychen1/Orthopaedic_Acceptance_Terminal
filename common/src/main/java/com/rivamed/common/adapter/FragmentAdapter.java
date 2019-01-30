package com.rivamed.common.adapter;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author : Amos_bo
 * @package: com.rivamed.common.adapter
 * @Created Time: 2018/8/23 14:50
 * @Changed Time: 2018/8/23 14:50
 * @email: 284285624@qq.com
 * @Org: SZKT
 * @version: V1.0
 * @describe: //Tag联动FragmentAdapter
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;
    private String[] mTitleList;

    public Fragment getmCurrentFragment() {
        return mCurrentFragment;
    }

    private Fragment mCurrentFragment;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    private int mPosition;

    public FragmentAdapter(@NonNull FragmentManager fm, @NonNull String[] titleList, @NonNull List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    public FragmentAdapter(@NonNull FragmentManager fm, @NonNull List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList == null || mTitleList.length == 0 ? "" : mTitleList[position];
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentFragment = (Fragment) object;
        mPosition = position;
        super.setPrimaryItem(container, position, object);
    }
}
