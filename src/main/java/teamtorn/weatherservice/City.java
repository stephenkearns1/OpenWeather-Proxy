package teamtorn.weatherservice;

import java.util.Map;

/**
* <h1>POJO</h1>
* POJO to represent the complex json returned from the openweather API
* <p>
* @author  Stephen Kearns
* @version 1.0
* @since   4/11/2017
*/

public class City {
    public int id;
    public String name;
    public Map<String, Double> coord;
    public String country;
}
