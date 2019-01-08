package pers.ccdongyu.neo4jbackend.message;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Calendar;

public class StatusWithTime {
    private int status;
    private String message;
    private String time;
    private Object data;

    private StatusWithTime(int status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = Long.toString(Calendar.getInstance().getTimeInMillis());
    }


    public static StatusWithTime getSucceedInstance() {
        return new StatusWithTime(200, "", null);
    }

    public static StatusWithTime getFailedInstance(String message) {
        return new StatusWithTime(405, message, null);
    }

    public static StatusWithTime getInstanceWithTime(int status, String message, Object data){
        return new StatusWithTime(status, message, data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
