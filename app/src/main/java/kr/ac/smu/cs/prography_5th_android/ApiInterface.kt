package kr.ac.smu.cs.prography_5th_android

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("films")
    fun getMovies() : Call<List<Movie>>

    companion object {



        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}