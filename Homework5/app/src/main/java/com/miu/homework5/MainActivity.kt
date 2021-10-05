package com.miu.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prob1.setOnClickListener {
            var quizIntent = Intent(this, Quiz::class.java);
            startActivity(quizIntent)
        }
        prob2.setOnClickListener {
            var shopIntent = Intent(this, Shopping::class.java);
            startActivity(shopIntent)
        }
        prob3.setOnClickListener {
            var recycleIntent = Intent(this, RecyclerView::class.java);
            startActivity(recycleIntent)
        }
    }
}