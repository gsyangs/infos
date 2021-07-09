package com.app.mvvm_jetpack.data.bean;

import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/9 16
 * 邮箱 894417048@qq.com
 */
public class TitleRequestBean {

    private int totalNum;
    private int ret_code;
    private List<ChannelListBean> channelList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public List<ChannelListBean> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelListBean> channelList) {
        this.channelList = channelList;
    }

    public class ChannelListBean {
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
}