
package NonUser;

import java.time.LocalDate;

public class WeatherInfo {

    private String location;
    private LocalDate date;
    private double temperature;
    private double visibility;
    private double windSpeed;
    private String condition;
    private String windDirection;

    public WeatherInfo() {
    }

    public WeatherInfo(String location, LocalDate date,
                       double temperature, double visibility,
                       double windSpeed, String condition,
                       String windDirection) {

        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.condition = condition;
        this.windDirection = windDirection;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
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

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
