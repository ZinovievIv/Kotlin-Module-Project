class Archives {
    companion object {
        var archives: MutableList<Archive> = mutableListOf()     //Лист где хранятся архивы
        fun viewArchivesList() {                                 //Функция выводящая список архивов
            println("Список архивов: ")
            for (i in this.archives.indices) {
                println("${i+1}.${this.archives[i].name}")
            }
        }

        fun viewNoteList(indexArchive : Int) {
            if (archives.isEmpty()) {
                println("Список заметок пуст")
            } else {
                for (i in Archives.archives[indexArchive].noteList.indices) {
                    println("${i}.${Archives.archives[indexArchive].noteList[i].header}")
                }
            }
        }
    }
}