
import { GestureHandlerRootView } from 'react-native-gesture-handler';
import { ScrollView, View } from 'react-native'
import InputSearch from '@/components/ui/Input/Input'
import Button from '@/components/ui/Button/Button';
import Ionicons from '@expo/vector-icons/Ionicons';
import { SafeAreaProvider, SafeAreaView } from 'react-native-safe-area-context';
import Hero from '@/components/ui/Hero/Hero';

const test = () => {
    console.log('lol')
}

export default function Index() {
    return (
        <GestureHandlerRootView>
            <SafeAreaProvider>
                <SafeAreaView>

                    <View>
                        <InputSearch
                            value={''}
                            onChangeText={test}
                        />

                        <Button onPress={test}>
                            <Ionicons name="settings-outline" size={24} color="black" />
                        </Button>      
                    </View>

                    <ScrollView>
                        <Hero />
                    </ScrollView>
                </SafeAreaView>
            </SafeAreaProvider>
        </GestureHandlerRootViev>
    )
    
}