package teamtorn.weatherservice;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Stephen Kearns
 */
public class Forecast {
    int dt;
    Main mian;
    ArrayList<Weather> weather;
    Clouds clouds;
    Map<String,Double> wind;
    Sys sys;
    String dt_txt;  
}
