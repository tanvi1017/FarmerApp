package com.live.countrysearch.util.validator

import android.os.Message
import android.provider.Telephony.Carriers.PASSWORD
import android.text.TextUtils
import android.util.Patterns
import android.widget.CheckBox
import com.google.gson.JsonArray
import com.live.countrysearch.util.validator.Validator.Companion.ErrorMessage
import java.util.regex.Pattern
import java.util.regex.Pattern.matches

class Validator() {
    companion object {
        fun String.formatTo(): String {
            if (this.isNotEmpty()) {
                val value = this.toDouble()
                return "%.02f".format(value)
            }
            return ""
        }

        var ErrorMessage = ""
        var instance: Validator? = null
            get() {
                if (field == null) {
                    field = Validator()
                }
                return field
            }
            private set
    }

    //*email id pattern
    private fun isValidEmailId(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }


    fun validateLogin(email: String?, password: String?): Boolean {
        return if (TextUtils.isEmpty(email)) {
            ErrorMessage = "Please enter email address"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ErrorMessage = "Please enter valid email address"
            false
        } else if (TextUtils.isEmpty(password)) {
            ErrorMessage = "Please enter password"
            false
        } else true
    }


    fun validateVerifyOtp(otp: String?): Boolean {
        return if (TextUtils.isEmpty(otp)) {
            ErrorMessage = "Please enter otp"
            false
        } else true
    }

    fun validateForgotPassword(email: String?): Boolean {
        return if (TextUtils.isEmpty(email)) {
            ErrorMessage = "Please enter email"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ErrorMessage = "Please enter valid email address"
            false
        } else true
    }


    fun validateChangePassword(
        oldPassword: String?,
        newPassword: String?,
        confirmPassword: String?
    ): Boolean {
        return if (TextUtils.isEmpty(oldPassword)) {
            ErrorMessage = "Please enter Old Password"
            false
        } else if (TextUtils.isEmpty(newPassword)) {
            ErrorMessage = "Please enter New Password"
            false
        } else if (TextUtils.isEmpty(confirmPassword)) {
            ErrorMessage = "Please confirm password"
            false
        } else if (newPassword != confirmPassword) {
            ErrorMessage = "Passwords should be same"
            false
        } else true

    }
    fun validateEditProfile(

        name: String?,
        email: String?,
        phoneNumber: String?,
        image: String,
    ): Boolean {

     /*   return if (TextUtils.isEmpty(image)) {
            ErrorMessage = "Please select Profile image"
            false
        }
        else */
        return if (TextUtils.isEmpty(name)) {
            ErrorMessage = "Please enter name"
            false
        } else if (TextUtils.isEmpty(email)) {
            ErrorMessage = "Please enter email"
            false
        }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                ErrorMessage = "Please enter valid email address"
                false
        } else if (TextUtils.isEmpty(phoneNumber)) {
            ErrorMessage = "please enter phone"
            false

        }
        else if (!Patterns.PHONE.matcher(phoneNumber).matches()) {
            ErrorMessage = "Please enter valid phone number"
            false

        } else if (phoneNumber!!.length <10||phoneNumber.length> 13) {
            ErrorMessage = "Please enter valid phone number"
            false
        } else true

    }

    fun validateContactUs(
        name: String?,
        email: String?,
        phoneNumber: String?,
        message: String?,

        ): Boolean {
        return if (TextUtils.isEmpty(name)) {
            ErrorMessage = "Please enter name"
            false
        } else if (TextUtils.isEmpty(email)) {
            ErrorMessage = "Please enter email"
            false
        } else if (!email?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }!!) {
            ErrorMessage = "Please enter valid email address"
            false
        } else if (TextUtils.isEmpty(phoneNumber)) {
            ErrorMessage = "Please enter phone number"
            false

        } else if (!phoneNumber?.let { Patterns.PHONE.matcher(it).matches() }!!) {
            ErrorMessage = "Please enter valid phone number"
            false
        } else if ((phoneNumber.length < 10) || (phoneNumber.length > 13)) {
            ErrorMessage = "Please enter valid phone number"
            false
        } else if (TextUtils.isEmpty(message)) {
            ErrorMessage = "please enter message"
            false
        } else true
    }
}

    fun validateVerifyOtp(otp: String?): Boolean {
        return if (TextUtils.isEmpty(otp)) {
            ErrorMessage = "Please enter otp"
            false
        } else true
    }




