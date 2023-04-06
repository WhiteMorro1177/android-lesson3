package ru.mirea.tsybulko.simplefragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    // create fragment manager
    private lateinit var fragmentManager: FragmentManager

    // create fragments
    private lateinit var firstFragment: Fragment
    private lateinit var secondFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init components
        fragmentManager = supportFragmentManager

        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
    }

    fun callFirstFragment(view: View) {
        fragmentManager.beginTransaction().replace(R.id.frameLayout, firstFragment).commit()
    }
    fun callSecondFragment(view: View) {
        fragmentManager.beginTransaction().replace(R.id.frameLayout, secondFragment).commit()
    }
}