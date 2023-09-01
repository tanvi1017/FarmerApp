package com.live.farmerapp.others

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.live.farmerapp.restApi.RestApiInterface
import com.live.farmerapp.restApi.ServiceGenerator


class MyApplication: Application() {

    var preferences: SharedPreferences? = null
    private var prefToken: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var editorToken: SharedPreferences.Editor? = null

    private var lifecycleHandler: AppLifeCycleHandler? = null
    override fun onCreate() {
        super.onCreate()

      //  instance = this

      //  FacebookSdk.sdkInitialize(getApplicationContext())
//        AppEventsLogger.activateApp(this)


        instance = this
        initializePreferences()
        initializePreferencesToken()
    }

    var restApiInterface: RestApiInterface? = null
    fun provideAuthservice(): RestApiInterface {
        return if (restApiInterface == null) {
            restApiInterface = ServiceGenerator.createService(RestApiInterface::class.java)
            restApiInterface!!
        } else {
            restApiInterface!!
        }

    }

    fun checkIfHasNetwork(): Boolean {
        val cm =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    private fun initializePreferences() {
        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editor = preferences!!.edit()
    }

    private fun initializePreferencesToken() {
        prefToken = getSharedPreferences(
            PREF_TOKEN,
            Context.MODE_PRIVATE
        )
        editorToken = prefToken!!.edit()
    }

    fun setString(key: String?, value: String?) {
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun getString(key: String?): String? {
        return preferences!!.getString(key, "")
    }

    fun setInt(key: String?, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun getInt(key: String?): Int {
        return preferences!!.getInt(key, 0)
    }

    fun clearData() {
      editor!!.clear().commit()
    }

    companion object {
        val TAG = MyApplication::class.java.simpleName
        private val PREF_NAME = "pavePro"
        var instance: MyApplication? = null
            private set
        const val PREF_TOKEN = "TruTraits"
        fun hasNetwork(): Boolean {
            return instance!!.checkIfHasNetwork()
        }
        fun getnstance(): MyApplication {
            return instance!!
        }

    }

    private fun registerLifecycleHandler(lifecycleHandler: AppLifeCycleHandler) {
        registerActivityLifecycleCallbacks(lifecycleHandler)
        registerComponentCallbacks(lifecycleHandler)
    }
}