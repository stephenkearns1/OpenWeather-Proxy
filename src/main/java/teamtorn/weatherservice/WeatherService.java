/* Referances 
 * http://download.oracle.com/otn-pub/jcp/jaxrs-2_0-fr-eval-spec/jsr339-jaxrs-2.0-final-spec.pdf?AuthParam=1509812416_65e0aea901cf3cd43c290d50dfa0d3ec
 *
 */
package teamtorn.weatherservice;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
* <h1>Weather Service Proxy</h1>
* <p>
* The service acts as a proxy between the openweather api and the jersey client.
* It abstracts the openweather api implemenation away from the client.
*
* @author  Stephen Kearns
* @version 1.0
* @since   4/11/2017
*/
@Path("/weather")
public class WeatherService {
    
    @GET
    @Path("/{city}")
    @Produces("application/json")
    public Response getWeather(@PathParam("city") String city)
    {
        Gson gson = new Gson();
        OpenWeatherProxy proxyApi = new OpenWeatherProxy();
        WeatherInfo weather = proxyApi.getForecast(city);
        return Response.status(200).entity(gson.toJson(weather)).build();
    }    
    
}
