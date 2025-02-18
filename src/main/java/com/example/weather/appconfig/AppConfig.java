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
//@Configuration:
//
//Ця анотація вказує, що клас є конфігураційним для Spring і містить методи, які створюють біні. Клас, позначений цією анотацією, буде скануватися Spring Boot під час запуску програми для реєстрації бінів.
//@Bean:
//
//Анотація на методі, яка означає, що метод створює бін, який буде доданий до контексту Spring. В даному випадку метод restTemplate() повертає новий екземпляр класу RestTemplate.
//RestTemplate використовується для виконання HTTP запитів, таких як GET, POST, PUT, DELETE тощо. Він часто використовується для інтеграції з іншими веб-сервісами через REST API.
//RestTemplate:
//
//Це клас у Spring, який дозволяє виконувати HTTP запити. Ви можете використовувати його для здійснення запитів до зовнішніх сервісів або для взаємодії з іншими веб-ресурсами.
