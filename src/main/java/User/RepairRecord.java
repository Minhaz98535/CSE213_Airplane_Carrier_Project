package User;

public class RepairRecord {
    private String repairId;
    private String partsUsed;
    private String workDone;
    private boolean completed;

    public RepairRecord(String repairId, String partsUsed, String workDone, boolean completed) {
        this.repairId = repairId;
        this.partsUsed = partsUsed;
        this.workDone = workDone;
        this.completed = completed;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getPartsUsed() {
        return partsUsed;
    }

    public void setPartsUsed(String partsUsed) {
        this.partsUsed = partsUsed;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
