
package NonUser;

public class preFlightChecklist {

    private boolean fuelLevelChecked;
    private boolean landingGearChecked;
    private boolean engineChecked;
    private boolean communicationSystemChecked;

    public preFlightChecklist() {
    }

    public preFlightChecklist(boolean fuelLevelChecked,
                              boolean landingGearChecked,
                              boolean engineChecked,
                              boolean communicationSystemChecked) {

        this.fuelLevelChecked = fuelLevelChecked;
        this.landingGearChecked = landingGearChecked;
        this.engineChecked = engineChecked;
        this.communicationSystemChecked = communicationSystemChecked;
    }

    public boolean isFuelLevelChecked() {
        return fuelLevelChecked;
    }

    public void setFuelLevelChecked(boolean fuelLevelChecked) {
        this.fuelLevelChecked = fuelLevelChecked;
    }

    public boolean isLandingGearChecked() {
        return landingGearChecked;
    }

    public void setLandingGearChecked(boolean landingGearChecked) {
        this.landingGearChecked = landingGearChecked;
    }

    public boolean isEngineChecked() {
        return engineChecked;
    }

    public void setEngineChecked(boolean engineChecked) {
        this.engineChecked = engineChecked;
    }

    public boolean isCommunicationSystemChecked() {
        return communicationSystemChecked;
    }

    public void setCommunicationSystemChecked(
            boolean communicationSystemChecked) {
        this.communicationSystemChecked = communicationSystemChecked;
    }

    @Override
    public String toString() {
        return "PreFlightChecklist{" +
                "fuelLevelChecked=" + fuelLevelChecked +
                ", landingGearChecked=" + landingGearChecked +
                ", engineChecked=" + engineChecked +
                ", communicationSystemChecked=" + communicationSystemChecked +
                '}';
    }
}
