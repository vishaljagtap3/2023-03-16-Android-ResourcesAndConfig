package com.bitcodetech.resourcesdemo

import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.bitcodetech.resourcesdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mt("onCreate")

        binding.txtInfo.setText(R.string.welcome_message)


        if(lastNonConfigurationInstance != null) {
            val data = lastCustomNonConfigurationInstance as Data
            binding.txtInfo.text = data.data
            mt("Data loaded back")
        }


        val company = resources.getString(R.string.company)
        val bgColor = resources.getColor(R.color.bg_color)
        val cities = resources.getStringArray(R.array.cities)
        for(city in cities) {
            Log.e("tag", city)
        }
        val cityCodes = resources.getIntArray(R.array.city_code)
        val isVisible = resources.getBoolean(R.bool.is_visible)
        val code = resources.getInteger(R.integer.company_code)
        val drawable : Drawable = resources.getDrawable(R.drawable.delivery)

        mt(company)

        loadAppropriateFlag()

        binding.btnSetInfo.setOnClickListener {
            binding.txtInfo.text = binding.edtInfo.text.toString()
        }


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mt("onConfigurationChanged")
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        mt("onRetainCustomNonConfigurationInstance")
        return Data(binding.txtInfo.text.toString())
    }

    inner class Data (val data : String)

    private fun loadAppropriateFlag() {

    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }
}