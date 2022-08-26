package com.example.latihanlayoutcollaborationgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(UntukAndaFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.untuk_anda -> {
                    loadFragment(UntukAndaFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.judul -> {
                    loadFragment(JudulFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.favorite -> {
                    loadFragment(FavoriteFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.kios -> {
                    loadFragment(KiosFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}