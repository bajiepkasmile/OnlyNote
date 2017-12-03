package data.datasources.local


import com.nodomain.onlynote.model.Note
import java.util.*


class NoteGenerator {

    companion object {

        private const val CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    }

    fun generateNotes(size: Int) = MutableList(size, { generateNote() })

    private fun generateNote() = Note(generateDate(), generateText())

    private fun generateDate(): Date {
        val calendar = Calendar.getInstance()

        val randomHourCount = (Math.random() * 24).toInt()
        calendar.add(Calendar.HOUR, -randomHourCount)

        val randomDayCount = (Math.random() * 100).toInt()
        calendar.add(Calendar.DAY_OF_YEAR, -randomDayCount)

        return calendar.time
    }

    private fun generateText(): String {
        val sb = StringBuilder()
        val stringLength = (Math.random() * 200).toInt() + 1  //note without text is not allowed

        for (i in 0..stringLength)
            sb.append(generateRandomChar())

        return sb.toString()
    }

    private fun generateRandomChar(): Char {
        val randomCharIndex = (Math.random() * CHARS.length).toInt() - 1
        return CHARS[randomCharIndex]
    }
}