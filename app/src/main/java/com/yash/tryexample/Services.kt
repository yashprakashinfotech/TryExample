package com.yash.tryexample

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// https://devemcapi.azurewebsites.net/api/v1/users/GetMyAttachemnts

const val BASE_URL = "https://devemcapi.azurewebsites.net/api/"
const val Token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjcwNjUyYTViLTY5OWUtNDNhOS05YzU0LTc1NDJjM2U5ZTJmNCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJtaGFycnNoYUBnbWFpbC5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL2FjY2Vzc2NvbnRyb2xzZXJ2aWNlLzIwMTAvMDcvY2xhaW1zL2lkZW50aXR5cHJvdmlkZXIiOiJBU1AuTkVUIElkZW50aXR5IiwibmJmIjoxNjQxMjg3NTQwLCJleHAiOjE2NDI0OTcxNDAsImlzcyI6Imh0dHBzOi8vZGV2ZW1jYXBpLmF6dXJld2Vic2l0ZXMubmV0IiwiYXVkIjoiRW5yaWNoU2VydmVyMTIzIn0.WVxqSoEUR6o5z4is6QRKpU_mvlJ2_unl-_cKWxkJ4VA"

interface TryInterface{


    @GET("v1/users/GetMyAttachemnts")
    fun getData() : Call<AttachmentData>

}

object Services {

    val tryInstance: TryInterface

    init {

         val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("Authorization", Token)
                    builder.header("DeviceId","testpostman")
                    builder.header("DeviceType", "1")
                    builder.header("IPAddress", "10.10.10.10")
                    builder.header("DeviceDetail", "testing from postman")
                    builder.header("Browser", "chrome")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        tryInstance = retrofit.create(TryInterface::class.java)
//        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(httpClient).build()
//        okHttpClient.interceptors()

    }



}