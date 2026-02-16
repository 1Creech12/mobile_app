fun main() {
    // Вспомогательные функции (определены внутри main)
    fun greetUser(name: String) {
        println("Привет, $name!")
    }

    fun calculateCircleArea(radius: Double): Double {
        return Math.PI * radius * radius
    }

    fun printPersonInfo(name: String, age: Int = 18, city: String = "Неизвестно") {
        println("Имя: $name, Возраст: $age, Город: $city")
    }

    fun calculateAverage(vararg numbers: Int): Double {
        if (numbers.isEmpty()) return 0.0
        var sum = 0
        for (num in numbers) {
            sum += num
        }
        return sum.toDouble() / numbers.size
    }

    fun square(x: Int) = x * x
    fun isEven(x: Int) = x % 2 == 0
    fun maxOfTwo(a: Int, b: Int) = if (a > b) a else b

    fun validatePassword(password: String): Boolean {
        fun hasValidLength(pwd: String) = pwd.length >= 8
        
        fun containsDigit(pwd: String): Boolean {
            for (char in pwd) {
                if (char.isDigit()) return true
            }
            return false
        }
        
        fun containsUppercase(pwd: String): Boolean {
            for (char in pwd) {
                if (char.isUpperCase()) return true
            }
            return false
        }
        
        return hasValidLength(password) && 
               containsDigit(password) && 
               containsUppercase(password)
    }
    
    println("\nЗадание 1:")
    greetUser("Анна")
    greetUser("Максим")
    greetUser("Елена")
    
    println("\nЗадание 2:")
    println("Площадь круга с радиусом 5.0: ${calculateCircleArea(5.0)}")
    println("Площадь круга с радиусом 10.0: ${calculateCircleArea(10.0)}")
    println("Площадь круга с радиусом 2.5: ${calculateCircleArea(2.5)}")
    
    println("\nЗадание 3:")
    println("Со всеми параметрами:")
    printPersonInfo("Анна", 25, "Москва")
    println("Только с именем и возрастом:")
    printPersonInfo("Максим", 30)
    println("Только с именем:")
    printPersonInfo("Елена")
    
    println("\nЗадание 4:")
    printPersonInfo(city = "Санкт-Петербург", name = "Дмитрий", age = 28)

    println("\nЗадание 5:")
    println("Среднее чисел 1, 2, 3: ${calculateAverage(1, 2, 3)}")
    println("Среднее чисел 10, 20, 30, 40, 50: ${calculateAverage(10, 20, 30, 40, 50)}")
    println("Среднее чисел 5, 5, 5, 5: ${calculateAverage(5, 5, 5, 5)}")
    
    println("\nЗадание 6:")
    println("Квадрат 5: ${square(5)}")
    println("Число 6 чётное? ${isEven(6)}")
    println("Максимум из 10 и 20: ${maxOfTwo(10, 20)}")
    
    println("\nЗадание 7:")
    val passwords = listOf(
        "weak", 
        "password123", 
        "Password123", 
        "PASS123", 
        "ValidPass123"
    )
    
    for (pwd in passwords) {
        println("Пароль '$pwd' валидный? ${validatePassword(pwd)}")
    }
    

}