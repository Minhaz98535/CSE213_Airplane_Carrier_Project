
package NonUser;

public class Aircraftinspection {

    // Attributes
    private String aircraftId;
    private String inspectionDate;
    private String fuelSystem;
    private String wings;
    private String engine;
    private String landingGear;
    private String safety;
    private String remarks;

    public Aircraftinspection(String aircraftId, String inspectionDate, String fuelSystem, String wings, String engine, String landingGear, String safety, String remarks) {
        this.aircraftId = aircraftId;
        this.inspectionDate = inspectionDate;
        this.fuelSystem = fuelSystem;
        this.wings = wings;
        this.engine = engine;
        this.landingGear = landingGear;
        this.safety = safety;
        this.remarks = remarks;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem) {
        this.fuelSystem = fuelSystem;
    }

    public String getWings() {
        return wings;
    }

    public void setWings(String wings) {
        this.wings = wings;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getLandingGear() {
        return landingGear;
    }

    public void setLandingGear(String landingGear) {
        this.landingGear = landingGear;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Aircraftinspection{" +
                "aircraftId='" + aircraftId + '\'' +
                ", inspectionDate='" + inspectionDate + '\'' +
                ", fuelSystem='" + fuelSystem + '\'' +
                ", wings='" + wings + '\'' +
                ", engine='" + engine + '\'' +
                ", landingGear='" + landingGear + '\'' +
                ", safety='" + safety + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
