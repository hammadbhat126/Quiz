package com.kashsoft.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        val  questionList = Constants.getQuestions()
        Log.i("Question Size" , "${questionList.size}")

      val currentPostion = 1
        val question: Question? = questionList[currentPostion -1]

      progress_bar.progress = currentPostion
        tv_progress.text = "$currentPostion" + "/" + progress_bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        option_one.text= question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text= question.optionFour



    }
}