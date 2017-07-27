package com.fc.fan.another.module.explore;

import java.util.List;

/**
 * Created by fan on 7/26/17.
 * A nice day..
 */

public class ExplorePostBean {

    /**
     * limit : 8
     * list : [{"commentNumber":11,"content":"李蕙敏提了个问题","lookNumber":15,"qid":1,"style":1,"time":{"date":4,"day":2,"hours":21,"minutes":38,"month":6,"nanos":0,"seconds":57,"time":1499175537000,"timezoneOffset":-480,"year":117},"title":"问题xxx","user":{"degree":0,"department":null,"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}}]
     * page : 1
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
         * commentNumber : 11
         * content : 李蕙敏提了个问题
         * lookNumber : 15
         * qid : 1
         * style : 1
         * time : {"date":4,"day":2,"hours":21,"minutes":38,"month":6,"nanos":0,"seconds":57,"time":1499175537000,"timezoneOffset":-480,"year":117}
         * title : 问题xxx
         * user : {"degree":0,"department":null,"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}
         */

        private int commentNumber;
        private String content;
        private int lookNumber;
        private int qid;
        private int style;
        private TimeBean time;
        private String title;
        private UserBean user;

        public int getCommentNumber() {
            return commentNumber;
        }

        public void setCommentNumber(int commentNumber) {
            this.commentNumber = commentNumber;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLookNumber() {
            return lookNumber;
        }

        public void setLookNumber(int lookNumber) {
            this.lookNumber = lookNumber;
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

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class TimeBean {
            /**
             * date : 4
             * day : 2
             * hours : 21
             * minutes : 38
             * month : 6
             * nanos : 0
             * seconds : 57
             * time : 1499175537000
             * timezoneOffset : -480
             * year : 117
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        public static class UserBean {
            /**
             * degree : 0
             * department : null
             * email : 12345678@qq.com
             * isRoot : 0
             * job :
             * password : 12
             * phone :
             * picture : 1.jpg
             * realname :
             * sex :
             * store :
             * uid : 1
             * username : 李
             */

            private int degree;
            private Object department;
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

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
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
        }
    }
}
