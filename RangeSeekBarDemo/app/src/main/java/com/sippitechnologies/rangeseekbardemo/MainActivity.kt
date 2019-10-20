package com.sippitechnologies.rangeseekbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar

class MainActivity : AppCompatActivity() {

    lateinit var rangeSeekBar:CrystalRangeSeekbar
    lateinit var maxvalueTextView: TextView
    lateinit var minvalueTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rangeSeekBar = findViewById(R.id.crystalRangeSeekbar)
        maxvalueTextView= findViewById(R.id.tv_max);
        minvalueTextView = findViewById(R.id.tv_min)
        rangeSeekBar.setMaxStartValue(299.99f).apply()
        rangeSeekBar.setMinValue(39.99f)
        rangeSeekBar.setMaxValue(449.99f)
        rangeSeekBar.setMinStartValue(79.99f).apply()


        rangeSeekBar.setOnRangeSeekbarChangeListener(OnRangeSeekbarChangeListener { minValue, maxValue ->
            maxvalueTextView.text = "\$ $maxValue"
            minvalueTextView.text = "\$ $minValue"

        })
    }
}
