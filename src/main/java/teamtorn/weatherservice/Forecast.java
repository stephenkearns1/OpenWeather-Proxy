package teamtorn.weatherservice;

import java.util.ArrayList;
import java.util.Map;

/**
* <h1>POJO</h1>
* POJO to represent the complex json returned from the openweather API
* <p>
* @author  Stephen Kearns
* @version 1.0
* @since   4/11/2017
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
