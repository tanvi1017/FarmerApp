package com.live.farmerapp.others

import android.content.Context
import android.content.SharedPreferences

object PreferenceFile {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    const val AUTH_TOKEN = "mToken"


    fun saveData(context: Context,key: String,value: String?=null) {
        value?.let {
            sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
            val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
            prefsEditor.putString(key,it)
            prefsEditor.apply()
        }
    }

    fun saveIntData(context: Context, key: String, value: Int) {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
        prefsEditor.putInt(key,value)
        prefsEditor.apply()
    }
    fun saveBoolData(context: Context, key: String, value: Boolean) {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
        prefsEditor.putBoolean(key,value)
        prefsEditor.apply()
    }
    fun <T>savData(context: Context, key: String, value: T) {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
        when(value){
            value as? Int -> (value as? Int)?.let { prefsEditor.putInt(key,it) }
            value as? String -> (value as? String)?.let { prefsEditor.putString(key,it) }
            value as? Boolean -> (value as? Boolean)?.let { prefsEditor.putBoolean(key,it) }

        }
        prefsEditor.apply()
    }

    fun getData(context: Context, key: String): String? {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key,"")
    }
    fun getBooleanData(context: Context, key: String): Boolean {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key,false)
    }

    fun getIntData(context: Context, key: String): Int {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key,0)
    }
    fun clearPreference(context: Context) {
        sharedPreferences = context.getSharedPreferences(CommonKeys.preferenceName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}