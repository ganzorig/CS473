package com.miu.wallmartlogin

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    fun openUrl(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.walmart.com/account/login"))
        startActivity(browserIntent);
    }
}