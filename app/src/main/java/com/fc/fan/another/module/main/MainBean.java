package com.fc.fan.another.module.main;

import java.util.List;

/**
 * Created by fan on 8/2/17.
 * A nice day..
 */

public class MainBean {

    private List<CbBean> cb;
    private List<KyListBean> kyList;
    private List<PlanListBean> planList;

    public List<CbBean> getCb() {
        return cb;
    }

    public void setCb(List<CbBean> cb) {
        this.cb = cb;
    }

    public List<KyListBean> getKyList() {
        return kyList;
    }

    public void setKyList(List<KyListBean> kyList) {
        this.kyList = kyList;
    }

    public List<PlanListBean> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanListBean> planList) {
        this.planList = planList;
    }

    public static class CbBean {
        /**
         * list : [{"cid":10,"isRoot":0,"name":"诺言","people":0,"picture":"1501639418463.jpg","score":99,"summary":"《诺言》由国际音乐制作人Djemba Djemba操刀作曲并制作"},{"cid":11,"isRoot":0,"name":"请到长城来滑雪","people":0,"picture":"1501639566349.jpg","score":89,"summary":"由鹿晗、陶喆共同演唱的北京申办冬奥会优秀音乐作品之一"},{"cid":12,"isRoot":0,"name":"迁徙","people":0,"picture":"1501639666529.jpg","score":90,"summary":"张信哲浪漫漂流到巴塞罗那"},{"cid":13,"isRoot":0,"name":"致爱","people":0,"picture":"1501639785660.jpg","score":96,"summary":"献给粉丝的一封情书"},{"cid":14,"isRoot":0,"name":"为何如此粗俗","people":0,"picture":"1501640801487.jpg","score":80,"summary":"春江潮水连海平 海上明月共潮生"},{"cid":15,"isRoot":0,"name":"red","people":0,"picture":"1501640922952.png","score":90,"summary":"live from New York City"},{"cid":16,"isRoot":0,"name":"小半","people":0,"picture":"1501641019808.jpg","score":90,"summary":"对你的偏爱太过于明目张胆"},{"cid":17,"isRoot":0,"name":"200%","people":0,"picture":"1501641103776.jpg","score":80,"summary":"乐童音乐家"}]
         * msg : 最新课程
         */

        private String msg;
        private List<ListBean> list;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * cid : 10
             * isRoot : 0
             * name : 诺言
             * people : 0
             * picture : 1501639418463.jpg
             * score : 99
             * summary : 《诺言》由国际音乐制作人Djemba Djemba操刀作曲并制作
             */

            private int cid;
            private int isRoot;
            private String name;
            private int people;
            private String picture;
            private int score;
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

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }
        }
    }

    public static class KyListBean {
        /**
         * picture : c.jpg
         * url : http:////10.0.0.17:8080//ff//course//course_getCourseMessage?cid=10
         */

        private String picture;
        private String url;

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class PlanListBean {
        /**
         * name : css  html...
         * picture : 1.jpg
         * pid : 1
         * planItems : [{"name":"xxxxxx","picture":"1.jpg","piid":2,"summary":"子计划2","time":{"date":25,"day":2,"hours":10,"minutes":40,"month":6,"nanos":0,"seconds":45,"time":1500950445000,"timezoneOffset":-480,"year":117},"title":"第二部"},{"name":"关于。。。。。。","picture":"1.jpg","piid":1,"summary":"子计划1","time":{"date":25,"day":2,"hours":10,"minutes":3,"month":6,"nanos":0,"seconds":4,"time":1500948184000,"timezoneOffset":-480,"year":117},"title":"第一步"},{"name":"xxx","picture":"1.jpg","piid":3,"summary":"子计划3","time":{"date":25,"day":2,"hours":10,"minutes":41,"month":6,"nanos":0,"seconds":15,"time":1500950475000,"timezoneOffset":-480,"year":117},"title":"第三步"}]
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
        private List<PlanItemsBean> planItems;

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

        public List<PlanItemsBean> getPlanItems() {
            return planItems;
        }

        public void setPlanItems(List<PlanItemsBean> planItems) {
            this.planItems = planItems;
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

        public static class PlanItemsBean {
            /**
             * name : xxxxxx
             * picture : 1.jpg
             * piid : 2
             * summary : 子计划2
             * time : {"date":25,"day":2,"hours":10,"minutes":40,"month":6,"nanos":0,"seconds":45,"time":1500950445000,"timezoneOffset":-480,"year":117}
             * title : 第二部
             */

            private String name;
            private String picture;
            private int piid;
            private String summary;
            private TimeBeanX time;
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

            public TimeBeanX getTime() {
                return time;
            }

            public void setTime(TimeBeanX time) {
                this.time = time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class TimeBeanX {
                /**
                 * date : 25
                 * day : 2
                 * hours : 10
                 * minutes : 40
                 * month : 6
                 * nanos : 0
                 * seconds : 45
                 * time : 1500950445000
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
}
