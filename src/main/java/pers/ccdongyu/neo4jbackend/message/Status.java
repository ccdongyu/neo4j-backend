package pers.ccdongyu.neo4jbackend.message;

public class Status {

    private int status;
    private String message;
    private Object data;

    private Status(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Status getSucceedInstance() {
        return new Status(200, "", null);
    }

    public static Status getFailedInstance(String message) {
        return new Status(405, message, null);
    }

    public static Status getInstance(int status, String message, Object data) {
        return new Status(status, message, data);
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

}
