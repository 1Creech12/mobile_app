import kotlin.math.sqrt
import kotlin.random.Random
fun main() {
    // Задание 1
    println("Задание 1: Динамические диапазоны")
    println("Пример: диапазон от 10 до 30 с шагом 2")
    for (num in 10..30 step 2) {
        if (num % 3 == 0) {
            println("Число $num делится на 3")
        }
    }
    println()
    
    // Задание 2
    println("Задание 2: Работа с массивом и условиями")
    val array = Array(10) { Random.nextInt(1, 101) }
    println("Массив: ${array.joinToString()}")
    println("Максимальный: ${array.maxOrNull()}")
    println("Минимальный: ${array.minOrNull()}")
    println("Среднее: ${"%.2f".format(array.average())}")
    println("Чётных чисел: ${array.count { it % 2 == 0 }}")
    println()
    
    // Задание 3
    println("Задание 3: Конвертер систем счисления")
    println("Число 42 в разных системах:")
    println("Двоичная: ${42.toString(2)}")
    println("Восьмеричная: ${42.toString(8)}")
    println("Шестнадцатеричная: ${42.toString(16).uppercase()}")
    println()
    
    // Задание 4
    println("Задание 4: Поиск простых чисел")
    print("Простые числа от 2 до 100: ")
    for (num in 2..100) {
        var isPrime = true
        for (divisor in 2 until num) {
            if (num % divisor == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) print("$num ")
    }
    println("\n")
    
    // Задание 5
    println("Задание 5: Шифр Цезаря")
    val text = "Hello World!"
    print("Исходный текст: $text -> ")
    val encrypted = text.map { char ->
        when {
            char.isUpperCase() -> ((char - 'A' + 3) % 26 + 'A'.code).toChar()
            char.isLowerCase() -> ((char - 'a' + 3) % 26 + 'a'.code).toChar()
            else -> char
        }
    }.joinToString("")
    println("Зашифрованный: $encrypted")
    println()
    
    // Задание 6
    println("Задание 6: Статистика текста")
    val sampleText = "Hello world! This is a test. How are you? I'm fine!"
    println("Текст: $sampleText")
    println("Символов: ${sampleText.length}")
    println("Слов: ${sampleText.split("\\s+".toRegex()).filter { it.isNotBlank() }.size}")
    println("Предложений: ${sampleText.split("[.!?]+".toRegex()).filter { it.trim().isNotEmpty() }.size}")
    println("Самое длинное слово: ${sampleText.split("\\W+".toRegex()).maxByOrNull { it.length }}")
    println()
    
    // Задание 7
    println("Задание 7: Игра «Угадай число»")
    val secret = Random.nextInt(1, 101)
    println("Загадано число от 1 до 100")
    println("(Для демонстрации загадано: $secret)")
    var attempts = 0
    var guess = 0
    while (guess != secret) {
        guess = when (attempts) {
            0 -> 50
            1 -> if (secret > 50) 75 else 25
            2 -> if (secret > 50) {
                if (secret > 75) 88 else 63
            } else {
                if (secret > 25) 38 else 13
            }
            else -> secret
        }
        attempts++
        println("Попытка $attempts: $guess -> ${when {
            guess < secret -> "Больше"
            guess > secret -> "Меньше"
            else -> "Угадал!"
        }}")
    }
    println()
    
    // Задание 8
    println("Задание 8: Работа с матрицей")
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    
    println("Матрица 3x3:")
    matrix.forEach { println(it.joinToString(" ")) }
    
    println("\nСуммы строк:")
    matrix.forEachIndexed { i, row -> println("Строка ${i+1}: ${row.sum()}") }
    
    println("\nСуммы столбцов:")
    for (j in 0..2) {
        val colSum = matrix.sumOf { it[j] }
        println("Столбец ${j+1}: $colSum")
    }
    
    println("\nСумма главной диагонали: ${matrix[0][0] + matrix[1][1] + matrix[2][2]}")
    println()
    
    // Задание 9
    println("Задание 9: Фибоначчи с условиями")
    println("Первые 15 чисел Фибоначчи (делятся на 2 ИЛИ >50 и <200):")
    var a = 0
    var b = 1
    
    for (i in 1..15) {
        val next = a + b
        a = b
        b = next
        
        if (next % 2 == 0 || (next > 50 && next < 200)) {
            println("$next")
        } else {
            continue
        }
    }
    println()
    
    // Задание 10
    println("Задание 10: Валидатор пароля")
    val passwords = listOf(
        "weak",
        "Strong123",
        "Strong123!",
        "Short1!",
        "nouppercase123!",
        "NODIGIT!",
        "GoodPass123!"
    )
    
    passwords.forEach { password ->
        println("\nПроверка пароля: $password")
        val errors = mutableListOf<String>()
        
        if (password.length < 8) errors.add("Длина < 8")
        if (!password.any { it.isDigit() }) errors.add("Нет цифр")
        if (!password.any { it.isUpperCase() }) errors.add("Нет заглавных")
        if (!password.any { it in "!@#$%^&*" }) errors.add("Нет спецсимволов")
        
        if (errors.isEmpty()) {
            println("Корректный пароль")
        } else {
            println("Ошибки: ${errors.joinToString(", ")}")
        }
    }
    println()
    
    // Задание 11
    println("Задание 11: Конвертер времени")
    val seconds = 3661
    println("$seconds секунд = ${seconds / 3600}:${(seconds % 3600) / 60}:${seconds % 60}")
    
    val time = "01:30:25"
    val parts = time.split(":")
    println("$time = ${parts[0].toInt() * 3600 + parts[1].toInt() * 60 + parts[2].toInt()} секунд")
    println()
    
    // Задание 12
    println("Задание 12: Мини-калькулятор выражений")
    val expressions = listOf(
        "12 + 34 - 5 * 2 / 4",
        "10 + 2 * 3",
        "100 / 2 - 25 * 2",
        "8 + 4 / 2"
    )
    
    expressions.forEach { expr ->
        println("\nВычисление: $expr")
        try {
            // Простая реализация калькулятора
            val tokens = expr.split(" ")
            var result = tokens[0].toDouble()
            
            var i = 1
            while (i < tokens.size) {
                val op = tokens[i]
                val num = tokens[i + 1].toDouble()
                
                result = when (op) {
                    "+" -> result + num
                    "-" -> result - num
                    "*" -> result * num
                    "/" -> {
                        if (num == 0.0) throw ArithmeticException("Деление на ноль")
                        result / num
                    }
                    else -> throw IllegalArgumentException("Неизвестная операция")
                }
                i += 2
            }
            println("Результат: $result")
        } catch (e: Exception) {
            println("Ошибка: ${e.message}")
        }
    }
}