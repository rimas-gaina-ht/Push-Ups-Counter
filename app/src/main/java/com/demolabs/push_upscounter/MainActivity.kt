package com.demolabs.push_upscounter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initControls()
    }

    private fun initControls() {
        btnSensor.setOnClickListener { toggleSensor() }
    }

    private fun toggleSensor() {
        Toast.makeText(this, "Sensor enabled / disabled", Toast.LENGTH_LONG).show()
    }
}
