package com.example.laboratorio5viana.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.laboratorio5viana.R
import com.example.laboratorio5viana.databinding.FragmentBillboardBinding
import com.example.laboratorio5viana.databinding.FragmentCreateMovieBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding

    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var actionNavtoMovieFragment: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionNavToCreateMovie = view.findViewById(R.id.action_to_create_movie)
        actionNavtoMovieFragment = view.findViewById(R.id.movie_card)

        actionNavToCreateMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        }

        actionNavtoMovieFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }
    }
}