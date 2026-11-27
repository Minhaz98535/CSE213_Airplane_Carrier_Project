package NonUser;

public class Flight {

    private String flightId;
    private String destination;
    private String date;
    private String launchTime;
    private String status;

    public Flight(String flightId, String date, String destination, String launchTime, String status) {
        this.flightId = flightId;
        this.date = date;
        this.destination = destination;
        this.launchTime = launchTime;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
