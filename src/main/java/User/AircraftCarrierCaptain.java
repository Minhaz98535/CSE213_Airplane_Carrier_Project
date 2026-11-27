package User;

import java.time.LocalDate;

public class AircraftCarrierCaptain extends User{

    public AircraftCarrierCaptain(String fullName, String email, String password, String mobileNo, String gender, String role, LocalDate dateOfBirth, int userId) {
        super(fullName, email, password, mobileNo, gender, "Aircraft Carrier Captain", dateOfBirth, userId);
    }
}
