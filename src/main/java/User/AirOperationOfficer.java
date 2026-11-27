package User;

import java.time.LocalDate;

public class AirOperationOfficer extends User {
    public AirOperationOfficer(String fullName, String email, String password, String mobileNo, String gender, String role, LocalDate dateOfBirth, int userId) {
        super(fullName, email, password, mobileNo, gender, "Air Operation Officer", dateOfBirth, userId);
    }
}
