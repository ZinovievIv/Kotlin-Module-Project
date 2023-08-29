import InputAndChecking.Companion.inputString
import InputAndChecking.Companion.intOrString
import kotlin.system.exitProcess

open class Screen {
    companion object {
        fun mainScreen() {     // Основное меню после запуска программы
            println("=======================\nМеню: \n0.Выход \n1.Создать архив \n2.Мои архивы" +
                    "\n=======================")
            when (InputAndChecking.inputInt()) {
                0 -> { println("Программа завершила свою работу")
                    exitProcess(1) }
                1 -> {Creation.createArchive()}
                2 -> archivesScreen()
                else -> {println("Введите правильную команду")
                mainScreen()
                }
            }
        }
        private fun archivesScreen() {  //Экран выбора архивов
            Archives.viewArchivesList()
            println("\nВыберите архив или введите '0' для перехода в предыдущее меню")
            val input = InputAndChecking.isInt(inputString())
            if (input is Int) {
                if (input > Archives.archives.size) {
                    println("=======================")
                    println("Неверный номер архива")
                    println("=======================")
                    archivesScreen()
                } else if (input == 0) {
                    mainScreen()
                } else {
                    menuInArchiveScreen(input - 1)
                }
            } else {
                    println("=======================")
                    println("Вы ввели буквенное значение, введите цифру")
                    println("=======================")
                    archivesScreen()
                }
            }
        private fun listNotesScreen(indexArchive: Int) {
            Archives.viewNoteList(indexArchive)
            println("\nВыберите заметку или введите 'Выход' для выхода")
            var input = InputAndChecking.isInt(inputString())
            if (input is Int) {
                if (input > Archives.archives[indexArchive].noteList.size) {
                    println("Неверный номер заметки")
                } else {
                    Note.viewNote(Archives.archives[indexArchive].noteList[input], indexArchive)
                }
            } else {
                if(input.toString().lowercase() == "выход") {
                    archivesScreen()
                } else {
                    println("Ошибка ввода")
                    listNotesScreen(indexArchive)
                }
            }
        }
        fun menuInArchiveScreen(indexArchive: Int) {
            println("=======================\nМеню заметок архива: " +
                    "'${Archives.archives[indexArchive].name}'" +
                    " \n0.Выход \n1.Создать заметку " +
                    "\n2.Посмотреть заметки\n=======================\n")
            when (InputAndChecking.inputInt()) {
                1 -> Archives.archives[indexArchive].noteList.add(Creation.createNote())
                2 -> listNotesScreen(indexArchive)
                0 -> archivesScreen()
            }
            menuInArchiveScreen(indexArchive)
        }

    }
}