package com.kashsoft.quiz

object Constants {

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What Country flag is? ",
             R.drawable.pakistan,
            "pakistan",
            "india",
            "usa",
            "united Kingdom",
            1
        )
        questionList.add(que1)
        return questionList
    }
}