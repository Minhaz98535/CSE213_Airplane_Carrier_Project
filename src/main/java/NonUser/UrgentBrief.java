package NonUser;

import java.time.LocalDate;
import java.util.ArrayList;

public class UrgentBrief extends CommunicationMessage {
    private String briefId;
    private String briefCategory;
    private String urgencyLevel;
    private String deliveryStatus;
    private LocalDate sentDate;

    public UrgentBrief() {
        super();
    }

    public UrgentBrief(String messageId, String senderId, String senderRole,
                       ArrayList<String> recipientIds, String subject, String body,
                       String briefId, String briefCategory, String urgencyLevel,
                       LocalDate sentDate) {
        super(messageId, senderId, senderRole, recipientIds, subject, body, "Urgent", sentDate, false);
        this.briefId = briefId;
        this.briefCategory = briefCategory;
        this.urgencyLevel = urgencyLevel;
        this.deliveryStatus = "Draft";
        this.sentDate = sentDate;
    }

    public void loadCategoryTemplate(String category) {
        this.briefCategory = category;
        if (category.equalsIgnoreCase("Flight Deck Emergency")) {
            setSubject("URGENT: Flight Deck Emergency Alert");
            setBody("Immediate deck intervention required. Check station status.");
        } else if (category.equalsIgnoreCase("Equipment Hazard")) {
            setSubject("URGENT: Deck Equipment Hazard");
            setBody("Critical gear or weapon hazard reported on deck.");
        } else {
            setSubject("URGENT: Operational Brief");
            setBody("Priority operational update for supervisor review.");
        }
    }

    public void pushPopupToOnlineSupervisors(ArrayList<String> onlineSupervisorIds) {
        if (onlineSupervisorIds != null && !onlineSupervisorIds.isEmpty()) {
            this.deliveryStatus = "Sent";
            prioritizeInQueue();
            dispatchNotification();
        } else {
            this.deliveryStatus = "Queued";
        }
    }

    public String getBriefId() { return briefId; }
    public void setBriefId(String briefId) { this.briefId = briefId; }

    public String getBriefCategory() { return briefCategory; }
    public void setBriefCategory(String briefCategory) { this.briefCategory = briefCategory; }

    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    public LocalDate getSentDate() { return sentDate; }
    public void setSentDate(LocalDate sentDate) { this.sentDate = sentDate; }
}