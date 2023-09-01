package com.live.farmerapp.others

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.service.controls.actions.ControlAction.TYPE_ERROR
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.live.farmerapp.R
import java.lang.Exception
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus?.windowToken, 0)
    }

    fun dialog(context: Context,title: String, msg: String,positive: String,negative:String){
        val paymentDialog = Dialog(context)

        paymentDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        paymentDialog.setContentView(R.layout.dialog)

        val tvMessage: TextView = paymentDialog.findViewById(R.id.tvMessage)
        val btnYes: AppCompatButton = paymentDialog.findViewById(R.id.btnYes)
        val tvNo: TextView = paymentDialog.findViewById(R.id.tvNo)
        val view: View = paymentDialog.findViewById(R.id.view)

        paymentDialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        paymentDialog.setCancelable(true)
        paymentDialog.setCanceledOnTouchOutside(false)
        paymentDialog.window!!.setGravity(Gravity.CENTER)

        paymentDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvMessage.text = msg

        if (title=="Updated!"){
            view.visibility = View.GONE
        }

        else if (title=="Update"){
            view.visibility = View.GONE
        }

        else{
            view.visibility = View.VISIBLE
        }

        if (negative==""){
            tvNo.visibility = View.GONE
            view.visibility = View.GONE
        }
        else{
            tvNo.text = negative

        }
        btnYes.text = positive

        tvNo.setOnClickListener {
            paymentDialog.dismiss()
        }

        btnYes.setOnClickListener {
            paymentDialog.dismiss()
        }
        paymentDialog.show()
    }

    @JvmStatic
    fun showErrorAlert(context: Activity, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    @JvmStatic
    fun showSuccessAlert(context: Activity, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    @JvmStatic
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    @JvmStatic
    fun showNoInternetAlert(context: Activity, msg: String, listener: OnNoInternetConnectionListener) {
      /*  Alerter.create(context)
            .setTitle(context.getString(R.string.error_))
            .setTitleAppearance(R.style.AlertTextAppearanceTitle)
            .setText(msg)
            .setTextAppearance(R.style.AlertTextAppearanceText)
            .setBackgroundColorRes(android.R.color.holo_red_light)
            *//*  .addButton(context.getString(R.s
            tring.retry), R.style.AlertButton, View.OnClickListener {
                  listener.onRetryApi()
              })*//*
            .show()*/

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    interface OnNoInternetConnectionListener {

        fun onRetryApi()
    }

    fun parseDateToddMMyyyy(dateAndTime: String?, dateFormate: String?): String? {
        val inputPattern = "yyyy-MM-dd'T'HH:mm:ss"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(dateFormate)
        //ne line
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(dateAndTime)
            str = outputFormat.format(date)

            //new line
            outputFormat.timeZone = TimeZone.getDefault()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return str
    }

    fun getFormatedDateTime(dateStr: String?,strReadFormat: String?,strWriteFormat: String?): String? {
        var formattedDate = dateStr
        val readFormat: DateFormat = SimpleDateFormat(strReadFormat, Locale.getDefault())
        val writeFormat: DateFormat = SimpleDateFormat(strWriteFormat, Locale.getDefault())
        var date: Date? = null
        try {
            date = readFormat.parse(dateStr)
        } catch (e: ParseException) {
        }
        if (date != null) {
            formattedDate = writeFormat.format(date)
        }
        return formattedDate
    }
}



