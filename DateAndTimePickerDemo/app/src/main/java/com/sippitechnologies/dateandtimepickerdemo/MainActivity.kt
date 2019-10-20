package com.sippitechnologies.dateandtimepickerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sippitechnologies.dateandtimepickerdemo.databinding.ActivityMainBinding
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*

class MainActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {

        val ampm = if(hourOfDay<12)"AM" else "PM"
        val hours = if(hourOfDay>12) "${hourOfDay-12}" else "$hourOfDay"
        val time = "$hours:$minute $ampm"
        dataBinding.tvTime.text = time

    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR,year)
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
        calendar.set(Calendar.MONTH,monthOfYear)
            dataBinding.tvDate.text =
            DateUtil.getFormatedDateForSchduleMassage(calendar, DateUtil.MASSAGE)

    }

    lateinit var dataBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        dataBinding.onClickListener = MainActivtiyClickListener()
    }
    inner class MainActivtiyClickListener : View.OnClickListener
    {
        override fun onClick(p0: View?) {
            when(p0?.id)
            {
                R.id.btn_date-> showDatePickerDialog()
                R.id.btn_time-> showTimePickerDialog()

            }

        }

    }

    fun showDatePickerDialog()
    {
        val calendar:Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month= calendar.get(Calendar.MONTH)
        val dayofMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog.newInstance(this,year,month,dayofMonth)
        datePickerDialog.minDate = calendar
        datePickerDialog.show(this.supportFragmentManager!!,"DatePicker")


    }

        fun showTimePickerDialog()
        {
            val calendar= Calendar.getInstance()
            var hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
            val min = calendar.get(Calendar.MINUTE)
            hourOfDay+=1;
            val timeDailog = TimePickerDialog.newInstance(this,hourOfDay,min,false)

            timeDailog.setTimeInterval(1,10)
            timeDailog.show(this.supportFragmentManager!!,"TimePicker")

    }
}
