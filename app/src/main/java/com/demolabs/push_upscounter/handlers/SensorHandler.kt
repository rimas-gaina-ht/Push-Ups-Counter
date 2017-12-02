package com.demolabs.push_upscounter.handlers

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager

/**
 * Created by rgaina on 02/12/2017.
 */
class SensorHandler(context: Context) {
    private var sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var proximity: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

    fun onResume(listener: SensorEventListener) {
        sensorManager.registerListener(listener, proximity, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun onPause(listener: SensorEventListener) {
        sensorManager.unregisterListener(listener)
    }
}
