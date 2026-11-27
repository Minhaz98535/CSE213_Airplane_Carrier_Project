
package NonUser;

public class IssueReport {

    private String aircraftId;
    private String severity;
    private String category;
    private String problem;
    private String observation;

    public IssueReport() {
    }

    public IssueReport(String aircraftId, String severity,
                       String category, String problem,
                       String observation) {

        this.aircraftId = aircraftId;
        this.severity = severity;
        this.category = category;
        this.problem = problem;
        this.observation = observation;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "IssueReport{" +
                "aircraftId='" + aircraftId + '\'' +
                ", severity='" + severity + '\'' +
                ", category='" + category + '\'' +
                ", problem='" + problem + '\'' +
                ", observation='" + observation + '\'' +
                '}';
    }
}
