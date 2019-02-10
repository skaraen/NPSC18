package com.nitt.karaens.npsc18;

public class Event {

    String day,sno,heading,venue,startTime,endTime,desc,vcode;

    public Event() {
    }

    public Event(String day, String sno, String heading, String venue, String startTime, String endTime, String desc, String vcode) {
        this.day = day;
        this.sno = sno;
        this.heading = heading;
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.desc = desc;
        this.vcode = vcode;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
}
