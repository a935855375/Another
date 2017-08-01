package com.fc.fan.another.module.entry;

import java.util.List;

/**
 * Created by fan on 8/1/17.
 * A nice day..
 */

public class PlanBean {

    /**
     * courses : [{"cid":1,"isRoot":0,"name":"xxx","people":11,"picture":"1.jpg","summary":"..................."}]
     * name : 关于。。。。。。
     * picture : 1.jpg
     * piid : 1
     * summary : 子计划1
     * time : {"date":25,"day":2,"hours":10,"minutes":3,"month":6,"nanos":0,"seconds":4,"time":1500948184000,"timezoneOffset":-480,"year":117}
     * title : 第一步
     */

    private String name;
    private String picture;
    private int piid;
    private String summary;
    private TimeBean time;
    private String title;
    private List<CoursesBean> courses;

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

    public int getPiid() {
        return piid;
    }

    public void setPiid(int piid) {
        this.piid = piid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public List<CoursesBean> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesBean> courses) {
        this.courses = courses;
    }

    public static class TimeBean {
        /**
         * date : 25
         * day : 2
         * hours : 10
         * minutes : 3
         * month : 6
         * nanos : 0
         * seconds : 4
         * time : 1500948184000
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

    public static class CoursesBean {
        /**
         * cid : 1
         * isRoot : 0
         * name : xxx
         * people : 11
         * picture : 1.jpg
         * summary : ...................
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
