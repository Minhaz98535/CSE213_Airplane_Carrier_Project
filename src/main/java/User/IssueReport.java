package User;

public class IssueReport {
    private String issueId;
    private String category;
    private String severity;
    private String description;

    public IssueReport() {
    }

    public IssueReport(String issueId, String category, String severity, String description) {
        this.issueId = issueId;
        this.category = category;
        this.severity = severity;
        this.description = description;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
