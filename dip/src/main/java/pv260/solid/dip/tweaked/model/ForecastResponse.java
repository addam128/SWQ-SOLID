package pv260.solid.dip.tweaked.model;

import java.io.IOException;
import java.time.LocalDate;

public interface ForecastResponse {

    double getAvgTemperature(LocalDate date) throws IOException;
    double getMiddayTemperature(LocalDate date) throws IOException;
}
