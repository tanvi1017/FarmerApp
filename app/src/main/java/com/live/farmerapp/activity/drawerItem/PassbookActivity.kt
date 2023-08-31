package com.live.farmerapp.activity.drawerItem

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.live.farmerapp.R
import com.live.farmerapp.activity.MainActivity
import com.live.farmerapp.databinding.ActivityPassbookBinding
import java.util.*

class PassbookActivity : AppCompatActivity() {
    companion object{
        fun launch(activity: Activity){
            val intent = Intent(activity, PassbookActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private lateinit var binding:ActivityPassbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPassbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
    }
//    private fun onClicks(){
//        binding.ivDateFrom.setOnClickListener {
//            pickUpDate()
//        }
//        binding.ivDateUpto.setOnClickListener {
//            pickUpDate()
//        }
//    }
    private fun onClicks() {
        binding.ivDateFrom.setOnClickListener {
            pickUpDate(binding.edtDateFrom)
        }
        binding.ivDateUpto.setOnClickListener {
            pickUpDate(binding.edtDateUpto)
        }
    }

    private fun pickUpDate(editText: EditText) {
        val today = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val formattedMonth = month + 1
                val selectedDate = "$dayOfMonth/$formattedMonth/$year"
                editText.setText(selectedDate)
            },
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        )

        datePicker.show()
    }
    }
