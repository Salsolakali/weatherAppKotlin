/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin.domain.mappers

import com.example.fernana6.kotlin.Forecast
import com.example.fernana6.kotlin.ForecastListAdapter
import com.example.fernana6.kotlin.data.ResponseClasses
import com.example.fernana6.kotlin.domain.model.DomainClasses
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country,
                    convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>)
            : List<ModelForecast> {
        return list.mapIndexed{i,forecast->
            val dt = Calendar.getInstance().timeInMillis+
                    TimeUnit.DAYS.toMillis(i.toLong())
                    convertForecastListToDomain(forecast.copy(dt=dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }
     private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
        }
    }


}