package data.datasources.local.impl


import com.nodomain.onlynote.model.Note
import java.util.*


class NoteGenerator {

    companion object {

        private const val CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
        private var nextId: Long = 0
    }

    fun generateNoteList(size: Int) = MutableList(size, { generateNote() })

    private fun generateNote() = Note(nextId++, generateDate(), generateText())

    private fun generateDate(): Date {
        val calendar = Calendar.getInstance()

        val randomHours = (Math.random() * 24).toInt()
        calendar.add(Calendar.HOUR, -randomHours)

        val randomDays = (Math.random() * 100).toInt()
        calendar.add(Calendar.DAY_OF_YEAR, -randomDays)

        return calendar.time
    }

    private fun generateText(): String {
        val sb = StringBuilder()
        val stringLength = generateStringLength()

        for (i in 0..stringLength)
            sb.append(generateRandomChar())

        return sb.toString()
    }

    private fun generateRandomChar(): Char {
        val randomCharIndex = (Math.random() * CHARS.length).toInt() - 1
        return CHARS[randomCharIndex]
    }

    private fun generateStringLength() = (Math.random() * 200).toInt() + 1  //note without text is not allowed
}