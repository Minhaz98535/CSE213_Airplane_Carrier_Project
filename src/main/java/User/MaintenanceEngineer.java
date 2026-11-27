
package User;

public class MaintenanceEngineer {

    private String employeeId;
    private String specialization;


    public MaintenanceEngineer() {
    }


    public MaintenanceEngineer(String employeeId, String specialization) {
        this.employeeId = employeeId;
        this.specialization = specialization;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getSpecialization() {
        return specialization;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @Override
    public String toString() {
        return "MaintenanceEngineer{" +
                "employeeId='" + employeeId + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
