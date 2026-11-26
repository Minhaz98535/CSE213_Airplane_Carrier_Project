package User;

public class cheaklistiteam {
    private String itemName;
    private String status;
    private boolean required;

    public cheaklistiteam(String itemName, String status, boolean required) {
        this.itemName = itemName;
        this.status = status;
        this.required = required;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
