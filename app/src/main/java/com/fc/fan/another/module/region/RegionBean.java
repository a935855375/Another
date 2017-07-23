package com.fc.fan.another.module.region;

import java.util.List;

/**
 * Created by fan on 7/21/17.
 */

public class RegionBean {

    /**
     * did : 1
     * name : 前端开发
     * types : [{"name":"HTML","picture":"1.jpg","tid":1},{"name":"CSS","picture":"1.jpg","tid":2},{"name":"JavaScript","picture":"1.jpg","tid":3},{"name":"jQuery","picture":"1.jpg","tid":4},{"name":"Node.js","picture":"1.jpg","tid":5},{"name":"Bootstrap","picture":"1.jpg","tid":6}]
     */

    private int did;
    private String name;
    private List<TypesBean> types;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {
        /**
         * name : HTML
         * picture : 1.jpg
         * tid : 1
         */

        private String name;
        private String picture;
        private int tid;

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

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }
    }
}
