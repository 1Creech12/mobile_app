import { View, TextInput, Text, Pressable } from "react-native";
import { useState } from "react";
import { searchCity } from "@/lib/api/openMeteo";

export default function CitySearch({
  onSelect,
}: {
  onSelect: (city: any) => void;
}) {
  const [query, setQuery] = useState("");
  const [results, setResults] = useState<any[]>([]);

  async function onChange(text: string) {
    setQuery(text);
    if (text.length < 3) return;

    const cities = await searchCity(text);
    setResults(cities);
  }

  return (
    <View>
      <TextInput
        placeholder="Поиск города"
        value={query}
        onChangeText={onChange}
      />

      {results.map((city) => (
        <Pressable
          key={city.id}
          onPress={() => {
            setQuery(city.name);
            setResults([]);
            onSelect(city);
          }}
        >
          <Text>{city.name}, {city.country}</Text>
        </Pressable>
      ))}
    </View>
  );
}
