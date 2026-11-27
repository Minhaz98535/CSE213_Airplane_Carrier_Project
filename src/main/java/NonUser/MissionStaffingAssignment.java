package NonUser;

import java.time.LocalDate;

public class MissionStaffingAssignment {
    private String assignmentId;
    private String missionId;
    private String crewMemberId;
    private String assignedRole;
    private LocalDate assignedDate;

    public MissionStaffingAssignment() {
    }

    public MissionStaffingAssignment(String assignmentId, String missionId, String crewMemberId,
                                     String assignedRole, LocalDate assignedDate) {
        this.assignmentId = assignmentId;
        this.missionId = missionId;
        this.crewMemberId = crewMemberId;
        this.assignedRole = assignedRole;
        this.assignedDate = assignedDate;
    }

    public boolean checkSchedulingConflict(String targetCrewId, Mission targetMission) {
        if (this.crewMemberId != null && this.crewMemberId.equals(targetCrewId)) {
            if (targetMission != null && targetMission.getMissionId().equals(this.missionId)) {
                return true;
            }
        }
        return false;
    }

    public boolean calculateRemovalUnderstaffingImpact(DeckStation currentStation) {
        if (currentStation == null) {
            return false;
        }
        int currentCount = currentStation.getAssignedCrew().size();
        int remainingAfterRemoval = currentCount - 1;
        return remainingAfterRemoval < currentStation.getRequiredPersonnelCount();
    }

    public String logActivityEntry() {
        return "Activity Log [" + assignedDate + "]: Crew " + crewMemberId
                + " assigned to Mission " + missionId + " as " + assignedRole;
    }

    public String getAssignmentId() { return assignmentId; }
    public void setAssignmentId(String assignmentId) { this.assignmentId = assignmentId; }

    public String getMissionId() { return missionId; }
    public void setMissionId(String missionId) { this.missionId = missionId; }

    public String getCrewMemberId() { return crewMemberId; }
    public void setCrewMemberId(String crewMemberId) { this.crewMemberId = crewMemberId; }

    public String getAssignedRole() { return assignedRole; }
    public void setAssignedRole(String assignedRole) { this.assignedRole = assignedRole; }

    public LocalDate getAssignedDate() { return assignedDate; }
    public void setAssignedDate(LocalDate assignedDate) { this.assignedDate = assignedDate; }
}