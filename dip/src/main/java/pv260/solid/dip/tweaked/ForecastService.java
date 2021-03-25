package pv260.solid.dip.tweaked;

import pv260.solid.dip.tweaked.model.ForecastResponse;

import java.io.IOException;

public interface ForecastService {

    ForecastResponse query() throws IOException;
}
