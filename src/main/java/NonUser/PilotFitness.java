package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class PilotFitness implements Serializable {
    private String pilotId;
    private String heartRate;
    private String bloodPressure;
    private String examStatus;
    private LocalDate examDate;
    private String description;

    public PilotFitness(String pilotId, String heartRate, String bloodPressure, String examStatus, LocalDate examDate, String description) {
        this.pilotId = pilotId;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.examStatus = examStatus;
        this.examDate = examDate;
        this.description = description;
    }

    public String getPilotId() { return pilotId; }
    public String getHeartRate() { return heartRate; }
    public String getBloodPressure() { return bloodPressure; }
    public String getExamStatus() { return examStatus; }
    public LocalDate getExamDate() { return examDate; }
    public String getDescription() { return description; }
}