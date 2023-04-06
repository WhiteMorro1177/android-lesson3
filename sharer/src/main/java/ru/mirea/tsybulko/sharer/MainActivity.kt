package ru.mirea.tsybulko.sharer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    /* ТЗ

        1. Create button, which calls "share dialog" (createChooser on action_send)
        2. One of the choices must be another activity (ShareActivity)

     */

    private val text = "Action_send text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callActionSendIntent(view: View) {
        val actionSendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            text.also { putExtra(Intent.EXTRA_TEXT, it) }
        }
        startActivity(Intent.createChooser(actionSendIntent, "Choose wisely"))
    }


}