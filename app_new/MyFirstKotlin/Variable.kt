fun main() {
    task2()
    task3()
    task4()
}

fun task2() {
    val name: String = "Александр"
    var age: Int = 17
    println("Меня зовут $name, мне $age лет.")
    age += 1
    println("Через год мне будет $age лет.")
}

fun task3() {
    val hexNumber: Int = 0xFF
    val binaryNumber: Int = 0b1010
    val longNumber: Long = 100_000L
    val floatNumber: Float = 3.14F

    println("Hex: $hexNumber, Binary: $binaryNumber, Long: $longNumber, Float: $floatNumber")
}

fun task4() {
    val isSunny = true
    val isRainy = false

    # Первый результат - False, потому что оба условия должны быть истинными
    println("isSunny && isRainy = ${isSunny && isRainy}")
    println("isSunny || isRainy = ${isSunny || isRainy}")
    println("!isRainy = ${!isRainy}")
} 