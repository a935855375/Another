package com.fc.fan.another.module.explore;

import java.util.List;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class ExploreRegionBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * name : 考试答疑
         * picture : d.jpg
         * qid : 4
         * style : 2
         */

        private String name;
        private String picture;
        private int qid;
        private int style;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getQid() {
            return qid;
        }

        public void setQid(int qid) {
            this.qid = qid;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }
}
