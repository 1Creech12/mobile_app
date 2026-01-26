import { View, Text, FlatList, StyleSheet} from "react-native";
import Indicator from "../Indicator/Indicator";

const testData = [
    {id: 1},
    {id: 2},
    {id: 3},
    {id: 4},
    {id: 5},
    {id: 6},
]

export default function Hero() {
    return (
        <View style={styles.container}>
            
            <View>
                <Text>New York</Text>
                <Text>Clear sky</Text>
            </View>

            <View>
                <View>
                    <Text>24</Text>
                    <Text>°C</Text>
                </View>
                <Text>Feels like 22°C</Text>
            </View>

            <FlatList 
                horizontal={false}
                numColumns={2}
                data={testData}
                renderItem={({item}) => (
                    <Indicator key={item.id} />
                ) }
            />

        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        borderWidth: 2,
        borderColor: '#FF0000',
})