package com.live.farmerapp.restApi

import android.util.Log
import com.google.gson.GsonBuilder
import com.live.countrysearch.util.Constant
import okhttp3.*
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ServiceGenerator {
    private val httpClient = OkHttpClient.Builder()
        .readTimeout((5 * 60).toLong(), TimeUnit.SECONDS)
        .connectTimeout((5 * 60).toLong(), TimeUnit.SECONDS)
        .writeTimeout((5 * 60).toLong(), TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        //.addInterceptor(provideHeaderInterceptor())
        .addInterceptor(ForbiddenInterceptor())
        .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT)).build()

    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .create()

    private val builder = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    @JvmStatic
    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = getRetrofit()
        return retrofit.create(serviceClass)
    }

    @JvmStatic
    fun getRetrofit(): Retrofit {
        return builder.client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setPrettyPrinting().create()))
            .build()
    }

    class ForbiddenInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val response: Response = chain.proceed(request)
         /*   if (response.code == 403) {
                if (!TextUtils.isEmpty(MyApplication.instance!!.getString(
                        Constants.AuthKey))) {

                            MyApplication.getnstance().clearData()

                    val intent = Intent(MyApplication.getnstance(), LoginFacebookGoogleActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    MyApplication.getnstance().startActivity(intent)
                    CommonMethods.backgroundThreadShortToast(
                        MyApplication.getnstance(),
                        "Session Expired!"
                    )
                }
            }*/
            Log.d("ServiceGenerator", "response :=> $response")
            return response
        }
    }
}


