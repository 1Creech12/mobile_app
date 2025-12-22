import { View, Text, Switch } from "react-native";
import { useState } from "react";

export default function SettingsScreen() {
  const [geo, setGeo] = useState(true);

  return (
    <View>
      <Text>Геолокация</Text>
      <Switch value={geo} onValueChange={setGeo} />

      <Text>Язык</Text>
      <Text>Тема</Text>
      <Text>Единицы измерения</Text>
    </View>
  );
}
