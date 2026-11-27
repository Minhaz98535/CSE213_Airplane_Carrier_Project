package NonUser;

public class FlightReport {
    private String reportId;
    private String departureTime;
    private String arrivalTime;
    private String observations;

    public FlightReport(String arrivalTime, String departureTime, String observations, String reportId) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.observations = observations;
        this.reportId = reportId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
}
