package teamtorn.weatherservice;

import java.util.ArrayList;

/**
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
