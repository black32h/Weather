package com.example.weather.weatherServControl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // Анотація позначає клас як сервіс для обробки бізнес-логіки
public class WeatherService {

    private final RestTemplate restTemplate; // Залежність від RestTemplate для здійснення HTTP-запитів

    @Value("${weather.api.key}") // Читаємо API ключ з налаштувань
    private String apiKey;

    // Конструктор, що ін'єкціює залежність RestTemplate
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate; // Ініціалізація RestTemplate
    }

    // Метод для отримання даних про погоду для заданого міста
    public String getWeatherData(String city) throws Exception {
        // Формуємо URL запиту до API погоди
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=uk",
                city, apiKey
        );

        // Надсилаємо GET запит до API і отримуємо відповідь у вигляді рядка
        String response = restTemplate.getForObject(url, String.class);

        // Якщо відповідь порожня, кидаємо виключення
        if (response == null) {
            throw new Exception("Не вдалося отримати дані про погоду.");
        }

        // Парсимо відповідь у форматі JSON
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject main = jsonResponse.getJSONObject("main"); // Основні дані: температура, вологість, тиск
        JSONObject wind = jsonResponse.getJSONObject("wind"); // Дані про вітер
        JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0); // Опис погодних умов

        // Перекладаємо опис погодних умов на українську
        String weatherDescription = translateToUkrainian(weather.getString("description"));
        double temp = main.getDouble("temp"); // Отримуємо температуру
        double windSpeed = wind.getDouble("speed"); // Отримуємо швидкість вітру

        // Перевіряємо наявність даних про дощ
        String rain = jsonResponse.has("rain") && jsonResponse.getJSONObject("rain").has("1h") ?
                String.format("дощ: %.1f мм", jsonResponse.getJSONObject("rain").getDouble("1h")) :
                "без опадів";

        // Форматуємо та повертаємо результат
        return String.format("Погода в %s: %s, температура: %.1f°C, вітер: %.1f м/с, %s",
                city, weatherDescription, temp, windSpeed, rain);
    }

    // Метод для перекладу опису погодних умов з англійської на українську
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
                return description; // Якщо опис не знайдено, повертаємо його без змін
        }
    }
}

//Конструктор та залежність від RestTemplate:
////
////Ви використовуєте RestTemplate для відправки HTTP запитів. Це зручний інструмент для взаємодії з REST API у Spring.
////Через анотацію @Value("${weather.api.key}") ви отримуєте API ключ з файлу налаштувань (наприклад, application.properties або application.yml), щоб підключитися до OpenWeather API.
////Метод getWeatherData:
////
////Формуєте URL запиту для API OpenWeather, підставляючи місто та API ключ.
////Використовуєте метод restTemplate.getForObject для отримання відповіді у вигляді рядка.
////        Перевіряєте, чи відповідь не порожня. Якщо так, кидаєте виключення.
////Парсите отриману JSON-відповідь за допомогою бібліотеки JSONObject і витягуєте потрібні дані: температуру, швидкість вітру та опис погодних умов.
////Якщо є дані про дощ, обробляєте їх і включаєте в результат.
////Форматуєте результат і повертаєте строку з інформацією про погоду для конкретного міста.
////Метод translateToUkrainian:
////
////Цей метод відповідає за переклад погодних умов (наприклад, "clear sky" → "Ясне небо") на українську мову.
////Ви використовуєте switch для перевірки умов та повертаєте відповідний переклад.//
