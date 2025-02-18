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

//@SpringBootApplication:
//
//Це основна анотація, яка позначає, що цей клас є точкою входу в Spring Boot додаток. Вона є поєднанням кількох інших анотацій:
//@Configuration — вказує, що клас містить бін-конфігурацію.
//@EnableAutoConfiguration — дозволяє Spring Boot автоматично налаштовувати конфігурацію на основі класів, наявних у проєкті.
//@ComponentScan — вказує, що Spring повинен сканувати поточний пакет та всі підпакети для пошуку компонентів (як, наприклад, сервіси, контролери тощо).
//@Import(AppConfig.class):
//
//Ця анотація дозволяє імпортувати конфігураційний клас AppConfig у головний клас додатка. Тобто Spring Boot буде знати про конфігурацію для RestTemplate, яка була визначена в класі AppConfig. Це дозволяє використовувати RestTemplate у вашому додатку.
//        SpringApplication.run():
//
//Метод SpringApplication.run() запускає ваш Spring Boot додаток. Він ініціалізує контекст Spring, запускає вбудований сервер (наприклад, Tomcat) і починає обробку запитів. Після запуску ваш додаток стає доступним за вказаною портом (за умовчанням — 8080, якщо не змінено).
