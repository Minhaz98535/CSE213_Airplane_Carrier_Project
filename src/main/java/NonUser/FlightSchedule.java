package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class FlightSchedule implements Serializable {
    protected final String missionName;
    protected int flightId;
    protected String flightTime, flightStatus;
    protected LocalDate flightDate;
    protected Boolean isApproved, isPending;

    public FlightSchedule(Mission mission, int flightId, String flightTime, String flightStatus, LocalDate flightDate, Boolean isApproved, Boolean isPending) {
        this.missionName = mission.getMissionName();
        this.flightId = flightId;
        this.flightTime = flightTime;
        this.flightStatus = flightStatus;
        this.flightDate = flightDate;
        this.isApproved = isApproved;
        this.isPending = isPending;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "flightId=" + flightId +
                ", flightTime='" + flightTime + '\'' +
                ", flightStatus='" + flightStatus + '\'' +
                ", flightDate=" + flightDate +
                ", isApproved=" + isApproved +
                ", isPending=" + isPending +
                '}';
    }

    public void updateApprovedStatus(int flightId, boolean newApprovedStatus){

    }

    public void updateFlightStatus(int flightId, boolean newFlightStatus){

    }

    public void updatePendingStatus(int flightId, boolean newPendingStatus){

    }
}
