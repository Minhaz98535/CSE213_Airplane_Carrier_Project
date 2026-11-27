package NonUser;

import java.util.ArrayList;

public class DeckStation {
    private String stationId;
    private String stationName;
    private String location;
    private int requiredPersonnelCount;
    private String currentShift;
    private String staffingStatus;
    private ArrayList<CrewMember> assignedCrew;
    private ArrayList<WeaponGearItem> stationGear;

    public DeckStation() {
        this.assignedCrew = new ArrayList<CrewMember>();
        this.stationGear = new ArrayList<WeaponGearItem>();
    }

    public DeckStation(String stationId, String stationName, String location,
                       int requiredPersonnelCount, String currentShift) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.location = location;
        this.requiredPersonnelCount = requiredPersonnelCount;
        this.currentShift = currentShift;
        this.assignedCrew = new ArrayList<CrewMember>();
        this.stationGear = new ArrayList<WeaponGearItem>();
        recalculateStaffingStatus();
    }

    public String recalculateStaffingStatus() {
        int count = assignedCrew.size();
        if (count < requiredPersonnelCount) {
            this.staffingStatus = "Understaffed";
        } else if (count == requiredPersonnelCount) {
            this.staffingStatus = "Fully Staffed";
        } else {
            this.staffingStatus = "Overstaffed";
        }
        return this.staffingStatus;
    }

    public boolean evaluateTransferImpact(String crewId) {
        int countAfterRemoval = assignedCrew.size() - 1;
        return countAfterRemoval < requiredPersonnelCount;
    }

    public boolean transferPersonnel(String crewId, DeckStation targetStation) {
        CrewMember memberToMove = null;
        for (int i = 0; i < assignedCrew.size(); i++) {
            CrewMember current = assignedCrew.get(i);
            if (current.getCrewId().equals(crewId)) {
                memberToMove = current;
                assignedCrew.remove(i);
                break;
            }
        }
        if (memberToMove != null && targetStation != null) {
            targetStation.getAssignedCrew().add(memberToMove);
            this.recalculateStaffingStatus();
            targetStation.recalculateStaffingStatus();
            return true;
        }
        return false;
    }

    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getRequiredPersonnelCount() { return requiredPersonnelCount; }
    public void setRequiredPersonnelCount(int requiredPersonnelCount) { this.requiredPersonnelCount = requiredPersonnelCount; }

    public String getCurrentShift() { return currentShift; }
    public void setCurrentShift(String currentShift) { this.currentShift = currentShift; }

    public String getStaffingStatus() { return staffingStatus; }
    public void setStaffingStatus(String staffingStatus) { this.staffingStatus = staffingStatus; }

    public ArrayList<CrewMember> getAssignedCrew() { return assignedCrew; }
    public void setAssignedCrew(ArrayList<CrewMember> assignedCrew) { this.assignedCrew = assignedCrew; }

    public ArrayList<WeaponGearItem> getStationGear() { return stationGear; }
    public void setStationGear(ArrayList<WeaponGearItem> stationGear) { this.stationGear = stationGear; }
}
