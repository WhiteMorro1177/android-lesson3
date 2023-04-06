package ru.mirea.tsybulko.favoritebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        // bind components
        val textView = findViewById<TextView>(R.id.textView)
        editText = findViewById(R.id.editText)

        // get value from intent
        // fill text field
        textView.text = "${textView.text} ${intent.getStringExtra(MainActivity::devBookNameKey.get(MainActivity()))}"
    }

    fun returnToMainActivity(view: View) {

        Log.d("CheckValues", editText.text.toString())
        // put value from editText
        // setResult()
        setResult(Activity.RESULT_OK, Intent().apply {
            putExtra(
                MainActivity::userBookNameKey.get(MainActivity()),
                editText.text.toString(),
            )
        })
        // finnish this activity
        finish()
    }
}