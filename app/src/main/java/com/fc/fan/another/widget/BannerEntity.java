package com.fc.fan.another.widget;

/**
 * Created by hcc on 16/8/24 21:37
 * 100332338@qq.com
 * <p>
 * Banner模型类
 */
public class BannerEntity {
    public String title;
    public String img;
    public int cid;

    public BannerEntity(int cid, String title, String img) {
        this.cid = cid;
        this.title = title;
        this.img = img;
    }

}
