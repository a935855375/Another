package com.fc.fan.another.module.region;

import java.util.List;

/**
 * Created by fan on 7/22/17.
 */

public class RegionItemBean {

    /**
     * limit : 8
     * list : [{"cid":1,"isRoot":0,"name":"xxx","people":12,"picture":"1.jpg","summary":"......"},{"cid":2,"isRoot":0,"name":"yyy","people":23,"picture":"1.jpg","summary":".,,,,,,"}]
     * page : 0
     * totalCount : 1
     * totalPage : 1
     */

    private int limit;
    private int page;
    private int totalCount;
    private int totalPage;
    private List<ListBean> list;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * cid : 1
         * isRoot : 0
         * name : xxx
         * people : 12
         * picture : 1.jpg
         * summary : ......
         */

        private int cid;
        private int isRoot;
        private String name;
        private int people;
        private String picture;
        private String summary;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getIsRoot() {
            return isRoot;
        }

        public void setIsRoot(int isRoot) {
            this.isRoot = isRoot;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPeople() {
            return people;
        }

        public void setPeople(int people) {
            this.people = people;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
