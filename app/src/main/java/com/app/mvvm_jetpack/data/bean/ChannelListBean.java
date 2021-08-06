package com.app.mvvm_jetpack.data.bean;

/**
 * @author:create by ys
 * 时间:2021/7/19 10
 * 邮箱 894417048@qq.com
 */
public class ChannelListBean {
    public ChannelListBean(String channelId, String name) {
        this.channelId = channelId;
        this.name = name;
    }

    private String channelId;
    private String name;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} 