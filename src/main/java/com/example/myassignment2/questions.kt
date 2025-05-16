package com.example.myassignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class questions : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions2)

        val questionText = findViewById<TextView>(R.id.questionText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        val questions = listOf(
            "Kotlin is a programming language used for Android development." ,
            "The Earth is flat." ,
            "There's only one planet in the universe" ,
            "Fishes have legs" ,
            "The sun disappears at night."
        )

        val answer = listOf(
            true ,
            true ,
            false ,
            false ,
            false ,
        )

        var currentnumber = 0
        questionText.text = questions[currentnumber]
        feedbackText.text = ""
        var score = 0
        trueButton.setOnClickListener {
            if (feedbackText.text.isEmpty())
                if (answer[currentnumber] == true) {
                    score++
                    feedbackText.text = "correct"
                } else {
                    feedbackText.text = "incorrect"
                }
            falseButton.setOnClickListener {
                if (feedbackText.text.isEmpty()) {
                    if (answer[currentnumber] == false) {
                        score++
                        feedbackText.text = "correct"
                    } else {
                        feedbackText.text = "incorrect"
                    }
                }
            }

            nextButton.setOnClickListener {
                currentnumber++
                if (feedbackText.text.isNotEmpty())
                    if (currentnumber < questions.size) {
                        questionText.text = questions[currentnumber]
                        feedbackText.text = ""
                    } else {
                        val intent = Intent(this , Scores::class.java)
                        intent.putExtra("score" , score)
                        intent.putExtra("Total" , 5)
                        startActivity(intent)
                        finish()
                    }
            }
        }

    }
}
