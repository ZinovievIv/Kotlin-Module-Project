import java.util.Scanner

class InputAndChecking {

    companion object {
        private val scanner: Scanner = Scanner(System.`in`)
        fun inputInt(): Int {                               //Функция получающая Int, включая проверку и повторный ввод
            val input: String = scanner.nextLine()
            var outInt: Int = 0
            if (checkInt(input)) {
                outInt = input.toInt()
                return outInt
            } else {
                println("Вы ввели буквенное значение, введите цифру")
                inputInt()
            }
            return outInt
        }


        fun inputString(): String {              //Внесение данных с проверкой пустого значения
            var scan: String = scanner.nextLine()
            while(scan.equals("")) {
                println("Введена пустая строка, введите имя:\n=======================")
                scan = scanner.nextLine()
            }
             return scan
            }


        private fun checkInt(s: String): Boolean {                   //Проверяет введены ли цифры
            return try {
                s.toInt()
                true
            } catch (ex: NumberFormatException) {
                false
            }
        }

        fun String.intOrString(): Any {                 //Функция проверяющая, состоит строка полностью из цифр или нет
            return when(val v = toIntOrNull()) {
                null -> this
                else -> v
            }
        }


        fun isInt(i: String) : Any {                    //Функция возвращает строку в Int или String
            if(i.intOrString() is Int) {
                return  i.toInt()
            } else {
                return i
            }
        }
    }
}