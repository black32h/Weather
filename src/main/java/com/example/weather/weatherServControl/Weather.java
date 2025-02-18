package com.example.weather;

public class Weather {

    private String city; // Назва міста
    private double temperature; // Температура в місті
    private double humidity; // Вологість в місті

    // Конструктор
    public Weather(String city, double temperature, double humidity) {
        this.city = city; // Ініціалізація назви міста
        this.temperature = temperature; // Ініціалізація температури
        this.humidity = humidity; // Ініціалізація вологості
    }

    // Геттери та сеттери
    public String getCity() {
        return city; // Повертає назву міста
    }

    public void setCity(String city) {
        this.city = city; // Встановлює назву міста
    }

    public double getTemperature() {
        return temperature; // Повертає температуру
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature; // Встановлює температуру
    }

    public double getHumidity() {
        return humidity; // Повертає вологість
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity; // Встановлює вологість
    }

    // Перевизначення методу toString для виведення даних
    @Override
    public String toString() {
        return "Weather in " + city + ": " +
                "Temperature = " + temperature + "°C, " +
                "Humidity = " + humidity + "%"; // Форматуємо виведення даних про погоду
    }
}

//        Поля city, temperature, humidity:
//
//city зберігає назву міста (тип String).
//temperature зберігає температуру в місті (тип double).
//humidity зберігає рівень вологості в місті (тип double).
//Конструктор:
//
//Конструктор ініціалізує ці поля, приймаючи значення для міста, температури та вологості. Під час створення об'єкта ці дані будуть встановлені.
//Геттери та сеттери:
//
//Геттери (getCity(), getTemperature(), getHumidity()) повертають відповідні значення полів.
//Сеттери (setCity(), setTemperature(), setHumidity()) дозволяють змінювати значення полів після створення об'єкта.
//Метод toString():
//
//Цей метод перевизначено для того, щоб представити об'єкт Weather у вигляді зрозумілого рядка. Якщо ви викликаєте toString() на об'єкті цього класу, він поверне рядок у форматі: "Weather in <назва міста>: Temperature = <температура>°C, Humidity = <вологість>%".
//Це дозволяє зручно виводити інформацію про погоду в консоль або логах.
