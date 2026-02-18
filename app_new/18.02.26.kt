class Book(
    val title: String,
    val author: String,
    var year: Int,
    var price: Double
)

class Student(
    val name: String,
    val surname: String,
    var group: String
) {
    val fullName: String
    
    init {
        fullName = "$name $surname"
        println("Создан студент: $fullName, группа: $group")
    }
}

class BankAccount(initialBalance: Double) {
    var balance = initialBalance
        get() = field
        set(value) {
            if (value < 0) {
                println("Ошибка: баланс не может быть отрицательным!")
            } else {
                field = value
            }
        }
    
    // пользовательский геттер для форматированного вывода
    val formattedBalance: String
        get() = "Баланс: $balance ₽"
}

enum class OrderStatus(val description: String) {
    NEW("Новый заказ"),
    PROCESSING("Заказ в обработке"),
    SHIPPED("Заказ отправлен"),
    DELIVERED("Заказ доставлен"),
    CANCELLED("Заказ отменён");
    
    fun isFinished(): Boolean {
        return this == DELIVERED || this == CANCELLED
    }
}

data class Product(
    val id: Int,
    val name: String,
    var price: Double,
    var inStock: Boolean
)

object ProductCatalog {
    private val _products = mutableListOf<Product>()
    
    val products: List<Product>
        get() = _products.toList()
    
    fun addProduct(product: Product) {
        _products.add(product)
    }
    
    fun findById(id: Int): Product? {
        return _products.find { it.id == id }
    }
}


// главная функция
fun main() {
    println("\tзадание 1 мой первый класс классы и свойства")

    task1()
    
    println("\n\tзадание 2 конструктор и инициализация")

    task2()
    
    println("\n\tзадание 3 геттеры и сеттеры")

    task3()
    
    println("\n\tзадание 4 перечисление состояний enum class")

    task4()
    
    println("\n\tзадание 5 объекты и data классы")

    task5()
}

/**
 * решение задания 1
 */
fun task1() {
    // создаем три объекта книг
    val book1 = Book("Война и мир", "Лев Толстой", 1869, 1200.0)
    val book2 = Book("Преступление и наказание", "Федор Достоевский", 1866, 950.0)
    val book3 = Book("Мастер и Маргарита", "Михаил Булгаков", 1967, 1100.0)
    
    // изменяем цену у второй книги
    book2.price = 1050.0
    
    // выводим информацию о всех книгах
    println("Книга: ${book1.title}, Автор: ${book1.author}, Год: ${book1.year}, Цена: ${book1.price}₽")
    println("Книга: ${book2.title}, Автор: ${book2.author}, Год: ${book2.year}, Цена: ${book2.price}₽")
    println("Книга: ${book3.title}, Автор: ${book3.author}, Год: ${book3.year}, Цена: ${book3.price}₽")
}

/**
 * решение задания 2
 */
fun task2() {
    val student1 = Student("Иван", "Петров", "ИС-21")
    val student2 = Student("Анна", "Смирнова", "БИ-32")
    
    println("\nполные имена студентов:")
    println(student1.fullName)
    println(student2.fullName)
}

/**
 * решение задания 3
 */
fun task3() {
    val account = BankAccount(1000.0)
    println(account.formattedBalance)
    
    account.balance = -500.0
    println(account.formattedBalance)
    
    account.balance = 2000.0
    println(account.formattedBalance)
}

/**
 * решение задания 4
 */
fun task4() {
    println("все статусы заказов с описаниями:")
    for (status in OrderStatus.values()) {
        println("${status.name} - ${status.description}")
    }
    
    println("\nзавершённые статусы:")
    val finishedStatuses = OrderStatus.values().filter { it.isFinished() }
    println(finishedStatuses.joinToString(", ") { it.name })
}

/**
 * решение задания 5
 */
fun task5() {
    println("часть а data class")
    val product1 = Product(1, "Ноутбук", 75000.0, true)
    val product2 = Product(1, "Ноутбук", 75000.0, true)
    
    println("сравнение товаров с одинаковыми данными: ${product1 == product2}")
    
    val product3 = product1.copy(price = 80000.0)
    println("оригинал: $product1")
    println("копия с изменённой ценой: $product3")
    
    println("\nчасть б object declaration синглтон")
    val catalog = ProductCatalog
    
    // очищаем каталог перед добавлением на случай повторного запуска
    // простой способ очистить список
    run {
        val field = ProductCatalog::class.java.getDeclaredField("_products")
        field.isAccessible = true
        (field.get(ProductCatalog) as MutableList<*>).clear()
    }
    
    catalog.addProduct(product1)
    catalog.addProduct(Product(2, "Мышь", 2500.0, true))
    catalog.addProduct(Product(3, "Клавиатура", 5000.0, false))
    
    println("все товары в каталоге:")
    catalog.products.forEach { println("  $it") }
    
    val foundProduct = catalog.findById(2)
    println("\nнайденный товар по id 2: $foundProduct")
    
    // проверка поиска несуществующего id
    val notFound = catalog.findById(99)
    println("поиск несуществующего id 99: $notFound")
}