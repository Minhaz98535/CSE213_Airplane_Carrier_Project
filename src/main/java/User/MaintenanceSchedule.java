package User;

public class MaintenanceSchedule {
    private String scheduleId;
    private String type;
    private String date;
    private String time;

    public MaintenanceSchedule() {
    }

    public MaintenanceSchedule(String scheduleId, String type, String date, String time) {
        this.scheduleId = scheduleId;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
