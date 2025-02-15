package com.example.weather;

import com.example.weather.appconfig.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication // Анотація, яка позначає цей клас як точку входу в Spring Boot додаток
@Import(AppConfig.class) // Імпортуємо конфігураційний клас, щоб зареєструвати бін для RestTemplate
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args); // Запуск Spring Boot додатка
    }
}
//http://localhost:8081/weather?city=London запит для перевірки погоди