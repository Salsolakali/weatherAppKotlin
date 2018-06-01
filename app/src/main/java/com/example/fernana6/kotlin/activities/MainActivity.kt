/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fernana6.kotlin.ForecastListAdapter
import com.example.fernana6.kotlin.R
import com.example.fernana6.kotlin.data.Request
import com.example.fernana6.kotlin.domain.commands.RequestForecastCommand

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Guardo la lista en un una variable
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView

        //La añado a la actividad. LinearLayoutManager(this) ya me instancia el objeto
        forecastList.layoutManager = LinearLayoutManager(this)

        //Le paso la lista al adapter
        forecastList.adapter = ForecastListAdapter(items)

        val appId:String = "f5024344f00429240a6bb1a18ee071e9"
        val City:String = "Madrid,ES"

        val url = "http://samples.openweathermap.org/data/2.5/forecast?q=$City&appid=$appId"

        //Hago la llamada asincrona a la API
        doAsync(){
            //Request(url).run()
            val result = RequestForecastCommand("94043").execute()

            uiThread { forecastList.adapter = ForecastListAdapter(result) }
            //Entro aqui cada vez que activity.isFinishing() == true
            runOnUiThread { longToast("Request performed") }

        }

        /**
         * Tambien se podria usar DoAsyncResult en caso de querer retornar un futuro con resultado*/


    }


}
