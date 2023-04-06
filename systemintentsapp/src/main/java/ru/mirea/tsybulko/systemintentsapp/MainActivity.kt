package ru.mirea.tsybulko.systemintentsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val callData = "tel:89166204524"
    private val browserData = "https://kotlinlang.org/docs/basic-syntax.html"
    private val mapData = "geo:55.749479,37.613944"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickCall(view: View) {
        val callIntent = Intent(Intent.ACTION_DIAL).apply {
            callData.also { data = Uri.parse(it) }
        }
        startActivity(callIntent)
    }

    fun onClickMap(view: View) {
        val mapIntent = Intent(Intent.ACTION_VIEW).apply {
            mapData.also { data = Uri.parse(it) }
        }
        startActivity(mapIntent)
    }

    fun onClickBrowser(view: View) {
        val browseIntent = Intent(Intent.ACTION_VIEW).apply {
            browserData.also { data = Uri.parse(it) }
        }
        startActivity(browseIntent)
    }
}