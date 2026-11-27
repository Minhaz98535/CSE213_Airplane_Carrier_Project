package User;

public class pilot {
    private String licenseNo;
    private String assignedAircraftId;

    public pilot(String licenseNo, String assignedAircraftId) {
        this.licenseNo = licenseNo;
        this.assignedAircraftId = assignedAircraftId;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAssignedAircraftId() {
        return assignedAircraftId;
    }

    public void setAssignedAircraftId(String assignedAircraftId) {
        this.assignedAircraftId = assignedAircraftId;
    }
}
