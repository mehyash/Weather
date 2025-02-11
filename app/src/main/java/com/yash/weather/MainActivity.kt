package com.yash.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.yash.weather.databinding.ActivityMainBinding
import com.yash.weather.databinding.ActivityMainScreemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.TimeZone
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var weathertypes=Weathertypes()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ssearchbtn.setOnClickListener{
            var city=binding.cityfld.text.toString()
            api_city_search(city)
        }
    }
    fun api_city_search(city:String){
        ApiService.call(city).enqueue(object : Callback<WeatherDataResponse> {
            override fun onResponse(call: Call<WeatherDataResponse>, response: Response<WeatherDataResponse>) {
                val t = response.body()
                if (t != null) {
                    Log.d("TEMP", t.main.temp.toString())
                    Log.d("SUNSET", t.sys.sunset.toString())
                    Log.d("SUNRISE", t.sys.sunrise.toString())
                    Log.d("VISBILITY", t.visibility.toString())
                    Log.d("WIND SPEED", t.wind.speed.toString())
                    Log.d("PRESSURE", t.weather[0].description.toString())
                }
                binding.city.text=city
                var temp = t?.main?.temp.toString()
                var sunset = t?.sys?.sunset.toString()
                var sunrise = t?.sys?.sunrise.toString()
                var visbility = t?.visibility.toString()
                val windspeed = t?.wind?.speed.toString()
                val pressure = t?.main?.pressure.toString()
                val typ= t?.sys?.type.toString()
                temp = (temp.toFloat() - 273.15).toInt().toString()
                visbility = (visbility.toFloat() / 1000).toString()
                sunset=convertTimestampToIST(sunset.toLong())
                sunrise=convertTimestampToIST((sunrise.toLong()))
                binding.temp.text= "$temp˙C"
                binding.sunset.text=sunset.toString()
                binding.sunrise.text=sunrise.toString()
                binding.pressure.text=pressure+" mb"
                binding.windSpeed.text=windspeed.toString()
                binding.visibility.text=visbility+" km"
                if (t != null) {
                    if (t.weather[0].description.toString().lowercase() in weathertypes.atmospheretpe){
                       binding.main.setBackgroundResource(R.drawable.rain_background)
                    }
                    else if(t.weather[0].description.toString().lowercase() in weathertypes.raintype){
                        binding.main.setBackgroundResource(R.drawable.rain_background)
                    }
                    else if(t.weather[0].description.toString().lowercase() in weathertypes.cloudtype){
                        binding.main.setBackgroundResource(R.drawable.cloudy_bg)
                    }
                    else if(t.weather[0].description.toString().lowercase() in weathertypes.snowtype){
                        binding.main.setBackgroundResource(R.drawable.snow_background)
                    }
                    else if(t.weather[0].description.toString().lowercase() in weathertypes.thunderstormtype){
                        binding.main.setBackgroundResource(R.drawable.thunderstorm_bg)
                    }
                    else if(t.weather[0].description.toString().lowercase() in weathertypes.drizzle){
                        binding.main.setBackgroundResource(R.drawable.drizzle_bg)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherDataResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"NO INTERNET CONNECTION",Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun convertTimestampToIST(timestamp: Long): String {
        // Convert the timestamp to milliseconds (if it is in seconds)
        val milliseconds = timestamp * 1000

        // Create a Date object from the timestamp
        val date = Date(milliseconds)

        // Set up a SimpleDateFormat with the desired date format
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        // Set the time zone to IST
        sdf.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        // Format the date into a readable string
        return sdf.format(date)
    }
    public fun requestPermission(view:View) {

    }

}