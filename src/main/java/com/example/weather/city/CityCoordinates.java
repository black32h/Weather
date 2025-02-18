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

//Поля latitude і longitude:
//
//Ці поля зберігають значення широти та довготи міста відповідно. Вони мають тип double, оскільки координати зазвичай виражаються в десяткових дробах.
//        Конструктор:
//
//Конструктор ініціалізує ці поля, приймаючи значення широти та довготи як параметри. Це дозволяє створити об'єкт класу CityCoordinates, надаючи координати під час створення.
//Геттери та сеттери:
//
//Геттери (методи getLatitude() і getLongitude()) повертають значення широти та довготи.
//Сеттери (методи setLatitude() і setLongitude()) дозволяють змінювати значення цих полів після створення об'єкта.
//Метод toString():
//
//Цей метод перевизначено для того, щоб представити об'єкт CityCoordinates у вигляді зрозумілого рядка. Якщо ви викликаєте toString() на об'єкті цього класу, він поверне рядок у форматі: Latitude: <значення>, Longitude: <значення>.
//Це дозволяє зручно виводити координати в консоль або логах.
