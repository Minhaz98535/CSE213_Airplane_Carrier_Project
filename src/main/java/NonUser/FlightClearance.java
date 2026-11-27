
package NonUser;

public class FlightClearance {

    private String flightId;
    private String aircraftId;
    private String mission;
    private String time;
    private String status;

    public FlightClearance() {
    }

    public FlightClearance(String flightId, String aircraftId,
                           String mission, String time, String status) {
        this.flightId = flightId;
        this.aircraftId = aircraftId;
        this.mission = mission;
        this.time = time;
        this.status = status;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
