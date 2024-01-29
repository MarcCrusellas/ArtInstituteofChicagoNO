package com.example.artinstituteofchicagono.obj

import org.json.JSONException
import org.json.JSONObject

object json {

    fun parse(json: String): JSONObject? {
        var jsonObject: JSONObject? = null
        try {
            jsonObject = JSONObject(json)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return jsonObject
    }




}