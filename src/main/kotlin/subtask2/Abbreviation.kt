package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var prevLetterOK = true
        var prevLetterId = 0
        for (j in b.indices) {
            if (prevLetterOK) {
                prevLetterOK = false
                for (i in prevLetterId until a.length) {
                    if (a[i].toUpperCase() == b[j]) {
                        prevLetterOK = true
                        prevLetterId = i
                        break
                    }
                }
            } else {
                break
            }
        }

        return if (prevLetterOK) {
            "YES"
        } else {
            "NO"
        }
    }
}
