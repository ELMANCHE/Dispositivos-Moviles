package com.example.quiz.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quiz.R
import com.example.quiz.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)


        return  binding.root


    }


}