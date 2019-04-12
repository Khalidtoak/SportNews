package com.example.sportnews.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sportnews.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(HomeFrag())
                Toast.makeText(this,"Latest Sport News...",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_saved -> {
                replaceFragment(SavedNews())
                Toast.makeText(this,"Saved Sport News...",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                replaceFragment(favorite_frag())
               Toast.makeText(this,"Favorite Sport News..",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFrag())

        //hides refresh button while data is loading
        // refresh_button.visibility = View.INVISIBLE

    }
    private fun replaceFragment(frag:Fragment){
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.replace(R.id.frag_container,frag)
        fragTransaction.commit()
    }
    private fun hideView(view: View){
        view.visibility = View.INVISIBLE
    }
    private fun showView(view:View){
        view.visibility = View.VISIBLE
    }
}
