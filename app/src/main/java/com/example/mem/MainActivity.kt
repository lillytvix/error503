package com.example.mem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Picasso.get().isLoggingEnabled = true
        setContentView(R.layout.activity_main)
        show(MemsFragment())
    }


    private fun show( fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout, fragment)
            .commit()
    }
}
