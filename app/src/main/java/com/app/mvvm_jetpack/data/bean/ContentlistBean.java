package com.app.mvvm_jetpack.data.bean;

import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/19 11
 * 邮箱 894417048@qq.com
 */
public class ContentlistBean {
    private String id;
    private boolean havePic;
    private String pubDate;
    private String title;
    private String channelName;
    private List<NewImageBean> imageurls;
    private String source;
    private String channelId;
    private String link;
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHavePic() {
        return havePic;
    }

    public void setHavePic(boolean havePic) {
        this.havePic = havePic;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<NewImageBean> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<NewImageBean> imageurls) {
        this.imageurls = imageurls;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}