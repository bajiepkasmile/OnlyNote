package com.nodomain.onlynote.utils


import java.util.Calendar


class TimeUtil {

    val currentTime: Long
        get() = Calendar.getInstance().timeInMillis
}