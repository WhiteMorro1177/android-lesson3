package ru.mirea.tsybulko.lesson3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onGoButtonClicked(view: View) {
        val secondActivity = Intent(this, SecondActivity::class.java).apply {
            putExtra("date", getDate())
        }
        startActivity(secondActivity)
    }

    private fun getDate(): String {
        val format = "yyyy-MM-dd HH:mm:ss"
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(format)

        val date = LocalDateTime.now().format(formatter)
        return date.toString()

    /*

        val dateInMillis = System.currentTimeMillis()
        val format = "yyyy-MM-dd HH:mm:ss"
        val sdf = SimpleDateFormat(format)
        val dateString: String = sdf.format(Date(dateInMillis))

    */
    }
}