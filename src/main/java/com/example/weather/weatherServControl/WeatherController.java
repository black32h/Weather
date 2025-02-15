package com.example.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Анотація, яка позначає цей клас як контролер REST для обробки HTTP запитів
public class WeatherController {

    private final WeatherService weatherService; // Залежність від WeatherService для отримання даних про погоду

    // Конструктор, що ін'єкціює WeatherService через @Autowired
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService; // Ініціалізація залежності
    }

    // Обробка GET запиту на /weather
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        try {
            return weatherService.getWeatherData(city); // Викликаємо метод для отримання даних про погоду для зазначеного міста
        } catch (Exception e) {
            return "Помилка отримання погоди: " + e.getMessage(); // Обробка помилок, якщо не вдалося отримати дані
        }
    }
}
