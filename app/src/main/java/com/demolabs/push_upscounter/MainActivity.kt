package com.demolabs.push_upscounter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.demolabs.push_upscounter.handlers.SensorHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {
    private var sensorEventVal: Float = 0f
    private lateinit var sensorHandler: SensorHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorHandler = SensorHandler(this)
        initControls()
    }

    override fun onResume() {
        super.onResume()
        sensorHandler.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        sensorHandler.onPause(this)
    }

    private fun initControls() {
        btnSensor.setOnClickListener { toggleSensor() }
    }

    private fun toggleSensor() {
        Toast.makeText(this, "Sensor enabled / disabled", Toast.LENGTH_LONG).show()
    }

    override fun onAccuracyChanged(sensor: Sensor?, i: Int) {
        // no-op
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        sensorEventVal = sensorEvent?.values?.get(0) ?: 0f
        proximityValue.text = sensorEventVal.toString()
    }
}
