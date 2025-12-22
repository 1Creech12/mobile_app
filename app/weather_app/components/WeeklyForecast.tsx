import { View, Text, Pressable } from "react-native";
import { useRouter } from "expo-router";

export default function WeeklyForecast({ daily }: { daily: any }) {
  const router = useRouter();

  return (
    <View>
      {daily.time.map((date: string, i: number) => (
        <Pressable
          key={date}
          onPress={() =>
            router.push({
              pathname: "/forecast",
              params: { date },
            })
          }
        >
          <Text>
            {date}: {daily.temperature_2m_min[i]} /
            {daily.temperature_2m_max[i]}
          </Text>
        </Pressable>
      ))}
    </View>
  );
}
