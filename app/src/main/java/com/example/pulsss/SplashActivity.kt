package com.example.pulsss


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressPercent)

        // Обновление прогресс бара и текста
        val handler = Handler(Looper.getMainLooper())
        val startTime = System.currentTimeMillis()
        val duration = 3000 // 3 секунды

        handler.post(object : Runnable {
            override fun run() {
                val elapsedTime = System.currentTimeMillis() - startTime
                val progress = (elapsedTime * 100 / duration).toInt()
                progressBar.progress = progress
                progressText.text = "$progress%"

                if (elapsedTime < duration) {
                    handler.postDelayed(this, 100)
                } else {
                    // Завершение активности
                    startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
                    finish()
                }
            }
        })
    }
}