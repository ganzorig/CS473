package com.miu.countdownexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var textIndicator: TextView
    private lateinit var timer: CountDownTimer
    var isRunning = false
    var minutes = 3L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textIndicator = indicator
        timer = createTimer()

        start.setOnClickListener {
            toggle()
        }
    }

    private fun toggle() {
        if(isRunning) {
            stopExercise()
            start.text = "Start"
        } else {
            // using animation framework
            breathe.playAnimation()
            start.text = getString(R.string.str_end)
            timer.start()
        }
    }

    private fun createTimer(): CountDownTimer {
        // 3 minute in millSeconds
        return object: CountDownTimer(3 * 60000, 1000) {
            var sec = 0L
            override fun onTick(ms: Long) {
                isRunning = true
                minutes = TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms))
                sec = TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))

                // update text every tick
                textIndicator.text = "$minutes:$sec"
            }

            override fun onFinish() {
                stopExercise()
            }
        }
    }

    fun stopExercise() {
        breathe.pauseAnimation()
        isRunning = false
        timer.cancel()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }
}