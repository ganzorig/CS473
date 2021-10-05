package com.miu.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*
import java.text.SimpleDateFormat
import java.util.*

class Quiz : AppCompatActivity() {
    private val rightAnsers = hashMapOf<String, Int>()
    private val chosen = hashSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.title = "Quiz application"

        rightAnsers[getString(R.string.ans1)] = 50
        rightAnsers[getString(R.string.q2ans1)] = 25
        rightAnsers[getString(R.string.q2ans2)] = 25
        rightAnsers[getString(R.string.q2ans3)] = -25

        radio.setOnCheckedChangeListener { group, checkedId ->
            val clicked = group.findViewById(checkedId) as RadioButton
            if (clicked.isChecked) {
                if(clicked.text.toString() == getString(R.string.ans1)) {
                    chosen.add(clicked.text.toString())
                } else {
                    chosen.remove(getString(R.string.ans1))
                }
            }
        }

        checkBox1.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans1)
        }

        checkBox2.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans2)
        }

        checkBox3.setOnCheckedChangeListener { view, isChecked ->
            toggleAnswer(isChecked, R.string.q2ans3)
        }

        btn_submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("“Congratulations!")
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            builder.setMessage("""
                Submission date: $currentDate
                Your achieved: ${calcPoint()}
            """.trimIndent())
            builder.setPositiveButton("Close"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        btn_reset.setOnClickListener {
            var checkedButton = findViewById<RadioButton>(radio.checkedRadioButtonId);
            if (checkedButton.isChecked) checkedButton.isChecked = false
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            chosen.clear()
        }
    }

    private fun toggleAnswer(isChecked: Boolean, ans: Int) {
        if (isChecked) {
            chosen.add(getString(ans))
        } else {
            chosen.remove(getString(ans))
        }
    }

    private fun calcPoint():Int {
        var points = 0;
        for (item in chosen) {
            if (rightAnsers.containsKey(item)) {
                points += rightAnsers[item]!!
            }
        }
        return points;
    }
}