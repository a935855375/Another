package com.fc.fan.another.module.explore;

import java.util.List;

/**
 * Created by fan on 7/28/17.
 * A nice day..
 */

public class PostCommentBean {

    /**
     * limit : 8
     * list : [{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":1,"content":"这个是是树。。 。 。  。 ，。。。。","time":{"date":30,"day":0,"hours":14,"minutes":47,"month":6,"nanos":0,"seconds":45,"time":1501397265000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":2,"content":"xxxxx ","time":{"date":24,"day":1,"hours":16,"minutes":14,"month":6,"nanos":0,"seconds":21,"time":1500884061000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":3,"content":"日番谷的人很多人和事的同事的他后天发货发帖和日方非法","time":{"date":24,"day":1,"hours":16,"minutes":46,"month":6,"nanos":0,"seconds":14,"time":1500885974000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":4,"content":"12345646","time":{"date":24,"day":1,"hours":17,"minutes":4,"month":6,"nanos":0,"seconds":51,"time":1500887091000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":6,"content":"反对的方向高校纷纷改行 挂号费的发","time":{"date":24,"day":1,"hours":17,"minutes":7,"month":6,"nanos":0,"seconds":8,"time":1500887228000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":12,"content":"fdafdsasd","time":{"date":4,"day":2,"hours":14,"minutes":27,"month":6,"nanos":0,"seconds":19,"time":1499149639000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":21,"content":"这个是是树。。 。 。  。 ，。。。。","time":{"date":30,"day":0,"hours":14,"minutes":47,"month":6,"nanos":0,"seconds":45,"time":1501397265000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}},{"accept":{"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"},"aid":22,"content":"xxxxx ","time":{"date":24,"day":1,"hours":16,"minutes":14,"month":6,"nanos":0,"seconds":21,"time":1500884061000,"timezoneOffset":-480,"year":117},"user":{"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}}]
     * page : 1
     * totalCount : 11
     * totalPage : 2
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
         * accept : {"degree":0,"department":{},"email":"123456789@qq.com","isRoot":0,"job":"","password":"1","phone":"","picture":"c.jpg","realname":"","sex":"","store":"","uid":2,"username":"2"}
         * aid : 1
         * content : 这个是是树。。 。 。  。 ，。。。。
         * time : {"date":30,"day":0,"hours":14,"minutes":47,"month":6,"nanos":0,"seconds":45,"time":1501397265000,"timezoneOffset":-480,"year":117}
         * user : {"degree":0,"department":{},"email":"12345678@qq.com","isRoot":0,"job":"","password":"12","phone":"","picture":"1.jpg","realname":"","sex":"","store":"","uid":1,"username":"李"}
         */

        private AcceptBean accept;
        private int aid;
        private String content;
        private TimeBean time;
        private UserBean user;

        public AcceptBean getAccept() {
            return accept;
        }

        public void setAccept(AcceptBean accept) {
            this.accept = accept;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class AcceptBean {
            /**
             * degree : 0
             * department : {}
             * email : 123456789@qq.com
             * isRoot : 0
             * job :
             * password : 1
             * phone :
             * picture : c.jpg
             * realname :
             * sex :
             * store :
             * uid : 2
             * username : 2
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

        public static class TimeBean {
            /**
             * date : 30
             * day : 0
             * hours : 14
             * minutes : 47
             * month : 6
             * nanos : 0
             * seconds : 45
             * time : 1501397265000
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
             * department : {}
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
            private DepartmentBeanX department;
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

            public DepartmentBeanX getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBeanX department) {
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

            public static class DepartmentBeanX {
            }
        }
    }
}
