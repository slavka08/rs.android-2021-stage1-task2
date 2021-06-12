package subtask1

import java.util.*
import java.util.Locale


class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        var resultString = ""
        if (!CheckDateForValid(day, month, year)) {
            resultString = "Такого дня не существует"
        } else {
            val timezone = TimeZone.getDefault()

            val calendar: Calendar = GregorianCalendar(timezone)
            calendar.isLenient = false
            calendar.set(year.toInt(), month.toInt() - 1, day.toInt())
            val monthName = calendar.getDisplayName(
                Calendar.MONTH,
                Calendar.LONG,
                Locale.forLanguageTag("ru")
            ) //Locale.US);

            val dayName = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.LONG,
                Locale.forLanguageTag("ru")//getDefault()
            ) //Locale.US);
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            resultString = "$day $monthName, $dayName"
        }
        return resultString
    }

    fun CheckDateForValid(day: String, month: String, year: String): Boolean {
        var result = true
        val timezone = TimeZone.getDefault()
        val calendar: Calendar = GregorianCalendar(timezone)
        calendar.isLenient = false
        calendar.set(year.toInt(), month.toInt() - 1, day.toInt())
        var monthName = ""
        var dayName = ""
        try {
            calendar.time
        } catch (e: Exception) {
             result = false
        }
        return result
    }
}
