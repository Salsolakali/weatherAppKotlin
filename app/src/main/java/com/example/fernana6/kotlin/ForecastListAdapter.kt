/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.fernana6.kotlin


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView


class ForecastListAdapter (private val items: List<String>):
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder?{
        return ViewHolder(TextView(parent.getContext()))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.textView.text = items[position]

        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
            }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder (val textView: TextView) : RecyclerView.ViewHolder(textView)


}