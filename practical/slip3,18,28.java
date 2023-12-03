1.Create Interface 
Observer.java 
package javaprograms; 
public interface Observer { 
 public void update(float temp,float humidity,float pressure); 
} 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
Displayelement.java 
package hello; 
public interface DisplayElement { 
public void display(); 
} 
Subject.java 
package hello; 
public interface Subject { 
public void registerObserver(Observer o); 
public void removeObserver(Observer o); 
public void notifyObservers(); 
} 
2. create classes 
CurrentConditionDispaly.java 
package hello; 
public class CurrentConditionDispaly implements
Observer,DisplayElement { 
 
private float temprature; 
private float humidity; 
private Subject weatherData; 
 
public CurrentConditionDispaly(Subject weatherData) 
{ 
 this.weatherData=weatherData; 
 weatherData.registerObserver(this); 
 
} 
 
public void update(float temprature,float humidity,float
pressure) { 
 this.temprature=temprature; 
 this.humidity=humidity; 
 display(); 
 } 
public void display() 
 { 
 System.out.println("current conditions:"+temprature+"F 
degree and "+humidity+"% humidity"); 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 } 
 
 
} 
ForecastDisplay.java 
package hello; 
public class ForecastDisplay implements Observer,DisplayElement { 
 
private float currentpressure=29.92f; 
private float lastpressure; 
private WeatherData weatherData; 
 
public ForecastDisplay(WeatherData weaherdata) { 
 this.weatherData=weatherData; 
 weatherData.registerObserver(this); 
 } 
public void update(float temp,float humidity,float pressure) { 
 lastpressure=currentpressure; 
 currentpressure=pressure; 
 display(); 
 } 
 
public void display() 
 { 
 System.out.println("forecast:"); 
 if(currentpressure > lastpressure) { 
 System.out.println("improving weather on the way!."); 
 }else if(currentpressure==lastpressure) { 
 System.out.println("more of the same"); 
 }else if(currentpressure < lastpressure) { 
 System.out.println("watch out for cooler,rainy 
weather"); 
 } 
 
 } 
} 
HeatIndexDisplay.java 
package hello; 
public class HeatIndexDisplay implements Observer,DisplayElement { 
float heatIndex=0.0f; 
private WeatherData weatherData; 
public HeatIndexDisplay(WeatherData weatherData) { 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 this.weatherData=weatherData; 
 weatherData.registerObserver(this); 
 } 
public void update(float t,float rh,float pressure) { 
 heatIndex=computeHeatIndex(t,rh); 
 display(); 
 
 } 
private float computeHeatIndex(float t,float rh) { 
 float index=(float)((16.923 + (0.185212 * t) + (5.37941 * 
rh) - (0.100254 * t * rh) + (0.000345372 *(t * t * rh ))) +(0.00728898 
* (rh * rh)) + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh
* rh))+ (0.0000102102 * (t * t * rh * rh)) -(0.000038646 * (t * t * 
t)) + (0.0000291683 * (rh * rh * rh)) + (0.00000142721 * (t * t * t * 
rh )) + (0.000000197483 * (t * rh * rh * rh)) - (0.000000218429 * (t * 
t * t * rh * rh )) + (0.000000000843296 * (t * t * rh * rh * rh)) - 
(0.0000000000481975 * (t * t * t * rh * rh * rh))); 
return index; 
 } 
public void display() 
 { 
 System.out.println("heat index"+heatIndex); 
 } 
} 
StatisticDisplay.java 
package hello; 
public class StatisticDisplay implements Observer,DisplayElement { 
 private float maxTemp=0.0f; 
 private float minTemp=200; 
 private float tempSum=0.0f; 
 private int numReadings; 
 private WeatherData weatherData; 
 public StatisticDisplay(WeatherData weatherData) { 
 this.weatherData=weatherData; 
 weatherData.registerObserver(this); 
 } 
 
 public void update(float temp,float humidity,float pressure) 
 { 
 tempSum=temp; 
 numReadings++; 
 
 if(temp > maxTemp) 
 { 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 maxTemp=temp; 
 } 
 if(temp < minTemp) { 
 minTemp=temp; 
 } 
 display(); 
 } 
 
 public void display() 
 { 
 System.out.println("AVG?MIN?MAX 
temprature="+(tempSum/numReadings )+"/"+maxTemp+"/"+minTemp); 
 
 } 
} 
WeatherData.java 
package hello; 
import java.util.ArrayList; 
public class WeatherData implements Subject{ 
private ArrayList<Observer> observers; 
private float temprature; 
private float humidity; 
private float pressure; 
 
 
public WeatherData() { 
 observers=new ArrayList<>(); 
 } 
 
public void registerObserver(Observer o) { 
 observers.add(o); 
 } 
 
public void removeObserver(Observer o) { 
 int i=observers.indexOf(o); 
 if(i>=0) { 
 observers.remove(i); 
 } 
 } 
 
public void notifyObservers() { 
for(int i=0;i<observers.size();i++) { 
 Observer observer=(Observer)observers.get(i); 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 observer.update(temprature, humidity, pressure); 
 } 
 
} 
public void measurementChanged() { 
 notifyObservers(); 
} 
public void setMeasurement(float temprature,float humidity,float
pressure) { 
this.temprature=temprature; 
this.humidity=humidity; 
this.pressure=pressure; 
measurementChanged(); 
} 
public float getTemprature() 
{ 
 return temprature; 
} 
public float gethumidity() 
{ 
return humidity; 
} 
public float getpressure() 
{ 
return pressure; 
} 
} 
WeatherStation.java 
package hello; 
import java.io.*; 
public class WeatherStation { 
public static void main(String[] args) { 
 // TODO Auto-generated method stub
 //try {
 WeatherData weatherData=new WeatherData(); 
 CurrentConditionDispaly currentDisplay=new
CurrentConditionDispaly(weatherData); 
 StatisticDisplay statisticDisplay=new
StatisticDisplay(weatherData); 
 weatherData.setMeasurement(80,65,30.4f); 
 weatherData.setMeasurement(82, 70,29.2f); 
 weatherData.setMeasurement(78,90,29.2f); 
 } 
}