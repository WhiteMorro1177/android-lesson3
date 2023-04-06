package ru.mirea.tsybulko.lesson3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvMainActivityInfo: TextView = findViewById(R.id.showDateTextView)
        tvMainActivityInfo.text = "Squared group number: ${25.0.pow(2.0).toInt()}\n" +
                "date: ${this.intent.extras?.get("date")}"
    }
}