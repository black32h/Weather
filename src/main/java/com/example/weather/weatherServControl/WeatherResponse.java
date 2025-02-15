package com.example.weather;

public class WeatherResponse {

    private Main main; // Основні дані про погоду: температура, вологість, тиск
    private Wind wind; // Інформація про вітер
    private Weather[] weather; // Опис погодних умов (наприклад, ясність, дощ)
    private Rain rain; // Дані про дощ

    public Main getMain() {
        return main; // Повертає основні дані про погоду
    }

    public void setMain(Main main) {
        this.main = main; // Встановлює основні дані про погоду
    }

    public Wind getWind() {
        return wind; // Повертає дані про вітер
    }

    public void setWind(Wind wind) {
        this.wind = wind; // Встановлює дані про вітер
    }

    public Weather[] getWeather() {
        return weather; // Повертає масив погодних умов
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather; // Встановлює масив погодних умов
    }

    public Rain getRain() {
        return rain; // Повертає дані про дощ
    }

    public void setRain(Rain rain) {
        this.rain = rain; // Встановлює дані про дощ
    }

    // Внутрішній клас для основних даних про погоду
    public static class Main {
        private double temp; // Температура
        private double humidity; // Вологість
        private double pressure; // Тиск

        // Геттери та сеттери
        public double getTemp() {
            return temp; // Повертає температуру
        }

        public void setTemp(double temp) {
            this.temp = temp; // Встановлює температуру
        }

        public double getHumidity() {
            return humidity; // Повертає вологість
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity; // Встановлює вологість
        }

        public double getPressure() {
            return pressure; // Повертає тиск
        }

        public void setPressure(double pressure) {
            this.pressure = pressure; // Встановлює тиск
        }
    }

    // Внутрішній клас для даних про вітер
    public static class Wind {
        private double speed; // Швидкість вітру

        public double getSpeed() {
            return speed; // Повертає швидкість вітру
        }

        public void setSpeed(double speed) {
            this.speed = speed; // Встановлює швидкість вітру
        }
    }

    // Внутрішній клас для опису погодних умов
    public static class Weather {
        private String description; // Опис погодних умов (наприклад, "ясно", "дощ")

        public String getDescription() {
            return description; // Повертає опис погодних умов
        }

        public void setDescription(String description) {
            this.description = description; // Встановлює опис погодних умов
        }
    }

    // Внутрішній клас для даних про дощ
    public static class Rain {
        private double _1h; // Кількість дощу за останню годину

        public double get_1h() {
            return _1h; // Повертає кількість дощу за останню годину
        }

        public void set_1h(double _1h) {
            this._1h = _1h; // Встановлює кількість дощу за останню годину
        }
    }
}
