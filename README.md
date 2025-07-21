# 🌤️ Weather App with Dynamic Weather-Based Background

An Android weather application built with **Kotlin**, where users can **input a location manually** to get real-time weather data. The app dynamically changes its background according to the **weather condition** (sunny, rainy, cloudy, etc.) to provide a visually immersive experience.

## ✨ Features

- 📝 **User-input location** for weather search
- ☁️ **Real-time weather updates** via OpenWeatherMap API
- 🖼️ **Dynamic background changes** based on current weather:
  - ☀️ Sunny: bright sunny theme
  - 🌧️ Rainy: rainy/cloudy visuals
  - ❄️ Snowy: snow background
  - ☁️ Cloudy: overcast background
- 🌡️ Shows:
  - Temperature
  - Humidity
  - Weather description
- 📱 Clean and intuitive Material Design UI

## 📸 Screenshots

| Sunny | Rainy | Cloudy |
|-------|-------|--------|
| ![sunny](assets/sunny.png) | ![rainy](assets/rainy.png) | ![cloudy](assets/cloudy.png) |

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI**: XML, ConstraintLayout
- **API**: OpenWeatherMap
- **Networking**: Retrofit / Volley
- **Architecture**: MVVM (optional)

## 🧠 How It Works

1. User enters a city name (e.g., *Delhi*, *New York*) in the search bar.
2. App makes a network call to **OpenWeatherMap API** using the city name.
3. Weather data is parsed, and:
   - UI displays temperature, humidity, and condition
   - Background changes to match the weather condition

## 🧾 Example Weather Conditions Mapping

| Weather Condition | Background |
|-------------------|------------|
| `Clear`           | ☀️ Sunny theme |
| `Rain`/`Drizzle`  | 🌧️ Rainy theme |
| `Clouds`          | ☁️ Cloudy background |
| `Snow`            | ❄️ Snowy theme |
| `Thunderstorm`    | ⚡ Stormy theme |
| `Mist`/`Fog`      | 🌫️ Foggy background |
