
package pv260.solid.dip.tweaked;

import java.io.IOException;
import java.time.LocalDate;

public class RecommendedLunchService implements RecommendationService {

private final ForecastService weatherService;

    public RecommendedLunchService() {
        this.weatherService = new DarkSkyForecastService();
    }

      private double findTemperatureAroundLunch(LocalDate date) throws IOException{

          return weatherService.query().getMiddayTemperature(date);
    }


    private String recommend(LocalDate date) {
        try {
            double temperatureAroundLunch = this.findTemperatureAroundLunch(date);
            if (temperatureAroundLunch < -15) {
                return "You will need a lot of energy to keep warm, tomorrow you should eat something very nutritious.";
            } else if (temperatureAroundLunch < 15) {
                return "No day like tomorrow for some chicken.";
            } else if (temperatureAroundLunch < 30) {
                return "It will be quite hot tomorrow, be sure to order a cold beer with your lunch.";
            } else {
                return "You probably will not be hungry at all in such a hot weather. Just get an ice cream!";
            }
        } catch (IOException e) {
            return "Error when calculating best lunch recommendation for tomorrow";
        }
    }

    @Override
    public String recommendForTomorrow() {
        return recommend(LocalDate.now().plusDays(1));
    }
}
