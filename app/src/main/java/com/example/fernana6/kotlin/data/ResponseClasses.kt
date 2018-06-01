/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin.data

class ResponseClasses {

    data class ForecastResult(val city: City, val list: List<Forecast>)

    data class City(val id: Long, val name: String, val coord: Coordinates,
                    val country: String, val population: Int)

    data class Coordinates(val lon: Float, val lat: Float)

    data class Forecast (val dt: Long, val temp: Temperature, val pressure: Float,
                         val humidity: Int, val weather: List<Weather>,
                         val speed: Float, val deg: Int, val clouds: Int,
                         val rain: Float)

    data class Temperature(val day: Float, val min: Float, val max: Float,
                           val night: Float, val eve: Float, val morn: Float)

    data class Weather(val id: Long, val main: String, val description: String,
                       val icon: String)
}