package NonUser;

public class ReadinessRecord {
    private String aircraftId;
    private String engineerId;
    private boolean ready;
    private String date;

    public ReadinessRecord(String aircraftId, String engineerId, boolean ready, String date) {
        this.aircraftId = aircraftId;
        this.engineerId = engineerId;
        this.ready = ready;
        this.date = date;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(String engineerId) {
        this.engineerId = engineerId;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReadinessRecord{" +
                "aircraftId='" + aircraftId + '\'' +
                ", engineerId='" + engineerId + '\'' +
                ", ready=" + ready +
                ", date='" + date + '\'' +
                '}';
    }
}
