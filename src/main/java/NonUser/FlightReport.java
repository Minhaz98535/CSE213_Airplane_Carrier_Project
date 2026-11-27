
package NonUser;

public class FlightReport {

    private String flightId;
    private String departureTime;
    private String arrivalTime;
    private String observations;
    private String additionalRemarks;

    public FlightReport() {
    }

    public FlightReport(String flightId, String departureTime,
                        String arrivalTime, String observations,
                        String additionalRemarks) {

        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.observations = observations;
        this.additionalRemarks = additionalRemarks;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }
}
