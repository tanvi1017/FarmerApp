package com.live.farmerapp.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.live.farmerapp.R
import com.live.farmerapp.core.BaseFragment
import com.live.farmerapp.databinding.FragmentPassbookBinding
import java.util.*


class PassbookFragment : BaseFragment<FragmentPassbookBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()
    }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPassbookBinding {
     return FragmentPassbookBinding.inflate(layoutInflater)
    }
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
            requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val formattedMonth = month + 1 // Correct the month indexing
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