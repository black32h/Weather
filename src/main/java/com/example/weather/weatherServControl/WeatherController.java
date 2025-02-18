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

//Анотація @RestController:
//
//Ця анотація позначає клас як контролер REST для Spring, що означає, що він буде обробляти HTTP-запити та повертати дані в форматі JSON або інший формат для клієнта (наприклад, Postman).
//Поле WeatherService:
//
//Поле weatherService є залежністю, яке використовує цей контролер для отримання даних про погоду. В Spring це поле буде автоматично заповнено (за допомогою Dependency Injection), коли Spring створює екземпляр контролера.
//Конструктор з анотацією @Autowired:
//
//Анотація @Autowired дозволяє автоматично ін'єктувати залежності (в даному випадку, екземпляр класу WeatherService) через конструктор.
//        Таким чином, цей контролер може використовувати методи WeatherService, щоб отримувати актуальні дані про погоду.
//Метод getWeather:
//
//Цей метод обробляє GET-запити за шляхом /weather та приймає параметр city через анотацію @RequestParam.
//Параметр city визначає місто, для якого необхідно отримати дані про погоду.
//Метод викликає метод getWeatherData() з класу WeatherService, який на основі назви міста повертає відповідь (дані про погоду).
//Якщо виникає помилка (наприклад, якщо не вдається отримати дані), повертається повідомлення про помилку з текстом, який містить деталі помилки.
//Обробка помилок:
//
//        Всі помилки, що можуть виникнути при отриманні погоди (наприклад, не вдалось отримати дані з API), будуть зловлені через блок catch. У разі помилки метод поверне повідомлення про помилку з деталями.

