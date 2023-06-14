package io.ubivis.backendwilliam.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class RobotLogId implements Serializable {

    private Timestamp timestamp;

    private String software;

    private String message;

    public RobotLogId() {}

    public RobotLogId(Timestamp timestamp, String software, String message) {
        this.timestamp = timestamp;
        this.software = software;
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSoftware() {
        return software;
    }

    public void SetSoftware(String software) {
        this.software = software;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
