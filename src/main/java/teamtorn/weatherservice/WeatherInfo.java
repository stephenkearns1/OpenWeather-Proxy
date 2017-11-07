package teamtorn.weatherservice;

import java.util.ArrayList;

/**
* <h1>POJO</h1>
* POJO to represent the complex json returned from the openweather API
* <p>
* @author  Stephen Kearns
* @version 1.0
* @since   4/11/2017
*/
public class WeatherInfo {
    String code;
    String message;
    int count;
    ArrayList<Forecast> list;
    City city;
}
