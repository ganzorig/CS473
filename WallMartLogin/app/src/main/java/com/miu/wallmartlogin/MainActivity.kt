package com.miu.wallmartlogin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openUrl(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.walmart.com/account/login"))
        startActivity(browserIntent);
    }
}