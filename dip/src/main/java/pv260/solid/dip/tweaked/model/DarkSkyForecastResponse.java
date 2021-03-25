
package pv260.solid.dip.tweaked.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class DarkSkyForecastResponse implements ForecastResponse {
    private double latitude;
    private double longitude;
    private String timezone;
    private Daily daily;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public Daily getDaily() {
        return daily;
    }



    @Override
    public String toString() {
        return "DarkSkyForecastResponse{" + "latitude=" + latitude + ", longitude=" + longitude + ", timezone=" + timezone + ", daily=" + daily + '}';
    }

    @Override
    public double getAvgTemperature(LocalDate date) throws IOException {
        for (DailyData data: getDaily().getData()) {
            LocalDateTime recordTime = LocalDateTime.ofEpochSecond(data.getTime(),
                    0,
                    ZoneOffset.UTC);
            if (recordTime.toLocalDate().equals(date)) {
                return (data.getTemperatureMax() + data.getTemperatureMin()) / 2;
            }
        }
        throw new IOException("no forecast for that day");
    }

    @Override
    public double getMiddayTemperature(LocalDate date) throws IOException {
        return getAvgTemperature(date);
    }

    public static class Daily {

        private String summary;

        private List<DailyData> data;

        public String getSummary() {
            return summary;
        }

        public List<DailyData> getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Daily{" + "summary=" + summary + ", data=" + data + '}';
        }
    }

    public static class DailyData {

        private long time;

        private double temperatureMin;

        private double temperatureMax;

        public long getTime() {
            return time;
        }

        public double getTemperatureMin() {
            return temperatureMin;
        }

        public double getTemperatureMax() {
            return temperatureMax;
        }

        @Override
        public String toString() {
            return "DailyData{" + "time=" + time + '}';
        }

    }

}
