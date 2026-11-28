package NonUser;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport implements Serializable {
    protected int reportId;
    protected LocalDate reportDate;
    protected String reportType, incidentLocation, damageSeverity, detailsReport, reportStatus;

    public IncidentReport(int reportId, LocalDate reportDate, String reportType, String incidentLocation, String damageSeverity, String detailsReport, String reportStatus) {
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.reportType = reportType;
        this.incidentLocation = incidentLocation;
        this.damageSeverity = damageSeverity;
        this.detailsReport = detailsReport;
        this.reportStatus = reportStatus;
    }

    public int getReportId() {
        return reportId;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public String getReportType() {
        return reportType;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public String getDamageSeverity() {
        return damageSeverity;
    }

    public String getDetailsReport() {
        return detailsReport;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Override
    public String toString() {
        return "IncidentReport{" +
                "reportId=" + reportId +
                ", reportDate=" + reportDate +
                ", reportType='" + reportType + '\'' +
                ", incidentLocation='" + incidentLocation + '\'' +
                ", damageSeverity='" + damageSeverity + '\'' +
                ", detailsReport='" + detailsReport + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                '}';
    }

    public void updateReportStatus(int reportId, String newReportStatus){

    }

}