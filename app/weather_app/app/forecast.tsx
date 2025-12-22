import { View, Text, FlatList } from "react-native";
import { useLocalSearchParams } from "expo-router";

export default function ForecastScreen() {
  const { date } = useLocalSearchParams();

  return (
    <View>
      <Text>Погода на {date}</Text>
      <FlatList
        horizontal
        data={[]}
        renderItem={() => <Text>Час</Text>}
      />
    </View>
  );
}
