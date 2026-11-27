package NonUser;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeaponGearItem {
    private String equipmentId;
    private String itemName;
    private String stationId;
    private String assignedCrewId;
    private String availabilityStatus;
    private String maintenanceStatus;
    private LocalDate lastInspectionDate;
    private LocalDate nextInspectionDueDate;
    private ArrayList<EquipmentInspectionLog> inspectionLogs;

    public WeaponGearItem() {
        this.inspectionLogs = new ArrayList<EquipmentInspectionLog>();
    }

    public WeaponGearItem(String equipmentId, String itemName, String stationId,
                          String assignedCrewId, String availabilityStatus,
                          String maintenanceStatus, LocalDate lastInspectionDate,
                          LocalDate nextInspectionDueDate) {
        this.equipmentId = equipmentId;
        this.itemName = itemName;
        this.stationId = stationId;
        this.assignedCrewId = assignedCrewId;
        this.availabilityStatus = availabilityStatus;
        this.maintenanceStatus = maintenanceStatus;
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDueDate = nextInspectionDueDate;
        this.inspectionLogs = new ArrayList<EquipmentInspectionLog>();
    }

    public boolean checkOverdueInspection(LocalDate currentDate) {
        if (nextInspectionDueDate != null && currentDate.isAfter(nextInspectionDueDate)) {
            return true;
        }
        return false;
    }

    public void reportEquipmentIssue(String logId, String officerId, String details, LocalDate reportDate) {
        this.availabilityStatus = "Unavailable";
        this.maintenanceStatus = "Maintenance Required";
        EquipmentInspectionLog log = new EquipmentInspectionLog(
                logId, this.equipmentId, officerId, reportDate, details, "Failed"
        );
        this.inspectionLogs.add(log);
    }

    public void updateEquipmentStatus(String newAvailability, String newMaintenanceStatus) {
        this.availabilityStatus = newAvailability;
        this.maintenanceStatus = newMaintenanceStatus;
    }

    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }

    public String getAssignedCrewId() { return assignedCrewId; }
    public void setAssignedCrewId(String assignedCrewId) { this.assignedCrewId = assignedCrewId; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }

    public String getMaintenanceStatus() { return maintenanceStatus; }
    public void setMaintenanceStatus(String maintenanceStatus) { this.maintenanceStatus = maintenanceStatus; }

    public LocalDate getLastInspectionDate() { return lastInspectionDate; }
    public void setLastInspectionDate(LocalDate lastInspectionDate) { this.lastInspectionDate = lastInspectionDate; }

    public LocalDate getNextInspectionDueDate() { return nextInspectionDueDate; }
    public void setNextInspectionDueDate(LocalDate nextInspectionDueDate) { this.nextInspectionDueDate = nextInspectionDueDate; }

    public ArrayList<EquipmentInspectionLog> getInspectionLogs() { return inspectionLogs; }
    public void setInspectionLogs(ArrayList<EquipmentInspectionLog> inspectionLogs) { this.inspectionLogs = inspectionLogs; }
}
