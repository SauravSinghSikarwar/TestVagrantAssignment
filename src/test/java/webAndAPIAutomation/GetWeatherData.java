package webAndAPIAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class GetWeatherData {

String city;
int temp;
int humid;

public GetWeatherData(String city, int temp, int humid){
	   this.city = city;
	   this.temp = temp;
	   this.humid = humid;
}
public void setTemp(int temp) {
	   this.temp = temp;
}
public int getTemp() {
	   return temp;
}
public void setHumid(int humid) {
	   this.humid = humid;
}
public int getHumid() {
	   return humid;
}
public void setCity(String city) {
	   this.city = city;
}
public String getCity() {
	   return city;
}
public static class temparatureSortingComparator implements Comparator<GetWeatherData>{

	@Override
	public int compare(GetWeatherData o1, GetWeatherData o2) {
		// TODO Auto-generated method stub
		int Success=0;
		// TODO Auto-generated method stub
		int temparatureCompare=o1.getTemp()-o2.getTemp();
		int humidCompare=o1.getHumid()-o2.getHumid();
		if(temparatureCompare<=2 && humidCompare <=10 ) {
		return Success;
		}
		else
		{
			return Success=1;
		}
	}	
	   
}
public static void compareFromApiAndUI() {
	ArrayList<GetWeatherData> uiData=GetUIWeatherData.getDataFromWebUI();
	Iterator<GetWeatherData> uiIterator = uiData.iterator(); 
   while (uiIterator.hasNext()) { 
        System.out.println(uiIterator.next()); 
    } 
    Collections.sort(uiData, new temparatureSortingComparator()); 
    
	GetUIWeatherData.closeDriver();
	ArrayList<GetWeatherData> apiData=GetAPIWeatherData.getDataFromAPI();
	Iterator<GetWeatherData> apiIterator = apiData.iterator(); 
    while (apiIterator.hasNext()) { 
        System.out.println(apiIterator.next()); 
    }   
    Collections.sort(apiData, new temparatureSortingComparator()); 
}
}
