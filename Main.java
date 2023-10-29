import java.util.ArrayList;
import java.util.List;

class WeatherData {
    private String location;
    private double temperature;
    private String condition;
    public WeatherData(String location, double temperature, String condition){
        this.location=location;
        this.temperature=temperature;
        this.condition=condition;

    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public String getLocation() {
        return location;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

interface WeatherAPI {
    List<WeatherData> fetchWeatherData();
}

class ImaginaryWeatherAPIAdapter implements WeatherAPI {
    public List<WeatherData> fetchWeatherData() {
        List<WeatherData> weatherDataList = new ArrayList<>();


        String apiResponse = getMockApiResponse();


        WeatherData weatherData = new WeatherData("Astana", 7.0, "Sunny");
        weatherData.setLocation("City A");
        weatherData.setTemperature(25.0);
        weatherData.setCondition("Sunny");

        weatherDataList.add(weatherData);

        return weatherDataList;
    }


    private String getMockApiResponse() {
        return "{ \"location\": \"City A\", \"temperature\": 25.0, \"condition\": \"Sunny\" }";
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherAPI api = new ImaginaryWeatherAPIAdapter();
        List<WeatherData> data = api.fetchWeatherData();


        for (WeatherData weatherData : data) {
            System.out.println("Location: " + weatherData.getLocation());
            System.out.println("Temperature: " + weatherData.getTemperature());
            System.out.println("Condition: " + weatherData.getCondition());
        }
    }
}
