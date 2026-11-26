package User;

public class weatherinfo {
    // Fields
    private String location;
    private double temperature;
    private double windSpeed;
    private String condition;

    public weatherinfo(String location, double temperature, double windSpeed, String condition) {
        this.location = location;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "weatherinfo{" +
                "location='" + location + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", condition='" + condition + '\'' +
                '}';
    }
}
