package com.fc.fan.another.utils;

import java.util.List;

/**
 * Created by fan on 7/18/17.
 */

public class Test {

    /**
     * did : 1
     * name : 前端开发
     * types : [{"name":"Node.js","tid":5},{"name":"HTML","tid":1},{"name":"Bootstrap","tid":6},{"name":"jQuery","tid":4},{"name":"CSS","tid":2},{"name":"JavaScript","tid":3}]
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
         * name : Node.js
         * tid : 5
         */

        private String name;
        private int tid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }
    }
}
