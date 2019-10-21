package com.sippitechnologies.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.widget.ImageView


class ListAdapter(context: Context,list:List<Person>) : BaseAdapter()
{
    var  list:List<Person>
    var context:Context

    init {
        this.list = list
        this.context = context
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var v = convertView
        val type = getItemViewType(position)
        if (v == null) {
            // Inflate the layout according to the view type
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (type == 0) {
                // Inflate the layout with image
                v = inflater.inflate(R.layout.layout_row_first, parent, false)
            } else {
                v = inflater.inflate(R.layout.layout_row_second, parent, false)
            }
        }
        //
        val c = list.get(position)

        val title = v!!.findViewById(R.id.tv_title) as TextView
        val icon = v.findViewById(R.id.iv_icon) as ImageView
        icon.setImageResource(c.icon)
        if (type == 0) {

           title.text=c.title
        }
        else
        {
          title.text = c.title
            val description = v.findViewById(R.id.tv_description) as TextView
           description.text = c.description
        }



        return v


    }

    override fun getItem(position: Int): Person {

        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(list.get(position).type.equals("first"))0 else 1
    }
    override fun getViewTypeCount(): Int {
        return 2
    }

}