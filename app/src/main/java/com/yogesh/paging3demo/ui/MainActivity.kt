package com.yogesh.paging3demo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yogesh.paging3demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        clickEvents()
    }

    private fun clickEvents() {
        activityMainBinding.oneBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, OneActivity::class.java))
        }
    }
}