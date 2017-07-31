package com.fc.fan.another.module.mine.bean;

import java.util.List;

/**
 * Created by fan on 7/31/17.
 * A nice day..
 */

public class DirectBean {

    /**
     * limit : 4
     * list : [{"name":"css html...","picture":"1.jpg","pid":1,"summary":"第一个计划","time":{"date":25,"day":2,"hours":10,"minutes":2,"month":6,"nanos":0,"seconds":7,"time":1500948127000,"timezoneOffset":-480,"year":117},"title":"前端"},{"name":"css html...","picture":"1.jpg","pid":1,"summary":"第一个计划","time":{"date":25,"day":2,"hours":10,"minutes":2,"month":6,"nanos":0,"seconds":7,"time":1500948127000,"timezoneOffset":-480,"year":117},"title":"前端"},{"name":"css html...","picture":"1.jpg","pid":1,"summary":"第一个计划","time":{"date":25,"day":2,"hours":10,"minutes":2,"month":6,"nanos":0,"seconds":7,"time":1500948127000,"timezoneOffset":-480,"year":117},"title":"前端"}]
     * page : 1
     * totalCount : 3
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
         * name : css html...
         * picture : 1.jpg
         * pid : 1
         * summary : 第一个计划
         * time : {"date":25,"day":2,"hours":10,"minutes":2,"month":6,"nanos":0,"seconds":7,"time":1500948127000,"timezoneOffset":-480,"year":117}
         * title : 前端
         */

        private String name;
        private String picture;
        private int pid;
        private String summary;
        private TimeBean time;
        private String title;

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

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
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

        public static class TimeBean {
            /**
             * date : 25
             * day : 2
             * hours : 10
             * minutes : 2
             * month : 6
             * nanos : 0
             * seconds : 7
             * time : 1500948127000
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
    }
}
