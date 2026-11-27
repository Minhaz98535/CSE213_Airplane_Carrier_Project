package NonUser;

import java.time.LocalDate;

public class ReadinessApproval {
    private String approvalId;
    private String aircraftId;
    private String readinessRecordId;
    private String approvedBy;
    private boolean isReady;
    private LocalDate approvedDate;

    public ReadinessApproval() {
    }

    public ReadinessApproval(String approvalId, String aircraftId, String readinessRecordId,
                             String approvedBy, LocalDate approvedDate) {
        this.approvalId = approvalId;
        this.aircraftId = aircraftId;
        this.readinessRecordId = readinessRecordId;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.isReady = false;
    }

    public boolean verifyOfficerApprovalPermission(String userRole) {
        return "Flight Deck Officer".equalsIgnoreCase(userRole);
    }

    public boolean confirmAircraftReady(AircraftReadinessRecord readinessRecord,
                                        MaintenancePreFlightChecklist maintenanceChecklist) {
        if (readinessRecord == null || maintenanceChecklist == null) {
            this.isReady = false;
            return false;
        }
        if (readinessRecord.isEligibleForFlight() && maintenanceChecklist.isComplete()) {
            this.isReady = true;
            return true;
        }
        this.isReady = false;
        return false;
    }

    public String getApprovalId() { return approvalId; }
    public void setApprovalId(String approvalId) { this.approvalId = approvalId; }

    public String getAircraftId() { return aircraftId; }
    public void setAircraftId(String aircraftId) { this.aircraftId = aircraftId; }

    public String getReadinessRecordId() { return readinessRecordId; }
    public void setReadinessRecordId(String readinessRecordId) { this.readinessRecordId = readinessRecordId; }

    public String getApprovedBy() { return approvedBy; }
    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }

    public boolean isReady() { return isReady; }
    public void setReady(boolean ready) { isReady = ready; }

    public LocalDate getApprovedDate() { return approvedDate; }
    public void setApprovedDate(LocalDate approvedDate) { this.approvedDate = approvedDate; }
}
