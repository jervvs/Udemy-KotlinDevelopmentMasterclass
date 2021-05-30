package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import org.w3c.dom.Text

// Implement OnClickListener to the class so can click any views in it like text views
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USERNAME)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }


    // When setting the question, there are 4 main things to do
    // 1. Reset all the text view backgrounds to default views
    // 2. Change the button back to 'SUBMIT'
    // 3. Change the question and the options
    // 4. Change the progress bar
    private fun setQuestion(){
        val question: Question? = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

        pbQuestionProgress.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition"+"/" + pbQuestionProgress.max

        // Using Question Class
        tvQuestion.text = question!!.question //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Question?
        ivImage.setImageResource(question.image)
        tvOptionOne.text=question.optionOne
        tvOptionTwo.text=question.optionTwo
        tvOptionThree.text=question.optionThree
        tvOptionFour.text=question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT // Can be bold.default, etc
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView() //Reset the view to the default option
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD) // Can be bold.default, etc
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    // On answering, pass the option int and set the view it should be
    private fun answerView(answer: Int, drawableView: Int){
        when (answer) {
            1-> {
                tvOptionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2-> {
                tvOptionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3-> {
                tvOptionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4-> {
                tvOptionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvOptionOne -> {
                selectedOptionsView(tvOptionOne, 1)
            }

            R.id.tvOptionTwo -> {
                selectedOptionsView(tvOptionTwo, 2)
            }

            R.id.tvOptionThree -> {
                selectedOptionsView(tvOptionThree, 3)
            }

            R.id.tvOptionFour -> {
                selectedOptionsView(tvOptionFour, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else{
                        mCorrectAnswers ++
                    }
                    answerView(question!!.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit.text = "FINISH"
                    } else{
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}