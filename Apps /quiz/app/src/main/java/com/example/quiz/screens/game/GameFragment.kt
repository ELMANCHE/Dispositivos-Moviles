package com.example.quiz.screens.game

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quiz.Constants
import com.example.quiz.Question
import com.example.quiz.R
import com.example.quiz.databinding.FragmentGameBinding
import kotlinx.coroutines.selects.select


class GameFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentGameBinding
    lateinit var mQuestionslist: ArrayList<Question>

    private  var mSelectedPosition: Int = 0
    private var mCorrectAnswer : Int = 0
    var mCurrrentPosition: Int = 1



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        mQuestionslist = Constants.getQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setQuestion()


        return  binding.root


    }

    private fun setQuestion() {

        var question: Question = mQuestionslist[mCurrrentPosition -1]

        binding.tvQuestion.text = question.question
        binding.imageView.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        binding.pb.progress = mCurrrentPosition
        binding.tvProgress.text = "$mCurrrentPosition" + "/" + binding.pb.max


        defauldAppearance()

        if (mCurrrentPosition == mQuestionslist.size){

            binding.btnSubmit.text = "Quiz Finished"

        } else {

            binding.btnSubmit.text = "Submit"
        }
    }

    private fun defauldAppearance() {

        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options){


            option.setTextColor(Color.parseColor("#7A8089"))
            //default appearance
            option.typeface = Typeface.DEFAULT
            option.background = context?.let { ContextCompat.getDrawable(it, R.drawable.default_option_fondopotaxie) }


        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_optionOne -> {

                selectedOptionView(binding.tvOptionOne, 1)

            }


            R.id.tv_optionTwo -> {

                selectedOptionView(binding.tvOptionTwo, 2)

            }

            R.id.tv_optionThree -> {

                selectedOptionView(binding.tvOptionThree, 3)
            }

            R.id.tv_optionFour -> {

                selectedOptionView(binding.tvOptionFour, 4)
            }

            R.id.btnSubmit -> {

                if(mSelectedPosition == 0){

                    mCurrrentPosition ++

                    when{
                        mCurrrentPosition <= mQuestionslist.size->{

                            setQuestion()
                        }else ->{
                            Toast.makeText(context, "FINALIZO GOGOOG", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionslist[mCurrrentPosition -1]
                    if(question!!.correctAnswer!=mSelectedPosition){

                        answerView(mSelectedPosition, R.drawable.wrong_option_potaxie)
                }   else {
                    mCorrectAnswer ++
                        answerView(question.correctAnswer,R.drawable.correct_border)

                        if (mCurrrentPosition == mQuestionslist.size){
                            binding.btnSubmit.text = " TERMINADO "
                        }else{
                            binding.btnSubmit.text = " SIGUIENTE GOGOGO"
                        }
                    }

                    mSelectedPosition = 0

                }


            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedPosion: Int) {

        mSelectedPosition = selectedPosion

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = context?.let { ContextCompat.getDrawable(it, R.drawable.selected_option_potaxie) }

        

    }

    private fun answerView(correctAnswer: Int, drawableView: Int) {

        when(mSelectedPosition){

            1->{

                binding.tvOptionOne.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }

            2->{

                binding.tvOptionTwo.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }

            3->{

                binding.tvOptionThree.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }

            4->{

                binding.tvOptionFour.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }
        }

    }

}