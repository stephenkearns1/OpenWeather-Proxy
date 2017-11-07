package teamtorn.weatherservice;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.WebApplicationException;



/**
* @author  Stephen Kearns
* @version 1.0
* @since   4/11/2017
*/
public class OpenWeatherProxy {

    private final int port;
    private String openweatherURL;
    private String appId;
    private int statusCode;
    private String forecast;
    private WeatherInfo weather;
   
    public OpenWeatherProxy(){
        port = 49000;
        openweatherURL = "";
        appId = "d0377bd518a52af18796c75df2997b2f";
        statusCode = 0;
        
    }
    
  /**
   * This method is used to obtain the forecast.
   * For a specific city from the openweather API
   * @param city used to obtain forecast.
   * @return weather This is a POJO which has be serialized to json using Gson.
   * @exception WebApplicationException On status codes other than 200.
   * @see WebApplicationException
   */
    
    public WeatherInfo getForecast(String city){
        System.out.print(city);
        openweatherURL = "http://api.openweathermap.org/data/2.5/forecast";
        Gson gson = new Gson();
        weather = new WeatherInfo();
        
        Client client = Client.create();
        WebResource apiEndpoint = client.resource(openweatherURL);
       
        ClientResponse response = apiEndpoint
                .queryParam("q", city)
                .queryParam("mode", "json")
                .queryParam("appid", appId)
                .get(ClientResponse.class);
        
        statusCode = response.getStatus();
        
        if(statusCode != 200){
            throw new WebApplicationException("Could not access the endpoint ", statusCode);
        }else{
            forecast = response.getEntity(String.class);
              
            weather = gson.fromJson(forecast, WeatherInfo.class);
        }    
        
        return weather;
    }
}
