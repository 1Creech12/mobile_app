import axios from "axios";

const GEO_URL = "https://geocoding-api.open-meteo.com/v1/search";
const WEATHER_URL = "https://api.open-meteo.com/v1/forecast";

export const searchCity = async (name) => {
  const res = await axios.get(GEO_URL, {
    params: {
      name,
      count: 5,
      language: "ru",
      format: "json",
    },
  });
  return res.data.results || [];
};

export const getWeather = async (lat, lon, units = "metric") => {
  return axios.get(WEATHER_URL, {
    params: {
      latitude: lat,
      longitude: lon,
      current: [
        "temperature_2m",
        "wind_speed_10m",
        "relative_humidity_2m",
        "visibility",
        "weather_code",
        "apparent_temperature",
        "uv_index",
      ],
      hourly: [
        "temperature_2m",
        "weather_code",
        "wind_speed_10m",
      ],
      daily: [
        "temperature_2m_max",
        "temperature_2m_min",
        "weather_code",
      ],
      timezone: "auto",
      temperature_unit: units === "metric" ? "celsius" : "fahrenheit",
      wind_speed_unit: units === "metric" ? "ms" : "mph",
    },
  });
};
