package com.fc.fan.another.module.common.bean;

/**
 * Created by fan on 7/29/17.
 * A nice day..
 */

public class LoginStatusBean {

    /**
     * msg : 1
     * user : {"degree":0,"department":{},"email":"2121211212@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":4,"username":"1"}
     */

    private int msg;
    private UserBean user;

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * degree : 0
         * department : {}
         * email : 2121211212@qq.com
         * isRoot : 0
         * job :
         * password : 1
         * phone :
         * picture : 1.jpg
         * realname :
         * sex :
         * store :
         * uid : 4
         * username : 1
         */

        private int degree;
        private DepartmentBean department;
        private String email;
        private int isRoot;
        private String job;
        private String password;
        private String phone;
        private String picture;
        private String realname;
        private String sex;
        private String store;
        private int uid;
        private String username;

        public int getDegree() {
            return degree;
        }

        public void setDegree(int degree) {
            this.degree = degree;
        }

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getIsRoot() {
            return isRoot;
        }

        public void setIsRoot(int isRoot) {
            this.isRoot = isRoot;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public static class DepartmentBean {
        }
    }
}
