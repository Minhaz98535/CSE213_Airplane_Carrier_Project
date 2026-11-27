package NonUser;
import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport extends OperationalReport {
    private String incidentCategory;
    private String title;
    private String location;
    private LocalDate incidentDate;
    private ArrayList<String> involvedCrewIds;
    private ArrayList<String> involvedAircraftIds;
    private String involvedStationId;
    private String injuriesSummary;
    private String damagesSummary;
    private ArrayList<EvidenceAttachment> attachments;

    public IncidentReport() {
        super();
        this.involvedCrewIds = new ArrayList<String>();
        this.involvedAircraftIds = new ArrayList<String>();
        this.attachments = new ArrayList<EvidenceAttachment>();
    }

    public IncidentReport(String reportId, String createdBy, LocalDate reportDate,
                          String incidentCategory, String title, String location,
                          LocalDate incidentDate, String involvedStationId,
                          String injuriesSummary, String damagesSummary) {
        super(reportId, createdBy, reportDate, "Submitted", "");
        this.incidentCategory = incidentCategory;
        this.title = title;
        this.location = location;
        this.incidentDate = incidentDate;
        this.involvedStationId = involvedStationId;
        this.injuriesSummary = injuriesSummary;
        this.damagesSummary = damagesSummary;
        this.involvedCrewIds = new ArrayList<String>();
        this.involvedAircraftIds = new ArrayList<String>();
        this.attachments = new ArrayList<EvidenceAttachment>();
    }

    public void addInvolvedCrew(String crewId) {
        if (crewId != null && !involvedCrewIds.contains(crewId)) {
            involvedCrewIds.add(crewId);
        }
    }

    public void addInvolvedAircraft(String aircraftId) {
        if (aircraftId != null && !involvedAircraftIds.contains(aircraftId)) {
            involvedAircraftIds.add(aircraftId);
        }
    }

    public String generatePreviewSummary() {
        return "Incident Report [" + getReportId() + "]: " + title + " (" + incidentCategory
                + ") at " + location + " on " + incidentDate + " | Damages: " + damagesSummary;
    }

    public String getIncidentCategory() { return incidentCategory; }
    public void setIncidentCategory(String incidentCategory) { this.incidentCategory = incidentCategory; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getIncidentDate() { return incidentDate; }
    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }

    public ArrayList<String> getInvolvedCrewIds() { return involvedCrewIds; }
    public void setInvolvedCrewIds(ArrayList<String> involvedCrewIds) { this.involvedCrewIds = involvedCrewIds; }

    public ArrayList<String> getInvolvedAircraftIds() { return involvedAircraftIds; }
    public void setInvolvedAircraftIds(ArrayList<String> involvedAircraftIds) { this.involvedAircraftIds = involvedAircraftIds; }

    public String getInvolvedStationId() { return involvedStationId; }
    public void setInvolvedStationId(String involvedStationId) { this.involvedStationId = involvedStationId; }

    public String getInjuriesSummary() { return injuriesSummary; }
    public void setInjuriesSummary(String injuriesSummary) { this.injuriesSummary = injuriesSummary; }

    public String getDamagesSummary() { return damagesSummary; }
    public void setDamagesSummary(String damagesSummary) { this.damagesSummary = damagesSummary; }

    public ArrayList<EvidenceAttachment> getAttachments() { return attachments; }
    public void setAttachments(ArrayList<EvidenceAttachment> attachments) { this.attachments = attachments; }
}