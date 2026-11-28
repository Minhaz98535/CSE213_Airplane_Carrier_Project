package NonUser;

import java.time.LocalDate;

public class WeatherInfo {
    protected LocalDate date;
    protected String temperature, windDirection, condition;

    public WeatherInfo(LocalDate date, String temperature, String windDirection, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.condition = condition;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "date=" + date +
                ", temperature='" + temperature + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }

}
