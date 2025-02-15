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
