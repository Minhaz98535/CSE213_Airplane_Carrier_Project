package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientCase implements Serializable {
    private String name;
    private String id;
    private String department;
    private String disease;
    private String status;
    private boolean isolation;
    private LocalDate date;
    private String description;

    public PatientCase(String name, String id, String department, String disease, String status, boolean isolation, LocalDate date, String description) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.disease = disease;
        this.status = status;
        this.isolation = isolation;
        this.date = date;
        this.description = description;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getDepartment() { return department; }
    public String getDisease() { return disease; }
    public String getStatus() { return status; }
    public boolean isIsolation() { return isolation; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
}