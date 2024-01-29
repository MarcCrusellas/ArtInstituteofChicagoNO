package com.example.artinstituteofchicagono.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artinstituteofchicagono.R
import com.example.artinstituteofchicagono.databinding.FragmentPersonalBinding


class PersonalFragment : Fragment() {

    lateinit var bind: FragmentPersonalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentPersonalBinding.inflate(layoutInflater)
        return bind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}