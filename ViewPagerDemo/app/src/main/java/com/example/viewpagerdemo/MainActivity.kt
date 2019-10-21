package com.example.viewpagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val sampleViewPagerAdapter = SampleViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = sampleViewPagerAdapter

    }
}
