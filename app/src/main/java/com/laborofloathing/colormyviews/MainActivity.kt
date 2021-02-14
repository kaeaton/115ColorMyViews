package com.laborofloathing.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.laborofloathing.colormyviews.R.*
import com.laborofloathing.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
                listOf(binding.boxOneText,
                        binding.boxTwoText,
                        binding.boxThreeText,
                        binding.boxFourText,
                        binding.boxFiveText,
                        binding.redButton,
                        binding.yellowButton,
                        binding.greenButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            binding.boxOneText.id -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText.id -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText.id -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText.id -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText.id -> view.setBackgroundResource(android.R.color.holo_green_light)

            //bottom buttons
            binding.redButton.id -> randomBox().setBackgroundResource(color.my_red)
            binding.yellowButton.id -> randomBox().setBackgroundResource(color.my_yellow)
            binding.greenButton.id -> randomBox().setBackgroundResource(color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun randomBox(): View {
        val viewChoices: List<View> =
                listOf(binding.boxOneText,
                        binding.boxTwoText,
                        binding.boxThreeText,
                        binding.boxFourText,
                        binding.boxFiveText)
        return viewChoices.random()
    }
}