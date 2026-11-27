package User;

public class pilot {
    private String pilotId;
    private String name;
    private String email;
    private String phone;
    private String licenseNo;
    private String assignedAircraftId;
    private String password;

    public pilot(String assignedAircraftId, String email, String licenseNo, String name, String password, String phone, String pilotId) {
        this.assignedAircraftId = assignedAircraftId;
        this.email = email;
        this.licenseNo = licenseNo;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.pilotId = pilotId;
    }

    public String getAssignedAircraftId() {
        return assignedAircraftId;
    }

    public void setAssignedAircraftId(String assignedAircraftId) {
        this.assignedAircraftId = assignedAircraftId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }
}
