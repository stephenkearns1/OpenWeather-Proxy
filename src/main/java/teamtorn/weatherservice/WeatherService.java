/* Referances 
 * http://download.oracle.com/otn-pub/jcp/jaxrs-2_0-fr-eval-spec/jsr339-jaxrs-2.0-final-spec.pdf?AuthParam=1509812416_65e0aea901cf3cd43c290d50dfa0d3ec
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamtorn.weatherservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Stephen Kearns
 */
@Path("/weather")
public class WeatherService {
    
    @GET
    @Path("/{city}")
    @Produces("application/json")
    public Response getWeather(@PathParam("city") String city)
    {
        OpenWeatherProxy proxyApi = new OpenWeatherProxy();
        //either serizlise json to PJO 
        String forecast = proxyApi.getForecast(city);
        //or just return json 
        
        
        return Response.status(200).entity(forecast).build();
    }    
    
}
