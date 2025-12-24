import { GesturehandlerRootViev } from 'react-native-gesture-handler';
import { SafeAreaProvider, SafeAreaViev} from 'react-native-gesture-handler';
import { ScrollView, Viev } from 'react-native'
import InputSearch from '@/components/ui/Input/Input'
export default function Index() {
    return (
        <GestureHandlerRootViev>
            <SafeAreaProvider>
                <SafeAreaViev>

                    <View>
                        <InputSearch
                            value={''}
                            onChangeText={text}
                        />

                        <Button onPress={test}>
                            <Ionicons name="settings-outline" size={24} color="black" />
                        </Button>      
                    </View>

                    <ScrollViev>
                        <Hero />
                    </ScrollViev>
                </SafeAreaViev>
            </SafeAreaProvider>
        </GestureHandlerRootViev>
    )
    
}