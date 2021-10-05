package com.miu.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_detail.*

class ShoppingDetail : AppCompatActivity() {
    lateinit var strings: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_detail)

        val type = intent.getStringExtra("TYPE")
        supportActionBar?.title = type

        strings = when(type) {
            getString(R.string.str_electronic) -> resources.getStringArray(R.array.arr_electronics)
            getString(R.string.str_clothes) -> resources.getStringArray(R.array.arr_clothes)
            getString(R.string.str_beauty) -> resources.getStringArray(R.array.arr_beauties)
            else -> resources.getStringArray(R.array.arr_foods)
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings)
        list.adapter = adapter
        list.setOnItemClickListener {parent, view, position, id ->
            Toast.makeText(applicationContext, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}