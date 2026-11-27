package User;

public class Aircraft {
    private String aircraftId;
    private String model;
    private String status;
    private String maintenanceStatus;

    public Aircraft(String aircraftId, String model, String status, String maintenanceStatus) {
        this.aircraftId = aircraftId;
        this.model = model;
        this.status = status;
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public String getModel() {
        return model;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getStatus() {
        return status;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftId='" + aircraftId + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                ", maintenanceStatus='" + maintenanceStatus + '\'' +
                '}';
    }
}
