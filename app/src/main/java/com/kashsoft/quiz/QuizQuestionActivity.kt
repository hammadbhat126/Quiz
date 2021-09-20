package com.kashsoft.quiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

private var mcurrentPostion:Int =1
    private var mQuestionList: ArrayList<Question>?  = null
    private var mSelectedOptionPostion: Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mQuestionList = Constants.getQuestions()
        // calling setquestion
        setQuestion()

       option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion(){


        val question = mQuestionList!! [mcurrentPostion-1]

        defaultOptionsView()

        if (mcurrentPostion == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        progress_bar.progress =mcurrentPostion
        tv_progress.text = "mcurrentPostion" + "/" + progress_bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        option_one.text= question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text= question.optionFour

    }

  private fun defaultOptionsView(){
      val options =ArrayList<TextView>()
      options.add(0,option_one)
      options.add(1,option_two)
      options.add(2,option_three)
      options.add(3,option_four)


      for (option in options){
          option.setTextColor(Color.parseColor("#7a8089"))
          option.typeface = Typeface.DEFAULT
          option.background = ContextCompat.getDrawable(this,
              R.drawable.default_option_border_bg)
      }


  }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.option_one -> {
                selectedOptionView(option_one, 1)
            }
            R.id.option_two -> {
                selectedOptionView(option_two, 2)
            }
            R.id.option_three -> {
                selectedOptionView(option_three, 3)
            }
            R.id.option_four -> {
                selectedOptionView(option_four, 4)
            }
            R.id.btn_start -> {
            if (mSelectedOptionPostion ==0) {
                mcurrentPostion++


                when {
                    mcurrentPostion <= mQuestionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        Toast.makeText(
                            this, "You have " +
                                    "sucessfull Completed Quiz ", Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }else{
                val question = mQuestionList?.get(mcurrentPostion- 1)
                if (question!!.correctAnswer != mSelectedOptionPostion){
                    answerView(mSelectedOptionPostion,R.drawable.wrong_option_border_bg)
                }
                answerView(question.correctAnswer,
                R.drawable.correct_option_border_bg)

                if (mcurrentPostion == mQuestionList!!.size){

                    btn_submit.text = "Finish"
                }else{
                    btn_submit.text = "GO TO Next QUESTION"
                }
                mSelectedOptionPostion = 0
            }

            }
        }

    }
        private fun answerView(answer: Int, drawableView: Int){
            when(answer){
                1 ->{
                    option_one.background = ContextCompat.getDrawable(
                        this, drawableView
                    )

                }
                2 ->{
                    option_two.background = ContextCompat.getDrawable(
                        this,drawableView
                    )
                }
                3 ->{
                    option_three.background = ContextCompat.getDrawable(
                        this , drawableView
                    )
                }
                4 ->{
                    option_four.background = ContextCompat.getDrawable(
                        this, drawableView
                    )
                }
            }
        }

// use this fun in on click listner
    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum: Int) {

        defaultOptionsView()
        mSelectedOptionPostion = selectedOptionNum
       tv.setTextColor(Color.parseColor("#363A43"))
           tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)

    }
}