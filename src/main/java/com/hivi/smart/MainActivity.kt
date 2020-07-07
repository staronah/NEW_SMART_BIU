package com.hivi.smart

import android.os.Bundle
import android.os.Message
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hivi.smart.Fragments.*

class MainActivity : AppCompatActivity() {




    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_dashboard -> {
                movetoFragment(DasboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_timetable -> {
                movetoFragment(TimetableFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_lib -> {
                movetoFragment(LibFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {
                movetoFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_chat -> {
                movetoFragment(ChatFragment())
                return@OnNavigationItemSelectedListener true
            }
        }


        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

       movetoFragment(DasboardFragment())

    }

    private fun movetoFragment(fragment: Fragment)
    {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }
}
