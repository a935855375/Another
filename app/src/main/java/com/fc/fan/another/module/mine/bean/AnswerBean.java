package com.fc.fan.another.module.mine.bean;

import java.util.List;

/**
 * Created by fan on 7/31/17.
 * A nice day..
 */

public class AnswerBean {

    /**
     * limit : 4
     * list : [{"aid":33,"content":"å\u201cˆå\u201cˆå\u201cˆ","question":{"commentNumber":6,"content":"ã\u20ac\u201aã\u20ac\u201aã\u20ac\u201aã\u20ac\u201a","lookNumber":49,"qid":8,"style":2,"time":{"date":29,"day":6,"hours":15,"minutes":35,"month":6,"nanos":0,"seconds":43,"time":1501313743000,"timezoneOffset":-480,"year":117},"title":"233333"},"time":{"date":29,"day":6,"hours":15,"minutes":42,"month":6,"nanos":0,"seconds":23,"time":1501314143000,"timezoneOffset":-480,"year":117}},{"aid":34,"content":"GGG","question":{"commentNumber":6,"content":"ã\u20ac\u201aã\u20ac\u201aã\u20ac\u201aã\u20ac\u201a","lookNumber":49,"qid":8,"style":2,"time":{"date":29,"day":6,"hours":15,"minutes":35,"month":6,"nanos":0,"seconds":43,"time":1501313743000,"timezoneOffset":-480,"year":117},"title":"233333"},"time":{"date":29,"day":6,"hours":15,"minutes":42,"month":6,"nanos":0,"seconds":34,"time":1501314154000,"timezoneOffset":-480,"year":117}},{"aid":35,"content":"å\u201cˆå\u201cˆ","question":{"commentNumber":2,"content":"1111","lookNumber":12,"qid":7,"style":2,"time":{"date":29,"day":6,"hours":15,"minutes":28,"month":6,"nanos":0,"seconds":26,"time":1501313306000,"timezoneOffset":-480,"year":117},"title":"1111"},"time":{"date":30,"day":0,"hours":16,"minutes":17,"month":6,"nanos":0,"seconds":29,"time":1501402649000,"timezoneOffset":-480,"year":117}},{"aid":36,"content":"ã\u20ac\u201aã\u20ac\u201aã\u20ac\u201aã\u20ac\u201a","question":{"commentNumber":6,"content":"ã\u20ac\u201aã\u20ac\u201aã\u20ac\u201aã\u20ac\u201a","lookNumber":49,"qid":8,"style":2,"time":{"date":29,"day":6,"hours":15,"minutes":35,"month":6,"nanos":0,"seconds":43,"time":1501313743000,"timezoneOffset":-480,"year":117},"title":"233333"},"time":{"date":30,"day":0,"hours":16,"minutes":54,"month":6,"nanos":0,"seconds":58,"time":1501404898000,"timezoneOffset":-480,"year":117}}]
     * page : 1
     * totalCount : 10
     * totalPage : 3
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
         * aid : 33
         * content : å“ˆå“ˆå“ˆ
         * question : {"commentNumber":6,"content":"ã\u20ac\u201aã\u20ac\u201aã\u20ac\u201aã\u20ac\u201a","lookNumber":49,"qid":8,"style":2,"time":{"date":29,"day":6,"hours":15,"minutes":35,"month":6,"nanos":0,"seconds":43,"time":1501313743000,"timezoneOffset":-480,"year":117},"title":"233333"}
         * time : {"date":29,"day":6,"hours":15,"minutes":42,"month":6,"nanos":0,"seconds":23,"time":1501314143000,"timezoneOffset":-480,"year":117}
         */

        private int aid;
        private String content;
        private QuestionBean question;
        private TimeBeanX time;

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

        public QuestionBean getQuestion() {
            return question;
        }

        public void setQuestion(QuestionBean question) {
            this.question = question;
        }

        public TimeBeanX getTime() {
            return time;
        }

        public void setTime(TimeBeanX time) {
            this.time = time;
        }

        public static class QuestionBean {
            /**
             * commentNumber : 6
             * content : ã€‚ã€‚ã€‚ã€‚
             * lookNumber : 49
             * qid : 8
             * style : 2
             * time : {"date":29,"day":6,"hours":15,"minutes":35,"month":6,"nanos":0,"seconds":43,"time":1501313743000,"timezoneOffset":-480,"year":117}
             * title : 233333
             */

            private int commentNumber;
            private String content;
            private int lookNumber;
            private int qid;
            private int style;
            private TimeBean time;
            private String title;

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

            public static class TimeBean {
                /**
                 * date : 29
                 * day : 6
                 * hours : 15
                 * minutes : 35
                 * month : 6
                 * nanos : 0
                 * seconds : 43
                 * time : 1501313743000
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

        public static class TimeBeanX {
            /**
             * date : 29
             * day : 6
             * hours : 15
             * minutes : 42
             * month : 6
             * nanos : 0
             * seconds : 23
             * time : 1501314143000
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
