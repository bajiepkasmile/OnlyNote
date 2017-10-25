package com.nodomain.onlynote.utils


import java.util.Calendar
import javax.inject.Inject


class TimeUtil @Inject constructor() {

    val currentTime: Long
        get() = Calendar.getInstance().timeInMillis
}