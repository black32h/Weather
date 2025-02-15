package com.example.weather.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Анотація, яка позначає клас як конфігураційний для Spring
public class AppConfig {

    @Bean // Анотація, що позначає метод, який створює бін
    public RestTemplate restTemplate() {
        return new RestTemplate(); // Створюємо екземпляр RestTemplate, який використовується для виконання HTTP запитів
    }
}
