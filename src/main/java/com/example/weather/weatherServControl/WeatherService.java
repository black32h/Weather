package com.example.weather;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherData(String city) throws Exception {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=uk",
                city, apiKey
        );

        String response = restTemplate.getForObject(url, String.class);

        if (response == null) {
            throw new Exception("Не вдалося отримати дані про погоду.");
        }

        JSONObject jsonResponse = new JSONObject(response);
        JSONObject main = jsonResponse.getJSONObject("main");
        JSONObject wind = jsonResponse.getJSONObject("wind");
        JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);

        String weatherDescription = translateToUkrainian(weather.getString("description"));
        double temp = main.getDouble("temp");
        double windSpeed = wind.getDouble("speed");

        String rain = jsonResponse.has("rain") && jsonResponse.getJSONObject("rain").has("1h") ?
                String.format("дощ: %.1f мм", jsonResponse.getJSONObject("rain").getDouble("1h")) :
                "без опадів";

        return String.format("Погода в %s: %s, температура: %.1f°C, вітер: %.1f м/с, %s",
                city, weatherDescription, temp, windSpeed, rain);
    }

    private String translateToUkrainian(String description) {
        switch (description.toLowerCase()) {
            case "clear sky":
                return "Ясне небо";
            case "few clouds":
                return "Невелика хмарність";
            case "scattered clouds":
                return "Розсіяні хмари";
            case "broken clouds":
                return "Перемінна хмарність";
            case "shower rain":
                return "Ливень";
            case "rain":
                return "Дощ";
            case "thunderstorm":
                return "Гроза";
            case "snow":
                return "Сніг";
            case "mist":
                return "Туман";
            default:
                return description;
        }
    }
}
