package ru.mirea.tsybulko.favoritebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

/* ТЗ




*/

class MainActivity : AppCompatActivity() {

    private lateinit var userBookNameTextView: TextView
    private lateinit var launcher: ActivityResultLauncher<Intent>

    val devBookNameKey = "dev_book_name"
    val userBookNameKey = "book_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userBookNameTextView: TextView = findViewById(R.id.userBookTextView)

        val callback: ActivityResultCallback<ActivityResult> =
            ActivityResultCallback { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    userBookNameTextView.text = "${getString(R.string.new_book_name_tv_value)} ${result.data?.getStringExtra(userBookNameKey)}"
                    Log.d("CheckValues", result.data?.getStringExtra(userBookNameKey).toString())
                }
            }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), callback)
    }

    fun callShareActivity(view: View) {
        val intent = Intent(this, ShareActivity::class.java).apply {
            putExtra(devBookNameKey, "Jack The Lantern's curse")
        }
        launcher.launch(intent)
    }
}