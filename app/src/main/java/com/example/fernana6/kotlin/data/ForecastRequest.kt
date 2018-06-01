/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin.data

import com.google.gson.Gson
import java.net.URL

class ForecastRequest(private val zipCode: String) {
    /**
     * Esta clase crea la request al servidor
     * */
    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&zip="
        }
    /**
     * Cada vez que ejecuto la funcion, retorno un objeto Gson*/
    fun execute(): ResponseClasses.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ResponseClasses.ForecastResult::class.java)
        }
}