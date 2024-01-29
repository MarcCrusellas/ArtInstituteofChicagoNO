package com.example.artinstituteofchicagono.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artinstituteofchicagono.R
import com.example.artinstituteofchicagono.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    lateinit var bind: FragmentDetailBinding

    var selected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentDetailBinding.inflate(layoutInflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bind.like.apply {
            setOnClickListener {
                selected = !selected
                if (selected) {
                    background =
                        resources.getDrawable(R.drawable.sharp_favorite_24)

                } else {
                    background =
                        resources.getDrawable(R.drawable.sharp_favorite_border_24)


                }
            }
        }


        bind.goback.setOnClickListener {
            // super.onBackPressed()
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, MainFragment()).commit()
        }

    }


}