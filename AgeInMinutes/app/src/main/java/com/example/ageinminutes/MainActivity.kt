package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View // View is something that is displayed on the screen
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Used to set the view

        // Toast is good to test whether button works
        btnDatePicker.setOnClickListener {
            view->clickDatePicker(view)
//            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }




    }

    fun clickDatePicker(view: View){

        // Get the current date which will be passed to the dialog to show when first opened
        // Note that month is 0-index
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view, selectedYear, selectedMonth, selectedDay ->
//                Toast.makeText(this, "Date Picker Works", Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH) // Note can set other patterns
                val theDate = sdf.parse(selectedDate) //sdf has parse method that turns a string to Date class
                val selectedDateInMinutes = theDate!!.time / 60000 // !! forces the date to be not null
                // Note .time method gives us in milliseconds from 1970
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate!!.time/60000
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

        }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }


}