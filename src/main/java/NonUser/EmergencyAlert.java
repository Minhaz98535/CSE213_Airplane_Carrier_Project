package NonUser;

import java.time.LocalDate;

public class EmergencyAlert {
    protected int alertId;
    protected String alertType, alertSeverity, alertDescription, actionTakenRequest;
    protected LocalDate alertDate;
    protected Boolean actionApproved;

    public EmergencyAlert(int alertId, String alertType, String alertSeverity, String alertDescription, String actionTakenRequest, LocalDate alertDate, Boolean actionApproved) {
        this.alertId = alertId;
        this.alertType = alertType;
        this.alertSeverity = alertSeverity;
        this.alertDescription = alertDescription;
        this.actionTakenRequest = actionTakenRequest;
        this.alertDate = alertDate;
        this.actionApproved = actionApproved;
    }

    public int getAlertId() {
        return alertId;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getAlertSeverity() {
        return alertSeverity;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

    public String getActionTakenRequest() {
        return actionTakenRequest;
    }

    public LocalDate getAlertDate() {
        return alertDate;
    }

    public Boolean getActionApproved() {
        return actionApproved;
    }

    public void setActionApproved(Boolean actionApproved) {
        this.actionApproved = actionApproved;
    }

    @Override
    public String toString() {
        return "EmergencyAlert{" +
                "alertId=" + alertId +
                ", alertType='" + alertType + '\'' +
                ", alertSeverity='" + alertSeverity + '\'' +
                ", alertDescription='" + alertDescription + '\'' +
                ", actionTakenRequest='" + actionTakenRequest + '\'' +
                ", alertDate=" + alertDate +
                ", actionApproved=" + actionApproved +
                '}';
    }

    public void updateActionApprovedStatus(int alertId, boolean newAction){

    }

}
