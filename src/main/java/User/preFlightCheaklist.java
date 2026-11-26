package User;

public class preFlightCheaklist {

    private String checklistId;
    private boolean completed;
    private String remarks;

    public preFlightCheaklist(String checklistId, boolean completed, String remarks) {
        this.checklistId = checklistId;
        this.completed = completed;
        this.remarks = remarks;
    }

    public String getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
