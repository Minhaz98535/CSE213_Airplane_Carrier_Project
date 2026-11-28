package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class Prescription implements Serializable {
    private String patientId;
    private String department;
    private LocalDate date;
    private String description;

    public Prescription(String patientId, String department, LocalDate date, String description) {
        this.patientId = patientId;
        this.department = department;
        this.date = date;
        this.description = description;
    }

    public String getPatientId() { return patientId; }
    public String getDepartment() { return department; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
}