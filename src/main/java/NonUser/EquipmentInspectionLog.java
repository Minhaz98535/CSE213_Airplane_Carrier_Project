package NonUser;

import java.time.LocalDate;

public class EquipmentInspectionLog {
    private String logId;
    private String equipmentId;
    private String inspectedBy;
    private LocalDate inspectionDate;
    private String findings;
    private String resultStatus;

    public EquipmentInspectionLog() {
    }

    public EquipmentInspectionLog(String logId, String equipmentId, String inspectedBy,
                                  LocalDate inspectionDate, String findings, String resultStatus) {
        this.logId = logId;
        this.equipmentId = equipmentId;
        this.inspectedBy = inspectedBy;
        this.inspectionDate = inspectionDate;
        this.findings = findings;
        this.resultStatus = resultStatus;
    }

    public boolean requiresMaintenanceAlert() {
        return "Failed".equalsIgnoreCase(resultStatus) || "Damaged".equalsIgnoreCase(resultStatus);
    }

    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }

    public String getInspectedBy() { return inspectedBy; }
    public void setInspectedBy(String inspectedBy) { this.inspectedBy = inspectedBy; }

    public LocalDate getInspectionDate() { return inspectionDate; }
    public void setInspectionDate(LocalDate inspectionDate) { this.inspectionDate = inspectionDate; }

    public String getFindings() { return findings; }
    public void setFindings(String findings) { this.findings = findings; }

    public String getResultStatus() { return resultStatus; }
    public void setResultStatus(String resultStatus) { this.resultStatus = resultStatus; }
}