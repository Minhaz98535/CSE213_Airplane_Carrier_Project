package NonUser;

import java.time.LocalDate;

public class StationAssignment {
    private String stationAssignmentId;
    private String stationId;
    private String crewMemberId;
    private String previousStationId;
    private LocalDate assignmentDate;
    private String shift;

    public StationAssignment() {
    }

    public StationAssignment(String stationAssignmentId, String stationId, String crewMemberId,
                             String previousStationId, LocalDate assignmentDate, String shift) {
        this.stationAssignmentId = stationAssignmentId;
        this.stationId = stationId;
        this.crewMemberId = crewMemberId;
        this.previousStationId = previousStationId;
        this.assignmentDate = assignmentDate;
        this.shift = shift;
    }

    public boolean isReassignment() {
        return previousStationId != null && !previousStationId.isEmpty();
    }

    public String generateTransferSummary() {
        if (isReassignment()) {
            return "Crew " + crewMemberId + " transferred from Station " + previousStationId
                    + " to Station " + stationId + " on " + assignmentDate;
        }
        return "Crew " + crewMemberId + " assigned to Station " + stationId + " on " + assignmentDate;
    }

    public String getStationAssignmentId() { return stationAssignmentId; }
    public void setStationAssignmentId(String stationAssignmentId) { this.stationAssignmentId = stationAssignmentId; }

    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }

    public String getCrewMemberId() { return crewMemberId; }
    public void setCrewMemberId(String crewMemberId) { this.crewMemberId = crewMemberId; }

    public String getPreviousStationId() { return previousStationId; }
    public void setPreviousStationId(String previousStationId) { this.previousStationId = previousStationId; }

    public LocalDate getAssignmentDate() { return assignmentDate; }
    public void setAssignmentDate(LocalDate assignmentDate) { this.assignmentDate = assignmentDate; }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}
