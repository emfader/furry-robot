package com.festapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class CreateEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)
    }

    /* Creator: Ankur
     */
    fun createEvent(view: View) {
        val eventName = (findViewById<EditText>(R.id.event_name_text_)).text
        Toast.makeText(this, eventName, Toast.LENGTH_SHORT).show()
    }

    /* Pick date from GUI */
    @Suppress("NAME_SHADOWING")
    fun pickDate(view: View) {
        val eventDate = (findViewById<TextView>(R.id.event_date_text_))
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

        val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    val date = "" + dayOfMonth + " " + months[monthOfYear] + " " + year
                    eventDate.text = date
                },
                year,
                month,
                day
        )
        dpd.show()
    }

    /* Pick time from GUI */
    @SuppressLint("SimpleDateFormat")
    fun pickTime(view: View) {
        val eventTime = (findViewById<TextView>(R.id.event_time_text_))
        val cal = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener {
            _, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            eventTime.text = SimpleDateFormat("HH:mm").format(cal.time)
        }

        eventTime.setOnClickListener {
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }
}