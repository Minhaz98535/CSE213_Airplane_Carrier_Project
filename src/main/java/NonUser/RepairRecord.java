
package NonUser;

public class RepairRecord {

    // Attributes
    private String recordId;
    private String aircraftId;
    private String date;
    private String type;
    private String status;

    // Constructor
    public RepairRecord(
            String recordId,
            String aircraftId,
            String date,
            String type,
            String status) {

        this.recordId = recordId;
        this.aircraftId = aircraftId;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    // Getters
    public String getRecordId() {
        return recordId;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    // toString
    @Override
    public String toString() {
        return "RepairRecord{" +
                "recordId='" + recordId + '\'' +
                ", aircraftId='" + aircraftId + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
