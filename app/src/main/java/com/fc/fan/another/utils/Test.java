package com.fc.fan.another.utils;

import java.util.List;

/**
 * Created by fan on 7/18/17.
 */

public class Test {

    private List<OfficListBean> officList;
    private List<ResourceListBean> resourceList;

    public List<OfficListBean> getOfficList() {
        return officList;
    }

    public void setOfficList(List<OfficListBean> officList) {
        this.officList = officList;
    }

    public List<ResourceListBean> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ResourceListBean> resourceList) {
        this.resourceList = resourceList;
    }

    public static class OfficListBean {
        /**
         * filePath : 1.pdf
         * name : 复习资料
         * orid : 1
         * showPath :
         */

        private String filePath;
        private String name;
        private int orid;
        private String showPath;

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrid() {
            return orid;
        }

        public void setOrid(int orid) {
            this.orid = orid;
        }

        public String getShowPath() {
            return showPath;
        }

        public void setShowPath(String showPath) {
            this.showPath = showPath;
        }
    }

    public static class ResourceListBean {
        /**
         * name : 蒲公英
         * path : 1.mp4
         * rid : 1
         * summary : xxxxx课程
         */

        private String name;
        private String path;
        private int rid;
        private String summary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
