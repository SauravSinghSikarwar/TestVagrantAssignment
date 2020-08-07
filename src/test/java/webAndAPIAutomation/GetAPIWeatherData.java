package webAndAPIAutomation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;


import io.restassured.*;
import io.restassured.path.json.JsonPath;

public class GetAPIWeatherData {
	
	
   public static ArrayList<GetWeatherData> getDataFromAPI(){
   
    ArrayList<GetWeatherData> APIData = new ArrayList<GetWeatherData>();
   
    RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
   
    String response = given().log().all().queryParam("q", "guwahati").queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
	                  .when().get()
	                  .then().assertThat().log().all().statusCode(200).extract().response().asString();
    
    
    JsonPath json = new JsonPath(response);
    String cityName = json.getString("name");
    System.out.println(cityName);
    double temp=json.getDouble("main.temp");
    int temparature=(int) Math.round(temp);
    int humidity = json.getInt("main.humidity");
    System.out.println(humidity);
    
    GetWeatherData data = new GetWeatherData(cityName, temparature, humidity);
    APIData.add(data);
    
    return APIData;
    
   }
  

   
}
