package NonUser;

import java.io.Serializable;

public class Aircraft implements Serializable {
    protected int aircraftId;
    protected String aircraftName, aircraftType, aircraftStatus;

    public Aircraft(int aircraftId, String aircraftName, String aircraftType, String aircraftStatus) {
        this.aircraftId = aircraftId;
        this.aircraftName = aircraftName;
        this.aircraftType = aircraftType;
        this.aircraftStatus = aircraftStatus;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getAircraftStatus() {
        return aircraftStatus;
    }

    public void setAircraftStatus(String aircraftStatus) {
        this.aircraftStatus = aircraftStatus;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftId=" + aircraftId +
                ", aircraftName='" + aircraftName + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", aircraftStatus='" + aircraftStatus + '\'' +
                '}';
    }

    public void updateAircraftStatus(String newStatus){

    }

}
