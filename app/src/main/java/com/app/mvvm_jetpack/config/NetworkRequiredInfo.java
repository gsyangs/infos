package com.app.mvvm_jetpack.config;

import com.app.mvvm_jetpack.BuildConfig;
import com.app.network.base.INetworkRequiredInfo;

/**
 * @author:create by ys
 * 时间:2021/7/5 14
 * 邮箱 894417048@qq.com
 */
public class NetworkRequiredInfo implements INetworkRequiredInfo {
    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public String getListCount() {
        return String.valueOf(20);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}