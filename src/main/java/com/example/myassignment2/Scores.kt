package com.example.myassignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class Scores : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val score = intent.getIntExtra("score" , 0)
        // Default to 0 if
        val totalScoreText: TextView = findViewById(R.id.totalScore)
        val feedBackText: TextView = findViewById(R.id.feedbackText)
        val reviewButton: Button = findViewById(R.id.reviewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        totalScoreText.text = "Your score: $score/ 5"

        feedBackText.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practicing"
        }
        reviewButton.setOnClickListener {
            // optionally go back to questions or show a review screen
            val intent = Intent(this , Scores::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            // Exit the app or close this activity
            finishAffinity()
            // close all activities and exits app
        }
    }
}