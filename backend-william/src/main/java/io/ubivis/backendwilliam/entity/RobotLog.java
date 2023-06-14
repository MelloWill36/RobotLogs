package io.ubivis.backendwilliam.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(RobotLogId.class)
public class RobotLog {

    @Column
    private int robot_id;

    @Column
    private int production_line_id;

    @Column
    private int machine_id;

    @Id
    @Column
    private Timestamp timestamp;

    @Id
    @Column
    private String software;

    @Column
    private String severity;

    @Id
    @Column
    private String message;

    public RobotLog() {
    }

    public RobotLog(int robot_id, int production_line_id, int machine_id, Timestamp timestamp, String software, String severity, String message) {
        this.robot_id = robot_id;
        this.production_line_id = production_line_id;
        this.machine_id = machine_id;
        this.timestamp = timestamp;
        this.software = software;
        this.severity = severity;
        this.message = message;
    }


    public int getRobot_id() {
        return robot_id;
    }

    public void setRobot_id(int robot_id) {
        this.robot_id = robot_id;
    }

    public int getProduction_line_id() {
        return production_line_id;
    }

    public void setProduction_line_id(int production_line_id) {
        this.production_line_id = production_line_id;
    }

    public int getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
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

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


