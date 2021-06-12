package subtask3

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass


class Blocks {


    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        lateinit var resstr: Any
        var inres = 0
        when (blockB) {
            String::class -> {
                resstr = ""
                for (item in blockA) {
                    if (item is String) {
                        resstr += item
                    }
                }
            }
            Int::class -> {
                resstr = 0
                for (item in blockA) {
                    if (item is Int) {
                        resstr += (item)
                    }
                }
            }
            LocalDate::class -> {
                var mindate = LocalDate.MIN
                resstr = LocalDate.MIN
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                for (item in blockA) {
                    if (item is LocalDate) {
                        if (item > mindate as LocalDate)
                            mindate = item
                    }
                }
                resstr = formatter.format(mindate)
            }
        }

        return resstr
    }
}
