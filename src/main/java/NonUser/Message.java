package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class Message implements Serializable {
    private String sender;
    private String messageContent;
    private String urgencyLevel;
    private String deliveryStatus;
    private LocalDate sentDate;

    public Message(String sender, String messageContent, String urgencyLevel, String deliveryStatus, LocalDate sentDate) {
        this.sender= sender;
        this.messageContent = messageContent;
        this.urgencyLevel = urgencyLevel;
        this.deliveryStatus = deliveryStatus;
        this.sentDate = sentDate;
    }

    public String getSender() {
        return sender;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }
}

