package pv260.solid.dip.tweaked.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.*;
import static javax.xml.bind.annotation.XmlAccessType.NONE;

@XmlRootElement(name = "weatherdata")
@XmlAccessorType(NONE)
public class OpenWeatherMapResponse implements ForecastResponse {

    @XmlElement
    private Location location;

    @XmlElement(name = "time")
    @XmlElementWrapper(name = "forecast")
    private List<ForecastTime> times;

    public Location getLocation() {
        return location;
    }

    public List<ForecastTime> getTimes() {
        return times;
    }

    @Override
    public double getAvgTemperature(LocalDate date) throws IOException {
        for (ForecastTime record: getTimes()) {
            if (date.equals(LocalDate.parse(record.getDay(), DateTimeFormatter.ISO_DATE))) {
                Temperature dailyTemp = record.getTemperature();
                return (dailyTemp.getDay() + dailyTemp.getMorn() + dailyTemp.getEve()) / 3;
            }
        }
        throw new IOException("no forecast for that day");
    }

    @Override
    public double getMiddayTemperature(LocalDate date) throws IOException {
        for (ForecastTime record: getTimes()) {
            if (date.equals(LocalDate.parse(record.getDay(), DateTimeFormatter.ISO_DATE))) {
                Temperature dailyTemp = record.getTemperature();
                return dailyTemp.getDay();
            }
        }
        throw new IOException("no forecast for that day");
    }

    @Override
    public String toString() {
        return "OpenWeatherMapResponse{" + "location=" + location + ", times=" + times + '}';
    }

    @XmlType
    public static class Location{
        @XmlElement
        private String name;
        @XmlElement
        private String country;

        @Override
        public String toString() {
            return "Location{" + "name=" + name + ", country=" + country + '}';
        }
    }

    @XmlType
    public static class ForecastTime {

        @XmlAttribute
        private String day;

        @XmlElement
        private Temperature temperature;

        public String getDay() {
            return day;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        @Override
        public String toString() {
            return "ForecastTime{" + "day=" + day + ", temperature=" + temperature + '}';
        }
    }

    @XmlType
    public static class Temperature {

        @XmlAttribute
        private double morn;

        @XmlAttribute
        private double day;

        @XmlAttribute
        private double eve;

        @XmlAttribute
        private double night;

        public double getMorn() {
            return morn;
        }

        public double getDay() {
            return day;
        }

        public double getEve() {
            return eve;
        }

        public double getNight() {
            return night;
        }

        @Override
        public String toString() {
            return "Temperature{" + "morn=" + morn + ", day=" + day + ", eve=" + eve + ", night=" + night + '}';
        }
    }
}
