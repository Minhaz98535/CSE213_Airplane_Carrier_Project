package User;

import java.time.LocalDate;

public class Pilot extends User {
    private String licenseNo;
    private String assignedAircraftId;

    public Pilot(String fullName, String email, String password, String mobileNo, String gender, String role, LocalDate dateOfBirth, int userId, String licenseNo, String assignedAircraftId) {
        super(fullName, email, password, mobileNo, gender, role, dateOfBirth, userId);
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
