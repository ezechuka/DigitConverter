package com.javalon.digitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezechuka.digitconverter.DigitConverter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DigitConverter.asWords(5000)
    }
}