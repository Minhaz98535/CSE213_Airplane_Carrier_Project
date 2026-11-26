package User;

public class FlightReport {
    private String reportId;
    private String departureTime;
    private String arrivalTime;
    private String observations;

    public FlightReport() {
    }

    public FlightReport(String reportId, String departureTime, String arrivalTime, String observations) {
        this.reportId = reportId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.observations = observations;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
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
}
