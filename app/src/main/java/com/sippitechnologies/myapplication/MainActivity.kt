package com.sippitechnologies.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var  listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listview)
        listView.adapter = getAdapter()


    }
    fun getAdapter():ListAdapter
    {
        val list = listOf<Person>(
            Person(R.drawable.ic_globe,"I Speak Hindi,English,Punjabi"," ","first"),
            Person(R.drawable.icon_home,"From Delhi"," ","first"),
            Person(R.drawable.icon_massage,"I like Massage"," ","first"),
            Person(R.drawable.ic_right_arrow,"Licence Number", "100100","second"),
            Person(R.drawable.ic_right_arrow,"Experience","2 years","second")
        )
        val listAdapter = ListAdapter(this,list)

        return  listAdapter
    }

}
