package User;

import java.util.ArrayList;

public class inspectionRecord {
    private String inspectionId;
    private String date;
    private boolean passed;

    public inspectionRecord(String inspectionId, String date, boolean passed) {
        this.inspectionId = inspectionId;
        this.date = date;
        this.passed = passed;
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
