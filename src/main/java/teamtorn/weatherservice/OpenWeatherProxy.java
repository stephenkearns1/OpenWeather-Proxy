/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamtorn.weatherservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.WebApplicationException;



/**
 *
 * @author Stephen Kearns
 */
public class OpenWeatherProxy {

    private final int port;
    private String openweatherURL;
    private String appId;
    private int statusCode;
    private String forecast;
   
    public OpenWeatherProxy(){
        port = 49000;
        openweatherURL = "";
        appId = "d0377bd518a52af18796c75df2997b2f";
        statusCode = 0;
        
    }
    
    public String getForecast(String city){
        openweatherURL = "http://api.openweathermap.org/data/2.5/forecast";
        
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
            /* Should use gson for forecast or return as json */
            forecast = response.getEntity(String.class);
        }
        /*ClientResponse response = apiEndpoint.type("application/json")
                .queryParam("q", city)
                .queryParam("mode", "json")
                .queryParam("appid", appId)
                .get(ClientResponse.class);
        */
        
        return forecast;
    }
}
