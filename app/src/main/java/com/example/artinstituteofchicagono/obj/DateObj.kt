package com.example.artinstituteofchicagono.obj

import java.text.SimpleDateFormat
import java.util.*

object DateObj {


    fun Date.formatToString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

}