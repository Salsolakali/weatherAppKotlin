/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin.data

import android.util.Log
import java.net.URL

class Request (private val url: String){

    fun run(){
        val forecastJsonStr = URL (url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}
