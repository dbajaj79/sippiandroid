package com.sippitechnologies.dateandtimepickerdemo

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    val DEFAULT = "MM-dd-yyyy"
    val SCHEDULE = "MMM dd HH:mm a"
    val MASSAGE = "MMM dd, yyyy"

    val APPOINTENT_SERVER_FORMAT = "yyyy-mm-dd hh:mm:ss"
    //2019-08-29 14:50:20

    val dateFormat = SimpleDateFormat(DEFAULT)
    fun getCurrentDate(): String {

        val formatedDate = dateFormat.format(Date())
        return formatedDate
    }


    fun getListOfDataParts(date: String): ArrayList<String> {
        val formattedDateParts = ArrayList<String>()
        val APPOINTENT_SERVER_FORMAT = "yyyy-MM-dd hh:mm:ss"
        val PATTERN_GET_DATE_ONLY = "dd"
        val dateFormat = SimpleDateFormat(APPOINTENT_SERVER_FORMAT)
        val formattedString = dateFormat.format(Date())
        val appointmentDate = dateFormat.parse(date)
        print("Server Formatted String=${formattedString}")
        print("Appoint Date:=${appointmentDate}")
        dateFormat.applyPattern(PATTERN_GET_DATE_ONLY)
        val dateInNumeric = dateFormat.format(appointmentDate)
        dateFormat.applyPattern("MMM")
        val formatMonth = dateFormat.format(appointmentDate)

        dateFormat.applyPattern("EEEE")


        val formattedDay = dateFormat.format(appointmentDate)
        dateFormat.applyPattern("hh:mm a")
        val timing = dateFormat.format(appointmentDate)
        println("Formatted Date:${dateInNumeric}")
        println("Formatted Month:${formatMonth}")
        println("Formatted Date:${formattedDay}")
        println("Timing : ${timing}")
        formattedDateParts.add(dateInNumeric)
        formattedDateParts.add(formatMonth)
        formattedDateParts.add("$formattedDay at ${timing.toUpperCase()}")
        return formattedDateParts
    }

    fun getFormatedDateForSchduleMassage(calendar: Calendar, format: String = SCHEDULE): String {
        dateFormat.applyPattern(format)
        return dateFormat.format(calendar.time)
    }

    fun getAppointServiceDate(date: String): String {
        val APPOINTENT_SERVER_FORMAT = "yyyy-MM-dd hh:mm:ss"
        val dateFormat = SimpleDateFormat(APPOINTENT_SERVER_FORMAT)
        val serviceDate = dateFormat.parse(date)
        val REQUIRED_FORMAT = "MMM dd, yyyy hh:mm a"
        dateFormat.applyPattern(REQUIRED_FORMAT)
        return dateFormat.format(serviceDate).toUpperCase()


    }

    fun getNextDateDay(numberOfDay: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDay)
        val nextDate = calendar.time
        val formatedDate = dateFormat.format(nextDate)
        return formatedDate
    }

    fun getNextDateDayForScheduleMassage(numberOfDay: Int, format: String = SCHEDULE): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDay)
        val nextDate = calendar.time
        dateFormat.applyPattern(format)
        val formatedDate = dateFormat.format(nextDate)

        return formatedDate
    }

}