package com.example.weather;

public class CityCoordinates {

    private double latitude; // Широта міста
    private double longitude; // Довгота міста

    // Конструктор
    public CityCoordinates(double latitude, double longitude) {
        this.latitude = latitude; // Ініціалізація широти
        this.longitude = longitude; // Ініціалізація довготи
    }

    // Геттери та сеттери
    public double getLatitude() {
        return latitude; // Повертає значення широти
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude; // Встановлює значення широти
    }

    public double getLongitude() {
        return longitude; // Повертає значення довготи
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude; // Встановлює значення довготи
    }

    // Перевизначення методу toString для виведення координат
    @Override
    public String toString() {
        return "Latitude: " + latitude + ", Longitude: " + longitude; // Форматуємо координати у вигляді рядка
    }
}
