package com.miu.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity(), ListAdapter.ItemClickListener {
    val products = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        supportActionBar?.title = "Electronics Category"

        products.add(Product("Fire HD 10 tablet", 64.00, "Red & Black", R.drawable.image1, "#5123142", "Fast and responsive - powerful octa-core processor and 3 GB RAM. 50% more RAM than previous generation.\n" +
                "Long-lasting 12-hour battery and 32 or 64 GB internal storage. Add up to 1 TB with microSD (sold separately).\n" +
                "Brighter display - Vivid 10.1\" 1080p Full HD display is 10% brighter than previous generation, with more than 2 million pixels."))
        products.add(Product("HP Stream 11.6-inch HD Laptop", 429.00, "Red & Gray", R.drawable.image2, "#6123142", "STUDY, STREAM, SHARE: Between home, school and work, you need a PC that won't quit. Post, play and stay productive all day with the affordable and portable HP Stream 11\n" +
                "KEEP YOUR PROJECTS SAFE: Experience peace of mind that comes with the most secure Windows ever built with Office, Microsoft Edge, Bing Search, Windows Defender and more\n" +
                "OFFICE 365 FOR ONE YEAR: Get full access to Microsoft Excel, Word, PowerPoint, OneNote, Access, and 1 TB of OneDrive Storage for one year"))
        products.add(Product("Fire 7 Kids Tablet", 74.00, "Blue & Pink", R.drawable.image3, "#7123142", "2-year worry-free guarantee: if it breaks, return it and we'll replace it for free.\n" +
                "Over 20 million kids (and their parents) have enjoyed Amazon Kids (FreeTime) service. Amazon Kids parental controls allow you to set educational goals, create time limits, and filter content."))
        products.add(Product("Amazon Fire TV 65\"", 332.00, "Black & Silver", R.drawable.image4, "#8123142", "Cinematic 4K entertainment - Get true-to-life picture quality and rich, brilliant colors with support for 4K Ultra HD, Dolby Vision, HDR 10, HLG, and Dolby Digital Plus, and control the TV hands-free with Alexa.\n" +
                "HDR like you've never seen - Dolby Vision brings spectacular color, contrast, clarity, and brightness to your screen.\n" +
                "Hands-free TV with Alexa - With built-in microphones, just ask to turn on the TV, and find, launch, and control content, no remote needed.\n" +
                "Watch what you want - Stream over 1 million movies and TV episodes. Watch favorites with subscriptions to Netflix, Prime Video, Disney+, and more.\n" +
                "All your entertainment in one place - Watch live and free TV, play video games, and stream music."))
        products.add(Product("RCA Newest Tablet ", 89.00, "Black", R.drawable.image5, "#9123142", "Vibrant 10.1” 1080p Full HD display and powerful performance thanks to 3 GB of RAM and an octa-core processor."))
        products.add(Product("SAMSUNG Galaxy Tab S7", 135.00, "White", R.drawable.image6, "#2123142", "SAMSUNG Galaxy Tab S7"))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ListAdapter(products, this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        val detailIntent = Intent(applicationContext, ProductDetail::class.java)
        detailIntent.putExtra("PRODUCT", products[position])
        startActivity(detailIntent)
    }
}