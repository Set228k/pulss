package com.example.pulsss
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.pulsss.on_boarding_fragments.OnboardingAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnboardingAdapter
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        dotsIndicator = findViewById(R.id.dotsIndicator)
        dotsIndicator.setViewPager2(viewPager)

        nextButton = findViewById(R.id.button)
        nextButton.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < adapter.itemCount - 1) {
                viewPager.setCurrentItem(currentItem + 1, true)
            } else {
                // Добавьте ваш код для действия по завершению онбординга
            }
        }

        viewPager.setPageTransformer { page, position ->
            page.translationX = -position * page.width
            page.alpha = 1 - kotlin.math.abs(position)
        }
    }
}