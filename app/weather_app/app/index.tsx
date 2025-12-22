import { View, Text, ScrollView } from "react-native";
import { useEffect, useState } from "react";
import * as Location from "expo-location";
import { getWeather } from "@/lib/api/openMeteo";
import CitySearch from "@/components/CitySearch";
import WeeklyForecast from "@/components/WeeklyForecast";

export default function HomeScreen() {
    const [weather, setWeather] = useState<any>(null);

    async function loadByLocation() {
        const { status } = await Location.requestForegroundPermissionsAsync();
        if (status !== 'granted') return;

        const loc = await Location.getCurrentPositionAsync({});
        const data = await getWeather(
            loc.coords.latitude,
            loc.coords.longitude
        );
        setWeather(data);
    }

    useEffect(() => {
        loadByLocation();
    }, []);

    return (
    <ScrollView>
      <CitySearch
        onSelect={async (city) => {
          const data = await getWeather(city.latitude, city.longitude);
          setWeather(data);
        }}
      />

      {weather && (
        <View>
          <Text>Температура: {weather.current.temperature_2m}°</Text>
          <Text>Ощущается: {weather.current.apparent_temperature}°</Text>
          <Text>Ветер: {weather.current.wind_speed_10m}</Text>
          <Text>Влажность: {weather.current.relative_humidity_2m}%</Text>
          <Text>Видимость: {weather.current.visibility} м</Text>
        </View>
      )}
            {weather && <WeeklyForecast daily={weather.daily} />}
        </ScrollView>
    );
}