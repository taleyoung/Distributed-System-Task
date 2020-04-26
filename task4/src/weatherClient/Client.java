package weatherClient;

import wsproxy.*;

public class Client {
    public void main(){
        WeatherWS weatherWS = new WeatherWSLocator();
        WeatherWSSoap_PortType weatherWSSoap = weatherWS.getWeatherWSSoap();
        String[] weather = weatherWSSoap.getWeather("西安",null);
        for(String s : weather){
            System.out.println(s);
        }
    }
}
