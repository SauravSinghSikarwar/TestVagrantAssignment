package reusables;


import io.restassured.path.json.JsonPath;

public class CommonUtils {
	
	// for string to Json conversion
	public static JsonPath rawStringToJson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
		
	}
	
	
    // Getting only integer value from a String
	public static String extractInt(String str) 
    { 
        // Replacing every non-digit number with space  
        str = str.replaceAll("[^\\d]", " "); 
        str = str.trim(); 
  
        // Replace all the consecutive white spaces with a single space 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return "-1"; 
  
        return str; 
    } 
	
    
	// Converting Celsius value into Fahrenheit  
    public static int convertCelsiusToFahrenheit(float Celsiustemperature)
    {   
               
             int Fahrenheit =(int) (((Celsiustemperature*9)/5)+32);
       
    
        return Fahrenheit;
     
    }
}
