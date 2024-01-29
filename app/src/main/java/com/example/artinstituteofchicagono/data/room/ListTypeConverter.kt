package com.example.artinstituteofchicagono.data.room

import androidx.room.TypeConverter
import java.util.*

class ListTypeConverter {
    @TypeConverter
    fun fromList(valorTypeConverter:  List<String> ): String{
        if (valorTypeConverter.isEmpty()){
            return ""
        }
        return valorTypeConverter.toString()
    }

    @TypeConverter
    fun fromString(valor : String): List<String>{
        return valor.split(",")
    }




}
