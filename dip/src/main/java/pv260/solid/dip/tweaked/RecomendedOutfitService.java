package pv260.solid.dip.tweaked;

import java.io.IOException;
import java.time.LocalDate;

public class RecomendedOutfitService implements RecommendationService {

    private final ForecastService weatherService;

    public RecomendedOutfitService() {
        this.weatherService = new OpenWeatherMapService();
    }


    private double findAverageTemperature(LocalDate date) throws IOException {
        return weatherService.query().getAvgTemperature(date);
    }

    private String recommend(LocalDate date) {
        try {
            double averageTemperature = this.findAverageTemperature(date);
            if (averageTemperature < -10) {
                return "It will be super cold, weak a jacket or two!";
            } else if (averageTemperature < 0) {
                return "It will be rather chilly, better wear a coat.";
            } else if (averageTemperature < 15) {
                return "Weather will be very pleasant, weak a light jacket and jeans.";
            } else if (averageTemperature < 25) {
                return "Tomorrow will be a beautiful day, shirt and shorst should be fine.";
            } else {
                return "It will be really hot, better grab a swimsuit and run to the beach!";
            }
        } catch (IOException e) {
            return "Error when calculating best outfit for tomorrow";
        }
    }

    @Override
    public String recommendForTomorrow() {
        return recommend(LocalDate.now().plusDays(1));

    }
}
